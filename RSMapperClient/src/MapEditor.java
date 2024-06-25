import com.rs.cache.Cache;
import com.rs.cache.io.InputStream;
import com.rs.cache.io.OutputStream;
import java.awt.EventQueue;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class MapEditor {
   boolean unsavedMapProgress;
   boolean unsavedUndermapProgress;
   boolean dataLoaded;
   boolean PACK_MAP;
   boolean PACK_UNDERMAP;
   boolean createdEnvironment;
   boolean previewingEnvironment;
   int[] environmentFlag = new int[2];
   int[] sunDistanceX = new int[2];
   int[] sunDistanceY = new int[2];
   int[] sunDistanceZ = new int[2];
   int[] highlightcolor = new int[2];
   float[] brightness = new float[2];
   float[] vibrance = new float[2];
   float[] blackpoint = new float[2];
   int[] fogcolor = new int[2];
   int[] fogdensity = new int[2];
   int i_7_;
   int i_8_;
   int i_9_;
   int i_10_;
   int i_11_;
   int i_12_;
   int[][][] heights = new int[4][Node_Sub54.GAME_SCENE_WDITH + 1][Class377_Sub1.GAME_SCENE_HEIGHT + 1];
   byte[][][] flags = new byte[4][Node_Sub54.GAME_SCENE_WDITH][Class377_Sub1.GAME_SCENE_HEIGHT];
   byte[][][] rotations = new byte[4][Node_Sub54.GAME_SCENE_WDITH][Class377_Sub1.GAME_SCENE_HEIGHT];
   byte[][][] overlays = new byte[4][Node_Sub54.GAME_SCENE_WDITH][Class377_Sub1.GAME_SCENE_HEIGHT];
   byte[][][] shapes = new byte[4][Node_Sub54.GAME_SCENE_WDITH][Class377_Sub1.GAME_SCENE_HEIGHT];
   byte[][][] underlays = new byte[4][Node_Sub54.GAME_SCENE_WDITH][Class377_Sub1.GAME_SCENE_HEIGHT];
   int[][][] um_heights = new int[1][Node_Sub54.GAME_SCENE_WDITH + 1][Class377_Sub1.GAME_SCENE_HEIGHT + 1];
   byte[][][] um_rotations = new byte[1][Node_Sub54.GAME_SCENE_WDITH][Class377_Sub1.GAME_SCENE_HEIGHT];
   byte[][][] um_overlays = new byte[1][Node_Sub54.GAME_SCENE_WDITH][Class377_Sub1.GAME_SCENE_HEIGHT];
   byte[][][] um_shapes = new byte[1][Node_Sub54.GAME_SCENE_WDITH][Class377_Sub1.GAME_SCENE_HEIGHT];
   byte[][][] um_underlays = new byte[1][Node_Sub54.GAME_SCENE_WDITH][Class377_Sub1.GAME_SCENE_HEIGHT];
   ConcurrentHashMap<WorldTile, CachedEffect> effects = new ConcurrentHashMap<>();

   public MapEditor() {
      this.dataLoaded = false;
      this.unsavedMapProgress = false;
      this.unsavedUndermapProgress = false;
   }

   void populateTable(final WorldTile tile) {
      if (this.dataLoaded) {
         EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
               if (RSMapperClient.editor.tool instanceof DefaultTool) {
                  int height = MapEditor.this.getMapValueFromTile(tile, MapEditor.PropertyType.HEIGHT);
                  ((JTextField)UIPanels.propertyComponents.get("txt_height")).setText("" + height);
                  int tileflag = MapEditor.this.getMapValueFromTile(tile, MapEditor.PropertyType.TILE_FLAG);
                  ((JTextField)UIPanels.propertyComponents.get("txt_tileflag")).setText("" + tileflag);
                  int overlay = MapEditor.this.getMapValueFromTile(tile, MapEditor.PropertyType.OVERLAY);
                  ((JTextField)UIPanels.propertyComponents.get("txt_overlay")).setText("" + overlay);
                  int underlay = MapEditor.this.getMapValueFromTile(tile, MapEditor.PropertyType.UNDERLAY);
                  ((JTextField)UIPanels.propertyComponents.get("txt_underlay")).setText("" + underlay);
                  int shape = MapEditor.this.getMapValueFromTile(tile, MapEditor.PropertyType.SHAPE);
                  ((JTextField)UIPanels.propertyComponents.get("txt_shape")).setText("" + shape);
                  int rotation = MapEditor.this.getMapValueFromTile(tile, MapEditor.PropertyType.ROTATION);
                  ((JTextField)UIPanels.propertyComponents.get("txt_rotation")).setText("" + rotation);
                  if (tile.getPlane() == 0) {
                     height = MapEditor.this.getUndermapValueFromTile(tile, MapEditor.PropertyType.HEIGHT);
                     ((JTextField)UIPanels.propertyComponents.get("txt_uHeight")).setText("" + height);
                     overlay = MapEditor.this.getUndermapValueFromTile(tile, MapEditor.PropertyType.OVERLAY);
                     ((JTextField)UIPanels.propertyComponents.get("txt_uOverlay")).setText("" + overlay);
                     underlay = MapEditor.this.getUndermapValueFromTile(tile, MapEditor.PropertyType.UNDERLAY);
                     ((JTextField)UIPanels.propertyComponents.get("txt_uUnderlay")).setText("" + underlay);
                     shape = MapEditor.this.getUndermapValueFromTile(tile, MapEditor.PropertyType.SHAPE);
                     ((JTextField)UIPanels.propertyComponents.get("txt_uShape")).setText("" + shape);
                     rotation = MapEditor.this.getUndermapValueFromTile(tile, MapEditor.PropertyType.ROTATION);
                     ((JTextField)UIPanels.propertyComponents.get("txt_uRotation")).setText("" + rotation);
                  } else {
                     ((JTextField)UIPanels.propertyComponents.get("txt_uHeight")).setText("0");
                     ((JTextField)UIPanels.propertyComponents.get("txt_uOverlay")).setText("0");
                     ((JTextField)UIPanels.propertyComponents.get("txt_uUnderlay")).setText("0");
                     ((JTextField)UIPanels.propertyComponents.get("txt_uShape")).setText("0");
                     ((JTextField)UIPanels.propertyComponents.get("txt_uRotation")).setText("0");
                  }
               } else if (RSMapperClient.editor.tool instanceof FXTool && ToolData.FXToolEffectOnTile != null) {
                  for(int i = 0; i <= 3; ++i) {
                     ((JCheckBox)UIPanels.propertyComponents.get("chck_plane" + i)).setSelected((ToolData.FXToolEffectOnTile.planeflag & 7) == i);
                  }

                  ((JCheckBox)UIPanels.propertyComponents.get("chck_plane_spread")).setSelected((ToolData.FXToolEffectOnTile.planeflag & 8) == 8);
                  ((JTextField)UIPanels.propertyComponents.get("txt_fx_height")).setText("" + (ToolData.FXToolEffectOnTile.height >> 2));
                  ((JSlider)UIPanels.propertyComponents.get("txt_fx_height_slider")).setValue(ToolData.FXToolEffectOnTile.height >> 2);
                  ((JTextField)UIPanels.propertyComponents.get("txt_fx_offsetx")).setText("" + ToolData.FXToolEffectOnTile.offsetX);
                  ((JTextField)UIPanels.propertyComponents.get("txt_fx_offsety")).setText("" + ToolData.FXToolEffectOnTile.offsetY);
                  ((JTextField)UIPanels.propertyComponents.get("txt_fx_color")).setText("" + ToolData.FXToolEffectOnTile.colorIndex);
                  ((JTextField)UIPanels.propertyComponents.get("txt_fx_flicker")).setText("" + ToolData.FXToolEffectOnTile.flickerType);
                  ((JTextField)UIPanels.propertyComponents.get("txt_fx_flicker2")).setText("" + ToolData.FXToolEffectOnTile.flickerType2);
                  ((JTextField)UIPanels.propertyComponents.get("txt_fx_spread")).setText("" + ToolData.FXToolEffectOnTile.spread);
               }
            }
         });
      }
   }

   boolean saveTileWithNewProperty(WorldTile tile, MapEditor.PropertyType type, int value, boolean undermap, boolean refresh, boolean setText) {
      if (tile == null || !tile.isWithinRegionBounds()) {
         return false;
      } else if (!this.dataLoaded) {
         return false;
      } else if (undermap && RSMapperClient.undermapArchiveId == -1) {
         return false;
      } else if (!undermap && RSMapperClient.mapArchiveId == -1) {
         JOptionPane.showMessageDialog(RSMapperClient.client_frame, "No file associated with coordinates.", "ERROR", 0);
         return false;
      } else {
         int localX = tile.getLocalX();
         int localY = tile.getLocalY();
         int plane = tile.getPlane();
         if (undermap && plane > 0) {
            return false;
         } else {
            boolean worldmap = WorldmapDefinitions.worldmapIsOpen();
            int tileOnX = tile.getX() - RSMapperClient.editor.worldmapEditor.regionXWorldCoordinate;
            int tileOnY = tile.getY() - RSMapperClient.editor.worldmapEditor.regionYWorldCoordinate;
            int posHash = tileOnX + tileOnY * WorldmapDefinitions.totalXTiles;
            int flag = this.flags[plane < 3 ? plane + 1 : 3][localX][localY];
            switch(type) {
               case HEIGHT:
                  value = undermap ? 8 * -(-(value / 8 >> 2)) << 2 : 8 * (value / 8 >> 2) << 2;
                  if (undermap) {
                     if (value < 0) {
                        return false;
                     }

                     this.um_heights[0][localX][localY] = value;
                  } else {
                     if (value > 0) {
                        return false;
                     }

                     if (plane <= 2) {
                        for(int p = plane + 1; p < 4; ++p) {
                           if (this.heights[p][localX][localY] - this.heights[plane][localX][localY] <= -960) {
                              this.heights[p][localX][localY] -= this.heights[plane][localX][localY] - value;
                           }
                        }
                     }

                     this.heights[plane][localX][localY] = value;
                  }

                  if (setText) {
                     ((JTextField)UIPanels.propertyComponents.get(undermap ? "txt_uHeight" : "txt_height")).setText("" + value);
                  }
                  break;
               case TILE_FLAG:
                  if (!undermap) {
                     this.flags[plane][localX][localY] = (byte)value;
                     if (setText) {
                        ((JTextField)UIPanels.propertyComponents.get("txt_tileflag")).setText("" + value);
                     }
                  }
                  break;
               case OVERLAY:
                  if (undermap) {
                     this.um_overlays[0][localX][localY] = (byte)value;
                  } else {
                     this.overlays[plane][localX][localY] = (byte)value;
                     if (worldmap) {
                        WorldmapDefinitions.worldmapOverlays[posHash] = this.overlays[(flag & 2) == 2 ? plane + 1 : plane][localX][localY];
                     }
                  }

                  if (setText) {
                     ((JTextField)UIPanels.propertyComponents.get(undermap ? "txt_uOverlay" : "txt_overlay")).setText("" + value);
                  }
                  break;
               case UNDERLAY:
                  if (undermap) {
                     this.um_underlays[0][localX][localY] = (byte)value;
                  } else {
                     this.underlays[plane][localX][localY] = (byte)value;
                     if (worldmap) {
                        WorldmapDefinitions.worldmapUnderlays[posHash] = this.underlays[(flag & 2) == 2 ? plane + 1 : plane][localX][localY];
                        WorldmapDefinitions.aByteArray335 = new byte[WorldmapDefinitions.totalXTiles * WorldmapDefinitions.totalYTiles];
                        WorldmapDefinitions.aShortArray338 = new short[WorldmapDefinitions.totalXTiles * WorldmapDefinitions.totalYTiles];
                        WorldmapDefinitions.method274(
                           WorldmapDefinitions.worldmapUnderlays,
                           WorldmapDefinitions.aByteArray335,
                           WorldmapDefinitions.aShortArray338,
                           WorldmapDefinitions.anInt323,
                           WorldmapDefinitions.anInt324
                        );
                     }
                  }

                  if (setText) {
                     ((JTextField)UIPanels.propertyComponents.get(undermap ? "txt_uUnderlay" : "txt_underlay")).setText("" + value);
                  }
                  break;
               case SHAPE:
                  if (value > 12 || value < 0) {
                     value = value > 12 ? 12 : 0;
                  }

                  if (undermap && plane == 0) {
                     this.um_shapes[0][localX][localY] = (byte)value;
                  } else if (!undermap) {
                     this.shapes[plane][localX][localY] = (byte)value;
                     boolean affectUndermap = RSMapperClient.undermapArchiveId != -1
                        && plane == 0
                        && OverlayDefinition.isWaterOverlay(this.overlays[plane][localX][localY]);
                     if (affectUndermap) {
                        byte um_shape = (byte)this.findShapeAndRotationForUndermap(value, this.rotations[plane][localX][localY])[0];
                        byte um_rotation = (byte)this.findShapeAndRotationForUndermap(value, this.rotations[plane][localX][localY])[1];
                        this.um_shapes[0][localX][localY] = um_shape;
                        this.um_rotations[0][localX][localY] = um_rotation;
                        ToolData.defaultUMapShape = um_shape;
                        ToolData.defaultUMapRotation = um_rotation;
                        if (setText) {
                           ((JTextField)UIPanels.propertyComponents.get("txt_uShape")).setText("" + um_shape);
                           ((JTextField)UIPanels.propertyComponents.get("txt_uRotation")).setText("" + um_rotation);
                        }
                     }

                     if (worldmap) {
                        int rotation = this.rotations[(flag & 2) == 2 ? plane + 1 : plane][localX][localY];
                        WorldmapDefinitions.worldmapShapeAndRotations[posHash] = WorldmapDefinitions.findByteForShapeRotation(value, rotation);
                     }
                  }

                  if (setText) {
                     ((JTextField)UIPanels.propertyComponents.get(undermap ? "txt_uShape" : "txt_shape")).setText("" + value);
                  }
                  break;
               case ROTATION:
                  if (undermap && plane == 0) {
                     this.um_rotations[0][localX][localY] = (byte)value;
                  } else if (!undermap) {
                     this.rotations[plane][localX][localY] = (byte)value;
                     boolean affectUndermap = RSMapperClient.undermapArchiveId != -1
                        && plane == 0
                        && OverlayDefinition.isWaterOverlay(this.overlays[plane][localX][localY]);
                     if (affectUndermap) {
                        byte um_shape = (byte)this.findShapeAndRotationForUndermap(this.shapes[plane][localX][localY], value)[0];
                        byte um_rotation = (byte)this.findShapeAndRotationForUndermap(this.shapes[plane][localX][localY], value)[1];
                        this.um_shapes[0][localX][localY] = um_shape;
                        this.um_rotations[0][localX][localY] = um_rotation;
                        ToolData.defaultUMapShape = um_shape;
                        ToolData.defaultUMapRotation = um_rotation;
                        if (setText) {
                           ((JTextField)UIPanels.propertyComponents.get("txt_uShape")).setText("" + um_shape);
                           ((JTextField)UIPanels.propertyComponents.get("txt_uRotation")).setText("" + um_rotation);
                        }
                     }

                     if (worldmap) {
                        int shape = this.shapes[(flag & 2) == 2 ? plane + 1 : plane][localX][localY];
                        WorldmapDefinitions.worldmapShapeAndRotations[posHash] = WorldmapDefinitions.findByteForShapeRotation(shape, value);
                     }
                  }

                  if (setText) {
                     ((JTextField)UIPanels.propertyComponents.get(undermap ? "txt_uRotation" : "txt_rotation")).setText("" + value);
                  }
            }

            if (undermap) {
               this.unsavedUndermapProgress = true;
            } else {
               this.unsavedMapProgress = true;
            }

            Class78.MAP_CHANGED = refresh && !worldmap;
            return true;
         }
      }
   }

   public CachedEffect getEffectOnTile(WorldTile tile) {
      return this.effects.get(tile);
   }

   public void saveEffect(WorldTile tile, CachedEffect effect, boolean refresh) {
      if (tile != null && tile.isWithinRegionBounds()) {
         this.effects.remove(tile);
         effect.localX = tile.getLocalX();
         effect.localY = tile.getLocalY();
         effect.referenceX = findReferenceCoord(tile.getLocalX(), effect.offsetX);
         effect.referenceY = findReferenceCoord(tile.getLocalY(), effect.offsetY);
         effect.plane = tile.getPlane();
         CachedEffect newFx = new CachedEffect(
            effect.referenceX,
            effect.referenceY,
            effect.plane,
            effect.planeflag,
            effect.height,
            effect.spread,
            effect.coverage,
            effect.colorIndex,
            effect.flickerType2
         );
         newFx.setFlickerType(effect.flickerType);
         this.effects.put(tile, newFx);
         this.unsavedMapProgress = true;
         Class78.MAP_CHANGED = refresh;
      }
   }

   public static int findReferenceCoord(int coord, int offset) {
      int reference = 0;

      for(int incr = 0; incr < 28; ++incr) {
         for(int i = 0; i < 9990000; ++i) {
            int ref = i << 2;
            if ((Utils.getRegionBaseLocalX(RSMapperClient.regionId) << 9) + ref >> 9 == coord
               && (coord << 9) + ref - (coord + (ref >> 9) << 9) == offset + incr) {
               return ref;
            }
         }
      }

      return reference;
   }

   public boolean packToCache(boolean undermap) {
      if (undermap && RSMapperClient.undermapArchiveId == -1) {
         JOptionPane.showMessageDialog(RSMapperClient.client_frame, "No undermap file exists", "ERROR", 0);
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

         if (!this.dataLoaded) {
            System.err.println("Tried packing " + (undermap ? "undermap" : "map") + " file when data was not loaded!");
            return false;
         } else {
            try {
               byte[] oldData = Cache.STORE.getIndexes()[5].getFile(undermap ? RSMapperClient.undermapArchiveId : RSMapperClient.mapArchiveId);
               InputStream is = new InputStream(oldData);
               OutputStream output = new OutputStream();
               int localX = Utils.getRegionBaseLocalX(RSMapperClient.regionId);
               int localY = Utils.getRegionBaseLocalY(RSMapperClient.regionId);
               int lY = localY;
               int lX = localX;

               for(int plane = 0; plane < (undermap ? 1 : 4); ++plane) {
                  for(int x = 0; x < 64; ++x) {
                     localX = lX + x;

                     for(int y = 0; y < 64; ++y) {
                        localY = lY + y;
                        if (!undermap) {
                           int height = this.heights[plane][localX][localY];
                           int flag = this.flags[plane][localX][localY];
                           int overlay = this.overlays[plane][localX][localY];
                           int underlay = this.underlays[plane][localX][localY];
                           int shape = this.shapes[plane][localX][localY];
                           int rotation = this.rotations[plane][localX][localY];
                           int sr = findByteForShapeRotation(shape, rotation);
                           if (sr >= 2 && overlay != 0 || sr > 2) {
                              output.writeByte(sr);
                              output.writeByte(overlay);
                           }

                           if (flag != 0) {
                              output.writeByte(flag + 49);
                           }

                           if (underlay != 0) {
                              output.writeByte(underlay + 81);
                           }

                           if (RSMapperClient.regionId != 7503 && plane > 0 && height == -960 + this.heights[plane - 1][localX][localY]) {
                              output.writeByte(0);
                           } else {
                              output.writeByte(1);
                              if (plane > 0) {
                                 int belowHeight = this.heights[plane - 1][localX][localY];
                                 if (belowHeight == height) {
                                    output.writeByte(1);
                                 } else {
                                    output.writeByte(-((height - belowHeight) / 8 >> 2));
                                 }
                              } else if (height == 0) {
                                 output.writeByte(1);
                              } else {
                                 output.writeByte(-(height / 8 >> 2));
                              }
                           }
                        } else {
                           if (OverlayDefinition.isWaterOverlay(this.overlays[plane][localX][localY])) {
                              if (this.um_underlays[plane][localX][localY] == 0) {
                                 this.um_underlays[plane][localX][localY] = this.underlays[plane][localX][localY] == 0
                                    ? 48
                                    : this.underlays[plane][localX][localY];
                              }

                              if (this.shapes[plane][localX][localY] != 0) {
                                 this.um_overlays[plane][localX][localY] = 42;
                                 int[] sr = this.findShapeAndRotationForUndermap(this.shapes[plane][localX][localY], this.rotations[plane][localX][localY]);
                                 this.um_shapes[plane][localX][localY] = (byte)sr[0];
                                 this.um_rotations[plane][localX][localY] = (byte)sr[1];
                              } else {
                                 this.um_overlays[plane][localX][localY] = 0;
                              }
                           } else {
                              this.um_heights[plane][localX][localY] = 0;
                              this.um_shapes[plane][localX][localY] = 0;
                              this.um_rotations[plane][localX][localY] = 0;
                              this.um_overlays[plane][localX][localY] = 42;
                              if (this.um_underlays[plane][localX][localY] == 0) {
                                 this.um_underlays[plane][localX][localY] = this.underlays[plane][localX][localY];
                              }
                           }

                           int height = this.um_heights[plane][localX][localY];
                           int overlay = this.um_overlays[plane][localX][localY];
                           int underlay = this.um_underlays[plane][localX][localY];
                           int shape = this.um_shapes[plane][localX][localY];
                           int rotation = this.um_rotations[plane][localX][localY];
                           int sr = findByteForShapeRotation(shape, rotation);
                           if (sr >= 2 && overlay != 0 || sr > 2) {
                              output.writeByte(sr);
                              output.writeByte(overlay);
                           }

                           if (underlay != 0) {
                              output.writeByte(underlay + 81);
                           }

                           if (height == 0) {
                              output.writeByte(0);
                           } else {
                              output.writeByte(1);
                              output.writeByte(height / 8 >> 2);
                           }
                        }
                     }
                  }
               }

               for(int plane = 0; plane < 4; ++plane) {
                  for(int x = 0; x < 64; ++x) {
                     for(int y = 0; y < 64; ++y) {
                        while(true) {
                           int i_145_ = is.readUnsignedByte();
                           if (i_145_ == 0) {
                              break;
                           }

                           if (i_145_ == 1) {
                              is.readUnsignedByte();
                              break;
                           }

                           if (i_145_ <= 49) {
                              is.readByte();
                           }
                        }
                     }
                  }
               }

               if (!undermap) {
                  boolean wroteEnvironment = false;
                  boolean readOpcode2 = false;
                  int opcode2Value1 = 0;
                  int opcode2Value2 = 0;
                  int opcode2Value3 = 0;

                  while(is.getOffset() < is.getBuffer().length) {
                     int opcode = is.readUnsignedByte();
                     if (opcode == 128) {
                        output.writeByte(opcode);
                        output.writeShort(is.readUnsignedShort());
                        output.writeShort(is.readShort());
                        output.writeShort(is.readShort());
                        output.writeShort(is.readShort());
                        output.writeShort(is.readUnsignedShort());
                     } else if (opcode == 129) {
                        output.writeByte(opcode);

                        for(int plane = 0; plane < 4; ++plane) {
                           byte b = (byte)is.readByte();
                           output.writeByte(b);
                           if (b != 0 && b == 1) {
                              for(int i_24_ = 0; i_24_ < 64; i_24_ += 4) {
                                 for(int i_25_ = 0; i_25_ < 64; i_25_ += 4) {
                                    output.writeByte(is.readByte());
                                 }
                              }
                           }
                        }
                     } else if (opcode == 0) {
                        if (!this.createdEnvironment && !wroteEnvironment) {
                           output.writeByte(opcode);
                        }

                        int flag = is.readUnsignedByte();
                        if (!this.createdEnvironment && !wroteEnvironment) {
                           output.writeByte(flag);
                        }

                        if ((flag & 1) != 0) {
                           int tint = is.readInt();
                           if (!this.createdEnvironment && !wroteEnvironment) {
                              output.writeInt(tint);
                           }
                        }

                        if ((flag & 2) != 0) {
                           int bright = is.readUnsignedShort();
                           if (!this.createdEnvironment && !wroteEnvironment) {
                              output.writeShort(bright);
                           }
                        }

                        if ((flag & 4) != 0) {
                           int vibr = is.readUnsignedShort();
                           if (!this.createdEnvironment && !wroteEnvironment) {
                              output.writeShort(vibr);
                           }
                        }

                        if ((flag & 8) != 0) {
                           int black = is.readUnsignedShort();
                           if (!this.createdEnvironment && !wroteEnvironment) {
                              output.writeShort(black);
                           }
                        }

                        if ((flag & 16) != 0) {
                           int sunX = is.readShort();
                           int sunZ = is.readShort();
                           int sunY = is.readShort();
                           if (!this.createdEnvironment && !wroteEnvironment) {
                              output.writeShort(sunX);
                              output.writeShort(sunZ);
                              output.writeShort(sunY);
                           }
                        }

                        if ((flag & 32) != 0) {
                           int fogColor = is.readInt();
                           if (!this.createdEnvironment && !wroteEnvironment) {
                              output.writeInt(fogColor);
                           }
                        }

                        if ((flag & 64) != 0) {
                           int fogDensity = is.readUnsignedShort();
                           if (!this.createdEnvironment && !wroteEnvironment) {
                              output.writeShort(fogDensity);
                           }
                        }

                        if ((flag & 128) != 0) {
                           int s1 = is.readUnsignedShort();
                           int s2 = is.readUnsignedShort();
                           int s3 = is.readUnsignedShort();
                           int s4 = is.readUnsignedShort();
                           int s5 = is.readUnsignedShort();
                           int s6 = is.readUnsignedShort();
                           if (!this.createdEnvironment && !wroteEnvironment) {
                              output.writeShort(s1);
                              output.writeShort(s2);
                              output.writeShort(s3);
                              output.writeShort(s4);
                              output.writeShort(s5);
                              output.writeShort(s6);
                           }
                        }

                        if (!this.createdEnvironment && !wroteEnvironment) {
                           wroteEnvironment = true;
                        }
                     } else if (opcode != 1) {
                        if (opcode == 2) {
                           opcode2Value1 = is.readUnsignedByte();
                           opcode2Value2 = is.readUnsignedByte();
                           opcode2Value3 = is.readUnsignedByte();
                           readOpcode2 = true;
                        }
                     } else {
                        int fxcount = is.readUnsignedByte();
                        if (fxcount > 0) {
                           for(int i = 0; i < fxcount; ++i) {
                              is.readUnsignedByte();
                              is.readUnsignedShort();
                              is.readUnsignedShort();
                              is.readUnsignedShort();
                              int i_19_ = is.readUnsignedByte();
                              int i_20_ = 2 * i_19_ + 1;
                              int[] passedi_22_ = new int[i_20_];
                              short[] aShortArray4105 = new short[i_20_];

                              for(int i_21_ = 0; i_21_ < aShortArray4105.length; ++i_21_) {
                                 int i_22_ = (short)is.readUnsignedShort();
                                 passedi_22_[i_21_] = i_22_;
                                 int i_23_ = i_22_ >>> 8;
                                 if (i_23_ >= i_20_) {
                                    i_23_ = i_20_ - 1;
                                 }

                                 int i_24_ = i_22_ & 0xFF;
                                 if (i_24_ > i_20_ - i_23_) {
                                    i_24_ = i_20_ - i_23_;
                                 }

                                 aShortArray4105[i_21_] = (short)(i_24_ | i_23_ << 8);
                              }

                              is.readUnsignedShort();
                              int i_26_ = is.readUnsignedByte();
                              int anInt4110 = i_26_ & 31;
                              if (anInt4110 == 31) {
                                 is.readUnsignedShort();
                              }
                           }
                        }
                     }
                  }

                  if (this.createdEnvironment) {
                     output.writeByte(0);
                     int flag = this.i_7_ == 0 && this.i_8_ == 0 && this.i_9_ == 0 && this.i_10_ == 0 && this.i_11_ == 0 && this.i_12_ == 0 ? 127 : 255;
                     output.writeByte(flag);
                     output.writeInt(this.highlightcolor[0]);
                     output.writeShort((short)((int)(this.brightness[0] * 256.0F)));
                     output.writeShort((short)((int)(this.vibrance[0] * 256.0F)));
                     output.writeShort((short)((int)(this.blackpoint[0] * 256.0F)));
                     output.writeShort((short)this.sunDistanceX[0]);
                     output.writeShort((short)this.sunDistanceZ[0]);
                     output.writeShort((short)this.sunDistanceY[0]);
                     output.writeInt(this.fogcolor[0]);
                     output.writeShort((short)this.fogdensity[0]);
                     if (flag == 255) {
                        output.writeShort(this.i_7_);
                        output.writeShort(this.i_8_);
                        output.writeShort(this.i_9_);
                        output.writeShort(this.i_10_);
                        output.writeShort(this.i_11_);
                        output.writeShort(this.i_12_);
                     }
                  }

                  int fxcount = this.effects.size();
                  if (fxcount > 0) {
                     output.writeByte(1);
                     output.writeByte(fxcount);

                     for(Entry<WorldTile, CachedEffect> pair : RSMapperClient.editor.mapEditor.effects.entrySet()) {
                        CachedEffect fx = pair.getValue();
                        output.writeByte((byte)fx.planeflag);
                        output.writeShort((short)(fx.referenceX >> 2));
                        output.writeShort((short)(fx.referenceY >> 2));
                        output.writeShort((short)(fx.height >> 2));
                        output.writeByte(fx.spread);

                        for(int i = 0; i < fx.coverage.length; ++i) {
                           output.writeShort((short)fx.coverage[i]);
                        }

                        output.writeShort(fx.colorIndex);
                        output.writeByte(fx.flickerType2);
                        if ((fx.flickerType2 & 31) == 31) {
                           output.writeShort(fx.flickerType);
                        }
                     }
                  }

                  if (readOpcode2) {
                     output.writeByte(2);
                     output.writeByte(opcode2Value1);
                     output.writeByte(opcode2Value2);
                     output.writeByte(opcode2Value3);
                  }
               }

               byte[] data = new byte[output.getOffset()];
               output.setOffset(0);
               output.getBytes(data, 0, data.length);
               if (data.length < 10) {
                  Logger.getLogger("global").log(Level.SEVERE, "EMPTY MAP FILE WAS PACKED");
               }

               boolean packed = Cache.STORE.getIndexes()[5].putFile(undermap ? RSMapperClient.undermapArchiveId : RSMapperClient.mapArchiveId, 0, data);
               if (packed) {
                  if (undermap) {
                     this.unsavedUndermapProgress = false;
                  } else {
                     this.unsavedMapProgress = false;
                  }

                  RSMapperClient.project.setDateModified();
                  HomeMenu.writeProjectInfo(RSMapperClient.project.name, RSMapperClient.project);
                  JOptionPane.showMessageDialog(
                     RSMapperClient.client_frame,
                     "Packed " + (undermap ? "under" : "") + "map file " + (undermap ? RSMapperClient.undermapArchiveId : RSMapperClient.mapArchiveId),
                     "SUCCESS",
                     1
                  );
               }

               return true;
            } catch (Exception var25) {
               var25.printStackTrace();
               JOptionPane.showMessageDialog(RSMapperClient.client_frame, "Failed to pack " + (undermap ? "under" : "") + "map file!", "ERROR", 0);
               return false;
            }
         }
      }
   }

   public int getMapValueFromTile(WorldTile tile, MapEditor.PropertyType type) {
      return this.getValueFromTile(tile, type, false);
   }

   public int getUndermapValueFromTile(WorldTile tile, MapEditor.PropertyType type) {
      return this.getValueFromTile(tile, type, true);
   }

   public int getValueFromTile(WorldTile tile, MapEditor.PropertyType type, boolean undermap) {
      if (!undermap || RSMapperClient.undermapArchiveId != -1 && this.um_heights != null) {
         int localX = tile.getLocalX();
         int localY = tile.getLocalY();
         int plane = tile.getPlane();
         switch(type) {
            case HEIGHT:
               return undermap ? this.um_heights[0][localX][localY] : this.heights[plane][localX][localY];
            case TILE_FLAG:
               return undermap ? 0 : this.flags[plane][localX][localY];
            case OVERLAY:
               return undermap ? this.um_overlays[0][localX][localY] : this.overlays[plane][localX][localY];
            case UNDERLAY:
               return undermap ? this.um_underlays[0][localX][localY] : this.underlays[plane][localX][localY];
            case SHAPE:
               return undermap ? this.um_shapes[0][localX][localY] : this.shapes[plane][localX][localY];
            case ROTATION:
               return undermap ? this.um_rotations[0][localX][localY] : this.rotations[plane][localX][localY];
            default:
               return -1;
         }
      } else {
         return 0;
      }
   }

   public static int findByteForShapeRotation(int shape, int rotation) {
      for(int i = 0; i < 128; ++i) {
         int s = (i - 2) / 4;
         int r = 3 & i - 2;
         if (shape == s && rotation == r) {
            return i;
         }
      }

      return -1;
   }

   // $VF: Could not inline inconsistent finally blocks
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public void exportFile(int regionId, boolean compiled, boolean undermap) throws Throwable {
      int mapArchive = Cache.STORE.getIndexes()[5].getArchiveId("m" + Utils.getLocalX(regionId) + "_" + Utils.getLocalY(regionId));
      int undermapArchive = Cache.STORE.getIndexes()[5].getArchiveId("um" + Utils.getLocalX(regionId) + "_" + Utils.getLocalY(regionId));
      if (!undermap && mapArchive == -1) {
         JOptionPane.showMessageDialog(RSMapperClient.client_frame, "No map file exists", "ERROR", 0);
      } else if (undermap && undermapArchive == -1) {
         JOptionPane.showMessageDialog(RSMapperClient.client_frame, "No undermap file exists", "ERROR", 0);
      } else {
         File file = null;
         file = new File("data/projects/" + RSMapperClient.project.name + "/exports/" + regionId + "/");
         if (!file.exists()) {
            file.mkdirs();
         }

         file = new File(
            file.toString() + "/" + (undermap ? undermapArchive : mapArchive) + "_" + (undermap ? "undermap" : "map") + (compiled ? "" : "(s).txt")
         );
         if (compiled) {
            byte[] data = Cache.STORE.getIndexes()[5].getArchive(undermap ? undermapArchive : mapArchive).getData();

            try {
               Throwable buffer = null;
               Object var9 = null;

               try {
                  FileOutputStream fos = new FileOutputStream(file);

                  try {
                     fos.write(data);
                     fos.close();
                     JOptionPane.showMessageDialog(
                        RSMapperClient.client_frame,
                        "Compiled " + (undermap ? "undermap" : "map") + " file " + (undermap ? undermapArchive : mapArchive) + " to " + file.toString(),
                        "SUCCESS",
                        1
                     );
                  } finally {
                     if (fos != null) {
                        fos.close();
                     }
                  }
               } catch (Throwable var64) {
                  if (buffer == null) {
                     buffer = var64;
                  } else if (buffer != var64) {
                     buffer.addSuppressed(var64);
                  }

                  throw buffer;
               }
            } catch (Exception var65) {
            }
         } else {
            try {
               byte[] da = Cache.STORE.getIndexes()[5].getFile(undermap ? undermapArchive : mapArchive, 0, null);
               InputStream buffer = new InputStream(da);
               Throwable var70 = null;
               Object var71 = null;

               try {
                  FileWriter writer = new FileWriter(file);

                  try {
                     int regionX = Utils.getRegionCoordX(regionId);
                     int regionY = Utils.getRegionCoordY(regionId);
                     int localX = Utils.getRegionBaseLocalX(regionId);
                     int localY = Utils.getRegionBaseLocalY(regionId);
                     int lY = localY;
                     int lX = localX;

                     for(int plane = 0; plane < 4; ++plane) {
                        for(int x = 0; x < 64; ++x) {
                           localX = lX + x;

                           for(int y = 0; y < 64; ++y) {
                              localY = lY + y;
                              writer.write("STARTING COORDS - (" + (regionX + x) + ", " + (regionY + y) + ", " + plane + ")\n");

                              while(true) {
                                 int i_145_ = buffer.readUnsignedByte();
                                 writer.write(
                                    "[UBYTE1] : "
                                       + i_145_
                                       + " : CONDITION ("
                                       + (
                                          i_145_ == 0
                                             ? "SET BASE HEIGHT"
                                             : (
                                                i_145_ == 1
                                                   ? "SET HEIGHT BASED ON UBYTE2"
                                                   : (
                                                      i_145_ <= 49
                                                         ? "SET S/R FROM THIS BYTE AND OVERLAY BASED ON BYTE3"
                                                         : (i_145_ <= 81 ? "SET PLANE FLAG BASED ON THIS BYTE" : "SET UNDERLAY BASED ON THIS BYTE")
                                                   )
                                             )
                                       )
                                       + ")"
                                       + "\n"
                                 );
                                 if (i_145_ == 0) {
                                    break;
                                 }

                                 if (i_145_ == 1) {
                                    int i_146_ = buffer.readUnsignedByte();
                                    writer.write("[UBYTE2] : " + i_146_ + " : HEIGHT" + "\n");
                                    break;
                                 }

                                 if (i_145_ <= 49) {
                                    int overlay = buffer.readByte();
                                    writer.write("[BYTE3] : " + overlay + " : OVERLAY" + "\n");
                                 }
                              }
                           }
                        }
                     }

                     boolean class343IsNull = true;
                     boolean aByteArrayArrayArray3518IsNull = true;

                     while(buffer.getBuffer().length > buffer.getOffset()) {
                        localX = Utils.getRegionBaseLocalX(regionId);
                        localY = Utils.getRegionBaseLocalY(regionId);
                        int opcode = buffer.readUnsignedByte();
                        writer.write("[OPCODE] : " + opcode + "\n");
                        if (opcode != 0) {
                           if (opcode == 1) {
                              writer.write("*** BEGIN OPCODE 1\n");
                              int fxCount = buffer.readUnsignedByte();
                              writer.write("[BYTE] fxCount: " + fxCount + "\n");
                              if (fxCount > 0) {
                                 writer.write("* fxCount > 0 - BEGIN LOOP until less than fxCount\n");

                                 for(int count = 0; count < fxCount; ++count) {
                                    writer.write("  ** CREATE NEW GFX (Class326) ->\n");
                                    int plane = buffer.readUnsignedByte();
                                    writer.write("   [BYTE] plane: " + plane + "\n");
                                    writer.write("   aBoolean4090: " + ((16 & plane) != 0) + "\n");
                                    writer.write("   aBoolean4102: " + ((plane & 8) != 0) + "\n");
                                    plane = 7 & plane;
                                    writer.write("   plane final: " + plane + "\n");
                                    int xHash = buffer.readUnsignedShort();
                                    writer.write("   [USHORT] xHash: " + (xHash << 2) + "\n");
                                    xHash <<= 2;
                                    int yHash = buffer.readUnsignedShort();
                                    writer.write("   [USHORT] yHash: " + (yHash << 2) + "\n");
                                    yHash <<= 2;
                                    int height = buffer.readUnsignedShort();
                                    writer.write("   [USHORT] height: " + (height << 2) + "\n");
                                    height <<= 2;
                                    int i_19_ = buffer.readUnsignedByte();
                                    writer.write("   [UBYTE] spread = " + i_19_ + "\n");
                                    int i_20_ = 2 * i_19_ + 1;
                                    writer.write("   finalSpread = " + i_20_ + " -> new aShortArray4105[spread]\n");
                                    writer.write("   ** LOOP i < finalSpread -> \n");

                                    for(int i_21_ = 0; i_21_ < i_20_; ++i_21_) {
                                       int i_22_ = (short)buffer.readUnsignedShort();
                                       writer.write("      [USHORT] coverage = " + i_22_ + "\n");
                                       int i_23_ = i_22_ >>> 8;
                                       writer.write("      i_23 : " + i_23_ + " (coverage >>> 8)\n");
                                       if (i_23_ >= i_20_) {
                                          i_23_ = i_20_ - 1;
                                          writer.write("      i_23 > finalSpread so i_23_ = : " + i_23_ + " (finalSpread - 1)\n");
                                       }

                                       int i_24_ = i_22_ & 0xFF;
                                       writer.write("      i_24_ : " + i_24_ + " (coverage & 0xff)\n");
                                       if (i_24_ > i_20_ - i_23_) {
                                          i_24_ = i_20_ - i_23_;
                                          writer.write("      i_24_ > (finalSpread - i_23_) so i_24_ = : " + i_24_ + " (finalSpread - i_23_)\n");
                                       }

                                       writer.write("      coverages[i] = " + (short)(i_24_ | i_23_ << 8) + " ((i_24_ | (i_23_ << 8))\n");
                                    }

                                    writer.write("      ** END LOOP ** \n");
                                    int i_25_ = buffer.readUnsignedShort();
                                    writer.write("   [USHORT] colorIndex = " + i_25_ + "\n");
                                    int i_26_ = buffer.readUnsignedByte();
                                    writer.write("   [UBYTE] i_26_ = " + i_26_ + "\n");
                                    writer.write("   ** END LOOP (CREATE GFX Class326) ** \n");
                                    int anInt4110 = i_26_ & 31;
                                    writer.write("anInt4110 from Class326 : " + anInt4110 + " (i_26_ & 0x1f)\n");
                                    if (anInt4110 == 31) {
                                       writer.write("** anInt4110 == 31 ENTER CONDITION --> \n");
                                       writer.write("[USHORT] flickerType = " + buffer.readUnsignedShort() + "\n");
                                    }

                                    int i_35_ = (localX << 9) + xHash;
                                    int i_36_ = (localY << 9) + yHash;
                                    int spawnX = i_35_ >> 9;
                                    int spawnY = i_36_ >> 9;
                                    writer.write(
                                       "GFX SPAWN ON COORDINATES: LOCAL("
                                          + spawnX
                                          + ", "
                                          + spawnY
                                          + ") - WORLD("
                                          + (spawnX + regionX - 16)
                                          + ", "
                                          + (spawnY + regionY - 16)
                                          + ", "
                                          + plane
                                          + ") \n"
                                    );
                                 }
                              }

                              writer.write("*** END OPCODE 1 *** \n");
                           } else if (opcode != 2) {
                              if (opcode == 128) {
                                 if (class343IsNull) {
                                    class343IsNull = false;
                                 }

                                 writer.write("[OP-128] : " + buffer.readUnsignedShort() + "\n");
                                 writer.write("[OP-128] : " + buffer.readShort() + "\n");
                                 writer.write("[OP-128] : " + buffer.readShort() + "\n");
                                 writer.write("[OP-128] : " + buffer.readShort() + "\n");
                                 writer.write("[OP-128] : " + buffer.readUnsignedShort() + "\n");
                              } else {
                                 writer.write("THIS SHOULD BE OPCODE 129???\n");

                                 for(int plane = 0; plane < 4; ++plane) {
                                    byte b = (byte)buffer.readByte();
                                    writer.write("[OP-" + opcode + "][" + plane + "] : " + b + "\n");
                                    if (b != 0 || aByteArrayArrayArray3518IsNull) {
                                       if (b != 1) {
                                          if (b == 1 && aByteArrayArrayArray3518IsNull) {
                                             aByteArrayArrayArray3518IsNull = false;
                                          }
                                       } else {
                                          if (aByteArrayArrayArray3518IsNull) {
                                             aByteArrayArrayArray3518IsNull = false;
                                          }

                                          for(int x = 0; x < 64; x += 4) {
                                             for(int y = 0; y < 64; y += 4) {
                                                writer.write("[OP-" + opcode + "] (" + x + ", " + y + ", " + plane + ") : " + buffer.readByte() + "\n");
                                             }
                                          }
                                       }
                                    }
                                 }
                              }
                           } else {
                              if (class343IsNull) {
                                 class343IsNull = false;
                              }

                              writer.write("[OP-2] : " + buffer.readUnsignedByte() + "\n");
                              writer.write("[OP-2] : " + buffer.readUnsignedByte() + "\n");
                              writer.write("[OP-2] : " + buffer.readUnsignedByte() + "\n");
                           }
                        } else if (class343IsNull) {
                           writer.write("*** BEGIN OPCODE 0 - new Class343 (ENVIRONMENT LIGHTING/FOG)\n");
                           class343IsNull = false;
                           int flag = buffer.readUnsignedByte();
                           writer.write("--> [BYTE]flag: " + flag + "\n");
                           if (~(1 & flag) != -1) {
                              writer.write("--> [INT]highlightColor: " + buffer.readInt() + "\n");
                           }

                           if (~(flag & 2) != -1) {
                              writer.write("--> [USHORT]brightness: " + buffer.readUnsignedShort() + "\n");
                           }

                           if ((flag & 4) != 0) {
                              writer.write("--> [USHORT]vibrance: " + buffer.readUnsignedShort() + "\n");
                           }

                           if (~(8 & flag) != -1) {
                              writer.write("--> [USHORT]blackpoint: " + buffer.readUnsignedShort() + "\n");
                           }

                           if (~(16 & flag) != -1) {
                              writer.write("--> [SHORT]sunDistanceX: " + buffer.readShort() + "\n");
                              writer.write("--> [SHORT]sunDistanceZ: " + buffer.readShort() + "\n");
                              writer.write("--> [SHORT]sunDistanceY: " + buffer.readShort() + "\n");
                           }

                           if (~(32 & flag) != -1) {
                              writer.write("--> [INT]fogColor: " + buffer.readInt() + "\n");
                           }

                           if (~(flag & 64) != -1) {
                              writer.write("--> [USHORT]fogDensity: " + buffer.readUnsignedShort() + "\n");
                           }

                           if (~(128 & flag) != -1) {
                              writer.write("--> [USHORT]i_7_ : " + buffer.readUnsignedShort() + "\n");
                              writer.write("--> [USHORT]i_8_ : " + buffer.readUnsignedShort() + "\n");
                              writer.write("--> [USHORT]i_9_ : " + buffer.readUnsignedShort() + "\n");
                              writer.write("--> [USHORT]i_10_ : " + buffer.readUnsignedShort() + "\n");
                              writer.write("--> [USHORT]i_11_ : " + buffer.readUnsignedShort() + "\n");
                              writer.write("--> [USHORT]i_12_ : " + buffer.readUnsignedShort() + "\n");
                              writer.write("*** END OPCODE 0 (LIGHTING)\n");
                           }
                        } else {
                           writer.write("*** BEGIN OPCODE 0 (COND. 2) - new Class343 (ENVIRONMENT LIGHTING/FOG)\n");
                           class343IsNull = false;
                           int flag = buffer.readUnsignedByte();
                           writer.write("--> [BYTE]flag: " + flag + "\n");
                           if (~(1 & flag) != -1) {
                              writer.write("--> [INT]highlightColor: " + buffer.readInt() + "\n");
                           }

                           if (~(flag & 2) != -1) {
                              writer.write("--> [USHORT]brightness: " + buffer.readUnsignedShort() + "\n");
                           }

                           if ((flag & 4) != 0) {
                              writer.write("--> [USHORT]vibrance: " + buffer.readUnsignedShort() + "\n");
                           }

                           if (~(8 & flag) != -1) {
                              writer.write("--> [USHORT]blackpoint: " + buffer.readUnsignedShort() + "\n");
                           }

                           if (~(16 & flag) != -1) {
                              writer.write("--> [SHORT]sunDistanceX: " + buffer.readShort() + "\n");
                              writer.write("--> [SHORT]sunDistanceZ: " + buffer.readShort() + "\n");
                              writer.write("--> [SHORT]sunDistanceY: " + buffer.readShort() + "\n");
                           }

                           if (~(32 & flag) != -1) {
                              writer.write("--> [INT]fogColor: " + buffer.readInt() + "\n");
                           }

                           if (~(flag & 64) != -1) {
                              writer.write("--> [USHORT]fogDensity: " + buffer.readUnsignedShort() + "\n");
                           }

                           if (~(128 & flag) != -1) {
                              writer.write("--> [USHORT]i_7_ : " + buffer.readUnsignedShort() + "\n");
                              writer.write("--> [USHORT]i_8_ : " + buffer.readUnsignedShort() + "\n");
                              writer.write("--> [USHORT]i_9_ : " + buffer.readUnsignedShort() + "\n");
                              writer.write("--> [USHORT]i_10_ : " + buffer.readUnsignedShort() + "\n");
                              writer.write("--> [USHORT]i_11_ : " + buffer.readUnsignedShort() + "\n");
                              writer.write("--> [USHORT]i_12_ : " + buffer.readUnsignedShort() + "\n");
                              writer.write("*** END OPCODE 0 (LIGHTING)\n");
                           }
                        }
                     }

                     writer.close();
                     JOptionPane.showMessageDialog(
                        RSMapperClient.client_frame,
                        "Wrote source " + (undermap ? "undermap" : "map") + " file " + (undermap ? undermapArchive : mapArchive) + " to " + file.toString(),
                        "SUCCESS",
                        1
                     );
                  } finally {
                     if (writer != null) {
                        writer.close();
                     }
                  }
               } catch (Throwable var61) {
                  if (var70 == null) {
                     var70 = var61;
                  } else if (var70 != var61) {
                     var70.addSuppressed(var61);
                  }

                  throw var70;
               }
            } catch (Exception var62) {
               var62.printStackTrace();
            }
         }
      }
   }

   public int[] findShapeAndRotationForUndermap(int shape, int rotation) {
      int[] shapeRotation = new int[2];
      switch(shape) {
         case 1:
            shapeRotation = new int[]{1, rotation < 2 ? rotation + 2 : rotation - 2};
            break;
         case 2:
            shapeRotation = new int[]{4, rotation};
            break;
         case 3:
            shapeRotation = new int[]{5, rotation};
            break;
         case 4:
            shapeRotation = new int[]{2, rotation};
            break;
         case 5:
            shapeRotation = new int[]{3, rotation};
            break;
         case 6:
            shapeRotation = new int[]{6, rotation < 2 ? rotation + 2 : rotation - 2};
            break;
         case 7:
            shapeRotation = new int[]{8, rotation};
            break;
         case 8:
            shapeRotation = new int[]{7, rotation};
            break;
         case 9:
            shapeRotation = new int[]{10, rotation};
            break;
         case 10:
            shapeRotation = new int[]{9, rotation};
         case 11:
      }

      return shapeRotation;
   }

   public void loadFile(byte[] data, int regionId, boolean undermap) {
      int localX = Utils.getRegionBaseLocalX(RSMapperClient.regionId);
      int localY = Utils.getRegionBaseLocalY(RSMapperClient.regionId);
      InputStream buffer = new InputStream(data);
      System.out.println("undermap: " + undermap);

      for(int plane = 0; plane < (undermap ? 1 : 4); ++plane) {
         for(int x = localX; x < localX + 64; ++x) {
            for(int y = localY; y < localY + 64; ++y) {
               if (x >= 0 && x < 104 && y >= 0 && y < 104) {
                  if (!undermap) {
                     this.heights[plane][x][y] = 0;
                     Class277.tileFlags[plane][x][y] = 0;
                     this.underlays[plane][x][y] = 0;
                     this.overlays[plane][x][y] = 0;
                     this.shapes[plane][x][y] = 0;
                     this.rotations[plane][x][y] = 0;
                  } else {
                     this.um_heights[plane][x][y] = 0;
                     this.um_underlays[plane][x][y] = 0;
                     this.um_overlays[plane][x][y] = 0;
                     this.um_shapes[plane][x][y] = 0;
                     this.um_rotations[plane][x][y] = 0;
                  }

                  int paddingX = 0;
                  int paddingY = 0;

                  while(true) {
                     int flag = buffer.readUnsignedByte();
                     if (flag == 0) {
                        if (!undermap) {
                           if (plane == 0) {
                              this.heights[0][x + paddingX][y + paddingY] = 8
                                    * -Class339_Sub1.method3925(
                                       Utils.getRegionCoordX(RSMapperClient.regionId) + x + 932731,
                                       114,
                                       Utils.getRegionCoordY(RSMapperClient.regionId) + y + 556238
                                    )
                                 << 2;
                           } else {
                              this.heights[plane][paddingX + x][paddingY + y] = this.heights[plane - 1][x + paddingX][y + paddingY] - 960;
                           }
                        } else {
                           this.um_heights[0][paddingX + x][y + paddingY] = 0;
                        }
                        break;
                     }

                     if (flag == 1) {
                        int height = buffer.readUnsignedByte();
                        if (!undermap) {
                           if (height == 1) {
                              height = 0;
                           }

                           if (plane == 0) {
                              this.heights[0][paddingX + x][paddingY + y] = 8 * -height << 2;
                           } else {
                              this.heights[plane][paddingX + x][y + paddingY] = this.heights[plane - 1][x + paddingX][paddingY + y] - (8 * height << 2);
                           }
                        } else {
                           this.um_heights[0][paddingX + x][paddingY + y] = 8 * height << 2;
                        }
                        break;
                     }

                     if (flag <= 49) {
                        if (undermap) {
                           this.um_overlays[plane][x][y] = (byte)buffer.readByte();
                           this.um_shapes[plane][x][y] = (byte)((flag - 2) / 4);
                           this.um_rotations[plane][x][y] = (byte)(3 & flag - 2);
                        } else {
                           this.overlays[plane][x][y] = (byte)buffer.readByte();
                           this.shapes[plane][x][y] = (byte)((flag - 2) / 4);
                           this.rotations[plane][x][y] = (byte)(3 & flag - 2);
                        }
                     } else if (flag <= 81) {
                        if (!undermap) {
                           Class277.tileFlags[plane][x][y] = (byte)(flag - 49);
                        }
                     } else if (undermap) {
                        this.um_underlays[plane][x][y] = (byte)(flag - 81);
                     } else {
                        this.underlays[plane][x][y] = (byte)(flag - 81);
                     }
                  }
               } else {
                  while(true) {
                     int flag = buffer.readUnsignedByte();
                     if (flag == 0) {
                        break;
                     }

                     if (flag == 1) {
                        buffer.readUnsignedByte();
                        break;
                     }

                     if (flag <= 49) {
                        buffer.readUnsignedByte();
                     }
                  }
               }
            }
         }
      }

      if (!undermap) {
         this.effects.clear();

         while(buffer.getOffset() < buffer.getBuffer().length) {
            int opcode = buffer.readUnsignedByte();
            System.out.println("opcode: " + opcode);
            if (opcode == 128) {
               buffer.readUnsignedShort();
               buffer.readShort();
               buffer.readShort();
               buffer.readShort();
               buffer.readUnsignedShort();
            } else if (opcode == 129) {
               for(int plane = 0; plane < 4; ++plane) {
                  byte b = (byte)buffer.readByte();
                  if (b != 0 && b == 1) {
                     for(int i_24_ = 0; i_24_ < 64; i_24_ += 4) {
                        for(int i_25_ = 0; i_25_ < 64; i_25_ += 4) {
                           buffer.readByte();
                        }
                     }
                  }
               }
            } else if (opcode == 0) {
               int flag = buffer.readUnsignedByte();
               if ((flag & 1) != 0) {
                  this.highlightcolor[0] = buffer.readInt();
               }

               if ((flag & 2) != 0) {
                  this.brightness[0] = (float)buffer.readUnsignedShort() / 256.0F;
               }

               if ((flag & 4) != 0) {
                  this.vibrance[0] = (float)buffer.readUnsignedShort() / 256.0F;
               }

               if ((flag & 8) != 0) {
                  this.blackpoint[0] = (float)buffer.readUnsignedShort() / 256.0F;
               }

               if ((flag & 16) != 0) {
                  this.sunDistanceX[0] = buffer.readShort();
                  this.sunDistanceZ[0] = buffer.readShort();
                  this.sunDistanceY[0] = buffer.readShort();
               }

               if ((flag & 32) != 0) {
                  this.fogcolor[0] = buffer.readInt();
               }

               if ((flag & 64) != 0) {
                  this.fogdensity[0] = buffer.readUnsignedShort();
               }

               if ((flag & 128) != 0) {
                  this.i_7_ = buffer.readUnsignedShort();
                  this.i_8_ = buffer.readUnsignedShort();
                  this.i_9_ = buffer.readUnsignedShort();
                  this.i_10_ = buffer.readUnsignedShort();
                  this.i_11_ = buffer.readUnsignedShort();
                  this.i_12_ = buffer.readUnsignedShort();
               }
            } else if (opcode != 1) {
               if (opcode == 2) {
                  buffer.readUnsignedByte();
                  buffer.readUnsignedByte();
                  buffer.readUnsignedByte();
               }
            } else {
               int fxcount = buffer.readUnsignedByte();
               System.out.println("fx count: " + fxcount);
               if (fxcount > 0) {
                  for(int i = 0; i < fxcount; ++i) {
                     int planeFlag = buffer.readUnsignedByte();
                     boolean aBoolean4090 = (16 & planeFlag) != 0;
                     boolean aBoolean4102 = (planeFlag & 8) != 0;
                     int plane = 7 & planeFlag;
                     int referenceX = buffer.readUnsignedShort() << 2;
                     int referenceY = buffer.readUnsignedShort() << 2;
                     int height = buffer.readUnsignedShort() << 2;
                     int spread = buffer.readUnsignedByte();
                     int finalSpread = 2 * spread + 1;
                     int[] coverage = new int[finalSpread];
                     short[] aShortArray4105 = new short[finalSpread];

                     for(int i_21_ = 0; i_21_ < aShortArray4105.length; ++i_21_) {
                        int i_22_ = (short)buffer.readUnsignedShort();
                        coverage[i_21_] = i_22_;
                        int i_23_ = i_22_ >>> 8;
                        if (i_23_ >= finalSpread) {
                           i_23_ = finalSpread - 1;
                        }

                        int i_24_ = i_22_ & 0xFF;
                        if (i_24_ > finalSpread - i_23_) {
                           i_24_ = finalSpread - i_23_;
                        }

                        aShortArray4105[i_21_] = (short)(i_24_ | i_23_ << 8);
                     }

                     int i_19_ = (spread << Class36.INT_9) + Class135.INT_9_;
                     int colorIndex = buffer.readUnsignedShort();
                     if (Class85.colors != null) {
                        int var10000 = Class85.colors[colorIndex];
                     } else {
                        int var48 = Class170.anIntArray2054['\uffff' & Node_Sub15_Sub2.method2560(5310, colorIndex)];
                     }

                     int i_26_ = buffer.readUnsignedByte();
                     int anInt4094 = 1792 & i_26_ << 3;
                     int anInt4110 = i_26_ & 31;
                     int regionLocalX = 64 * (RSMapperClient.regionId >> 8) - Node_Sub53.gameSceneBaseX;
                     int regionLocalY = 64 * (RSMapperClient.regionId & 0xFF) - Class320_Sub4.gameSceneBaseY;
                     int i_35_ = (regionLocalX << 9) + referenceX;
                     int i_36_ = (regionLocalY << 9) + referenceY;
                     CachedEffect newEffect = new CachedEffect(referenceX, referenceY, plane, planeFlag, height, spread, coverage, colorIndex, i_26_);
                     if (anInt4110 == 31) {
                        newEffect.setFlickerType(buffer.readUnsignedShort());
                     }

                     RSMapperClient.editor.mapEditor.effects.put(new WorldTile(i_35_ >> 9, i_36_ >> 9, plane, true), newEffect);
                  }
               }
            }
         }

         if (RSMapperClient.editor.tool instanceof FXTool) {
            ((FXTool)RSMapperClient.editor.tool).updateEffectsCountLabel();
         }
      }

      RSMapperClient.editor.loadingRegionProgress += 25;
   }

   public void smoothVerticeHeights(WorldTile tile, boolean undermap, boolean refresh) {
      int size = RSMapperClient.editor.brush.getSize();
      int startX = tile.getLocalX() - size / 2;
      int startY = tile.getLocalY() - size / 2;
      int endX = tile.getLocalX() + size / 2 + 1;
      int endY = tile.getLocalY() + size / 2 + 1;
      int plane = tile.getPlane();
      if (!undermap || plane <= 0) {
         for(int y = startY; y < endY; ++y) {
            for(int x = startX; x < endX; ++x) {
               int value = 0;
               int cellAverage = 1;
               if (x > 0 && y > 0) {
                  value += undermap ? this.um_heights[plane][x - 1][y - 1] : this.heights[plane][x - 1][y - 1];
                  ++cellAverage;
               }

               if (y > 0) {
                  value += undermap ? this.um_heights[plane][x][y - 1] : this.heights[plane][x][y - 1];
                  ++cellAverage;
               }

               if (x < 103 && y > 0) {
                  value += undermap ? this.um_heights[plane][x + 1][y - 1] : this.heights[plane][x + 1][y - 1];
                  ++cellAverage;
               }

               if (x > 0) {
                  value += undermap ? this.um_heights[plane][x - 1][y] : this.heights[plane][x - 1][y];
                  ++cellAverage;
               }

               if (x < 104 && x >= 0 && y < 104 && y >= 0) {
                  value += undermap ? this.um_heights[plane][x][y] : this.heights[plane][x][y];
               }

               if (x < 103) {
                  value += undermap ? this.um_heights[plane][x + 1][y] : this.heights[plane][x + 1][y];
                  ++cellAverage;
               }

               if (x > 0 && y < 103) {
                  value += undermap ? this.um_heights[plane][x - 1][y + 1] : this.heights[plane][x - 1][y + 1];
                  ++cellAverage;
               }

               if (y < 103) {
                  value += undermap ? this.um_heights[plane][x][y + 1] : this.heights[plane][x][y + 1];
                  ++cellAverage;
               }

               if (x < 103 && y < 103) {
                  value += undermap ? this.um_heights[plane][x + 1][y + 1] : this.heights[plane][x + 1][y + 1];
                  ++cellAverage;
               }

               int height = value / cellAverage;
               if (undermap && !OverlayDefinition.isWaterOverlay(this.overlays[plane][x][y])) {
                  height = 0;
               }

               this.saveTileWithNewProperty(new WorldTile(x, y, plane, true), MapEditor.PropertyType.HEIGHT, height, undermap, false, false);
            }
         }

         if (refresh) {
            Class78.MAP_CHANGED = true;
         }
      }
   }

   public void makeHill(WorldTile tile, int intensity, boolean inverse, boolean undermap, boolean refresh) {
      if (!undermap || tile.getPlane() <= 0) {
         ArrayList<WorldTile> tiles = RSMapperClient.editor.brush.getTilesBasedOnBrushAndSize(tile);
         int plane = tile.getPlane();
         int startHeight = undermap ? this.um_heights[plane][tile.getLocalX()][tile.getLocalY()] : this.heights[plane][tile.getLocalX()][tile.getLocalY()];
         int tipHeight = startHeight + (inverse ? 500 * intensity : -(500 * intensity));

         for(WorldTile t : tiles) {
            this.saveTileWithNewProperty(t, MapEditor.PropertyType.HEIGHT, tipHeight, undermap, false, false);
         }

         this.smoothVerticeHeights(tile, undermap, false);
         this.smoothVerticeHeights(tile, undermap, refresh);
      }
   }

   public void makeBridge(WorldTile point1, WorldTile point2, ArrayList<WorldTile> selectedTiles, boolean bridgeFlag, boolean undermap) {
      int baseX = 64 * (RSMapperClient.regionId >> 8);
      int baseY = 64 * (RSMapperClient.regionId & 0xFF);
      int maxX = baseX + 63;
      int maxY = baseY + 63;
      boolean point2XGreater = Math.max(point1.getLocalX(), point2.getLocalX()) == point2.getLocalX();
      boolean point2YGreater = Math.max(point1.getLocalY(), point2.getLocalY()) == point2.getLocalY();
      int length = Math.max(point1.getLocalY(), point2.getLocalY()) - Math.min(point1.getLocalY(), point2.getLocalY());
      int width = Math.max(point1.getLocalX(), point2.getLocalX()) - Math.min(point1.getLocalX(), point2.getLocalX());
      int height1 = 0;
      int height2 = 0;
      if (ToolData.bridgeManualHeights) {
         height1 = ToolData.bridgeHeightPoint1;
         height2 = ToolData.bridgeHeightPoint2;
      } else {
         height1 = this.getValueFromTile(point1, MapEditor.PropertyType.HEIGHT, undermap);
         height2 = this.getValueFromTile(point2, MapEditor.PropertyType.HEIGHT, undermap);
      }

      int floorObjectId = bridgeFlag ? ToolData.bridgeFloorObjectId : -1;
      int floorObjectRotation = floorObjectId > -1 ? ToolData.bridgeFloorObjectRotation : 0;
      if (bridgeFlag && floorObjectId > -1) {
         ObjectDefinition objectdefinition = Class186.aClass112_2256 == null ? null : Class186.aClass112_2256.getObjectDefinitionsForId(floorObjectId, 42);
         if (objectdefinition == null) {
            floorObjectId = -1;
            EventQueue.invokeLater(new Runnable() {
               @Override
               public void run() {
                  JOptionPane.showMessageDialog(RSMapperClient.client_frame, "The input floor object is invalid so it was not used.", "ERROR", 0);
               }
            });
         } else {
            boolean goodToGo = false;

            for(byte b : objectdefinition.possibleTypes) {
               if (b == 22) {
                  goodToGo = true;
                  break;
               }
            }

            if (!goodToGo) {
               floorObjectId = -1;
               EventQueue.invokeLater(new Runnable() {
                  @Override
                  public void run() {
                     JOptionPane.showMessageDialog(RSMapperClient.client_frame, "The input floor object is not walkable so it was not used.", "ERROR", 0);
                  }
               });
            } else if (goodToGo && (floorObjectRotation > 3 || floorObjectRotation < 0)) {
               floorObjectRotation = floorObjectRotation > 3 ? 3 : 0;
            }
         }
      }

      boolean height2Greater = Math.max(Math.abs(height1), Math.abs(height2)) == Math.abs(height2);
      int increment = (Math.abs(height2Greater ? height2 : height1) - Math.abs(height2Greater ? height1 : height2)) / (length > width ? length : width);

      while(increment % 32 != 0) {
         increment = undermap ? increment + 1 : increment - 1;
      }

      boolean reverse = false;
      if ((height2Greater && !point2XGreater || !height2Greater && point2XGreater) && width > length) {
         reverse = true;
      } else if ((height2Greater && !point2YGreater || !height2Greater && point2YGreater) && length > width) {
         reverse = true;
      }

      int[] heights = new int[2 + (length > width ? length : width)];

      for(int i = 0; i < heights.length; ++i) {
         int offset = reverse ? heights.length - 1 - i : i;
         if (!undermap) {
            heights[offset] = (height2Greater ? height1 : height2) - i * increment;
         } else {
            heights[offset] = (height2Greater ? height1 : height2) + i * increment;
         }

         if (undermap && heights[offset] < 0) {
            heights[offset] = 0;
         } else if (!undermap && heights[offset] > 0) {
            heights[offset] = 0;
         }
      }

      int nextHeight = 0;
      int newHeight = 0;

      for(int x = point2XGreater ? point1.getLocalX() : point2.getLocalX(); x <= (point2XGreater ? point2.getLocalX() : point1.getLocalX()) + 1; ++x) {
         if (nextHeight >= heights.length) {
            nextHeight = 0;
         }

         newHeight = heights[nextHeight];
         if (width > length) {
            ++nextHeight;
         }

         for(int y = point2YGreater ? point1.getLocalY() : point2.getLocalY(); y <= (point2YGreater ? point2.getLocalY() : point1.getLocalY()) + 1; ++y) {
            if (length > width) {
               newHeight = heights[nextHeight];
               ++nextHeight;
            }

            boolean isBridgeTile = selectedTiles.contains(new WorldTile(x, y, point1.getPlane(), true));
            if (x + Node_Sub53.gameSceneBaseX <= maxX
               && y + Class320_Sub4.gameSceneBaseY <= maxY
               && x + Node_Sub53.gameSceneBaseX >= baseX
               && y + Class320_Sub4.gameSceneBaseY >= baseY) {
               if (bridgeFlag && newHeight > this.getValueFromTile(new WorldTile(x, y, point1.getPlane(), true), MapEditor.PropertyType.HEIGHT, undermap)) {
                  this.saveTileWithNewProperty(new WorldTile(x, y, point1.getPlane(), true), MapEditor.PropertyType.HEIGHT, newHeight, undermap, false, false);
               }

               if (!bridgeFlag || bridgeFlag && !ToolData.bridgeManualHeights) {
                  if (reverse && width > length && x == (point2XGreater ? point1.getLocalX() : point2.getLocalX())) {
                     newHeight = this.getValueFromTile(new WorldTile(x, y, point1.getPlane(), true), MapEditor.PropertyType.HEIGHT, undermap);
                  } else if (!reverse && width > length && x == (point2XGreater ? point2.getLocalX() : point1.getLocalX()) + 1) {
                     newHeight = this.getValueFromTile(new WorldTile(x, y, point1.getPlane(), true), MapEditor.PropertyType.HEIGHT, undermap);
                  } else if (reverse && length > width && y == (point2YGreater ? point1.getLocalY() : point2.getLocalY())) {
                     newHeight = this.getValueFromTile(new WorldTile(x, y, point1.getPlane(), true), MapEditor.PropertyType.HEIGHT, undermap);
                  } else if (!reverse && length > width && y == (point2YGreater ? point2.getLocalY() : point1.getLocalY()) + 1) {
                     newHeight = this.getValueFromTile(new WorldTile(x, y, point1.getPlane(), true), MapEditor.PropertyType.HEIGHT, undermap);
                  }
               }

               this.saveTileWithNewProperty(
                  new WorldTile(x, y, point1.getPlane() + (bridgeFlag ? 1 : 0), true), MapEditor.PropertyType.HEIGHT, newHeight, undermap, false, false
               );
               if (isBridgeTile && bridgeFlag) {
                  this.saveTileWithNewProperty(
                     new WorldTile(x, y, point1.getPlane() + 1, true), MapEditor.PropertyType.OVERLAY, ToolData.bridgeOverlay, false, false, false
                  );
                  this.saveTileWithNewProperty(new WorldTile(x, y, point1.getPlane() + 1, true), MapEditor.PropertyType.TILE_FLAG, 2, false, false, false);
                  if (floorObjectId > -1) {
                     RSMapperClient.editor
                        .objectEditor
                        .placeObject(new WorldTile(x, y, point1.getPlane() + 1, true), floorObjectId, 22, floorObjectRotation, false, false);
                  }
               }
            }
         }
      }

      if (floorObjectId > -1) {
         RSMapperClient.editor.objectEditor.populateTable(RSMapperClient.editor.selectedTile);
      }

      Class78.MAP_CHANGED = true;
   }

   public ArrayList<WorldTile> getAllTilesForBridge(WorldTile point1, WorldTile point2) {
      ArrayList<WorldTile> affectedTiles = new ArrayList<>();
      boolean point2XGreater = Math.max(point1.getLocalX(), point2.getLocalX()) == point2.getLocalX();
      boolean point2YGreater = Math.max(point1.getLocalY(), point2.getLocalY()) == point2.getLocalY();

      for(int x = point2XGreater ? point1.getLocalX() : point2.getLocalX(); x <= (point2XGreater ? point2.getLocalX() : point1.getLocalX()) + 1; ++x) {
         for(int y = point2YGreater ? point1.getLocalY() : point2.getLocalY(); y <= (point2YGreater ? point2.getLocalY() : point1.getLocalY()) + 1; ++y) {
            WorldTile affectedTile = new WorldTile(x, y, point1.getPlane(), true);
            if (affectedTile.isWithinRegionBounds()) {
               affectedTiles.add(affectedTile);
            }
         }
      }

      return affectedTiles;
   }

   public static enum PropertyType {
      HEIGHT,
      TILE_FLAG,
      OVERLAY,
      UNDERLAY,
      SHAPE,
      ROTATION;
   }
}
