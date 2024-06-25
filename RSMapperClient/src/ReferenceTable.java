import java.util.Random;

public class ReferenceTable {
   static Random aRandom283 = new Random();
   static GLSprite[] aGLSpriteArray284;
   protected int[] anIntArray285;
   static int anInt286;
   protected int[] archives;
   protected Class75[] aClass75Array288;
   private byte[] aByteArray289;
   protected int[][] anIntArrayArray290;
   protected int anInt291;
   protected int revision;
   protected int[] anIntArray293;
   protected int validArchivesCount;
   protected int[] anIntArray295;
   protected int archivesLength;
   static int anInt297;
   protected byte[][] aByteArrayArray298;
   protected int[] anIntArray299;
   protected int[] validArchiveIds;
   protected Class75 aClass75_301;
   static int anInt302;
   protected int[][] nameHashes;

   private final void decodeHeader(byte[] bs, boolean bool) {
      ++anInt297;
      Buffer buffer = new Buffer(Node_Sub38_Sub26.method2875(bs, (byte)-104));
      int i = buffer.readUnsignedByte();
      if (~i <= -6 && i <= 7) {
         if (~i <= -7) {
            this.revision = buffer.readInt();
         } else {
            this.revision = 0;
         }

         int hash = buffer.readUnsignedByte();
         boolean named = (1 & hash) != 0;
         boolean usesWhirlpool = ~(2 & hash) != -1;
         if (i >= 7) {
            this.validArchivesCount = buffer.readBigSmart();
         } else {
            this.validArchivesCount = buffer.readUnsignedShort();
         }

         int i_3_ = 0;
         int biggestArchiveId = -1;
         this.validArchiveIds = new int[this.validArchivesCount];
         if (~i <= -8) {
            for(int i_5_ = 0; this.validArchivesCount > i_5_; ++i_5_) {
               this.validArchiveIds[i_5_] = i_3_ += buffer.readBigSmart();
               if (~this.validArchiveIds[i_5_] < ~biggestArchiveId) {
                  biggestArchiveId = this.validArchiveIds[i_5_];
               }
            }
         } else {
            for(int index = 0; ~this.validArchivesCount < ~index; ++index) {
               this.validArchiveIds[index] = i_3_ += buffer.readUnsignedShort();
               if (~biggestArchiveId > ~this.validArchiveIds[index]) {
                  biggestArchiveId = this.validArchiveIds[index];
               }
            }
         }

         this.archivesLength = biggestArchiveId + 1;
         this.anIntArray299 = new int[this.archivesLength];
         if (usesWhirlpool) {
            this.aByteArrayArray298 = new byte[this.archivesLength][];
         }

         this.anIntArray293 = new int[this.archivesLength];
         this.anIntArray285 = new int[this.archivesLength];
         this.anIntArray295 = new int[this.archivesLength];
         this.anIntArrayArray290 = new int[this.archivesLength][];
         if (named) {
            this.archives = new int[this.archivesLength];

            for(int i_7_ = 0; ~this.archivesLength < ~i_7_; ++i_7_) {
               this.archives[i_7_] = -1;
            }

            for(int i_8_ = 0; ~this.validArchivesCount < ~i_8_; ++i_8_) {
               this.archives[this.validArchiveIds[i_8_]] = buffer.readInt();
            }

            this.aClass75_301 = new Class75(this.archives);
         }

         for(int i_9_ = 0; ~this.validArchivesCount < ~i_9_; ++i_9_) {
            this.anIntArray299[this.validArchiveIds[i_9_]] = buffer.readInt();
         }

         if (usesWhirlpool) {
            for(int i_10_ = 0; ~i_10_ > ~this.validArchivesCount; ++i_10_) {
               byte[] bs_11_ = new byte[64];
               buffer.readBytes(bs_11_, 0, 64);
               this.aByteArrayArray298[this.validArchiveIds[i_10_]] = bs_11_;
            }
         }

         for(int i_12_ = 0; ~i_12_ > ~this.validArchivesCount; ++i_12_) {
            this.anIntArray293[this.validArchiveIds[i_12_]] = buffer.readInt();
         }

         if (~i > -8) {
            for(int i_13_ = 0; ~i_13_ > ~this.validArchivesCount; ++i_13_) {
               this.anIntArray295[this.validArchiveIds[i_13_]] = buffer.readUnsignedShort();
            }

            for(int i_14_ = 0; i_14_ < this.validArchivesCount; ++i_14_) {
               int i_15_ = this.validArchiveIds[i_14_];
               i_3_ = 0;
               int i_16_ = this.anIntArray295[i_15_];
               int i_17_ = -1;
               this.anIntArrayArray290[i_15_] = new int[i_16_];

               for(int i_18_ = 0; i_18_ < i_16_; ++i_18_) {
                  int i_19_ = this.anIntArrayArray290[i_15_][i_18_] = i_3_ += buffer.readUnsignedShort();
                  if (~i_17_ > ~i_19_) {
                     i_17_ = i_19_;
                  }
               }

               this.anIntArray285[i_15_] = 1 + i_17_;
               if (i_16_ == i_17_ + 1) {
                  this.anIntArrayArray290[i_15_] = null;
               }
            }
         } else {
            for(int i_20_ = 0; this.validArchivesCount > i_20_; ++i_20_) {
               this.anIntArray295[this.validArchiveIds[i_20_]] = buffer.readBigSmart();
            }

            for(int i_21_ = 0; ~this.validArchivesCount < ~i_21_; ++i_21_) {
               int i_22_ = this.validArchiveIds[i_21_];
               int i_23_ = this.anIntArray295[i_22_];
               i_3_ = 0;
               int i_24_ = -1;
               this.anIntArrayArray290[i_22_] = new int[i_23_];

               for(int i_25_ = 0; i_23_ > i_25_; ++i_25_) {
                  int i_26_ = this.anIntArrayArray290[i_22_][i_25_] = i_3_ += buffer.readBigSmart();
                  if (~i_26_ < ~i_24_) {
                     i_24_ = i_26_;
                  }
               }

               this.anIntArray285[i_22_] = i_24_ - -1;
               if (1 + i_24_ == i_23_) {
                  this.anIntArrayArray290[i_22_] = null;
               }
            }
         }

         if (named) {
            this.aClass75Array288 = new Class75[1 + biggestArchiveId];
            this.nameHashes = new int[1 + biggestArchiveId][];

            for(int i_27_ = 0; i_27_ < this.validArchivesCount; ++i_27_) {
               int i_28_ = this.validArchiveIds[i_27_];
               int i_29_ = this.anIntArray295[i_28_];
               this.nameHashes[i_28_] = new int[this.anIntArray285[i_28_]];

               for(int i_30_ = 0; ~this.anIntArray285[i_28_] < ~i_30_; ++i_30_) {
                  this.nameHashes[i_28_][i_30_] = -1;
               }

               for(int i_31_ = 0; ~i_29_ < ~i_31_; ++i_31_) {
                  int i_32_;
                  if (this.anIntArrayArray290[i_28_] != null) {
                     i_32_ = this.anIntArrayArray290[i_28_][i_31_];
                  } else {
                     i_32_ = i_31_;
                  }

                  this.nameHashes[i_28_][i_32_] = buffer.readInt();
               }

               this.aClass75Array288[i_28_] = new Class75(this.nameHashes[i_28_]);
            }
         }

         if (bool) {
            method264(-19);
         }
      } else {
         throw new RuntimeException();
      }
   }

   public static void method264(int i) {
      aRandom283 = null;
      if (i < 108) {
         anInt286 = -16;
      }

      aGLSpriteArray284 = null;
   }

   ReferenceTable(byte[] bs, int i, byte[] bs_33_) {
      this.anInt291 = Class66_Sub2_Sub1.method728(bs.length, false, bs);
      if (~i != ~this.anInt291) {
         throw new RuntimeException();
      } else {
         if (bs_33_ != null) {
            if (bs_33_.length != 64) {
               throw new RuntimeException();
            }

            this.aByteArray289 = GLXToolkit.generateWhirpoolHash((byte)119, bs, bs.length, 0);

            for(int i_34_ = 0; i_34_ < 64; ++i_34_) {
               if (~bs_33_[i_34_] != ~this.aByteArray289[i_34_]) {
                  throw new RuntimeException();
               }
            }
         }

         this.decodeHeader(bs, false);
      }
   }
}
