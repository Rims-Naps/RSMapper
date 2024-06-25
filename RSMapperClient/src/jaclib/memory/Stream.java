package jaclib.memory;

public class Stream {
   private jaclib.memory.Buffer a;
   private int b;
   private int e;
   private int d;
   private byte[] c;

   public final void a(float f) {
      if (3 + this.b >= this.c.length) {
         this.c();
      }

      int i = floatToRawIntBits(f);
      this.c[this.b++] = (byte)(i >> 24);
      this.c[this.b++] = (byte)(i >> 16);
      this.c[this.b++] = (byte)(i >> 8);
      this.c[this.b++] = (byte)i;
   }

   public final int a() {
      return this.b + this.d;
   }

   public final void f(int i) {
      this.c();
      this.d = i;
   }

   public final void b(int i) {
      if (~this.c.length >= ~(this.b + 1)) {
         this.c();
      }

      this.c[this.b++] = (byte)(i >> 8);
      this.c[this.b++] = (byte)i;
   }

   public final void c(int i) {
      if (this.c.length <= this.b - -1) {
         this.c();
      }

      this.c[this.b++] = (byte)i;
      this.c[this.b++] = (byte)(i >> 8);
   }

   private static final native byte getLSB(int var0);

   public final void a(jaclib.memory.Buffer buffer) {
      this.a(buffer, 0, buffer.getSize());
   }

   public Stream(jaclib.memory.Buffer buffer) {
      this(buffer, 0, buffer.getSize());
   }

   public static final native int floatToRawIntBits(float var0);

   public final void a(int i, int i_0_, int i_1_, int i_2_) {
      if (~(3 + this.b) <= ~this.c.length) {
         this.c();
      }

      this.c[this.b++] = (byte)i_1_;
      this.c[this.b++] = (byte)i_0_;
      this.c[this.b++] = (byte)i;
      this.c[this.b++] = (byte)i_2_;
   }

   public final void a(int i) {
      if (~this.c.length >= ~(this.b + 3)) {
         this.c();
      }

      this.c[this.b++] = (byte)i;
      this.c[this.b++] = (byte)(i >> 8);
      this.c[this.b++] = (byte)(i >> 16);
      this.c[this.b++] = (byte)(i >> 24);
   }

   private final void a(jaclib.memory.Buffer buffer, int i, int i_3_) {
      this.c();
      this.a = buffer;
      this.e = i_3_ + i;
      this.d = i;
      if (this.e > buffer.getSize()) {
         throw new RuntimeException();
      }
   }

   public final void e(int i) {
      if (~(3 + this.b) <= ~this.c.length) {
         this.c();
      }

      this.c[this.b++] = (byte)(i >> 16);
      this.c[this.b++] = (byte)(i >> 8);
      this.c[this.b++] = (byte)i;
      this.c[this.b++] = (byte)(i >> 24);
   }

   public final void d(int i) {
      if (~this.b <= ~this.c.length) {
         this.c();
      }

      this.c[this.b++] = (byte)i;
   }

   public final void b(int i, int i_4_, int i_5_, int i_6_) {
      if (~this.c.length >= ~(this.b - -3)) {
         this.c();
      }

      this.c[this.b++] = (byte)i;
      this.c[this.b++] = (byte)i_4_;
      this.c[this.b++] = (byte)i_5_;
      this.c[this.b++] = (byte)i_6_;
   }

   public static final boolean b() {
      return ~getLSB(-65536) == 0;
   }

   public Stream(jaclib.memory.Buffer buffer, int i, int i_7_) {
      this(~buffer.getSize() <= -4097 ? 4096 : buffer.getSize());
      this.a(buffer, i, i_7_);
   }

   public Stream() {
      this(4096);
   }

   private Stream(int i) {
      this.c = new byte[i];
   }

   public final void b(float f) {
      if (~(3 + this.b) <= ~this.c.length) {
         this.c();
      }

      int i = floatToRawIntBits(f);
      this.c[this.b++] = (byte)i;
      this.c[this.b++] = (byte)(i >> 8);
      this.c[this.b++] = (byte)(i >> 16);
      this.c[this.b++] = (byte)(i >> 24);
   }

   public final void c() {
      if (this.b > 0) {
         if (~(this.d + this.b) < ~this.e) {
            throw new RuntimeException();
         }

         this.a.a(this.c, 0, this.d, this.b);
         this.d = this.d + this.b;
         this.b = 0;
      }
   }
}
