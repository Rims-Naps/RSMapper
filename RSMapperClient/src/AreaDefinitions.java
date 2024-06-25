import com.dropbox.core.v2.DbxClientV2;
import java.lang.reflect.Method;

public class AreaDefinitions {
   private int anInt1042;
   static int anInt1043;
   private int configId2 = -1;
   protected String baseOption;
   static int anInt1046;
   protected boolean aBoolean1047;
   private int configByFileId2;
   protected int[] anIntArray1049;
   protected int anInt1050 = -1;
   protected int anInt1051;
   static boolean aBoolean1052 = false;
   private HashTable clientScriptData;
   protected int anInt1054;
   protected int anInt1055;
   protected int hoverSpriteId;
   protected byte[] aByteArray1057;
   protected int textColor;
   static int anInt1059;
   protected int anInt1060;
   static int anInt1061;
   protected int spriteId;
   protected boolean aBoolean1063;
   protected boolean aBoolean1064;
   protected String[] rightClickOptions;
   protected int[] anIntArray1066;
   protected int type;
   protected int anInt1068;
   private int configbyfileId;
   static int[][] anIntArrayArray1070;
   protected int anInt1071;
   private int anInt1072;
   static int anInt1073;
   protected int anInt1074;
   static int anInt1075;
   protected Class215 aClass215_1076;
   protected int anInt1077;
   private int anInt1078;
   protected boolean aBoolean1079;
   protected int anInt1080;
   protected int anInt1081;
   static IComponentDefinitions[][] aWidgetArrayArray1082;
   static int anInt1083;
   protected int anInt1084;
   protected String nameLabel;
   static int anInt1086;
   private int anInt1087;
   static int anInt1088;
   protected int anInt1089;
   protected int anInt1090;
   private int configId;
   protected int anInt1092;
   private int anInt1093;
   public static DbxClientV2 aHashTable1923 = null;
   static Class<?> aClass1094;

   final void method782(byte b, Buffer buffer) {
      if (b <= -59) {
         ++anInt1088;

         while(true) {
            int i = buffer.readUnsignedByte();
            if (i == 0) {
               break;
            }

            this.method791((byte)54, buffer, i);
         }
      }
   }

   public static void method783(int i) {
      anIntArrayArray1070 = null;
      aWidgetArrayArray1082 = null;
      if (i != 5621) {
         aBoolean1052 = true;
      }
   }

   final boolean method784(byte b, Interface17 interface17) {
      if (b <= 75) {
         this.aByteArray1057 = null;
      }

      ++anInt1073;
      int i;
      if (~this.configId == 0) {
         if (this.configbyfileId == -1) {
            return true;
         }

         i = interface17.getVarpBit(this.configbyfileId, (byte)-42);
      } else {
         i = interface17.method65(this.configId, -43);
      }

      if (~i <= ~this.anInt1087 && ~i >= ~this.anInt1042) {
         int i_0_;
         if (this.configId2 == -1) {
            if (~this.configByFileId2 == 0) {
               return true;
            }

            i_0_ = interface17.getVarpBit(this.configByFileId2, (byte)-42);
         } else {
            i_0_ = interface17.method65(this.configId2, -56);
         }

         return ~this.anInt1078 >= ~i_0_ && this.anInt1072 >= i_0_;
      } else {
         return false;
      }
   }

   final String method785(int i, int i_1_, String string) {
      ++anInt1059;
      if (this.clientScriptData == null) {
         return string;
      } else {
         Node_Sub18 node_sub18 = (Node_Sub18)this.clientScriptData.get(3512, (long)i);
         if (node_sub18 == null) {
            return string;
         } else {
            if (i_1_ != -18740) {
               anIntArrayArray1070 = null;
            }

            return node_sub18.aString7149;
         }
      }
   }

   final int method786(int i, int i_2_, int i_3_) {
      ++anInt1046;
      if (this.clientScriptData == null) {
         return i_2_;
      } else {
         if (i != 0) {
            this.method786(20, 39, 79);
         }

         Node_Sub32 node_sub32 = (Node_Sub32)this.clientScriptData.get(3512, (long)i_3_);
         return node_sub32 == null ? i_2_ : node_sub32.anInt7381;
      }
   }

   final GLSprite method787(int i, GraphicsToolkit graphicstoolkit) {
      ++anInt1043;
      if (i != 32394) {
         this.method789(true);
      }

      GLSprite glsprite = (GLSprite)this.aClass215_1076.aClass61_2543.method607((long)(131072 | this.anInt1093 | graphicstoolkit.anInt1537 << 29), 0);
      if (glsprite != null) {
         return glsprite;
      } else {
         this.aClass215_1076.aClass302_2541.method3510(this.anInt1093, (byte)63);
         Class383 class383 = Class383.method4194(this.aClass215_1076.aClass302_2541, this.anInt1093, 0);
         if (class383 != null) {
            glsprite = graphicstoolkit.a(class383, true);
            this.aClass215_1076.aClass61_2543.method601(glsprite, i + -6828, (long)(this.anInt1093 | 131072 | graphicstoolkit.anInt1537 << 29));
         }

         return glsprite;
      }
   }

   static final void method788(boolean bool) {
      ++anInt1061;

      try {
         if (!bool) {
            aWidgetArrayArray1082 = null;
         }

         Method method = (aClass1094 == null ? (aClass1094 = method792("java.lang.Runtime")) : aClass1094).getMethod("availableProcessors");
         if (method != null) {
            try {
               Runtime runtime = Runtime.getRuntime();
               Integer integer = (Integer)method.invoke(runtime, new Object());
               Class263.anInt3336 = integer;
            } catch (Throwable var4) {
            }
         }
      } catch (Exception var5) {
      }
   }

   final void method789(boolean bool) {
      ++anInt1083;
      if (bool) {
         this.nameLabel = null;
      }

      if (this.anIntArray1049 != null) {
         for(int i = 0; ~i > ~this.anIntArray1049.length; i += 2) {
            if (this.anIntArray1049[i] >= this.anInt1068) {
               if (this.anInt1089 < this.anIntArray1049[i]) {
                  this.anInt1089 = this.anIntArray1049[i];
               }
            } else {
               this.anInt1068 = this.anIntArray1049[i];
            }

            if (this.anInt1051 > this.anIntArray1049[i + 1]) {
               this.anInt1051 = this.anIntArray1049[1 + i];
            } else if (~this.anInt1060 > ~this.anIntArray1049[1 + i]) {
               this.anInt1060 = this.anIntArray1049[i + 1];
            }
         }
      }
   }

   final GLSprite method790(boolean bool, byte b, GraphicsToolkit graphicstoolkit) {
      if (b >= -90) {
         this.method787(-5, null);
      }

      ++anInt1086;
      int i = !bool ? this.spriteId : this.hoverSpriteId;
      int i_4_ = graphicstoolkit.anInt1537 << 29 | i;
      GLSprite glsprite = (GLSprite)this.aClass215_1076.aClass61_2543.method607((long)i_4_, 0);
      if (glsprite != null) {
         return glsprite;
      } else if (!this.aClass215_1076.aClass302_2541.method3510(i, (byte)63)) {
         return null;
      } else {
         Class383 class383 = Class383.method4194(this.aClass215_1076.aClass302_2541, i, 0);
         if (class383 != null) {
            glsprite = graphicstoolkit.a(class383, true);
            this.aClass215_1076.aClass61_2543.method601(glsprite, 25566, (long)i_4_);
         }

         return glsprite;
      }
   }

   private final void method791(byte b, Buffer buffer, int opcode) {
      ++anInt1075;
      if (opcode == 1) {
         this.spriteId = buffer.readUnsignedShort();
      } else if (opcode == 2) {
         this.hoverSpriteId = buffer.readUnsignedShort();
      } else if (opcode == 3) {
         this.nameLabel = buffer.readString();
      } else if (opcode == 4) {
         this.textColor = buffer.read24BitInteger();
      } else if (opcode != 5) {
         if (opcode != 6) {
            if (opcode == 7) {
               int i_6_ = buffer.readUnsignedByte();
               if ((1 & i_6_) == 0) {
                  this.aBoolean1047 = false;
               }

               if ((i_6_ & 2) == 2) {
                  this.aBoolean1079 = true;
               }
            } else if (opcode != 8) {
               if (opcode != 9) {
                  if (opcode >= 10 && opcode <= 14) {
                     this.rightClickOptions[opcode - 10] = buffer.readString();
                  } else if (opcode != 15) {
                     if (opcode == 16) {
                        this.aBoolean1064 = false;
                     } else if (opcode != 17) {
                        if (opcode == 18) {
                           this.anInt1093 = buffer.readUnsignedShort();
                        } else if (opcode == 19) {
                           this.type = buffer.readUnsignedShort();
                        } else if (opcode == 20) {
                           this.configByFileId2 = buffer.readUnsignedShort();
                           if (this.configByFileId2 == 65535) {
                              this.configByFileId2 = -1;
                           }

                           this.configId2 = buffer.readUnsignedShort();
                           if (this.configId2 == 65535) {
                              this.configId2 = -1;
                           }

                           this.anInt1078 = buffer.readInt();
                           this.anInt1072 = buffer.readInt();
                        } else if (opcode == 21) {
                           this.anInt1081 = buffer.readInt();
                        } else if (opcode == 22) {
                           this.anInt1077 = buffer.readInt();
                        } else if (opcode == 23) {
                           this.anInt1074 = buffer.readUnsignedByte();
                           this.anInt1050 = buffer.readUnsignedByte();
                           this.anInt1080 = buffer.readUnsignedByte();
                        } else if (opcode == 24) {
                           this.anInt1071 = buffer.readShort();
                           this.anInt1092 = buffer.readShort();
                        } else if (opcode == 249) {
                           int i_7_ = buffer.readUnsignedByte();
                           if (this.clientScriptData == null) {
                              int i_8_ = Class320_Sub19.method3753(i_7_);
                              this.clientScriptData = new HashTable(i_8_);
                           }

                           for(int i_9_ = 0; i_9_ < i_7_; ++i_9_) {
                              boolean bool = buffer.readUnsignedByte() == 1;
                              int i_10_ = buffer.read24BitInteger();
                              Node node;
                              if (bool) {
                                 node = new Node_Sub18(buffer.readString());
                              } else {
                                 node = new Node_Sub32(buffer.readInt());
                              }

                              this.clientScriptData.put((long)i_10_, node, -126);
                           }
                        }
                     } else {
                        this.baseOption = buffer.readString();
                     }
                  } else {
                     int i_11_ = buffer.readUnsignedByte();
                     this.anIntArray1049 = new int[i_11_ * 2];

                     for(int i_12_ = 0; i_12_ < 2 * i_11_; ++i_12_) {
                        this.anIntArray1049[i_12_] = buffer.readShort();
                     }

                     this.anInt1084 = 3000;
                     buffer.readInt();
                     int i_13_ = buffer.readUnsignedByte();
                     this.anIntArray1066 = new int[i_13_];

                     for(int i_14_ = 0; i_14_ < this.anIntArray1066.length; ++i_14_) {
                        this.anIntArray1066[i_14_] = 2000;
                     }

                     buffer.readInt();
                     this.aByteArray1057 = new byte[i_11_];

                     for(int i_15_ = 0; i_15_ < i_11_; ++i_15_) {
                        this.aByteArray1057[i_15_] = buffer.readByte();
                     }
                  }
               } else {
                  this.configbyfileId = buffer.readUnsignedShort();
                  if (this.configbyfileId == 65535) {
                     this.configbyfileId = -1;
                  }

                  this.configId = buffer.readUnsignedShort();
                  if (this.configId == 65535) {
                     this.configId = -1;
                  }

                  this.anInt1087 = buffer.readInt();
                  this.anInt1042 = buffer.readInt();
               }
            } else {
               this.aBoolean1063 = buffer.readUnsignedByte() == 1;
            }
         } else {
            this.anInt1090 = buffer.readUnsignedByte();
         }
      } else {
         this.anInt1054 = buffer.read24BitInteger();
      }
   }

   public AreaDefinitions() {
      this.configByFileId2 = -1;
      this.spriteId = -1;
      this.anInt1060 = Integer.MIN_VALUE;
      this.hoverSpriteId = -1;
      this.aBoolean1047 = true;
      this.aBoolean1063 = true;
      this.configbyfileId = -1;
      this.anInt1051 = Integer.MAX_VALUE;
      this.type = -1;
      this.rightClickOptions = new String[5];
      this.anInt1054 = -1;
      this.anInt1074 = -1;
      this.aBoolean1064 = true;
      this.aBoolean1079 = false;
      this.anInt1068 = Integer.MAX_VALUE;
      this.anInt1089 = Integer.MIN_VALUE;
      this.configId = -1;
      this.anInt1080 = -1;
      this.anInt1093 = -1;
      this.anInt1090 = 0;
   }

   static Class<?> method792(String string) {
      try {
         return Class.forName(string);
      } catch (ClassNotFoundException var3) {
         throw (NoClassDefFoundError)new NoClassDefFoundError().initCause(var3);
      }
   }
}
