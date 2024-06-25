public class Class77 {
   static int anInt1016;
   static int anInt1017 = 1401;
   static long aLong1018;
   static int anInt1019;
   static int anInt1020;
   static int anInt1021;

   static final char method772(byte b, char c) {
      ++anInt1019;
      int i = -50 % ((-5 - b) / 54);
      if (~c == -33 || ~c == -161 || c == '_' || c == '-') {
         return '_';
      } else if (~c == -92 || ~c == -94 || c == '#') {
         return c;
      } else if (c == 224 || c == 225 || ~c == -227 || ~c == -229 || c == 227 || ~c == -193 || ~c == -194 || c == 194 || ~c == -197 || ~c == -196) {
         return 'a';
      } else if (c == 232 || c == 233 || c == 234 || ~c == -236 || ~c == -201 || c == 201 || c == 202 || c == 203) {
         return 'e';
      } else if (c == 237 || ~c == -239 || ~c == -240 || ~c == -206 || c == 206 || c == 207) {
         return 'i';
      } else if (c == 242 || ~c == -244 || ~c == -245 || c == 246 || ~c == -246 || c == 210 || ~c == -212 || c == 212 || c == 214 || ~c == -214) {
         return 'o';
      } else if (c == 249 || ~c == -251 || ~c == -252 || ~c == -253 || ~c == -218 || ~c == -219 || c == 219 || c == 220) {
         return 'u';
      } else if (~c == -232 || ~c == -200) {
         return 'c';
      } else if (~c == -256 || c == 376) {
         return 'y';
      } else if (c == 241 || c == 209) {
         return 'n';
      } else {
         return c == 223 ? 'b' : Character.toLowerCase(c);
      }
   }

   static final int[] method772(int i, byte b) {
      if (b < 10) {
         method773(10, i);
      }

      switch(i) {
         case 0:
            return new int[]{5098, 22};
         case 1:
            return new int[]{8361, 24};
         case 2:
            return new int[]{4226, 22};
         case 3:
            return new int[]{9213, 23};
         case 4:
            return new int[]{2602, 21};
         case 5:
            return new int[]{4201, 16};
         case 6:
            return new int[]{1659, 15};
         default:
            return null;
      }
   }

   static final String method773(int i, int i_1_) {
      if (i != 225) {
         return null;
      } else {
         ++anInt1020;
         Node_Sub3 node_sub3 = (Node_Sub3)Class56.aHashTable839.get(3512, (long)i_1_);
         if (node_sub3 != null) {
            Node_Sub25_Sub4 node_sub25_sub4 = node_sub3.aClass189_Sub1_6943.method1921(3455);
            if (node_sub25_sub4 != null) {
               double d = node_sub3.aClass189_Sub1_6943.method1928(i + -109);
               if ((double)node_sub25_sub4.method2678(i + 12967) <= d && d <= (double)node_sub25_sub4.method2683(-75)) {
                  return node_sub25_sub4.method2682(110);
               }
            }
         }

         return null;
      }
   }

   public static void method774(int i) {
      if (i != 194) {
         anInt1017 = -45;
      }
   }

   final int method775(int i, boolean bool, int i_2_) {
      if (bool) {
         this.method775(-98, false, 36);
      }

      ++anInt1016;
      int i_3_ = ~Class205.canvasHeight < ~i ? Class205.canvasHeight : i;
      if (Animable_Sub4_Sub2.aClass77_10805 == this) {
         return 0;
      } else if (Class260.aClass77_5225 == this) {
         return i_3_ + -i_2_;
      } else {
         return Class67.aClass77_930 == this ? (-i_2_ + i_3_) / 2 : 0;
      }
   }

   @Override
   public final String toString() {
      ++anInt1021;
      throw new IllegalStateException();
   }
}
