public class EntityNode_Sub4 extends EntityNode {
   private static boolean[] aBooleanArray5966 = new boolean[8];
   private Class103 aClass103_5967;
   private long aLong5968;
   private boolean aBoolean5969;
   protected EntityNode_Sub3_Sub2_Sub1[] anEntityNode_Sub3_Sub2_Sub1Array5970;
   private static boolean[] aBooleanArray5971 = new boolean[32];
   protected boolean aBoolean5972 = false;
   private long aLong5973;
   protected int anInt5974;
   private int anInt5975;
   protected Class312 aClass312_5976;
   protected Class198 aClass198_5977;
   protected boolean aBoolean5978;
   protected int anInt5979;
   private boolean aBoolean5980;
   private int anInt5981;

   final void method952(GraphicsToolkit graphicstoolkit, long l, Class300[] class300s, Class218[] class218s, boolean bool) {
      if (!this.aBoolean5972) {
         this.method960(graphicstoolkit, class300s, bool);
         this.method957(class218s, bool);
         this.aLong5973 = l;
      }
   }

   final void method953() {
      this.aBoolean5969 = true;
   }

   final Class198 method954() {
      return this.aClass198_5977;
   }

   final void method955(GraphicsToolkit graphicstoolkit) {
      this.aClass198_5977.aClass87_2429.method1011(12077);

      for(EntityNode_Sub7 entitynode_sub7 = (EntityNode_Sub7)this.aClass103_5967.method1113((byte)112);
         entitynode_sub7 != null;
         entitynode_sub7 = (EntityNode_Sub7)this.aClass103_5967.method1108(82)
      ) {
         entitynode_sub7.method976(this.aLong5968, graphicstoolkit, 0);
      }
   }

   public static void method956() {
      aBooleanArray5971 = null;
      aBooleanArray5966 = null;
   }

   private final void method957(Class218[] class218s, boolean bool) {
      for(int i = 0; i < 8; ++i) {
         aBooleanArray5966[i] = false;
      }

      label71:
      for(CacheNode_Sub5 cachenode_sub5 = (CacheNode_Sub5)this.aClass312_5976.method3613(65280);
         cachenode_sub5 != null;
         cachenode_sub5 = (CacheNode_Sub5)this.aClass312_5976.method3620(16776960)
      ) {
         if (class218s != null) {
            for(int i = 0; i < class218s.length; ++i) {
               if (cachenode_sub5.aClass218_9476 == class218s[i] || cachenode_sub5.aClass218_9476 == class218s[i].aClass218_2561) {
                  aBooleanArray5966[i] = true;
                  cachenode_sub5.method2309((byte)103);
                  continue label71;
               }
            }
         }

         if (!bool) {
            cachenode_sub5.method2160((byte)99);
            --this.anInt5981;
            if (cachenode_sub5.method2276((byte)122)) {
               cachenode_sub5.method2275(-66);
               --Class51_Sub2.anInt9070;
            }
         }
      }

      if (class218s != null) {
         for(int i = 0; i < class218s.length && i != 8 && this.anInt5981 != 8; ++i) {
            if (!aBooleanArray5966[i]) {
               CacheNode_Sub5 cachenode_sub5 = null;
               if (class218s[i].method2075((byte)-57).anInt3160 == 1 && Class51_Sub2.anInt9070 < 32) {
                  cachenode_sub5 = new CacheNode_Sub5(class218s[i], this);
                  Node_Sub41.aClass114_7519.method1156((byte)91, cachenode_sub5, (long)class218s[i].anInt2555);
                  ++Class51_Sub2.anInt9070;
               }

               if (cachenode_sub5 == null) {
                  cachenode_sub5 = new CacheNode_Sub5(class218s[i], this);
               }

               this.aClass312_5976.method3625((byte)-54, cachenode_sub5);
               ++this.anInt5981;
               aBooleanArray5966[i] = true;
            }
         }
      }
   }

   final void method958(long l) {
      this.aLong5973 = l;
   }

   final Class198 method959() {
      this.aClass198_5977.aClass87_2429.method1011(12077);

      for(int i = 0; i < this.anEntityNode_Sub3_Sub2_Sub1Array5970.length; ++i) {
         if (this.anEntityNode_Sub3_Sub2_Sub1Array5970[i] != null && this.anEntityNode_Sub3_Sub2_Sub1Array5970[i].anEntityNode_Sub7_11027 != null) {
            this.aClass198_5977.aClass87_2429.method1012(127, this.anEntityNode_Sub3_Sub2_Sub1Array5970[i]);
         }
      }

      return this.aClass198_5977;
   }

   private final void method960(GraphicsToolkit graphicstoolkit, Class300[] class300s, boolean bool) {
      for(int i = 0; i < 32; ++i) {
         aBooleanArray5971[i] = false;
      }

      label62:
      for(EntityNode_Sub7 entitynode_sub7 = (EntityNode_Sub7)this.aClass103_5967.method1113((byte)125);
         entitynode_sub7 != null;
         entitynode_sub7 = (EntityNode_Sub7)this.aClass103_5967.method1108(117)
      ) {
         if (class300s != null) {
            for(int i = 0; i < class300s.length; ++i) {
               if (entitynode_sub7.aClass300_6003 == class300s[i] || entitynode_sub7.aClass300_6003 == class300s[i].aClass300_3763) {
                  aBooleanArray5971[i] = true;
                  entitynode_sub7.method977((byte)107);
                  entitynode_sub7.aBoolean6012 = false;
                  continue label62;
               }
            }
         }

         if (!bool) {
            if (entitynode_sub7.anInt6004 == 0) {
               entitynode_sub7.method803(false);
               --this.anInt5975;
            } else {
               entitynode_sub7.aBoolean6012 = true;
            }
         }
      }

      if (class300s != null) {
         for(int i = 0; i < class300s.length && i != 32 && this.anInt5975 != 32; ++i) {
            if (!aBooleanArray5971[i]) {
               EntityNode_Sub7 entitynode_sub7 = new EntityNode_Sub7(graphicstoolkit, class300s[i], this, this.aLong5973);
               this.aClass103_5967.method1110(false, entitynode_sub7);
               ++this.anInt5975;
               aBooleanArray5971[i] = true;
            }
         }
      }
   }

   final void method961() {
      this.aBoolean5972 = true;

      for(CacheNode_Sub5 cachenode_sub5 = (CacheNode_Sub5)this.aClass312_5976.method3613(65280);
         cachenode_sub5 != null;
         cachenode_sub5 = (CacheNode_Sub5)this.aClass312_5976.method3620(16776960)
      ) {
         if (cachenode_sub5.aClass249_9473.anInt3160 == 1) {
            cachenode_sub5.method2275(-46);
         }
      }

      for(int i = 0; i < this.anEntityNode_Sub3_Sub2_Sub1Array5970.length; ++i) {
         if (this.anEntityNode_Sub3_Sub2_Sub1Array5970[i] != null) {
            this.anEntityNode_Sub3_Sub2_Sub1Array5970[i].method951();
            this.anEntityNode_Sub3_Sub2_Sub1Array5970[i] = null;
         }
      }

      this.anInt5974 = 0;
      this.aClass103_5967 = new Class103();
      this.anInt5975 = 0;
      this.aClass312_5976 = new Class312();
      this.anInt5981 = 0;
      this.method803(false);
      Class48.anEntityNode_Sub4Array694[Node_Sub28.anInt7327] = this;
      Node_Sub28.anInt7327 = Node_Sub28.anInt7327 + 1 & Class107.anIntArray1359[Node_Sub39.anInt7498];
   }

   final boolean method962(GraphicsToolkit graphicstoolkit, long l) {
      if (this.aLong5973 != this.aLong5968) {
         this.method953();
      } else {
         this.method964();
      }

      if (l - this.aLong5973 > 750L) {
         this.method961();
         return false;
      } else {
         int i = (int)(l - this.aLong5968);
         if (this.aBoolean5980) {
            for(EntityNode_Sub7 entitynode_sub7 = (EntityNode_Sub7)this.aClass103_5967.method1113((byte)112);
               entitynode_sub7 != null;
               entitynode_sub7 = (EntityNode_Sub7)this.aClass103_5967.method1108(127)
            ) {
               for(int i_0_ = 0; i_0_ < entitynode_sub7.aClass355_6011.anInt4358; ++i_0_) {
                  entitynode_sub7.method974(1, (byte)19, !this.aBoolean5969, l, graphicstoolkit);
               }
            }

            this.aBoolean5980 = false;
         }

         for(EntityNode_Sub7 entitynode_sub7 = (EntityNode_Sub7)this.aClass103_5967.method1113((byte)108);
            entitynode_sub7 != null;
            entitynode_sub7 = (EntityNode_Sub7)this.aClass103_5967.method1108(72)
         ) {
            entitynode_sub7.method974(i, (byte)19, !this.aBoolean5969, l, graphicstoolkit);
         }

         this.aLong5968 = l;
         return true;
      }
   }

   static final EntityNode_Sub4 method963(int i, boolean bool) {
      if (Node_Sub28.anInt7327 != Class158.anInt1994) {
         EntityNode_Sub4 entitynode_sub4 = Class48.anEntityNode_Sub4Array694[Class158.anInt1994];
         Class158.anInt1994 = Class158.anInt1994 + 1 & Class107.anIntArray1359[Node_Sub39.anInt7498];
         entitynode_sub4.method966(i, bool);
         return entitynode_sub4;
      } else {
         return new EntityNode_Sub4(i, bool);
      }
   }

   private final void method964() {
      this.aBoolean5969 = false;
   }

   final void method965() {
      this.aBoolean5980 = true;
   }

   private final void method966(int i, boolean bool) {
      Animable_Sub2.aClass103_9116.method1110(false, this);
      this.aLong5973 = (long)i;
      this.aLong5968 = (long)i;
      this.aBoolean5980 = true;
      this.aBoolean5978 = bool;
   }

   final void method967(int i, int i_1_, int i_2_, int i_3_, int i_4_) {
      this.anInt5979 = i;
   }

   private EntityNode_Sub4(int i, boolean bool) {
      this.aBoolean5969 = false;
      this.anInt5974 = 0;
      this.aClass103_5967 = new Class103();
      this.anInt5975 = 0;
      this.aClass312_5976 = new Class312();
      this.aBoolean5980 = false;
      this.aBoolean5978 = false;
      this.anInt5981 = 0;
      this.aClass198_5977 = new Class198();
      this.anEntityNode_Sub3_Sub2_Sub1Array5970 = new EntityNode_Sub3_Sub2_Sub1[8192];
      this.method966(i, bool);
   }
}
