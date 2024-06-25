package jaggl;

import jaclib.memory.NativeBuffer;

public class MapBuffer extends NativeBuffer {
   private int c;

   public final boolean a(int i, int i_0_, int i_1_) {
      if (this.c != 0) {
         return false;
      } else {
         long l = OpenGL.glMapBufferARB(i, i_1_);
         if (l == 0L) {
            return false;
         } else {
            this.a(l, i_0_);
            this.c = i;
            return true;
         }
      }
   }

   public final boolean a() {
      return ~this.c != -1;
   }

   @Override
   public final void a(byte[] bs, int i, int i_2_, int i_3_) {
      if (this.c == 0) {
         throw new RuntimeException();
      } else {
         super.a(bs, i, i_2_, i_3_);
      }
   }

   public final boolean b() {
      boolean bool = true;
      if (this.c != 0) {
         bool = OpenGL.glUnmapBufferARB(this.c);
         this.a(0L, 0);
         this.c = 0;
      }

      return bool;
   }
}
