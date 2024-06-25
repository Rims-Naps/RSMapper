package org.rsmapper.cache.loaders;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.rsmapper.cache.Cache;
import org.rsmapper.networking.codec.stream.InputStream;
import org.rsmapper.utilities.misc.Utils;

public class AreaDefinitions {
   private static final ConcurrentHashMap<Integer, AreaDefinitions> areaDefs = new ConcurrentHashMap();
   public int id;
   public int spriteId = -1;
   public int backgroundSpriteId;
   public String name;
   public int anInt2646;
   public int anInt2647;
   public int anInt2663;
   public boolean aBool2640;
   public boolean aBool2655;
   public int configbyfileId;
   public int configId;
   public int anInt2659;
   public int anInt2660;
   public String[] aStringArray2656 = new String[5];
   public int[] anIntArray2668;
   public int anInt2673;
   public int[] anIntArray2681;
   public byte[] aByteArray2682;
   public boolean aBool2684;
   public String aString2649;
   public int anInt2658;
   public int type;
   public int configByFileId2;
   public int configId2;
   public int anInt2677;
   public int anInt2674;
   public int anInt2653;
   public int anInt2652;
   public int anInt2644;
   public int anInt2675;
   public int anInt2676;
   public int anInt2641;
   public int anInt2678;
   public int newSpriteId = -1;
   public int[] anIntArray2667;
   public int anInt2683;
   public int[] aClass278_2679;
   public int[] aClass290_2666;
   public HashMap<Integer, Object> clientScriptData;

   public static void main(String[] args) throws IOException {
      Cache.init();
      System.out.println(Utils.getAreaDefinitionsSize());

      for(int i = 0; i < Utils.getAreaDefinitionsSize(); ++i) {
         AreaDefinitions defs = getAreaDefinitions(i);
         if (defs.anIntArray2667 != null && (defs.anIntArray2667[1] == 3458 || defs.anIntArray2667[0] == 3458 || defs.anIntArray2667[2] == 3458)) {
            System.out.println(defs);
         }
      }

      AreaDefinitions oldDefs = getAreaDefinitions(696);
      System.out.println(oldDefs);
   }

   public String toString() {
      return "AreaDefinitions [id=" + this.id + ", spriteId=" + this.spriteId + ", backgroundSpriteId=" + this.backgroundSpriteId + ", name=" + this.name + ", anInt2646=" + this.anInt2646 + ", anInt2647=" + this.anInt2647 + ", anInt2663=" + this.anInt2663 + ", aBool2640=" + this.aBool2640 + ", aBool2655=" + this.aBool2655 + ", configbyfileId=" + this.configbyfileId + ", configId=" + this.configId + ", anInt2659=" + this.anInt2659 + ", anInt2660=" + this.anInt2660 + ", aStringArray2656=" + Arrays.toString(this.aStringArray2656) + ", anIntArray2668=" + Arrays.toString(this.anIntArray2668) + ", anInt2673=" + this.anInt2673 + ", anIntArray2681=" + Arrays.toString(this.anIntArray2681) + ", aByteArray2682=" + Arrays.toString(this.aByteArray2682) + ", aBool2684=" + this.aBool2684 + ", aString2649=" + this.aString2649 + ", anInt2658=" + this.anInt2658 + ", type=" + this.type + ", configByFileId2=" + this.configByFileId2 + ", configId2=" + this.configId2 + ", anInt2677=" + this.anInt2677 + ", anInt2674=" + this.anInt2674 + ", anInt2653=" + this.anInt2653 + ", anInt2652=" + this.anInt2652 + ", anInt2644=" + this.anInt2644 + ", anInt2675=" + this.anInt2675 + ", anInt2676=" + this.anInt2676 + ", anInt2641=" + this.anInt2641 + ", anInt2678=" + this.anInt2678 + ", newSpriteId=" + this.newSpriteId + ", anIntArray2667=" + Arrays.toString(this.anIntArray2667) + ", anInt2683=" + this.anInt2683 + ", aClass278_2679=" + Arrays.toString(this.aClass278_2679) + ", aClass290_2666=" + Arrays.toString(this.aClass290_2666) + ", clientScriptData=" + this.clientScriptData + "]";
   }

   public static final AreaDefinitions getAreaDefinitions(int areaId) {
      try {
         AreaDefinitions defs = (AreaDefinitions)areaDefs.get(areaId);
         if (defs != null) {
            return defs;
         } else {
            byte[] data = Cache.STORE.getIndexes()[2].getFile(36, areaId);
            defs = new AreaDefinitions();
            defs.id = areaId;
            if (data != null) {
               defs.readValueLoop(new InputStream(data));
            }

            areaDefs.put(areaId, defs);
            return defs;
         }
      } catch (Throwable var3) {
         var3.printStackTrace();
         return null;
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

   private void readValues(InputStream buffer, int opcode) {
      if (1 == opcode) {
         this.spriteId = buffer.readBigSmart();
      } else if (opcode == 2) {
         this.backgroundSpriteId = buffer.readBigSmart();
      } else if (3 == opcode) {
         this.name = buffer.readString();
      } else if (4 == opcode) {
         this.anInt2646 = buffer.read24BitInt();
      } else if (5 == opcode) {
         this.anInt2647 = buffer.read24BitInt();
      } else if (opcode == 6) {
         this.anInt2663 = buffer.readUnsignedByte();
      } else {
         int length;
         if (7 == opcode) {
            length = buffer.readUnsignedByte();
            if ((length & 1) == 0) {
               this.aBool2640 = false;
            }

            if ((length & 2) == 2) {
               this.aBool2655 = true;
            }
         } else if (8 == opcode) {
            buffer.readUnsignedByte();
         } else if (9 == opcode) {
            this.configbyfileId = buffer.readUnsignedShort();
            if (65535 == this.configbyfileId) {
               this.configbyfileId = -1;
            }

            this.configId = buffer.readUnsignedShort();
            if (this.configId == 65535) {
               this.configId = -1;
            }

            this.anInt2659 = buffer.readInt();
            this.anInt2660 = buffer.readInt();
         } else if (opcode >= 10 && opcode <= 14) {
            this.aStringArray2656[opcode - 10] = buffer.readString();
         } else {
            int index;
            int i_17_;
            if (opcode == 15) {
               length = buffer.readUnsignedByte();
               this.anIntArray2668 = new int[2 * length];

               for(index = 0; index < 2 * length; ++index) {
                  this.anIntArray2668[index] = buffer.readShort();
               }

               this.anInt2673 = buffer.readInt();
               index = buffer.readUnsignedByte();
               this.anIntArray2681 = new int[index];

               for(i_17_ = 0; i_17_ < this.anIntArray2681.length; ++i_17_) {
                  this.anIntArray2681[i_17_] = buffer.readInt();
               }

               this.aByteArray2682 = new byte[length];

               for(i_17_ = 0; i_17_ < length; ++i_17_) {
                  this.aByteArray2682[i_17_] = (byte)buffer.readByte();
               }
            } else if (opcode == 16) {
               this.aBool2684 = false;
            } else if (17 == opcode) {
               this.aString2649 = buffer.readString();
            } else if (18 == opcode) {
               this.anInt2658 = buffer.readBigSmart();
            } else if (19 == opcode) {
               this.type = buffer.readUnsignedShort();
            } else if (20 == opcode) {
               this.configByFileId2 = buffer.readUnsignedShort();
               if (this.configByFileId2 == 65535) {
                  this.configByFileId2 = -1;
               }

               this.configId2 = buffer.readUnsignedShort();
               if (this.configId2 == 65535) {
                  this.configId2 = -1;
               }

               this.anInt2677 = buffer.readInt();
               this.anInt2674 = buffer.readInt();
            } else if (opcode == 21) {
               this.anInt2653 = buffer.readInt();
            } else if (22 == opcode) {
               this.anInt2652 = buffer.readInt();
            } else if (opcode == 23) {
               this.anInt2644 = buffer.readUnsignedByte();
               this.anInt2675 = buffer.readUnsignedByte();
               this.anInt2676 = buffer.readUnsignedByte();
            } else if (opcode == 24) {
               this.anInt2641 = buffer.readShort();
               this.anInt2678 = buffer.readShort();
            } else if (25 == opcode) {
               this.newSpriteId = buffer.readBigSmart();
            } else if (opcode != 26 && opcode != 27) {
               if (opcode == 28) {
                  this.anInt2683 = buffer.readUnsignedByte();
               } else if (29 == opcode) {
                  this.aClass278_2679 = new int[2];
                  switch(buffer.readUnsignedByte()) {
                  case 0:
                     this.aClass278_2679 = new int[]{0, 2};
                     break;
                  case 1:
                     this.aClass278_2679 = new int[]{1, 1};
                     break;
                  case 2:
                     this.aClass278_2679 = new int[]{2, 0};
                  }
               } else if (opcode == 30) {
                  this.aClass290_2666 = new int[2];
                  switch(buffer.readUnsignedByte()) {
                  case 0:
                     this.aClass290_2666 = new int[2];
                     break;
                  case 1:
                     this.aClass290_2666 = new int[]{1, 2};
                     break;
                  case 2:
                     this.aClass290_2666 = new int[]{2, 1};
                  }
               } else if (opcode == 249) {
                  length = buffer.readUnsignedByte();
                  if (this.clientScriptData == null) {
                     this.clientScriptData = new HashMap(length);
                  }

                  for(index = 0; index < length; ++index) {
                     boolean stringInstance = buffer.readUnsignedByte() == 1;
                     int key = buffer.read24BitInt();
                     Object value = stringInstance ? buffer.readString() : buffer.readInt();
                     this.clientScriptData.put(key, value);
                  }
               }
            } else {
               this.configbyfileId = buffer.readUnsignedShort();
               if (65535 == this.configbyfileId) {
                  this.configbyfileId = -1;
               }

               this.configId = buffer.readUnsignedShort();
               if (65535 == this.configId) {
                  this.configId = -1;
               }

               length = -1;
               if (27 == opcode) {
                  length = buffer.readUnsignedShort();
                  if (65535 == length) {
                     length = -1;
                  }
               }

               index = buffer.readUnsignedByte();
               this.anIntArray2667 = new int[index + 2];

               for(i_17_ = 0; i_17_ <= index; ++i_17_) {
                  this.anIntArray2667[i_17_] = buffer.readUnsignedShort();
                  if (this.anIntArray2667[i_17_] == 65535) {
                     this.anIntArray2667[i_17_] = -1;
                  }
               }

               this.anIntArray2667[index + 1] = length;
            }
         }
      }

   }
}
