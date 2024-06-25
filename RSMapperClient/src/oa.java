import java.awt.Dimension;
import java.awt.Rectangle;
import java.lang.reflect.Method;

public class oa extends GraphicsToolkit implements Interface3 {
   private Class312 aClass312_4991;
   private boolean aBoolean4992;
   protected long nativeid = 0L;
   private static int[] anIntArray4993 = new int[Math.max(Math.max(104, 20), 24573)];
   static int[] anIntArray4994 = anIntArray4993;
   private static int[] anIntArray4995 = new int[8191];
   private static int[] anIntArray4996 = anIntArray4993;
   private static int[] anIntArray4997 = anIntArray4993;
   private ya aYa4998;
   private static int[] anIntArray4999 = new int[8191];
   private static float[] aFloatArray5000 = oa.aFloatArray5005;
   private static byte[] aByteArray5001 = new byte[8191];
   private static short[] aShortArray5002 = new short[8191];
   static int[] anIntArray5003 = new int[6];
   private Class336 aClass336_5004;
   private static float[] aFloatArray5005 = new float[20];
   private Class336 aClass336_5006;
   private HashTable aHashTable5007;
   private int anInt5008;
   private p aP5009;
   private int anInt5010;
   private a[] anAArray5011;
   private boolean aBoolean5012;
   protected int anInt5013;

   private final native void d(int var1);

   @Override
   final native int[] Y();

   @Override
   final void a(Class270 class270) {
   }

   @Override
   final native void f(int var1, int var2);

   public oa(java.awt.Canvas canvas, d var_d, int i, int i_1_) {
      super(var_d);
      this.aBoolean4992 = false;
      this.aClass312_4991 = new Class312();
      this.anInt5008 = 4096;
      this.anInt5010 = 4096;
      this.aHashTable5007 = new HashTable(4);
      this.aBoolean5012 = false;

      try {
         if (!Node_Sub38_Sub2.method2793(1, "sw3d")) {
            throw new RuntimeException("");
         } else {
            Class164.method1741(-1);
            this.MA(this.aD1543, 0, 0);
            Class110.method1132(0, true, false);
            this.aBoolean5012 = true;
            this.aClass336_5004 = new ja();
            this.a(new ja());
            this.j(1);
            this.k(0);
            if (canvas != null) {
               this.b(canvas, i, i_1_);
               this.a(canvas);
            }
         }
      } catch (Throwable var6) {
         this.method1233(-7751);
         throw new RuntimeException();
      }
   }

   @Override
   final native void ra(int var1, int var2, int var3, int var4);

   @Override
   final void e(int i) {
      Class164.method1740(-9630);
      this.d(i);

      for(ya var_ya = (ya)this.aClass312_4991.method3613(65280); var_ya != null; var_ya = (ya)this.aClass312_4991.method3620(16776960)) {
         var_ya.r();
      }
   }

   @Override
   final GLSprite a(int[] is, int i, int i_5_, int i_6_, int i_7_, boolean bool) {
      return new j(this, is, i, i_5_, i_6_, i_7_, false);
   }

   @Override
   final boolean a() {
      return false;
   }

   @Override
   final void j(int i) {
      this.anInt5013 = i;
      this.anAArray5011 = new a[this.anInt5013];

      for(int i_8_ = 0; i_8_ < this.anInt5013; ++i_8_) {
         this.anAArray5011[i_8_] = new a(this, this.anInt5008, this.anInt5010);
      }
   }

   @Override
   final int getanInt6367() {
      return 4;
   }

   private final native void MA(d var1, int var2, int var3);

   private final void a(Class198 class198, boolean bool) {
      int i = 0;
      int i_10_ = 0;
      int i_11_ = 0;
      int i_12_ = 0;
      int i_13_ = 0;

      for(EntityNode_Sub3_Sub2 entitynode_sub3_sub2 = (EntityNode_Sub3_Sub2)class198.aClass87_2429.method1015(0);
         entitynode_sub3_sub2 != null;
         entitynode_sub3_sub2 = (EntityNode_Sub3_Sub2)class198.aClass87_2429.method1014(true)
      ) {
         anIntArray4996[i++] = entitynode_sub3_sub2.anInt9174;
         anIntArray4996[i++] = entitynode_sub3_sub2.anInt9171;
         anIntArray4996[i++] = entitynode_sub3_sub2.anInt9173;
         anIntArray4999[i_10_++] = entitynode_sub3_sub2.anInt9176;
         aShortArray5002[i_12_++] = (short)entitynode_sub3_sub2.anInt9177;
         anIntArray4995[i_11_++] = entitynode_sub3_sub2.anInt9172;
         if (bool) {
            aByteArray5001[i_13_++] = entitynode_sub3_sub2.aByte9170;
         }
      }
   }

   @Override
   final Interface4 a(int i, int i_14_) {
      return this.a(i, i_14_, false);
   }

   @Override
   final void a(java.awt.Canvas canvas) {
      if (canvas != null) {
         p var_p = (p)this.aHashTable5007.get(3512, (long)canvas.hashCode());
         this.aP5009 = var_p;
         this.t(var_p);
      } else {
         this.aP5009 = null;
         this.t(null);
      }
   }

   @Override
   final native int E();

   @Override
   final void a(java.awt.Canvas canvas, int i, int i_15_) {
      p var_p = (p)this.aHashTable5007.get(3512, (long)canvas.hashCode());
      var_p.method2768(canvas, i, i_15_);
      if (canvas != null && canvas == this.aP5009.aCanvas5018) {
         this.a(canvas);
      }
   }

   @Override
   final int c(int i, int i_16_) {
      return i | i_16_;
   }

   private final native void FA();

   @Override
   final void a(int i, int i_17_, int i_18_, int i_19_, int i_20_, int i_21_, int i_22_, int i_23_, int i_24_) {
   }

   @Override
   final Class52 a(Class357 class357, Class383[] class383s, boolean bool) {
      int[] is = new int[class383s.length];
      int[] is_25_ = new int[class383s.length];
      boolean bool_26_ = false;

      for(int i = 0; i < class383s.length; ++i) {
         is[i] = class383s[i].anInt4897;
         is_25_[i] = class383s[i].anInt4900;
         if (class383s[i].aByteArray4905 != null) {
            bool_26_ = true;
         }
      }

      if (bool) {
         if (bool_26_) {
            throw new IllegalArgumentException("Cannot specify alpha with non-mono font unless someone writes it");
         } else {
            return new h(this, this.aYa4998, class357, class383s, null);
         }
      } else if (bool_26_) {
         throw new IllegalArgumentException("Cannot specify alpha with non-mono font unless someone writes it");
      } else {
         return new n(this, this.aYa4998, class357, class383s, null);
      }
   }

   @Override
   final void c(int i) {
      this.anAArray5011[i].method155();
   }

   @Override
   final Class270 a(Class270 class270, Class270 class270_27_, float f, Class270 class270_28_) {
      return null;
   }

   @Override
   final void a(int i, int i_29_, int i_30_, int i_31_, int i_32_, int i_33_, int i_34_) {
      this.C().method157(this, i, i_29_, i_30_, i_31_, i_32_, i_33_, i_34_);
   }

   @Override
   final boolean k() {
      return true;
   }

   @Override
   final void a(za var_za) {
      this.aYa4998 = (ya)var_za;
      this.va(var_za);
   }

   @Override
   final boolean w() {
      return false;
   }

   @Override
   final void v() {
      this.a(this.aP5009.aCanvas5018);
   }

   @Override
   final native int M();

   @Override
   final native void H(int var1, int var2, int var3, int[] var4);

   @Override
   final void j() {
   }

   @Override
   final boolean m() {
      return false;
   }

   @Override
   final native int r(int var1, int var2, int var3, int var4, int var5, int var6, int var7);

   @Override
   final void b(boolean bool) {
   }

   @Override
   final void b(int i) {
      this.anInt5008 = this.anInt5010 = i;
      if (this.anInt5013 > 1) {
         throw new IllegalStateException("No MT");
      } else {
         this.j(this.anInt5013);
         this.k(0);
      }
   }

   @Override
   final Node_Sub29 a(int i, int i_43_, int i_44_, int i_45_, int i_46_, float f) {
      return new Node_Sub29_Sub3(i, i_43_, i_44_, i_45_, i_46_, f);
   }

   @Override
   final native void KA(int var1, int var2, int var3, int var4);

   private final boolean c(short s) {
      synchronized(this) {
         TextureDefinitions class91 = this.aD1543.getTexture(s, -8217);
         if (class91 == null) {
            return false;
         } else {
            this.AA(
               s,
               class91.colorIndex,
               class91.unknown1,
               class91.effect,
               class91.effectParam1,
               class91.effectParam2,
               class91.skipTriangles,
               class91.shadowFactor,
               class91.brightness,
               class91.speedU,
               class91.speedV,
               class91.meshGround,
               class91.translucent,
               class91.unknown,
               class91.repeatSides,
               class91.repeatTop,
               class91.mipmaps,
               class91.hdr,
               class91.brickTile,
               class91.combinedMode
            );
            return true;
         }
      }
   }

   @Override
   final native void F(int var1, int var2);

   @Override
   final void b(java.awt.Canvas canvas) {
      if (this.aP5009.aCanvas5018 == canvas) {
         this.a();
      }

      p var_p = (p)this.aHashTable5007.get(3512, (long)canvas.hashCode());
      if (var_p != null) {
         var_p.method2160((byte)112);
         var_p.method2771();
      }
   }

   @Override
   final void a(int i, int i_51_, int i_52_, int i_53_, int i_54_, int i_55_, aa var_aa, int i_56_, int i_57_) {
      this.Z(i, i_51_, i_52_, i_53_, i_54_, i_55_, var_aa, i_56_, i_57_);
   }

   @Override
   final boolean s() {
      return true;
   }

   @Override
   final void a(int i, int i_58_, int i_59_, int i_60_) {
   }

   @Override
   final native int JA(int var1, int var2, int var3, int var4, int var5, int var6);

   @Override
   final void d(int i, int i_66_, int i_67_, int i_68_, int i_69_, int i_70_) {
      this.U(i, i_66_, i_67_, i_69_, i_70_);
      this.U(i, i_66_ + i_68_ - 1, i_67_, i_69_, i_70_);
      this.P(i, i_66_ + 1, i_68_ - 1, i_69_, i_70_);
      this.P(i + i_67_ - 1, i_66_ + 1, i_68_ - 1, i_69_, i_70_);
   }

   @Override
   final native void DA(int var1, int var2, int var3, int var4);

   @Override
   final za a(int i) {
      ya var_ya = new ya(this, i);
      this.aClass312_4991.method3625((byte)-54, var_ya);
      return var_ya;
   }

   private final native void AA(
      short var1,
      short var2,
      int var3,
      byte var4,
      byte var5,
      int var6,
      boolean var7,
      byte var8,
      byte var9,
      byte var10,
      byte var11,
      boolean var12,
      boolean var13,
      boolean var14,
      boolean var15,
      boolean var16,
      byte var17,
      boolean var18,
      boolean var19,
      int var20
   );

   @Override
   final void k(int i) {
      this.anAArray5011[i].method142();
   }

   @Override
   final native int i();

   @Override
   final boolean p() {
      return true;
   }

   @Override
   final void a(int[] is) {
      Dimension dimension = this.aP5009.aCanvas5018.getSize();
      is[0] = dimension.width;
      is[1] = dimension.height;
   }

   @Override
   final native void ZA(int var1, float var2, float var3, float var4, float var5, float var6);

   @Override
   final void q() {
   }

   @Override
   final void a(int i, int i_94_, int i_95_, int i_96_, int i_97_, int i_98_, aa var_aa, int i_99_, int i_100_, int i_101_, int i_102_, int i_103_) {
   }

   @Override
   final native void za(int var1, int var2, int var3, int var4, int var5);

   @Override
   final native void HA(int var1, int var2, int var3, int var4, int[] var5);

   @Override
   final native void Q(int var1, int var2, int var3, int var4, int var5, int var6, byte[] var7, int var8, int var9);

   @Override
   final native void X(int var1);

   @Override
   final void d() {
   }

   @Override
   final native void da(int var1, int var2, int var3, int[] var4);

   @Override
   final void a(Interface6 interface6) {
      wa var_wa = (wa)interface6;
      this.n(var_wa.aJ5050.nativeid, var_wa.aXa5052.nativeid);
   }

   @Override
   final void a(
      int i, int i_120_, int i_121_, int i_122_, int i_123_, int i_124_, int i_125_, int i_126_, int i_127_, int i_128_, int i_129_, int i_130_, int i_131_
   ) {
   }

   @Override
   final boolean o() {
      return false;
   }

   @Override
   final boolean x() {
      return true;
   }

   @Override
   final boolean z() {
      return true;
   }

   @Override
   final DrawableModel a(Model model, int i, int i_132_, int i_133_, int i_134_) {
      return new i(this, this.aYa4998, model, i, i_132_, i_133_, i_134_);
   }

   @Override
   final void b(java.awt.Canvas canvas, int i, int i_135_) {
      p var_p = (p)this.aHashTable5007.get(3512, (long)canvas.hashCode());
      if (var_p == null) {
         try {
            Class<?> var_class = Class.forName("java.awt.Canvas");
            Method method = var_class.getMethod("setIgnoreRepaint", Boolean.TYPE);
            method.invoke(canvas, Boolean.TRUE);
         } catch (Exception var7) {
         }

         var_p = new p(this, canvas, i, i_135_);
         this.aHashTable5007.put((long)canvas.hashCode(), var_p, -124);
      } else if (var_p.anInt5015 != i || var_p.anInt5016 != i_135_) {
         var_p.method2768(canvas, i, i_135_);
      }
   }

   @Override
   final native void b(int var1, int var2, int var3, int var4, double var5);

   @Override
   public final native void w(boolean var1);

   @Override
   final aa a(int i, int i_139_, int[] is, int[] is_140_) {
      return new na(this, this.aYa4998, i, i_139_, is, is_140_);
   }

   @Override
   final Renderer c() {
      return new Renderer(0, "SSE", 1, "CPU", 0L);
   }

   @Override
   final boolean t() {
      return false;
   }

   @Override
   final Class336 y() {
      return new ja();
   }

   @Override
   final GLSprite a(int i, int i_141_, int i_142_, int i_143_, boolean bool) {
      return new j(this, i, i_141_, i_142_, i_143_, !bool);
   }

   @Override
   final boolean l() {
      return true;
   }

   private final native void n(long var1, long var3);

   @Override
   final void h() {
   }

   @Override
   final GLSprite a(int i, int i_145_, boolean bool) {
      return new j(this, i, i_145_);
   }

   @Override
   final void a(int i, int i_146_, int i_147_, int i_148_, int i_149_, int i_150_) {
      this.wa(i, i_146_, i_147_, i_148_, i_149_, i_150_);
   }

   private final native void ma(long var1);

   @Override
   final native void ya();

   final a C() {
      for(int i = 0; i < this.anInt5013; ++i) {
         if (this.anAArray5011[i].aRunnable4984 == Thread.currentThread()) {
            return this.anAArray5011[i];
         }
      }

      return null;
   }

   @Override
   final native void pa();

   @Override
   final native void xa(float var1);

   @Override
   final native void L(int var1, int var2, int var3);

   private final native void wa(int var1, int var2, int var3, int var4, int var5, int var6);

   private final boolean WA(short s) {
      synchronized(this.aD1543) {
         if (!this.aD1543.method7(9900, s)) {
            return false;
         } else {
            TextureDefinitions class91 = this.aD1543.getTexture(s, -8217);
            if (class91 == null) {
               return false;
            } else {
               int[] is;
               if (class91.unknown1 != 2) {
                  is = this.aD1543.method11(128, true, 128, s, (byte)0, 0.7F);
               } else {
                  is = this.aD1543.method8(0.7F, s, 128, false, true, 128);
               }

               this.CA(
                  s,
                  is,
                  class91.colorIndex,
                  class91.unknown1,
                  class91.effect,
                  class91.effectParam1,
                  class91.effectParam2,
                  class91.skipTriangles,
                  class91.shadowFactor,
                  class91.brightness,
                  class91.speedU,
                  class91.speedV,
                  class91.meshGround,
                  class91.translucent,
                  class91.unknown,
                  class91.repeatSides,
                  class91.repeatTop,
                  class91.mipmaps,
                  class91.hdr,
                  class91.brickTile,
                  class91.combinedMode
               );
               return true;
            }
         }
      }
   }

   private final native void CA(
      short var1,
      int[] var2,
      short var3,
      int var4,
      byte var5,
      byte var6,
      int var7,
      boolean var8,
      byte var9,
      byte var10,
      byte var11,
      byte var12,
      boolean var13,
      boolean var14,
      boolean var15,
      boolean var16,
      boolean var17,
      byte var18,
      boolean var19,
      boolean var20,
      int var21
   );

   @Override
   final Class270 c(int i, int i_174_, int i_175_, int i_176_, int i_177_, int i_178_) {
      return null;
   }

   @Override
   protected final synchronized void finalize() {
      this.method1233(-7751);
      if (this.nativeid != 0L) {
         Class164.method1739(0, this);
      }
   }

   @Override
   final void f(int i) {
      throw new IllegalStateException();
   }

   @Override
   final void a(int i, Node_Sub29[] node_sub29s) {
      int i_179_ = 0;

      for(int i_180_ = 0; i_180_ < i; ++i_180_) {
         anIntArray4997[i_179_++] = node_sub29s[i_180_].getReferenceX(32311);
         anIntArray4997[i_179_++] = node_sub29s[i_180_].getHeight(30);
         anIntArray4997[i_179_++] = node_sub29s[i_180_].getReferenceY(27433);
         anIntArray4997[i_179_++] = node_sub29s[i_180_].getFlickerType(126);
         aFloatArray5000[i_180_] = node_sub29s[i_180_].method2707(1);
         anIntArray4997[i_179_++] = node_sub29s[i_180_].getColor((byte)-118);
      }

      this.N(i, anIntArray4997, aFloatArray5000);
   }

   private final native void t(p var1);

   @Override
   final int b(int i, int i_181_) {
      int i_182_ = i & 1048575;
      int i_183_ = i_181_ & 1048575;
      return i_182_ & i_183_ ^ i_183_;
   }

   @Override
   final void a(Rectangle[] rectangles, int i, int i_184_, int i_185_) throws Exception_Sub1 {
      if (this.aP5009 == null) {
         throw new IllegalStateException("off");
      } else {
         this.aP5009.method2770(rectangles, i, i_184_, i_185_);
      }
   }

   @Override
   final Plane a(int i, int i_186_, int[][] is, int[][] is_187_, int i_188_, int i_189_, int i_190_) {
      return new t(this, this.aYa4998, i, i_186_, is, is_187_, i_188_, i_189_, i_190_);
   }

   @Override
   final Class336 n() {
      return this.aClass336_5006;
   }

   private final Object OA() {
      return new ba(this);
   }

   @Override
   final native void U(int var1, int var2, int var3, int var4, int var5);

   @Override
   final native int I();

   @Override
   final native void EA(int var1, int var2, int var3, int var4);

   @Override
   final native int[] na(int var1, int var2, int var3, int var4);

   @Override
   final native void K(int[] var1);

   @Override
   final void a(Class198 class198, int i) {
      this.a(class198, false);
      this.C().method145(this, anIntArray4996, anIntArray4999, anIntArray4995, aShortArray5002, class198.aClass87_2429.method1013(125));
   }

   @Override
   final native void T(int var1, int var2, int var3, int var4);

   @Override
   final void a(Class336 class336) {
      this.aClass336_5006 = class336;
      this.ma(((ja)class336).nativeid);
   }

   @Override
   final void a(Class198 class198) {
      if (class198.aClass87_2429.method1013(119) != 0) {
         this.a(class198, false);
         this.C().method145(this, anIntArray4996, anIntArray4999, anIntArray4995, aShortArray5002, class198.aClass87_2429.method1013(124));
      }
   }

   @Override
   final native void P(int var1, int var2, int var3, int var4, int var5);

   @Override
   final GLSprite a(Class383 class383, boolean bool) {
      j var_j = new j(
         this, class383.anIntArray4904, class383.aByteArray4903, class383.aByteArray4905, 0, class383.anInt4897, class383.anInt4897, class383.anInt4900
      );
      var_j.method1178(class383.anInt4902, class383.anInt4898, class383.anInt4901, class383.anInt4899);
      return var_j;
   }

   private final void g() {
      System.gc();
      System.runFinalization();
      Class164.method1740(-9630);
   }

   @Override
   final void f() {
   }

   @Override
   final void e(int i, int i_208_) throws Exception_Sub1 {
      if (this.aP5009 == null) {
         throw new IllegalStateException("off");
      } else {
         this.aP5009.method2767(i, i_208_);
      }
   }

   private final native void N(int var1, int[] var2, float[] var3);

   @Override
   final boolean b() {
      return true;
   }

   private final native void Z(int var1, int var2, int var3, int var4, int var5, int var6, aa var7, int var8, int var9);

   @Override
   final void a(float f, float f_216_, float f_217_) {
   }

   @Override
   final void u() {
      if (!this.aBoolean4992) {
         this.anAArray5011 = null;
         this.aP5009 = null;
         this.aYa4998 = null;
         this.aClass336_5004 = null;
         this.aHashTable5007.method1517(false);

         for(ya var_ya = (ya)this.aClass312_4991.method3613(65280); var_ya != null; var_ya = (ya)this.aClass312_4991.method3620(16776960)) {
            var_ya.ga();
         }

         this.aClass312_4991.method3614(-601);
         this.FA();
         if (this.aBoolean5012) {
            Class160.method1727(false, (byte)104, true);
            this.aBoolean5012 = false;
         }

         this.g();
         Class164.method1743(-1);
         this.aBoolean4992 = true;
      }
   }

   @Override
   final boolean r() {
      return true;
   }

   @Override
   final Interface20 d(int i, int i_218_) {
      return new xa(i, i_218_);
   }

   @Override
   final native void la();

   private final native void va(za var1);

   @Override
   final native void C(boolean var1);

   @Override
   final native void aa(int var1, int var2, int var3, int var4, int var5, int var6);

   @Override
   final boolean B() {
      return true;
   }

   @Override
   final Interface6 a(Interface4 interface4, Interface20 interface20) {
      return new wa(this, (j)interface4, (xa)interface20);
   }

   @Override
   final Class336 A() {
      return this.aClass336_5004;
   }

   @Override
   final native int XA();

   @Override
   final native void A(int var1, aa var2, int var3, int var4);

   @Override
   final native void GA(int var1);

   @Override
   final void a(boolean bool) {
   }
}
