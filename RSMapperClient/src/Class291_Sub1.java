import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.Method;

public class Class291_Sub1 extends Class291 implements KeyListener, FocusListener {
   static int anInt8185;
   static int anInt8186;
   static int anInt8187;
   static boolean aBoolean8188 = false;
   static int anInt8189;
   static int anInt8190;
   static int anInt8191;
   static int anInt8192;
   static int[] anIntArray8193 = new int[8];
   static int anInt8194;
   static int anInt8195;
   static int anInt8196;
   private Class312 aClass312_8197 = new Class312();
   static Class13 aClass13_8198;
   static int anInt8199;
   static int anInt8200;
   static int anInt8201;
   static int anInt8202;
   static int lastKeyPressed;
   private Class312 aClass312_8203 = new Class312();
   static int anInt8204;
   private Component aComponent8205;
   private boolean[] aBooleanArray8206 = new boolean[112];

   static final void method3454(int i, int i_0_, int i_1_, int i_2_) {
      ++anInt8196;
      if (~Class368.anInt4550 != ~i_1_ || ~Class72.anInt973 != ~i || i_0_ != Node_Sub29_Sub1.anInt10012) {
         Class194_Sub1.aBoolean6892 = true;
         Class72.anInt973 = i;
         Class368.anInt4550 = i_1_;
         if (i_2_ == 128) {
            Node_Sub29_Sub1.anInt10012 = i_0_;
            double d = -(Math.PI * (double)(i_1_ * 2)) / 16384.0;
            double d_3_ = -((double)(2 * i) * Math.PI) / 16384.0;
            double d_4_ = Math.cos(d_3_);
            double d_5_ = Math.sin(d_3_);
            double d_6_ = Math.cos(d);
            double d_7_ = Math.sin(d);
            Class363.aDouble4509 = d_4_;
            FileOnDisk.aDouble1318 = d_6_;
            LightFX.aDouble4108 = -d_4_ * d_7_;
            Class195.aDouble2401 = d_5_;
            Animable_Sub2_Sub1.aDouble10631 = d_5_ * d_7_;
            Class282.aDouble3585 = d_4_ * d_6_;
            Class320_Sub6.aDouble8262 = d_6_ * -d_5_;
            SeekableFile.aDouble3883 = 0.0;
            Class165.aDouble2028 = d_7_;
         }
      }
   }

   private final int method3455(int i) {
      ++anInt8186;
      int i_8_ = 0;
      if (this.aBooleanArray8206[81]) {
         i_8_ |= 1;
      }

      if (i != -17254) {
         this.method3453((byte)-94);
      }

      if (this.aBooleanArray8206[82]) {
         i_8_ |= 4;
      }

      if (this.aBooleanArray8206[86]) {
         i_8_ |= 2;
      }

      return i_8_;
   }

   private final void method3456(char c, int i, int i_9_, int i_10_) {
      ++anInt8190;
      Node_Sub12 node_sub12 = new Node_Sub12();
      node_sub12.aChar5458 = c;
      node_sub12.anInt5454 = i_9_;
      if (i != 10830) {
         this.method3452((byte)83);
      }

      node_sub12.anInt5463 = i_10_;
      node_sub12.aLong5461 = Class313.method3650(false);
      this.aClass312_8203.method3625((byte)-54, node_sub12);
   }

   @Override
   public final void focusGained(FocusEvent focusevent) {
      ++anInt8204;
   }

   @Override
   final Interface21 method3449(int i) {
      if (i != -22959) {
         this.method3460((byte)59);
      }

      ++anInt8189;
      return (Interface21)this.aClass312_8197.method3619(i + 22869);
   }

   @Override
   final void method3453(byte b) {
      ++anInt8202;
      this.method3460((byte)-20);
      if (b < 42) {
         aClass13_8198 = null;
      }
   }

   @Override
   final synchronized void method3452(byte b) {
      if (b == 45) {
         this.aClass312_8197.method3614(-601);
         ++anInt8187;

         for(Node_Sub12 node_sub12 = (Node_Sub12)this.aClass312_8203.method3619(b ^ -96);
            node_sub12 != null;
            node_sub12 = (Node_Sub12)this.aClass312_8203.method3619(-79)
         ) {
            node_sub12.anInt5462 = this.method3455(b ^ -17225);
            if (node_sub12.anInt5463 != 0) {
               if (node_sub12.anInt5463 != 1) {
                  if (node_sub12.anInt5463 != -1) {
                     if (node_sub12.anInt5463 == 3) {
                        this.aClass312_8197.method3625((byte)-54, node_sub12);
                     }
                  } else {
                     for(int i = 0; ~i > -113; ++i) {
                        if (this.aBooleanArray8206[i]) {
                           Node_Sub12 node_sub12_11_ = new Node_Sub12();
                           node_sub12_11_.anInt5454 = i;
                           node_sub12_11_.anInt5462 = node_sub12.anInt5462;
                           node_sub12_11_.aChar5458 = 0;
                           node_sub12_11_.anInt5463 = 1;
                           node_sub12_11_.aLong5461 = node_sub12.aLong5461;
                           this.aClass312_8197.method3625((byte)-54, node_sub12_11_);
                           this.aBooleanArray8206[i] = false;
                        }
                     }
                  }
               } else if (this.aBooleanArray8206[node_sub12.anInt5454]) {
                  this.aClass312_8197.method3625((byte)-54, node_sub12);
                  this.aBooleanArray8206[node_sub12.anInt5454] = false;
               }
            } else {
               if (!this.aBooleanArray8206[node_sub12.anInt5454]) {
                  Node_Sub12 node_sub12_12_ = new Node_Sub12();
                  node_sub12_12_.aChar5458 = 0;
                  node_sub12_12_.anInt5454 = node_sub12.anInt5454;
                  node_sub12_12_.anInt5463 = 0;
                  node_sub12_12_.anInt5462 = node_sub12.anInt5462;
                  node_sub12_12_.aLong5461 = node_sub12.aLong5461;
                  this.aClass312_8197.method3625((byte)-54, node_sub12_12_);
                  this.aBooleanArray8206[node_sub12.anInt5454] = true;
               }

               node_sub12.anInt5463 = 2;
               this.aClass312_8197.method3625((byte)-54, node_sub12);
            }
         }
      }
   }

   @Override
   public final synchronized void keyPressed(KeyEvent keyevent) {
      ++anInt8191;
      this.method3458((byte)-51, 0, keyevent);
      KeybindHandler.handleKeyPressed(keyevent);
   }

   @Override
   public final synchronized void keyReleased(KeyEvent keyevent) {
      ++anInt8195;
      this.method3458((byte)-51, 1, keyevent);
      KeybindHandler.handleKeyReleased(keyevent);
   }

   public static void method3457(int i) {
      anIntArray8193 = null;
      if (i != 112) {
         aBoolean8188 = true;
      }

      aClass13_8198 = null;
   }

   private final void method3458(byte b, int i, KeyEvent keyevent) {
      ++anInt8194;
      int key = keyevent.getKeyCode();
      if (i == 0 || i == 1) {
         lastKeyPressed = i == 0 ? key : -1;
      }

      if (~key != -1) {
         if (~key <= -1 && ~key > ~Node_Sub38_Sub24.anIntArray10352.length) {
            key = Node_Sub38_Sub24.anIntArray10352[key];
            if (~i == -1 && ~(128 & key) != -1) {
               key = 0;
            } else {
               key &= -129;
            }
         } else {
            key = 0;
         }
      } else {
         key = 0;
      }

      if (key != 0) {
         if (b != -51) {
            this.aComponent8205 = null;
         }

         this.method3456('\u0000', 10830, key, i);
         keyevent.consume();
      }
   }

   private final void method3459(int i, Component component) {
      ++anInt8192;
      this.method3460((byte)-44);
      this.aComponent8205 = component;
      Method method = SignLink.aMethod4004;
      if (method != null) {
         try {
            method.invoke(this.aComponent8205, Boolean.FALSE);
         } catch (Throwable var5) {
         }
      }

      if (i == 0) {
         this.aComponent8205.addKeyListener(this);
         this.aComponent8205.addFocusListener(this);
      }
   }

   private final void method3460(byte b) {
      ++anInt8200;
      if (this.aComponent8205 != null) {
         this.aComponent8205.removeKeyListener(this);
         this.aComponent8205.removeFocusListener(this);
         this.aComponent8205 = null;
         if (b <= -12) {
            for(int i = 0; i < 112; ++i) {
               this.aBooleanArray8206[i] = false;
            }

            this.aClass312_8197.method3614(-601);
            this.aClass312_8203.method3614(-601);
         }
      }
   }

   @Override
   public final synchronized void focusLost(FocusEvent focusevent) {
      ++anInt8185;
      this.method3456('\u0000', 10830, 0, -1);
   }

   @Override
   public final synchronized void keyTyped(KeyEvent keyevent) {
      ++anInt8199;
      char c = keyevent.getKeyChar();
      if (~c != -1 && Class106.method1121(-127, c)) {
         this.method3456(c, 10830, -1, 3);
         keyevent.consume();
      }
   }

   @Override
   final boolean isKeyHeld(int i, int i_14_) {
      ++anInt8201;
      int i_15_ = -86 / ((i - 28) / 53);
      return i_14_ >= 0 && i_14_ < 112 ? this.aBooleanArray8206[i_14_] : false;
   }

   Class291_Sub1(Component component) {
      Class355.method4019(false);
      this.method3459(0, component);
   }
}
