import java.io.IOException;
import java.io.OutputStream;

public class OutputStream_Sub2 extends OutputStream {
   static int anInt92;
   static OutgoingPacket OUTGOING_PLAYER_TRADE_CLICK = new OutgoingPacket(77, 3);
   static int anInt94;
   static int anInt95;
   static int anInt96;
   static int anInt97 = 5000;

   OutputStream_Sub2() {
   }

   public static void method137(int i) {
      if (i != -5656) {
         method139((byte)-53);
      }

      OUTGOING_PLAYER_TRADE_CLICK = null;
   }

   static final void method138(int i, int i_0_, int i_1_, byte b, int i_2_, int i_3_, int i_4_) {
      ++anInt92;
      int i_5_ = 101 % ((b - -46) / 57);
      if (-i_0_ + i_3_ >= Class262_Sub4.anInt7722
         && ~(i_0_ + i_3_) >= ~za_Sub2.anInt10513
         && ~Class384.anInt4906 >= ~(i_2_ - i_0_)
         && i_0_ + i_2_ <= Node_Sub25_Sub1.anInt9936) {
         Class62.method610(i_1_, i_4_, i_2_, i_0_, (byte)-56, i_3_, i);
      } else {
         Class35.method387(i, i_4_, i_1_, i_3_, -1, i_0_, i_2_);
      }
   }

   @Override
   public final void write(int i) throws IOException {
      ++anInt95;
      throw new IOException();
   }

   static final void method139(byte b) {
      ++anInt94;
      int[] is = new int[EntityNode_Sub3_Sub1.aClass86_9166.anInt1175];
      int i = 0;

      for(int i_6_ = 0; ~i_6_ > ~EntityNode_Sub3_Sub1.aClass86_9166.anInt1175; ++i_6_) {
         ItemDefinitions itemdefinition = EntityNode_Sub3_Sub1.aClass86_9166.getItemDefinitionForId(i_6_);
         if (itemdefinition.maleEquip1 >= 0 || itemdefinition.femaleEquip1 >= 0) {
            is[i++] = i_6_;
         }
      }

      Node_Sub28.anIntArray7329 = new int[i];
      if (b != -110) {
         OUTGOING_PLAYER_TRADE_CLICK = null;
      }

      for(int i_7_ = 0; i_7_ < i; ++i_7_) {
         Node_Sub28.anIntArray7329[i_7_] = is[i_7_];
      }
   }
}
