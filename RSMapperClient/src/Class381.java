import java.lang.reflect.Method;

public class Class381 {
   static int anInt4892;
   static int anInt4893;
   static int anInt4894 = 0;
   static Class aClass4895;
   static Class aClass4896;

   static final synchronized void method4172(int i) {
      ++anInt4892;
      if (Class66_Sub1.anObject8988 == null) {
         try {
            int i_0_ = 108 % ((-70 - i) / 49);
            Class var_class = Class.forName("java.lang.management.ManagementFactory");
            Method method = var_class.getDeclaredMethod("getPlatformMBeanServer");
            Object object = method.invoke(null);
            Method method_1_ = var_class.getMethod(
               "newPlatformMXBeanProxy",
               Class.forName("javax.management.MBeanServerConnection"),
               aClass4895 == null ? (aClass4895 = method4174("java.lang.String")) : aClass4895,
               aClass4896 == null ? (aClass4896 = method4174("java.lang.Class")) : aClass4896
            );
            Class66_Sub1.anObject8988 = method_1_.invoke(
               null, object, "com.sun.management:type=HotSpotDiagnostic", Class.forName("com.sun.management.HotSpotDiagnosticMXBean")
            );
         } catch (Exception var6) {
            System.out.println("HeapDump setup error:");
            var6.printStackTrace();
         }
      }
   }

   static final void method4173(int i, int i_2_, Actor actor, byte b, int i_3_, int i_4_, int i_5_) {
      Animable_Sub3.method919(actor.plane, actor.y, i_4_, actor.x, false, 0);
      int i_6_ = -61 % ((-26 - b) / 39);
      ++anInt4893;
   }

   static Class method4174(String string) {
      try {
         return Class.forName(string);
      } catch (ClassNotFoundException var3) {
         throw (NoClassDefFoundError)new NoClassDefFoundError().initCause(var3);
      }
   }
}
