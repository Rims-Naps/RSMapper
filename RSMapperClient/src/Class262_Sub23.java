import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

public class Class262_Sub23 extends Class262 {
   private int anInt7875;
   private int anInt7876;
   private int anInt7877;
   static int anInt7878;
   private int anInt7879;
   private int anInt7880;
   private int anInt7881;
   private int anInt7882;
   static Class257 aClass257_7883 = new Class257(12, 7);
   static Class197 aClass197_7884;
   private int anInt7885;
   static Index index20;
   static int anInt7887;
   private int anInt7888;
   private int anInt7889;
   static int anInt7890;
   private int anInt7891;
   static int[][] anIntArrayArray7892 = new int[128][128];
   static int anInt7893;
   static int anInt7894;
   private int anInt7895;
   private int anInt7896;

   static final void method3212(boolean bool, int i) {
      if (bool && WorldmapDefinitions.currentWorldmapArea != null) {
         Class188.anInt2281 = WorldmapDefinitions.currentWorldmapArea.fileId;
      } else {
         Class188.anInt2281 = -1;
      }

      ++anInt7893;
      Node_Sub43.aClass312_7541 = null;
      Class66_Sub1.aWidget8983 = null;
      WorldmapDefinitions.currentWorldmapArea = null;
      Node_Sub25_Sub1.worldmapLoaded = 0;
      WorldmapDefinitions.method280();
      WorldmapDefinitions.aClass312_331.method3614(i ^ -1880);
      Class190.aClass299_2330 = null;
      EntityNode_Sub6.aClass299_5988 = null;
      WorldmapDefinitions.aClass224_330 = null;
      Class352.aClass299_4329 = null;
      Class262_Sub4.anInt7730 = -1;
      Node_Sub2.aGLSprite6935 = null;
      Class75.aClass299_1007 = null;
      Node_Sub25_Sub3.aClass299_9980 = null;
      Packet.aClass299_9394 = null;
      Class195.aClass299_2380 = null;
      Class150_Sub2.aClass299_8962 = null;
      Class150_Sub3.anInt8963 = -1;
      if (WorldmapDefinitions.aClass215_322 != null) {
         WorldmapDefinitions.aClass215_322.method2071(7);
         WorldmapDefinitions.aClass215_322.method2068(-1, 128, 64);
      }

      if (WorldmapDefinitions.aClass338_315 != null) {
         WorldmapDefinitions.aClass338_315.method3912(64, i ^ 1393, 64);
      }

      if (WorldmapDefinitions.aClass112_319 != null) {
         WorldmapDefinitions.aClass112_319.method1144(i + -1231, 64);
      }

      if (i == 1295) {
         IOException_Sub1.aClass128_85.method1543(16509, 64);
      }
   }

   static final Class123 method3213(byte b) {
      if (b >= -52) {
         return null;
      } else {
         ++anInt7890;
         return Class329.method3833((byte)-61, Class151.anInt1843) ? Class218.aClass123_2560 : Class218.aClass123_2566;
      }
   }

   static final int method3214(int i, int i_0_) {
      if (i_0_ != -20139) {
         return -83;
      } else {
         ++anInt7894;
         return 127 & i;
      }
   }

   static final void method3215(int i) {
      if (Class298.anInt3740 < 102) {
         Class298.anInt3740 += 6;
      }

      ++anInt7887;
      if (Class194_Sub3.anInt6904 != -1 && Class163.aLong2020 < Class313.method3650(false)) {
         for(int i_1_ = Class194_Sub3.anInt6904; ~i_1_ > ~Class339_Sub1.aStringArray8631.length; ++i_1_) {
            if (Class339_Sub1.aStringArray8631[i_1_].startsWith("pause")) {
               int i_2_ = 5;

               try {
                  i_2_ = Integer.parseInt(Class339_Sub1.aStringArray8631[i_1_].substring(6));
               } catch (Exception var9) {
               }

               Node_Sub7.writeToConsole((byte)43, "Pausing for " + i_2_ + " seconds...");
               Class194_Sub3.anInt6904 = 1 + i_1_;
               Class163.aLong2020 = (long)(i_2_ * 1000) + Class313.method3650(false);
               return;
            }

            Node_Sub10.stringInConsole = Class339_Sub1.aStringArray8631[i_1_];
            Node_Sub21.method2618(false, 0);
         }

         Class194_Sub3.anInt6904 = -1;
      }

      if (~Class339_Sub8.mouseNotches != -1) {
         Class118.anInt5406 -= 5 * Class339_Sub8.mouseNotches;
         if (Class118.anInt5406 >= Class144_Sub4.anInt6848) {
            Class118.anInt5406 = -1 + Class144_Sub4.anInt6848;
         }

         Class339_Sub8.mouseNotches = 0;
         if (~Class118.anInt5406 > -1) {
            Class118.anInt5406 = 0;
         }
      }

      int i_3_ = 0;
      if (i < 86) {
         aClass197_7884 = null;
      }

      for(; Class357.anInt4429 > i_3_; ++i_3_) {
         Interface21 interface21 = Class320_Sub7.anInterface21Array8275[i_3_];
         int i_4_ = interface21.method75(-29764);
         char c = interface21.method77(-24069);
         int i_5_ = interface21.method78(88);
         if (i_4_ == 84) {
            Node_Sub21.method2618(false, 0);
         }

         if (i_4_ == 80) {
            Node_Sub21.method2618(true, 0);
         } else if (~i_4_ == -67 && (i_5_ & 4) != 0) {
            if (Class102.aClipboard1315 != null) {
               String string = "";

               for(int i_6_ = Class210.aStringArray2502.length + -1; i_6_ >= 0; --i_6_) {
                  if (Class210.aStringArray2502[i_6_] != null && Class210.aStringArray2502[i_6_].length() > 0) {
                     string = string + Class210.aStringArray2502[i_6_] + '\n';
                  }
               }

               Class102.aClipboard1315.setContents(new StringSelection(string), null);
            }
         } else if (~i_4_ == -68 && ~(i_5_ & 4) != -1) {
            if (Class102.aClipboard1315 != null) {
               try {
                  Transferable transferable = Class102.aClipboard1315.getContents(null);
                  if (transferable != null) {
                     String string = (String)transferable.getTransferData(DataFlavor.stringFlavor);
                     if (string != null) {
                        String[] strings = Class106.method1120((byte)49, string, '\n');
                        Class194.method1960(strings);
                     }
                  }
               } catch (Exception var10) {
               }
            }
         } else if (~i_4_ == -86 && ~Class315.anInt4034 < -1) {
            Node_Sub10.stringInConsole = Node_Sub10.stringInConsole.substring(0, Class315.anInt4034 + -1)
               + Node_Sub10.stringInConsole.substring(Class315.anInt4034);
            --Class315.anInt4034;
         } else if (~i_4_ == -102 && ~Class315.anInt4034 > ~Node_Sub10.stringInConsole.length()) {
            Node_Sub10.stringInConsole = Node_Sub10.stringInConsole.substring(0, Class315.anInt4034)
               + Node_Sub10.stringInConsole.substring(1 + Class315.anInt4034);
         } else if (~i_4_ == -97 && Class315.anInt4034 > 0) {
            --Class315.anInt4034;
         } else if (~i_4_ == -98 && Class315.anInt4034 < Node_Sub10.stringInConsole.length()) {
            ++Class315.anInt4034;
         } else if (~i_4_ != -103) {
            if (i_4_ != 103) {
               if (~i_4_ == -105 && Class210.aStringArray2502.length > Class332.anInt4145) {
                  ++Class332.anInt4145;
                  Class181.method1829(-20412);
                  Class315.anInt4034 = Node_Sub10.stringInConsole.length();
               } else if (~i_4_ == -106 && Class332.anInt4145 > 0) {
                  --Class332.anInt4145;
                  Class181.method1829(-20412);
                  Class315.anInt4034 = Node_Sub10.stringInConsole.length();
               } else if (Class316.method3662(false, c) || "\\/.:, _-+[]~@".indexOf(c) != -1) {
                  Node_Sub10.stringInConsole = Node_Sub10.stringInConsole.substring(0, Class315.anInt4034)
                     + Class320_Sub7.anInterface21Array8275[i_3_].method77(-24069)
                     + Node_Sub10.stringInConsole.substring(Class315.anInt4034);
                  ++Class315.anInt4034;
               }
            } else {
               Class315.anInt4034 = Node_Sub10.stringInConsole.length();
            }
         } else {
            Class315.anInt4034 = 0;
         }
      }

      Class320_Sub8.anInt8281 = 0;
      Class357.anInt4429 = 0;
      Class320_Sub21.method3764(-95);
   }

   @Override
   final void method3148(int i) {
      ++anInt7878;
      int i_7_;
      int i_8_;
      int i_9_;
      if (this.anInt7885 < 0) {
         Actor actor = Class121.aClass206Array1529[this.anInt7888].method2037(-111);
         i_9_ = actor.plane;
         i_7_ = actor.y;
         i_8_ = actor.x;
      } else {
         i_7_ = 256 + this.anInt7875 * 512;
         i_8_ = 256 + this.anInt7885 * 512;
         i_9_ = this.anInt7889;
      }

      int i_11_;
      int i_10_;
      if (~this.anInt7875 <= -1) {
         i_11_ = 512 * this.anInt7876 - -256;
         i_10_ = 256 + this.anInt7891 * 512;
      } else {
         Actor actor = Class121.aClass206Array1529[this.anInt7896].method2037(-105);
         i_10_ = actor.x;
         i_11_ = actor.y;
         if (~i_9_ > -1) {
            i_9_ = actor.plane;
         }
      }

      int i_12_ = this.anInt7882 << 2;
      Mobile_Sub1 mobile_sub1 = new Mobile_Sub1(
         this.anInt7879,
         i_9_,
         i_9_,
         i_8_,
         i_7_,
         this.anInt7877 << 2,
         Class174.clientCycle,
         Class174.clientCycle - -this.anInt7881,
         this.anInt7880,
         i_12_,
         this.anInt7888 + 1,
         1 + this.anInt7896,
         this.anInt7895 << 2,
         false,
         0
      );
      mobile_sub1.method895(this.anInt7895 << 2, false, this.anInt7881 + Class174.clientCycle, i_11_, i_10_);
      if (i <= -102) {
         Class270.aClass312_3477.method3625((byte)-54, new CacheNode_Sub12(mobile_sub1));
      }
   }

   public static void method3216(byte b) {
      if (b >= -47) {
         anIntArrayArray7892 = null;
      }

      anIntArrayArray7892 = null;
      index20 = null;
      aClass257_7883 = null;
      aClass197_7884 = null;
   }

   Class262_Sub23(Buffer buffer, int i, int i_13_) {
      super(buffer);
      if (i == 0) {
         int i_14_ = buffer.readInt();
         this.anInt7875 = 65535 & i_14_;
         this.anInt7888 = -1;
         this.anInt7885 = i_14_ >>> 16;
      } else {
         this.anInt7885 = -1;
         this.anInt7875 = -1;
         this.anInt7888 = buffer.readUnsignedShort();
      }

      if (i_13_ != 0) {
         this.anInt7876 = -1;
         this.anInt7891 = -1;
         this.anInt7896 = buffer.readUnsignedShort();
      } else {
         int i_15_ = buffer.readInt();
         this.anInt7891 = i_15_ >>> 16;
         this.anInt7896 = -1;
         this.anInt7876 = 65535 & i_15_;
      }

      if (i == 0 && ~i_13_ == -1) {
         this.anInt7889 = buffer.readUnsignedByte();
      } else {
         this.anInt7889 = -1;
      }

      this.anInt7879 = buffer.readUnsignedShort();
      this.anInt7877 = buffer.readUnsignedByte();
      this.anInt7895 = buffer.readUnsignedByte();
      this.anInt7881 = buffer.read24BitInteger();
      this.anInt7880 = buffer.readUnsignedShort();
      this.anInt7882 = buffer.readUnsignedByte();
   }
}
