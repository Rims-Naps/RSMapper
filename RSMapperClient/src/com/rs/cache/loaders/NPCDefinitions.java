package com.rs.cache.loaders;

import com.alex.io.InputStream;
import com.alex.io.OutputStream;
import com.alex.store.Store;
import com.rs.cache.Cache;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public final class NPCDefinitions {
   public static ConcurrentHashMap<Integer, NPCDefinitions> npcDefinitions = new ConcurrentHashMap<>();
   public int id;
   public HashMap<Integer, Object> parameters;
   public int anInt833;
   public int anInt836;
   public int anInt837;
   public byte respawnDirection;
   public int size = 1;
   public int[][] anIntArrayArray840;
   public boolean aBoolean841;
   public int anInt842;
   public int anInt844;
   public int[] anIntArray845;
   public int anInt846;
   public int renderEmote;
   public boolean aBoolean849 = false;
   public int anInt850;
   public byte innerShadowBrightness;
   public boolean aBoolean852;
   public int anInt853;
   public byte outerShadowBrightness;
   public boolean aBoolean856;
   public boolean hasShadow;
   public short[] originalColors;
   public int combatLevel;
   public byte[] aByteArray861;
   public short innerShadowColor;
   public boolean aBoolean863;
   public int width;
   public String name;
   public short[] modifiedTextures;
   public byte walkMask;
   public int[] modelIds;
   public int anInt869;
   public int anInt870;
   public int anInt871;
   public int mouseHoverSprite;
   public int anInt874;
   public int anInt875;
   public int anInt876;
   public int headIcons;
   public int anInt879;
   public short[] originalTextures;
   public int[][] anIntArrayArray882;
   public int anInt884;
   public int[] anIntArray885;
   public int anInt888;
   public int anInt889;
   public boolean isVisibleOnMap;
   public int[] anIntArray892;
   public short outerShadowColor;
   public String[] options;
   public short[] modifiedColors;
   public int anInt897;
   public int height;
   public int registerClickRadius;
   public int npcId;
   public int stackSpriteId;
   public byte canInteract;
   public boolean aBoolean3190;

   public static NPCDefinitions getNPCDefinitions(int id) {
      NPCDefinitions def = npcDefinitions.get(id);
      if (def == null) {
         def = new NPCDefinitions(id);
         def.method694();
         byte[] data = Cache.STORE.getIndexes()[18].getFile(id >>> 134238215, id & 127);
         if (data != null) {
            def.readValueLoop(new InputStream(data));
         }

         npcDefinitions.put(id, def);
      }

      return def;
   }

   public static NPCDefinitions getNPCDefinitions(Store cache, int id) {
      NPCDefinitions def = npcDefinitions.get(id);
      if (def == null) {
         def = new NPCDefinitions(id);
         def.id = id;
         byte[] data = cache.getIndexes()[18].getFile(id >>> 134238215, id & 127);
         if (data != null) {
            def.readValueLoop(new InputStream(data));
         }

         npcDefinitions.put(id, def);
      }

      return def;
   }

   public void method694() {
      if (this.modelIds == null) {
         this.modelIds = new int[0];
      }
   }

   private void readValueLoop(InputStream stream) {
      while(true) {
         int opcode = stream.readUnsignedByte();
         if (opcode == 0) {
            return;
         }

         this.readValues(stream, opcode);
      }
   }

   public byte[] encode() {
      OutputStream stream = new OutputStream();
      if (this.modelIds != null) {
         stream.writeByte(1);
         stream.writeByte(this.modelIds.length);

         for(int i = 0; i < this.modelIds.length; ++i) {
            stream.writeShort(this.modelIds[i]);
         }
      }

      if (this.name != null && !this.name.equals("null")) {
         stream.writeByte(2);
         stream.writeString(this.name);
      }

      stream.writeByte(12);
      stream.writeByte(this.size);
      if (this.options != null) {
         for(int i = 0; i < 5; ++i) {
            if (this.options[i] != null) {
               stream.writeByte(i + 30);
               stream.writeString(this.options[i]);
            }
         }
      }

      if (this.modifiedColors != null && this.originalColors != null) {
         stream.writeByte(40);
         stream.writeByte(this.modifiedColors.length);

         for(int i = 0; i < this.modifiedColors.length; ++i) {
            stream.writeShort(this.originalColors[i]);
            stream.writeShort(this.modifiedColors[i]);
         }
      }

      if (this.modifiedTextures != null && this.originalTextures != null) {
         stream.writeByte(41);
         stream.writeByte(this.modifiedTextures.length);

         for(int i = 0; i < this.modifiedTextures.length; ++i) {
            stream.writeShort(this.originalTextures[i]);
            stream.writeShort(this.modifiedTextures[i]);
         }
      }

      if (!this.isVisibleOnMap) {
         stream.writeByte(93);
      }

      stream.writeByte(95);
      stream.writeShort(this.combatLevel);
      stream.writeByte(97);
      stream.writeShort(this.width);
      stream.writeByte(98);
      stream.writeShort(this.height);
      stream.writeByte(100);
      stream.writeByte(this.anInt869);
      stream.writeByte(101);
      stream.writeByte(this.anInt897);
      stream.writeByte(102);
      stream.writeShort(this.headIcons);
      if (!this.hasShadow) {
         stream.writeByte(111);
      }

      stream.writeByte(113);
      stream.writeShort(this.innerShadowColor);
      stream.writeShort(this.outerShadowColor);
      stream.writeByte(114);
      stream.writeByte(this.innerShadowBrightness);
      stream.writeByte(this.outerShadowBrightness);
      stream.writeByte(119);
      stream.writeByte(this.walkMask);
      stream.writeByte(125);
      stream.writeByte(this.respawnDirection);
      stream.writeByte(127);
      stream.writeShort(this.renderEmote);
      stream.writeByte(137);
      stream.writeShort(this.mouseHoverSprite);
      stream.writeByte(138);
      stream.writeShort(this.stackSpriteId);
      if (this.canInteract == 1) {
         stream.writeByte(158);
      } else {
         stream.writeByte(159);
      }

      stream.writeByte(165);
      stream.writeByte((byte)this.registerClickRadius);
      if (this.parameters != null) {
         stream.writeByte(249);
         stream.writeByte(this.parameters.size());

         for(int key : this.parameters.keySet()) {
            Object value = this.parameters.get(key);
            boolean string_value = value instanceof String;
            stream.writeByte(string_value ? 1 : 0);
            stream.write24BitInt(key);
            if (string_value) {
               stream.writeString((String)value);
            } else {
               stream.writeInt((Integer)value);
            }
         }
      }

      stream.writeByte(0);
      byte[] data = new byte[stream.getOffset()];
      stream.setOffset(0);
      stream.getBytes(data, 0, data.length);
      return data;
   }

   private void readValues(InputStream stream, int opcode) {
      if (opcode != 1) {
         if (opcode == 2) {
            this.setName(stream.readString());
         } else if (opcode != 12) {
            if (opcode >= 30 && opcode < 35) {
               this.options[opcode - 30] = stream.readString();
            } else if (opcode != 40) {
               if (opcode == 41) {
                  int i = stream.readUnsignedByte();
                  this.originalTextures = new short[i];
                  this.modifiedTextures = new short[i];

                  for(int i_54_ = 0; ~i_54_ > ~i; ++i_54_) {
                     this.modifiedTextures[i_54_] = (short)stream.readUnsignedShort();
                     this.originalTextures[i_54_] = (short)stream.readUnsignedShort();
                  }
               } else if (opcode == 42) {
                  int i = stream.readUnsignedByte();
                  this.aByteArray861 = new byte[i];

                  for(int i_55_ = 0; i > i_55_; ++i_55_) {
                     this.aByteArray861[i_55_] = (byte)stream.readByte();
                  }
               } else if (opcode != 60) {
                  if (opcode == 93) {
                     this.isVisibleOnMap = false;
                  } else if (opcode == 95) {
                     this.combatLevel = stream.readUnsignedShort();
                  } else if (opcode != 97) {
                     if (opcode == 98) {
                        this.height = stream.readUnsignedShort();
                     } else if (opcode == 99) {
                        this.aBoolean863 = true;
                     } else if (opcode == 100) {
                        this.anInt869 = stream.readByte();
                     } else if (opcode == 101) {
                        this.anInt897 = stream.readByte() * 5;
                     } else if (opcode == 102) {
                        this.headIcons = stream.readUnsignedShort();
                     } else if (opcode != 103) {
                        if (opcode == 106 || opcode == 118) {
                           this.anInt844 = stream.readUnsignedShort();
                           if (this.anInt844 == 65535) {
                              this.anInt844 = -1;
                           }

                           this.anInt888 = stream.readUnsignedShort();
                           if (this.anInt888 == 65535) {
                              this.anInt888 = -1;
                           }

                           int i = -1;
                           if (opcode == 118) {
                              i = stream.readUnsignedShort();
                              if (i == 65535) {
                                 i = -1;
                              }
                           }

                           int i_56_ = stream.readUnsignedByte();
                           this.anIntArray845 = new int[2 + i_56_];

                           for(int i_57_ = 0; i_56_ >= i_57_; ++i_57_) {
                              this.anIntArray845[i_57_] = stream.readUnsignedShort();
                              if (this.anIntArray845[i_57_] == 65535) {
                                 this.anIntArray845[i_57_] = -1;
                              }
                           }

                           this.anIntArray845[i_56_ - -1] = i;
                        } else if (opcode != 107) {
                           if (opcode == 109) {
                              this.aBoolean852 = false;
                           } else if (opcode != 111) {
                              if (opcode != 113) {
                                 if (opcode == 114) {
                                    this.innerShadowBrightness = (byte)stream.readByte();
                                    this.outerShadowBrightness = (byte)stream.readByte();
                                 } else if (opcode == 115) {
                                    stream.readUnsignedByte();
                                    stream.readUnsignedByte();
                                 } else if (opcode != 119) {
                                    if (opcode != 121) {
                                       if (opcode != 122) {
                                          if (opcode == 123) {
                                             this.anInt846 = stream.readUnsignedShort();
                                          } else if (opcode != 125) {
                                             if (opcode == 127) {
                                                this.renderEmote = stream.readUnsignedShort();
                                             } else if (opcode == 128) {
                                                stream.readUnsignedByte();
                                             } else if (opcode != 134) {
                                                if (opcode == 135) {
                                                   this.anInt833 = stream.readUnsignedByte();
                                                   this.anInt874 = stream.readUnsignedShort();
                                                } else if (opcode != 136) {
                                                   if (opcode != 137) {
                                                      if (opcode != 138) {
                                                         if (opcode != 139) {
                                                            if (opcode == 140) {
                                                               this.anInt850 = stream.readUnsignedByte();
                                                            } else if (opcode == 141) {
                                                               this.aBoolean849 = true;
                                                            } else if (opcode != 142) {
                                                               if (opcode == 143) {
                                                                  this.aBoolean856 = true;
                                                               } else if (opcode >= 150 && opcode < 155) {
                                                                  this.options[opcode - 150] = stream.readString();
                                                               } else if (opcode == 160) {
                                                                  int i = stream.readUnsignedByte();
                                                                  this.anIntArray885 = new int[i];

                                                                  for(int i_58_ = 0; i > i_58_; ++i_58_) {
                                                                     this.anIntArray885[i_58_] = stream.readUnsignedShort();
                                                                  }
                                                               } else if (opcode == 155) {
                                                                  stream.readByte();
                                                                  stream.readByte();
                                                                  stream.readByte();
                                                                  stream.readByte();
                                                               } else if (opcode == 158) {
                                                                  this.canInteract = 1;
                                                               } else if (opcode == 159) {
                                                                  this.canInteract = 0;
                                                               } else if (opcode == 162) {
                                                                  this.aBoolean3190 = true;
                                                               } else if (opcode == 163) {
                                                                  stream.readUnsignedByte();
                                                               } else if (opcode == 164) {
                                                                  stream.readUnsignedShort();
                                                                  stream.readUnsignedShort();
                                                               } else if (opcode == 165) {
                                                                  this.registerClickRadius = stream.readUnsignedByte();
                                                               } else if (opcode == 168) {
                                                                  stream.readUnsignedByte();
                                                               } else if (opcode == 249) {
                                                                  int i = stream.readUnsignedByte();
                                                                  if (this.parameters == null) {
                                                                     this.parameters = new HashMap<>(i);
                                                                  }

                                                                  for(int i_60_ = 0; i > i_60_; ++i_60_) {
                                                                     boolean bool = stream.readUnsignedByte() == 1;
                                                                     int key = stream.read24BitInt();
                                                                     Object value;
                                                                     if (bool) {
                                                                        value = stream.readString();
                                                                     } else {
                                                                        value = stream.readInt();
                                                                     }

                                                                     this.parameters.put(key, value);
                                                                  }
                                                               }
                                                            } else {
                                                               this.anInt870 = stream.readUnsignedShort();
                                                            }
                                                         } else {
                                                            this.anInt879 = stream.readUnsignedShort();
                                                         }
                                                      } else {
                                                         this.stackSpriteId = stream.readUnsignedShort();
                                                      }
                                                   } else {
                                                      this.mouseHoverSprite = stream.readUnsignedShort();
                                                   }
                                                } else {
                                                   this.anInt837 = stream.readUnsignedByte();
                                                   this.anInt889 = stream.readUnsignedShort();
                                                }
                                             } else {
                                                this.anInt876 = stream.readUnsignedShort();
                                                if (this.anInt876 == 65535) {
                                                   this.anInt876 = -1;
                                                }

                                                this.anInt842 = stream.readUnsignedShort();
                                                if (this.anInt842 == 65535) {
                                                   this.anInt842 = -1;
                                                }

                                                this.anInt884 = stream.readUnsignedShort();
                                                if (this.anInt884 == 65535) {
                                                   this.anInt884 = -1;
                                                }

                                                this.anInt871 = stream.readUnsignedShort();
                                                if (this.anInt871 == 65535) {
                                                   this.anInt871 = -1;
                                                }

                                                this.anInt875 = stream.readUnsignedByte();
                                             }
                                          } else {
                                             this.respawnDirection = (byte)stream.readByte();
                                          }
                                       } else {
                                          this.anInt836 = stream.readUnsignedShort();
                                       }
                                    } else {
                                       this.anIntArrayArray840 = new int[this.modelIds.length][];
                                       int i = stream.readUnsignedByte();

                                       for(int i_62_ = 0; ~i_62_ > ~i; ++i_62_) {
                                          int i_63_ = stream.readUnsignedByte();
                                          int[] is = this.anIntArrayArray840[i_63_] = new int[3];
                                          is[0] = stream.readByte();
                                          is[1] = stream.readByte();
                                          is[2] = stream.readByte();
                                       }
                                    }
                                 } else {
                                    this.walkMask = (byte)stream.readByte();
                                 }
                              } else {
                                 this.innerShadowColor = (short)stream.readUnsignedShort();
                                 this.outerShadowColor = (short)stream.readUnsignedShort();
                              }
                           } else {
                              this.hasShadow = false;
                           }
                        } else {
                           this.aBoolean841 = false;
                        }
                     } else {
                        this.anInt853 = stream.readUnsignedShort();
                     }
                  } else {
                     this.width = stream.readUnsignedShort();
                  }
               } else {
                  int i = stream.readUnsignedByte();
                  this.anIntArray892 = new int[i];

                  for(int i_64_ = 0; ~i_64_ > ~i; ++i_64_) {
                     this.anIntArray892[i_64_] = stream.readUnsignedShort();
                  }
               }
            } else {
               int i = stream.readUnsignedByte();
               this.originalColors = new short[i];
               this.modifiedColors = new short[i];

               for(int i_65_ = 0; ~i < ~i_65_; ++i_65_) {
                  this.modifiedColors[i_65_] = (short)stream.readUnsignedShort();
                  this.originalColors[i_65_] = (short)stream.readUnsignedShort();
               }
            }
         } else {
            this.size = stream.readUnsignedByte();
         }
      } else {
         int i = stream.readUnsignedByte();
         this.modelIds = new int[i];

         for(int i_66_ = 0; i_66_ < i; ++i_66_) {
            this.modelIds[i_66_] = stream.readUnsignedShort();
            if (~this.modelIds[i_66_] == -65536) {
               this.modelIds[i_66_] = -1;
            }
         }
      }
   }

   public boolean hasPickupOption() {
      for(String option : this.options) {
         if (option != null && option.equalsIgnoreCase("pick-up")) {
            return true;
         }
      }

      return false;
   }

   public boolean hasTakeOption() {
      for(String option : this.options) {
         if (option != null && option.equalsIgnoreCase("take")) {
            return true;
         }
      }

      return false;
   }

   public static void clearNPCDefinitions() {
      npcDefinitions.clear();
   }

   public NPCDefinitions(int id) {
      this.id = id;
      this.anInt842 = -1;
      this.anInt844 = -1;
      this.anInt837 = -1;
      this.anInt846 = -1;
      this.anInt853 = 32;
      this.combatLevel = -1;
      this.anInt836 = -1;
      this.setName("null");
      this.anInt869 = 0;
      this.walkMask = 0;
      this.anInt850 = 255;
      this.anInt871 = -1;
      this.aBoolean852 = true;
      this.innerShadowColor = 0;
      this.anInt876 = -1;
      this.innerShadowBrightness = -96;
      this.anInt875 = 0;
      this.mouseHoverSprite = -1;
      this.renderEmote = -1;
      this.respawnDirection = 7;
      this.hasShadow = true;
      this.anInt870 = -1;
      this.anInt874 = -1;
      this.anInt833 = -1;
      this.width = 128;
      this.headIcons = -1;
      this.aBoolean856 = false;
      this.anInt888 = -1;
      this.outerShadowBrightness = -16;
      this.aBoolean863 = false;
      this.isVisibleOnMap = true;
      this.anInt889 = -1;
      this.anInt884 = -1;
      this.aBoolean841 = true;
      this.anInt879 = -1;
      this.height = 128;
      this.outerShadowColor = 0;
      this.options = new String[5];
      this.anInt897 = 0;
      this.stackSpriteId = -1;
      this.canInteract = -1;
      this.registerClickRadius = 0;
   }

   public boolean hasMarkOption() {
      for(String option : this.options) {
         if (option != null && option.equalsIgnoreCase("mark")) {
            return true;
         }
      }

      return false;
   }

   public boolean hasOption(String op) {
      for(String option : this.options) {
         if (option != null && option.equalsIgnoreCase(op)) {
            return true;
         }
      }

      return false;
   }

   public boolean hasAttackOption() {
      for(String option : this.options) {
         if (option != null && option.equalsIgnoreCase("attack")) {
            return true;
         }
      }

      return false;
   }

   public String getName() {
      return this.name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public static NPCDefinitions getNPCDefinitions(String name) {
      for(int i = 0; i < getNPCDefinitionsSize(); ++i) {
         if (getNPCDefinitions(i).getName().equalsIgnoreCase(name)) {
            return getNPCDefinitions(i);
         }
      }

      return null;
   }

   public int getId() {
      return this.id;
   }

   public int getCombatLevel() {
      return this.combatLevel;
   }

   public static int getNPCDefinitionsSize() {
      int lastArchiveId = Cache.STORE.getIndexes()[18].getLastArchiveId();
      return lastArchiveId * 128 + Cache.STORE.getIndexes()[18].getValidFilesCount(lastArchiveId);
   }
}
