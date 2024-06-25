public class OverlayDefinition {
   static int anInt3628;
   protected int mapColor;
   static HashTable aHashTable3630 = new HashTable(8);
   protected int anInt3631 = 0;
   protected int anInt3632 = 512;
   protected int anInt3633;
   protected int anInt3634;
   protected Class71 aClass71_3635;
   protected boolean aBoolean3636 = true;
   protected int overlayId;
   protected boolean aBoolean3638;
   static int anInt3639;
   protected int texture;
   protected int anInt3641;
   static int anInt3642;
   protected boolean blend;
   static int anInt3644;
   static int anInt3645;
   protected int anInt3646;

   static final void method3405(int i, int i_0_, int i_1_, int i_2_, int i_3_, int i_4_, byte b) {
      ++anInt3628;
      int i_5_ = i_2_ + -i_3_;
      int i_6_ = i_4_ - -i_3_;

      for(int i_7_ = i_4_; ~i_6_ < ~i_7_; ++i_7_) {
         Class369.method4086(i_1_, i, i_0_, Class169_Sub4.anIntArrayArray8826[i_7_], b + -44);
      }

      for(int i_8_ = i_2_; ~i_5_ > ~i_8_; --i_8_) {
         Class369.method4086(i_1_, i, i_0_, Class169_Sub4.anIntArrayArray8826[i_8_], 0);
      }

      int i_9_ = i_1_ - i_3_;
      int i_10_ = i_0_ - -i_3_;

      for(int i_11_ = i_6_; ~i_11_ >= ~i_5_; ++i_11_) {
         int[] is = Class169_Sub4.anIntArrayArray8826[i_11_];
         Class369.method4086(i_10_, i, i_0_, is, b + -44);
         Class369.method4086(i_1_, i, i_9_, is, 0);
      }

      if (b != 44) {
         aHashTable3630 = null;
      }
   }

   final void method3406(int i) {
      ++anInt3642;
      if (i != -13163) {
         this.aBoolean3636 = true;
      }

      this.anInt3633 = this.overlayId | this.anInt3633 << 8;
   }

   public static void method3407(boolean bool) {
      aHashTable3630 = null;
      if (bool) {
         anInt3645 = -4;
      }
   }

   public static boolean isWaterOverlay(byte overlay) {
      return overlay == 112
         || overlay == 114
         || overlay == -118
         || overlay == -127
         || overlay == -56
         || overlay == -60
         || overlay == -67
         || overlay == -87
         || overlay == -21
         || overlay == -25
         || overlay == -40
         || overlay == -41
         || overlay == -42;
   }

   final void decodeOverlay(Buffer buffer) {
      ++anInt3644;

      while(true) {
         int opcode = buffer.readUnsignedByte();
         if (opcode == 0) {
            return;
         }

         this.readValue(buffer, opcode);
      }
   }

   private final void readValue(Buffer buffer, int opcode) {
      ++anInt3639;
      if (opcode != 1) {
         if (opcode == 2) {
            this.texture = buffer.readUnsignedByte();
         } else if (opcode != 3) {
            if (opcode == 5) {
               this.aBoolean3636 = false;
            } else if (opcode != 7) {
               if (opcode == 8) {
                  this.aClass71_3635.anInt961 = this.overlayId;
               } else if (opcode != 9) {
                  if (opcode == 10) {
                     this.aBoolean3638 = false;
                  } else if (opcode == 11) {
                     this.anInt3633 = buffer.readUnsignedByte();
                  } else if (opcode == 12) {
                     this.blend = true;
                  } else if (opcode == 13) {
                     this.anInt3646 = buffer.read24BitInteger();
                  } else if (opcode == 14) {
                     this.anInt3634 = buffer.readUnsignedByte() << 2;
                  } else if (opcode == 16) {
                     this.anInt3641 = buffer.readUnsignedByte();
                  }
               } else {
                  this.anInt3632 = buffer.readUnsignedShort() << 2;
               }
            } else {
               this.mapColor = Node_Sub15_Sub12.getColor(buffer.read24BitInteger(), -1);
            }
         } else {
            this.texture = buffer.readUnsignedShort();
            if (this.texture == 65535) {
               this.texture = -1;
            }
         }
      } else {
         this.anInt3631 = Node_Sub15_Sub12.getColor(buffer.read24BitInteger(), -1);
      }
   }

   public OverlayDefinition() {
      this.mapColor = -1;
      this.anInt3634 = 64;
      this.aBoolean3638 = true;
      this.anInt3633 = 8;
      this.anInt3641 = 127;
      this.texture = -1;
      this.blend = false;
      this.anInt3646 = 1190717;
   }
}
