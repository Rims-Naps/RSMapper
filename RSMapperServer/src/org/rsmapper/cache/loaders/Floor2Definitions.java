package org.rsmapper.cache.loaders;

import java.util.concurrent.ConcurrentHashMap;
import org.rsmapper.cache.Cache;
import org.rsmapper.networking.codec.stream.InputStream;

public final class Floor2Definitions {
   private static final ConcurrentHashMap<Integer, Floor2Definitions> defs = new ConcurrentHashMap();
   public int anInt6318 = -1;
   int anInt6319;
   public int color;
   public int anInt6321 = -1;
   public int anInt6322 = -1;
   public int secondaryColor = -1;
   public int anInt6325 = -1;
   public int anInt6326 = -1;
   public boolean aBool6327 = false;
   public int anInt6328 = -1;
   public int anInt6329 = -1;
   public int anInt6330 = -1;
   public boolean aBool6331 = true;
   public int anInt6332;
   public boolean aBool6333 = true;
   private int id;

   public int getId() {
      return this.id;
   }

   public static final Floor2Definitions getFloorDefinitions(int id) {
      Floor2Definitions script = (Floor2Definitions)defs.get(id);
      if (script != null) {
         return script;
      } else {
         byte[] data = Cache.STORE.getIndexes()[2].getFile(4, id);
         script = new Floor2Definitions();
         script.id = id;
         if (data != null) {
            script.readValueLoop(new InputStream(data));
         }

         defs.put(id, script);
         return script;
      }
   }

   Floor2Definitions() {
   }

   private void readValueLoop(InputStream stream) {
      while(true) {
         int opcode = stream.readUnsignedByte();
         if (opcode == 0) {
            return;
         }

         this.readValues(stream, opcode);
      }
   }

   static int method2632(int i, int i_790_) {
      return i == 16711935 ? -1 : method11651(i, (byte)-16);
   }

   public static int method11651(int i, byte i_12_) {
      double d = (double)(i >> 16 & 255) / 256.0D;
      double d_13_ = (double)(i >> 8 & 255) / 256.0D;
      double d_14_ = (double)(i & 255) / 256.0D;
      double d_15_ = d;
      if (d_13_ < d) {
         d_15_ = d_13_;
      }

      if (d_14_ < d_15_) {
         d_15_ = d_14_;
      }

      double d_16_ = d;
      if (d_13_ > d) {
         d_16_ = d_13_;
      }

      if (d_14_ > d_16_) {
         d_16_ = d_14_;
      }

      double d_17_ = 0.0D;
      double d_18_ = 0.0D;
      double d_19_ = (d_16_ + d_15_) / 2.0D;
      if (d_15_ != d_16_) {
         if (d_19_ < 0.5D) {
            d_18_ = (d_16_ - d_15_) / (d_15_ + d_16_);
         }

         if (d_19_ >= 0.5D) {
            d_18_ = (d_16_ - d_15_) / (2.0D - d_16_ - d_15_);
         }

         if (d == d_16_) {
            d_17_ = (d_13_ - d_14_) / (d_16_ - d_15_);
         } else if (d_16_ == d_13_) {
            d_17_ = 2.0D + (d_14_ - d) / (d_16_ - d_15_);
         } else if (d_16_ == d_14_) {
            d_17_ = 4.0D + (d - d_13_) / (d_16_ - d_15_);
         }
      }

      d_17_ /= 6.0D;
      int i_20_ = (int)(d_17_ * 256.0D);
      int i_21_ = (int)(d_18_ * 256.0D);
      int i_22_ = (int)(d_19_ * 256.0D);
      if (i_21_ < 0) {
         i_21_ = 0;
      } else if (i_21_ > 255) {
         i_21_ = 255;
      }

      if (i_22_ < 0) {
         i_22_ = 0;
      } else if (i_22_ > 255) {
         i_22_ = 255;
      }

      if (i_22_ > 243) {
         i_21_ >>= 4;
      } else if (i_22_ > 217) {
         i_21_ >>= 3;
      } else if (i_22_ > 192) {
         i_21_ >>= 2;
      } else if (i_22_ > 179) {
         i_21_ >>= 1;
      }

      return (i_22_ >> 1) + ((i_20_ & 255) >> 2 << 10) + (i_21_ >> 5 << 7);
   }

   private void readValues(InputStream stream, int i) {
      if (1 == i) {
         this.color = stream.read24BitInt();
      } else if (i == 2) {
         this.anInt6321 = stream.readUnsignedByte();
      } else if (3 == i) {
         this.anInt6321 = stream.readUnsignedShort();
         if (65535 == this.anInt6321) {
            this.anInt6321 = -1;
         }
      } else if (i == 5) {
         this.aBool6333 = false;
      } else if (i == 7) {
         this.secondaryColor = stream.read24BitInt();
      } else if (8 != i) {
         if (i == 9) {
            this.anInt6322 = stream.readUnsignedShort() << 2;
         } else if (i == 10) {
            this.aBool6331 = false;
         } else if (i == 11) {
            this.anInt6326 = stream.readUnsignedByte();
         } else if (i == 12) {
            this.aBool6327 = true;
         } else if (i == 13) {
            this.anInt6328 = stream.read24BitInt();
         } else if (14 == i) {
            this.anInt6329 = stream.readUnsignedByte() << 2;
         } else if (16 == i) {
            this.anInt6330 = stream.readUnsignedByte();
         } else if (i == 20) {
            this.anInt6318 = stream.readUnsignedShort();
         } else if (i == 21) {
            this.anInt6332 = stream.readUnsignedByte();
         } else if (i == 22) {
            this.anInt6325 = stream.readUnsignedShort();
         }
      }

   }
}
