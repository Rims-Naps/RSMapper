import com.rs.cache.Cache;
import com.rs.cache.io.InputStream;
import com.rs.cache.io.OutputStream;
import com.rs.cache.loaders.XTEAKeys;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ObjectSpawnEditor extends JFrame {
   private static final long serialVersionUID = 3422540990658440264L;
   static int[] objectTypeFlags = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
   static int[] objectTypes = new int[]{0, 4, 10, 22};
   public boolean unsavedLandProgress;
   public boolean unsavedUnderlandProgress;
   public boolean VIEWER_OPEN = false;
   public boolean dataLoaded = false;
   boolean PACK_LAND = false;
   boolean PACK_UNDERLAND = false;
   boolean HIDE_OBJECTS = false;
   public int viewingObject = -1;
   static XTEAKeys databaseKeys;
   ConcurrentHashMap<Integer, int[]> foundObjectsOnTile;
   LinkedHashMap<Integer, ArrayList<CachedObject>> cachedObjects;
   ConcurrentHashMap<Integer, int[]> foundUnderObjectsOnTile;
   LinkedHashMap<Integer, ArrayList<CachedObject>> cachedUnderObjects;

   public ObjectSpawnEditor() {
      databaseKeys = new XTEAKeys();
      databaseKeys.loadKeys();
      this.unsavedLandProgress = false;
      this.unsavedUnderlandProgress = false;
      this.dataLoaded = false;
   }

   public void populateTable(WorldTile tile) {
      if (tile != null) {
         boolean objectsRead = this.readInObjectsOnTile(tile, false);
         ArrayList<Integer> objectIds = objectsRead ? new ArrayList<>(this.foundObjectsOnTile.keySet()) : null;
         boolean underObjectsRead = this.readInObjectsOnTile(tile, true);
         ArrayList<Integer> underObjectIds = underObjectsRead ? new ArrayList<>(this.foundUnderObjectsOnTile.keySet()) : null;

         for(int k = 0; k < 2; ++k) {
            for(int i = 0; i < 4; ++i) {
               JTextField idField = (JTextField)(k == 0 ? UIPanels.generalComponents : UIPanels.objectComponents).get("objects_on_tile" + i + "_0");
               if (idField != null) {
                  if (objectsRead && objectIds != null && this.foundObjectsOnTile != null && i < this.foundObjectsOnTile.size()) {
                     ((JTextField)(k == 0 ? UIPanels.generalComponents : UIPanels.objectComponents).get("objects_on_tile" + i + "_0"))
                        .setText(Integer.toString(objectIds.get(i)));
                     ((JTextField)(k == 0 ? UIPanels.generalComponents : UIPanels.objectComponents).get("objects_on_tile" + i + "_1"))
                        .setText(Integer.toString(this.foundObjectsOnTile.get(objectIds.get(i))[0]));
                     ((JTextField)(k == 0 ? UIPanels.generalComponents : UIPanels.objectComponents).get("objects_on_tile" + i + "_2"))
                        .setText(Integer.toString(this.foundObjectsOnTile.get(objectIds.get(i))[1]));
                  } else {
                     ((JTextField)(k == 0 ? UIPanels.generalComponents : UIPanels.objectComponents).get("objects_on_tile" + i + "_0")).setText("");
                     ((JTextField)(k == 0 ? UIPanels.generalComponents : UIPanels.objectComponents).get("objects_on_tile" + i + "_1")).setText("");
                     ((JTextField)(k == 0 ? UIPanels.generalComponents : UIPanels.objectComponents).get("objects_on_tile" + i + "_2")).setText("");
                  }
               }

               if (i < 3 && RSMapperClient.underlandArchiveId != -1) {
                  idField = (JTextField)(k == 0 ? UIPanels.generalComponents : UIPanels.objectComponents).get("under_objects_on_tile" + i + "_0");
                  if (idField != null) {
                     if (underObjectsRead && underObjectIds != null && this.foundUnderObjectsOnTile != null && i < this.foundUnderObjectsOnTile.size()) {
                        ((JTextField)(k == 0 ? UIPanels.generalComponents : UIPanels.objectComponents).get("under_objects_on_tile" + i + "_0"))
                           .setText(Integer.toString(underObjectIds.get(i)));
                        ((JTextField)(k == 0 ? UIPanels.generalComponents : UIPanels.objectComponents).get("under_objects_on_tile" + i + "_1"))
                           .setText(Integer.toString(this.foundUnderObjectsOnTile.get(underObjectIds.get(i))[0]));
                        ((JTextField)(k == 0 ? UIPanels.generalComponents : UIPanels.objectComponents).get("under_objects_on_tile" + i + "_2"))
                           .setText(Integer.toString(this.foundUnderObjectsOnTile.get(underObjectIds.get(i))[1]));
                     } else {
                        ((JTextField)(k == 0 ? UIPanels.generalComponents : UIPanels.objectComponents).get("under_objects_on_tile" + i + "_0")).setText("");
                        ((JTextField)(k == 0 ? UIPanels.generalComponents : UIPanels.objectComponents).get("under_objects_on_tile" + i + "_1")).setText("");
                        ((JTextField)(k == 0 ? UIPanels.generalComponents : UIPanels.objectComponents).get("under_objects_on_tile" + i + "_2")).setText("");
                     }
                  }
               }
            }
         }

         RSMapperClient.setFocusOnCanvas();
      }
   }

   public void loadFile(byte[] data, boolean underland) {
      try {
         if (!underland) {
            if (this.cachedObjects == null) {
               this.cachedObjects = new LinkedHashMap<>();
            } else {
               this.cachedObjects.clear();
            }
         } else if (this.cachedUnderObjects == null) {
            this.cachedUnderObjects = new LinkedHashMap<>();
         } else {
            this.cachedUnderObjects.clear();
         }

         InputStream buffer = new InputStream(data);
         int objectId = -1;

         while(true) {
            int objectIdIncrement = buffer.readSmart2();
            if (objectIdIncrement == 0) {
               RSMapperClient.editor.loadingRegionProgress += 25;
               return;
            }

            objectId += objectIdIncrement;
            ArrayList<CachedObject> objectsWithSameId = new ArrayList<>();
            int positionHash = 0;

            while(true) {
               int positionIncrement = buffer.readUnsignedSmart();
               if (positionIncrement == 0) {
                  if (!underland) {
                     this.cachedObjects.put(Integer.valueOf(objectId), objectsWithSameId);
                  } else {
                     this.cachedUnderObjects.put(Integer.valueOf(objectId), objectsWithSameId);
                  }
                  break;
               }

               int x = ((positionHash + positionIncrement - 1 & 4086) >> 6) + Utils.getRegionCoordX(RSMapperClient.regionId);
               int y = (positionHash + positionIncrement - 1 & 63) + Utils.getRegionCoordY(RSMapperClient.regionId);
               int plane = positionHash + positionIncrement - 1 >> 12;
               int typeRotation = buffer.readUnsignedByte();
               objectsWithSameId.add(new CachedObject(new WorldTile(x, y, plane, false), typeRotation));
               positionHash += positionIncrement - 1;
            }
         }
      } catch (Exception var13) {
         var13.printStackTrace();
         JOptionPane.showMessageDialog(RSMapperClient.client_frame, "Unable to locate file, or XTEA Keys are missing/wrong", "ERROR", 0);
      }
   }

   private boolean readInObjectsOnTile(WorldTile tile, boolean underland) {
      if (tile != null && (underland || this.cachedObjects != null) && (!underland || this.cachedUnderObjects != null)) {
         if (!underland) {
            if (this.foundObjectsOnTile == null) {
               this.foundObjectsOnTile = new ConcurrentHashMap<>();
            } else {
               this.foundObjectsOnTile.clear();
            }
         } else if (this.foundUnderObjectsOnTile == null) {
            this.foundUnderObjectsOnTile = new ConcurrentHashMap<>();
         } else {
            this.foundUnderObjectsOnTile.clear();
         }

         if (!underland && RSMapperClient.landArchiveId == -1) {
            return false;
         } else if (underland && RSMapperClient.underlandArchiveId == -1) {
            return false;
         } else {
            Iterator<Entry<Integer, ArrayList<CachedObject>>> it = underland
               ? this.cachedUnderObjects.entrySet().iterator()
               : this.cachedObjects.entrySet().iterator();

            while(it.hasNext()) {
               Entry<Integer, ArrayList<CachedObject>> pair = it.next();
               int objectId = pair.getKey();

               for(CachedObject object : pair.getValue()) {
                  if (object.getX() == tile.getX() && object.getY() == tile.getY() && object.getPlane() == tile.getPlane()) {
                     if (!underland) {
                        this.foundObjectsOnTile.put(objectId, new int[]{object.getType(), object.getRotation()});
                     } else {
                        this.foundUnderObjectsOnTile.put(objectId, new int[]{object.getType(), object.getRotation()});
                     }
                  }
               }
            }

            return !underland && this.foundObjectsOnTile.size() > 0 || underland && this.foundUnderObjectsOnTile.size() > 0;
         }
      } else {
         return false;
      }
   }

   public int[][] getObjectsOnTile(WorldTile tile, boolean underland) {
      if (tile == null) {
         return null;
      } else {
         int[][] returnObjects = new int[4][3];
         if (!underland && !WorldmapDefinitions.worldmapIsOpen()) {
            WorldObject interface19 = Class277_Sub1.getWorldObjectWithTypeAtCoordinates(tile.getLocalX(), tile.getLocalY(), tile.getPlane(), 0, true);
            boolean ignore = interface19 == null || objectTypeFlags[interface19.getType(69)] != 0;
            returnObjects[0][0] = !ignore ? interface19.getId(-32136) : -1;
            returnObjects[0][1] = !ignore ? interface19.getType(69) : -1;
            returnObjects[0][2] = !ignore ? interface19.getRotation(23796) : -1;
            interface19 = Class277_Sub1.getWorldObjectWithTypeAtCoordinates(tile.getLocalX(), tile.getLocalY(), tile.getPlane(), 1, true);
            ignore = interface19 == null || objectTypeFlags[interface19.getType(69)] != 1;
            returnObjects[1][0] = !ignore ? interface19.getId(-32136) : -1;
            returnObjects[1][1] = !ignore ? interface19.getType(69) : -1;
            returnObjects[1][2] = !ignore ? interface19.getRotation(23796) : -1;
            interface19 = Class277_Sub1.getWorldObjectWithTypeAtCoordinates(tile.getLocalX(), tile.getLocalY(), tile.getPlane(), 2, true);
            ignore = interface19 == null || objectTypeFlags[interface19.getType(69)] != 2;
            returnObjects[2][0] = !ignore ? interface19.getId(-32136) : -1;
            returnObjects[2][1] = !ignore ? interface19.getType(69) : -1;
            returnObjects[2][2] = !ignore ? interface19.getRotation(23796) : -1;
            interface19 = Class277_Sub1.getWorldObjectWithTypeAtCoordinates(tile.getLocalX(), tile.getLocalY(), tile.getPlane(), 3, true);
            ignore = interface19 == null || objectTypeFlags[interface19.getType(69)] != 3;
            returnObjects[3][0] = !ignore ? interface19.getId(-32136) : -1;
            returnObjects[3][1] = !ignore ? interface19.getType(69) : -1;
            returnObjects[3][2] = !ignore ? interface19.getRotation(23796) : -1;
         } else {
            int count = 0;
            Iterator<Entry<Integer, ArrayList<CachedObject>>> it = underland
               ? this.cachedUnderObjects.entrySet().iterator()
               : this.cachedObjects.entrySet().iterator();

            while(it.hasNext()) {
               Entry<Integer, ArrayList<CachedObject>> pair = it.next();
               int objectId = pair.getKey();

               for(CachedObject object : pair.getValue()) {
                  if (object.getX() == tile.getX() && object.getY() == tile.getY() && object.getPlane() == tile.getPlane()) {
                     returnObjects[count] = new int[]{objectId, object.getType(), object.getRotation()};
                     ++count;
                  }
               }
            }

            if (count < 3) {
               for(int i = 0; i < 4; ++i) {
                  if (returnObjects[i][0] == 0 && returnObjects[i][1] == 0) {
                     returnObjects[i] = new int[]{-1, -1, -1};
                  }
               }
            }
         }

         return returnObjects;
      }
   }

   public boolean removeObject(WorldTile tile, int type, boolean underland, boolean populateTables) {
      return this.placeObject(tile, -1, type, 0, underland, populateTables);
   }

   public boolean placeObject(WorldTile tile, int id, int type, int rotation, boolean underland, boolean populateTables) {
      if (tile == null || !tile.isWithinRegionBounds() || type < 0) {
         return false;
      } else if (!underland && RSMapperClient.landArchiveId == -1) {
         return false;
      } else if (underland && RSMapperClient.underlandArchiveId == -1) {
         return false;
      } else if (type == -1) {
         System.err.println("type was -1 for " + id + " on " + tile.toString());
         return false;
      } else {
         rotation &= 3;
         this.readInObjectsOnTile(tile, underland);
         if (!underland) {
            if (id != -1
               && this.foundObjectsOnTile != null
               && this.foundObjectsOnTile.get(id) != null
               && ((int[])this.foundObjectsOnTile.get(id))[0] == type
               && ((int[])this.foundObjectsOnTile.get(id))[1] == rotation) {
               if (populateTables) {
                  this.populateTable(tile);
               }

               return false;
            }
         } else if (id != -1
            && this.foundUnderObjectsOnTile != null
            && this.foundUnderObjectsOnTile.get(id) != null
            && ((int[])this.foundUnderObjectsOnTile.get(id))[0] == type
            && ((int[])this.foundUnderObjectsOnTile.get(id))[1] == rotation) {
            if (populateTables) {
               this.populateTable(tile);
            }

            return false;
         }

         if (!underland && this.foundObjectsOnTile != null && this.foundObjectsOnTile.size() > 0
            || underland && this.foundUnderObjectsOnTile != null && this.foundUnderObjectsOnTile.size() > 0) {
            Iterator<Entry<Integer, int[]>> it = underland
               ? this.foundUnderObjectsOnTile.entrySet().iterator()
               : this.foundObjectsOnTile.entrySet().iterator();

            while(it.hasNext()) {
               Entry<Integer, int[]> pair = it.next();
               int objectId = pair.getKey();
               int[] typeRotation = (int[])pair.getValue();
               if (typeRotation[0] < 0) {
                  typeRotation[0] = 0;
               } else if (typeRotation[0] > 22) {
                  typeRotation[0] = 22;
               }

               if (typeRotation[1] < 0 || typeRotation[1] > 3) {
                  typeRotation[1] &= 3;
               }

               if (objectTypeFlags[typeRotation[0]] == objectTypeFlags[type]) {
                  Iterator<Entry<Integer, ArrayList<CachedObject>>> it$ = underland
                     ? this.cachedUnderObjects.entrySet().iterator()
                     : this.cachedObjects.entrySet().iterator();

                  while(it$.hasNext()) {
                     Entry<Integer, ArrayList<CachedObject>> cachedPair = it$.next();
                     int cachedObjectId = cachedPair.getKey();
                     if (cachedObjectId == objectId) {
                        boolean marking = RSMapperClient.settings.markPropertyText.equalsIgnoreCase("Objects");
                        if (marking) {
                           RSMapperClient.settings.markPropertyText = "none";
                        }

                        ArrayList<CachedObject> objects = cachedPair.getValue();
                        ArrayList<CachedObject> updatedObjectList = new ArrayList<>();

                        for(CachedObject object : objects) {
                           if (object.getType() >= 0
                              && object.getType() <= 22
                              && (!object.getTile().equals(tile) || objectTypeFlags[object.getType()] != objectTypeFlags[type])) {
                              updatedObjectList.add(object);
                           }
                        }

                        it$.remove();
                        if (!underland) {
                           this.cachedObjects.put(Integer.valueOf(objectId), updatedObjectList);
                        } else {
                           this.cachedUnderObjects.put(Integer.valueOf(objectId), updatedObjectList);
                        }

                        if (marking) {
                           RSMapperClient.settings.markPropertyText = "Objects";
                        }
                        break;
                     }
                  }

                  it.remove();
                  break;
               }
            }
         }

         if (id >= 0) {
            if (!underland) {
               Class262_Sub19.sendDrawWorldObjectFromEditor(
                  rotation, id, objectTypeFlags[type], tile.getLocalX(), tile.getPlane(), type, tile.getLocalY(), false
               );
               this.foundObjectsOnTile.put(id, new int[]{type, rotation});
            } else {
               this.foundUnderObjectsOnTile.put(id, new int[]{type, rotation});
            }

            ArrayList<CachedObject> updatedObjectList = (underland || this.cachedObjects.get(id) != null)
                  && (!underland || this.cachedUnderObjects.get(id) != null)
               ? (underland ? this.cachedUnderObjects.get(id) : this.cachedObjects.get(id))
               : new ArrayList<>();
            updatedObjectList.add(new CachedObject(tile, type, rotation));
            if (!underland && this.cachedObjects.replace(Integer.valueOf(id), updatedObjectList) == null) {
               this.cachedObjects.put(Integer.valueOf(id), updatedObjectList);
            } else if (underland && this.cachedUnderObjects.replace(Integer.valueOf(id), updatedObjectList) == null) {
               this.cachedUnderObjects.put(Integer.valueOf(id), updatedObjectList);
            }
         } else if (!underland) {
            Class262_Sub19.sendDrawWorldObjectFromEditor(rotation, -1, objectTypeFlags[type], tile.getLocalX(), tile.getPlane(), type, tile.getLocalY(), false);
         }

         if (populateTables) {
            this.populateTable(tile);
         }

         if (!underland && WorldmapDefinitions.worldmapIsOpen()) {
            int tileOnX = tile.getX() - RSMapperClient.editor.worldmapEditor.regionXWorldCoordinate;
            int tileOnY = tile.getY() - RSMapperClient.editor.worldmapEditor.regionYWorldCoordinate;
            int posHash = tileOnX + tileOnY * WorldmapDefinitions.totalXTiles;
            int[][] objs = this.getObjectsOnTile(tile, false);
            int count = 0;

            for(int[] obj : objs) {
               if (obj[0] > 0) {
                  ++count;
               }
            }

            if (count == 1) {
               for(int[] obj : objs) {
                  if (obj[0] > 0) {
                     WorldmapDefinitions.worldmapObjectIds[posHash >= 0 ? posHash : 0] = obj[0] + 1;
                     WorldmapDefinitions.worldmapObjectOrientations[posHash >= 0 ? posHash : 0] = WorldmapDefinitions.findByteForShapeRotation(obj[1], obj[2]);
                     break;
                  }
               }
            } else if (count > 1) {
               WorldmapDefinitions.worldmapObjectIds[posHash >= 0 ? posHash : 0] = -1;
               int[] ses = new int[count];
               byte[] bs = new byte[count];
               int index = 0;

               for(int[] obj : objs) {
                  if (obj[0] > 0) {
                     ses[index] = obj[0];
                     bs[index] = WorldmapDefinitions.findByteForShapeRotation(obj[1], obj[2]);
                     ++index;
                  }
               }

               WorldmapDefinitions.aHashTable347.put((long)(tileOnX << 16 | tileOnY), new Node_Sub17(ses, bs), -123);
            } else {
               WorldmapDefinitions.worldmapObjectIds[posHash >= 0 ? posHash : 0] = -1;
               WorldmapDefinitions.aHashTable347.put((long)(tileOnX << 16 | tileOnY), new Node_Sub17(new int[0], new byte[0]), -123);
            }
         }

         if (!underland) {
            this.unsavedLandProgress = true;
         } else {
            this.unsavedUnderlandProgress = true;
            Class78.MAP_CHANGED = true;
         }

         return true;
      }
   }

   public boolean packToCache(boolean underland) {
      if (!underland && this.cachedObjects == null) {
         Logger.getLogger("global").log(Level.SEVERE, "TRYING TO PACK CACHED OBJECTS WHEN DATA IS NULL");
         return false;
      } else if (underland && this.cachedUnderObjects == null) {
         Logger.getLogger("global").log(Level.SEVERE, "TRYING TO PACK CACHED UNDER OBJECTS WHEN DATA IS NULL");
         return false;
      } else if (!this.dataLoaded) {
         System.err.println("Tried packing " + (underland ? "underland" : "land") + " file when data was not loaded!");
         return false;
      } else {
         if (RSMapperClient.editor.loadedRegion != -1) {
            int choiceLoad = JOptionPane.showOptionDialog(
               RSMapperClient.client_frame,
               "Loading region " + RSMapperClient.editor.loadedRegion + " data!",
               "ARE YOU SURE?",
               0,
               2,
               null,
               new Object[]{"Save", "Cancel"},
               "Cancel"
            );
            if (choiceLoad != 0) {
               return false;
            }
         }

         SortedMap<Integer, ArrayList<CachedObject>> cachedObjectsSorted = new TreeMap<>(underland ? this.cachedUnderObjects : this.cachedObjects);
         int previousObjectId = -1;
         int objectIdIncrement = 0;
         OutputStream output = new OutputStream();
         if (cachedObjectsSorted.isEmpty()) {
            Logger.getLogger("global").log(Level.SEVERE, "EMPTY OBJECTS HASHMAP, WOULD'VE IMPROPERLY PACKED TO CACHE!!!");
            return false;
         } else {
            for(Entry<Integer, ArrayList<CachedObject>> pair : cachedObjectsSorted.entrySet()) {
               int id = pair.getKey();
               ArrayList<CachedObject> objects = pair.getValue();
               objectIdIncrement = id - previousObjectId;
               previousObjectId = id;
               output.writeSmart2(objectIdIncrement);
               if (objects.size() > 1) {
                  Collections.sort(objects, new Comparator<CachedObject>() {
                     public int compare(CachedObject o1, CachedObject o2) {
                        if (o1.getPositionHash() == o2.getPositionHash()) {
                           return 0;
                        } else {
                           return o1.getPositionHash() < o2.getPositionHash() ? -1 : 1;
                        }
                     }
                  });
               }

               int previousPositionHash = 0;

               for(int i = 0; i < objects.size(); ++i) {
                  CachedObject object = objects.get(i);
                  int positionHash = object.getPositionHash();
                  int positionIncrement = positionHash - previousPositionHash + 1;
                  previousPositionHash = positionHash;
                  output.writeSmart(positionIncrement);
                  output.writeByte(object.getTypeRotationHash());
               }

               output.writeSmart(0);
            }

            output.writeSmart2(0);

            try {
               byte[] data = new byte[output.getOffset()];
               output.setOffset(0);
               output.getBytes(data, 0, data.length);
               int[] keys = databaseKeys.getKeys(RSMapperClient.regionId);
               if (!underland && keys != null) {
                  boolean packed = Cache.STORE.getIndexes()[5]
                     .putFile(
                        RSMapperClient.landArchiveId,
                        0,
                        2,
                        data,
                        keys,
                        true,
                        true,
                        ("l" + Utils.getLocalX(RSMapperClient.regionId) + "_" + Utils.getLocalY(RSMapperClient.regionId)).toLowerCase().hashCode(),
                        -1
                     );
                  if (packed && Cache.STORE.getIndexes()[5].encryptArchive(RSMapperClient.landArchiveId, keys)) {
                     Set<Integer> set = new HashSet<>(RSMapperClient.decryptedLandFiles);
                     RSMapperClient.decryptedLandFiles.clear();
                     RSMapperClient.decryptedLandFiles.addAll(set);
                     if (RSMapperClient.decryptedLandFiles.contains(RSMapperClient.regionId)) {
                        RSMapperClient.decryptedLandFiles.remove(RSMapperClient.decryptedLandFiles.indexOf(RSMapperClient.regionId));
                     }

                     this.unsavedLandProgress = false;
                     JOptionPane.showMessageDialog(RSMapperClient.client_frame, "Packed land file " + RSMapperClient.landArchiveId, "SUCCESS", 1);
                     return true;
                  }
               } else {
                  boolean packed = Cache.STORE.getIndexes()[5].putFile(underland ? RSMapperClient.underlandArchiveId : RSMapperClient.landArchiveId, 0, data);
                  if (packed) {
                     if (underland) {
                        this.unsavedUnderlandProgress = false;
                     } else {
                        this.unsavedLandProgress = false;
                     }

                     RSMapperClient.project.setDateModified();
                     HomeMenu.writeProjectInfo(RSMapperClient.project.name, RSMapperClient.project);
                     JOptionPane.showMessageDialog(
                        RSMapperClient.client_frame,
                        "Packed " + (underland ? "under" : "") + "land file " + (underland ? RSMapperClient.underlandArchiveId : RSMapperClient.landArchiveId),
                        "SUCCESS",
                        1
                     );
                     return true;
                  }
               }
            } catch (Exception var15) {
               var15.printStackTrace();
               JOptionPane.showMessageDialog(RSMapperClient.client_frame, "(1) Failed to pack " + (underland ? "under" : "") + "land file!", "ERROR", 0);
            }

            return false;
         }
      }
   }

   // $VF: Could not inline inconsistent finally blocks
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public void exportFile(int regionId, boolean compiled, boolean underland) throws Throwable {
      int landArchive = Cache.STORE.getIndexes()[5].getArchiveId("l" + Utils.getLocalX(regionId) + "_" + Utils.getLocalY(regionId));
      int underlandArchive = Cache.STORE.getIndexes()[5].getArchiveId("ul" + Utils.getLocalX(regionId) + "_" + Utils.getLocalY(regionId));
      if (!underland && landArchive == -1) {
         JOptionPane.showMessageDialog(RSMapperClient.client_frame, "No land file exists", "ERROR", 0);
      } else if (underland && underlandArchive == -1) {
         JOptionPane.showMessageDialog(RSMapperClient.client_frame, "No underland file exists", "ERROR", 0);
      } else if (regionId != RSMapperClient.regionId || underland || this.cachedObjects != null) {
         if (regionId != RSMapperClient.regionId || !underland || this.cachedUnderObjects != null) {
            File file = null;
            file = new File("data/projects/" + RSMapperClient.project.name + "/exports/" + regionId + "/");
            if (!file.exists()) {
               file.mkdirs();
            }

            file = new File(file.toString() + "/" + (underland ? underlandArchive + "_underland" : landArchive + "_land") + (compiled ? "" : "(s).txt"));
            int[] keys = null;
            if (!underland) {
               keys = databaseKeys.getKeys(regionId);
               if (RSMapperClient.decryptedLandFiles.contains(regionId)) {
                  System.out.println("Contains, so null keys");
                  keys = null;
               }

               Set<Integer> set = new HashSet<>(RSMapperClient.decryptedLandFiles);
               set.add(regionId);
               RSMapperClient.decryptedLandFiles.clear();
               RSMapperClient.decryptedLandFiles.addAll(set);
            }

            if (compiled) {
               byte[] data = Cache.STORE.getIndexes()[5].getFile(underland ? underlandArchive : landArchive, 0, keys);

               try {
                  Throwable e = null;
                  Object writer = null;

                  try {
                     FileOutputStream fos = new FileOutputStream(file);

                     try {
                        fos.write(data);
                        fos.close();
                        JOptionPane.showMessageDialog(
                           RSMapperClient.client_frame,
                           "Compiled " + (underland ? "under" : "") + "land file " + (underland ? underlandArchive : landArchive) + " to " + file.toString(),
                           "SUCCESS",
                           1
                        );
                     } finally {
                        if (fos != null) {
                           fos.close();
                        }
                     }
                  } catch (Throwable var43) {
                     if (e == null) {
                        e = var43;
                     } else if (e != var43) {
                        e.addSuppressed(var43);
                     }

                     throw e;
                  }
               } catch (Exception var44) {
                  var44.printStackTrace();
               }
            } else {
               try {
                  Throwable var51 = null;
                  Object var52 = null;

                  try {
                     FileWriter writer = new FileWriter(file);

                     try {
                        byte[] da = Cache.STORE.getIndexes()[5].getFile(underland ? underlandArchive : landArchive, 0, keys);
                        InputStream buffer = new InputStream(da);
                        int objectId = -1;

                        while(true) {
                           int objectIdIncrement = buffer.readSmart2();
                           objectId += objectIdIncrement;
                           writer.write(
                              "SMART2:" + objectIdIncrement + " - OBJECT ID:" + (objectIdIncrement == 0 ? "-1" : objectId) + "\n"
                           );
                           if (objectIdIncrement == 0) {
                              writer.close();
                              break;
                           }

                           int positionHash = 0;

                           while(true) {
                              int positionIncrement = buffer.readUnsignedSmart();
                              writer.write(
                                 "SMART:"
                                    + positionIncrement
                                    + " - COORDS:("
                                    + (
                                       positionIncrement == 0
                                          ? "-1,-1,-1)"
                                          : ((positionHash + positionIncrement - 1 & 4086) >> 6)
                                             + Utils.getRegionCoordX(regionId)
                                             + ","
                                             + ((positionHash + positionIncrement - 1 & 63) + Utils.getRegionCoordY(regionId))
                                             + ","
                                             + (positionHash + positionIncrement - 1 >> 12)
                                             + ")"
                                             + " - OBJ:"
                                             + (positionIncrement == 0 ? "-1" : objectId)
                                    )
                                    + "\n"
                              );
                              if (positionIncrement == 0) {
                                 break;
                              }

                              positionHash += positionIncrement - 1;
                              int typeRotation = buffer.readUnsignedByte();
                              writer.write("BYTE:" + typeRotation + "\n");
                           }
                        }
                     } finally {
                        if (writer != null) {
                           writer.close();
                        }
                     }
                  } catch (Throwable var46) {
                     if (var51 == null) {
                        var51 = var46;
                     } else if (var51 != var46) {
                        var51.addSuppressed(var46);
                     }

                     throw var51;
                  }
               } catch (Exception var47) {
                  var47.printStackTrace();
               }
            }
         }
      }
   }

   public void openModelViewer() {
      ExternalInterfaceLoader.openInterface("ModelViewer", 2);
      int interfaceId = ExternalInterfaceLoader.getInterfaceId("ModelViewer");
      ClientScriptsExecutor.runExternalInterfaceScript(new Object[]{10002, interfaceId << 16 | 3, interfaceId << 16 | 9, interfaceId << 16 | 10, 0, 1909});
      ClientScriptsExecutor.runExternalInterfaceScript(new Object[]{10002, interfaceId << 16 | 3, interfaceId << 16 | 11, interfaceId << 16 | 12, 2, 1908});
      ClientScriptsExecutor.runExternalInterfaceScript(new Object[]{10002, interfaceId << 16 | 3, interfaceId << 16 | 4, interfaceId << 16 | 5, 1, 1910});
      ClientScriptsExecutor.runExternalInterfaceScript(new Object[]{10002, interfaceId << 16 | 3, interfaceId << 16 | 7, interfaceId << 16 | 8, 3, 1911});
      this.VIEWER_OPEN = true;
      RSMapperClient.setFocusOnCanvas();
   }

   public void displayObjectOnModelViewer(int objectId, int type) {
      if (objectId >= 0 && objectId <= 65534 && type >= 0 && type <= 22 && (!this.VIEWER_OPEN || this.viewingObject != objectId)) {
         if (!this.VIEWER_OPEN) {
            this.openModelViewer();
         }

         ClientScriptsExecutor.runExternalInterfaceScript(new Object[]{10001, ExternalInterfaceLoader.getInterfaceId("ModelViewer") << 16 | 3, objectId, type});
         this.viewingObject = objectId;
      }
   }
}
