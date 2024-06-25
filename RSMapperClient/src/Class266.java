import com.dropbox.core.v2.DbxClientV2;
import java.io.IOException;

public class Class266 {
   static int anInt3368;
   static int anInt3369;
   static int anInt3370;
   static int anInt3371;
   static int anInt3372;
   static int anInt3373;
   static int anInt3374;
   static int anInt3375;
   static int anInt3376;
   static int anInt3377;
   static int anInt3378;
   static int anInt3379;
   static HashTable aHashTable3380 = new HashTable(64);
   static int anInt3381;
   static int anInt3382;
   static int anInt3383;
   private Class158 aClass158_3384 = new Class158();
   static boolean aBoolean3385;
   private Class158 aClass158_3386 = new Class158();
   private Class158 aClass158_3387 = new Class158();
   private Class158 aClass158_3388 = new Class158();
   private BufferedConnection aBufferedConnection3389;
   private int anInt3390;
   private long aLong3391;
   private Buffer aBuffer3392 = new Buffer(6);
   volatile int anInt3393;
   volatile int anInt3394 = 0;
   private byte encryptValue;
   private Buffer aBuffer3396;
   private CacheNode_Sub16_Sub1 aCacheNode_Sub16_Sub1_3397;
   public static DbxClientV2 aHashTable1923 = null;

   final void method3233(byte b) {
      try {
         this.aBufferedConnection3389.method430(20692);
      } catch (Exception var3) {
      }

      ++anInt3373;
      this.aBufferedConnection3389 = null;
      if (b != 98) {
         this.aClass158_3386 = null;
      }

      ++this.anInt3394;
   }

   private final void method3234(byte b) {
      ++anInt3371;
      if (this.aBufferedConnection3389 != null) {
         try {
            this.aBuffer3392.offset = 0;
            this.aBuffer3392.writeByte(6);
            this.aBuffer3392.write24BitInt((byte)109, 3);
            this.aBufferedConnection3389.method429(0, 4, this.aBuffer3392.buffer, (byte)78);
         } catch (IOException var5) {
            try {
               this.aBufferedConnection3389.method430(20692);
            } catch (Exception var4) {
            }

            ++this.anInt3394;
            this.anInt3393 = -2;
            this.aBufferedConnection3389 = null;
         }

         if (b != 0) {
            method3243(-90, null);
         }
      }
   }

   final void method3235(boolean bool) {
      if (bool) {
         this.method3235(false);
      }

      if (this.aBufferedConnection3389 != null) {
         this.aBufferedConnection3389.method430(20692);
      }

      ++anInt3377;
   }

   final int method3236(int i) {
      if (i != 0) {
         return 87;
      } else {
         ++anInt3375;
         return this.aClass158_3384.method1720((byte)-122) + this.aClass158_3386.method1720((byte)20);
      }
   }

   static final void method3237(int i, GraphicsToolkit graphicstoolkit) {
      for(EntityNode_Sub4 entitynode_sub4 = (EntityNode_Sub4)Animable_Sub2.aClass103_9116.method1113((byte)-45);
         entitynode_sub4 != null;
         entitynode_sub4 = (EntityNode_Sub4)Animable_Sub2.aClass103_9116.method1108(65)
      ) {
         if (entitynode_sub4.aBoolean5978) {
            entitynode_sub4.method955(graphicstoolkit);
         }
      }

      ++anInt3374;
      if (i != 0) {
         aHashTable3380 = null;
      }
   }

   final boolean method3238(byte b) {
      if (this.aBufferedConnection3389 != null) {
         long l = Class313.method3650(false);
         int i = (int)(-this.aLong3391 + l);
         this.aLong3391 = l;
         if (i > 200) {
            i = 200;
         }

         this.anInt3390 += i;
         if (~this.anInt3390 < -30001) {
            try {
               this.aBufferedConnection3389.method430(b + 20622);
            } catch (Exception var19) {
            }

            this.aBufferedConnection3389 = null;
         }
      }

      ++anInt3379;
      if (this.aBufferedConnection3389 == null) {
         return this.method3236(b ^ 70) == 0 && ~this.method3246((byte)111) == -1;
      } else {
         try {
            this.aBufferedConnection3389.method423(-1650936088);
            CacheNode_Sub16_Sub1 cachenode_sub16_sub1 = (CacheNode_Sub16_Sub1)this.aClass158_3384.method1723(13);
            if (b != 70) {
               this.aClass158_3386 = null;
            }

            while(cachenode_sub16_sub1 != null) {
               this.aBuffer3392.offset = 0;
               this.aBuffer3392.writeByte(1);
               int indexId = (int)(cachenode_sub16_sub1.aLong7037 >> 32);
               int archiveId = (int)(cachenode_sub16_sub1.aLong7037 - ((long)indexId << 32));
               this.aBuffer3392.writeByte(indexId);
               this.aBuffer3392.writeInt(archiveId);
               this.aBufferedConnection3389.method429(0, 6, this.aBuffer3392.buffer, (byte)78);
               this.aClass158_3386.method1719(true, cachenode_sub16_sub1);
               cachenode_sub16_sub1 = (CacheNode_Sub16_Sub1)this.aClass158_3384.method1721(0);
            }

            for(CacheNode_Sub16_Sub1 cachenode_sub16_sub1_0_ = (CacheNode_Sub16_Sub1)this.aClass158_3387.method1723(b ^ 75);
               cachenode_sub16_sub1_0_ != null;
               cachenode_sub16_sub1_0_ = (CacheNode_Sub16_Sub1)this.aClass158_3387.method1721(0)
            ) {
               this.aBuffer3392.offset = 0;
               this.aBuffer3392.writeByte(0);
               int indexId = (int)(cachenode_sub16_sub1_0_.aLong7037 >> 32);
               int archiveId = (int)(cachenode_sub16_sub1_0_.aLong7037 - ((long)indexId << 32));
               this.aBuffer3392.writeByte(indexId);
               this.aBuffer3392.writeInt(archiveId);
               this.aBufferedConnection3389.method429(0, 6, this.aBuffer3392.buffer, (byte)78);
               this.aClass158_3388.method1719(true, cachenode_sub16_sub1_0_);
            }

            for(int i = 0; i < 100; ++i) {
               int i_1_ = this.aBufferedConnection3389.method428(0);
               if (i_1_ < 0) {
                  throw new IOException();
               }

               if (i_1_ == 0) {
                  break;
               }

               this.anInt3390 = 0;
               int i_2_ = 0;
               if (this.aCacheNode_Sub16_Sub1_3397 == null) {
                  i_2_ = 10;
               } else if (this.aCacheNode_Sub16_Sub1_3397.position == 0) {
                  i_2_ = 1;
               }

               if (i_2_ > 0) {
                  int i_3_ = -this.aBuffer3396.offset + i_2_;
                  if (i_1_ < i_3_) {
                     i_3_ = i_1_;
                  }

                  this.aBufferedConnection3389.method425(i_3_, (byte)48, this.aBuffer3396.offset, this.aBuffer3396.buffer);
                  if (this.encryptValue != 0) {
                     for(int i_4_ = 0; ~i_4_ > ~i_3_; ++i_4_) {
                        this.aBuffer3396.buffer[this.aBuffer3396.offset - -i_4_] = (byte)Node_Sub19.method2612(
                           this.aBuffer3396.buffer[this.aBuffer3396.offset + i_4_], this.encryptValue
                        );
                     }
                  }

                  this.aBuffer3396.offset += i_3_;
                  if (i_2_ <= this.aBuffer3396.offset) {
                     if (this.aCacheNode_Sub16_Sub1_3397 == null) {
                        this.aBuffer3396.offset = 0;
                        int indexId = this.aBuffer3396.readUnsignedByte();
                        int archiveId = this.aBuffer3396.readInt();
                        int settings = this.aBuffer3396.readUnsignedByte();
                        int size = this.aBuffer3396.readInt();
                        int compression = 127 & settings;
                        boolean noPriority = ~(settings & 128) != -1;
                        long l = (long)archiveId + ((long)indexId << 32);
                        Object object = null;
                        CacheNode_Sub16_Sub1 cachenode_sub16_sub1_10_;
                        if (!noPriority) {
                           cachenode_sub16_sub1_10_ = (CacheNode_Sub16_Sub1)this.aClass158_3386.method1723(13);

                           while(cachenode_sub16_sub1_10_ != null && ~cachenode_sub16_sub1_10_.aLong7037 != ~l) {
                              cachenode_sub16_sub1_10_ = (CacheNode_Sub16_Sub1)this.aClass158_3386.method1721(0);
                           }
                        } else {
                           cachenode_sub16_sub1_10_ = (CacheNode_Sub16_Sub1)this.aClass158_3388.method1723(13);

                           while(cachenode_sub16_sub1_10_ != null && ~cachenode_sub16_sub1_10_.aLong7037 != ~l) {
                              cachenode_sub16_sub1_10_ = (CacheNode_Sub16_Sub1)this.aClass158_3388.method1721(0);
                           }
                        }

                        if (cachenode_sub16_sub1_10_ == null) {
                           throw new IOException();
                        }

                        this.aCacheNode_Sub16_Sub1_3397 = cachenode_sub16_sub1_10_;
                        int i_11_ = ~compression != -1 ? 9 : 5;
                        this.aCacheNode_Sub16_Sub1_3397.aBuffer11072 = new Buffer(i_11_ + size - -this.aCacheNode_Sub16_Sub1_3397.aByte11069);
                        this.aCacheNode_Sub16_Sub1_3397.aBuffer11072.writeByte(compression);
                        this.aCacheNode_Sub16_Sub1_3397.aBuffer11072.writeInt(size);
                        this.aCacheNode_Sub16_Sub1_3397.position = 10;
                        this.aBuffer3396.offset = 0;
                     } else {
                        if (this.aCacheNode_Sub16_Sub1_3397.position != 0) {
                           throw new IOException();
                        }

                        if (this.aBuffer3396.buffer[0] != -1) {
                           this.aCacheNode_Sub16_Sub1_3397 = null;
                        } else {
                           this.aBuffer3396.offset = 0;
                           this.aCacheNode_Sub16_Sub1_3397.position = 1;
                        }
                     }
                  }
               } else {
                  int i_12_ = -this.aCacheNode_Sub16_Sub1_3397.aByte11069 + this.aCacheNode_Sub16_Sub1_3397.aBuffer11072.buffer.length;
                  int i_13_ = 512 - this.aCacheNode_Sub16_Sub1_3397.position;
                  if (~i_13_ < ~(-this.aCacheNode_Sub16_Sub1_3397.aBuffer11072.offset + i_12_)) {
                     i_13_ = -this.aCacheNode_Sub16_Sub1_3397.aBuffer11072.offset + i_12_;
                  }

                  if (i_13_ > i_1_) {
                     i_13_ = i_1_;
                  }

                  this.aBufferedConnection3389
                     .method425(i_13_, (byte)67, this.aCacheNode_Sub16_Sub1_3397.aBuffer11072.offset, this.aCacheNode_Sub16_Sub1_3397.aBuffer11072.buffer);
                  if (~this.encryptValue != -1) {
                     for(int i_14_ = 0; i_14_ < i_13_; ++i_14_) {
                        this.aCacheNode_Sub16_Sub1_3397.aBuffer11072.buffer[this.aCacheNode_Sub16_Sub1_3397.aBuffer11072.offset - -i_14_] = (byte)Node_Sub19.method2612(
                           this.aCacheNode_Sub16_Sub1_3397.aBuffer11072.buffer[this.aCacheNode_Sub16_Sub1_3397.aBuffer11072.offset + i_14_], this.encryptValue
                        );
                     }
                  }

                  this.aCacheNode_Sub16_Sub1_3397.aBuffer11072.offset += i_13_;
                  this.aCacheNode_Sub16_Sub1_3397.position += i_13_;
                  if (~i_12_ == ~this.aCacheNode_Sub16_Sub1_3397.aBuffer11072.offset) {
                     this.aCacheNode_Sub16_Sub1_3397.method2275(-65);
                     this.aCacheNode_Sub16_Sub1_3397.aBoolean9602 = false;
                     this.aCacheNode_Sub16_Sub1_3397 = null;
                  } else if (this.aCacheNode_Sub16_Sub1_3397.position == 512) {
                     this.aCacheNode_Sub16_Sub1_3397.position = 0;
                  }
               }
            }

            return true;
         } catch (IOException var20) {
            try {
               this.aBufferedConnection3389.method430(b + 20622);
            } catch (Exception var18) {
            }

            this.aBufferedConnection3389 = null;
            ++this.anInt3394;
            this.anInt3393 = -2;
            return this.method3236(0) == 0 && ~this.method3246((byte)71) == -1;
         }
      }
   }

   final boolean method3239(int i) {
      if (i != 255) {
         return false;
      } else {
         ++anInt3376;
         return ~this.method3246((byte)121) <= -21;
      }
   }

   final void method3240(boolean bool, int i) {
      ++anInt3378;
      if (this.aBufferedConnection3389 != null) {
         try {
            this.aBuffer3392.offset = i;
            this.aBuffer3392.writeByte(bool ? 2 : 3);
            this.aBuffer3392.write24BitInt((byte)85, 0);
            this.aBufferedConnection3389.method429(0, 4, this.aBuffer3392.buffer, (byte)78);
         } catch (IOException var6) {
            try {
               this.aBufferedConnection3389.method430(20692);
            } catch (Exception var5) {
            }

            this.aBufferedConnection3389 = null;
            this.anInt3393 = -2;
            ++this.anInt3394;
         }
      }
   }

   final void method3241(boolean bool, int i, BufferedConnection bufferedconnection) {
      ++anInt3370;
      if (this.aBufferedConnection3389 != null) {
         try {
            this.aBufferedConnection3389.method430(20692);
         } catch (Exception var8) {
         }

         this.aBufferedConnection3389 = null;
      }

      this.aBufferedConnection3389 = bufferedconnection;
      if (i >= -7) {
         this.method3234((byte)-124);
      }

      this.method3234((byte)0);
      this.method3240(bool, 0);
      this.aCacheNode_Sub16_Sub1_3397 = null;
      this.aBuffer3396.offset = 0;

      while(true) {
         CacheNode_Sub16_Sub1 cachenode_sub16_sub1 = (CacheNode_Sub16_Sub1)this.aClass158_3386.method1717(-119);
         if (cachenode_sub16_sub1 == null) {
            while(true) {
               cachenode_sub16_sub1 = (CacheNode_Sub16_Sub1)this.aClass158_3388.method1717(-128);
               if (cachenode_sub16_sub1 == null) {
                  if (this.encryptValue != 0) {
                     try {
                        this.aBuffer3392.offset = 0;
                        this.aBuffer3392.writeByte(4);
                        this.aBuffer3392.writeByte(this.encryptValue);
                        this.aBuffer3392.writeShort(0);
                        this.aBufferedConnection3389.method429(0, 4, this.aBuffer3392.buffer, (byte)78);
                     } catch (IOException var7) {
                        try {
                           this.aBufferedConnection3389.method430(20692);
                        } catch (Exception var6) {
                        }

                        ++this.anInt3394;
                        this.aBufferedConnection3389 = null;
                        this.anInt3393 = -2;
                     }
                  }

                  this.anInt3390 = 0;
                  this.aLong3391 = Class313.method3650(false);
                  return;
               }

               this.aClass158_3387.method1719(true, cachenode_sub16_sub1);
            }
         }

         this.aClass158_3384.method1719(true, cachenode_sub16_sub1);
      }
   }

   final void method3242(int i) {
      ++anInt3369;
      if (this.aBufferedConnection3389 != null) {
         try {
            this.aBuffer3392.offset = 0;
            this.aBuffer3392.writeByte(7);
            if (i >= -104) {
               this.method3244(-53);
            }

            this.aBuffer3392.write24BitInt((byte)65, 0);
            this.aBufferedConnection3389.method429(0, 4, this.aBuffer3392.buffer, (byte)78);
         } catch (IOException var5) {
            try {
               this.aBufferedConnection3389.method430(20692);
            } catch (Exception var4) {
            }

            this.aBufferedConnection3389 = null;
            this.anInt3393 = -2;
            ++this.anInt3394;
         }
      }
   }

   static final int method3243(int i, Npc npc) {
      ++anInt3383;
      NpcDefinition npcdefinition = npc.definitions;
      if (npcdefinition.anIntArray2827 != null) {
         npcdefinition = npcdefinition.method2999(65535, Class24.aClass275_442);
         if (npcdefinition == null) {
            return -1;
         }
      }

      int i_15_ = npcdefinition.anInt2809;
      if (i > -25) {
         return -110;
      } else {
         RenderDefinitions class259 = npc.method868((byte)-124);
         int i_16_ = npc.anAnimator10860.getAnimationId();
         if (i_16_ != -1 && !npc.aBoolean10867) {
            if (class259.anInt3252 == i_16_ || class259.anInt3271 == i_16_ || ~class259.anInt3293 == ~i_16_ || ~i_16_ == ~class259.anInt3270) {
               i_15_ = npcdefinition.anInt2810;
            } else if (class259.anInt3262 == i_16_ || ~i_16_ == ~class259.anInt3297 || ~class259.anInt3304 == ~i_16_ || ~class259.anInt3269 == ~i_16_) {
               i_15_ = npcdefinition.anInt2833;
            }
         } else {
            i_15_ = npcdefinition.anInt2812;
         }

         return i_15_;
      }
   }

   final boolean method3244(int i) {
      if (i != 24365) {
         this.encryptValue = -93;
      }

      ++anInt3368;
      return ~this.method3236(0) <= -21;
   }

   final void method3245(int i) {
      if (i != -2) {
         this.anInt3394 = 79;
      }

      if (this.aBufferedConnection3389 != null) {
         this.aBufferedConnection3389.method426((byte)-120);
      }

      ++anInt3382;
   }

   private final int method3246(byte b) {
      ++anInt3381;
      return b < 31 ? -79 : this.aClass158_3387.method1720((byte)86) - -this.aClass158_3388.method1720((byte)-95);
   }

   final CacheNode_Sub16_Sub1 method3247(int i, int i_17_, byte b, boolean bool, byte b_18_) {
      ++anInt3372;
      if (b != -79) {
         this.method3236(-28);
      }

      long l = ((long)i << 32) + (long)i_17_;
      CacheNode_Sub16_Sub1 cachenode_sub16_sub1 = new CacheNode_Sub16_Sub1();
      cachenode_sub16_sub1.aBoolean9598 = bool;
      cachenode_sub16_sub1.aByte11069 = b_18_;
      cachenode_sub16_sub1.aLong7037 = l;
      if (bool) {
         if (~this.method3236(0) <= -21) {
            throw new RuntimeException();
         }

         this.aClass158_3384.method1719(true, cachenode_sub16_sub1);
      } else {
         if (this.method3246((byte)85) >= 20) {
            throw new RuntimeException();
         }

         this.aClass158_3387.method1719(true, cachenode_sub16_sub1);
      }

      return cachenode_sub16_sub1;
   }

   public static void method3248(int i) {
      aHashTable3380 = null;
      if (i != 0) {
         method3248(-48);
      }
   }

   public Class266() {
      this.anInt3393 = 0;
      this.encryptValue = 0;
      this.aBuffer3396 = new Buffer(10);
   }
}
