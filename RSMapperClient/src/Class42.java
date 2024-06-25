import java.awt.Component;

class Class42 {
   static int anInt629;
   static int anInt630;
   static Class122 aClass122_631;
   static int anInt632;
   static int anInt633;
   static int anInt634;
   private int anInt635 = 32;
   static int anInt636;
   static int anInt637;
   static int anInt638;
   static int anInt639;
   static int anInt640;
   private long aLong641;
   protected int[] anIntArray642;
   static Class181 aClass181_643;
   static int anInt644;
   static int[] undermapArchiveIds;
   static int anInt646;
   private boolean aBoolean647 = false;
   static int anInt648;
   static int anInt649 = 16777215;
   private Node_Sub9 aNode_Sub9_650;
   protected int anInt651;
   private Node_Sub9[] aNode_Sub9Array652;
   protected int anInt653;
   private long aLong654;
   private int anInt655;
   private boolean aBoolean656;
   private int anInt657;
   private int anInt658;
   private Node_Sub9[] aNode_Sub9Array659;
   private long aLong660;
   private int anInt661;
   private int anInt662;

   final synchronized void method441(int i, Node_Sub9 node_sub9) {
      ++anInt630;
      this.aNode_Sub9_650 = node_sub9;
      if (i != 11757) {
         this.anInt635 = -102;
      }
   }

   void method442() throws Exception {
      ++anInt629;
   }

   private final void method443(int i, int i_0_) {
      this.anInt655 -= i_0_;
      ++anInt634;
      if (i == -26994) {
         if (~this.anInt655 > -1) {
            this.anInt655 = 0;
         }

         if (this.aNode_Sub9_650 != null) {
            this.aNode_Sub9_650.method2426(i_0_);
         }
      }
   }

   static final int method444(long l, boolean bool) {
      ++anInt637;
      return bool ? 123 : (int)(l / 86400000L) + -11745;
   }

   final synchronized void method445(int i) {
      if (i != 3) {
         this.aNode_Sub9Array659 = null;
      }

      if (IComponentDefinitions.aClass92_4845 != null) {
         boolean bool = true;

         for(int i_1_ = 0; i_1_ < 2; ++i_1_) {
            if (IComponentDefinitions.aClass92_4845.aClass42Array1234[i_1_] == this) {
               IComponentDefinitions.aClass92_4845.aClass42Array1234[i_1_] = null;
            }

            if (IComponentDefinitions.aClass92_4845.aClass42Array1234[i_1_] != null) {
               bool = false;
            }
         }

         if (bool) {
            IComponentDefinitions.aClass92_4845.aBoolean1231 = true;

            while(IComponentDefinitions.aClass92_4845.aBoolean1232) {
               Class262_Sub22.method3208(50L, false);
            }

            IComponentDefinitions.aClass92_4845 = null;
         }
      }

      ++anInt639;
      this.method455();
      this.anIntArray642 = null;
      this.aBoolean647 = true;
   }

   int method446() throws Exception {
      ++anInt648;
      return this.anInt651;
   }

   void method447(int i) throws Exception {
      ++anInt633;
   }

   public static void method448(int i) {
      aClass122_631 = null;
      int i_2_ = 120 / ((2 - i) / 34);
      aClass181_643 = null;
      undermapArchiveIds = null;
   }

   void method449() throws Exception {
      ++anInt640;
   }

   private final void method450(boolean bool, int i, Node_Sub9 node_sub9) {
      ++anInt636;
      int i_3_ = i >> 5;
      Node_Sub9 node_sub9_4_ = this.aNode_Sub9Array652[i_3_];
      if (bool) {
         this.method441(51, null);
      }

      if (node_sub9_4_ == null) {
         this.aNode_Sub9Array659[i_3_] = node_sub9;
      } else {
         node_sub9_4_.aNode_Sub9_7072 = node_sub9;
      }

      this.aNode_Sub9Array652[i_3_] = node_sub9;
      node_sub9.anInt7073 = i;
   }

   final synchronized void method451(byte b) {
      ++anInt644;
      this.aBoolean656 = true;
      if (b != -50) {
         this.method443(91, 24);
      }

      try {
         this.method442();
      } catch (Exception var3) {
         this.method455();
         this.aLong654 = Class313.method3650(false) - -2000L;
      }
   }

   void method452(Component component) throws Exception {
      ++anInt638;
   }

   final synchronized void method453(byte b) {
      ++anInt632;
      if (!this.aBoolean647) {
         long l = Class313.method3650(false);

         try {
            if (this.aLong641 + 6000L < l) {
               this.aLong641 = l - 6000L;
            }

            while(~l < ~(5000L + this.aLong641)) {
               this.method443(-26994, 256);
               this.aLong641 += (long)(256000 / Class365.anInt4523);
               l = Class313.method3650(false);
            }
         } catch (Exception var7) {
            this.aLong641 = l;
         }

         if (this.anIntArray642 != null) {
            try {
               if (~this.aLong654 != -1L) {
                  if (~this.aLong654 < ~l) {
                     return;
                  }

                  this.method447(this.anInt651);
                  this.aLong654 = 0L;
                  this.aBoolean656 = true;
               }

               int i = this.method446();
               if (-i + this.anInt657 > this.anInt658) {
                  this.anInt658 = this.anInt657 + -i;
               }

               int i_5_ = this.anInt653 + this.anInt662;
               if (~(256 + i_5_) < -16385) {
                  i_5_ = 16128;
               }

               if (this.anInt651 < i_5_ + 256) {
                  this.anInt651 += 1024;
                  if (this.anInt651 > 16384) {
                     this.anInt651 = 16384;
                  }

                  this.method455();
                  this.method447(this.anInt651);
                  i = 0;
                  if (~this.anInt651 > ~(i_5_ - -256)) {
                     i_5_ = -256 + this.anInt651;
                     this.anInt662 = i_5_ + -this.anInt653;
                  }

                  this.aBoolean656 = true;
               }

               while(i_5_ > i) {
                  this.method454(this.anIntArray642, 256);
                  i += 256;
                  this.method449();
               }

               if (l > this.aLong660) {
                  if (this.aBoolean656) {
                     this.aBoolean656 = false;
                  } else {
                     if (~this.anInt658 == -1 && ~this.anInt661 == -1) {
                        this.method455();
                        this.aLong654 = 2000L + l;
                        return;
                     }

                     this.anInt662 = Math.min(this.anInt661, this.anInt658);
                     this.anInt661 = this.anInt658;
                  }

                  this.aLong660 = 2000L + l;
                  this.anInt658 = 0;
               }

               if (b >= -98) {
                  this.method441(66, null);
               }

               this.anInt657 = i;
            } catch (Exception var6) {
               this.method455();
               this.aLong654 = 2000L + l;
            }
         }
      }
   }

   private final void method454(int[] is, int i) {
      int i_6_ = i;
      if (DrawableModel.aBoolean913) {
         i_6_ = i << 1;
      }

      Class311.method3602(is, 0, i_6_);
      this.anInt655 -= i;
      if (this.aNode_Sub9_650 != null && this.anInt655 <= 0) {
         this.anInt655 += Class365.anInt4523 >> 4;
         Class320_Sub19.method3755(-729073628, this.aNode_Sub9_650);
         this.method450(false, this.aNode_Sub9_650.method2432(), this.aNode_Sub9_650);
         int i_7_ = 0;
         int i_8_ = 255;

         label104:
         for(int i_9_ = 7; i_8_ != 0; --i_9_) {
            int i_10_;
            int i_11_;
            if (i_9_ < 0) {
               i_10_ = i_9_ & 3;
               i_11_ = -(i_9_ >> 2);
            } else {
               i_10_ = i_9_;
               i_11_ = 0;
            }

            for(int i_12_ = i_8_ >>> i_10_ & 286331153; i_12_ != 0; i_12_ >>>= 4) {
               if ((i_12_ & 1) != 0) {
                  i_8_ &= ~(1 << i_10_);
                  Node_Sub9 node_sub9 = null;
                  Node_Sub9 node_sub9_13_ = this.aNode_Sub9Array659[i_10_];

                  while(node_sub9_13_ != null) {
                     Node_Sub45 node_sub45 = node_sub9_13_.aNode_Sub45_7075;
                     if (node_sub45 != null && node_sub45.anInt7552 > i_11_) {
                        i_8_ |= 1 << i_10_;
                        node_sub9 = node_sub9_13_;
                        node_sub9_13_ = node_sub9_13_.aNode_Sub9_7072;
                     } else {
                        node_sub9_13_.aBoolean7074 = true;
                        int i_14_ = node_sub9_13_.method2428();
                        i_7_ += i_14_;
                        if (node_sub45 != null) {
                           node_sub45.anInt7552 += i_14_;
                        }

                        if (i_7_ >= this.anInt635) {
                           break label104;
                        }

                        Node_Sub9 node_sub9_15_ = node_sub9_13_.method2429();
                        if (node_sub9_15_ != null) {
                           for(int i_16_ = node_sub9_13_.anInt7073; node_sub9_15_ != null; node_sub9_15_ = node_sub9_13_.method2431()) {
                              this.method450(false, i_16_ * node_sub9_15_.method2432() >> 8, node_sub9_15_);
                           }
                        }

                        Node_Sub9 node_sub9_17_ = node_sub9_13_.aNode_Sub9_7072;
                        node_sub9_13_.aNode_Sub9_7072 = null;
                        if (node_sub9 == null) {
                           this.aNode_Sub9Array659[i_10_] = node_sub9_17_;
                        } else {
                           node_sub9.aNode_Sub9_7072 = node_sub9_17_;
                        }

                        if (node_sub9_17_ == null) {
                           this.aNode_Sub9Array652[i_10_] = node_sub9;
                        }

                        node_sub9_13_ = node_sub9_17_;
                     }
                  }
               }

               i_10_ += 4;
               ++i_11_;
            }
         }

         for(int i_18_ = 0; i_18_ < 8; ++i_18_) {
            Node_Sub9 node_sub9 = this.aNode_Sub9Array659[i_18_];

            Node_Sub9 node_sub9_19_;
            for(this.aNode_Sub9Array659[i_18_] = this.aNode_Sub9Array652[i_18_] = null; node_sub9 != null; node_sub9 = node_sub9_19_) {
               node_sub9_19_ = node_sub9.aNode_Sub9_7072;
               node_sub9.aNode_Sub9_7072 = null;
            }
         }
      }

      if (this.anInt655 < 0) {
         this.anInt655 = 0;
      }

      if (this.aNode_Sub9_650 != null) {
         this.aNode_Sub9_650.method2427(is, 0, i);
      }

      this.aLong641 = Class313.method3650(false);
   }

   void method455() {
      ++anInt646;
   }

   public Class42() {
      this.aLong641 = Class313.method3650(false);
      this.aLong654 = 0L;
      this.anInt655 = 0;
      this.aNode_Sub9Array652 = new Node_Sub9[8];
      this.anInt658 = 0;
      this.anInt657 = 0;
      this.aLong660 = 0L;
      this.aBoolean656 = true;
      this.aNode_Sub9Array659 = new Node_Sub9[8];
      this.anInt661 = 0;
   }
}
