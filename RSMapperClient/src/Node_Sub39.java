import jaclib.hardware_info.HardwareInfo;

public class Node_Sub39 extends Node {
   private int anInt7468;
   private String aString7469;
   private int anInt7470;
   static int anInt7471;
   static int anInt7472;
   static int anInt7473;
   protected int anInt7474;
   private boolean aBoolean7475;
   private String aString7476;
   private int anInt7477;
   private int anInt7478;
   static int anInt7479;
   protected int anInt7480;
   static int anInt7481;
   private int anInt7482;
   private String aString7483;
   protected int anInt7484;
   private int anInt7485;
   static OutgoingPacket aClass318_7486 = new OutgoingPacket(44, -1);
   private String aString7487;
   private int anInt7488;
   private boolean aBoolean7489;
   private int anInt7490;
   private int anInt7491;
   private int anInt7492;
   static Class151 aClass151_7493 = new Class151(10, 2, 2, 0);
   static int[] routeFinderXArray = new int[4096];
   private int anInt7495;
   private int anInt7496;
   static Class369[] aClass369Array7497;
   static int anInt7498 = 2;

   private final void method2918(boolean bool) {
      if (this.aString7487.length() > 40) {
         this.aString7487 = this.aString7487.substring(0, 40);
      }

      ++anInt7481;
      if (this.aString7476.length() > 40) {
         this.aString7476 = this.aString7476.substring(0, 40);
      }

      if (bool) {
         method2922(true);
      }

      if (~this.aString7483.length() < -11) {
         this.aString7483 = this.aString7483.substring(0, 10);
      }

      if (~this.aString7469.length() < -11) {
         this.aString7469 = this.aString7469.substring(0, 10);
      }
   }

   public static void method2919(boolean bool) {
      aClass369Array7497 = null;
      routeFinderXArray = null;
      if (bool) {
         aClass151_7493 = null;
         aClass318_7486 = null;
      }
   }

   final void method2920(Buffer buffer, int i) {
      buffer.writeByte(5);
      ++anInt7479;
      buffer.writeByte(this.anInt7485);
      buffer.writeByte(!this.aBoolean7475 ? 0 : 1);
      buffer.writeByte(this.anInt7488);
      buffer.writeByte(this.anInt7496);
      buffer.writeByte(this.anInt7474);
      buffer.writeByte(this.anInt7470);
      buffer.writeByte(this.anInt7480);
      buffer.writeByte(!this.aBoolean7489 ? 0 : 1);
      buffer.writeShort(this.anInt7490);
      if (i == -19819) {
         buffer.writeByte(this.anInt7482);
         buffer.write24BitInt((byte)95, this.anInt7484);
         buffer.writeShort(this.anInt7477);
         buffer.writeByte(this.anInt7478);
         buffer.writeByte(this.anInt7491);
         buffer.writeByte(this.anInt7468);
         buffer.writeJagString(this.aString7487, 30);
         buffer.writeJagString(this.aString7476, -109);
         buffer.writeJagString(this.aString7483, i + 19898);
         buffer.writeJagString(this.aString7469, -120);
         buffer.writeByte(this.anInt7492);
         buffer.writeShort(this.anInt7495);
      }
   }

   static final void method2921(boolean bool, int i, int i_0_, int i_1_, IComponentDefinitions widget) {
      ++anInt7471;
      int i_2_ = widget.width;
      if (i_0_ != 18815) {
         method2919(false);
      }

      int i_3_ = widget.height;
      if (widget.aspectWidthType != 0) {
         if (widget.aspectWidthType == 1) {
            widget.width = -widget.baseWidth + i_1_;
         } else if (widget.aspectWidthType == 2) {
            widget.width = widget.baseWidth * i_1_ >> 14;
         }
      } else {
         widget.width = widget.baseWidth;
      }

      if (~widget.aspectHeightType == -1) {
         widget.height = widget.baseHeight;
      } else if (~widget.aspectHeightType != -2) {
         if (widget.aspectHeightType == 2) {
            widget.height = i * widget.baseHeight >> 14;
         }
      } else {
         widget.height = -widget.baseHeight + i;
      }

      if (~widget.aspectWidthType == -5) {
         widget.width = widget.anInt4792 * widget.height / widget.anInt4700;
      }

      if (widget.aspectHeightType == 4) {
         widget.height = widget.width * widget.anInt4700 / widget.anInt4792;
      }

      if (Class54.aBoolean817 && (~Client.method113(widget).settingsHash != -1 || widget.type == 0)) {
         if (~widget.height > -6 && ~widget.width > -6) {
            widget.height = 5;
            widget.width = 5;
         } else {
            if (~widget.width >= -1) {
               widget.width = 5;
            }

            if (widget.height <= 0) {
               widget.height = 5;
            }
         }
      }

      if (~Class200_Sub1.anInt5146 == ~widget.anInt4814) {
         Class324.aWidget4085 = widget;
      }

      if (bool && widget.anObjectArray4777 != null && (~i_2_ != ~widget.width || i_3_ != widget.height)) {
         Node_Sub37 node_sub37 = new Node_Sub37();
         node_sub37.parameters = widget.anObjectArray4777;
         node_sub37.aWidget7437 = widget;
         Class275.aClass312_5419.method3625((byte)-54, node_sub37);
      }
   }

   static final void method2922(boolean bool) {
      ++anInt7473;
      if (!bool) {
         for(Node_Sub3 node_sub3 = (Node_Sub3)Class56.aHashTable839.method1516(bool);
            node_sub3 != null;
            node_sub3 = (Node_Sub3)Class56.aHashTable839.method1520(71)
         ) {
            if (node_sub3.aBoolean6949) {
               node_sub3.aBoolean6949 = false;
            } else {
               Renderer.method3446(node_sub3.anInt6947, 5);
            }
         }
      }
   }

   final int method2923(byte b) {
      ++anInt7472;
      if (b != 66) {
         return 15;
      } else {
         int i = 23;
         i += Node_Sub15_Sub12.method2583(this.aString7487, (byte)65);
         i += Node_Sub15_Sub12.method2583(this.aString7476, (byte)103);
         i += Node_Sub15_Sub12.method2583(this.aString7483, (byte)108);
         return i + Node_Sub15_Sub12.method2583(this.aString7469, (byte)106);
      }
   }

   public Node_Sub39() {
   }

   Node_Sub39(boolean bool, SignLink signlink) {
      if (bool) {
         if (!SignLink.aString3981.startsWith("win")) {
            if (!SignLink.aString3981.startsWith("mac")) {
               if (SignLink.aString3981.startsWith("linux")) {
                  this.anInt7485 = 3;
               } else {
                  this.anInt7485 = 4;
               }
            } else {
               this.anInt7485 = 2;
            }
         } else {
            this.anInt7485 = 1;
         }

         if (!SignLink.aString3984.startsWith("amd64") && !SignLink.aString3984.startsWith("x86_64")) {
            this.aBoolean7475 = false;
         } else {
            this.aBoolean7475 = true;
         }

         if (~this.anInt7485 == -2) {
            if (SignLink.aString3982.indexOf("4.0") != -1) {
               this.anInt7488 = 1;
            } else if (~SignLink.aString3982.indexOf("4.1") == 0) {
               if (~SignLink.aString3982.indexOf("4.9") == 0) {
                  if (~SignLink.aString3982.indexOf("5.0") == 0) {
                     if (~SignLink.aString3982.indexOf("5.1") != 0) {
                        this.anInt7488 = 5;
                     } else if (SignLink.aString3982.indexOf("6.0") != -1) {
                        this.anInt7488 = 6;
                     } else if (SignLink.aString3982.indexOf("6.1") != -1) {
                        this.anInt7488 = 7;
                     }
                  } else {
                     this.anInt7488 = 4;
                  }
               } else {
                  this.anInt7488 = 3;
               }
            } else {
               this.anInt7488 = 2;
            }
         } else if (~this.anInt7485 == -3) {
            if (SignLink.aString3982.indexOf("10.4") != -1) {
               this.anInt7488 = 20;
            } else if (~SignLink.aString3982.indexOf("10.5") != 0) {
               this.anInt7488 = 21;
            } else if (~SignLink.aString3982.indexOf("10.6") == 0) {
               if (~SignLink.aString3982.indexOf("10.7") != 0) {
                  this.anInt7488 = 23;
               }
            } else {
               this.anInt7488 = 22;
            }
         }

         if (~SignLink.aString3989.toLowerCase().indexOf("sun") == 0) {
            if (SignLink.aString3989.toLowerCase().indexOf("microsoft") == -1) {
               if (~SignLink.aString3989.toLowerCase().indexOf("apple") == 0) {
                  this.anInt7496 = 4;
               } else {
                  this.anInt7496 = 3;
               }
            } else {
               this.anInt7496 = 2;
            }
         } else {
            this.anInt7496 = 1;
         }

         int i = 2;
         int i_4_ = 0;

         try {
            while(i < SignLink.aString3995.length()) {
               int i_5_ = SignLink.aString3995.charAt(i);
               if (~i_5_ > -49 || ~i_5_ < -58) {
                  break;
               }

               i_4_ = 10 * i_4_ - -i_5_ + -48;
               ++i;
            }
         } catch (Exception var9) {
         }

         this.anInt7474 = i_4_;
         i = SignLink.aString3995.indexOf(46, 2) - -1;
         i_4_ = 0;

         try {
            while(i < SignLink.aString3995.length()) {
               int i_6_ = SignLink.aString3995.charAt(i);
               if (~i_6_ > -49 || i_6_ > 57) {
                  break;
               }

               ++i;
               i_4_ = i_6_ - 48 + i_4_ * 10;
            }
         } catch (Exception var8) {
         }

         this.anInt7470 = i_4_;
         i_4_ = 0;
         i = SignLink.aString3995.indexOf(95, 4) + 1;

         try {
            while(SignLink.aString3995.length() > i) {
               int i_7_ = SignLink.aString3995.charAt(i);
               if (i_7_ < 48 || ~i_7_ < -58) {
                  break;
               }

               i_4_ = 10 * i_4_ - -i_7_ + -48;
               ++i;
            }
         } catch (Exception var7) {
         }

         this.anInt7480 = i_4_;
         if (~this.anInt7474 < -4) {
            this.anInt7482 = Class263.anInt3336;
         } else {
            this.anInt7482 = 0;
         }

         this.anInt7490 = Class201.anInt2446;
         if (signlink.aBoolean4005) {
            this.aBoolean7489 = false;
         } else {
            this.aBoolean7489 = true;
         }

         try {
            int[] is = HardwareInfo.getCPUInfo();
            if (is != null && ~is.length == -8) {
               this.anInt7477 = is[2];
               this.anInt7468 = is[5];
               this.anInt7484 = is[6];
               this.anInt7491 = is[4];
               this.anInt7478 = is[3];
            }
         } catch (Throwable var6) {
            this.anInt7484 = 0;
         }
      }

      if (this.aString7469 == null) {
         this.aString7469 = "";
      }

      if (this.aString7487 == null) {
         this.aString7487 = "";
      }

      if (this.aString7476 == null) {
         this.aString7476 = "";
      }

      if (this.aString7483 == null) {
         this.aString7483 = "";
      }

      this.method2918(false);
   }
}
