package org.rsmapper.cache.loaders;

import java.util.concurrent.ConcurrentHashMap;
import org.rsmapper.cache.Cache;
import org.rsmapper.networking.codec.stream.InputStream;

public class GraphicDefinitions {
   public short[] aShortArray1435;
   public short[] aShortArray1438;
   public int anInt1440 = 0;
   public boolean aBoolean1442 = false;
   public int defaultModel;
   public int anInt1446 = 128;
   public boolean aBoolean1448 = false;
   public int anInt1449 = 128;
   public int anInt1450 = -1;
   public int anInt1451 = 0;
   public int graphicsId;
   public int anInt1454 = 0;
   public short[] aShortArray1455;
   public short[] aShortArray1456;
   public byte byteValue = 0;
   public int intValue = -1;
   private static final ConcurrentHashMap<Integer, GraphicDefinitions> animDefs = new ConcurrentHashMap();

   public static final GraphicDefinitions getAnimationDefinitions(int emoteId) {
      GraphicDefinitions defs = (GraphicDefinitions)animDefs.get(emoteId);
      if (defs != null) {
         return defs;
      } else {
         byte[] data = Cache.STORE.getIndexes()[21].getFile(emoteId >>> 735411752, emoteId & 255);
         defs = new GraphicDefinitions();
         defs.graphicsId = emoteId;
         if (data != null) {
            defs.readValueLoop(new InputStream(data));
         }

         animDefs.put(emoteId, defs);
         return defs;
      }
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

   public void readValues(InputStream stream, int opcode) {
      if (opcode != 1) {
         if (~opcode == -3) {
            this.anInt1450 = stream.readBigSmart();
         } else if (opcode == 4) {
            this.anInt1446 = stream.readUnsignedShort();
         } else if (opcode != 5) {
            if (~opcode != -7) {
               if (opcode == 7) {
                  this.anInt1440 = stream.readUnsignedByte();
               } else if (~opcode == -9) {
                  this.anInt1451 = stream.readUnsignedByte();
               } else if (opcode != 9) {
                  if (opcode != 10) {
                     if (opcode == 11) {
                        this.byteValue = 1;
                     } else if (opcode == 12) {
                        this.byteValue = 4;
                     } else if (opcode == 13) {
                        this.byteValue = 5;
                     } else if (opcode == 14) {
                        this.byteValue = 2;
                        this.intValue = stream.readUnsignedByte() * 256;
                     } else if (opcode == 15) {
                        this.byteValue = 3;
                        this.intValue = stream.readUnsignedShort();
                     } else if (opcode == 16) {
                        this.byteValue = 3;
                        this.intValue = stream.readInt();
                     } else {
                        int i;
                        int i_0_;
                        if (opcode != 40) {
                           if (~opcode == -42) {
                              i = stream.readUnsignedByte();
                              this.aShortArray1455 = new short[i];
                              this.aShortArray1435 = new short[i];

                              for(i_0_ = 0; i > i_0_; ++i_0_) {
                                 this.aShortArray1455[i_0_] = (short)stream.readUnsignedShort();
                                 this.aShortArray1435[i_0_] = (short)stream.readUnsignedShort();
                              }
                           }
                        } else {
                           i = stream.readUnsignedByte();
                           this.aShortArray1438 = new short[i];
                           this.aShortArray1456 = new short[i];

                           for(i_0_ = 0; ~i < ~i_0_; ++i_0_) {
                              this.aShortArray1438[i_0_] = (short)stream.readUnsignedShort();
                              this.aShortArray1456[i_0_] = (short)stream.readUnsignedShort();
                           }
                        }
                     }
                  } else {
                     this.aBoolean1448 = true;
                  }
               } else {
                  this.byteValue = 3;
                  this.intValue = 8224;
               }
            } else {
               this.anInt1454 = stream.readUnsignedShort();
            }
         } else {
            this.anInt1449 = stream.readUnsignedShort();
         }
      } else {
         this.defaultModel = stream.readBigSmart();
      }

   }
}
