import com.alex.io.InputStream;
import com.alex.store.ArchiveReference;
import com.alex.store.FileReference;
import com.rs.cache.Cache;
import com.rs.cache.io.OutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

public class WorldmapEditor {
   int regionId;
   String details_archiveName;
   int details_archiveId;
   int details_fileId;
   int area_archiveId;
   int area_fileId;
   int regionXWorldCoordinate = 0;
   int regionYWorldCoordinate = 0;
   int totalXTiles = 0;
   int totalYTiles = 0;

   public void load(int regionId) {
      this.regionId = regionId;
      this.details_archiveId = Cache.getStore().getIndexes()[23].getArchiveId("details");
      byte[] data = getFile(this.details_archiveId, 0);
      if (data != null) {
         int validFiles = Cache.getStore().getIndexes()[23].getValidFilesCount(this.details_archiveId);

         for(int i = 0; i < validFiles; ++i) {
            InputStream buffer = new InputStream(getFile(this.details_archiveId, i));
            String archivename = buffer.readString();
            buffer.readString();
            buffer.readInt();
            buffer.readInt();
            buffer.readUnsignedByte();
            buffer.readUnsignedByte();
            buffer.readUnsignedByte();
            int areas = buffer.readUnsignedByte();

            for(int area = 0; area < areas; ++area) {
               int plane = buffer.readUnsignedByte();
               int minX = buffer.readUnsignedShort();
               int minY = buffer.readUnsignedShort();
               int maxX = buffer.readUnsignedShort();
               int maxY = buffer.readUnsignedShort();
               boolean found = false;

               for(int x = minX; x < maxX; ++x) {
                  for(int y = minY; y < maxY; ++y) {
                     if (Utils.getRegionId(x, y) == regionId && plane == (Class295.myPlayer == null ? 0 : Class295.myPlayer.plane)) {
                        this.details_fileId = i;
                        int ar = 0;

                        ArchiveReference[] var21;
                        for(ArchiveReference a : var21 = Cache.getStore().getIndexes()[23].getTable().getArchives()) {
                           if (Cache.getStore().getIndexes()[23].archiveExists(ar) && a.getNameHash() == archivename.hashCode()) {
                              this.area_archiveId = ar;
                           }

                           ++ar;
                        }

                        int fi = 0;

                        FileReference[] var22;
                        for(FileReference f : var22 = Cache.getStore().getIndexes()[23].getTable().getArchives()[this.area_archiveId].getFiles()) {
                           if (Cache.getStore().getIndexes()[23].fileExists(this.area_archiveId, fi) && f.getNameHash() == "area".hashCode()) {
                              this.area_fileId = fi;
                           }

                           ++fi;
                        }

                        found = true;
                        break;
                     }
                  }

                  if (found) {
                     break;
                  }
               }

               minX = buffer.readUnsignedShort();
               minY = buffer.readUnsignedShort();
               maxX = buffer.readUnsignedShort();
               maxY = buffer.readUnsignedShort();
               if (!found) {
                  for(int x = minX; x < maxX; ++x) {
                     for(int y = minY; y < maxY; ++y) {
                        if (Utils.getRegionId(x, y) == regionId && plane == (Class295.myPlayer == null ? 0 : Class295.myPlayer.plane)) {
                           this.details_fileId = i;
                           int ar = 0;

                           ArchiveReference[] var47;
                           for(ArchiveReference a : var47 = Cache.getStore().getIndexes()[23].getTable().getArchives()) {
                              if (Cache.getStore().getIndexes()[23].archiveExists(ar) && a.getNameHash() == archivename.hashCode()) {
                                 this.area_archiveId = ar;
                                 break;
                              }

                              ++ar;
                           }

                           int fi = 0;

                           FileReference[] var49;
                           for(FileReference f : var49 = Cache.getStore().getIndexes()[23].getTable().getArchives()[this.area_archiveId].getFiles()) {
                              if (Cache.getStore().getIndexes()[23].fileExists(this.area_archiveId, fi) && f.getNameHash() == "area".hashCode()) {
                                 this.area_fileId = fi;
                                 break;
                              }

                              ++fi;
                           }

                           found = true;
                           break;
                        }
                     }

                     if (found) {
                        break;
                     }
                  }
               }
            }
         }

         int minimumX = 12800;
         int minimumY = 12800;
         int maximumX = 0;
         int maximumY = 0;
         ArrayList<WorldTile[]> bounds = (ArrayList)this.getDetailsAttribute("bounds");
         if (bounds != null) {
            Iterator<WorldTile[]> it = bounds.iterator();

            while(it.hasNext()) {
               it.next();
               WorldTile[] b = (WorldTile[])it.next();
               if (b[0].getY() < minimumY) {
                  minimumY = b[0].getY();
               }

               if (b[0].getX() < minimumX) {
                  minimumX = b[0].getX();
               }

               if (b[1].getX() > maximumX) {
                  maximumX = b[1].getX();
               }

               if (b[1].getY() > maximumY) {
                  maximumY = b[1].getY();
               }
            }

            this.regionXWorldCoordinate = minimumX >> 6 << 6;
            this.regionYWorldCoordinate = minimumY >> 6 << 6;
            this.totalXTiles = (maximumX >> 6 << 6) - (this.regionXWorldCoordinate - 64);
            this.totalYTiles = 64 + -this.regionYWorldCoordinate + (maximumY >> 6 << 6);
         }
      }
   }

   public static byte[] getFile(int archiveId, int fileId) {
      return Cache.getStore().getIndexes()[23].getFile(archiveId, fileId);
   }

   public Object getDetailsAttribute(String attribute) {
      byte[] data = getFile(this.details_archiveId, this.details_fileId);
      ArrayList<WorldTile[]> bounds = new ArrayList<>();
      if (data != null) {
         InputStream buffer = new InputStream(data);
         String archivename = buffer.readString();
         String displayName = buffer.readString();
         int center = buffer.readInt();
         int emptySpace = buffer.readInt();
         boolean accessibleLinks = buffer.readUnsignedByte() == 1;
         int zoom = buffer.readUnsignedByte();
         int unknown = buffer.readUnsignedByte();
         int planes = buffer.readUnsignedByte();

         for(int i = 0; i < planes; ++i) {
            int plane = buffer.readUnsignedByte();
            int minX = buffer.readUnsignedShort();
            int minY = buffer.readUnsignedShort();
            int maxX = buffer.readUnsignedShort();
            int maxY = buffer.readUnsignedShort();
            bounds.add(new WorldTile[]{new WorldTile(minX, minY, plane, false), new WorldTile(maxX, maxY, plane, false)});
            minX = buffer.readUnsignedShort();
            minY = buffer.readUnsignedShort();
            maxX = buffer.readUnsignedShort();
            maxY = buffer.readUnsignedShort();
            bounds.add(new WorldTile[]{new WorldTile(minX, minY, plane, false), new WorldTile(maxX, maxY, plane, false)});
         }

         if (attribute.equalsIgnoreCase("archivename")) {
            return archivename;
         }

         if (attribute.equalsIgnoreCase("displayname")) {
            return displayName;
         }

         if (attribute.equalsIgnoreCase("center")) {
            return center;
         }

         if (attribute.equalsIgnoreCase("emptycolor")) {
            return emptySpace;
         }

         if (attribute.equalsIgnoreCase("accessible")) {
            return accessibleLinks ? 1 : 0;
         }

         if (attribute.equalsIgnoreCase("zoom")) {
            return zoom;
         }

         if (attribute.equalsIgnoreCase("unknown")) {
            return unknown;
         }

         if (attribute.equalsIgnoreCase("bounds")) {
            return bounds;
         }
      }

      return "null";
   }

   public byte[] getAreaFileData() {
      return Cache.getStore().getIndexes()[23].getFile(this.area_archiveId, this.area_fileId);
   }

   public void packToCache(String type) {
      if (!type.equalsIgnoreCase("details") && type.equalsIgnoreCase("area")) {
         byte[] oldData = getFile(this.area_archiveId, this.area_fileId);
         if (oldData == null) {
            JOptionPane.showMessageDialog(null, "No area file exists", "ERROR", 0);
            return;
         }

         InputStream is = new InputStream(oldData);
         OutputStream output = new OutputStream();
         int underlayPaletteSize = is.readUnsignedByte();
         output.writeByte(underlayPaletteSize);
         int[] underlayPalette = new int[underlayPaletteSize];

         for(int i_182_ = 0; i_182_ < underlayPaletteSize; ++i_182_) {
            underlayPalette[i_182_] = is.readUnsignedByte();
            output.writeByte(underlayPalette[i_182_]);
         }

         int overlayPaletteSize = is.readUnsignedByte();
         output.writeByte(overlayPaletteSize);
         int[] overlayPalette = new int[overlayPaletteSize];

         for(int i_185_ = 0; i_185_ < overlayPaletteSize; ++i_185_) {
            overlayPalette[i_185_] = is.readUnsignedByte();
            output.writeByte(overlayPalette[i_185_]);
         }

         while(is.getOffset() < is.getBuffer().length) {
            int condition = is.readUnsignedByte();
            output.writeByte(condition);
            int regionLocalX = is.readUnsignedByte();
            int regionLocalY = is.readUnsignedByte();
            output.writeByte(regionLocalX);
            output.writeByte(regionLocalY);
            int i_194_ = 0;
            int i_195_ = 0;
            if (condition != 0) {
               i_194_ = is.readUnsignedByte();
               i_195_ = is.readUnsignedByte();
               output.writeByte(i_194_);
               output.writeByte(i_195_);
            }

            for(int localX = 0; localX < (condition == 0 ? 64 : 8); ++localX) {
               for(int localY = 0; localY < (condition == 0 ? 64 : 8); ++localY) {
                  int xWorldCoordinate = condition == 0 ? regionLocalX * 64 + localX : regionLocalX * 64 + i_194_ * 8 + localX;
                  int yWorldCoordinate = condition == 0 ? regionLocalY * 64 + localY : regionLocalY * 64 + i_195_ * 8 + localY;
                  int tileOnX = xWorldCoordinate - this.regionXWorldCoordinate;
                  int tileOnY = yWorldCoordinate - this.regionYWorldCoordinate;
                  if (this.regionXWorldCoordinate + tileOnX >= Utils.getRegionCoordX(this.regionId)
                     && this.regionXWorldCoordinate + tileOnX < Utils.getRegionCoordX(this.regionId) + 64
                     && this.regionYWorldCoordinate + tileOnY >= Utils.getRegionCoordY(this.regionId)
                     && this.regionYWorldCoordinate + tileOnY < Utils.getRegionCoordY(this.regionId) + 64) {
                     int mask = is.readUnsignedByte();
                     if ((mask & 1) == 0) {
                        boolean setUnderlay = (mask & 2) == 0;
                        int textureId = mask >> 2 & 63;
                        if (textureId != 62) {
                           if (textureId == 63) {
                              is.readUnsignedByte();
                           }

                           if (!setUnderlay) {
                              is.readByte();
                           }
                        }
                     } else {
                        int numIterations = (mask >> 1 & 3) + 1;
                        boolean setOverlay = (mask & 8) != 0;
                        boolean hasObjects = (mask & 16) != 0;

                        for(int iteration = 0; iteration < numIterations; ++iteration) {
                           is.readUnsignedByte();
                           if (setOverlay) {
                              is.readUnsignedByte();
                              is.readUnsignedByte();
                           }

                           int numObjects = 0;
                           if (hasObjects) {
                              numObjects = is.readUnsignedByte();
                           }

                           if (iteration == 0) {
                              if (numObjects == 1) {
                                 is.readUnsignedShort();
                                 is.readByte();
                              } else if (numObjects > 1) {
                                 for(int i_167_ = 0; i_167_ < numObjects; ++i_167_) {
                                    is.readUnsignedShort();
                                    is.readByte();
                                 }
                              }
                           } else if (numObjects > 0) {
                              for(int i_168_ = 0; i_168_ < numObjects; ++i_168_) {
                                 is.readUnsignedShort();
                                 is.readByte();
                              }
                           }
                        }
                     }

                     int lx = Utils.getLocalXFromCoordX(this.regionXWorldCoordinate + tileOnX, RSMapperClient.regionId);
                     int ly = Utils.getLocalYFromCoordY(this.regionYWorldCoordinate + tileOnY, RSMapperClient.regionId);
                     int plane = 0;
                     if ((RSMapperClient.editor.mapEditor.flags[1][lx][ly] & 2) == 2 || (RSMapperClient.editor.mapEditor.flags[1][lx][ly] & 8) == 8) {
                        ++plane;
                     }

                     int overlayOnTile = RSMapperClient.editor.mapEditor.overlays[plane][lx][ly];
                     int underlayOnTile = RSMapperClient.editor.mapEditor.underlays[plane][lx][ly];
                     int shapeOnTile = RSMapperClient.editor.mapEditor.shapes[plane][lx][ly];
                     int rotationOnTile = RSMapperClient.editor.mapEditor.rotations[plane][lx][ly];
                     int sr = WorldmapDefinitions.findByteForShapeRotation(shapeOnTile, rotationOnTile);
                     if (plane > 0) {
                        int overlayOnBottomTile = RSMapperClient.editor.mapEditor.overlays[plane - 1][lx][ly];
                        int underlayOnBottomTile = RSMapperClient.editor.mapEditor.underlays[plane - 1][lx][ly];
                        int shapeOnBottomTile = RSMapperClient.editor.mapEditor.shapes[plane - 1][lx][ly];
                        int rotationOnBottomTile = RSMapperClient.editor.mapEditor.rotations[plane - 1][lx][ly];
                        if ((RSMapperClient.editor.mapEditor.flags[1][lx][ly] & 2) != 2) {
                           if (overlayOnBottomTile != 0 && overlayOnBottomTile != 42) {
                              overlayOnTile = (byte)overlayOnBottomTile;
                           } else if (overlayOnTile == 0 || overlayOnTile == 42) {
                              overlayOnTile = 0;
                              underlayOnTile = (byte)underlayOnBottomTile;
                           }
                        } else if (overlayOnTile == 0 || overlayOnTile == 42) {
                           overlayOnTile = 0;
                           underlayOnTile = (byte)underlayOnBottomTile;
                        }

                        if (underlayOnBottomTile != 0) {
                           underlayOnTile = (byte)underlayOnBottomTile;
                        }

                        if ((RSMapperClient.editor.mapEditor.flags[1][lx][ly] & 2) != 2 && shapeOnBottomTile != 0 && shapeOnBottomTile != 12) {
                           sr = WorldmapDefinitions.findByteForShapeRotation(shapeOnBottomTile, rotationOnBottomTile);
                        }
                     }

                     int overlay = (byte)overlayOnTile;
                     int underlay = (byte)underlayOnTile;
                     int[][] objs = RSMapperClient.editor
                        .objectEditor
                        .getObjectsOnTile(
                           new WorldTile(
                              this.regionXWorldCoordinate + tileOnX,
                              this.regionYWorldCoordinate + tileOnY,
                              (RSMapperClient.editor.mapEditor.flags[1][lx][ly] & 8) == 8 ? plane - 1 : plane,
                              false
                           ),
                           false
                        );
                     int count = 0;

                     for(int[] obj : objs) {
                        if (obj[0] > 0) {
                           ++count;
                        }
                     }

                     if (count == 0) {
                        output.writeByte(9);
                        output.writeByte(underlay);
                        output.writeByte(overlay);
                        output.writeByte(sr);
                     } else if (count == 1) {
                        output.writeByte(25);
                        output.writeByte(underlay);
                        output.writeByte(overlay);
                        output.writeByte(sr);
                        output.writeByte(count);

                        for(int[] obj : objs) {
                           if (obj[0] > 0) {
                              output.writeShort(obj[0]);
                              output.writeByte(WorldmapDefinitions.findByteForShapeRotation(obj[1], obj[2]));
                              break;
                           }
                        }
                     } else if (count > 1) {
                        output.writeByte(25);
                        output.writeByte(underlay);
                        output.writeByte(overlay);
                        output.writeByte(sr);
                        output.writeByte(count);

                        for(int[] obj : objs) {
                           if (obj[0] > 0) {
                              output.writeShort(obj[0]);
                              output.writeByte(WorldmapDefinitions.findByteForShapeRotation(obj[1], obj[2]));
                           }
                        }
                     }
                  } else {
                     int i_158_ = is.readUnsignedByte();
                     output.writeByte(i_158_);
                     if ((i_158_ & 1) == 0) {
                        boolean bool = (i_158_ & 2) == 0;
                        int i_159_ = i_158_ >> 2 & 63;
                        if (i_159_ != 62) {
                           if (i_159_ == 63) {
                              i_159_ = is.readUnsignedByte();
                              output.writeByte(i_159_);
                           }

                           if (!bool) {
                              output.writeByte(is.readByte());
                           }
                        }
                     } else {
                        int i_160_ = (i_158_ >> 1 & 3) + 1;
                        boolean bool = (i_158_ & 8) != 0;
                        boolean hasObjects = (i_158_ & 16) != 0;

                        for(int i_162_ = 0; i_162_ < i_160_; ++i_162_) {
                           output.writeByte(is.readUnsignedByte());
                           if (bool) {
                              output.writeByte(is.readUnsignedByte());
                              output.writeByte(is.readUnsignedByte());
                           }

                           int numObjects = 0;
                           if (hasObjects) {
                              numObjects = is.readUnsignedByte();
                              output.writeByte(numObjects);
                           }

                           if (i_162_ == 0) {
                              if (numObjects == 1) {
                                 output.writeShort(is.readUnsignedShort());
                                 output.writeByte(is.readByte());
                              } else if (numObjects > 1) {
                                 for(int i_167_ = 0; i_167_ < numObjects; ++i_167_) {
                                    output.writeShort(is.readUnsignedShort());
                                    output.writeByte(is.readByte());
                                 }
                              }
                           } else if (numObjects > 0) {
                              for(int i_168_ = 0; i_168_ < numObjects; ++i_168_) {
                                 output.writeShort(is.readUnsignedShort());
                                 output.writeByte(is.readByte());
                              }
                           }
                        }
                     }
                  }
               }
            }
         }

         try {
            byte[] data = new byte[output.getOffset()];
            output.setOffset(0);
            output.getBytes(data, 0, data.length);
            RSMapperClient.project.setDateModified();
            HomeMenu.writeProjectInfo(RSMapperClient.project.name, RSMapperClient.project);
            Cache.STORE.getIndexes()[23].putFile(this.area_archiveId, this.area_fileId, data);
            System.out.println("Packed worldmap area file " + this.area_archiveId + "_" + this.area_fileId);
         } catch (Exception var37) {
            var37.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to pack worldmap area file " + this.area_archiveId + "_" + this.area_fileId, "ERROR", 0);
            return;
         }
      }
   }

   // $VF: Could not inline inconsistent finally blocks
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public void export(String type, boolean compiled) {
      if (type.equalsIgnoreCase("details")) {
         byte[] data = getFile(this.details_archiveId, this.details_fileId);
         if (data == null) {
            JOptionPane.showMessageDialog(null, "No details file exists", "ERROR", 0);
            return;
         }

         File file = null;
         file = new File("data/projects/" + RSMapperClient.project.name + "/exports/" + RSMapperClient.regionId + "/");
         if (!file.exists()) {
            file.mkdirs();
         }

         file = new File(file.toString() + "/" + this.details_archiveId + "_" + this.details_fileId + "_details" + (compiled ? "" : "(s).txt"));
         if (compiled) {
            try {
               Throwable e = null;
               Object var6 = null;

               try {
                  FileOutputStream fos = new FileOutputStream(file);

                  try {
                     fos.write(data);
                     fos.close();
                     JOptionPane.showMessageDialog(
                        null, "Compiled worldmap details file " + this.details_archiveId + "_" + this.details_fileId + " to " + file.toString(), "SUCCESS", 1
                     );
                  } finally {
                     if (fos != null) {
                        fos.close();
                     }
                  }
               } catch (Throwable var141) {
                  if (e == null) {
                     e = var141;
                  } else if (e != var141) {
                     e.addSuppressed(var141);
                  }

                  throw e;
               }
            } catch (Throwable var142) {
               var142.printStackTrace();
            }
         } else {
            try {
               Throwable var152 = null;
               Object var155 = null;

               try {
                  FileWriter writer = new FileWriter(file);

                  try {
                     InputStream buffer = new InputStream(data);
                     String archivename = buffer.readString();
                     writer.write("Area Archive Name: " + archivename + "\n");
                     String displayName = buffer.readString();
                     writer.write("Area Display Name: " + displayName + "\n");
                     int center = buffer.readInt();
                     writer.write("Center Location Hash: " + center + " (" + (center >> 14 & 16383) + ", " + (center & 16383) + ")\n");
                     int emptySpace = buffer.readInt();
                     writer.write("Empty Space: " + emptySpace + "\n");
                     boolean accessibleLinks = buffer.readUnsignedByte() == 1;
                     writer.write("Accessible Links: " + accessibleLinks + "\n");
                     int zoom = buffer.readUnsignedByte();
                     writer.write("Zoom on Load: " + zoom + "\n");
                     int unknown = buffer.readUnsignedByte();
                     writer.write("Unknown: " + unknown + "\n");
                     int planes = buffer.readUnsignedByte();
                     writer.write("Planes: " + planes + "\n");
                     writer.write("for(int i = 0; i < planes; i++) { \n");

                     for(int i = 0; i < planes; ++i) {
                        writer.write("\ti: " + i + "\n");
                        int plane = buffer.readUnsignedByte();
                        int minX = buffer.readUnsignedShort();
                        int minY = buffer.readUnsignedShort();
                        int maxX = buffer.readUnsignedShort();
                        int maxY = buffer.readUnsignedShort();
                        writer.write("\tplane[B]: " + plane + "\n");
                        writer.write("\tbottom X,Y[S][S]: (" + minX + ", " + minY + ")\n");
                        writer.write("\ttop X,Y[S][S]: (" + maxX + ", " + maxY + ")\n");
                        minX = buffer.readUnsignedShort();
                        minY = buffer.readUnsignedShort();
                        maxX = buffer.readUnsignedShort();
                        maxY = buffer.readUnsignedShort();
                        writer.write("\tbest bottom X,Y[S][S]: (" + minX + ", " + minY + ")\n");
                        writer.write("\tbest top X,Y[S][S]: (" + maxX + ", " + maxY + ")\n");
                        writer.write("\t---------------------\n");
                     }

                     writer.write("}\n");
                     writer.close();
                     JOptionPane.showMessageDialog(
                        null,
                        "Wrote worldmap details source file " + this.details_archiveId + "_" + this.details_fileId + " to " + file.toString(),
                        "SUCCESS",
                        1
                     );
                  } finally {
                     if (writer != null) {
                        writer.close();
                     }
                  }
               } catch (Throwable var144) {
                  if (var152 == null) {
                     var152 = var144;
                  } else if (var152 != var144) {
                     var152.addSuppressed(var144);
                  }

                  throw var152;
               }
            } catch (Throwable var145) {
               var145.printStackTrace();
            }
         }
      } else if (type.equalsIgnoreCase("area")) {
         byte[] data = getFile(this.area_archiveId, this.area_fileId);
         if (data == null) {
            JOptionPane.showMessageDialog(null, "No area file exists", "ERROR", 0);
            return;
         }

         File file = null;
         file = new File("data/projects/" + RSMapperClient.project.name + "/exports/" + RSMapperClient.regionId + "/");
         if (!file.exists()) {
            file.mkdirs();
         }

         file = new File(file.toString() + "/" + this.area_archiveId + "_" + this.area_fileId + "_area" + (compiled ? "" : "(s).txt"));
         if (compiled) {
            try {
               Throwable var153 = null;
               Object var156 = null;

               try {
                  FileOutputStream fos = new FileOutputStream(file);

                  try {
                     fos.write(data);
                     fos.close();
                     JOptionPane.showMessageDialog(
                        null, "Compiled worldmap area file " + this.area_archiveId + "_" + this.area_fileId + " to " + file.toString(), "SUCCESS", 1
                     );
                  } finally {
                     if (fos != null) {
                        fos.close();
                     }
                  }
               } catch (Throwable var138) {
                  if (var153 == null) {
                     var153 = var138;
                  } else if (var153 != var138) {
                     var153.addSuppressed(var138);
                  }

                  throw var153;
               }
            } catch (Throwable var139) {
               var139.printStackTrace();
            }
         } else {
            try {
               Throwable var154 = null;
               Object var157 = null;

               try {
                  FileWriter writer = new FileWriter(file);

                  try {
                     InputStream buffer = new InputStream(data);
                     int underlayPaletteSize = buffer.readUnsignedByte();
                     writer.write("[B]underlayPaletteSize: " + underlayPaletteSize + "\n");
                     int[] underlayPalette = new int[underlayPaletteSize];
                     writer.write("for(int i = 0; i < underlayPaletteSize; i++) { \n");

                     for(int i_182_ = 0; i_182_ < underlayPaletteSize; ++i_182_) {
                        underlayPalette[i_182_] = buffer.readUnsignedByte();
                        writer.write("[B]underlayPalette[" + i_182_ + "]: " + underlayPalette[i_182_] + "\n");
                     }

                     writer.write("}\n");
                     int overlayPaletteSize = buffer.readUnsignedByte();
                     writer.write("[B]overlayPaletteSize: " + overlayPaletteSize + "\n");
                     int[] overlayPalette = new int[overlayPaletteSize];
                     writer.write("for(int i = 0; i < overlayPalette; i++) { \n");

                     for(int i_185_ = 0; i_185_ < overlayPaletteSize; ++i_185_) {
                        overlayPalette[i_185_] = buffer.readUnsignedByte();
                        writer.write("[B]overlayPalette[" + i_185_ + "]: " + overlayPalette[i_185_] + "\n");
                     }

                     writer.write("}\n");
                     writer.write("While offset is less than length of file: decode terrain and objects--->\n");

                     for(int iters = 0; buffer.getOffset() < buffer.getBuffer().length; ++iters) {
                        writer.write("While loop iteration #: " + iters + "\n");
                        int condition = buffer.readUnsignedByte();
                        writer.write("[B]Condition: " + condition + " (" + (condition == 0 ? "by tile" : "by chunk") + ")\n");
                        int regionLocalX = buffer.readUnsignedByte();
                        int regionLocalY = buffer.readUnsignedByte();
                        writer.write("[B][B]Region Local Coords: (" + regionLocalX + ", " + regionLocalY + ")\n");
                        int i_194_ = 0;
                        int i_195_ = 0;
                        if (condition != 0) {
                           i_194_ = buffer.readUnsignedByte();
                           i_195_ = buffer.readUnsignedByte();
                           writer.write("CONDITION IS 0: [B][B]Chunk Coords: (" + i_194_ + ", " + i_195_ + ")\n");
                        }

                        for(int localX = 0; localX < (condition == 0 ? 64 : 8); ++localX) {
                           for(int localY = 0; localY < (condition == 0 ? 64 : 8); ++localY) {
                              int xWorldCoordinate = condition == 0 ? regionLocalX * 64 + localX : regionLocalX * 64 + i_194_ * 8 + localX;
                              int yWorldCoordinate = condition == 0 ? regionLocalY * 64 + localY : regionLocalY * 64 + i_195_ * 8 + localY;
                              int tileOnX = xWorldCoordinate - this.regionXWorldCoordinate;
                              int tileOnY = yWorldCoordinate - this.regionYWorldCoordinate;
                              if (this.regionXWorldCoordinate + tileOnX >= Utils.getRegionCoordX(this.regionId)
                                 && this.regionXWorldCoordinate + tileOnX < Utils.getRegionCoordX(this.regionId) + 64
                                 && this.regionYWorldCoordinate + tileOnY >= Utils.getRegionCoordY(this.regionId)
                                 && this.regionYWorldCoordinate + tileOnY < Utils.getRegionCoordY(this.regionId) + 64) {
                                 writer.write(
                                    "########## BEGIN COORDINATE/TILE: tile("
                                       + tileOnX
                                       + ", "
                                       + tileOnY
                                       + ") - coord("
                                       + (this.regionXWorldCoordinate + tileOnX)
                                       + ", "
                                       + (this.regionYWorldCoordinate + tileOnY)
                                       + ") - posHash:"
                                       + (tileOnX + tileOnY * this.totalXTiles)
                                       + "\n"
                                 );
                                 int mask = buffer.readUnsignedByte();
                                 writer.write("[B]mask: " + mask + "\n");
                                 writer.write("(mask & 0x1) == " + (mask & 1) + "\n");
                                 if ((mask & 1) == 0) {
                                    boolean setUnderlay = (mask & 2) == 0;
                                    writer.write("setUnderlay: " + setUnderlay + "\n");
                                    int textureId = mask >> 2 & 63;
                                    writer.write("textureId: " + textureId + "\n");
                                    if (textureId != 62) {
                                       if (textureId == 63) {
                                          textureId = buffer.readUnsignedByte();
                                          writer.write("[B]textureId: " + textureId + " (because original textureId == 63)\n");
                                       } else if (setUnderlay) {
                                          textureId = underlayPalette[textureId];
                                          writer.write("textureId as underlay: " + textureId + " (from underlayPalette, because setUnderlay)\n");
                                       } else {
                                          textureId = overlayPalette[textureId];
                                          writer.write("textureId as overlay: " + textureId + " (from overlayPalette, because !setUnderlay and != 63)\n");
                                       }

                                       int posHash = tileOnX + tileOnY * this.totalXTiles;
                                       if (setUnderlay) {
                                          writer.write("worldmapUnderlays[posHash] = " + textureId + " (textureId, because setUnderlay)\n");
                                          writer.write("worldmapOverlays[posHash] = 0 (because setUnderlay)\n");
                                       } else {
                                          writer.write("worldmapOverlays[posHash] = " + textureId + " (textureId, because !setUnderlay)\n");
                                          writer.write("worldmapShapeAndRotations[posHash] = 0 (because !setUnderlay)\n");
                                          writer.write("[B]worldmapUnderlays[posHash] = " + buffer.readByte() + " (because !setUnderlay)\n");
                                       }
                                    }
                                 } else {
                                    int numIterations = (mask >> 1 & 3) + 1;
                                    writer.write("numIterations: " + numIterations + " ((mask >> 1 & 0x3) + 1)\n");
                                    boolean setOverlay = (mask & 8) != 0;
                                    writer.write("setOverlay: " + setOverlay + " ((mask & 0x8) != 0)\n");
                                    boolean hasObjects = (mask & 16) != 0;
                                    writer.write("hasObjects: " + hasObjects + " ((mask & 0x10) != 0)\n");
                                    writer.write("for(int i = 0; i < numIterations; i++) { \n");

                                    for(int iteration = 0; iteration < numIterations; ++iteration) {
                                       writer.write("\t------------------------iteration: " + iteration + "\n");
                                       int underlay = buffer.readUnsignedByte();
                                       writer.write("\t[B]underlay: " + underlay + "\n");
                                       int overlay = 0;
                                       int shapeRotationHash = 0;
                                       if (setOverlay) {
                                          overlay = buffer.readUnsignedByte();
                                          shapeRotationHash = buffer.readUnsignedByte();
                                          writer.write("\t[B]overlay: " + overlay + " (because setOverlay)\n");
                                          writer.write("\t[B]shapeRotationHash: " + shapeRotationHash + " (because setOverlay)\n");
                                       }

                                       int numObjects = 0;
                                       if (hasObjects) {
                                          numObjects = buffer.readUnsignedByte();
                                          writer.write("\t[B]i_66_: " + numObjects + " (because hasObjects)\n");
                                       }

                                       if (iteration == 0) {
                                          writer.write("\t########## BECAUSE iteration == 0: --> \n");
                                          int posHash = tileOnX + tileOnY * this.totalXTiles;
                                          if (posHash >= 0) {
                                             writer.write("\tworldmapUnderlays[posHash] = " + underlay + " (underlay, because posHash >= 0)\n");
                                             writer.write("\tworldmapOverlays[posHash] = " + overlay + " (overlay, because posHash >= 0)\n");
                                             writer.write(
                                                "\tworldmapShapeAndRotations[posHash] = " + shapeRotationHash + " (shapeRotationHash, because posHash >= 0)\n"
                                             );
                                          }

                                          if (numObjects == 1) {
                                             int objectId = buffer.readUnsignedShort() + 1;
                                             byte typeRotation = (byte)buffer.readByte();
                                             writer.write("\t[S]worldmapObjectIds[posHash] = " + objectId + " (objectId, because numObjects == 1)\n");
                                             writer.write(
                                                "\t[B]worldmapObjectOrientations[posHash] = " + typeRotation + " (typeRotation, because numObjects == 1)\n"
                                             );
                                          } else if (numObjects > 1) {
                                             writer.write("\tworldmapObjectIds[posHash] = -1 (because numObjects > 1)\n");
                                             int[] ses = new int[numObjects];
                                             byte[] bs = new byte[numObjects];
                                             writer.write("\tfor(int i = 0; i < numObjects; i++) { \n");

                                             for(int i_167_ = 0; i_167_ < numObjects; ++i_167_) {
                                                ses[i_167_] = buffer.readUnsignedShort();
                                                bs[i_167_] = (byte)buffer.readByte();
                                                writer.write("\t\t[S]ses[" + i_167_ + "] = " + ses[i_167_] + "\n");
                                                writer.write("\t\t[B]bs[" + i_167_ + "] = " + bs[i_167_] + "\n");
                                             }

                                             writer.write("\t}\n");
                                          }
                                       } else {
                                          writer.write("\t########## BECAUSE iteration NOT EQUAL 0: --> \n");
                                          int[] ses = null;
                                          byte[] bs = null;
                                          if (numObjects > 0) {
                                             ses = new int[numObjects];
                                             bs = new byte[numObjects];
                                             writer.write("\tfor(int i = 0; i < numObjects; i++) { (because numObjects > 0)\n");

                                             for(int i_168_ = 0; i_168_ < numObjects; ++i_168_) {
                                                ses[i_168_] = buffer.readUnsignedShort();
                                                bs[i_168_] = (byte)buffer.readByte();
                                                writer.write("\t\t[S]ses[" + i_168_ + "] = " + ses[i_168_] + "\n");
                                                writer.write("\t\t[B]bs[" + i_168_ + "] = " + bs[i_168_] + "\n");
                                             }

                                             writer.write("\t}\n");
                                          }

                                          if (iteration - 1 >= 0
                                             && regionLocalX - (this.regionXWorldCoordinate >> 6) >= 0
                                             && regionLocalY - (this.regionYWorldCoordinate >> 6) >= 0) {
                                             writer.write(
                                                "HIT LAST CONDITION: iteration = "
                                                   + iteration
                                                   + " - relevant coords("
                                                   + (regionLocalX - (this.regionXWorldCoordinate >> 6))
                                                   + ", "
                                                   + (regionLocalY - (this.regionYWorldCoordinate >> 6))
                                                   + ")\n"
                                             );
                                          }
                                       }
                                    }

                                    writer.write("}\n");
                                 }
                              } else {
                                 int i_158_ = buffer.readUnsignedByte();
                                 if ((i_158_ & 1) == 0) {
                                    boolean bool = (i_158_ & 2) == 0;
                                    int i_159_ = i_158_ >> 2 & 63;
                                    if (i_159_ != 62) {
                                       if (i_159_ == 63) {
                                          i_159_ = buffer.readUnsignedByte();
                                       }

                                       if (!bool) {
                                          buffer.readByte();
                                       }
                                    }
                                 } else {
                                    int i_160_ = (i_158_ >> 1 & 3) + 1;
                                    boolean bool = (i_158_ & 8) != 0;
                                    boolean hasObjects = (i_158_ & 16) != 0;

                                    for(int i_162_ = 0; i_162_ < i_160_; ++i_162_) {
                                       buffer.readUnsignedByte();
                                       if (bool) {
                                          buffer.readUnsignedByte();
                                          buffer.readUnsignedByte();
                                       }

                                       int numObjects = 0;
                                       if (hasObjects) {
                                          numObjects = buffer.readUnsignedByte();
                                       }

                                       if (i_162_ == 0) {
                                          if (numObjects == 1) {
                                             buffer.readUnsignedShort();
                                             buffer.readByte();
                                          } else if (numObjects > 1) {
                                             for(int i_167_ = 0; i_167_ < numObjects; ++i_167_) {
                                                buffer.readUnsignedShort();
                                                buffer.readByte();
                                             }
                                          }
                                       } else if (numObjects > 0) {
                                          for(int i_168_ = 0; i_168_ < numObjects; ++i_168_) {
                                             buffer.readUnsignedShort();
                                             buffer.readByte();
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }

                     writer.write("}\n");
                     writer.close();
                  } finally {
                     if (writer != null) {
                        writer.close();
                     }
                  }
               } catch (Throwable var135) {
                  if (var154 == null) {
                     var154 = var135;
                  } else if (var154 != var135) {
                     var154.addSuppressed(var135);
                  }

                  throw var154;
               }

               JOptionPane.showMessageDialog(
                  null, "Wrote worldmap area source file " + this.area_archiveId + "_" + this.area_fileId + " to " + file.toString(), "SUCCESS", 1
               );
            } catch (Throwable var136) {
               var136.printStackTrace();
            }
         }
      }
   }

   // $VF: Could not inline inconsistent finally blocks
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public void exportConverted(String type) {
      if (!type.equalsIgnoreCase("details") && type.equalsIgnoreCase("area")) {
         byte[] data = getFile(this.area_archiveId, this.area_fileId);
         if (data == null) {
            JOptionPane.showMessageDialog(null, "No area file exists", "ERROR", 0);
            return;
         }

         InputStream is = new InputStream(data);
         OutputStream output = new OutputStream();
         int underlayPaletteSize = is.readUnsignedByte();
         output.writeByte(underlayPaletteSize);
         int[] underlayPalette = new int[underlayPaletteSize];

         for(int i_182_ = 0; i_182_ < underlayPaletteSize; ++i_182_) {
            underlayPalette[i_182_] = is.readUnsignedByte();
            output.writeByte(underlayPalette[i_182_]);
         }

         int overlayPaletteSize = is.readUnsignedByte();
         output.writeByte(overlayPaletteSize);
         int[] overlayPalette = new int[overlayPaletteSize];

         for(int i_185_ = 0; i_185_ < overlayPaletteSize; ++i_185_) {
            overlayPalette[i_185_] = is.readUnsignedByte();
            output.writeByte(overlayPalette[i_185_]);
         }

         while(is.getOffset() < is.getBuffer().length) {
            int condition = is.readUnsignedByte();
            output.writeByte(condition);
            int regionLocalX = is.readUnsignedByte();
            int regionLocalY = is.readUnsignedByte();
            output.writeByte(regionLocalX);
            output.writeByte(regionLocalY);
            int i_194_ = 0;
            int i_195_ = 0;
            if (condition != 0) {
               i_194_ = is.readUnsignedByte();
               i_195_ = is.readUnsignedByte();
               output.writeByte(i_194_);
               output.writeByte(i_195_);
            }

            for(int localX = 0; localX < (condition == 0 ? 64 : 8); ++localX) {
               for(int localY = 0; localY < (condition == 0 ? 64 : 8); ++localY) {
                  int i_158_ = is.readUnsignedByte();
                  output.writeByte(i_158_);
                  if ((i_158_ & 1) == 0) {
                     boolean bool = (i_158_ & 2) == 0;
                     int i_159_ = i_158_ >> 2 & 63;
                     if (i_159_ != 62) {
                        if (i_159_ == 63) {
                           i_159_ = is.readUnsignedByte();
                           output.writeByte(i_159_);
                        }

                        if (!bool) {
                           output.writeByte(is.readByte());
                        }
                     }
                  } else {
                     int i_160_ = (i_158_ >> 1 & 3) + 1;
                     boolean bool = (i_158_ & 8) != 0;
                     boolean hasObjects = (i_158_ & 16) != 0;

                     for(int i_162_ = 0; i_162_ < i_160_; ++i_162_) {
                        output.writeByte(is.readUnsignedByte());
                        if (bool) {
                           output.writeByte(is.readUnsignedByte());
                           output.writeByte(is.readUnsignedByte());
                        }

                        int numObjects = 0;
                        if (hasObjects) {
                           numObjects = is.readUnsignedByte();
                           output.writeByte(numObjects);
                        }

                        if (i_162_ == 0) {
                           if (numObjects == 1) {
                              output.writeBigSmart(is.readUnsignedShort());
                              output.writeByte(is.readByte());
                           } else if (numObjects > 1) {
                              for(int i_167_ = 0; i_167_ < numObjects; ++i_167_) {
                                 output.writeBigSmart(is.readUnsignedShort());
                                 output.writeByte(is.readByte());
                              }
                           }
                        } else if (numObjects > 0) {
                           for(int i_168_ = 0; i_168_ < numObjects; ++i_168_) {
                              output.writeBigSmart(is.readUnsignedShort());
                              output.writeByte(is.readByte());
                           }
                        }
                     }
                  }
               }
            }
         }

         File file = null;
         file = new File("data/projects/" + RSMapperClient.project.name + "/exports/" + RSMapperClient.regionId + "/");
         if (!file.exists()) {
            file.mkdirs();
         }

         file = new File(file.toString() + "/" + this.area_archiveId + "_" + this.area_fileId + "_details_CONVERTED");

         try {
            Throwable var37 = null;
            Object var38 = null;

            try {
               FileOutputStream fos = new FileOutputStream(file);

               try {
                  fos.write(data);
                  fos.close();
                  Node_Sub7.writeToConsole(
                     (byte)43, "Exported converted worldmap details file " + this.area_archiveId + "_" + this.area_fileId + " to " + file.toString()
                  );
               } finally {
                  if (fos != null) {
                     fos.close();
                  }
               }
            } catch (Throwable var30) {
               if (var37 == null) {
                  var37 = var30;
               } else if (var37 != var30) {
                  var37.addSuppressed(var30);
               }

               throw var37;
            }
         } catch (Throwable var31) {
            var31.printStackTrace();
         }
      }
   }
}
