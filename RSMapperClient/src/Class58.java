public class Class58 {
   static int anInt852;
   private Class61 aClass61_853 = new Class61(128);
   static int anInt854;
   static int anInt855;
   static IncommingPacket aClass192_856 = new IncommingPacket(33, -2);
   static int anInt857;
   static int anInt858;
   static int anInt859;
   private Index aClass302_860;
   static IComponentDefinitions aWidget861 = null;
   static int anInt862;

   final UnderlayDefinition getUnderlayDefinitions(int junk, int underlayFileId) {
      ++anInt859;
      UnderlayDefinition underlay;
      synchronized(this.aClass61_853) {
         underlay = (UnderlayDefinition)this.aClass61_853.method607((long)underlayFileId, junk ^ junk);
      }

      if (underlay != null) {
         return underlay;
      } else {
         byte[] bs;
         synchronized(this.aClass302_860) {
            bs = this.aClass302_860.getFile(false, underlayFileId, 1);
         }

         underlay = new UnderlayDefinition();
         if (bs != null) {
            underlay.decodeUnderlay(new Buffer(bs), junk ^ 17992);
         }

         synchronized(this.aClass61_853) {
            this.aClass61_853.method601(underlay, junk + 43559, (long)underlayFileId);
            return underlay;
         }
      }
   }

   final void method574(int i) {
      ++anInt858;
      if (i < 96) {
         getIndex(false, -5, 126, -59);
      }

      synchronized(this.aClass61_853) {
         this.aClass61_853.method608(false);
      }
   }

   static final void method575(Animable animable) {
      if (animable != null) {
         for(int i = 0; i < 2; ++i) {
            Animable animable_1_ = null;

            for(Animable animable_2_ = Class303.anAnimableArray3827[i]; animable_2_ != null; animable_2_ = animable_2_.anAnimable5941) {
               if (animable_2_ == animable) {
                  if (animable_1_ != null) {
                     animable_1_.anAnimable5941 = animable_2_.anAnimable5941;
                  } else {
                     Class303.anAnimableArray3827[i] = animable_2_.anAnimable5941;
                  }

                  Class194_Sub1.aBoolean6892 = true;
                  return;
               }

               animable_1_ = animable_2_;
            }

            animable_1_ = null;

            for(Animable animable_3_ = SeekableFile.anAnimableArray3884[i]; animable_3_ != null; animable_3_ = animable_3_.anAnimable5941) {
               if (animable_3_ == animable) {
                  if (animable_1_ != null) {
                     animable_1_.anAnimable5941 = animable_3_.anAnimable5941;
                  } else {
                     SeekableFile.anAnimableArray3884[i] = animable_3_.anAnimable5941;
                  }

                  Class194_Sub1.aBoolean6892 = true;
                  return;
               }

               animable_1_ = animable_3_;
            }

            animable_1_ = null;

            for(Animable animable_4_ = Node_Sub36.anAnimableArray7429[i]; animable_4_ != null; animable_4_ = animable_4_.anAnimable5941) {
               if (animable_4_ == animable) {
                  if (animable_1_ != null) {
                     animable_1_.anAnimable5941 = animable_4_.anAnimable5941;
                  } else {
                     Node_Sub36.anAnimableArray7429[i] = animable_4_.anAnimable5941;
                  }

                  Class194_Sub1.aBoolean6892 = true;
                  return;
               }

               animable_1_ = animable_4_;
            }
         }
      }
   }

   static final Index getIndex(boolean bool, int indexId, int i_5_, int i_6_) {
      ++anInt857;
      MainFile class6 = null;
      if (Class99.aSeekableFile1289 != null) {
         class6 = new MainFile(indexId, Class99.aSeekableFile1289, Class150_Sub1.indexes[indexId], 1000000);
      }

      GraphicsToolkit.aClass34_Sub1Array1547[indexId] = Class144_Sub1.aClass232_6802.method2137(class6, indexId, Class194_Sub2.aClass6_6899);
      GraphicsToolkit.aClass34_Sub1Array1547[indexId].method386((byte)119);
      if (i_6_ != 2) {
         method575(null);
      }

      return new Index(GraphicsToolkit.aClass34_Sub1Array1547[indexId], bool, i_5_);
   }

   static final boolean method577(int i, int i_7_) {
      if (i_7_ != -22906) {
         anInt862 = 81;
      }

      ++anInt854;
      return ~i == -12 || ~i == -13 || i == 13;
   }

   public static void method578(boolean bool) {
      aClass192_856 = null;
      if (bool) {
         aWidget861 = null;
      }
   }

   final void method579(boolean bool) {
      ++anInt855;
      synchronized(this.aClass61_853) {
         this.aClass61_853.method602((byte)-128);
      }

      if (!bool) {
         aClass192_856 = null;
      }
   }

   Class58(Class353 class353, int i, Index class302) {
      this.aClass302_860 = class302;
      this.aClass302_860.method3537(-2, 1);
   }

   final void method580(int i, int i_8_) {
      if (i != -13) {
         this.aClass61_853 = null;
      }

      ++anInt852;
      synchronized(this.aClass61_853) {
         this.aClass61_853.method598(i_8_, -11819);
      }
   }
}
