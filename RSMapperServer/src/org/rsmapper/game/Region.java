package org.rsmapper.game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.rsmapper.Constants;
import org.rsmapper.cache.Cache;
import org.rsmapper.cache.loaders.ClientScriptMap;
import org.rsmapper.cache.loaders.ObjectDefinitions;
import org.rsmapper.engine.CoresManager;
import org.rsmapper.game.item.FloorItem;
import org.rsmapper.game.player.Player;
import org.rsmapper.networking.codec.stream.InputStream;
import org.rsmapper.utilities.game.cache.MapXTEA;
import org.rsmapper.utilities.misc.Utils;

public class Region {
   public static final int[] OBJECT_SLOTS = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
   public static final int OBJECT_SLOT_WALL = 0;
   public static final int OBJECT_SLOT_WALL_DECORATION = 1;
   public static final int OBJECT_SLOT_FLOOR = 2;
   public static final int OBJECT_SLOT_FLOOR_DECORATION = 3;
   protected int regionId;
   protected RegionMap map;
   protected RegionMap clipedOnlyMap;
   protected List<Integer> playersIndexes;
   protected List<Integer> npcsIndexes;
   protected List<WorldObject> spawnedObjects;
   protected List<WorldObject> removedObjects;
   private List<FloorItem> floorItems;
   protected WorldObject[][][][] objects;
   private volatile int loadMapStage;
   private boolean loadedNPCSpawns;
   private boolean loadedObjectSpawns;
   private boolean loadedItemSpawns;
   private int[] musicIds;

   public Region(int regionId) {
      this.regionId = regionId;
      this.spawnedObjects = new CopyOnWriteArrayList();
      this.removedObjects = new CopyOnWriteArrayList();
      this.loadMusicIds();
   }

   public void checkLoadMap() {
      if (this.getLoadMapStage() == 0) {
         this.setLoadMapStage(1);
         CoresManager.slowExecutor.execute(new Runnable() {
            public void run() {
               try {
                  Region.this.loadRegionMap();
                  Region.ForceClipping[] var4;
                  int var3 = (var4 = Region.ForceClipping.values()).length;

                  for(int var2 = 0; var2 < var3; ++var2) {
                     Region.ForceClipping regions = var4[var2];
                     if (Region.this.regionId == regions.regionId) {
                        WorldTile[] var8;
                        int var7 = (var8 = regions.tiles).length;

                        for(int var6 = 0; var6 < var7; ++var6) {
                           WorldTile tile = var8[var6];
                           Region.this.clip(tile.getPlane(), tile.getX(), tile.getY());
                        }
                     }
                  }

                  Region.this.setLoadMapStage(2);
               } catch (Throwable var9) {
                  var9.printStackTrace();
               }

            }
         });
      }

   }

   public void addObject(WorldObject object) {
      if (this.spawnedObjects == null) {
         this.spawnedObjects = new CopyOnWriteArrayList();
      }

      this.spawnedObjects.add(object);
   }

   public void addRemovedObject(WorldObject object) {
      if (this.removedObjects == null) {
         this.removedObjects = new CopyOnWriteArrayList();
      }

      this.removedObjects.add(object);
   }

   public WorldObject getObject(int plane, int x, int y) {
      WorldObject[] objects = this.getObjects(plane, x, y);
      return objects == null ? null : objects[0];
   }

   public void removeMapFromMemory() {
      if (this.getLoadMapStage() == 2 && (this.playersIndexes == null || this.playersIndexes.isEmpty()) && (this.npcsIndexes == null || this.npcsIndexes.isEmpty())) {
         this.objects = null;
         this.map = null;
         this.setLoadMapStage(0);
      }

   }

   public RegionMap forceGetRegionMapClipedOnly() {
      if (this.clipedOnlyMap == null) {
         this.clipedOnlyMap = new RegionMap(this.regionId, true);
      }

      return this.clipedOnlyMap;
   }

   public RegionMap forceGetRegionMap() {
      if (this.map == null) {
         this.map = new RegionMap(this.regionId, false);
      }

      return this.map;
   }

   public RegionMap getRegionMap() {
      return this.map;
   }

   public int getMask(int plane, int localX, int localY) {
      return this.map != null && this.getLoadMapStage() == 2 ? this.map.getMasks()[plane][localX][localY] : -1;
   }

   public int getMaskClipedOnly(int plane, int localX, int localY) {
      return this.clipedOnlyMap != null && this.getLoadMapStage() == 2 ? this.clipedOnlyMap.getMasks()[plane][localX][localY] : -1;
   }

   public void setMask(int plane, int localX, int localY, int mask) {
      if (this.map != null && this.getLoadMapStage() == 2) {
         if (localX < 64 && localY < 64 && localX >= 0 && localY >= 0) {
            this.map.setMask(plane, localX, localY, mask);
         } else {
            WorldTile tile = new WorldTile(this.map.getRegionX() + localX, this.map.getRegionY() + localY, plane);
            int regionId = tile.getRegionId();
            int newRegionX = (regionId >> 8) * 64;
            int newRegionY = (regionId & 255) * 64;
            World.getRegion(tile.getRegionId()).setMask(plane, tile.getX() - newRegionX, tile.getY() - newRegionY, mask);
         }
      }
   }

   public void clip(WorldObject object, int x, int y) {
      if (this.map == null) {
         this.map = new RegionMap(this.regionId, false);
      }

      if (this.clipedOnlyMap == null) {
         this.clipedOnlyMap = new RegionMap(this.regionId, true);
      }

      int plane = object.getPlane();
      int type = object.getType();
      int rotation = object.getRotation();
      if (x >= 0 && y >= 0 && x < this.map.getMasks()[plane].length && y < this.map.getMasks()[plane][x].length) {
         ObjectDefinitions objectDefinition;
         label51: {
            objectDefinition = ObjectDefinitions.getObjectDefinitions(object.getId());
            if (type == 22) {
               if (objectDefinition.getClipType() == 0) {
                  break label51;
               }
            } else if (objectDefinition.getClipType() != 0) {
               break label51;
            }

            return;
         }

         if (type >= 0 && type <= 3) {
            this.map.addWall(plane, x, y, type, rotation, objectDefinition.isProjectileCliped(), true);
            if (objectDefinition.isProjectileCliped()) {
               this.clipedOnlyMap.addWall(plane, x, y, type, rotation, objectDefinition.isProjectileCliped(), true);
            }
         } else if (type >= 9 && type <= 21) {
            int sizeX;
            int sizeY;
            if (rotation != 1 && rotation != 3) {
               sizeX = objectDefinition.getSizeX();
               sizeY = objectDefinition.getSizeY();
            } else {
               sizeX = objectDefinition.getSizeY();
               sizeY = objectDefinition.getSizeX();
            }

            this.map.addObject(plane, x, y, sizeX, sizeY, objectDefinition.isProjectileCliped(), true);
            if (objectDefinition.isProjectileCliped()) {
               this.clipedOnlyMap.addObject(plane, x, y, sizeX, sizeY, objectDefinition.isProjectileCliped(), true);
            }
         }

      }
   }

   public void clip(int plane, int x, int y) {
      x &= 63;
      y &= 63;
      if (this.map == null) {
         this.map = new RegionMap(this.regionId, false);
      }

      if (this.clipedOnlyMap == null) {
         this.clipedOnlyMap = new RegionMap(this.regionId, true);
      }

      this.map.addUnwalkable(plane, x, y);
   }

   public void unclip(int plane, int x, int y) {
      if (this.map == null) {
         this.map = new RegionMap(this.regionId, false);
      }

      if (this.clipedOnlyMap == null) {
         this.clipedOnlyMap = new RegionMap(this.regionId, true);
      }

      this.map.setMask(plane, x, y, 0);
   }

   public void unclip(WorldObject object, int x, int y) {
      if (this.map == null) {
         this.map = new RegionMap(this.regionId, false);
      }

      if (this.clipedOnlyMap == null) {
         this.clipedOnlyMap = new RegionMap(this.regionId, true);
      }

      int plane = object.getPlane();
      int type = object.getType();
      int rotation = object.getRotation();
      if (x >= 0 && y >= 0 && x < this.map.getMasks()[plane].length && y < this.map.getMasks()[plane][x].length) {
         ObjectDefinitions objectDefinition;
         label51: {
            objectDefinition = ObjectDefinitions.getObjectDefinitions(object.getId());
            if (type == 22) {
               if (objectDefinition.getClipType() == 0) {
                  break label51;
               }
            } else if (objectDefinition.getClipType() != 0) {
               break label51;
            }

            return;
         }

         if (type >= 0 && type <= 3) {
            this.map.removeWall(plane, x, y, type, rotation, objectDefinition.isProjectileCliped(), true);
            if (objectDefinition.isProjectileCliped()) {
               this.clipedOnlyMap.removeWall(plane, x, y, type, rotation, objectDefinition.isProjectileCliped(), true);
            }
         } else if (type >= 9 && type <= 21) {
            int sizeX;
            int sizeY;
            if (rotation != 1 && rotation != 3) {
               sizeX = objectDefinition.getSizeX();
               sizeY = objectDefinition.getSizeY();
            } else {
               sizeX = objectDefinition.getSizeY();
               sizeY = objectDefinition.getSizeX();
            }

            this.map.removeObject(plane, x, y, sizeX, sizeY, objectDefinition.isProjectileCliped(), true);
            if (objectDefinition.isProjectileCliped()) {
               this.clipedOnlyMap.removeObject(plane, x, y, sizeX, sizeY, objectDefinition.isProjectileCliped(), true);
            }
         }

      }
   }

   public void spawnObject(WorldObject object, int plane, int localX, int localY, boolean original) {
      if (this.objects == null) {
         this.objects = new WorldObject[4][64][64][4];
      }

      int slot = OBJECT_SLOTS[object.getType()];
      if (original) {
         this.objects[plane][localX][localY][slot] = object;
         this.clip(object, localX, localY);
      } else {
         WorldObject spawned = this.getSpawnedObjectWithSlot(plane, localX, localY, slot);
         if (spawned != null) {
            this.spawnedObjects.remove(spawned);
            this.unclip(spawned, localX, localY);
         }

         WorldObject removed = this.getRemovedObjectWithSlot(plane, localX, localY, slot);
         if (removed != null) {
            object = removed;
            this.removedObjects.remove(removed);
         } else if (this.objects[plane][localX][localY][slot] != object) {
            this.spawnedObjects.add(object);
            if (this.objects[plane][localX][localY][slot] != null) {
               this.unclip(this.objects[plane][localX][localY][slot], localX, localY);
            }
         } else if (spawned == null) {
            if (Constants.DEBUG) {
               System.out.println("Requested object to spawn is already spawned.(Shouldnt happen)");
            }

            return;
         }

         if (object.getId() != -1) {
            this.clip(object, localX, localY);
         }

         Iterator var10 = World.getPlayers().iterator();

         while(var10.hasNext()) {
            Player p2 = (Player)var10.next();
            if (p2 != null && p2.hasStarted() && !p2.hasFinished() && p2.getMapRegionsIds().contains(this.regionId)) {
               p2.getPackets().sendSpawnedObject(object);
            }
         }
      }

   }

   public void removeObject(WorldObject object, int plane, int localX, int localY) {
      if (this.objects == null) {
         this.objects = new WorldObject[4][64][64][4];
      }

      int slot = OBJECT_SLOTS[object.getType()];
      WorldObject removed = this.getRemovedObjectWithSlot(plane, localX, localY, slot);
      if (removed != null) {
         this.removedObjects.remove(object);
         this.clip(removed, localX, localY);
      }

      WorldObject original = null;
      WorldObject spawned = this.getSpawnedObjectWithSlot(plane, localX, localY, slot);
      if (spawned != null) {
         object = spawned;
         this.spawnedObjects.remove(spawned);
         this.unclip(spawned, localX, localY);
         if (this.objects[plane][localX][localY][slot] != null) {
            this.clip(this.objects[plane][localX][localY][slot], localX, localY);
            original = this.objects[plane][localX][localY][slot];
         }
      } else {
         if (this.objects[plane][localX][localY][slot] != object) {
            if (Constants.DEBUG) {
               System.out.println("Requested object to remove wasnt found.(Shouldnt happen)");
            }

            return;
         }

         this.unclip(object, localX, localY);
         this.removedObjects.add(object);
      }

      this.spawnedObjects.remove(object);
      Iterator var10 = World.getPlayers().iterator();

      while(var10.hasNext()) {
         Player p2 = (Player)var10.next();
         if (p2 != null && p2.hasStarted() && !p2.hasFinished() && p2.getMapRegionsIds().contains(this.regionId)) {
            if (original != null) {
               p2.getPackets().sendSpawnedObject(original);
            } else {
               p2.getPackets().sendDestroyObject(object);
            }
         }
      }

   }

   public WorldObject getStandardObject(int plane, int x, int y) {
      return this.getObjectWithSlot(plane, x, y, 2);
   }

   public WorldObject getObjectWithType(int plane, int x, int y, int type) {
      WorldObject object = this.getObjectWithSlot(plane, x, y, OBJECT_SLOTS[type]);
      return object != null && object.getType() == type ? object : null;
   }

   public WorldObject getObjectWithSlot(int plane, int x, int y, int slot) {
      if (this.objects == null) {
         return null;
      } else {
         WorldObject o = this.getSpawnedObjectWithSlot(plane, x, y, slot);
         if (o == null) {
            return this.getRemovedObjectWithSlot(plane, x, y, slot) != null ? null : this.objects[plane][x][y][slot];
         } else {
            return o;
         }
      }
   }

   public WorldObject getSpawnedObjectWithSlot(int plane, int x, int y, int slot) {
      Iterator var6 = this.spawnedObjects.iterator();

      WorldObject object;
      do {
         if (!var6.hasNext()) {
            return null;
         }

         object = (WorldObject)var6.next();
      } while(object.getXInRegion() != x || object.getYInRegion() != y || object.getPlane() != plane || OBJECT_SLOTS[object.getType()] != slot);

      return object;
   }

   public WorldObject getRemovedObject(WorldTile tile) {
      if (this.removedObjects == null) {
         return null;
      } else {
         Iterator var3 = this.removedObjects.iterator();

         WorldObject object;
         do {
            if (!var3.hasNext()) {
               return null;
            }

            object = (WorldObject)var3.next();
         } while(object.getX() != tile.getX() || object.getY() != tile.getY() || object.getPlane() != tile.getPlane());

         return object;
      }
   }

   public WorldObject getRemovedObjectWithSlot(int plane, int x, int y, int slot) {
      Iterator var6 = this.removedObjects.iterator();

      WorldObject object;
      do {
         if (!var6.hasNext()) {
            return null;
         }

         object = (WorldObject)var6.next();
      } while(object.getXInRegion() != x || object.getYInRegion() != y || object.getPlane() != plane || OBJECT_SLOTS[object.getType()] != slot);

      return object;
   }

   public WorldObject[] getObjects(int plane, int x, int y) {
      return this.objects == null ? null : this.objects[plane][x][y];
   }

   public List<WorldObject> getObjects() {
      if (this.objects == null) {
         return null;
      } else {
         List<WorldObject> list = new ArrayList();

         for(int z = 0; z < 4; ++z) {
            for(int x = 0; x < 64; ++x) {
               for(int y = 0; y < 64; ++y) {
                  if (this.objects[z][x][y] != null) {
                     WorldObject[] var8;
                     int var7 = (var8 = this.objects[z][x][y]).length;

                     for(int var6 = 0; var6 < var7; ++var6) {
                        WorldObject o = var8[var6];
                        if (o != null) {
                           list.add(o);
                        }
                     }
                  }
               }
            }
         }

         return list;
      }
   }

   public boolean containsObjectWithId(int plane, int x, int y, int id) {
      WorldObject object = this.getObjectWithId(plane, x, y, id);
      return object != null && object.getId() == id;
   }

   public void removeRemovedObject(WorldObject object) {
      if (this.removedObjects != null) {
         this.removedObjects.remove(object);
      }
   }

   public WorldObject getSpawnedObject(WorldTile tile) {
      if (this.spawnedObjects == null) {
         return null;
      } else {
         Iterator var3 = this.spawnedObjects.iterator();

         WorldObject object;
         do {
            if (!var3.hasNext()) {
               return null;
            }

            object = (WorldObject)var3.next();
         } while(object.getX() != tile.getX() || object.getY() != tile.getY() || object.getPlane() != tile.getPlane());

         return object;
      }
   }

   public WorldObject getObjectWithId(int plane, int x, int y, int id) {
      if (this.objects == null) {
         return null;
      } else {
         Iterator var6 = this.removedObjects.iterator();

         WorldObject object;
         do {
            if (!var6.hasNext()) {
               for(int i = 0; i < 4; ++i) {
                  WorldObject object = this.objects[plane][x][y][i];
                  if (object != null && object.getId() == id) {
                     WorldObject spawned = this.getSpawnedObjectWithSlot(plane, x, y, OBJECT_SLOTS[object.getType()]);
                     return spawned == null ? object : null;
                  }
               }

               var6 = this.spawnedObjects.iterator();

               do {
                  if (!var6.hasNext()) {
                     return null;
                  }

                  object = (WorldObject)var6.next();
               } while(object.getXInRegion() != x || object.getYInRegion() != y || object.getPlane() != plane || object.getId() != id);

               return object;
            }

            object = (WorldObject)var6.next();
         } while(object.getId() != id || object.getXInRegion() != x || object.getYInRegion() != y || object.getPlane() != plane);

         return null;
      }
   }

   public WorldObject getObjectWithId(int id, int plane) {
      if (this.objects == null) {
         return null;
      } else {
         Iterator var4 = this.spawnedObjects.iterator();

         while(var4.hasNext()) {
            WorldObject object = (WorldObject)var4.next();
            if (object.getId() == id && object.getPlane() == plane) {
               return object;
            }
         }

         for(int x = 0; x < 64; ++x) {
            for(int y = 0; y < 64; ++y) {
               for(int slot = 0; slot < this.objects[plane][x][y].length; ++slot) {
                  WorldObject object = this.objects[plane][x][y][slot];
                  if (object != null && object.getId() == id) {
                     return object;
                  }
               }
            }
         }

         return null;
      }
   }

   public List<WorldObject> getSpawnedObjects() {
      return this.spawnedObjects;
   }

   public List<WorldObject> getRemovedObjects() {
      return this.removedObjects;
   }

   public void removeObject(WorldObject object) {
      if (this.spawnedObjects != null) {
         this.spawnedObjects.remove(object);
      }
   }

   public void loadRegionMap() {
      int regionX = (this.regionId >> 8) * 64;
      int regionY = (this.regionId & 255) * 64;
      int landArchiveId = Cache.STORE.getIndexes()[5].getArchiveId("l" + (regionX >> 3) / 8 + "_" + (regionY >> 3) / 8);
      byte[] landContainerData = landArchiveId == -1 ? null : Cache.STORE.getIndexes()[5].getFile(landArchiveId, 0, MapXTEA.getKey(this.regionId));
      int mapArchiveId = Cache.STORE.getIndexes()[5].getArchiveId("m" + (regionX >> 3) / 8 + "_" + (regionY >> 3) / 8);
      byte[] mapContainerData = mapArchiveId == -1 ? null : Cache.STORE.getIndexes()[5].getFile(mapArchiveId, 0);
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

         if (this.regionId != 11844) {
            for(plane = 0; plane < 4; ++plane) {
               for(x = 0; x < 64; ++x) {
                  for(y = 0; y < 64; ++y) {
                     if ((mapSettings[plane][x][y] & 1) == 1 && (mapSettings[1][x][y] & 2) != 2) {
                        this.forceGetRegionMap().addUnwalkable(plane, x, y);
                     }
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
               int localX = y >> 6 & 63;
               int localY = y & 63;
               int plane = y >> 12;
               int objectData = mapStream.readUnsignedByte();
               int type = objectData >> 2;
               int rotation = objectData & 3;
               if (localX >= 0 && localX < 64 && localY >= 0 && localY < 64) {
                  int objectPlane = plane;
                  if (mapSettings != null && (mapSettings[1][localX][localY] & 2) == 2) {
                     objectPlane = plane - 1;
                  }

                  if (objectPlane >= 0 && objectPlane < 4 && plane >= 0 && plane < 4) {
                     this.spawnObject(new WorldObject(plane, type, rotation, localX + regionX, localY + regionY, objectPlane), objectPlane, localX, localY, true);
                  }
               }
            }
         }
      }

      if (landContainerData == null && landArchiveId != -1 && MapXTEA.getKey(this.regionId) != null) {
         System.out.println("Missing xteas for region " + this.regionId + ".");
      }

   }

   public int getRotation(int plane, int x, int y) {
      return 0;
   }

   public FloorItem getFloorItem(int id, WorldTile tile, Player player) {
      if (this.floorItems == null) {
         return null;
      } else {
         Iterator var5 = this.floorItems.iterator();

         FloorItem item;
         do {
            do {
               if (!var5.hasNext()) {
                  return null;
               }

               item = (FloorItem)var5.next();
            } while(item.isInvisible() && item.hasOwner() && !player.getUsername().equalsIgnoreCase(item.getOwner().getUsername()));
         } while(item.getId() != id || tile.getX() != item.getTile().getX() || tile.getY() != item.getTile().getY() || tile.getPlane() != item.getTile().getPlane());

         return item;
      }
   }

   public List<FloorItem> getFloorItems() {
      return this.floorItems;
   }

   public List<FloorItem> forceGetFloorItems() {
      if (this.floorItems == null) {
         this.floorItems = new CopyOnWriteArrayList();
      }

      return this.floorItems;
   }

   public List<Integer> getPlayerIndexes() {
      return this.playersIndexes;
   }

   public int getPlayerCount() {
      return this.playersIndexes == null ? 0 : this.playersIndexes.size();
   }

   public List<Integer> getNPCsIndexes() {
      return this.npcsIndexes;
   }

   public void addPlayerIndex(int index) {
      if (this.playersIndexes == null) {
         this.playersIndexes = new CopyOnWriteArrayList();
      }

      this.playersIndexes.add(index);
   }

   public void addNPCIndex(int index) {
      if (this.npcsIndexes == null) {
         this.npcsIndexes = new CopyOnWriteArrayList();
      }

      this.npcsIndexes.add(index);
   }

   public void removePlayerIndex(Integer index) {
      if (this.playersIndexes != null) {
         this.playersIndexes.remove(index);
      }
   }

   public boolean removeNPCIndex(Object index) {
      return this.npcsIndexes == null ? false : this.npcsIndexes.remove(index);
   }

   public void loadMusicIds() {
      int musicId1 = getMusicId(getMusicName1(this.regionId));
      if (musicId1 != -1) {
         int musicId2 = getMusicId(getMusicName2(this.regionId));
         if (musicId2 != -1) {
            int musicId3 = getMusicId(getMusicName3(this.regionId));
            if (musicId3 != -1) {
               this.musicIds = new int[]{musicId1, musicId2, musicId3};
            } else {
               this.musicIds = new int[]{musicId1, musicId2};
            }
         } else {
            this.musicIds = new int[]{musicId1};
         }
      }

   }

   public int getMusicId() {
      if (this.musicIds == null) {
         return -1;
      } else {
         return this.musicIds.length == 1 ? this.musicIds[0] : this.musicIds[Utils.getRandom(this.musicIds.length - 1)];
      }
   }

   public int getLoadMapStage() {
      return this.loadMapStage;
   }

   public void setLoadMapStage(int loadMapStage) {
      this.loadMapStage = loadMapStage;
   }

   public boolean isLoadedObjectSpawns() {
      return this.loadedObjectSpawns;
   }

   public void setLoadedObjectSpawns(boolean loadedObjectSpawns) {
      this.loadedObjectSpawns = loadedObjectSpawns;
   }

   public boolean isLoadedNPCSpawns() {
      return this.loadedNPCSpawns;
   }

   public void setLoadedNPCSpawns(boolean loadedNPCSpawns) {
      this.loadedNPCSpawns = loadedNPCSpawns;
   }

   public int getRegionId() {
      return this.regionId;
   }

   public static final String getMusicName3(int regionId) {
      switch(regionId) {
      case 11575:
         return "Spiritual";
      case 12895:
         return "Target";
      case 12896:
         return "I Can See You";
      case 13151:
         return "Hunted";
      case 13152:
         return "Steady";
      case 14948:
         return "Dominion Lobby III";
      case 18255:
         return "Tzhaar Supremacy III";
      case 18511:
      case 18512:
      case 19024:
         return "Tzhaar City III";
      default:
         return null;
      }
   }

   public static final String getMusicName2(int regionId) {
      switch(regionId) {
      case 11573:
         return "Taverley Enchantment";
      case 11575:
         return "Taverley Adventure";
      case 12342:
         return "Stronger (What Doesn't Kill You)";
      case 12853:
         return "Cellar Song";
      case 12895:
         return "Steady";
      case 12896:
         return "Hunted";
      case 13151:
         return "You Will Know Me";
      case 13152:
         return "I Can See You";
      case 13626:
      case 13627:
      case 13881:
      case 13882:
         return "Daemonheim Fremenniks";
      case 14948:
         return "Dominion Lobby II";
      case 18255:
         return "Tzhaar Supremacy II";
      case 18511:
      case 18512:
      case 19024:
         return "Tzhaar City II";
      default:
         return null;
      }
   }

   public static final String getMusicName1(int regionId) {
      switch(regionId) {
      case 4451:
      case 4453:
      case 4707:
      case 4709:
      case 5219:
      case 5220:
      case 5221:
         return "Hunting Dragons";
      case 6992:
      case 6993:
         return "The Mad Mole";
      case 7473:
         return "The Waiting Game";
      case 7505:
         return "Dogs of War";
      case 8017:
         return "Food for Thought";
      case 8523:
         return "Stratosphere";
      case 8527:
         return "Aye Car Rum Ba";
      case 8528:
         return "Blistering Barnacles";
      case 8530:
         return "Malady";
      case 8774:
         return "Taverley Lament";
      case 8779:
         return "La Mort";
      case 9033:
         return "Attack5";
      case 9035:
         return "Complication";
      case 9275:
         return "Volcanic Vikings";
      case 9297:
         return "Dance of Death";
      case 9516:
         return "Command Centre";
      case 9541:
         return "Faerie";
      case 9547:
         return "Understanding";
      case 9551:
         return "TzHaar!";
      case 9552:
         return "Fire and Brimstone";
      case 9776:
         return "Melodrama";
      case 9781:
         return "Gnome Village";
      case 9797:
         return "Crystal Cave";
      case 9802:
         return "Undead Dungeon";
      case 9803:
         return "Righteousness";
      case 9804:
         return "Bloodbath";
      case 10029:
      case 10285:
         return "Jungle Hunt";
      case 10032:
         return "Big Chords";
      case 10039:
         return "Legion";
      case 10040:
         return "Lighthouse";
      case 10059:
         return "Heart and Mind";
      case 10140:
         return "Out of the Deep";
      case 10288:
         return "Magic Dance";
      case 10291:
      case 10292:
         return "Knightly";
      case 10293:
         return "Mellow";
      case 10294:
         return "Theme";
      case 10296:
         return "Lullaby";
      case 10301:
         return "Skyfall";
      case 10315:
         return "Quest";
      case 10329:
         return "The Sound of Guthix";
      case 10388:
         return "Cavern";
      case 10547:
         return "Baroque";
      case 10548:
         return "Wonderous";
      case 10549:
         return "Lasting";
      case 10550:
         return "Talking Forest";
      case 10552:
         return "Saga";
      case 10553:
         return "Rellekka";
      case 10571:
         return "Down to Earth";
      case 10644:
      case 10645:
      case 10900:
         return "7th Realm";
      case 10658:
         return "Espionage";
      case 10801:
         return "Landlubber";
      case 10802:
         return "Jungly2";
      case 10804:
         return "Trinity";
      case 10805:
      case 11062:
         return "Camelot";
      case 10806:
         return "Overture";
      case 10809:
         return "Borderland";
      case 10827:
         return "Zealot";
      case 10828:
         return "Legend";
      case 10899:
         return "Karamja Jam";
      case 10901:
         return "Pathways";
      case 10906:
         return "Twilight";
      case 10907:
      case 10908:
         return "Masquerade";
      case 11057:
         return "High Seas";
      case 11058:
         return "Jolly-R";
      case 11061:
      case 11317:
         return "Fishing";
      case 11083:
         return "Miracle Dance";
      case 11094:
         return "Clan Wars";
      case 11157:
         return "Aztec";
      case 11164:
         return "The Slayer";
      case 11314:
      case 11315:
         return "The Shadow";
      case 11318:
         return "Ice Melody";
      case 11319:
         return "Warriors' Guild";
      case 11320:
         return "Tremble";
      case 11339:
         return "Serene";
      case 11346:
         return "Armadyl Alliance";
      case 11347:
         return "Armageddon";
      case 11413:
      case 11414:
         return "Dangerous Road";
      case 11416:
         return "Underground";
      case 11417:
         return "Arabique";
      case 11570:
         return "Wandar";
      case 11571:
         return "Miles Away";
      case 11573:
         return "Taverley Ambience";
      case 11574:
         return "Splendour";
      case 11575:
         return "Spiritual";
      case 11576:
         return "Kingdom";
      case 11577:
         return "Mad Eadgar";
      case 11588:
      case 11844:
         return "The Vacant Abyss";
      case 11595:
         return "Rune Essence";
      case 11601:
         return "Zaros Zeitgeist";
      case 11602:
         return "Strength of Saradomin";
      case 11603:
         return "Zamorak Zoo";
      case 11671:
         return "Royale";
      case 11672:
         return "Dunjun";
      case 11673:
         return "Courage";
      case 11824:
         return "Mudskipper Melody";
      case 11825:
         return "Attention";
      case 11826:
         return "Long Way Home";
      case 11827:
         return "Nightfall";
      case 11828:
         return "Fanfare";
      case 11829:
         return "Scape Soft";
      case 11836:
         return "Attack3";
      case 11925:
         return "Starlight";
      case 11927:
         return "Cave Background";
      case 11929:
      case 12185:
         return "Dwarf Theme";
      case 12081:
         return "Tomorrow";
      case 12082:
         return "Sea Shanty2";
      case 12083:
         return "Wander";
      case 12086:
         return "Knightmare";
      case 12089:
         return "Dark";
      case 12091:
         return "Wilderness2";
      case 12092:
         return "Wild Side";
      case 12107:
         return "Into the Abyss";
      case 12115:
         return "Dimension X";
      case 12181:
         return "Woe of the Wyvern";
      case 12184:
         return "Workshop";
      case 12336:
         return "Newbie Melody";
      case 12338:
         return "Unknown Land";
      case 12339:
         return "Start";
      case 12340:
         return "Spooky";
      case 12341:
         return "Barbarianims";
      case 12342:
         return "Forever";
      case 12343:
         return "Dangerous";
      case 12344:
         return "Dark";
      case 12345:
         return "Eruption";
      case 12349:
         return "Mage Arena";
      case 12374:
         return "The Route of All Evil";
      case 12441:
      case 12442:
      case 12954:
         return "Scape Cave";
      case 12445:
      case 12446:
         return "Wilderness";
      case 12589:
         return "The Desert";
      case 12590:
         return "Bandit Camp";
      case 12593:
         return "Book of Spells";
      case 12594:
         return "Dream";
      case 12595:
         return "Flute Salad";
      case 12596:
         return "Greatness";
      case 12597:
         return "Spirit";
      case 12598:
         return "The Trade Parade";
      case 12599:
         return "Doorways";
      case 12600:
         return "Scape Wild";
      case 12616:
         return "Undead Dungeon";
      case 12847:
      case 13102:
      case 13104:
      case 13359:
         return "Desert Voyage";
      case 12848:
         return "Arabian3";
      case 12849:
         return "Yesteryear";
      case 12850:
         return "Harmony";
      case 12851:
         return "Autumn Voyage";
      case 12852:
         return "Expanse";
      case 12853:
         return "Garden";
      case 12854:
         return "Adventure";
      case 12855:
         return "Crystal Sword";
      case 12856:
         return "Faithless";
      case 12895:
         return "I Can See You";
      case 12896:
         return "You Will Know Me";
      case 12948:
         return "The Power of Tears";
      case 12949:
      case 12950:
         return "Cave of the Goblins";
      case 13103:
         return "Lonesome";
      case 13105:
         return "Al Kharid";
      case 13107:
         return "Arabian2";
      case 13108:
         return "Still Night";
      case 13109:
         return "Medieval";
      case 13110:
         return "Honkytonky Parade";
      case 13114:
         return "Wilderness";
      case 13151:
         return "Target";
      case 13152:
         return "Hunted";
      case 13206:
         return "The Lost Tribe";
      case 13360:
      case 13407:
      case 18516:
      case 18517:
      case 18773:
      case 18775:
         return "";
      case 13361:
         return "Valerio's Song";
      case 13362:
         return "Duel Arena";
      case 13363:
         return "Shine";
      case 13364:
         return "Medieval";
      case 13365:
         return "Venture";
      case 13617:
         return "Citharede Requiem";
      case 13622:
         return "Morytania";
      case 13623:
         return "The Terrible Tower";
      case 13626:
      case 13627:
      case 13881:
      case 13882:
         return "Daemonheim Entrance";
      case 13654:
      case 13910:
         return "Rest for the Weary";
      case 13656:
         return "The Muspah's Tomb";
      case 13722:
         return "Mausoleum";
      case 13877:
         return "Waterlogged";
      case 13878:
         return "Village";
      case 13899:
         return "Zealot";
      case 13972:
         return "Insect Queen";
      case 13977:
         return "Stillness";
      case 14131:
         return "Dance of the Undead";
      case 14231:
         return "Dangerous Way";
      case 14415:
      case 14416:
      case 14671:
      case 14672:
         return "Living Rock";
      case 14494:
         return "Little Cave of Horrors";
      case 14637:
      case 14894:
         return "Life's a Beach!";
      case 14638:
         return "In the Brine";
      case 14644:
         return "Darkmeyer";
      case 14646:
         return "The Other Side";
      case 14746:
         return "Phasmatys";
      case 14747:
         return "Brew Hoo Hoo";
      case 14948:
         return "Dominion Lobby I";
      case 15446:
      case 15957:
      case 15958:
         return "Dead and Buried";
      case 15710:
         return "Runebreath";
      case 15711:
         return "Runearia";
      case 15967:
         return "Runespan";
      case 18255:
         return "Tzhaar Supremacy I";
      case 18511:
      case 18512:
      case 19024:
         return "Tzhaar City I";
      default:
         return null;
      }
   }

   private static final int getMusicId(String musicName) {
      if (musicName == null) {
         return -1;
      } else if (musicName.equals("")) {
         return -2;
      } else if (musicName.equals("Skyfall")) {
         return 2000;
      } else if (musicName.equals("Stronger (What Doesn't Kill You)")) {
         return 2001;
      } else {
         int musicIndex = (int)ClientScriptMap.getMap(1345).getKeyForValue(musicName);
         return ClientScriptMap.getMap(1351).getIntValue((long)musicIndex);
      }
   }

   public boolean isLoadedItemSpawns() {
      return this.loadedItemSpawns;
   }

   public void setLoadedItemSpawns(boolean loadedItemSpawns) {
      this.loadedItemSpawns = loadedItemSpawns;
   }

   public static enum ForceClipping {
      TAVDUNG1(11672, new WorldTile[]{new WorldTile(2904, 9764, 0), new WorldTile(2903, 9763, 0), new WorldTile(2902, 9762, 0), new WorldTile(2901, 9762, 0), new WorldTile(2900, 9762, 0), new WorldTile(2899, 9762, 0), new WorldTile(2898, 9762, 0), new WorldTile(2897, 9762, 0), new WorldTile(2896, 9763, 0), new WorldTile(2895, 9764, 0), new WorldTile(2894, 9764, 0), new WorldTile(2893, 9764, 0), new WorldTile(2893, 9765, 0), new WorldTile(2892, 9766, 0), new WorldTile(2891, 9766, 0), new WorldTile(2890, 9766, 0), new WorldTile(2889, 9766, 0), new WorldTile(2888, 9766, 0), new WorldTile(2887, 9766, 0), new WorldTile(2886, 9766, 0), new WorldTile(2885, 9766, 0), new WorldTile(2884, 9765, 0), new WorldTile(2883, 9766, 0), new WorldTile(2882, 9766, 0), new WorldTile(2881, 9766, 0), new WorldTile(2880, 9766, 0), new WorldTile(2939, 9782, 0), new WorldTile(2925, 9757, 0), new WorldTile(2926, 9757, 0), new WorldTile(2938, 9780, 0), new WorldTile(2937, 9779, 0), new WorldTile(2937, 9780, 0), new WorldTile(2936, 9779, 0), new WorldTile(2935, 9779, 0), new WorldTile(2935, 9778, 0), new WorldTile(2934, 9777, 0), new WorldTile(2934, 9778, 0), new WorldTile(2933, 9776, 0), new WorldTile(2933, 9775, 0), new WorldTile(2933, 9774, 0), new WorldTile(2933, 9773, 0), new WorldTile(2933, 9772, 0), new WorldTile(2933, 9771, 0), new WorldTile(2933, 9770, 0), new WorldTile(2933, 9769, 0), new WorldTile(2933, 9768, 0), new WorldTile(2932, 9767, 0), new WorldTile(2932, 9768, 0), new WorldTile(2931, 9765, 0), new WorldTile(2931, 9766, 0), new WorldTile(2932, 9765, 0), new WorldTile(2933, 9764, 0), new WorldTile(2933, 9763, 0), new WorldTile(2933, 9762, 0), new WorldTile(2933, 9761, 0), new WorldTile(2933, 9760, 0), new WorldTile(2933, 9759, 0), new WorldTile(2932, 9758, 0), new WorldTile(2931, 9758, 0), new WorldTile(2930, 9757, 0), new WorldTile(2929, 9757, 0), new WorldTile(2928, 9757, 0), new WorldTile(2927, 9757, 0), new WorldTile(2925, 9758, 0), new WorldTile(2929, 9754, 0), new WorldTile(2928, 9754, 0), new WorldTile(2927, 9753, 0), new WorldTile(2926, 9752, 0), new WorldTile(2938, 9782, 0), new WorldTile(2925, 9752, 0), new WorldTile(2924, 9752, 0), new WorldTile(2924, 9751, 0), new WorldTile(2923, 9750, 0), new WorldTile(2922, 9749, 0), new WorldTile(2921, 9748, 0), new WorldTile(2920, 9747, 0), new WorldTile(2927, 9754, 0), new WorldTile(2926, 9754, 0), new WorldTile(2925, 9754, 0), new WorldTile(2924, 9753, 0), new WorldTile(2923, 9753, 0), new WorldTile(2922, 9753, 0), new WorldTile(2921, 9753, 0), new WorldTile(2920, 9753, 0), new WorldTile(2920, 9754, 0), new WorldTile(2919, 9755, 0), new WorldTile(2918, 9755, 0), new WorldTile(2917, 9755, 0), new WorldTile(2916, 9755, 0), new WorldTile(2915, 9755, 0), new WorldTile(2914, 9754, 0), new WorldTile(2912, 9757, 0), new WorldTile(2912, 9758, 0), new WorldTile(2912, 9759, 0), new WorldTile(2913, 9760, 0), new WorldTile(2914, 9761, 0), new WorldTile(2915, 9762, 0), new WorldTile(2916, 9762, 0), new WorldTile(2917, 9762, 0), new WorldTile(2918, 9762, 0), new WorldTile(2919, 9762, 0), new WorldTile(2920, 9762, 0), new WorldTile(2921, 9762, 0), new WorldTile(2921, 9763, 0), new WorldTile(2922, 9763, 0), new WorldTile(2922, 9764, 0), new WorldTile(2922, 9765, 0), new WorldTile(2922, 9766, 0), new WorldTile(2922, 9767, 0), new WorldTile(2922, 9768, 0), new WorldTile(2923, 9769, 0), new WorldTile(2923, 9770, 0), new WorldTile(2924, 9771, 0), new WorldTile(2925, 9772, 0), new WorldTile(2926, 9773, 0), new WorldTile(2927, 9773, 0), new WorldTile(2928, 9773, 0), new WorldTile(2929, 9774, 0), new WorldTile(2928, 9774, 0), new WorldTile(2929, 9775, 0), new WorldTile(2929, 9776, 0), new WorldTile(2929, 9777, 0), new WorldTile(2929, 9778, 0), new WorldTile(2929, 9779, 0), new WorldTile(2932, 9775, 0), new WorldTile(2932, 9774, 0), new WorldTile(2932, 9773, 0), new WorldTile(2932, 9772, 0), new WorldTile(2932, 9771, 0), new WorldTile(2931, 9771, 0), new WorldTile(2930, 9771, 0), new WorldTile(2929, 9771, 0), new WorldTile(2928, 9770, 0), new WorldTile(2929, 9770, 0), new WorldTile(2928, 9769, 0), new WorldTile(2928, 9768, 0), new WorldTile(2928, 9767, 0), new WorldTile(2928, 9766, 0), new WorldTile(2928, 9765, 0), new WorldTile(2928, 9764, 0), new WorldTile(2929, 9764, 0), new WorldTile(2930, 9763, 0), new WorldTile(2931, 9762, 0), new WorldTile(2931, 9761, 0), new WorldTile(2930, 9760, 0), new WorldTile(2929, 9759, 0), new WorldTile(2928, 9759, 0), new WorldTile(2927, 9759, 0), new WorldTile(2926, 9759, 0), new WorldTile(2932, 9780, 0), new WorldTile(2932, 9781, 0), new WorldTile(2933, 9782, 0), new WorldTile(2933, 9782, 0), new WorldTile(2937, 9782, 0), new WorldTile(2934, 9782, 0), new WorldTile(2935, 9782, 0), new WorldTile(2936, 9782, 0)}),
      TAVDUNG2(11416, new WorldTile[]{new WorldTile(2879, 9766, 0), new WorldTile(2878, 9766, 0), new WorldTile(2877, 9767, 0), new WorldTile(2876, 9767, 0)});

      private final int regionId;
      private final WorldTile[] tiles;

      private ForceClipping(int regionId, WorldTile[] tiles) {
         this.regionId = regionId;
         this.tiles = tiles;
      }
   }
}
