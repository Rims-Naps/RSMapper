package org.rsmapper.cache.loaders;

import java.util.concurrent.ConcurrentHashMap;
import org.rsmapper.cache.Cache;
import org.rsmapper.networking.codec.stream.InputStream;

public class AnimationDefinitions {
   public int anInt2136 = 99;
   public int anInt2137;
   public int[] anIntArray2139;
   public int anInt2140 = -1;
   public boolean aBoolean2141 = false;
   public int anInt2142 = 5;
   public int emoteItem = -1;
   public int anInt2144 = -1;
   public int[][] handledSounds;
   public boolean[] aBooleanArray2149;
   public int[] anIntArray2151;
   public boolean aBoolean2152 = false;
   public int[] anIntArray2153;
   public int anInt2155 = 2;
   public boolean aBoolean2158 = false;
   public boolean aBoolean2159 = false;
   public int anInt2162 = -1;
   public int anInt2163 = -1;
   public int[] soundMinDelay;
   public int[] soundMaxDelay;
   public int[] anIntArray1362;
   public boolean effect2Sound;
   private static final ConcurrentHashMap<Integer, AnimationDefinitions> animDefs = new ConcurrentHashMap();

   public static final AnimationDefinitions getAnimationDefinitions(int emoteId) {
      AnimationDefinitions defs = (AnimationDefinitions)animDefs.get(emoteId);
      if (defs != null) {
         return defs;
      } else {
         byte[] data = Cache.STORE.getIndexes()[20].getFile(emoteId >>> 7, emoteId & 127);
         defs = new AnimationDefinitions();
         if (data != null) {
            defs.readValueLoop(new InputStream(data));
         }

         defs.method2394();
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

   public int getEmoteTime() {
      if (this.anIntArray2153 == null) {
         return 0;
      } else {
         int ms = 0;
         int[] var5;
         int var4 = (var5 = this.anIntArray2153).length;

         for(int var3 = 0; var3 < var4; ++var3) {
            int i = var5[var3];
            ms += i;
         }

         return ms * 30;
      }
   }

   public int getEmoteGameTickets() {
      return this.getEmoteTime() / 1000;
   }

   private void readValues(InputStream stream, int opcode) {
      int i_34_;
      int i_21_;
      if (~opcode == -2) {
         i_34_ = stream.readUnsignedShort();
         this.anIntArray2153 = new int[i_34_];

         for(i_21_ = 0; ~i_34_ < ~i_21_; ++i_21_) {
            this.anIntArray2153[i_21_] = stream.readUnsignedShort();
         }

         this.anIntArray2139 = new int[i_34_];

         for(i_21_ = 0; ~i_21_ > ~i_34_; ++i_21_) {
            this.anIntArray2139[i_21_] = stream.readUnsignedShort();
         }

         for(i_21_ = 0; i_21_ < i_34_; ++i_21_) {
            this.anIntArray2139[i_21_] += stream.readUnsignedShort() << 16;
         }
      } else if (~opcode != -3) {
         if (~opcode != -4) {
            if (~opcode == -5) {
               this.aBoolean2152 = true;
            } else if (opcode == 5) {
               this.anInt2142 = stream.readUnsignedByte();
            } else if (opcode != 6) {
               if (~opcode == -8) {
                  this.emoteItem = stream.readUnsignedShort();
               } else if (~opcode != -9) {
                  if (opcode != 9) {
                     if (~opcode != -11) {
                        if (~opcode == -12) {
                           this.anInt2155 = stream.readUnsignedByte();
                        } else if (opcode == 12) {
                           i_34_ = stream.readUnsignedByte();
                           this.anIntArray2151 = new int[i_34_];

                           for(i_21_ = 0; ~i_21_ > ~i_34_; ++i_21_) {
                              this.anIntArray2151[i_21_] = stream.readUnsignedShort();
                           }

                           for(i_21_ = 0; i_34_ > i_21_; ++i_21_) {
                              this.anIntArray2151[i_21_] += stream.readUnsignedShort() << 16;
                           }
                        } else if (~opcode != -14) {
                           if (opcode != 14) {
                              if (opcode != 15) {
                                 if (opcode == 16) {
                                    this.aBoolean2158 = true;
                                 } else if (opcode == 17) {
                                    stream.readUnsignedByte();
                                 } else if (opcode == 18) {
                                    this.effect2Sound = true;
                                 } else if (opcode == 19) {
                                    if (this.anIntArray1362 == null) {
                                       this.anIntArray1362 = new int[this.handledSounds.length];

                                       for(i_34_ = 0; i_34_ < this.handledSounds.length; ++i_34_) {
                                          this.anIntArray1362[i_34_] = 255;
                                       }
                                    }

                                    this.anIntArray1362[stream.readUnsignedByte()] = stream.readUnsignedByte();
                                 } else if (opcode == 20) {
                                    if (this.soundMaxDelay == null || this.soundMinDelay == null) {
                                       this.soundMaxDelay = new int[this.handledSounds.length];
                                       this.soundMinDelay = new int[this.handledSounds.length];

                                       for(i_34_ = 0; i_34_ < this.handledSounds.length; ++i_34_) {
                                          this.soundMaxDelay[i_34_] = 256;
                                          this.soundMinDelay[i_34_] = 256;
                                       }
                                    }

                                    i_34_ = stream.readUnsignedByte();
                                    this.soundMaxDelay[i_34_] = stream.readUnsignedShort();
                                    this.soundMinDelay[i_34_] = stream.readUnsignedShort();
                                 }
                              } else {
                                 this.aBoolean2159 = true;
                              }
                           } else {
                              this.aBoolean2141 = true;
                           }
                        } else {
                           i_34_ = stream.readUnsignedShort();
                           this.handledSounds = new int[i_34_][];

                           for(i_21_ = 0; i_21_ < i_34_; ++i_21_) {
                              int i_22_ = stream.readUnsignedByte();
                              if (~i_22_ < -1) {
                                 this.handledSounds[i_21_] = new int[i_22_];
                                 this.handledSounds[i_21_][0] = stream.read24BitInt();

                                 for(int i_23_ = 1; ~i_22_ < ~i_23_; ++i_23_) {
                                    this.handledSounds[i_21_][i_23_] = stream.readUnsignedShort();
                                 }
                              }
                           }
                        }
                     } else {
                        this.anInt2162 = stream.readUnsignedByte();
                     }
                  } else {
                     this.anInt2140 = stream.readUnsignedByte();
                  }
               } else {
                  this.anInt2136 = stream.readUnsignedByte();
               }
            } else {
               this.anInt2144 = stream.readUnsignedShort();
            }
         } else {
            this.aBooleanArray2149 = new boolean[256];
            i_34_ = stream.readUnsignedByte();

            for(i_21_ = 0; ~i_34_ < ~i_21_; ++i_21_) {
               this.aBooleanArray2149[stream.readUnsignedByte()] = true;
            }
         }
      } else {
         this.anInt2163 = stream.readUnsignedShort();
      }

   }

   public void method2394() {
      if (this.anInt2140 == -1) {
         if (this.aBooleanArray2149 == null) {
            this.anInt2140 = 0;
         } else {
            this.anInt2140 = 2;
         }
      }

      if (this.anInt2162 == -1) {
         if (this.aBooleanArray2149 == null) {
            this.anInt2162 = 0;
         } else {
            this.anInt2162 = 2;
         }
      }

   }
}
