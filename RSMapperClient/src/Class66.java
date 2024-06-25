abstract class Class66 implements Interface10 {
   private long aLong5164;
   static int anInt5165;
   static int anInt5166;
   static OutgoingPacket aClass318_5167 = new OutgoingPacket(6, 8);
   protected Index aClass302_5168;
   private Class52 aClass52_5169;
   static int anInt5170;
   protected Class150 aClass150_5171;
   static int anInt5172;
   static int anInt5173;
   private int anInt5174;
   private Index aClass302_5175;
   static ClanChat playerOwnedClan;
   static String aString5177 = null;

   @Override
   public final void method27(boolean bool, int i) {
      ++anInt5173;
      int i_0_ = this.aClass150_5171.aClass379_5079.method4160(-123, Node_Sub38_Sub12.anInt10225, this.aClass150_5171.anInt5086)
         - -this.aClass150_5171.anInt5092;
      int i_1_ = this.aClass150_5171.aClass77_5087.method775(Class257.anInt3244, false, this.aClass150_5171.anInt5081) + this.aClass150_5171.anInt5080;
      this.method719(bool, i_0_, (byte)-16, i_1_);
      this.method721(i_0_, -50, bool, i_1_);
      int i_2_ = -113 % ((66 - i) / 42);
      String string = Class243.aClass340_3069.method3957((byte)62);
      if (Class313.method3650(false) + -this.aLong5164 > 10000L) {
         string = string + " (" + Class243.aClass340_3069.method3949(false).method1130(-3) + ")";
      }

      this.aClass52_5169
         .method537(
            -1,
            (byte)99,
            i_0_ - -(this.aClass150_5171.anInt5086 / 2),
            string,
            4 + i_1_ + this.aClass150_5171.anInt5081 / 2 - -this.aClass150_5171.anInt5084,
            this.aClass150_5171.anInt5090
         );
   }

   public static void method718(byte b) {
      if (b == -126) {
         aClass318_5167 = null;
         aString5177 = null;
         playerOwnedClan = null;
      }
   }

   abstract void method719(boolean var1, int var2, byte var3, int var4);

   final int method720(int i) {
      ++anInt5172;
      int i_4_ = Class243.aClass340_3069.method3958((byte)84);
      int i_5_ = i_4_ * i;
      if (~i_4_ == ~this.anInt5174 && i_4_ != 0) {
         int i_6_ = Class243.aClass340_3069.method3955(7398);
         if (~i_4_ > ~i_6_) {
            long l = this.aLong5164 + -Class243.aClass340_3069.method3950((byte)121);
            if (l > 0L) {
               long l_7_ = (long)(i_6_ + -i_4_) * (l * 10000L / (long)i_4_);
               long l_8_ = (-this.aLong5164 + Class313.method3650(false)) * 10000L;
               if (~l_8_ > ~l_7_) {
                  i_5_ = (int)((long)(i_6_ + -i_4_) * l_8_ * 100L / l_7_ + (long)(i_4_ * 100));
               } else {
                  i_5_ = i_6_ * 100;
               }
            }
         }
      } else {
         this.anInt5174 = i_4_;
         this.aLong5164 = Class313.method3650(false);
      }

      return i_5_;
   }

   abstract void method721(int var1, int var2, boolean var3, int var4);

   @Override
   public void method26(int i) {
      ++anInt5166;
      if (i != 99) {
         this.aClass302_5168 = null;
      }

      Class357 class357 = Class129.method1553(i ^ -100, this.aClass150_5171.anInt5083, this.aClass302_5175);
      this.aClass52_5169 = Class93.aGraphicsToolkit1241.a(class357, Class383.method4199(this.aClass302_5168, this.aClass150_5171.anInt5083), true);
   }

   static final void method722(int i, String string) {
      if (i > -116) {
         aString5177 = null;
      }

      ++anInt5165;
      if (Class50.aClass211Array782 != null) {
         ++Node_Sub19.anInt7172;
         Class123 class123 = Class262_Sub23.method3213((byte)-99);
         OutgoingPacketBuffer node_sub13 = PacketParser.createOutgoingPacket(Class235.aClass318_5126, class123.issacKeys);
         node_sub13.currentOutgoingPacket.writeByte(Class126.method1536(-20826, string));
         node_sub13.currentOutgoingPacket.writeString(string);
         class123.sendPacket(127, node_sub13);
      }
   }

   @Override
   public boolean method25(int i) {
      ++anInt5170;
      boolean bool = true;
      if (!this.aClass302_5168.method3510(this.aClass150_5171.anInt5083, (byte)63)) {
         bool = false;
      }

      if (i != 421) {
         this.aClass52_5169 = null;
      }

      if (!this.aClass302_5175.method3510(this.aClass150_5171.anInt5083, (byte)63)) {
         bool = false;
      }

      return bool;
   }

   Class66(Index class302, Index class302_11_, Class150 class150) {
      this.aClass150_5171 = class150;
      this.aClass302_5168 = class302;
      this.aClass302_5175 = class302_11_;
   }
}
