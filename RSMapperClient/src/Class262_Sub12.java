public class Class262_Sub12 extends Class262 {
   static Class124 aClass124_7785 = new Class124(70);
   private int anInt7786;
   static int anInt7787;
   static OutgoingPacket aClass318_7788 = new OutgoingPacket(3, 4);
   private int anInt7789;
   private Node_Sub4 aNode_Sub4_7790;
   static int anInt7791 = 0;
   static int anInt7792;
   static String[] aStringArray7793 = new String[200];

   Class262_Sub12(Buffer buffer) {
      super(buffer);
      this.anInt7786 = buffer.readUnsignedShort();
      this.anInt7789 = buffer.readUnsignedByte();
   }

   @Override
   final boolean method3145(boolean bool) {
      if (this.aNode_Sub4_7790 == null) {
         this.aNode_Sub4_7790 = Node_Sub4.method2173(SeekableFile.index6, this.anInt7786, 0);
      }

      ++anInt7792;
      if (this.aNode_Sub4_7790 == null) {
         return false;
      } else if (!bool) {
         return true;
      } else {
         return FixedAnimator.method257(this.aNode_Sub4_7790, 0);
      }
   }

   public static void method3180(int i) {
      if (i != 30151) {
         aClass318_7788 = null;
      }

      aStringArray7793 = null;
      aClass124_7785 = null;
      aClass318_7788 = null;
   }

   @Override
   final void method3148(int i) {
      ++anInt7787;
      if (i <= -102) {
         Node_Sub38_Sub37.method2908((byte)66, this.aNode_Sub4_7790, this.anInt7789);
      }
   }
}
