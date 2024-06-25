public class Class138 {
   static int anInt1718;
   static int anInt1719;
   protected int anInt1720;
   protected int anInt1721;
   protected int anInt1722;
   protected int anInt1723;
   static int anInt1724 = 0;
   private byte aByte1725;
   static int anInt1726;
   static int anInt1727;
   static int anInt1728;
   protected int anInt1729;

   final int method1601(boolean bool) {
      if (bool) {
         return 15;
      } else {
         ++anInt1718;
         return (this.aByte1725 & 8) == 8 ? 1 : 0;
      }
   }

   final int method1602(int i) {
      if (i != 28771) {
         return 18;
      } else {
         ++anInt1727;
         return 7 & this.aByte1725;
      }
   }

   static final boolean method1603(byte b, int i, int i_0_) {
      ++anInt1728;
      if (!Class213.rightClickDialogueIsOpen) {
         return false;
      } else {
         int i_1_ = i >> 16;
         if (b <= 68) {
            anInt1726 = 54;
         }

         int i_2_ = 65535 & i;
         if (Class134_Sub3.aWidgetArrayArray9035[i_1_] != null && Class134_Sub3.aWidgetArrayArray9035[i_1_][i_2_] != null) {
            IComponentDefinitions widget = Class134_Sub3.aWidgetArrayArray9035[i_1_][i_2_];
            if (i_0_ == -1 && widget.type == 0) {
               for(CacheNode_Sub13 cachenode_sub13 = (CacheNode_Sub13)Class368.aClass312_4549.method3613(65280);
                  cachenode_sub13 != null;
                  cachenode_sub13 = (CacheNode_Sub13)Class368.aClass312_4549.method3620(16776960)
               ) {
                  if (~cachenode_sub13.anInt9562 == -19
                     || ~cachenode_sub13.anInt9562 == -1003
                     || ~cachenode_sub13.anInt9562 == -13
                     || cachenode_sub13.anInt9562 == 20
                     || cachenode_sub13.anInt9562 == 10) {
                     for(IComponentDefinitions widget_3_ = Class76.getInterfaceFromHash((byte)107, cachenode_sub13.lastClickY);
                        widget_3_ != null;
                        widget_3_ = Class295.method3468((byte)-120, widget_3_)
                     ) {
                        if (widget_3_.ihash == widget.ihash) {
                           return true;
                        }
                     }
                  }
               }
            } else {
               for(CacheNode_Sub13 cachenode_sub13 = (CacheNode_Sub13)Class368.aClass312_4549.method3613(65280);
                  cachenode_sub13 != null;
                  cachenode_sub13 = (CacheNode_Sub13)Class368.aClass312_4549.method3620(16776960)
               ) {
                  if (cachenode_sub13.lastClickX == i_0_
                     && widget.ihash == cachenode_sub13.lastClickY
                     && (
                        cachenode_sub13.anInt9562 == 18
                           || ~cachenode_sub13.anInt9562 == -1003
                           || ~cachenode_sub13.anInt9562 == -13
                           || cachenode_sub13.anInt9562 == 20
                           || cachenode_sub13.anInt9562 == 10
                     )) {
                     return true;
                  }
               }
            }

            return false;
         } else {
            return false;
         }
      }
   }

   static final boolean method1604(int i, int i_4_, int i_5_) {
      if (i_5_ != 0) {
         anInt1724 = -101;
      }

      ++anInt1719;
      return Node_Sub38_Sub26.method2877(i_4_, i, 90) | (i & 458752) != 0 || Class262_Sub15_Sub1.method3192(i_4_, i, 512);
   }

   public Class138() {
   }

   Class138(Buffer buffer) {
      this.aByte1725 = buffer.readByte();
      this.anInt1721 = buffer.readUnsignedShort();
      this.anInt1729 = buffer.readInt();
      this.anInt1722 = buffer.readInt();
      this.anInt1723 = buffer.readInt();
      this.anInt1720 = buffer.readInt();
   }
}
