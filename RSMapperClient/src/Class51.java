import jaclib.memory.Source;
import jaclib.memory.heap.NativeHeapBuffer;
import jaggl.MapBuffer;
import jaggl.OpenGL;

abstract class Class51 implements Interface15 {
   private int anInt5324 = -1;
   static int anInt5325;
   private int anInt5326;
   static int anInt5327;
   static int anInt5328;
   private int anInt5329;
   static int anInt5330;
   static boolean hasWindowFocus;
   protected GLXToolkit aGLXToolkit5332;
   static int anInt5333;
   static int anInt5334;
   static IncommingPacket INCOMMING_PACKET_69 = new IncommingPacket(69, -2);
   static int anInt5336;
   private boolean aBoolean5337;
   static int anInt5338;
   static Index aClass302_5339;
   private int anInt5340 = 0;
   private int anInt5341;
   static int anInt5342;
   static float aFloat5343;
   private NativeHeapBuffer aNativeHeapBuffer5344;
   static ClanChat playerGuestClan;
   static int anInt5346;

   public static void method514(int i) {
      if (i != 2) {
         aClass302_5339 = null;
      }

      INCOMMING_PACKET_69 = null;
      aClass302_5339 = null;
      playerGuestClan = null;
   }

   void method38(boolean bool) {
      ++anInt5342;
      if (!bool && ~this.anInt5324 < -1) {
         this.aGLXToolkit5332.method1402((byte)-98, this.anInt5324, this.anInt5329);
         this.anInt5324 = -1;
      }
   }

   @Override
   protected final void finalize() throws Throwable {
      this.method38(false);
      ++anInt5325;
      super.finalize();
   }

   final long method515(byte b) {
      ++anInt5328;
      if (b != 50) {
         return -22L;
      } else {
         return ~this.anInt5324 == -1 ? this.aNativeHeapBuffer5344.getAddress() : 0L;
      }
   }

   final boolean method516(int i, Source source, boolean bool) {
      ++anInt5338;
      if (~i < ~this.anInt5341) {
         this.method520(76);
         if (~this.anInt5324 >= -1) {
            throw new RuntimeException("ARGH!");
         }

         OpenGL.glBindBufferARB(this.anInt5326, this.anInt5324);
         OpenGL.glBufferDataARBa(this.anInt5326, i, source.getAddress(), this.aBoolean5337 ? '\u88E0' : '\u88E4');
         this.aGLXToolkit5332.anInt6260 += i + -this.anInt5329;
         this.anInt5341 = i;
      } else {
         if (this.anInt5324 <= 0) {
            throw new RuntimeException("ARGH!");
         }

         OpenGL.glBindBufferARB(this.anInt5326, this.anInt5324);
         OpenGL.glBufferSubDataARBa(this.anInt5326, 0, this.anInt5329, source.getAddress());
         this.aGLXToolkit5332.anInt6260 += -this.anInt5329 + i;
      }

      this.anInt5329 = i;
      return !bool ? true : true;
   }

   final boolean method517(int i, MapBuffer mapbuffer) {
      if (i != 0) {
         this.method57((byte)55);
      }

      ++anInt5334;
      boolean bool = true;
      if (~this.anInt5340 != -1) {
         if (~this.anInt5324 < -1) {
            OpenGL.glBindBufferARB(this.anInt5326, this.anInt5324);
            if (this.anInt5340 == 1) {
               OpenGL.glBufferSubDataARBa(this.anInt5326, 0, this.anInt5341, this.aGLXToolkit5332.aNativeHeapBuffer6171.getAddress());
            } else {
               bool = mapbuffer.b();
            }
         }

         this.anInt5340 = 0;
      }

      return bool;
   }

   final void method518(int i) {
      if (i < 18) {
         this.anInt5341 = 98;
      }

      ++anInt5346;
      if (this.aGLXToolkit5332.aBoolean9316) {
         OpenGL.glBindBufferARB(this.anInt5326, this.anInt5324);
      }
   }

   void method56(int i, int i_0_) {
      if (i != -1696) {
         this.aGLXToolkit5332 = null;
      }

      ++anInt5327;
      if (~i_0_ < ~this.anInt5341) {
         this.method520(55);
         if (this.anInt5324 > 0) {
            OpenGL.glBindBufferARB(this.anInt5326, this.anInt5324);
            OpenGL.glBufferDataARBub(this.anInt5326, i_0_, null, 0, this.aBoolean5337 ? '\u88E0' : '\u88E4');
            this.aGLXToolkit5332.anInt6260 += i_0_ + -this.anInt5341;
         } else {
            this.aNativeHeapBuffer5344 = this.aGLXToolkit5332.method1330(false, -96, i_0_);
         }

         this.anInt5341 = i_0_;
      }

      this.anInt5329 = i_0_;
   }

   final jaclib.memory.Buffer method519(boolean bool, MapBuffer mapbuffer, int i) {
      ++anInt5333;
      if (i != -5934) {
         this.method518(74);
      }

      if (this.anInt5340 == 0) {
         this.method520(i ^ -5974);
         if (this.anInt5324 <= 0) {
            this.anInt5340 = 2;
            return this.aNativeHeapBuffer5344;
         }

         OpenGL.glBindBufferARB(this.anInt5326, this.anInt5324);
         if (bool) {
            OpenGL.glBufferDataARBub(this.anInt5326, this.anInt5341, null, 0, !this.aBoolean5337 ? '\u88E4' : '\u88E0');
            if (this.aGLXToolkit5332.aNativeHeapBuffer6171.b >= this.anInt5329) {
               this.anInt5340 = 1;
               return this.aGLXToolkit5332.aNativeHeapBuffer6171;
            }
         }

         if (!mapbuffer.a() && mapbuffer.a(this.anInt5326, this.anInt5329, 35001)) {
            this.anInt5340 = 2;
            return mapbuffer;
         }
      }

      return null;
   }

   @Override
   public int method57(byte b) {
      if (b >= -56) {
         return -121;
      } else {
         ++anInt5330;
         return this.anInt5329;
      }
   }

   Class51(GLXToolkit glxtoolkit, int i, boolean bool) {
      this.aBoolean5337 = bool;
      this.anInt5326 = i;
      this.aGLXToolkit5332 = glxtoolkit;
   }

   private final void method520(int i) {
      ++anInt5336;
      if (~this.anInt5324 > -1) {
         if (this.aGLXToolkit5332.aBoolean9316) {
            OpenGL.glGenBuffersARB(1, Class307.anIntArray3896, 0);
            this.anInt5324 = Class307.anIntArray3896[0];
            OpenGL.glBindBufferARB(this.anInt5326, this.anInt5324);
         } else {
            this.anInt5324 = 0;
         }

         if (i <= 1) {
            this.anInt5324 = 39;
         }
      }
   }
}
