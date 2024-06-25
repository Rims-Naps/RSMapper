public class Class260 implements Interface10 {
   private Class205 aClass205_5219;
   static int anInt5220;
   static int anInt5221;
   static int anInt5222;
   static int anInt5223;
   static int anInt5224;
   static Class77 aClass77_5225 = new Class77();
   static int anInt5226;
   private Class337 aClass337_5227;
   static int anInt5228;
   static int anInt5229;
   static Class124 aClass124_5230 = new Class124(51);
   static int anInt5231;

   private final int method3135(byte b, Class52 class52, String string, int i, int i_0_, int i_1_) {
      ++anInt5222;
      if (b != -122) {
         aClass77_5225 = null;
      }

      return class52.method535(
         0,
         null,
         this.aClass205_5219.anInt5105,
         string,
         null,
         null,
         i_0_ + i_1_,
         this.aClass205_5219.anInt5111,
         92,
         0,
         0,
         i - -i_0_,
         0,
         0,
         this.aClass205_5219.anInt5112 - i_0_ * 2,
         this.aClass205_5219.anInt5103 + -(2 * i_0_)
      );
   }

   static final int method3136(Class94 class94, int i) {
      ++anInt5220;
      if (i != 30716) {
         aClass124_5230 = null;
      }

      if (class94 != Class117_Sub1.aClass94_4924) {
         if (class94 != Class116.aClass94_5075) {
            if (class94 != Class385.aClass94_4911) {
               if (class94 != UnderlayDefinition.aClass94_2898) {
                  if (GameStub.aClass94_11 == class94) {
                     return 34023;
                  } else {
                     throw new IllegalArgumentException();
                  }
               } else {
                  return 260;
               }
            } else {
               return 34165;
            }
         } else {
            return 8448;
         }
      } else {
         return 7681;
      }
   }

   @Override
   public final void method27(boolean bool, int i) {
      int i_2_ = -95 % ((i - 66) / 42);
      ++anInt5224;
      Class295 class295 = this.aClass337_5227.method3902(3, this.aClass205_5219.anInt5114);
      if (class295 != null) {
         int i_3_ = this.aClass205_5219.aClass379_5109.method4160(-106, Node_Sub38_Sub12.anInt10225, this.aClass205_5219.anInt5112)
            + this.aClass205_5219.anInt5113;
         int i_4_ = this.aClass205_5219.aClass77_5106.method775(Class257.anInt3244, false, this.aClass205_5219.anInt5103) + this.aClass205_5219.anInt5110;
         if (this.aClass205_5219.aBoolean5102) {
            Class93.aGraphicsToolkit1241.d(i_3_, i_4_, this.aClass205_5219.anInt5112, this.aClass205_5219.anInt5103, this.aClass205_5219.anInt5107, 0);
         }

         i_4_ += 12 * this.method3135((byte)-122, Class262_Sub4.aClass52_7721, class295.aString3694, i_3_, 5, i_4_);
         i_4_ += 8;
         if (this.aClass205_5219.aBoolean5102) {
            Class93.aGraphicsToolkit1241.a(i_3_, i_4_, -1 + this.aClass205_5219.anInt5112 + i_3_, i_4_, this.aClass205_5219.anInt5107, 0);
         }

         i_4_ = ++i_4_ + 12 * this.method3135((byte)-122, Class262_Sub4.aClass52_7721, class295.aString3697, i_3_, 5, i_4_);
         i_4_ += 5;
         i_4_ += 12 * this.method3135((byte)-122, Class262_Sub4.aClass52_7721, class295.aString3691, i_3_, 5, i_4_);
      }
   }

   static final void method3137(int i) {
      ++anInt5231;
      GameStub.method88((byte)-96);
      Class213.rightClickDialogueIsOpen = false;
      Class310.method3589(Class362.anInt4492, Node_Sub6.anInt7043, (byte)107, Class219.anInt2627, Client.anInt5481);
      if (i != 0) {
         aClass77_5225 = null;
      }
   }

   public static void method3138(byte b) {
      aClass124_5230 = null;
      if (b != 36) {
         aClass124_5230 = null;
      }

      aClass77_5225 = null;
   }

   static final Class<?> method3139(String string, int i) throws ClassNotFoundException {
      ++anInt5229;
      if (string.equals("B")) {
         return Byte.TYPE;
      } else if (string.equals("I")) {
         return Integer.TYPE;
      } else if (string.equals("S")) {
         return Short.TYPE;
      } else if (string.equals("J")) {
         return Long.TYPE;
      } else if (string.equals("Z")) {
         return Boolean.TYPE;
      } else if (string.equals("F")) {
         return Float.TYPE;
      } else {
         if (i != 51) {
            aClass77_5225 = null;
         }

         if (string.equals("D")) {
            return Double.TYPE;
         } else {
            return string.equals("C") ? Character.TYPE : Class.forName(string);
         }
      }
   }

   @Override
   public final void method26(int i) {
      if (i != 99) {
         aClass77_5225 = null;
      }

      ++anInt5221;
   }

   static final ClientScript getClientScript(int scriptId, int i_5_) {
      ++anInt5223;
      if (RSMapperClient.externalCS2 != null && RSMapperClient.externalCS2.get(scriptId) != null) {
         return RSMapperClient.externalCS2.get(scriptId);
      } else {
         ClientScript cachenode_sub9 = (ClientScript)Class258.aClass335_5293.method3849((long)scriptId, true);
         if (cachenode_sub9 != null) {
            return cachenode_sub9;
         } else {
            byte[] data = Class21.index12.getFile(false, 0, scriptId);
            if (data != null && data.length > 1) {
               try {
                  cachenode_sub9 = Class32.loadClientScript(data, false, (long)scriptId);
               } catch (Exception var5) {
                  throw new RuntimeException(var5.getMessage() + " S: " + scriptId);
               }

               Class258.aClass335_5293.method3848((byte)-115, cachenode_sub9, (long)scriptId);
               if (i_5_ > -108) {
                  aClass124_5230 = null;
               }

               return cachenode_sub9;
            } else {
               return null;
            }
         }
      }
   }

   @Override
   public final boolean method25(int i) {
      ++anInt5226;
      if (i != 421) {
         this.method27(true, 15);
      }

      return this.aClass337_5227.method3905(-106);
   }

   Class260(Class337 class337, Class205 class205) {
      this.aClass205_5219 = class205;
      this.aClass337_5227 = class337;
   }
}
