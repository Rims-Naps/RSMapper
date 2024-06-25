import com.ms.awt.WComponentPeer;
import com.ms.dll.Callback;
import com.ms.dll.Root;
import com.ms.win32.User32;
import java.awt.Component;

public class Callback_Sub1 extends Callback {
   private volatile int anInt1;
   private volatile int anInt2;
   private volatile boolean aBoolean3 = true;
   private int anInt4;
   private boolean aBoolean5;

   final synchronized int method80(int i, int i_0_, int i_1_, int i_2_) {
      if (this.anInt2 != i) {
         int i_3_ = User32.GetWindowLong(i, -4);
         return User32.CallWindowProc(i_3_, i, i_0_, i_1_, i_2_);
      } else {
         if (~i_0_ == -33) {
            int i_4_ = i_2_ & 65535;
            if (~i_4_ == -2) {
               User32.SetCursor(this.aBoolean3 ? this.anInt4 : 0);
               return 0;
            }
         }

         if (i_0_ == 101024) {
            User32.SetCursor(this.aBoolean3 ? this.anInt4 : 0);
            return 0;
         } else {
            if (~i_0_ == -2) {
               this.anInt2 = 0;
               this.aBoolean3 = true;
            }

            return User32.CallWindowProc(this.anInt1, i, i_0_, i_1_, i_2_);
         }
      }
   }

   final void method81(int i, int i_5_, int i_6_) {
      if (i_5_ == -33) {
         User32.SetCursorPos(i, i_6_);
      }
   }

   final void method82(boolean bool, Component component, byte b) {
      WComponentPeer wcomponentpeer = (WComponentPeer)component.getPeer();
      int i = wcomponentpeer.getTopHwnd();
      if (i != this.anInt2 || bool != this.aBoolean3) {
         if (!this.aBoolean5) {
            this.anInt4 = User32.LoadCursor(0, 32512);
            Root.alloc(this);
            this.aBoolean5 = true;
         }

         if (~this.anInt2 != ~i) {
            if (this.anInt2 != 0) {
               this.aBoolean3 = true;
               User32.SendMessage(i, 101024, 0, 0);
               synchronized(this) {
                  User32.SetWindowLong(this.anInt2, -4, this.anInt1);
               }
            }

            synchronized(this) {
               this.anInt2 = i;
               this.anInt1 = User32.SetWindowLong(this.anInt2, -4, this);
            }
         }

         int i_7_ = 1 % ((b - 35) / 46);
         this.aBoolean3 = bool;
         User32.SendMessage(i, 101024, 0, 0);
      }
   }

   Callback_Sub1() {
   }
}
