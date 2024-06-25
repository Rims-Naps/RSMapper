public class Class118 implements Interface17 {
   static int anInt5404;
   static int anInt5405 = 0;
   static int anInt5406 = 0;
   static int anInt5407 = 0;
   static int anInt5408;
   static int anInt5409;
   static int anInt5410;
   static int anInt5411;

   static final boolean method1175(byte[] bs, int i, int i_0_, int i_1_, int i_2_, int i_3_) {
      ++anInt5411;
      boolean bool = true;
      Buffer buffer = new Buffer(bs);
      int i_4_ = i;

      label55:
      while(true) {
         int i_5_ = buffer.readSmart2(true);
         if (i_5_ == 0) {
            return bool;
         }

         i_4_ += i_5_;
         int i_6_ = 0;
         boolean bool_7_ = false;

         while(true) {
            while(!bool_7_) {
               int i_9_ = buffer.readSmart();
               if (~i_9_ == -1) {
                  continue label55;
               }

               i_6_ += -1 + i_9_;
               int i_10_ = 63 & i_6_;
               int i_11_ = 63 & i_6_ >> 6;
               int i_12_ = buffer.readUnsignedByte() >> 2;
               int i_13_ = i_0_ + i_11_;
               int i_14_ = i_10_ + i_2_;
               if (~i_13_ < -1 && i_14_ > 0 && ~(-1 + i_1_) < ~i_13_ && ~(-1 + i_3_) < ~i_14_) {
                  ObjectDefinition objectdefinition = Class186.aClass112_2256.getObjectDefinitionsForId(i_4_, i + 110);
                  if (i_12_ != 22
                     || Class213.aNode_Sub27_2512.aClass320_Sub6_7267.method3701(false) != 0
                     || objectdefinition.anInt3057 != 0
                     || objectdefinition.clipType == -1
                     || objectdefinition.aBoolean3051) {
                     bool_7_ = true;
                     if (!objectdefinition.method3039(82)) {
                        bool = false;
                        ++Node_Sub2.anInt6937;
                     }
                  }
               }
            }

            int i_8_ = buffer.readSmart();
            if (i_8_ == 0) {
               break;
            }

            buffer.readUnsignedByte();
         }
      }
   }

   Class118() {
   }

   @Override
   public final int method65(int i, int i_15_) {
      int i_16_ = 60 % ((56 - i_15_) / 44);
      ++anInt5409;
      Node_Sub32 node_sub32 = (Node_Sub32)Class18.aHashTable308.get(3512, (long)i);
      return node_sub32 == null ? Class24.aClass275_442.method65(i, -107) : node_sub32.anInt7381;
   }

   @Override
   public final int getVarpBit(int i, byte b) {
      ++anInt5408;
      Node_Sub32 node_sub32 = (Node_Sub32)Class18.aHashTable308.get(b ^ -3474, (long)i | 4294967296L);
      if (b != -42) {
         method1175(null, -67, -10, 88, -118, -60);
      }

      return node_sub32 == null ? Class24.aClass275_442.getVarpBit(i, (byte)-42) : node_sub32.anInt7381;
   }
}
