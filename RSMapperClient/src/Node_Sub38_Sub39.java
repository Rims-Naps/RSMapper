public class Node_Sub38_Sub39 extends Node_Sub38 {
   static int anInt10494;
   private int anInt10495 = 1;
   private int anInt10496 = 204;
   static int anInt10497;
   private int anInt10498 = 1;
   static IncommingPacket aClass192_10499 = new IncommingPacket(122, 10);
   static Index index8;

   @Override
   final void method2780(boolean bool, Buffer buffer, int i) {
      if (i != 0) {
         if (~i != -2) {
            if (~i == -3) {
               this.anInt10496 = buffer.readUnsignedShort();
            }
         } else {
            this.anInt10495 = buffer.readUnsignedByte();
         }
      } else {
         this.anInt10498 = buffer.readUnsignedByte();
      }

      ++anInt10494;
      if (bool) {
         method2917(-119);
      }
   }

   public static void method2917(int i) {
      aClass192_10499 = null;
      index8 = null;
      if (i != 0) {
         method2917(-110);
      }
   }

   public Node_Sub38_Sub39() {
      super(0, true);
   }

   @Override
   final int[] method2775(int i, int i_1_) {
      ++anInt10497;
      int[] is = this.aClass146_7460.method1645(27356, i_1_);
      if (this.aClass146_7460.aBoolean1819) {
         for(int i_2_ = 0; ~i_2_ > ~Class339_Sub7.anInt8728; ++i_2_) {
            int i_3_ = CacheNode_Sub3.anIntArray9442[i_2_];
            int i_4_ = Node_Sub25_Sub1.anIntArray9941[i_1_];
            int i_5_ = i_3_ * this.anInt10498 >> 12;
            int i_6_ = i_4_ * this.anInt10495 >> 12;
            int i_7_ = i_3_ % (4096 / this.anInt10498) * this.anInt10498;
            int i_8_ = this.anInt10495 * (i_4_ % (4096 / this.anInt10495));
            if (~i_8_ > ~this.anInt10496) {
               i_5_ -= i_6_;

               while(~i_5_ > -1) {
                  i_5_ += 4;
               }

               while(i_5_ > 3) {
                  i_5_ -= 4;
               }

               if (i_5_ != 1) {
                  is[i_2_] = 0;
                  continue;
               }

               if (i_7_ < this.anInt10496) {
                  is[i_2_] = 0;
                  continue;
               }
            }

            if (~i_7_ > ~this.anInt10496) {
               i_5_ -= i_6_;

               while(i_5_ < 0) {
                  i_5_ += 4;
               }

               while(~i_5_ < -4) {
                  i_5_ -= 4;
               }

               if (i_5_ > 0) {
                  is[i_2_] = 0;
                  continue;
               }
            }

            is[i_2_] = 4096;
         }
      }

      if (i <= 107) {
         method2917(-36);
      }

      return is;
   }
}
