public class Node_Sub45_Sub1 extends Node_Sub45 {
   protected boolean aBoolean10501;
   protected int anInt10502;
   protected int anInt10503;
   protected byte[] aByteArray10504;
   protected int anInt10505;

   final Node_Sub45_Sub1 method2947(Class191 class191) {
      this.aByteArray10504 = class191.method1949(-14, this.aByteArray10504);
      this.anInt10502 = class191.method1948(0, this.anInt10502);
      if (this.anInt10503 == this.anInt10505) {
         this.anInt10503 = this.anInt10505 = class191.method1945(5692, this.anInt10503);
      } else {
         this.anInt10503 = class191.method1945(5692, this.anInt10503);
         this.anInt10505 = class191.method1945(5692, this.anInt10505);
         if (this.anInt10503 == this.anInt10505) {
            --this.anInt10503;
         }
      }

      return this;
   }

   Node_Sub45_Sub1(int i, byte[] bs, int i_0_, int i_1_) {
      this.anInt10502 = i;
      this.aByteArray10504 = bs;
      this.anInt10503 = i_0_;
      this.anInt10505 = i_1_;
   }

   Node_Sub45_Sub1(int i, byte[] bs, int i_2_, int i_3_, boolean bool) {
      this.anInt10502 = i;
      this.aByteArray10504 = bs;
      this.anInt10503 = i_2_;
      this.anInt10505 = i_3_;
      this.aBoolean10501 = bool;
   }
}
