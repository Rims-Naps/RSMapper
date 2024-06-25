package org.rsmapper.cache.loaders;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import org.rsmapper.cache.Cache;
import org.rsmapper.networking.codec.stream.InputStream;

public class RenderAnimDefinitions {
   public int anInt949 = -1;
   public int anInt951 = -1;
   public int anInt952 = -1;
   public int anInt953 = -1;
   public int anInt954 = -1;
   public int anInt955 = -1;
   public int anInt956 = 0;
   public int anInt957 = -1;
   public int anInt958 = -1;
   public int[] anIntArray959 = null;
   public int anInt960 = -1;
   public int anInt961 = 0;
   public int anInt962 = -1;
   public int walkAnim = -1;
   public int anInt964 = -1;
   public int anInt965 = 0;
   public int anInt966 = -1;
   public int[] standAnims = null;
   public int anInt969 = 0;
   public int[] anIntArray971;
   public int runAnim = -1;
   public int anInt973 = 0;
   public int anInt974 = -1;
   public int anInt975 = 0;
   public int anInt976 = -1;
   public int anInt977 = -1;
   public boolean aBoolean978 = true;
   public int[][] anIntArrayArray979;
   public int anInt980 = 0;
   public int anInt981 = -1;
   public int anInt983 = -1;
   public int anInt985 = -1;
   public int anInt986 = -1;
   public int anInt987 = -1;
   public int anInt988 = 0;
   public int anInt989 = -1;
   public int anInt990 = -1;
   public int anInt992 = 0;
   public int anInt993 = 0;
   public int anInt994 = 0;
   private static final ConcurrentHashMap<Integer, RenderAnimDefinitions> renderAimDefs = new ConcurrentHashMap();

   public static final RenderAnimDefinitions getRenderAnimDefinitions(int emoteId) {
      RenderAnimDefinitions defs = (RenderAnimDefinitions)renderAimDefs.get(emoteId);
      if (defs != null) {
         return defs;
      } else if (emoteId == -1) {
         return null;
      } else {
         byte[] data = Cache.STORE.getIndexes()[2].getFile(32, emoteId);
         defs = new RenderAnimDefinitions();
         if (data != null) {
            defs.readValueLoop(new InputStream(data));
         }

         renderAimDefs.put(emoteId, defs);
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

   private void readValues(InputStream stream, int opcode) {
      if (opcode == 54) {
         stream.readUnsignedByte();
         stream.readUnsignedByte();
      } else {
         int i_2_;
         if (opcode == 55) {
            int[] anIntArray1246 = new int[12];
            i_2_ = stream.readUnsignedByte();
            anIntArray1246[i_2_] = stream.readUnsignedShort();
         } else {
            int i_3_;
            if (opcode == 56) {
               int[][] anIntArrayArray1217 = new int[12][];
               i_2_ = stream.readUnsignedByte();
               anIntArrayArray1217[i_2_] = new int[3];

               for(i_3_ = 0; i_3_ < 3; ++i_3_) {
                  anIntArrayArray1217[i_2_][i_3_] = stream.readShort();
               }
            } else if (~opcode != -2) {
               if (~opcode != -3) {
                  if (opcode != 3) {
                     if (~opcode != -5) {
                        if (opcode == 5) {
                           this.anInt977 = stream.readUnsignedShort();
                        } else if (~opcode != -7) {
                           if (opcode == 7) {
                              this.anInt960 = stream.readUnsignedShort();
                           } else if (~opcode == -9) {
                              this.anInt985 = stream.readUnsignedShort();
                           } else if (opcode == 9) {
                              this.anInt957 = stream.readUnsignedShort();
                           } else if (opcode == 26) {
                              this.anInt973 = (short)(4 * stream.readUnsignedByte());
                              this.anInt975 = (short)(stream.readUnsignedByte() * 4);
                           } else {
                              int i;
                              if (~opcode == -28) {
                                 if (this.anIntArrayArray979 == null) {
                                    this.anIntArrayArray979 = new int[12][];
                                 }

                                 i = stream.readUnsignedByte();
                                 this.anIntArrayArray979[i] = new int[6];

                                 for(i_2_ = 0; ~i_2_ > -7; ++i_2_) {
                                    this.anIntArrayArray979[i][i_2_] = stream.readShort();
                                 }
                              } else if (~opcode == -29) {
                                 this.anIntArray971 = new int[12];

                                 for(i = 0; i < 12; ++i) {
                                    this.anIntArray971[i] = stream.readUnsignedByte();
                                    if (this.anIntArray971[i] == 255) {
                                       this.anIntArray971[i] = -1;
                                    }
                                 }
                              } else if (opcode != 29) {
                                 if (opcode != 30) {
                                    if (~opcode != -32) {
                                       if (opcode != 32) {
                                          if (~opcode != -34) {
                                             if (opcode != 34) {
                                                if (opcode != 35) {
                                                   if (~opcode != -37) {
                                                      if (~opcode != -38) {
                                                         if (opcode != 38) {
                                                            if (~opcode != -40) {
                                                               if (~opcode != -41) {
                                                                  if (~opcode == -42) {
                                                                     this.anInt953 = stream.readUnsignedShort();
                                                                  } else if (opcode != 42) {
                                                                     if (~opcode == -44) {
                                                                        stream.readUnsignedShort();
                                                                     } else if (~opcode != -45) {
                                                                        if (~opcode == -46) {
                                                                           this.anInt964 = stream.readUnsignedShort();
                                                                        } else if (~opcode != -47) {
                                                                           if (opcode == 47) {
                                                                              this.anInt966 = stream.readUnsignedShort();
                                                                           } else if (opcode == 48) {
                                                                              this.anInt989 = stream.readUnsignedShort();
                                                                           } else if (opcode != 49) {
                                                                              if (~opcode != -51) {
                                                                                 if (opcode != 51) {
                                                                                    if (opcode == 52) {
                                                                                       i = stream.readUnsignedByte();
                                                                                       this.anIntArray959 = new int[i];
                                                                                       this.standAnims = new int[i];

                                                                                       for(i_2_ = 0; i_2_ < i; ++i_2_) {
                                                                                          this.standAnims[i_2_] = stream.readUnsignedShort();
                                                                                          i_3_ = stream.readUnsignedByte();
                                                                                          this.anIntArray959[i_2_] = i_3_;
                                                                                          this.anInt994 += i_3_;
                                                                                       }
                                                                                    } else if (opcode == 53) {
                                                                                       this.aBoolean978 = false;
                                                                                    }
                                                                                 } else {
                                                                                    this.anInt962 = stream.readUnsignedShort();
                                                                                 }
                                                                              } else {
                                                                                 this.anInt990 = stream.readUnsignedShort();
                                                                              }
                                                                           } else {
                                                                              this.anInt952 = stream.readUnsignedShort();
                                                                           }
                                                                        } else {
                                                                           this.anInt983 = stream.readUnsignedShort();
                                                                        }
                                                                     } else {
                                                                        this.anInt955 = stream.readUnsignedShort();
                                                                     }
                                                                  } else {
                                                                     this.anInt981 = stream.readUnsignedShort();
                                                                  }
                                                               } else {
                                                                  this.anInt949 = stream.readUnsignedShort();
                                                               }
                                                            } else {
                                                               this.anInt954 = stream.readUnsignedShort();
                                                            }
                                                         } else {
                                                            this.anInt958 = stream.readUnsignedShort();
                                                         }
                                                      } else {
                                                         this.anInt951 = stream.readUnsignedByte();
                                                      }
                                                   } else {
                                                      this.anInt965 = stream.readShort();
                                                   }
                                                } else {
                                                   this.anInt969 = stream.readUnsignedShort();
                                                }
                                             } else {
                                                this.anInt993 = stream.readUnsignedByte();
                                             }
                                          } else {
                                             this.anInt956 = stream.readShort();
                                          }
                                       } else {
                                          this.anInt961 = stream.readUnsignedShort();
                                       }
                                    } else {
                                       this.anInt988 = stream.readUnsignedByte();
                                    }
                                 } else {
                                    this.anInt980 = stream.readUnsignedShort();
                                 }
                              } else {
                                 this.anInt992 = stream.readUnsignedByte();
                              }
                           }
                        } else {
                           this.anInt976 = stream.readUnsignedShort();
                        }
                     } else {
                        this.anInt986 = stream.readUnsignedShort();
                     }
                  } else {
                     this.anInt987 = stream.readUnsignedShort();
                  }
               } else {
                  this.anInt974 = stream.readUnsignedShort();
               }
            } else {
               this.runAnim = stream.readUnsignedShort();
               this.walkAnim = stream.readUnsignedShort();
               if (~this.runAnim == -65536) {
                  this.runAnim = -1;
               }

               if (~this.walkAnim == -65536) {
                  this.walkAnim = -1;
               }
            }
         }
      }

   }

   public static void main(String[] args) throws IOException {
      Cache.init();
      new File("./ranims.txt");
      RenderAnimDefinitions defs = getRenderAnimDefinitions(2122);
      if (defs != null) {
         System.out.println("run: " + defs.runAnim + ", walk: " + defs.walkAnim + ", stand: " + Arrays.toString(defs.standAnims));
      }

   }
}
