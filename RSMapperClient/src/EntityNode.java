class EntityNode {
   protected EntityNode anEntityNode1124;
   static int anInt1125;
   protected EntityNode anEntityNode1126;
   static int anInt1127;
   static boolean aBoolean1128 = true;

   static final void method802(int i) {
      ++anInt1125;
      if (Class240.aSignLink2946.aBoolean4005 && ~Class262_Sub23.aClass197_7884.id != 0) {
         Class188_Sub1_Sub2.method1899(Class262_Sub23.aClass197_7884.id, (byte)27, Class262_Sub23.aClass197_7884.ipadress);
      }

      if (i != 2126) {
         method802(-121);
      }
   }

   final void method803(boolean bool) {
      ++anInt1127;
      if (this.anEntityNode1124 != null && !bool) {
         this.anEntityNode1124.anEntityNode1126 = this.anEntityNode1126;
         this.anEntityNode1126.anEntityNode1124 = this.anEntityNode1124;
         this.anEntityNode1126 = null;
         this.anEntityNode1124 = null;
      }
   }

   public EntityNode() {
   }
}
