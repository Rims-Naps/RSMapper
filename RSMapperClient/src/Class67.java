public class Class67 {
   static int anInt928;
   static int anInt929;
   static Class77 aClass77_930 = new Class77();
   static int anInt931;

   static final String method730(boolean bool, String string) {
      ++anInt928;
      int i = string.length();
      int i_0_ = 0;

      for(int i_1_ = 0; ~i < ~i_1_; ++i_1_) {
         char c = string.charAt(i_1_);
         if (c == '<' || c == '>') {
            i_0_ += 3;
         }
      }

      StringBuffer stringbuffer = new StringBuffer(i - -i_0_);

      for(int i_2_ = 0; i > i_2_; ++i_2_) {
         char c = string.charAt(i_2_);
         if (c != '<') {
            if (~c != -63) {
               stringbuffer.append(c);
            } else {
               stringbuffer.append("<gt>");
            }
         } else {
            stringbuffer.append("<lt>");
         }
      }

      if (bool) {
         aClass77_930 = null;
      }

      return stringbuffer.toString();
   }

   static final String method731(byte b) {
      ++anInt929;
      if (Class213.rightClickDialogueIsOpen || Node_Sub38_Sub23.aCacheNode_Sub13_10343 == null) {
         return "";
      } else if (b != 115) {
         return null;
      } else {
         return (Node_Sub38_Sub23.aCacheNode_Sub13_10343.aString9558 == null || ~Node_Sub38_Sub23.aCacheNode_Sub13_10343.aString9558.length() == -1)
               && Node_Sub38_Sub23.aCacheNode_Sub13_10343.aString9565 != null
               && ~Node_Sub38_Sub23.aCacheNode_Sub13_10343.aString9565.length() < -1
            ? Node_Sub38_Sub23.aCacheNode_Sub13_10343.aString9565
            : Node_Sub38_Sub23.aCacheNode_Sub13_10343.aString9558;
      }
   }

   public static void method732(byte b) {
      if (b >= 78) {
         aClass77_930 = null;
      }
   }

   static final int method733(int i) {
      ++anInt931;
      if (i >= -73) {
         aClass77_930 = null;
      }

      return Class320_Sub20.anInt8397 == 1 ? Node_Sub38_Sub1.anInt10075 : 0;
   }
}
