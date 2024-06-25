public class Class316 {
   static int anInt4036;
   static int anInt4037;

   static final boolean method3661(int i, int i_0_, byte b) {
      ++anInt4037;
      if (b != 69) {
         return false;
      } else {
         return (i & 384) != 0;
      }
   }

   static final boolean method3662(boolean bool, char c) {
      ++anInt4036;
      if (bool) {
         method3662(true, '%');
      }

      return ~c <= -49 && ~c >= -58 || c >= 'A' && ~c >= -91 || c >= 'a' && c <= 'z';
   }
}
