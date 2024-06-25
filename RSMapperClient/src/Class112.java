import com.dropbox.core.v2.DbxClientV2;

public class Class112 {
   static int anInt1419;
   static int anInt1420;
   private Class353 aClass353_1421;
   private int anInt1422;
   static int anInt1423;
   protected boolean aBoolean1424 = false;
   static int anInt1425;
   static int anInt1426;
   private Class61 aClass61_1427 = new Class61(64);
   static int anInt1428;
   static int anInt1429;
   private Index aClass302_1430;
   protected boolean aBoolean1431;
   static int anInt1432;
   protected Index aClass302_1433;
   protected Class61 aClass61_1434 = new Class61(500);
   protected Class61 aClass61_1435 = new Class61(30);
   protected Class61 aClass61_1436 = new Class61(50);
   protected int anInt1437;
   private String[] aStringArray1438;
   public static DbxClientV2 aHashTable1923;

   final void method1140(int i) {
      synchronized(this.aClass61_1427) {
         this.aClass61_1427.method602((byte)-121);
      }

      ++anInt1426;
      synchronized(this.aClass61_1434) {
         this.aClass61_1434.method602((byte)-119);
      }

      synchronized(this.aClass61_1435) {
         this.aClass61_1435.method602((byte)-125);
      }

      synchronized(this.aClass61_1436) {
         if (i > -9) {
            this.aBoolean1431 = false;
         }

         this.aClass61_1436.method602((byte)-117);
      }
   }

   final void method1141(boolean bool, int i) {
      ++anInt1420;
      if (!bool != !this.aBoolean1431) {
         this.aBoolean1431 = bool;
         this.method1142(52);
         if (i != 32648) {
            this.aClass61_1435 = null;
         }
      }
   }

   final void method1142(int i) {
      ++anInt1429;
      if (i < 13) {
         this.aStringArray1438 = null;
      }

      synchronized(this.aClass61_1427) {
         this.aClass61_1427.method608(false);
      }

      synchronized(this.aClass61_1434) {
         this.aClass61_1434.method608(false);
      }

      synchronized(this.aClass61_1435) {
         this.aClass61_1435.method608(false);
      }

      synchronized(this.aClass61_1436) {
         this.aClass61_1436.method608(false);
      }
   }

   final void method1143(int i, boolean bool) {
      ++anInt1425;
      if (!bool != !this.aBoolean1424 && i == -2098) {
         this.aBoolean1424 = bool;
         this.method1142(109);
      }
   }

   final void method1144(int i, int i_0_) {
      if (i != 64) {
         this.aClass302_1433 = null;
      }

      this.aClass61_1427 = new Class61(i_0_);
      ++anInt1419;
   }

   final ObjectDefinition getObjectDefinitionsForId(int objectId, int junk) {
      ++anInt1432;
      if (junk <= 29) {
         return null;
      } else {
         ObjectDefinition objectdefinition;
         synchronized(this.aClass61_1427) {
            objectdefinition = (ObjectDefinition)this.aClass61_1427.method607((long)objectId, 0);
         }

         if (objectdefinition != null) {
            return objectdefinition;
         } else {
            byte[] bs;
            synchronized(this.aClass302_1430) {
               bs = this.aClass302_1430.getFile(false, Class300.method3499(objectId, (byte)-6), Class374.method4112(1, objectId));
            }

            objectdefinition = new ObjectDefinition();
            objectdefinition.objectId = objectId;
            objectdefinition.aClass112_3028 = this;
            objectdefinition.options = (String[])this.aStringArray1438.clone();
            if (bs != null) {
               objectdefinition.method3042((byte)123, new Buffer(bs));
            }

            objectdefinition.method3043(5);
            if (objectdefinition.aBoolean3016) {
               objectdefinition.clipType = 0;
               objectdefinition.aBoolean3034 = false;
            }

            if (!this.aBoolean1431 && objectdefinition.aBoolean3002) {
               objectdefinition.options = null;
               objectdefinition.rightClickImages = null;
            }

            synchronized(this.aClass61_1427) {
               this.aClass61_1427.method601(objectdefinition, 25566, (long)objectId);
               return objectdefinition;
            }
         }
      }
   }

   final void method1146(int i, int i_2_) {
      ++anInt1428;
      if (i_2_ == 500) {
         synchronized(this.aClass61_1427) {
            this.aClass61_1427.method598(i, -11819);
         }

         synchronized(this.aClass61_1434) {
            this.aClass61_1434.method598(i, -11819);
         }

         synchronized(this.aClass61_1435) {
            this.aClass61_1435.method598(i, i_2_ + -12319);
         }

         synchronized(this.aClass61_1436) {
            this.aClass61_1436.method598(i, -11819);
         }
      }
   }

   final void method1147(int i, int i_3_) {
      ++anInt1423;
      this.anInt1437 = i;
      synchronized(this.aClass61_1434) {
         this.aClass61_1434.method608(false);
      }

      synchronized(this.aClass61_1435) {
         this.aClass61_1435.method608(false);
      }

      synchronized(this.aClass61_1436) {
         this.aClass61_1436.method608(false);
      }

      if (i_3_ != 29988) {
         this.method1140(-121);
      }
   }

   Class112(Class353 class353, int i, boolean bool, Index class302, Index class302_4_) {
      this.aClass302_1433 = class302_4_;
      this.aClass353_1421 = class353;
      this.anInt1422 = i;
      this.aClass302_1430 = class302;
      this.aBoolean1431 = bool;
      if (this.aClass302_1430 != null) {
         int i_5_ = -1 + this.aClass302_1430.method3526(-20871);
         this.aClass302_1430.method3537(-2, i_5_);
      }

      if (Node_Sub38_Sub34.aClass353_10443 != this.aClass353_1421) {
         this.aStringArray1438 = new String[6];
      } else {
         this.aStringArray1438 = new String[]{null, null, null, null, null, Class22.aClass22_385.getStoredString(this.anInt1422)};
      }
   }
}
