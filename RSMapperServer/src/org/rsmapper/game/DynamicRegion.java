package org.rsmapper.game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.rsmapper.cache.Cache;
import org.rsmapper.cache.loaders.ObjectDefinitions;
import org.rsmapper.networking.codec.stream.InputStream;
import org.rsmapper.utilities.game.cache.MapXTEA;

public class DynamicRegion extends Region {
   private int[][][][] regionCoords = new int[4][8][8][4];
   private boolean[][][] needsReload = new boolean[4][8][8];
   private boolean recheckReload;

   public DynamicRegion(int regionId) {
      super(regionId);

      for(int z = 0; z < 4; ++z) {
         for(int x = 0; x < 8; ++x) {
            for(int y = 0; y < 8; ++y) {
               this.needsReload[z][x][y] = true;
            }
         }
      }

      this.recheckReload = false;
   }

   public void checkLoadMap() {
      if (this.recheckReload) {
         this.setLoadMapStage(0);
         this.recheckReload = false;
      }

      super.checkLoadMap();
   }

   public void loadRegionMap() {
      int dynZ;
      int dynX;
      int dynY;
      for(dynZ = 0; dynZ < 4; ++dynZ) {
         for(dynX = 0; dynX < 8; ++dynX) {
            for(dynY = 0; dynY < 8; ++dynY) {
               if (this.needsReload[dynZ][dynX][dynY]) {
                  this.unloadChunk(dynX, dynY, dynZ);
               }
            }
         }
      }

      for(dynZ = 0; dynZ < 4; ++dynZ) {
         for(dynX = 0; dynX < 8; ++dynX) {
            for(dynY = 0; dynY < 8; ++dynY) {
               if (this.needsReload[dynZ][dynX][dynY]) {
                  this.needsReload[dynZ][dynX][dynY] = false;
                  int renderChunkX = this.regionCoords[dynZ][dynX][dynY][0];
                  int renderChunkY = this.regionCoords[dynZ][dynX][dynY][1];
                  int renderChunkZ = this.regionCoords[dynZ][dynX][dynY][2];
                  int rotation = this.regionCoords[dynZ][dynX][dynY][3];
                  int renderLocalChunkX = renderChunkX - (renderChunkX >> 3 << 3);
                  int renderLocalChunkY = renderChunkY - (renderChunkY >> 3 << 3);
                  if (renderChunkX != 0 || renderChunkY != 0 || renderChunkZ != 0 || rotation != 0) {
                     int mapID = renderChunkX >> 3 << 8 | renderChunkY >> 3;
                     int landArchiveId = Cache.STORE.getIndexes()[5].getArchiveId("l" + (mapID >> 8) + "_" + (mapID & 255));
                     int mapArchiveId = Cache.STORE.getIndexes()[5].getArchiveId("m" + (mapID >> 8) + "_" + (mapID & 255));
                     byte[] mapContainerData = mapArchiveId == -1 ? null : Cache.STORE.getIndexes()[5].getFile(mapArchiveId, 0);
                     byte[] landContainerData = landArchiveId == -1 ? null : Cache.STORE.getIndexes()[5].getFile(landArchiveId, 0, MapXTEA.getKey(mapID));
                     byte[][][] mapSettings = mapContainerData == null ? null : new byte[4][64][64];
                     InputStream mapStream;
                     int plane;
                     int x;
                     int y;
                     int value;
                     if (mapContainerData != null) {
                        mapStream = new InputStream(mapContainerData);

                        for(plane = 0; plane < 4; ++plane) {
                           for(x = 0; x < 64; ++x) {
                              for(y = 0; y < 64; ++y) {
                                 while(true) {
                                    value = mapStream.readUnsignedByte();
                                    if (value == 0) {
                                       break;
                                    }

                                    if (value == 1) {
                                       mapStream.readByte();
                                       break;
                                    }

                                    if (value <= 49) {
                                       mapStream.readByte();
                                    } else if (value <= 81) {
                                       mapSettings[plane][x][y] = (byte)(value - 49);
                                    }
                                 }
                              }
                           }
                        }

                        for(plane = 0; plane < 4; ++plane) {
                           for(x = 0; x < 64; ++x) {
                              for(y = 0; y < 64; ++y) {
                                 if ((mapSettings[plane][x][y] & 1) == 1) {
                                    value = plane;
                                    if ((mapSettings[1][x][y] & 2) == 2) {
                                       value = plane - 1;
                                    }

                                    if (value == renderChunkZ && x >> 3 == renderLocalChunkX && y >> 3 == renderLocalChunkY) {
                                       int[] coords = translate(x & 7, y & 7, rotation);
                                       this.forceGetRegionMap().addUnwalkable(dynZ, dynX << 3 | coords[0], dynY << 3 | coords[1]);
                                    }
                                 }
                              }
                           }
                        }
                     } else {
                        for(int z = 0; z < 4; ++z) {
                           for(plane = 0; plane < 64; ++plane) {
                              for(x = 0; x < 64; ++x) {
                                 if (z == renderChunkZ && plane >> 3 == renderLocalChunkX && x >> 3 == renderLocalChunkY) {
                                    int[] coords = translate(plane & 7, x & 7, rotation);
                                    this.forceGetRegionMap().addUnwalkable(dynZ, dynX << 3 | coords[0], dynY << 3 | coords[1]);
                                 }
                              }
                           }
                        }
                     }

                     if (landContainerData != null) {
                        mapStream = new InputStream(landContainerData);
                        plane = -1;

                        while((x = mapStream.readSmart2()) != 0) {
                           plane += x;
                           y = 0;

                           while((value = mapStream.readUnsignedSmart()) != 0) {
                              y += value - 1;
                              int x = y >> 6 & 63;
                              int y = y & 63;
                              int z = y >> 12;
                              int objectData = mapStream.readUnsignedByte();
                              int type = objectData >> 2;
                              int rot = objectData & 3;
                              int realZ = z;
                              if (mapSettings != null && (mapSettings[1][x][y] & 2) == 2) {
                                 realZ = z - 1;
                              }

                              if (realZ == renderChunkZ && x >> 3 == renderLocalChunkX && y >> 3 == renderLocalChunkY) {
                                 ObjectDefinitions definition = ObjectDefinitions.getObjectDefinitions(plane);
                                 int[] coords = translate(x & 7, y & 7, rotation, definition.sizeX, definition.sizeY, rot);
                                 this.spawnObject(new WorldObject(plane, type, rotation + rot & 3, (dynX << 3) + coords[0] + (this.getRegionId() >> 8 << 6), (dynY << 3) + coords[1] + ((this.getRegionId() & 255) << 6), dynZ), dynZ, (dynX << 3) + coords[0], (dynY << 3) + coords[1], true);
                              }
                           }
                        }
                     }

                     if (landContainerData == null && landArchiveId != -1 && MapXTEA.getKey(mapID) != null) {
                        System.err.println("Missing xteas for region " + mapID + ".");
                     }
                  }
               }
            }
         }
      }

   }

   private void unloadChunk(int chunkX, int chunkY, int chunkZ) {
      for(int x = 0; x < 8; ++x) {
         for(int y = 0; y < 8; ++y) {
            int fullX = chunkX << 3 | x;
            int fullY = chunkY << 3 | y;
            if (this.objects != null) {
               for(int slot = 0; slot < 4; ++slot) {
                  this.objects[chunkZ][fullX][fullY][slot] = null;
               }
            }

            if (this.map != null) {
               this.map.setMask(chunkZ, fullX, fullY, 0);
            }

            if (this.clipedOnlyMap != null) {
               this.clipedOnlyMap.setMask(chunkZ, fullX, fullY, 0);
            }

            List<WorldObject> ro = new ArrayList(this.removedObjects);
            Iterator var10 = ro.iterator();

            while(var10.hasNext()) {
               WorldObject removed = (WorldObject)var10.next();
               if (removed.getPlane() == chunkZ && removed.getChunkX() == chunkX && removed.getChunkY() == chunkY) {
                  this.removedObjects.remove(removed);
               }
            }
         }
      }

   }

   public static int[] translate(int x, int y, int rotation) {
      int[] coords = new int[2];
      if (rotation == 0) {
         coords[0] = x;
         coords[1] = y;
      } else if (rotation == 1) {
         coords[0] = y;
         coords[1] = 7 - x;
      } else if (rotation == 2) {
         coords[0] = 7 - x;
         coords[1] = 7 - y;
      } else {
         coords[0] = 7 - y;
         coords[1] = x;
      }

      return coords;
   }

   public static int[] translate(int x, int y, int mapRotation, int sizeX, int sizeY, int objectRotation) {
      int[] coords = new int[2];
      if ((objectRotation & 1) == 1) {
         int prevSizeX = sizeX;
         sizeX = sizeY;
         sizeY = prevSizeX;
      }

      if (mapRotation == 0) {
         coords[0] = x;
         coords[1] = y;
      } else if (mapRotation == 1) {
         coords[0] = y;
         coords[1] = 7 - x - (sizeX - 1);
      } else if (mapRotation == 2) {
         coords[0] = 7 - x - (sizeX - 1);
         coords[1] = 7 - y - (sizeY - 1);
      } else if (mapRotation == 3) {
         coords[0] = 7 - y - (sizeY - 1);
         coords[1] = x;
      }

      return coords;
   }

   public int getRotation(int plane, int x, int y) {
      return this.regionCoords[plane][x][y][3];
   }

   public void setRotation(int plane, int x, int y, int rotation) {
      this.regionCoords[plane][x][y][3] = rotation;
      this.setReloadObjects(plane, x, y);
   }

   public void setReloadObjects(int plane, int x, int y) {
      this.needsReload[plane][x][y] = true;
      this.recheckReload = true;
   }

   public int[][][][] getRegionCoords() {
      return this.regionCoords;
   }
}
