package org.rsmapper.cache.loaders;

import com.alex.io.OutputStream;
import com.alex.store.Store;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.rsmapper.cache.Cache;
import org.rsmapper.networking.codec.stream.InputStream;
import org.rsmapper.utilities.misc.Utils;

public final class NPCDefinitions {
   private static final ConcurrentHashMap<Integer, NPCDefinitions> npcDefinitions = new ConcurrentHashMap();
   public int id;
   public HashMap<Integer, Object> aClass180_832;
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
   public byte aByte851;
   public boolean aBoolean852;
   public int anInt853;
   public byte aByte854;
   public boolean aBoolean856;
   public boolean aBoolean857;
   public short[] aShortArray859;
   public int combatLevel;
   public byte[] aByteArray861;
   public short aShort862;
   public boolean aBoolean863;
   public int anInt864;
   private String name;
   public short[] aShortArray866;
   public byte walkMask;
   public int[] modelIds;
   public int anInt869;
   public int anInt870;
   public int anInt871;
   public int anInt872;
   public int anInt874;
   public int anInt875;
   public int anInt876;
   public int headIcons;
   public int anInt879;
   public short[] aShortArray880;
   public int[][] anIntArrayArray882;
   public int anInt884;
   public int[] anIntArray885;
   public int anInt888;
   public int anInt889;
   public boolean isVisibleOnMap;
   public int[] anIntArray892;
   public short aShort894;
   public String[] options;
   public short[] aShortArray896;
   public int anInt897;
   public int anInt899;
   public int npcId;
   public int anInt901;
   public boolean aBoolean3190;

   public static final NPCDefinitions getNPCDefinitions(int id) {
      NPCDefinitions def = (NPCDefinitions)npcDefinitions.get(id);
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

   public static final NPCDefinitions getNPCDefinitions(Store cache, int id) {
      NPCDefinitions def = (NPCDefinitions)npcDefinitions.get(id);
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
      int i;
      if (this.modelIds != null) {
         stream.writeByte(1);
         stream.writeByte(this.modelIds.length);

         for(i = 0; i < this.modelIds.length; ++i) {
            stream.writeBigSmart(this.modelIds[i]);
         }
      }

      if (this.name != null && !this.name.equals("null")) {
         stream.writeByte(2);
         stream.writeString(this.name);
      }

      stream.writeByte(12);
      stream.writeByte(this.size);
      if (this.options != null) {
         for(i = 0; i < 5; ++i) {
            stream.writeByte(i + 30);
            stream.writeString(this.options[i]);
         }
      }

      stream.writeByte(95);
      stream.writeBigSmart(this.combatLevel);
      stream.writeByte(98);
      stream.writeByte(this.anInt899);
      stream.writeByte(100);
      stream.writeByte(this.anInt869);
      stream.writeByte(101);
      stream.writeByte(this.anInt897);
      stream.writeByte(127);
      stream.writeBigSmart(this.renderEmote);
      stream.writeByte(0);
      byte[] data = new byte[stream.getOffset()];
      stream.setOffset(0);
      stream.getBytes(data, 0, data.length);
      return data;
   }

   private void readValues(InputStream stream, int opcode) {
      int i;
      int i_60_;
      if (opcode != 1) {
         if (opcode == 2) {
            this.setName(stream.readString());
         } else if (opcode != 12) {
            if (opcode >= 30 && opcode < 35) {
               this.options[opcode - 30] = stream.readString();
               if (this.options[opcode - 30].equalsIgnoreCase("Hidden")) {
                  this.options[opcode - 30] = null;
               }
            } else if (opcode != 40) {
               if (opcode == 41) {
                  i = stream.readUnsignedByte();
                  this.aShortArray880 = new short[i];
                  this.aShortArray866 = new short[i];

                  for(i_60_ = 0; ~i_60_ > ~i; ++i_60_) {
                     this.aShortArray880[i_60_] = (short)stream.readUnsignedShort();
                     this.aShortArray866[i_60_] = (short)stream.readUnsignedShort();
                  }
               } else if (opcode == 42) {
                  i = stream.readUnsignedByte();
                  this.aByteArray861 = new byte[i];

                  for(i_60_ = 0; i > i_60_; ++i_60_) {
                     this.aByteArray861[i_60_] = (byte)stream.readByte();
                  }
               } else if (opcode != 60) {
                  if (opcode == 93) {
                     this.isVisibleOnMap = false;
                  } else if (opcode == 95) {
                     this.combatLevel = stream.readUnsignedShort();
                  } else if (opcode != 97) {
                     if (opcode == 98) {
                        this.anInt899 = stream.readUnsignedShort();
                     } else if (opcode == 99) {
                        this.aBoolean863 = true;
                     } else if (opcode == 100) {
                        this.anInt869 = stream.readByte();
                     } else if (opcode == 101) {
                        this.anInt897 = stream.readByte() * 5;
                     } else if (opcode == 102) {
                        this.headIcons = stream.readUnsignedShort();
                     } else if (opcode != 103) {
                        int i_63_;
                        if (opcode != 106 && opcode != 118) {
                           if (opcode != 107) {
                              if (opcode == 109) {
                                 this.aBoolean852 = false;
                              } else if (opcode != 111) {
                                 if (opcode != 113) {
                                    if (opcode == 114) {
                                       this.aByte851 = (byte)stream.readByte();
                                       this.aByte854 = (byte)stream.readByte();
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
                                                                     if (this.options[opcode - 150].equalsIgnoreCase("Hidden")) {
                                                                        this.options[opcode + -150] = null;
                                                                     }
                                                                  } else if (opcode == 160) {
                                                                     i = stream.readUnsignedByte();
                                                                     this.anIntArray885 = new int[i];

                                                                     for(i_60_ = 0; i > i_60_; ++i_60_) {
                                                                        this.anIntArray885[i_60_] = stream.readUnsignedShort();
                                                                     }
                                                                  } else if (opcode == 155) {
                                                                     stream.readByte();
                                                                     stream.readByte();
                                                                     stream.readByte();
                                                                     stream.readByte();
                                                                  } else if (opcode != 158 && opcode != 159) {
                                                                     if (opcode == 162) {
                                                                        this.aBoolean3190 = true;
                                                                     } else if (opcode == 163) {
                                                                        stream.readUnsignedByte();
                                                                     } else if (opcode == 164) {
                                                                        stream.readUnsignedShort();
                                                                        stream.readUnsignedShort();
                                                                     } else if (opcode == 165) {
                                                                        stream.readUnsignedByte();
                                                                     } else if (opcode == 168) {
                                                                        stream.readUnsignedByte();
                                                                     } else if (opcode == 249) {
                                                                        i = stream.readUnsignedByte();
                                                                        if (this.aClass180_832 == null) {
                                                                           this.aClass180_832 = new HashMap(i);
                                                                        }

                                                                        for(i_60_ = 0; i > i_60_; ++i_60_) {
                                                                           boolean bool = stream.readUnsignedByte() == 1;
                                                                           int key = stream.read24BitInt();
                                                                           Object value;
                                                                           if (bool) {
                                                                              value = stream.readString();
                                                                           } else {
                                                                              value = stream.readInt();
                                                                           }

                                                                           this.aClass180_832.put(key, value);
                                                                        }
                                                                     }
                                                                  }
                                                               } else {
                                                                  this.anInt870 = stream.readUnsignedShort();
                                                               }
                                                            } else {
                                                               this.anInt879 = stream.readUnsignedShort();
                                                            }
                                                         } else {
                                                            this.anInt901 = stream.readUnsignedShort();
                                                         }
                                                      } else {
                                                         this.anInt872 = stream.readUnsignedShort();
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
                                          i = stream.readUnsignedByte();

                                          for(i_60_ = 0; ~i_60_ > ~i; ++i_60_) {
                                             i_63_ = stream.readUnsignedByte();
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
                                    this.aShort862 = (short)stream.readUnsignedShort();
                                    this.aShort894 = (short)stream.readUnsignedShort();
                                 }
                              } else {
                                 this.aBoolean857 = false;
                              }
                           } else {
                              this.aBoolean841 = false;
                           }
                        } else {
                           this.anInt844 = stream.readUnsignedShort();
                           if (this.anInt844 == 65535) {
                              this.anInt844 = -1;
                           }

                           this.anInt888 = stream.readUnsignedShort();
                           if (this.anInt888 == 65535) {
                              this.anInt888 = -1;
                           }

                           i = -1;
                           if (opcode == 118) {
                              i = stream.readUnsignedShort();
                              if (i == 65535) {
                                 i = -1;
                              }
                           }

                           i_60_ = stream.readUnsignedByte();
                           this.anIntArray845 = new int[2 + i_60_];

                           for(i_63_ = 0; i_60_ >= i_63_; ++i_63_) {
                              this.anIntArray845[i_63_] = stream.readUnsignedShort();
                              if (this.anIntArray845[i_63_] == 65535) {
                                 this.anIntArray845[i_63_] = -1;
                              }
                           }

                           this.anIntArray845[i_60_ - -1] = i;
                        }
                     } else {
                        this.anInt853 = stream.readUnsignedShort();
                     }
                  } else {
                     this.anInt864 = stream.readUnsignedShort();
                  }
               } else {
                  i = stream.readUnsignedByte();
                  this.anIntArray892 = new int[i];

                  for(i_60_ = 0; ~i_60_ > ~i; ++i_60_) {
                     this.anIntArray892[i_60_] = stream.readUnsignedShort();
                  }
               }
            } else {
               i = stream.readUnsignedByte();
               this.aShortArray859 = new short[i];
               this.aShortArray896 = new short[i];

               for(i_60_ = 0; ~i < ~i_60_; ++i_60_) {
                  this.aShortArray896[i_60_] = (short)stream.readUnsignedShort();
                  this.aShortArray859[i_60_] = (short)stream.readUnsignedShort();
               }
            }
         } else {
            this.size = stream.readUnsignedByte();
         }
      } else {
         i = stream.readUnsignedByte();
         this.modelIds = new int[i];

         for(i_60_ = 0; i_60_ < i; ++i_60_) {
            this.modelIds[i_60_] = stream.readUnsignedShort();
            if (~this.modelIds[i_60_] == -65536) {
               this.modelIds[i_60_] = -1;
            }
         }
      }

   }

   public boolean hasPickupOption() {
      String[] as;
      int j = (as = this.options).length;

      for(int i = 0; i < j; ++i) {
         String option = as[i];
         if (option != null && option.equalsIgnoreCase("pick-up")) {
            return true;
         }
      }

      return false;
   }

   public boolean hasTakeOption() {
      String[] as;
      int j = (as = this.options).length;

      for(int i = 0; i < j; ++i) {
         String option = as[i];
         if (option != null && option.equalsIgnoreCase("take")) {
            return true;
         }
      }

      return false;
   }

   public static final void clearNPCDefinitions() {
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
      this.aShort862 = 0;
      this.anInt876 = -1;
      this.aByte851 = -96;
      this.anInt875 = 0;
      this.anInt872 = -1;
      this.renderEmote = -1;
      this.respawnDirection = 7;
      this.aBoolean857 = true;
      this.anInt870 = -1;
      this.anInt874 = -1;
      this.anInt833 = -1;
      this.anInt864 = 128;
      this.headIcons = -1;
      this.aBoolean856 = false;
      this.anInt888 = -1;
      this.aByte854 = -16;
      this.aBoolean863 = false;
      this.isVisibleOnMap = true;
      this.anInt889 = -1;
      this.anInt884 = -1;
      this.aBoolean841 = true;
      this.anInt879 = -1;
      this.anInt899 = 128;
      this.aShort894 = 0;
      this.options = new String[5];
      this.anInt897 = 0;
      this.anInt901 = -1;
   }

   public boolean hasMarkOption() {
      String[] var4;
      int var3 = (var4 = this.options).length;

      for(int var2 = 0; var2 < var3; ++var2) {
         String option = var4[var2];
         if (option != null && option.equalsIgnoreCase("mark")) {
            return true;
         }
      }

      return false;
   }

   public boolean hasOption(String op) {
      String[] var5;
      int var4 = (var5 = this.options).length;

      for(int var3 = 0; var3 < var4; ++var3) {
         String option = var5[var3];
         if (option != null && option.equalsIgnoreCase(op)) {
            return true;
         }
      }

      return false;
   }

   public boolean hasAttackOption() {
      String[] var4;
      int var3 = (var4 = this.options).length;

      for(int var2 = 0; var2 < var3; ++var2) {
         String option = var4[var2];
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

   public static final NPCDefinitions getNPCDefinitions(String name) {
      for(int i = 0; i < Utils.getNPCDefinitionsSize(); ++i) {
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
}
