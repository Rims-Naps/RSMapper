public class Class40 {
   static int anInt618;
   static int anInt619;
   static int anInt620;
   static GLSprite aGLSprite621;

   public static void method431(int i) {
      aGLSprite621 = null;
      if (i <= 70) {
         method431(-113);
      }
   }

   static final void playMusic(int volume, int junk, int musicId, int i_2_) {
      ++anInt619;
      int var5 = -1;
      int var4 = 0;
      if (var5 == -1 && !Class377_Sub1.aBoolean8775) {
         Class320_Sub2.method3685(-118);
      } else if (~var5 != 0 && (~Class313.anInt4013 != ~var5 || !Class36.method390(-122)) && ~var4 != -1 && !Class377_Sub1.aBoolean8775) {
         CacheNode_Sub14_Sub2.method2354(SeekableFile.index6, var4, false, 0, var5, i_2_, false);
         EntityNode_Sub7.method979(17285);
      }

      if (~Class313.anInt4013 != ~var5) {
         EntityNode_Sub1.aNode_Sub9_Sub1_5929 = null;
      }

      if (junk <= 112) {
         playMusic(-89, 11, 106, 125);
      }

      Class313.anInt4013 = var5;
   }
}
