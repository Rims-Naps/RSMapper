public class Class110 {
   static int anInt1377;
   private int anInt1378;
   protected Class22 aClass22_1379;
   static int anInt1380;
   static int anInt1381;
   protected int anInt1382;
   protected int anInt1383;
   static Class110 aClass110_1384 = new Class110(0, Class22.aClass22_379, Class22.aClass22_379, 0, 1);
   static int anInt1385;
   static int anInt1386;
   protected boolean aBoolean1387;
   static int anInt1388;
   protected Class22 aClass22_1389;
   static Class110 aClass110_1390 = new Class110(1, Class22.aClass22_379, 2);
   static int anInt1391;
   static Class110 aClass110_1392 = new Class110(2, Class22.aClass22_379, Class22.aClass22_379, 2, 3);
   protected boolean aBoolean1393;
   static Class110 aClass110_1394 = new Class110(3, Class22.aClass22_379, 3);
   static Class110 aClass110_1395 = new Class110(4, Class22.aClass22_379, Class22.aClass22_379, 3, 4);
   static Class110 aClass110_1396 = new Class110(5, Class22.aClass22_379, 4);
   static Class110 aClass110_1397 = new Class110(6, Class22.aClass22_379, 4);
   static Class110 aClass110_1398 = new Class110(7, Class22.aClass22_379, Class22.aClass22_379, 4, 5);
   static Class110 aClass110_1399 = new Class110(8, Class22.aClass22_379, Class22.aClass22_379, 5, 98, true, true);
   static Class110 aClass110_1400 = new Class110(9, Class22.aClass22_379, 99);
   static Class110 aClass110_1401 = new Class110(10, Class22.aClass22_379, 100);
   static Class110 aClass110_1402 = new Class110(11, Class22.aClass22_380, Class22.aClass22_380, 0, 92, true, true);
   static Class110 aClass110_1403 = new Class110(12, Class22.aClass22_380, Class22.aClass22_380, 92, 92);
   private static Class110 aClass110_1404 = new Class110(13, Class22.aClass22_380, Class22.aClass22_380, 92, 93);
   static Class110 aClass110_1405 = new Class110(14, Class22.aClass22_380, Class22.aClass22_380, 94, 95);
   static Class110 aClass110_1406 = new Class110(15, Class22.aClass22_380, Class22.aClass22_380, 96, 97);
   static Class110 aClass110_1407 = new Class110(16, Class22.aClass22_380, 97);
   static Class110 aClass110_1408 = new Class110(17, Class22.aClass22_380, 97);
   static Class110 aClass110_1409 = new Class110(18, Class22.aClass22_380, 100);
   static Class110 aClass110_1410 = new Class110(19, Class22.aClass22_380, 100);
   static Class110 aClass110_1411 = new Class110(20, Class22.aClass22_380, 100);
   static int anInt1412 = 0;
   static Class<?> aClass1413;

   static final void method1129(byte b, int i) {
      if (b <= 62) {
         method1129((byte)-96, -70);
      }

      ++anInt1391;
      Class105.aClass61_5202.method598(i, -11819);
   }

   private Class110(int i, Class22 class22, int i_0_) {
      this(i, class22, class22, i_0_, i_0_, true, false);
   }

   @Override
   public final String toString() {
      ++anInt1385;
      throw new IllegalStateException();
   }

   private Class110(int i, Class22 class22, Class22 class22_1_, int i_2_, int i_3_) {
      this(i, class22, class22_1_, i_2_, i_3_, true, false);
   }

   final int method1130(int i) {
      ++anInt1377;
      return i != -3 ? -111 : this.anInt1378;
   }

   static final void method1131(int plane, int localY, int type, int animationId, int localX, int rotation, int junk, int typeFlag) {
      ++anInt1381;
      if (localX >= 0 && localY >= 0 && Node_Sub54.GAME_SCENE_WDITH - 1 > localX && Class377_Sub1.GAME_SCENE_HEIGHT - 1 > localY) {
         if (Class175.aClass261ArrayArrayArray2099 == null) {
            return;
         }

         if (typeFlag == 0) {
            WorldObject interface19 = (WorldObject)Node_Sub38_Sub12.method2830(plane, localX, localY);
            if (interface19 != null && type != 2) {
               if (!(interface19 instanceof Animable_Sub2_Sub1)) {
                  Class128.method1544(localY, type, rotation, localX, animationId, typeFlag, plane, 58, interface19.getId(-32136));
               } else {
                  ((Animable_Sub2_Sub1)interface19).aClass310_10632.method3591(animationId, 30994);
               }
            }

            WorldObject interface19_11_ = (WorldObject)Class328.method3827(plane, localX, localY);
            if (interface19_11_ != null) {
               if (!(interface19_11_ instanceof Animable_Sub2_Sub1)) {
                  Class128.method1544(localY, type, rotation, localX, animationId, typeFlag, plane, 99, interface19_11_.getId(-32136));
               } else {
                  ((Animable_Sub2_Sub1)interface19_11_).aClass310_10632.method3591(animationId, junk ^ -30994);
               }
            }
         } else if (typeFlag != 1) {
            if (typeFlag != 2) {
               if (typeFlag == 3) {
                  WorldObject interface19 = (WorldObject)Class270_Sub1_Sub1.method3303(plane, localX, localY);
                  if (interface19 != null) {
                     if (interface19 instanceof Animable_Sub1_Sub2) {
                        ((Animable_Sub1_Sub2)interface19).aClass310_10652.method3591(animationId, 30994);
                     } else {
                        Class128.method1544(localY, type, rotation, localX, animationId, typeFlag, plane, junk + 67, interface19.getId(-32136));
                     }
                  }
               }
            } else {
               WorldObject interface19 = (WorldObject)Class262_Sub20.method3203(
                  plane, localX, localY, aClass1413 != null ? aClass1413 : (aClass1413 = method1136("WorldObject"))
               );
               if (interface19 != null) {
                  if (type == 11) {
                     type = 10;
                  }

                  if (!(interface19 instanceof Mobile_Sub3)) {
                     Class128.method1544(localY, type, rotation, localX, animationId, typeFlag, plane, junk + -120, interface19.getId(-32136));
                  } else {
                     ((Mobile_Sub3)interface19).aClass310_10777.method3591(animationId, 30994);
                  }
               }
            }
         } else {
            WorldObject interface19 = (WorldObject)CacheNode_Sub8.method2320(plane, localX, localY);
            if (interface19 != null) {
               if (interface19 instanceof Animable_Sub4_Sub2) {
                  ((Animable_Sub4_Sub2)interface19).aClass310_10794.method3591(animationId, 30994);
               } else {
                  int i_12_ = interface19.getId(-32136);
                  if (type == 4 || type == 5) {
                     Class128.method1544(localY, 4, rotation, localX, animationId, typeFlag, plane, -125, i_12_);
                  } else if (type == 6) {
                     Class128.method1544(localY, 4, rotation + 4, localX, animationId, typeFlag, plane, -128, i_12_);
                  } else if (type == 7) {
                     Class128.method1544(localY, 4, (3 & rotation + 2) - -4, localX, animationId, typeFlag, plane, junk ^ 121, i_12_);
                  } else if (type == 8) {
                     Class128.method1544(localY, 4, 4 + rotation, localX, animationId, typeFlag, plane, junk + -123, i_12_);
                     Class128.method1544(localY, 4, (2 + rotation & 3) + 4, localX, animationId, typeFlag, plane, -125, i_12_);
                  }
               }
            }
         }
      }

      if (junk != -4) {
         aClass110_1399 = null;
      }
   }

   static final void method1132(int i, boolean bool, boolean bool_13_) {
      if (i == 0) {
         ++anInt1388;
         if (bool_13_) {
            ++Class233.anInt2783;
            Class262_Sub11.method3176(i + 1);
         }

         if (bool) {
            ++Class108.anInt5283;
            Class246.method3073(113);
         }
      }
   }

   static final Class110[] method1133(byte b) {
      ++anInt1386;
      int i = 87 % ((b - 5) / 47);
      return new Class110[]{
         aClass110_1384,
         aClass110_1390,
         aClass110_1392,
         aClass110_1394,
         aClass110_1395,
         aClass110_1396,
         aClass110_1397,
         aClass110_1398,
         aClass110_1399,
         aClass110_1400,
         aClass110_1401,
         aClass110_1402,
         aClass110_1403,
         aClass110_1404,
         aClass110_1405,
         aClass110_1406,
         aClass110_1407,
         aClass110_1408,
         aClass110_1409,
         aClass110_1410,
         aClass110_1411
      };
   }

   public static void method1134(int i) {
      aClass110_1384 = null;
      aClass110_1396 = null;
      aClass110_1411 = null;
      aClass110_1390 = null;
      aClass110_1395 = null;
      aClass110_1394 = null;
      aClass110_1392 = null;
      aClass110_1404 = null;
      aClass110_1401 = null;
      aClass110_1403 = null;
      aClass110_1409 = null;
      aClass110_1397 = null;
      aClass110_1402 = null;
      aClass110_1400 = null;
      aClass110_1398 = null;
      aClass110_1410 = null;
      aClass110_1406 = null;
      aClass110_1405 = null;
      aClass110_1408 = null;
      aClass110_1399 = null;
      aClass110_1407 = null;
      if (i != 97) {
         aClass110_1401 = null;
      }
   }

   private Class110(int i, Class22 class22, Class22 class22_14_, int i_15_, int i_16_, boolean bool, boolean bool_17_) {
      this.anInt1383 = i_15_;
      this.aBoolean1387 = bool;
      this.anInt1382 = i_16_;
      this.aBoolean1393 = bool_17_;
      this.aClass22_1389 = class22_14_;
      this.aClass22_1379 = class22;
      this.anInt1378 = i;
   }

   static final boolean method1135(int i, int i_18_, boolean bool) {
      ++anInt1380;
      if (!Class320_Sub4.method3693(75, i, i_18_)) {
         return false;
      } else if (bool) {
         return false;
      } else {
         return (45056 & i) != 0 | CacheNode_Sub3.method2296(i_18_, (byte)-79, i) | Class320_Sub7.method3711((byte)86, i, i_18_)
            ? true
            : (Class73.method749((byte)-65, i, i_18_) | Class214.method2060(i, i_18_, 116)) & (55 & i_18_) == 0;
      }
   }

   static Class<?> method1136(String string) {
      try {
         return Class.forName(string);
      } catch (ClassNotFoundException var3) {
         throw (NoClassDefFoundError)new NoClassDefFoundError().initCause(var3);
      }
   }
}
