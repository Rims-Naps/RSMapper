public class ClientScript extends CacheNode {
   public static int anInt9496;
   protected String name;
   static Class216 aClass216_9498;
   protected int totalIntVars;
   protected int[] opcodes;
   protected long[] longValues;
   protected int totalLongVars;
   protected HashTable[] aHashTableArray9503;
   protected String[] stringValues;
   protected Class212 aClass212_9505;
   protected int totalStringVars;
   protected int totalIntParams;
   protected int[] intValues;
   static int anInt9509;
   static boolean aBoolean9510 = false;
   protected int totalStringParams;
   protected int totalLongParams;
   static int anInt9513;

   static final void method2321(int i, IComponentDefinitions widget) {
      if (widget.anInt4824 == Node_Sub12.anInt5453) {
         Class195.aBooleanArray2387[widget.anInt4703] = true;
      }

      ++anInt9509;
      if (i != -1) {
         method2321(122, null);
      }
   }

   static final boolean method2322(int i, int i_0_, int i_1_) {
      if (i < 41) {
         return false;
      } else {
         ++anInt9513;
         return ~(1024 & i_0_) != -1;
      }
   }

   public static void method2323(int i) {
      int i_2_ = 28 % ((-48 - i) / 36);
      aClass216_9498 = null;
   }
}
