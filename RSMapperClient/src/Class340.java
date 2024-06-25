import java.awt.Container;

public class Class340 implements Runnable {
   private boolean aBoolean4206;
   static int anInt4207;
   static int anInt4208;
   static int anInt4209;
   static int anInt4210;
   static int anInt4211;
   static int anInt4212;
   static int anInt4213;
   private volatile boolean aBoolean4214;
   static int anInt4215;
   private Interface16 anInterface16_4216 = new Class350();
   static int anInt4217 = -1;
   static int anInt4218;
   static int anInt4219;
   static int anInt4220;
   static int anInt4221;
   private long aLong4222;
   private Class110 aClass110_4223;
   static int anInt4224;
   private long aLong4225;
   static int anInt4226;
   private String aString4227;
   private Interface16 anInterface16_4228 = null;
   private int anInt4229;
   private int anInt4230;

   final Class110 method3949(boolean bool) {
      if (bool) {
         this.method3954(-61, null, null, 84, 34L);
      }

      ++anInt4208;
      return this.aClass110_4223;
   }

   final long method3950(byte b) {
      if (b < 37) {
         this.anInterface16_4228 = null;
      }

      ++anInt4211;
      return this.aLong4225;
   }

   final synchronized void method3951(byte b) {
      this.aBoolean4206 = true;
      ++anInt4212;
      if (b != 66) {
         this.method3951((byte)-109);
      }
   }

   final void method3952(int i) {
      if (i == 100) {
         ++anInt4224;
         this.aBoolean4214 = true;
      }
   }

   final synchronized void setNextLoadingScreen(byte b, Interface16 interface16) {
      ++anInt4207;
      if (b <= -42) {
         this.aLong4222 = Class313.method3650(true);
      }
   }

   final synchronized void method3954(int i, String string, Class110 class110, int i_0_, long l) {
      this.anInt4230 = i;
      this.aClass110_4223 = class110;
      this.aLong4225 = l;
      this.aString4227 = string;
      int i_1_ = -111 / ((i_0_ - -2) / 49);
      ++anInt4210;
   }

   final int method3955(int i) {
      ++anInt4221;
      if (this.aClass110_4223 == null) {
         return 0;
      } else {
         if (i != 7398) {
            this.anInt4229 = -104;
         }

         int i_2_ = this.aClass110_4223.method1130(-3);
         if (this.aClass110_4223.aBoolean1393 && ~this.aClass110_4223.anInt1382 < ~this.anInt4230) {
            return 1 + this.anInt4230;
         } else if (~i_2_ > -1 || ~i_2_ <= ~(Node_Sub25_Sub4.aClass110Array10006.length + -1)) {
            return 100;
         } else {
            return ~this.anInt4230 == ~this.aClass110_4223.anInt1383 ? this.aClass110_4223.anInt1382 : this.aClass110_4223.anInt1383;
         }
      }
   }

   final synchronized boolean method3956(int i) {
      ++anInt4226;
      int i_3_ = -96 % ((-17 - i) / 60);
      return this.anInterface16_4216.method61(false, this.aLong4222);
   }

   final String method3957(byte b) {
      if (b < 23) {
         this.method3949(false);
      }

      ++anInt4219;
      return this.aString4227;
   }

   final int method3958(byte b) {
      ++anInt4213;
      if (b != 84) {
         this.method3959(79);
      }

      return this.anInt4230;
   }

   @Override
   public final void run() {
      while(!this.aBoolean4214) {
         long l = Class313.method3650(false);
         synchronized(this) {
            try {
               ++this.anInt4229;
               if (this.anInterface16_4216 instanceof Class350) {
                  this.anInterface16_4216.method63(this.aBoolean4206, (byte)-113);
               } else {
                  long l_4_ = Class313.method3650(false);
                  if (Class93.aGraphicsToolkit1241 != null
                     && this.anInterface16_4228 != null
                     && this.anInterface16_4228.method60(66) != 0
                     && ~this.aLong4222 <= ~(-((long)this.anInterface16_4228.method60(36)) + l_4_)) {
                     int i = (int)((-this.aLong4222 + l_4_) * 255L / (long)this.anInterface16_4228.method60(124));
                     int i_5_ = -i + 255;
                     Node_Sub36_Sub1.method2758(-90);
                     i_5_ = i_5_ << 24 | 16777215;
                     i = 16777215 | i << 24;
                     Class93.aGraphicsToolkit1241.GA(0);
                     GLSprite glsprite = Class93.aGraphicsToolkit1241.a(Class360.canvasWidth, Class205.canvasHeight, true);
                     Class93.aGraphicsToolkit1241.method1245(glsprite, -1);
                     this.anInterface16_4228.method63(true, (byte)-95);
                     Class93.aGraphicsToolkit1241.v();
                     glsprite.method1191(0, 0, 0, i_5_, 1);
                     Class93.aGraphicsToolkit1241.method1245(glsprite, -1);
                     Class93.aGraphicsToolkit1241.GA(0);
                     this.anInterface16_4216.method63(true, (byte)-63);
                     Class93.aGraphicsToolkit1241.v();
                     glsprite.method1191(0, 0, 0, i, 1);
                  } else {
                     if (this.anInterface16_4228 != null) {
                        this.aBoolean4206 = true;
                        this.anInterface16_4228.method59(6312);
                        this.anInterface16_4228 = null;
                     }

                     if (this.aBoolean4206) {
                        Node_Sub36_Sub1.method2758(-35);
                        if (Class93.aGraphicsToolkit1241 != null) {
                           Class93.aGraphicsToolkit1241.GA(0);
                        }
                     }

                     this.anInterface16_4216
                        .method63(this.aBoolean4206 || Class93.aGraphicsToolkit1241 != null && Class93.aGraphicsToolkit1241.B(), (byte)-123);
                  }

                  try {
                     if (Class93.aGraphicsToolkit1241 != null && !(this.anInterface16_4216 instanceof Class350)) {
                        Class93.aGraphicsToolkit1241.method1241(19088);
                     }
                  } catch (Exception_Sub1 var9) {
                     ClanChat.method507(var9, var9.getMessage() + " (Recovered) " + Class158.aClient1983.method100(10), -108);
                     Class22.method300(0, true, true);
                  }
               }

               Container container;
               if (Node_Sub29.aFrame7344 == null) {
                  if (Class96.anApplet1270 != null) {
                     container = Class96.anApplet1270;
                  } else {
                     container = Class82.aGameStub1123;
                  }
               } else {
                  container = Node_Sub29.aFrame7344;
               }

               container.getSize();
               container.getSize();
               if (container == Node_Sub29.aFrame7344) {
                  Node_Sub29.aFrame7344.getInsets();
               }

               this.aBoolean4206 = false;
               if (Class93.aGraphicsToolkit1241 != null
                  && !(this.anInterface16_4216 instanceof Class350)
                  && this.aClass110_4223.method1130(-3) < Class110.aClass110_1409.method1130(-3)) {
                  Npc.method880((byte)11);
               }
            } catch (Exception var10) {
               continue;
            }
         }

         long l_6_ = Class313.method3650(false);
         int i = (int)(20L + l + -l_6_);
         if (~i < -1) {
            Class262_Sub22.method3208((long)i, false);
         }
      }

      ++anInt4215;
   }

   final int method3959(int i) {
      if (i != 255) {
         this.method3952(0);
      }

      ++anInt4218;
      return this.anInt4229;
   }
}
