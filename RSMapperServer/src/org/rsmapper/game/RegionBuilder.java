package org.rsmapper.game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.rsmapper.cache.Cache;
import org.rsmapper.game.npc.NPC;
import org.rsmapper.game.player.Player;

public final class RegionBuilder {
   public static final int[] FORCE_LOAD_REGIONS = new int[]{7503, 7759};
   public static final int NORTH = 0;
   public static final int EAST = 1;
   public static final int SOUTH = 2;
   public static final int WEST = 3;
   private static final Object ALGORITHM_LOCK = new Object();
   private static final List<Integer> EXISTING_MAPS = new ArrayList();
   private static final int MAX_REGION_X = 127;
   private static final int MAX_REGION_Y = 255;

   public static void init() {
      int mapX;
      int mapY;
      for(mapX = 0; mapX < 127; ++mapX) {
         for(mapY = 0; mapY < 255; ++mapY) {
            if (Cache.STORE.getIndexes()[5].getArchiveId("m" + mapX + "_" + mapY) != -1) {
               EXISTING_MAPS.add(RegionUtils.encode(RegionUtils.Structure.REGION, mapX, mapY, 0));
            }
         }
      }

      int[] var3;
      int var2 = (var3 = FORCE_LOAD_REGIONS).length;

      for(mapY = 0; mapY < var2; ++mapY) {
         mapX = var3[mapY];
         World.getRegion(mapX, true);
      }

   }

   public static int[] findEmptyRegionBound(int widthChunks, int heightChunks) {
      int regionHash = findEmptyRegionHash(widthChunks, heightChunks);
      return new int[]{regionHash >> 8, regionHash & 255};
   }

   public static int[] findEmptyChunkBound(int widthChunks, int heightChunks) {
      int[] map = findEmptyRegionBound(widthChunks, heightChunks);
      map[0] *= 8;
      map[1] *= 8;
      return map;
   }

   public static int getRegionId(int mapX, int mapY) {
      return (mapX << 8) + mapY;
   }

   public static int findEmptyRegionHash(int widthChunks, int heightChunks) {
      int regionsDistanceX;
      for(regionsDistanceX = 1; widthChunks > 8; widthChunks -= 8) {
         ++regionsDistanceX;
      }

      int regionsDistanceY;
      for(regionsDistanceY = 1; heightChunks > 8; heightChunks -= 8) {
         ++regionsDistanceY;
      }

      synchronized(ALGORITHM_LOCK) {
         for(int regionX = 1; regionX <= 127 - regionsDistanceX; ++regionX) {
            label54:
            for(int regionY = 1; regionY <= 255 - regionsDistanceY; ++regionY) {
               int regionHash = getRegionId(regionX, regionY);

               for(int checkRegionX = regionX - 1; checkRegionX <= regionX + regionsDistanceX; ++checkRegionX) {
                  for(int checkRegionY = regionY - 1; checkRegionY <= regionY + regionsDistanceY; ++checkRegionY) {
                     int hash = getRegionId(checkRegionX, checkRegionY);
                     if (regionExists(hash)) {
                        continue label54;
                     }
                  }
               }

               reserveArea(regionX, regionY, regionsDistanceX, regionsDistanceY, false);
               return regionHash;
            }
         }

         return -1;
      }
   }

   public static void reserveArea(int fromRegionX, int fromRegionY, int width, int height, boolean remove) {
      for(int regionX = fromRegionX; regionX < fromRegionX + width; ++regionX) {
         for(int regionY = fromRegionY; regionY < fromRegionY + height; ++regionY) {
            if (remove) {
               EXISTING_MAPS.remove(getRegionId(regionX, regionY));
            } else {
               EXISTING_MAPS.add(getRegionId(regionX, regionY));
            }
         }
      }

   }

   public static boolean regionExists(int mapHash) {
      return EXISTING_MAPS.contains(mapHash);
   }

   public static void cutChunk(int chunkX, int chunkY, int plane) {
      DynamicRegion toRegion = createDynamicRegion((chunkX / 8 << 8) + chunkY / 8);
      int offsetX = chunkX - chunkX / 8 * 8;
      int offsetY = chunkY - chunkY / 8 * 8;
      toRegion.getRegionCoords()[plane][offsetX][offsetY][0] = 0;
      toRegion.getRegionCoords()[plane][offsetX][offsetY][1] = 0;
      toRegion.getRegionCoords()[plane][offsetX][offsetY][2] = 0;
      toRegion.getRegionCoords()[plane][offsetX][offsetY][3] = 0;
      toRegion.setReloadObjects(plane, offsetX, offsetY);
   }

   public static final void destroyMap(int chunkX, int chunkY, int widthRegions, int heightRegions) {
      synchronized(ALGORITHM_LOCK) {
         int fromRegionX = chunkX / 8;
         int fromRegionY = chunkY / 8;

         int regionsDistanceX;
         for(regionsDistanceX = 1; widthRegions > 8; widthRegions -= 8) {
            ++regionsDistanceX;
         }

         int regionsDistanceY;
         for(regionsDistanceY = 1; heightRegions > 8; heightRegions -= 8) {
            ++regionsDistanceY;
         }

         for(int regionX = fromRegionX; regionX < fromRegionX + regionsDistanceX; ++regionX) {
            for(int regionY = fromRegionY; regionY < fromRegionY + regionsDistanceY; ++regionY) {
               destroyRegion(getRegionId(regionX, regionY));
            }
         }

         reserveArea(fromRegionX, fromRegionY, regionsDistanceX, regionsDistanceY, true);
      }
   }

   public static final void repeatMap(int toChunkX, int toChunkY, int widthChunks, int heightChunks, int rx, int ry, int plane, int rotation, int... toPlanes) {
      for(int xOffset = 0; xOffset < widthChunks; ++xOffset) {
         for(int yOffset = 0; yOffset < heightChunks; ++yOffset) {
            int nextChunkX = toChunkX + xOffset;
            int nextChunkY = toChunkY + yOffset;
            DynamicRegion toRegion = createDynamicRegion((nextChunkX / 8 << 8) + nextChunkY / 8);
            int regionOffsetX = nextChunkX - nextChunkX / 8 * 8;
            int regionOffsetY = nextChunkY - nextChunkY / 8 * 8;

            for(int pIndex = 0; pIndex < toPlanes.length; ++pIndex) {
               int toPlane = toPlanes[pIndex];
               toRegion.getRegionCoords()[toPlane][regionOffsetX][regionOffsetY][0] = rx;
               toRegion.getRegionCoords()[toPlane][regionOffsetX][regionOffsetY][1] = ry;
               toRegion.getRegionCoords()[toPlane][regionOffsetX][regionOffsetY][2] = plane;
               toRegion.getRegionCoords()[toPlane][regionOffsetX][regionOffsetY][3] = rotation;
               toRegion.setReloadObjects(toPlane, regionOffsetX, regionOffsetY);
            }
         }
      }

   }

   public static final void cutMap(int toChunkX, int toChunkY, int widthChunks, int heightChunks, int... toPlanes) {
      for(int xOffset = 0; xOffset < widthChunks; ++xOffset) {
         for(int yOffset = 0; yOffset < heightChunks; ++yOffset) {
            int nextChunkX = toChunkX + xOffset;
            int nextChunkY = toChunkY + yOffset;
            DynamicRegion toRegion = createDynamicRegion((nextChunkX / 8 << 8) + nextChunkY / 8);
            int regionOffsetX = nextChunkX - nextChunkX / 8 * 8;
            int regionOffsetY = nextChunkY - nextChunkY / 8 * 8;

            for(int pIndex = 0; pIndex < toPlanes.length; ++pIndex) {
               int toPlane = toPlanes[pIndex];
               toRegion.getRegionCoords()[toPlane][regionOffsetX][regionOffsetY][0] = 0;
               toRegion.getRegionCoords()[toPlane][regionOffsetX][regionOffsetY][1] = 0;
               toRegion.getRegionCoords()[toPlane][regionOffsetX][regionOffsetY][2] = 0;
               toRegion.getRegionCoords()[toPlane][regionOffsetX][regionOffsetY][3] = 0;
               toRegion.setReloadObjects(toPlane, regionOffsetX, regionOffsetY);
            }
         }
      }

   }

   public static void copyChunk(int fromChunkX, int fromChunkY, int fromPlane, int toChunkX, int toChunkY, int toPlane, int rotation) {
      DynamicRegion toRegion = createDynamicRegion((toChunkX / 8 << 8) + toChunkY / 8);
      int regionOffsetX = toChunkX - toChunkX / 8 * 8;
      int regionOffsetY = toChunkY - toChunkY / 8 * 8;
      toRegion.getRegionCoords()[toPlane][regionOffsetX][regionOffsetY][0] = fromChunkX;
      toRegion.getRegionCoords()[toPlane][regionOffsetX][regionOffsetY][1] = fromChunkY;
      toRegion.getRegionCoords()[toPlane][regionOffsetX][regionOffsetY][2] = fromPlane;
      toRegion.getRegionCoords()[toPlane][regionOffsetX][regionOffsetY][3] = rotation;
      toRegion.setReloadObjects(toPlane, regionOffsetX, regionOffsetY);
   }

   public static final void copyAllPlanesMap(int fromRegionX, int fromRegionY, int toRegionX, int toRegionY, int ratio) {
      int[] planes = new int[4];

      for(int plane = 1; plane < 4; planes[plane] = plane++) {
      }

      copyMap(fromRegionX, fromRegionY, toRegionX, toRegionY, ratio, ratio, planes, planes);
   }

   public static final void copyAllPlanesMap(int fromRegionX, int fromRegionY, int toRegionX, int toRegionY, int widthRegions, int heightRegions) {
      int[] planes = new int[4];

      for(int plane = 1; plane < 4; planes[plane] = plane++) {
      }

      copyMap(fromRegionX, fromRegionY, toRegionX, toRegionY, widthRegions, heightRegions, planes, planes);
   }

   public static final void copyMap(int fromRegionX, int fromRegionY, int toRegionX, int toRegionY, int ratio, int[] fromPlanes, int[] toPlanes) {
      copyMap(fromRegionX, fromRegionY, toRegionX, toRegionY, ratio, ratio, fromPlanes, toPlanes);
   }

   public static final void copyMap(int fromRegionX, int fromRegionY, int toRegionX, int toRegionY, int widthRegions, int heightRegions, int[] fromPlanes, int[] toPlanes) {
      if (fromPlanes.length != toPlanes.length) {
         throw new RuntimeException("PLANES LENGTH ISNT SAME OF THE NEW PLANES ORDER!");
      } else {
         for(int xOffset = 0; xOffset < widthRegions; ++xOffset) {
            for(int yOffset = 0; yOffset < heightRegions; ++yOffset) {
               int fromThisRegionX = fromRegionX + xOffset;
               int fromThisRegionY = fromRegionY + yOffset;
               int toThisRegionX = toRegionX + xOffset;
               int toThisRegionY = toRegionY + yOffset;
               int regionId = (toThisRegionX / 8 << 8) + toThisRegionY / 8;
               DynamicRegion toRegion = createDynamicRegion(regionId);
               int regionOffsetX = toThisRegionX - toThisRegionX / 8 * 8;
               int regionOffsetY = toThisRegionY - toThisRegionY / 8 * 8;

               for(int pIndex = 0; pIndex < fromPlanes.length; ++pIndex) {
                  int toPlane = toPlanes[pIndex];
                  toRegion.getRegionCoords()[toPlane][regionOffsetX][regionOffsetY][0] = fromThisRegionX;
                  toRegion.getRegionCoords()[toPlane][regionOffsetX][regionOffsetY][1] = fromThisRegionY;
                  toRegion.getRegionCoords()[toPlane][regionOffsetX][regionOffsetY][2] = fromPlanes[pIndex];
                  toRegion.setReloadObjects(toPlane, regionOffsetX, regionOffsetY);
               }
            }
         }

      }
   }

   public static final void copy2RatioSquare(int fromRegionX, int fromRegionY, int toRegionX, int toRegionY, int rotation) {
      if (rotation == 0) {
         copyChunk(fromRegionX, fromRegionY, 0, toRegionX, toRegionY, 0, rotation);
         copyChunk(fromRegionX + 1, fromRegionY, 0, toRegionX + 1, toRegionY, 0, rotation);
         copyChunk(fromRegionX, fromRegionY + 1, 0, toRegionX, toRegionY + 1, 0, rotation);
         copyChunk(fromRegionX + 1, fromRegionY + 1, 0, toRegionX + 1, toRegionY + 1, 0, rotation);
      } else if (rotation == 1) {
         copyChunk(fromRegionX, fromRegionY, 0, toRegionX, toRegionY + 1, 0, rotation);
         copyChunk(fromRegionX + 1, fromRegionY, 0, toRegionX, toRegionY, 0, rotation);
         copyChunk(fromRegionX, fromRegionY + 1, 0, toRegionX + 1, toRegionY + 1, 0, rotation);
         copyChunk(fromRegionX + 1, fromRegionY + 1, 0, toRegionX + 1, toRegionY, 0, rotation);
      } else if (rotation == 2) {
         copyChunk(fromRegionX, fromRegionY, 0, toRegionX + 1, toRegionY + 1, 0, rotation);
         copyChunk(fromRegionX + 1, fromRegionY, 0, toRegionX, toRegionY + 1, 0, rotation);
         copyChunk(fromRegionX, fromRegionY + 1, 0, toRegionX + 1, toRegionY, 0, rotation);
         copyChunk(fromRegionX + 1, fromRegionY + 1, 0, toRegionX, toRegionY, 0, rotation);
      } else if (rotation == 3) {
         copyChunk(fromRegionX, fromRegionY, 0, toRegionX + 1, toRegionY, 0, rotation);
         copyChunk(fromRegionX + 1, fromRegionY, 0, toRegionX + 1, toRegionY + 1, 0, rotation);
         copyChunk(fromRegionX, fromRegionY + 1, 0, toRegionX, toRegionY, 0, rotation);
         copyChunk(fromRegionX + 1, fromRegionY + 1, 0, toRegionX, toRegionY + 1, 0, rotation);
      }

   }

   public static DynamicRegion createDynamicRegion(int regionId) {
      synchronized(ALGORITHM_LOCK) {
         Region region = (Region)World.getRegions().get(regionId);
         if (region != null) {
            if (region instanceof DynamicRegion) {
               return (DynamicRegion)region;
            }

            destroyRegion(regionId);
         }

         DynamicRegion newRegion = new DynamicRegion(regionId);
         World.getRegions().put(regionId, newRegion);
         return newRegion;
      }
   }

   public static void destroyRegion(int regionId) {
      Region region = (Region)World.getRegions().get(regionId);
      if (region != null) {
         List<Integer> playerIndexes = region.getPlayerIndexes();
         List<Integer> npcIndexes = region.getNPCsIndexes();
         if (region.getFloorItems() != null) {
            region.getFloorItems().clear();
         }

         region.getSpawnedObjects().clear();
         region.getRemovedObjects().clear();
         int playerIndex;
         Iterator var5;
         if (npcIndexes != null) {
            var5 = npcIndexes.iterator();

            while(var5.hasNext()) {
               playerIndex = (Integer)var5.next();
               NPC npc = (NPC)World.getNPCs().get(playerIndex);
               if (npc != null) {
                  npc.finish();
               }
            }
         }

         World.getRegions().remove(regionId);
         if (playerIndexes != null) {
            var5 = playerIndexes.iterator();

            while(var5.hasNext()) {
               playerIndex = (Integer)var5.next();
               Player player = (Player)World.getPlayers().get(playerIndex);
               if (player != null && player.hasStarted() && !player.hasFinished()) {
                  player.setForceNextMapLoadRefresh(true);
                  player.loadMapRegions();
               }
            }
         }
      }

   }

   private RegionBuilder() {
   }
}
