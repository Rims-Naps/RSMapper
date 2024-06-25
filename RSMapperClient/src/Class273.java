public class Class273 {
   private Class103 aClass103_3486 = new Class103();
   static int anInt3487;
   static int anInt3488;
   static int anInt3489;
   static Index index33;
   static int anInt3491;
   protected String aString3492;
   static int anInt3493;
   static int anInt3494;
   private volatile int anInt3495;
   static int anInt3496;
   private Class33 aClass33_3497;

   final void method3314(EntityNode_Sub8 entitynode_sub8, byte b) {
      synchronized(this.aClass103_3486) {
         this.aClass103_3486.method1110(false, entitynode_sub8);
         ++this.anInt3495;
      }

      ++anInt3487;
      if (this.aClass33_3497 != null) {
         synchronized(this.aClass33_3497) {
            this.aClass33_3497.notify();
         }
      }

      if (b != 51) {
         this.aString3492 = null;
      }
   }

   static final int method3315(int i, int i_0_) {
      ++anInt3493;
      return i != -989325398 ? 115 : i_0_ >>> 10;
   }

   final EntityNode method3316(boolean bool) {
      ++anInt3496;
      Object object = null;
      if (!bool) {
         return null;
      } else {
         synchronized(this.aClass103_3486) {
            EntityNode entitynode = this.aClass103_3486.method1113((byte)107);
            entitynode.method803(false);
            --this.anInt3495;
            return entitynode;
         }
      }
   }

   public static void method3317(int i) {
      if (i == 0) {
         index33 = null;
      }
   }

   final void method3318(Animable animable, byte b) {
      if (b != -36) {
         this.method3321(null, 121);
      }

      animable.aBoolean5935 = true;
      ++anInt3491;
      synchronized(this.aClass103_3486) {
         this.aClass103_3486.method1110(false, animable);
         ++this.anInt3495;
      }

      if (this.aClass33_3497 != null) {
         synchronized(this.aClass33_3497) {
            this.aClass33_3497.notify();
         }
      }
   }

   final boolean method3319(int i) {
      ++anInt3494;
      if (i != -10968) {
         this.aString3492 = null;
      }

      return this.anInt3495 == 0;
   }

   final void method3320(boolean bool, Class33 class33) {
      ++anInt3488;
      if (bool) {
         method3315(31, -98);
      }

      this.aClass33_3497 = class33;
   }

   final void method3321(Animable animable, int i) {
      animable.aBoolean5935 = false;
      ++anInt3489;
      synchronized(this.aClass103_3486) {
         this.aClass103_3486.method1110(false, animable);
         if (i <= 22) {
            method3317(-74);
         }

         ++this.anInt3495;
      }

      if (this.aClass33_3497 != null) {
         synchronized(this.aClass33_3497) {
            this.aClass33_3497.notify();
         }
      }
   }

   Class273(String string) {
      this.aString3492 = string;
   }
}
