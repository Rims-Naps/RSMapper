package com.alex.loaders.objects;

import com.alex.io.InputStream;
import com.alex.io.OutputStream;
import com.alex.store.Store;
import com.alex.utils.Utils;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.rsmapper.game.player.Player;

public class ObjectDefinitions {
   private static final ConcurrentHashMap<Integer, ObjectDefinitions> objectDefinitions = new ConcurrentHashMap();
   public short[] originalColours;
   public int[] switchIds;
   static int anInt3832 = -2;
   public int[] animations = null;
   private int anInt3834 = -2;
   int anInt3835 = -2;
   static int anInt3836 = -2;
   private byte aByte3837 = -2;
   int anInt3838 = -1;
   boolean aBoolean3839;
   private int anInt3840 = -2;
   private int anInt3841 = -2;
   static int anInt3842 = -2;
   static int anInt3843 = -2;
   int anInt3844 = -2;
   boolean aBoolean3845;
   static int anInt3846 = -2;
   int firstOp = -2;
   boolean bothOp;
   private byte aByte3847 = -2;
   private byte aByte3849 = -2;
   int anInt3850 = -2;
   int anInt3851 = -2;
   public boolean secondBool;
   public boolean aBoolean3853;
   int anInt3855 = -2;
   public boolean ignoreClipOnAlternativeRoute;
   int anInt3857 = -2;
   private byte[] aByteArray3858;
   int[] anIntArray3859;
   int anInt3860 = -2;
   public String[] options;
   public int configFileId = -2;
   public short[] modifiedColours;
   int anInt3865 = -2;
   boolean aBoolean3866;
   boolean aBoolean3867;
   public boolean projectileClipped;
   private int[] anIntArray3869;
   boolean aBoolean3870;
   public int sizeY;
   boolean aBoolean3872;
   boolean aBoolean3873;
   public int thirdInt;
   private int anInt3875 = -2;
   public int animation;
   private int anInt3877 = -2;
   private int anInt3878 = -2;
   public int clipType;
   private int anInt3881 = -2;
   private int anInt3882 = -2;
   private int anInt3883 = -2;
   Object loader;
   private int anInt3889 = -2;
   public int sizeX;
   public boolean aBoolean3891;
   int anInt3892 = -2;
   public int secondInt;
   boolean aBoolean3894;
   boolean aBoolean3895;
   int anInt3896 = -2;
   int configId;
   private byte[] possibleTypes;
   int anInt3900 = -2;
   public String name;
   private int anInt3902 = -2;
   int anInt3904 = -2;
   int anInt3905 = -2;
   boolean aBoolean3906;
   int[] anIntArray3908;
   private byte aByte3912 = -2;
   int anInt3913 = -2;
   private byte aByte3914;
   private int anInt3915 = -2;
   public int[][] modelIds;
   private int anInt3917 = -2;
   public short[] modifiedTextures;
   public short[] originalTextures;
   int anInt3921 = -2;
   private HashMap<Integer, Object> parameters;
   boolean aBoolean3923;
   boolean aBoolean3924;
   int anInt3925 = -2;
   public int id;
   private int[] anIntArray4534;
   private byte[] unknownArray4;
   private byte[] unknownArray3;
   private int cflag;
   private int anInt3383 = -2;
   private int anInt3362 = -2;
   private int anInt3302 = -2;
   private int anInt3336 = -2;
   private boolean ub;
   private int db;
   private boolean bloom;

   public static void configByFile(Store cache, int objectId, Player player) {
      ObjectDefinitions defs = getObjectDefinitions(cache, objectId);
      player.getPackets().sendGameMessage("ConfigByFile ID is: " + defs.configFileId);
   }

   public static int[] findDoorPairs(Store cache, int openDoorId) {
      ObjectDefinitions open = getObjectDefinitions(cache, openDoorId);
      if (open != null && open.modelIds != null) {
         int length = 0;

         for(int i = 0; i < open.modelIds.length; ++i) {
            length += open.modelIds[i].length;
         }

         int[] allModels = new int[length];
         int[] pairs = new int[100];
         int count = 0;

         label61:
         for(int x = 0; x < Utils.getObjectDefinitionsSize(cache); ++x) {
            ObjectDefinitions other = getObjectDefinitions(cache, x);
            if (other != null && other != open && other.modelIds != null && open.modelIds.length == other.modelIds.length) {
               for(int a = 0; a < open.modelIds.length; ++a) {
                  if (open.modelIds[a].length != other.modelIds[a].length) {
                     continue label61;
                  }

                  int[] a1 = open.modelIds[a];
                  int[] a2 = other.modelIds[a];

                  for(int b = 0; b < a1.length; ++b) {
                     if (a1[b] != a2[b]) {
                        continue label61;
                     }
                  }
               }

               pairs[count++] = x;
            }
         }

         if (count == pairs.length) {
            return pairs;
         } else {
            int[] rebuff = new int[count];
            System.arraycopy(pairs, 0, rebuff, 0, count);
            return rebuff;
         }
      } else {
         return new int[0];
      }
   }

   public String getFirstOption() {
      return this.options != null && this.options.length >= 1 ? this.options[0] : "";
   }

   public String getSecondOption() {
      return this.options != null && this.options.length >= 2 ? this.options[1] : "";
   }

   public String getOption(int option) {
      return this.options != null && this.options.length >= option && option != 0 ? this.options[option - 1] : "";
   }

   public String getThirdOption() {
      return this.options != null && this.options.length >= 3 ? this.options[2] : "";
   }

   public boolean containsOption(int i, String option) {
      return this.options != null && this.options[i] != null && this.options.length > i ? this.options[i].equals(option) : false;
   }

   public boolean containsOption(String o) {
      if (this.options == null) {
         return false;
      } else {
         String[] var5;
         int var4 = (var5 = this.options).length;

         for(int var3 = 0; var3 < var4; ++var3) {
            String option = var5[var3];
            if (option != null && option.equalsIgnoreCase(o)) {
               return true;
            }
         }

         return false;
      }
   }

   private void readValues(InputStream stream, int opcode) {
      int i_60_;
      int i_57_;
      int i_61_;
      if (opcode != 1 && opcode != 5) {
         if (opcode == 2) {
            this.name = stream.readString();
         } else if (opcode == 14) {
            this.sizeX = stream.readUnsignedByte();
         } else if (opcode == 15) {
            this.sizeY = stream.readUnsignedByte();
         } else if (opcode == 17) {
            this.projectileClipped = false;
            this.clipType = 0;
         } else if (opcode == 18) {
            this.projectileClipped = false;
         } else if (opcode == 19) {
            this.secondInt = stream.readUnsignedByte();
         } else if (opcode == 21) {
            this.aByte3912 = 1;
         } else if (opcode == 22) {
            this.aBoolean3867 = true;
         } else if (opcode == 23) {
            this.thirdInt = 1;
         } else if (opcode == 24) {
            this.animation = stream.readBigSmart();
         } else if (opcode == 27) {
            this.clipType = 1;
         } else if (opcode == 28) {
            this.anInt3892 = stream.readUnsignedByte() << 2;
         } else if (opcode == 29) {
            this.anInt3878 = stream.readByte();
         } else if (opcode >= 30 && opcode < 35) {
            this.options[opcode - 30] = stream.readString();
         } else if (opcode == 39) {
            this.anInt3840 = stream.readByte() * 5;
         } else {
            int length;
            if (opcode == 40) {
               length = stream.readUnsignedByte();
               this.originalColours = new short[length];
               this.modifiedColours = new short[length];

               for(i_60_ = 0; length > i_60_; ++i_60_) {
                  this.originalColours[i_60_] = (short)stream.readUnsignedShort();
                  this.modifiedColours[i_60_] = (short)stream.readUnsignedShort();
               }
            } else if (opcode == 41) {
               length = stream.readUnsignedByte();
               this.originalTextures = new short[length];
               this.modifiedTextures = new short[length];

               for(i_60_ = 0; length > i_60_; ++i_60_) {
                  this.originalTextures[i_60_] = (short)stream.readUnsignedShort();
                  this.modifiedTextures[i_60_] = (short)stream.readUnsignedShort();
               }
            } else if (opcode == 42) {
               length = stream.readUnsignedByte();
               this.aByteArray3858 = new byte[length];

               for(i_60_ = 0; i_60_ < length; ++i_60_) {
                  this.aByteArray3858[i_60_] = (byte)stream.readByte();
               }
            } else {
               short i_91_;
               byte i_94_;
               if (opcode == 44) {
                  i_91_ = (short)stream.readUnsignedShort();
                  i_60_ = 0;

                  for(i_57_ = i_91_; i_57_ > 0; i_57_ >>= 1) {
                     ++i_60_;
                  }

                  this.unknownArray3 = new byte[i_60_];
                  i_94_ = 0;

                  for(i_61_ = 0; i_61_ < i_60_; ++i_61_) {
                     if ((i_91_ & 1 << i_61_) > 0) {
                        this.unknownArray3[i_61_] = i_94_++;
                     } else {
                        this.unknownArray3[i_61_] = -1;
                     }
                  }
               } else if (opcode == 45) {
                  i_91_ = (short)stream.readUnsignedShort();
                  i_60_ = 0;

                  for(i_57_ = i_91_; i_57_ > 0; i_57_ >>= 1) {
                     ++i_60_;
                  }

                  this.unknownArray4 = new byte[i_60_];
                  i_94_ = 0;

                  for(i_61_ = 0; i_61_ < i_60_; ++i_61_) {
                     if ((i_91_ & 1 << i_61_) > 0) {
                        this.unknownArray4[i_61_] = i_94_++;
                     } else {
                        this.unknownArray4[i_61_] = -1;
                     }
                  }
               } else if (opcode == 62) {
                  this.aBoolean3839 = true;
               } else if (opcode == 64) {
                  this.aBoolean3872 = false;
               } else if (opcode == 65) {
                  this.anInt3902 = stream.readUnsignedShort();
               } else if (opcode == 66) {
                  this.anInt3841 = stream.readUnsignedShort();
               } else if (opcode == 67) {
                  this.anInt3917 = stream.readUnsignedShort();
               } else if (opcode == 69) {
                  this.cflag = stream.readUnsignedByte();
               } else if (opcode == 70) {
                  this.anInt3883 = stream.readShort() << 2;
               } else if (opcode == 71) {
                  this.anInt3889 = stream.readShort() << 2;
               } else if (opcode == 72) {
                  this.anInt3915 = stream.readShort() << 2;
               } else if (opcode == 73) {
                  this.secondBool = true;
               } else if (opcode == 74) {
                  this.ignoreClipOnAlternativeRoute = true;
               } else if (opcode == 75) {
                  this.anInt3855 = stream.readUnsignedByte();
               } else if (opcode != 77 && opcode != 92) {
                  if (opcode == 78) {
                     this.anInt3860 = stream.readUnsignedShort();
                     this.anInt3904 = stream.readUnsignedByte();
                  } else if (opcode == 79) {
                     this.anInt3900 = stream.readUnsignedShort();
                     this.anInt3905 = stream.readUnsignedShort();
                     this.anInt3904 = stream.readUnsignedByte();
                     length = stream.readUnsignedByte();
                     this.anIntArray3859 = new int[length];

                     for(i_60_ = 0; i_60_ < length; ++i_60_) {
                        this.anIntArray3859[i_60_] = stream.readUnsignedShort();
                     }
                  } else if (opcode == 81) {
                     this.aByte3912 = 2;
                     this.anInt3882 = 256 * stream.readUnsignedByte();
                  } else if (opcode == 82) {
                     this.aBoolean3891 = true;
                  } else if (opcode == 88) {
                     this.aBoolean3853 = false;
                  } else if (opcode == 89) {
                     this.aBoolean3895 = false;
                  } else if (opcode == 90) {
                     this.aBoolean3870 = true;
                  } else if (opcode == 91) {
                     this.aBoolean3873 = true;
                  } else if (opcode == 93) {
                     this.aByte3912 = 3;
                     this.anInt3882 = stream.readUnsignedShort();
                  } else if (opcode == 94) {
                     this.aByte3912 = 4;
                  } else if (opcode == 95) {
                     this.aByte3912 = 5;
                     this.anInt3882 = stream.readShort();
                  } else if (opcode == 96) {
                     this.aBoolean3924 = true;
                  } else if (opcode == 97) {
                     this.aBoolean3866 = true;
                  } else if (opcode == 98) {
                     this.aBoolean3923 = true;
                  } else if (opcode == 99) {
                     this.anInt3857 = stream.readUnsignedByte();
                     this.anInt3835 = stream.readUnsignedShort();
                  } else if (opcode == 100) {
                     this.anInt3844 = stream.readUnsignedByte();
                     this.anInt3913 = stream.readUnsignedShort();
                  } else if (opcode == 101) {
                     this.anInt3850 = stream.readUnsignedByte();
                  } else if (opcode == 102) {
                     this.anInt3838 = stream.readUnsignedShort();
                  } else if (opcode == 103) {
                     this.thirdInt = 0;
                  } else if (opcode == 104) {
                     this.anInt3865 = stream.readUnsignedByte();
                  } else if (opcode == 105) {
                     this.aBoolean3906 = true;
                  } else if (opcode == 106) {
                     length = stream.readUnsignedByte();
                     this.anIntArray3869 = new int[length];
                     this.animations = new int[length];

                     for(i_60_ = 0; i_60_ < length; ++i_60_) {
                        this.animations[i_60_] = stream.readBigSmart();
                        i_57_ = stream.readUnsignedByte();
                        this.anIntArray3869[i_60_] = i_57_;
                        this.anInt3881 += i_57_;
                     }
                  } else if (opcode == 107) {
                     this.anInt3851 = stream.readUnsignedShort();
                  } else if (opcode >= 150 && opcode < 155) {
                     this.options[opcode - 150] = stream.readString();
                  } else if (opcode == 160) {
                     length = stream.readUnsignedByte();
                     this.anIntArray3908 = new int[length];

                     for(i_60_ = 0; length > i_60_; ++i_60_) {
                        this.anIntArray3908[i_60_] = stream.readUnsignedShort();
                     }
                  } else if (opcode == 162) {
                     this.aByte3912 = 3;
                     this.anInt3882 = stream.readInt();
                  } else if (opcode == 163) {
                     this.aByte3847 = (byte)stream.readByte();
                     this.aByte3849 = (byte)stream.readByte();
                     this.aByte3837 = (byte)stream.readByte();
                     this.aByte3914 = (byte)stream.readByte();
                  } else if (opcode == 164) {
                     this.anInt3834 = stream.readShort();
                  } else if (opcode == 165) {
                     this.anInt3875 = stream.readShort();
                  } else if (opcode == 166) {
                     this.anInt3877 = stream.readShort();
                  } else if (opcode == 167) {
                     this.anInt3921 = stream.readUnsignedShort();
                  } else if (opcode == 168) {
                     this.aBoolean3894 = true;
                  } else if (opcode == 169) {
                     this.aBoolean3845 = true;
                  } else if (opcode == 170) {
                     this.anInt3383 = stream.readUnsignedSmart();
                  } else if (opcode == 171) {
                     this.anInt3362 = stream.readUnsignedSmart();
                  } else if (opcode == 173) {
                     this.anInt3302 = stream.readUnsignedShort();
                     this.anInt3336 = stream.readUnsignedShort();
                  } else if (opcode == 177) {
                     this.ub = true;
                  } else if (opcode == 178) {
                     this.db = stream.readUnsignedByte();
                  } else if (opcode == 189) {
                     this.bloom = true;
                  } else if (opcode >= 190 && opcode < 196) {
                     if (this.anIntArray4534 == null) {
                        this.anIntArray4534 = new int[6];
                        Arrays.fill(this.anIntArray4534, -1);
                     }

                     this.anIntArray4534[opcode - 190] = stream.readUnsignedShort();
                  } else if (opcode == 249) {
                     length = stream.readUnsignedByte();
                     if (this.parameters == null) {
                        this.parameters = new HashMap(length);
                     }

                     for(i_60_ = 0; i_60_ < length; ++i_60_) {
                        boolean bool = stream.readUnsignedByte() == 1;
                        i_61_ = stream.readInt();
                        if (!bool) {
                           this.parameters.put(i_61_, stream.readInt());
                        } else {
                           this.parameters.put(i_61_, stream.readString());
                        }
                     }
                  }
               } else {
                  this.configFileId = stream.readUnsignedShort();
                  if (this.configFileId == 65535) {
                     this.configFileId = -1;
                  }

                  this.configId = stream.readUnsignedShort();
                  if (this.configId == 65535) {
                     this.configId = -1;
                  }

                  length = -1;
                  if (opcode == 92) {
                     length = stream.readBigSmart();
                  }

                  i_60_ = stream.readUnsignedByte();
                  this.switchIds = new int[i_60_ - -2];

                  for(i_57_ = 0; i_60_ >= i_57_; ++i_57_) {
                     this.switchIds[i_57_] = stream.readBigSmart();
                  }

                  this.switchIds[i_60_ + 1] = length;
               }
            }
         }
      } else {
         boolean aBoolean1162 = false;
         if (this.firstOp != 0) {
            this.firstOp = opcode;
         } else {
            this.bothOp = true;
         }

         if (opcode == 5 && aBoolean1162) {
            this.skipReadModelIds(stream);
         }

         i_60_ = stream.readUnsignedByte();
         this.modelIds = new int[i_60_][];
         this.possibleTypes = new byte[i_60_];

         for(i_57_ = 0; i_57_ < i_60_; ++i_57_) {
            this.possibleTypes[i_57_] = (byte)stream.readByte();
            i_61_ = stream.readUnsignedByte();
            this.modelIds[i_57_] = new int[i_61_];

            for(int index2 = 0; i_61_ > index2; ++index2) {
               this.modelIds[i_57_][index2] = stream.readBigSmart();
            }
         }

         if (opcode == 5 && !aBoolean1162) {
            this.skipReadModelIds(stream);
         }
      }

   }

   public byte[] encode() {
      OutputStream out = new OutputStream();
      int key;
      if (this.modelIds != null) {
         out.writeByte(1);
         out.writeByte(this.modelIds.length);

         for(key = 0; key < this.modelIds.length; ++key) {
            out.writeByte(this.possibleTypes[key]);
            int[] models = this.modelIds[key];
            out.writeByte(models.length);

            for(int index = 0; index < models.length; ++index) {
               out.writeBigSmart(models[index]);
            }
         }
      }

      if (this.name != null) {
         out.writeByte(2);
         out.writeString(this.name);
      }

      out.writeByte(14);
      out.writeByte(this.sizeX);
      out.writeByte(15);
      out.writeByte(this.sizeY);
      if (this.aByte3912 == 1) {
         out.writeByte(21);
      }

      out.writeByte(24);
      out.writeBigSmart(this.animation);
      if (this.clipType == 1) {
         out.writeByte(27);
      }

      for(key = 0; key < 5; ++key) {
         if (this.options[key] != null) {
            out.writeByte(30 + key);
            out.writeString(this.options[key]);
         }
      }

      if (this.modifiedColours != null) {
         out.writeByte(40);
         out.writeByte(this.modifiedColours.length);

         for(key = 0; key < this.modifiedColours.length; ++key) {
            out.writeShort(this.originalColours[key]);
            out.writeShort(this.modifiedColours[key]);
         }
      }

      if (this.modifiedTextures != null) {
         out.writeByte(41);
         out.writeByte(this.modifiedTextures.length);

         for(key = 0; key < this.modifiedTextures.length; ++key) {
            out.writeShort(this.originalTextures[key]);
            out.writeShort(this.modifiedTextures[key]);
         }
      }

      if (this.ignoreClipOnAlternativeRoute) {
         out.writeByte(74);
      }

      out.writeByte(75);
      out.writeByte(this.anInt3855);
      out.writeByte(78);
      out.writeShort(this.anInt3860);
      out.writeByte(this.anInt3904);
      if (this.thirdInt == 0) {
         out.writeByte(103);
      }

      if (this.anIntArray4534 != null) {
         for(key = 0; key < this.anIntArray4534.length; ++key) {
            if (this.anIntArray4534[key] != -1 && this.anIntArray4534[key] != 65535) {
               out.writeByte(190 + key);
               out.writeShort(this.anIntArray4534[key]);
            }
         }
      }

      if (this.parameters != null) {
         out.writeByte(249);
         out.writeByte(this.parameters.size());
         Iterator var6 = this.parameters.keySet().iterator();

         while(var6.hasNext()) {
            key = (Integer)var6.next();
            Object value = this.parameters.get(key);
            boolean string_value = value instanceof String;
            out.writeByte(string_value ? 1 : 0);
            out.writeByte(key);
            if (string_value) {
               out.writeString((String)value);
            } else {
               out.writeInt((Integer)value);
            }
         }
      }

      out.writeByte(0);
      byte[] data = new byte[out.getOffset()];
      out.setOffset(0);
      out.getBytes(data, 0, data.length);
      return data;
   }

   private void skipReadModelIds(InputStream stream) {
      int length = stream.readUnsignedByte();

      for(int index = 0; index < length; ++index) {
         stream.skip(1);
         int length2 = stream.readUnsignedByte();

         for(int i = 0; i < length2; ++i) {
            stream.readBigSmart();
         }
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

   private ObjectDefinitions() {
      this.anInt3835 = -1;
      this.anInt3860 = -1;
      this.configFileId = -1;
      this.aBoolean3866 = false;
      this.anInt3851 = -1;
      this.anInt3865 = 255;
      this.aBoolean3845 = false;
      this.aBoolean3867 = false;
      this.anInt3850 = 0;
      this.anInt3844 = -1;
      this.anInt3881 = 0;
      this.anInt3857 = -1;
      this.aBoolean3872 = true;
      this.anInt3882 = -1;
      this.anInt3834 = 0;
      this.options = new String[5];
      this.anInt3875 = 0;
      this.aBoolean3839 = false;
      this.anIntArray3869 = null;
      this.sizeY = 1;
      this.thirdInt = -1;
      this.anInt3883 = 0;
      this.aBoolean3895 = true;
      this.anInt3840 = 0;
      this.aBoolean3870 = false;
      this.anInt3889 = 0;
      this.aBoolean3853 = true;
      this.secondBool = false;
      this.clipType = 2;
      this.projectileClipped = true;
      this.ignoreClipOnAlternativeRoute = false;
      this.anInt3855 = -1;
      this.anInt3878 = 0;
      this.anInt3904 = 0;
      this.sizeX = 1;
      this.animation = -1;
      this.aBoolean3891 = false;
      this.anInt3905 = 0;
      this.name = "null";
      this.anInt3913 = -1;
      this.aBoolean3906 = false;
      this.aBoolean3873 = false;
      this.aByte3914 = 0;
      this.anInt3915 = 0;
      this.anInt3900 = 0;
      this.secondInt = -1;
      this.aBoolean3894 = false;
      this.aByte3912 = 0;
      this.anInt3921 = 0;
      this.anInt3902 = 128;
      this.configId = -1;
      this.anInt3877 = 0;
      this.anInt3925 = 0;
      this.anInt3892 = 64;
      this.aBoolean3923 = false;
      this.aBoolean3924 = false;
      this.anInt3841 = 128;
      this.anInt3917 = 128;
   }

   final void method3287() {
      if (this.secondInt == -1) {
         this.secondInt = 0;
         if (this.possibleTypes != null && this.possibleTypes.length == 1 && this.possibleTypes[0] == 10) {
            this.secondInt = 1;
         }

         for(int i_13_ = 0; i_13_ < 5; ++i_13_) {
            if (this.options[i_13_] != null) {
               this.secondInt = 1;
               break;
            }
         }
      }

      if (this.anInt3855 == -1) {
         this.anInt3855 = this.clipType != 0 ? 1 : 0;
      }

   }

   public int getArchiveId() {
      return this.id >>> -1135990488;
   }

   public static ObjectDefinitions getObjectDefinitions(Store cache, int id) {
      try {
         ObjectDefinitions def = (ObjectDefinitions)objectDefinitions.get(id);
         if (def == null) {
            def = new ObjectDefinitions();
            def.id = id;
            byte[] data = cache.getIndexes()[16].getFile(def.getArchiveId(), id & 255);
            if (data != null) {
               def.readValueLoop(new InputStream(data));
            }

            def.method3287();
            objectDefinitions.put(id, def);
         }

         return def;
      } catch (Exception var4) {
         var4.printStackTrace();
         return null;
      }
   }

   public int getClipType() {
      return this.clipType;
   }

   public boolean isProjectileCliped() {
      return this.projectileClipped;
   }

   public int getSizeX() {
      return this.sizeX;
   }

   public int getSizeY() {
      return this.sizeY;
   }

   public int getAccessBlockFlag() {
      return this.cflag;
   }

   public static void clearObjectDefinitions() {
      objectDefinitions.clear();
   }

   public void printFields() {
      Field[] var4;
      int var3 = (var4 = this.getClass().getDeclaredFields()).length;

      for(int var2 = 0; var2 < var3; ++var2) {
         Field field = var4[var2];
         if ((field.getModifiers() & 8) != 0) {
         }
      }

   }

   private Object getValue(Field field) throws Throwable {
      field.setAccessible(true);
      Class<?> type = field.getType();
      if (type == int[][].class) {
         return Arrays.toString((int[][])field.get(this));
      } else if (type == int[].class) {
         return Arrays.toString((int[])field.get(this));
      } else if (type == byte[].class) {
         return Arrays.toString((byte[])field.get(this));
      } else if (type == short[].class) {
         return Arrays.toString((short[])field.get(this));
      } else if (type == double[].class) {
         return Arrays.toString((double[])field.get(this));
      } else if (type == float[].class) {
         return Arrays.toString((float[])field.get(this));
      } else {
         return type == Object[].class ? Arrays.toString((Object[])field.get(this)) : field.get(this);
      }
   }
}
