public class CacheNode_Sub13 extends CacheNode {
   protected String aString9558;
   static int anInt9559;
   protected String aString9560;
   protected int lastClickY;
   protected int anInt9562;
   protected long lastClickedIndex;
   protected long aLong9564;
   protected String aString9565;
   static int anInt9566;
   protected boolean aBoolean9567;
   protected int lastClickX;
   protected int anInt9569;
   protected int cursorSprite;
   protected boolean aBoolean9571;
   protected boolean aBoolean9572;

   static final int method2344(int i, int i_0_, int i_1_, int i_2_, int i_3_) {
      ++anInt9559;
      int i_4_ = i_0_ & 15;
      if (i_2_ <= 2) {
         return 92;
      } else {
         int i_5_ = ~i_4_ <= -9 ? i_3_ : i_1_;
         int i_6_ = ~i_4_ > -5 ? i_3_ : (~i_4_ != -13 && ~i_4_ != -15 ? i : i_1_);
         return ((i_4_ & 1) != 0 ? -i_5_ : i_5_) - -((2 & i_4_) != 0 ? -i_6_ : i_6_);
      }
   }

   static final void method2345(int i, int i_7_, boolean bool) {
      if (i_7_ > -84) {
         method2344(-36, -111, 123, -85, -62);
      }

      ++anInt9566;
      CacheNode_Sub2 cachenode_sub2 = Class320_Sub19.method3754(3, 21, (long)i);
      cachenode_sub2.method2288(0);
      cachenode_sub2.anInt9434 = !bool ? 0 : 1;
   }

   CacheNode_Sub13(
      String baseOption,
      String option,
      int cursorSprite,
      int opcode,
      int i_10_,
      long l,
      int lastClickX,
      int lastClickY,
      boolean bool,
      boolean bool_13_,
      long l_14_,
      boolean bool_15_
   ) {
      this.lastClickedIndex = l;
      this.aBoolean9571 = bool;
      this.cursorSprite = cursorSprite;
      this.anInt9569 = i_10_;
      this.lastClickY = lastClickY;
      this.anInt9562 = opcode;
      this.aString9560 = baseOption;
      this.aLong9564 = l_14_;
      this.aString9558 = option;
      this.lastClickX = lastClickX;
      this.aBoolean9572 = bool_13_;
      this.aBoolean9567 = bool_15_;
   }
}
