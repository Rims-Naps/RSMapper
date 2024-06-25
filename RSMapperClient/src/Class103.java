public class Class103 {
   private EntityNode anEntityNode1335 = new EntityNode();
   static int anInt1336;
   static int anInt1337;
   static int anInt1338;
   static int anInt1339;
   static int anInt1340;
   private EntityNode anEntityNode1341;
   static int anInt1342;
   static int anInt1343;
   static int anInt1344;
   static int anInt1345;

   final boolean method1105(int i) {
      if (i > -89) {
         this.method1108(57);
      }

      ++anInt1344;
      return this.anEntityNode1335 == this.anEntityNode1335.anEntityNode1126;
   }

   final EntityNode method1106(int i) {
      ++anInt1345;
      if (i <= 26) {
         this.anEntityNode1341 = null;
      }

      EntityNode entitynode = this.anEntityNode1335.anEntityNode1126;
      if (entitynode == this.anEntityNode1335) {
         return null;
      } else {
         entitynode.method803(false);
         return entitynode;
      }
   }

   final int method1107(int i) {
      ++anInt1337;
      int i_0_ = 0;
      EntityNode entitynode = this.anEntityNode1335.anEntityNode1126;
      if (i != -1) {
         return -128;
      } else {
         while(this.anEntityNode1335 != entitynode) {
            ++i_0_;
            entitynode = entitynode.anEntityNode1126;
         }

         return i_0_;
      }
   }

   public Class103() {
      this.anEntityNode1335.anEntityNode1124 = this.anEntityNode1335;
      this.anEntityNode1335.anEntityNode1126 = this.anEntityNode1335;
   }

   final EntityNode method1108(int i) {
      ++anInt1338;
      EntityNode entitynode = this.anEntityNode1341;
      if (this.anEntityNode1335 == entitynode) {
         this.anEntityNode1341 = null;
         return null;
      } else {
         this.anEntityNode1341 = entitynode.anEntityNode1126;
         if (i <= 56) {
            this.anEntityNode1341 = null;
         }

         return entitynode;
      }
   }

   static final void method1109(boolean bool, int i) {
      Class327.anInt5360 = i;
      Class150_Sub3.anInt8963 = -1;
      ++anInt1340;
      if (bool) {
         method1109(true, -44);
      }

      Class150_Sub3.anInt8963 = -1;
      Class207.method2039(81);
   }

   final void method1110(boolean bool, EntityNode entitynode) {
      if (entitynode.anEntityNode1124 != null) {
         entitynode.method803(bool);
      }

      ++anInt1342;
      entitynode.anEntityNode1124 = this.anEntityNode1335.anEntityNode1124;
      entitynode.anEntityNode1126 = this.anEntityNode1335;
      entitynode.anEntityNode1124.anEntityNode1126 = entitynode;
      entitynode.anEntityNode1126.anEntityNode1124 = entitynode;
      if (bool) {
         this.anEntityNode1341 = null;
      }
   }

   final EntityNode method1111(int i) {
      ++anInt1339;
      EntityNode entitynode = this.anEntityNode1335.anEntityNode1124;
      if (entitynode == this.anEntityNode1335) {
         this.anEntityNode1341 = null;
         return null;
      } else {
         this.anEntityNode1341 = entitynode.anEntityNode1124;
         return entitynode;
      }
   }

   final void method1112(byte b) {
      if (b > -112) {
         this.anEntityNode1341 = null;
      }

      while(true) {
         EntityNode entitynode = this.anEntityNode1335.anEntityNode1126;
         if (entitynode == this.anEntityNode1335) {
            ++anInt1336;
            this.anEntityNode1341 = null;
            return;
         }

         entitynode.method803(false);
      }
   }

   final EntityNode method1113(byte b) {
      ++anInt1343;
      EntityNode entitynode = this.anEntityNode1335.anEntityNode1126;
      if (entitynode == this.anEntityNode1335) {
         this.anEntityNode1341 = null;
         return null;
      } else {
         this.anEntityNode1341 = entitynode.anEntityNode1126;
         return entitynode;
      }
   }
}
