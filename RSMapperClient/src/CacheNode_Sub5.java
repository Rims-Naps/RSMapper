public class CacheNode_Sub5 extends CacheNode {
   static int anInt9467;
   protected int anInt9468;
   static int anInt9469;
   protected int anInt9470;
   protected int anInt9471;
   protected int anInt9472;
   protected Class249 aClass249_9473;
   static int anInt9474;
   protected int anInt9475;
   protected Class218 aClass218_9476;
   static Index index27;

   static final boolean method2307(int i, int i_0_, int i_1_) {
      ++anInt9469;
      if (~(i_0_ & i_1_) != -1 | Class73.method749((byte)-65, i_1_, i) || PacketParser.method2248(i_1_, i, 51)) {
         return true;
      } else {
         return (55 & i) == 0 && Class110.method1135(i_1_, i, false);
      }
   }

   static final Class169_Sub2_Sub1 method2308(GLToolkit gltoolkit, int i, int i_2_, boolean bool, int i_3_, int[] is, int i_4_, int i_5_) {
      ++anInt9474;
      if (i != 25448) {
         return null;
      } else if (!gltoolkit.aBoolean6652 && (!Class371.method4094(i_2_, false) || !Class371.method4094(i_4_, false))) {
         return gltoolkit.aBoolean6649
            ? new Class169_Sub2_Sub1(gltoolkit, 34037, i_2_, i_4_, bool, is, i_3_, i_5_)
            : new Class169_Sub2_Sub1(gltoolkit, i_2_, i_4_, Class320_Sub19.method3753(i_2_), Class320_Sub19.method3753(i_4_), is);
      } else {
         return new Class169_Sub2_Sub1(gltoolkit, 3553, i_2_, i_4_, bool, is, i_3_, i_5_);
      }
   }

   final void method2309(byte b) {
      this.anInt9475 = this.aClass218_9476.anInt2559;
      this.anInt9471 = this.aClass218_9476.anInt2557;
      this.anInt9468 = this.aClass218_9476.anInt2556;
      ++anInt9467;
      if (this.aClass218_9476.aClass336_2562 != null) {
         this.aClass218_9476
            .aClass336_2562
            .method3867(this.aClass249_9473.anInt3157, this.aClass249_9473.anInt3166, this.aClass249_9473.anInt3150, Node_Sub38.anIntArray7457);
      }

      if (b >= 85) {
         this.anInt9470 = Node_Sub38.anIntArray7457[2];
         this.anInt9472 = Node_Sub38.anIntArray7457[0];
      }
   }

   public static void method2310(boolean bool) {
      index27 = null;
      if (!bool) {
         method2310(false);
      }
   }

   CacheNode_Sub5(Class218 class218, EntityNode_Sub4 entitynode_sub4) {
      this.aClass218_9476 = class218;
      this.aClass249_9473 = this.aClass218_9476.method2075((byte)-57);
      this.method2309((byte)92);
   }
}
