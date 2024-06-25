public class Class146 {
   static int anInt1800;
   private Class312 aClass312_1801;
   static short[][] aShortArrayArray1802;
   private int anInt1803 = -1;
   private int anInt1804 = 0;
   static int anInt1805;
   static int anInt1806;
   private int anInt1807;
   private Node_Sub50[] aNode_Sub50Array1808;
   private int[][] anIntArrayArray1809;
   static IncommingPacket aClass192_1810 = new IncommingPacket(143, -2);
   private int anInt1811;
   static Class32 aClass32_1812;
   static SignLink aSignLink1813;
   static boolean aBoolean1814;
   static Class10 aClass10_1815;
   static boolean aBoolean1816 = false;
   static int anInt1817;
   static int anInt1818;
   protected boolean aBoolean1819;

   final int[][] method1642(byte b) {
      int i = 70 % ((b - 38) / 38);
      ++anInt1818;
      if (~this.anInt1811 != ~this.anInt1807) {
         throw new RuntimeException("Can only retrieve a full image cache");
      } else {
         for(int i_0_ = 0; ~i_0_ > ~this.anInt1811; ++i_0_) {
            this.aNode_Sub50Array1808[i_0_] = Class218.aNode_Sub50_2568;
         }

         return this.anIntArrayArray1809;
      }
   }

   public static void method1643(boolean bool) {
      aShortArrayArray1802 = null;
      aClass32_1812 = null;
      if (!bool) {
         aClass10_1815 = null;
         aSignLink1813 = null;
         aClass192_1810 = null;
      }
   }

   final void method1644(int i) {
      for(int i_1_ = 0; this.anInt1811 > i_1_; ++i_1_) {
         this.anIntArrayArray1809[i_1_] = null;
      }

      ++anInt1806;
      if (i > -113) {
         this.method1642((byte)-112);
      }

      this.aNode_Sub50Array1808 = null;
      this.anIntArrayArray1809 = null;
      this.aClass312_1801.method3614(-601);
      this.aClass312_1801 = null;
   }

   final int[] method1645(int i, int i_2_) {
      if (i != 27356) {
         method1643(false);
      }

      ++anInt1800;
      if (~this.anInt1811 != ~this.anInt1807) {
         if (~this.anInt1811 != -2) {
            Node_Sub50 node_sub50 = this.aNode_Sub50Array1808[i_2_];
            if (node_sub50 != null) {
               this.aBoolean1819 = false;
            } else {
               this.aBoolean1819 = true;
               if (this.anInt1804 >= this.anInt1811) {
                  Node_Sub50 node_sub50_3_ = (Node_Sub50)this.aClass312_1801.method3622((byte)-60);
                  node_sub50 = new Node_Sub50(i_2_, node_sub50_3_.anInt7626);
                  this.aNode_Sub50Array1808[node_sub50_3_.anInt7624] = null;
                  node_sub50_3_.method2160((byte)75);
               } else {
                  node_sub50 = new Node_Sub50(i_2_, this.anInt1804);
                  ++this.anInt1804;
               }

               this.aNode_Sub50Array1808[i_2_] = node_sub50;
            }

            this.aClass312_1801.method3611(node_sub50, i ^ -27302);
            return this.anIntArrayArray1809[node_sub50.anInt7626];
         } else {
            this.aBoolean1819 = ~this.anInt1803 != ~i_2_;
            this.anInt1803 = i_2_;
            return this.anIntArrayArray1809[0];
         }
      } else {
         this.aBoolean1819 = this.aNode_Sub50Array1808[i_2_] == null;
         this.aNode_Sub50Array1808[i_2_] = Class218.aNode_Sub50_2568;
         return this.anIntArrayArray1809[i_2_];
      }
   }

   static final float method1646(byte b, float f) {
      ++anInt1805;
      if (b > -88) {
         method1646((byte)56, 0.12968303F);
      }

      return ((6.0F * f - 15.0F) * f + 10.0F) * f * f * f;
   }

   Class146(int i, int i_4_, int i_5_) {
      this.aClass312_1801 = new Class312();
      this.aBoolean1819 = false;
      this.anInt1811 = i;
      this.anInt1807 = i_4_;
      this.aNode_Sub50Array1808 = new Node_Sub50[this.anInt1807];
      this.anIntArrayArray1809 = new int[this.anInt1811][i_5_];
   }
}
