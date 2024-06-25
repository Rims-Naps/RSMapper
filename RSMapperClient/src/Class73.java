public class Class73 {
   private Class301 aClass301_980;
   static byte[] movementTypes = new byte[2048];
   private Class339[] aClass339Array982;
   static int anInt983;
   private GLToolkit aGLToolkit984;
   static int anInt985;
   protected Class339_Sub6 aClass339_Sub6_986;
   private int anInt987 = 0;
   static CacheNode_Sub4 aCacheNode_Sub4_988 = null;
   private int anInt989 = 0;
   static int anInt990;
   private int anInt991 = 0;
   static int anInt992;

   final boolean method748(int i, byte b) {
      if (b < 21) {
         return true;
      } else {
         ++anInt990;
         return this.aClass339Array982[i].method3922((byte)-73);
      }
   }

   static final boolean method749(byte b, int i, int i_0_) {
      if (b != -65) {
         method749((byte)11, -103, -77);
      }

      ++anInt983;
      return (i & 24) != 0 | (i & 544) == 544;
   }

   final boolean method750(byte b, int i, Class169 class169) {
      if (b <= 97) {
         return false;
      } else {
         ++anInt992;
         if (this.anInt987 == 0) {
            return false;
         } else {
            this.aClass339Array982[2147483647 & this.anInt987].method3917(class169, i, -28289);
            return true;
         }
      }
   }

   final void method751(int i, int i_1_, boolean bool, boolean bool_2_, int i_3_, int i_4_) {
      ++anInt985;
      bool &= this.aGLToolkit984.z();
      if (i >= -72) {
         this.aClass301_980 = null;
      }

      if (!bool && (~i_4_ == -5 || i_4_ == 8 || ~i_4_ == -10)) {
         if (i_4_ == 4) {
            i_1_ = i_3_;
         }

         i_4_ = 2;
      }

      if (i_4_ != 0 && bool_2_) {
         i_4_ |= Integer.MIN_VALUE;
      }

      if (~i_4_ == ~this.anInt987) {
         if (~this.anInt987 != -1) {
            this.aClass339Array982[this.anInt987 & 2147483647].method3920(-1, bool_2_);
            if (this.anInt991 != i_3_ || ~this.anInt989 != ~i_1_) {
               this.aClass339Array982[this.anInt987 & 2147483647].method3919(-13437, i_1_, i_3_);
               this.anInt989 = i_1_;
               this.anInt991 = i_3_;
            }
         }
      } else {
         if (this.anInt987 != 0) {
            this.aClass339Array982[this.anInt987 & 2147483647].method3918(20937);
         }

         if (i_4_ != 0) {
            this.aClass339Array982[2147483647 & i_4_].method3923(bool_2_, 0);
            this.aClass339Array982[i_4_ & 2147483647].method3920(-1, bool_2_);
            this.aClass339Array982[i_4_ & 2147483647].method3919(-13437, i_1_, i_3_);
         }

         this.anInt989 = i_1_;
         this.anInt991 = i_3_;
         this.anInt987 = i_4_;
      }
   }

   public static void method752(int i) {
      aCacheNode_Sub4_988 = null;
      movementTypes = null;
      if (i < 116) {
         method752(-94);
      }
   }

   Class73(GLToolkit gltoolkit) {
      this.aGLToolkit984 = gltoolkit;
      this.aClass301_980 = new Class301(gltoolkit);
      this.aClass339Array982 = new Class339[10];
      this.aClass339Array982[1] = new Class339_Sub1(gltoolkit);
      this.aClass339Array982[2] = new Class339_Sub9(gltoolkit, this.aClass301_980);
      this.aClass339Array982[4] = new Class339_Sub2(gltoolkit, this.aClass301_980);
      this.aClass339Array982[5] = new Class339_Sub5(gltoolkit, this.aClass301_980);
      this.aClass339Array982[6] = new Class339_Sub8(gltoolkit);
      this.aClass339Array982[7] = new Class339_Sub3(gltoolkit);
      this.aClass339Array982[3] = this.aClass339_Sub6_986 = new Class339_Sub6(gltoolkit);
      this.aClass339Array982[8] = new Class339_Sub4(gltoolkit, this.aClass301_980);
      this.aClass339Array982[9] = new Class339_Sub7(gltoolkit, this.aClass301_980);
      if (!this.aClass339Array982[8].method3922((byte)-71)) {
         this.aClass339Array982[8] = this.aClass339Array982[4];
      }

      if (!this.aClass339Array982[9].method3922((byte)-60)) {
         this.aClass339Array982[9] = this.aClass339Array982[8];
      }
   }
}
