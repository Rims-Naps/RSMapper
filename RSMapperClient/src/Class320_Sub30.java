public class Class320_Sub30 extends Class320 {
   static int anInt8492;
   static int anInt8493;
   static int anInt8494;
   static int anInt8495;
   static int anInt8496;
   static int anInt8497;
   static int anInt8498;
   static int anInt8499;

   Class320_Sub30(Node_Sub27 node_sub27) {
      super(node_sub27);
   }

   final boolean method3795(byte b) {
      ++anInt8494;
      if (b < 63) {
         anInt8495 = 20;
      }

      if (this.aNode_Sub27_4063.method2691(3) == Node_Sub38_Sub34.aClass353_10443) {
         return !this.aNode_Sub27_4063.method2697(-71);
      } else {
         return false;
      }
   }

   @Override
   final void method3673(byte b) {
      if (b >= -35) {
         this.method3796(true);
      }

      if (this.aNode_Sub27_4063.method2691(3) != Node_Sub38_Sub34.aClass353_10443) {
         this.anInt4064 = 1;
      } else if (this.aNode_Sub27_4063.method2697(-91)) {
         this.anInt4064 = 0;
      }

      ++anInt8498;
      if (~this.anInt4064 != -1 && ~this.anInt4064 != -2) {
         this.anInt4064 = this.method3677(0);
      }
   }

   final int method3796(boolean bool) {
      ++anInt8492;
      if (bool) {
         anInt8495 = -119;
      }

      return this.anInt4064;
   }

   Class320_Sub30(int i, Node_Sub27 node_sub27) {
      super(i, node_sub27);
   }

   static final boolean method3797(r var_r, int i, int i_0_, int i_1_, boolean[] bools) {
      boolean bool = false;
      if (Class320_Sub10.aPlaneArray8300 != Class368.aPlaneArray4548) {
         int i_2_ = Node_Sub38_Sub37.aPlaneArray10466[i].getMedianHeightFromVertices(i_1_, -114, i_0_);

         for(int i_3_ = 0; i_3_ <= i; ++i_3_) {
            Plane plane = Node_Sub38_Sub37.aPlaneArray10466[i_3_];
            if (plane != null) {
               int i_4_ = i_2_ - plane.getMedianHeightFromVertices(i_1_, -109, i_0_);
               if (bools != null) {
                  bools[i_3_] = plane.method3256(var_r, i_0_, i_4_, i_1_, 0, false);
                  if (!bools[i_3_]) {
                     continue;
                  }
               }

               plane.CA(var_r, i_0_, i_4_, i_1_, 0, false);
               bool = true;
            }
         }
      }

      return bool;
   }

   static final void method3798(int i) {
      ++anInt8493;
      if (~Class213.aNode_Sub27_2512.aClass320_Sub19_7301.method3751(false) == -1 && ~Class94.anInt1249 != ~CacheNode_Sub20_Sub1.myPlayerPlane) {
         Class364.method4057(false, Player.regionX, 12, Class277.regionY, (byte)-36);
      } else {
         Class56.method563(i ^ 11922, Class93.aGraphicsToolkit1241);
         if (Node_Sub36_Sub3.anInt10061 != CacheNode_Sub20_Sub1.myPlayerPlane) {
            Class46.method471(-1);
         }

         if (i != -17132) {
            method3797(null, 12, -7, 99, null);
         }
      }
   }

   @Override
   final void method3676(boolean bool, int i) {
      ++anInt8499;
      this.anInt4064 = i;
      if (bool) {
         this.method3795((byte)103);
      }
   }

   @Override
   final int method3675(int i, byte b) {
      ++anInt8496;
      if (this.aNode_Sub27_4063.method2691(b ^ 53) == Node_Sub38_Sub34.aClass353_10443) {
         if (this.aNode_Sub27_4063.method2697(-72)) {
            return 3;
         } else {
            return i != 0 && this.aNode_Sub27_4063.aClass320_Sub23_7290.method3770(false) != 1 ? 2 : 1;
         }
      } else {
         if (b != 54) {
            this.method3677(-103);
         }

         return 3;
      }
   }

   @Override
   final int method3677(int i) {
      ++anInt8497;
      return i != 0 ? 34 : 1;
   }
}
