public class CacheNode_Sub1 extends CacheNode {
   static int anInt9420;
   static Class257 aClass257_9421 = new Class257(10, 19);
   static int anInt9422;
   private HashTable aHashTable9423;
   static int anInt9424;
   static boolean aBoolean9425 = false;
   static int anInt9426;
   static int[] anIntArray9427;

   static final void method2280(int i) {
      Class320_Sub12.anInt8327 = i;

      for(int i_0_ = 0; i_0_ < Class328.SCENE_WIDTH_X; ++i_0_) {
         for(int i_1_ = 0; i_1_ < Node_Sub50.SCENE_WIDTH_Y; ++i_1_) {
            if (Class175.aClass261ArrayArrayArray2099[i][i_0_][i_1_] == null) {
               Class175.aClass261ArrayArrayArray2099[i][i_0_][i_1_] = new Class261(i);
            }
         }
      }
   }

   private final void method2281(int i, Buffer buffer, int i_2_) {
      if (i == 249) {
         int i_3_ = buffer.readUnsignedByte();
         if (this.aHashTable9423 == null) {
            int i_4_ = Class320_Sub19.method3753(i_3_);
            this.aHashTable9423 = new HashTable(i_4_);
         }

         for(int i_5_ = 0; i_3_ > i_5_; ++i_5_) {
            boolean bool = buffer.readUnsignedByte() == 1;
            int i_6_ = buffer.read24BitInteger();
            Node node;
            if (bool) {
               node = new Node_Sub18(buffer.readString());
            } else {
               node = new Node_Sub32(buffer.readInt());
            }

            this.aHashTable9423.put((long)i_6_, node, -124);
         }
      }

      if (i_2_ <= -118) {
         ++anInt9422;
      }
   }

   final int method2282(int i, int i_7_, int i_8_) {
      ++anInt9420;
      if (this.aHashTable9423 == null) {
         return i;
      } else {
         Node_Sub32 node_sub32 = (Node_Sub32)this.aHashTable9423.get(3512, (long)i_8_);
         return node_sub32 == null ? i : node_sub32.anInt7381;
      }
   }

   final void method2283(byte b, Buffer buffer) {
      ++anInt9426;

      while(true) {
         int i = buffer.readUnsignedByte();
         if (~i == -1) {
            return;
         }

         this.method2281(i, buffer, -119);
      }
   }

   final String method2284(int i, String string, int i_10_) {
      ++anInt9424;
      if (this.aHashTable9423 == null) {
         return string;
      } else if (i_10_ != 27908) {
         return null;
      } else {
         Node_Sub18 node_sub18 = (Node_Sub18)this.aHashTable9423.get(3512, (long)i);
         return node_sub18 == null ? string : node_sub18.aString7149;
      }
   }

   public static void method2285(int i) {
      aClass257_9421 = null;
      anIntArray9427 = null;
      if (i != 12228) {
         method2285(-85);
      }
   }
}
