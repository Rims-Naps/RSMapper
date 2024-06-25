public class Node_Sub3 extends Node {
   static int anInt6938;
   static int anInt6939;
   static int anInt6940;
   protected int anInt6941;
   protected boolean aBoolean6942;
   protected Class189_Sub1 aClass189_Sub1_6943;
   static int anInt6944;
   protected boolean aBoolean6945;
   protected boolean aBoolean6946;
   protected int anInt6947;
   static boolean aBoolean6948 = false;
   protected boolean aBoolean6949;

   static final IComponentDefinitions method2169(int i, int componentId, int interfaceId) {
      ++anInt6940;
      if (i != -101) {
         method2171(-24, 50, (byte)32, null, 92, -119, -58);
      }

      IComponentDefinitions widget = Class76.getInterfaceFromHash((byte)107, interfaceId);
      if (~componentId == 0) {
         return widget;
      } else {
         return widget != null && widget.aWidgetArray4804 != null && ~componentId > ~widget.aWidgetArray4804.length
            ? widget.aWidgetArray4804[componentId]
            : null;
      }
   }

   static final void method2170(int i, long[] ls, int[] is) {
      Class125.method1530((byte)-114, -1 + ls.length, is, ls, 0);
      ++anInt6938;
      int i_2_ = -117 / ((64 - i) / 43);
   }

   Node_Sub3(int i, Class189_Sub1 class189_sub1, int i_3_, boolean bool) {
      this.aBoolean6945 = bool;
      this.anInt6947 = i;
      this.aClass189_Sub1_6943 = class189_sub1;
      this.anInt6941 = i_3_;
   }

   static final boolean method2171(int i, int i_4_, byte b, Class171 class171, int i_5_, int i_6_, int i_7_) {
      ++anInt6939;
      if (Class12.aBoolean194 && Mobile_Sub1.aBoolean10959) {
         if (b >= -124) {
            method2171(-69, -122, (byte)-82, null, -41, 6, 98);
         }

         if (~Class233.anInt2786 > -101) {
            return false;
         } else if (i_6_ == i_4_ && ~i_5_ == ~i) {
            if (!Class313.method3649(true, i, i_7_, i_6_)) {
               return false;
            } else if (Animable_Sub2.method835(class171, (byte)93)) {
               ++Class187.anInt2267;
               return true;
            } else {
               return false;
            }
         } else {
            for(int i_8_ = i_6_; i_8_ <= i_4_; ++i_8_) {
               for(int i_9_ = i; ~i_5_ <= ~i_9_; ++i_9_) {
                  if (Class240.anIntArrayArrayArray2948[i_7_][i_8_][i_9_] == -Class359.anInt4465) {
                     return false;
                  }
               }
            }

            if (!Animable_Sub2.method835(class171, (byte)94)) {
               return false;
            } else {
               ++Class187.anInt2267;
               return true;
            }
         }
      } else {
         return false;
      }
   }

   static final String method2172(byte b, Buffer buffer) {
      ++anInt6944;
      return b != -72 ? null : Class207.method2040(buffer, 32767, -24709);
   }
}
