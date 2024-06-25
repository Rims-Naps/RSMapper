import jaggl.OpenGL;
import java.util.Calendar;
import java.util.TimeZone;

public class Class247 {
   private Class382 aClass382_3109;
   private boolean aBoolean3110;
   private int anInt3111;
   private Class312 aClass312_3112;
   private int anInt3113;
   private int anInt3114 = 1;
   static Class197 aClass197_3115;
   static int anInt3116;
   static int anInt3117;
   static int anInt3118;
   private int anInt3119;
   static int anInt3120;
   private GLToolkit aGLToolkit3121;
   static boolean aBoolean3122 = false;
   static IncommingPacket aClass192_3123 = new IncommingPacket(110, -1);
   static int anInt3124;
   static int anInt3125;
   static int anInt3126;
   static int anInt3127;
   private Class382 aClass382_3128;
   private Class382 aClass382_3129;
   static OutgoingPacket aClass318_3130 = new OutgoingPacket(70, -1);
   private boolean aBoolean3131;
   private Class169_Sub2[] aClass169_Sub2Array3132;
   private boolean aBoolean3133;
   private boolean aBoolean3134;
   private Class169_Sub2 aClass169_Sub2_3135;
   private int anInt3136;
   private CacheNode_Sub17 aCacheNode_Sub17_3137;
   private CacheNode_Sub17 aCacheNode_Sub17_3138;
   private boolean aBoolean3139;
   private boolean aBoolean3140;
   static GLSprite aGLSprite3141;
   private int anInt3142;
   static Index index16;
   static Calendar aCalendar3144 = Calendar.getInstance(TimeZone.getTimeZone("PST"));

   private final boolean method3075(byte b) {
      if (this.aBoolean3139) {
         if (this.aCacheNode_Sub17_3137 != null) {
            this.aCacheNode_Sub17_3137.method2398((byte)127);
            this.aCacheNode_Sub17_3137 = null;
         }

         if (this.aClass169_Sub2_3135 != null) {
            this.aClass169_Sub2_3135.method1761((byte)-53);
            this.aClass169_Sub2_3135 = null;
         }

         if (this.aClass382_3109 != null) {
            this.aCacheNode_Sub17_3137 = new CacheNode_Sub17(this.aGLToolkit3121, 6402, this.anInt3114, this.anInt3113, this.aGLToolkit3121.anInt6599);
         }

         if (!this.aBoolean3140) {
            if (this.aCacheNode_Sub17_3137 == null) {
               this.aCacheNode_Sub17_3137 = new CacheNode_Sub17(this.aGLToolkit3121, 6402, this.anInt3114, this.anInt3113);
            }
         } else {
            this.aClass169_Sub2_3135 = new Class169_Sub2(this.aGLToolkit3121, 34037, 6402, this.anInt3114, this.anInt3113);
         }

         this.aBoolean3133 = true;
         this.aBoolean3131 = true;
         this.aBoolean3139 = false;
      }

      ++anInt3116;
      if (b != 81) {
         return false;
      } else {
         if (this.aBoolean3134) {
            if (this.aCacheNode_Sub17_3138 != null) {
               this.aCacheNode_Sub17_3138.method2398((byte)124);
               this.aCacheNode_Sub17_3138 = null;
            }

            if (this.aClass169_Sub2Array3132[0] != null) {
               this.aClass169_Sub2Array3132[0].method1761((byte)-53);
               this.aClass169_Sub2Array3132[0] = null;
            }

            if (this.aClass169_Sub2Array3132[1] != null) {
               this.aClass169_Sub2Array3132[1].method1761((byte)-53);
               this.aClass169_Sub2Array3132[1] = null;
            }

            if (this.aClass382_3109 != null) {
               this.aCacheNode_Sub17_3138 = new CacheNode_Sub17(
                  this.aGLToolkit3121, this.anInt3142, this.anInt3114, this.anInt3113, this.aGLToolkit3121.anInt6599
               );
            }

            this.aClass169_Sub2Array3132[0] = new Class169_Sub2(this.aGLToolkit3121, 34037, this.anInt3142, this.anInt3114, this.anInt3113);
            this.aClass169_Sub2Array3132[1] = this.anInt3136 <= 1
               ? null
               : new Class169_Sub2(this.aGLToolkit3121, 34037, this.anInt3142, this.anInt3114, this.anInt3113);
            this.aBoolean3133 = true;
            this.aBoolean3131 = true;
            this.aBoolean3134 = false;
         }

         if (this.aBoolean3131) {
            if (this.aClass382_3109 != null) {
               this.aGLToolkit3121.method1410(15, this.aClass382_3128);
               this.aClass382_3128.method4175(0, -25845);
               this.aClass382_3128.method4175(1, -25845);
               this.aClass382_3128.method4175(8, -25845);
               this.aClass382_3128.method4181(18264, this.aClass169_Sub2Array3132[0], 0);
               if (~this.anInt3136 < -2) {
                  this.aClass382_3128.method4181(b + 18183, this.aClass169_Sub2Array3132[1], 1);
               }

               if (this.aBoolean3140) {
                  this.aClass382_3128.method4181(18264, this.aClass169_Sub2_3135, 8);
               }

               this.aGLToolkit3121.method1436(this.aClass382_3128, (byte)23);
               this.aGLToolkit3121.method1410(15, this.aClass382_3109);
               this.aClass382_3109.method4175(0, -25845);
               this.aClass382_3109.method4175(8, -25845);
               this.aClass382_3109.method4178(this.aCacheNode_Sub17_3138, 0, b + -80);
               this.aClass382_3109.method4178(this.aCacheNode_Sub17_3137, 8, 1);
               this.aGLToolkit3121.method1436(this.aClass382_3109, (byte)82);
            } else {
               this.aGLToolkit3121.method1410(15, this.aClass382_3128);
               this.aClass382_3128.method4175(0, -25845);
               this.aClass382_3128.method4175(1, -25845);
               this.aClass382_3128.method4175(8, b ^ -25766);
               this.aClass382_3128.method4181(18264, this.aClass169_Sub2Array3132[0], 0);
               if (~this.anInt3136 < -2) {
                  this.aClass382_3128.method4181(18264, this.aClass169_Sub2Array3132[1], 1);
               }

               if (this.aBoolean3140) {
                  this.aClass382_3128.method4181(18264, this.aClass169_Sub2_3135, 8);
               } else {
                  this.aClass382_3128.method4178(this.aCacheNode_Sub17_3137, 8, 1);
               }

               this.aGLToolkit3121.method1436(this.aClass382_3128, (byte)13);
            }

            this.aBoolean3131 = false;
            this.aBoolean3133 = true;
         }

         if (this.aBoolean3133) {
            this.aGLToolkit3121.method1410(15, this.aClass382_3129);
            this.aBoolean3133 = !this.aClass382_3129.method4180(10785);
            this.aGLToolkit3121.method1436(this.aClass382_3129, (byte)90);
         }

         return !this.aBoolean3133;
      }
   }

   final void method3076(byte b) {
      ++anInt3118;
      if (this.aBoolean3110) {
         if (this.aClass382_3109 != null) {
            this.aGLToolkit3121.method1481(this.aClass382_3109, false);
            int i = 16384;
            this.aGLToolkit3121.method1479(29630, this.aClass382_3128);
            this.aClass382_3109.method4186(0, (byte)108);
            this.aClass382_3128.method4183(0, (byte)16);
            if (this.aBoolean3140) {
               i |= 256;
            }

            OpenGL.glBlitFramebufferEXT(0, 0, this.anInt3114, this.anInt3113, 0, 0, this.anInt3114, this.anInt3113, i, 9728);
            this.aGLToolkit3121.method1431(-10785, this.aClass382_3109);
            this.aGLToolkit3121.method1447(this.aClass382_3128, 32760);
         }

         this.aGLToolkit3121.method1461(34962);
         this.aGLToolkit3121.method1460(0, 3);
         this.aGLToolkit3121.method1434((byte)69, 1);
         this.aGLToolkit3121.la();
         int i = 0;
         if (b <= 46) {
            method3083(false);
         }

         int i_0_ = 1;

         Node_Sub23 node_sub23;
         for(Node_Sub23 node_sub23_1_ = (Node_Sub23)this.aClass312_3112.method3613(65280); node_sub23_1_ != null; node_sub23_1_ = node_sub23) {
            node_sub23 = (Node_Sub23)this.aClass312_3112.method3620(16776960);
            int i_2_ = node_sub23_1_.method2623(1);

            for(int i_3_ = 0; ~i_2_ < ~i_3_; ++i_3_) {
               node_sub23_1_.method2629(this.aClass169_Sub2_3135, this.aClass169_Sub2Array3132[i], 0, i_3_);
               if (node_sub23 == null && ~(-1 + i_2_) == ~i_3_) {
                  this.aGLToolkit3121.method1436(this.aClass382_3128, (byte)114);
                  this.aGLToolkit3121.method1465(0, 0, 16053);
                  OpenGL.glBegin(7);
                  OpenGL.glTexCoord2f(0.0F, (float)this.anInt3113);
                  OpenGL.glMultiTexCoord2f(33985, 0.0F, 1.0F);
                  OpenGL.glVertex2i(this.anInt3111, this.anInt3119);
                  OpenGL.glTexCoord2f(0.0F, 0.0F);
                  OpenGL.glMultiTexCoord2f(33985, 0.0F, 0.0F);
                  OpenGL.glVertex2i(this.anInt3111, this.anInt3119 + this.anInt3113);
                  OpenGL.glTexCoord2f((float)this.anInt3114, 0.0F);
                  OpenGL.glMultiTexCoord2f(33985, 1.0F, 0.0F);
                  OpenGL.glVertex2i(this.anInt3114 + this.anInt3111, this.anInt3113 + this.anInt3119);
                  OpenGL.glTexCoord2f((float)this.anInt3114, (float)this.anInt3113);
                  OpenGL.glMultiTexCoord2f(33985, 1.0F, 1.0F);
                  OpenGL.glVertex2i(this.anInt3111 - -this.anInt3114, this.anInt3119);
                  OpenGL.glEnd();
               } else {
                  this.aClass382_3128.method4183(i_0_, (byte)7);
                  OpenGL.glBegin(7);
                  OpenGL.glTexCoord2f(0.0F, (float)this.anInt3113);
                  OpenGL.glMultiTexCoord2f(33985, 0.0F, 1.0F);
                  OpenGL.glVertex2i(0, 0);
                  OpenGL.glTexCoord2f(0.0F, 0.0F);
                  OpenGL.glMultiTexCoord2f(33985, 0.0F, 0.0F);
                  OpenGL.glVertex2i(0, this.anInt3113);
                  OpenGL.glTexCoord2f((float)this.anInt3114, 0.0F);
                  OpenGL.glMultiTexCoord2f(33985, 1.0F, 0.0F);
                  OpenGL.glVertex2i(this.anInt3114, this.anInt3113);
                  OpenGL.glTexCoord2f((float)this.anInt3114, (float)this.anInt3113);
                  OpenGL.glMultiTexCoord2f(33985, 1.0F, 1.0F);
                  OpenGL.glVertex2i(this.anInt3114, 0);
                  OpenGL.glEnd();
               }

               node_sub23_1_.method2625((byte)113, i_3_);
               i = 1 & 1 + i;
               i_0_ = 1 + i_0_ & 1;
            }
         }

         this.aBoolean3110 = false;
      }
   }

   final boolean method3077(Node_Sub23 node_sub23, byte b) {
      ++anInt3127;
      if (this.aClass382_3129 != null) {
         if (node_sub23.method2627((byte)-116) || node_sub23.method2635((byte)87)) {
            this.aClass312_3112.method3625((byte)-54, node_sub23);
            this.method3078(-17454);
            if (this.method3075((byte)81)) {
               if (~this.anInt3114 != 0 && this.anInt3113 != -1) {
                  node_sub23.method2632(this.anInt3114, 0, this.anInt3113);
               }

               node_sub23.aBoolean7205 = true;
               return true;
            }
         }

         this.method3082(30543, node_sub23);
      }

      if (b >= -95) {
         this.method3075((byte)1);
      }

      return false;
   }

   private final void method3078(int i) {
      ++anInt3125;
      if (i != -17454) {
         this.anInt3113 = -76;
      }

      boolean bool = false;
      int i_4_ = 0;
      int i_5_ = 0;

      for(Node_Sub23 node_sub23 = (Node_Sub23)this.aClass312_3112.method3613(i + 82734);
         node_sub23 != null;
         node_sub23 = (Node_Sub23)this.aClass312_3112.method3620(16776960)
      ) {
         int i_6_ = node_sub23.method2630(i ^ -17453);
         if (i_4_ < i_6_) {
            i_4_ = i_6_;
         }

         i_5_ += node_sub23.method2623(1);
         bool |= node_sub23.method2631((byte)-100);
      }

      int i_7_;
      if (~i_4_ != -3) {
         if (i_4_ == 1) {
            i_7_ = 34842;
         } else {
            i_7_ = 6408;
         }
      } else {
         i_7_ = 34836;
      }

      if (~i_7_ != ~this.anInt3142) {
         this.anInt3142 = i_7_;
         this.aBoolean3134 = true;
      }

      int i_8_ = ~this.anInt3136 >= -3 ? this.anInt3136 : 2;
      int i_9_ = ~i_5_ >= -3 ? i_5_ : 2;
      this.anInt3136 = i_5_;
      if (this.aBoolean3140 == !bool) {
         this.aBoolean3139 = true;
         this.aBoolean3140 = bool;
      }

      if (i_8_ != i_9_) {
         this.aBoolean3131 = this.aBoolean3134 = true;
      }
   }

   final boolean method3079(int i) {
      if (i != -2) {
         return false;
      } else {
         ++anInt3120;
         return this.aClass382_3129 != null;
      }
   }

   final void method3080(boolean bool) {
      this.aCacheNode_Sub17_3137 = null;
      if (bool) {
         method3083(true);
      }

      ++anInt3117;
      this.aCacheNode_Sub17_3138 = null;
      this.aClass382_3129 = this.aClass382_3109 = this.aClass382_3128 = null;
      this.aClass169_Sub2Array3132 = null;
      this.aClass169_Sub2_3135 = null;
      if (!this.aClass312_3112.method3616(0)) {
         for(Node node = this.aClass312_3112.method3613(65280); node != this.aClass312_3112.aNode3958; node = node.aNode2800) {
            ((Node_Sub23)node).method2626((byte)-127);
         }
      }

      this.anInt3114 = this.anInt3113 = 1;
   }

   final boolean method3081(int i, int i_10_, int i_11_, int i_12_, int i_13_) {
      ++anInt3124;
      if (this.aClass382_3129 != null && !this.aClass312_3112.method3616(0)) {
         if (i_10_ != this.anInt3114 || ~i_12_ != ~this.anInt3113) {
            this.anInt3114 = i_10_;
            this.anInt3113 = i_12_;

            for(Node node = this.aClass312_3112.method3613(65280); this.aClass312_3112.aNode3958 != node; node = node.aNode2800) {
               ((Node_Sub23)node).method2632(this.anInt3114, 0, this.anInt3113);
            }

            this.aBoolean3134 = true;
            this.aBoolean3139 = true;
            this.aBoolean3131 = true;
         }

         if (this.method3075((byte)81)) {
            this.anInt3119 = i_13_;
            this.aBoolean3110 = true;
            this.anInt3111 = i_11_;
            this.aGLToolkit3121.method1410(15, this.aClass382_3129);
            this.aClass382_3129.method4183(0, (byte)121);
            this.aGLToolkit3121.method1465(this.anInt3113 - (-this.anInt3119 + this.aGLToolkit3121.anInt6567), -this.anInt3111, i + 16053);
            return true;
         } else {
            if (i != 0) {
               this.method3075((byte)-6);
            }

            return false;
         }
      } else {
         return false;
      }
   }

   final void method3082(int i, Node_Sub23 node_sub23) {
      ++anInt3126;
      node_sub23.aBoolean7205 = false;
      node_sub23.method2626((byte)-128);
      node_sub23.method2160((byte)126);
      if (i != 30543) {
         this.aCacheNode_Sub17_3138 = null;
      }

      this.method3078(-17454);
   }

   public static void method3083(boolean bool) {
      index16 = null;
      aGLSprite3141 = null;
      if (bool) {
         method3083(true);
      }

      aCalendar3144 = null;
      aClass318_3130 = null;
      aClass192_3123 = null;
      aClass197_3115 = null;
   }

   Class247(GLToolkit gltoolkit) {
      this.anInt3113 = 1;
      this.anInt3119 = 0;
      this.anInt3111 = 0;
      this.aClass312_3112 = new Class312();
      this.aClass169_Sub2Array3132 = new Class169_Sub2[2];
      this.aBoolean3131 = true;
      this.aBoolean3133 = true;
      this.anInt3136 = 0;
      this.aBoolean3140 = false;
      this.aBoolean3139 = true;
      this.aBoolean3134 = true;
      this.anInt3142 = -1;
      this.aGLToolkit3121 = gltoolkit;
      if (this.aGLToolkit3121.aBoolean6719 && this.aGLToolkit3121.aBoolean6649) {
         this.aClass382_3129 = this.aClass382_3128 = new Class382(this.aGLToolkit3121);
         if (~this.aGLToolkit3121.anInt6599 < -2 && this.aGLToolkit3121.aBoolean6662 && this.aGLToolkit3121.aBoolean6735) {
            this.aClass382_3129 = this.aClass382_3109 = new Class382(this.aGLToolkit3121);
         }
      }
   }
}
