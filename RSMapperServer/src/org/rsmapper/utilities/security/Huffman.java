package org.rsmapper.utilities.security;

import org.rsmapper.cache.Cache;
import org.rsmapper.networking.codec.stream.InputStream;
import org.rsmapper.networking.codec.stream.OutputStream;
import org.rsmapper.utilities.misc.Utils;

public final class Huffman {
   private static int[] huffmanAlgorithm1;
   private static byte[] huffmanAlgorithm2;
   private static int[] huffmanAlgorithm3;

   public static final void init() {
		byte[] huffmanFile = Cache.STORE.getIndexes()[10].getFile(Cache.STORE
				.getIndexes()[10].getArchiveId("huffman"));
      int fileLength = huffmanFile.length;
      huffmanAlgorithm2 = huffmanFile;
      huffmanAlgorithm1 = new int[fileLength];
      huffmanAlgorithm3 = new int[8];
      int[] is = new int[33];
      int i_4_ = 0;

      for(int i_5_ = 0; ~fileLength < ~i_5_; ++i_5_) {
         int i_6_ = huffmanFile[i_5_];
         if (i_6_ != 0) {
            int i_7_ = 1 << 32 - i_6_;
            int i_8_ = is[i_6_];
            huffmanAlgorithm1[i_5_] = i_8_;
            int i_9_;
            int i_14_;
            int i_15_;
            int i_16_;
            if ((i_8_ & i_7_) == 0) {
               for(i_14_ = -1 + i_6_; i_14_ >= 1; --i_14_) {
                  i_15_ = is[i_14_];
                  if (i_8_ != i_15_) {
                     break;
                  }

                  i_16_ = 1 << 32 + -i_14_;
                  if (~(i_16_ & i_15_) != -1) {
                     is[i_14_] = is[-1 + i_14_];
                     break;
                  }

                  is[i_14_] = i_15_ | i_16_;
               }

               i_9_ = i_7_ | i_8_;
            } else {
               i_9_ = is[i_6_ + -1];
            }

            is[i_6_] = i_9_;

            for(i_14_ = 1 + i_6_; i_14_ <= 32; ++i_14_) {
               if (i_8_ == is[i_14_]) {
                  is[i_14_] = i_9_;
               }
            }

            i_14_ = 0;

            for(i_15_ = 0; ~i_6_ < ~i_15_; ++i_15_) {
               i_16_ = Integer.MIN_VALUE >>> i_15_;
               if (~(i_8_ & i_16_) == -1) {
                  ++i_14_;
               } else {
                  if (huffmanAlgorithm3[i_14_] == 0) {
                     huffmanAlgorithm3[i_14_] = i_4_;
                  }

                  i_14_ = huffmanAlgorithm3[i_14_];
               }

               if (~huffmanAlgorithm3.length >= ~i_14_) {
                  int[] is_17_ = new int[huffmanAlgorithm3.length * 2];

                  for(int i_18_ = 0; i_18_ < huffmanAlgorithm3.length; ++i_18_) {
                     is_17_[i_18_] = huffmanAlgorithm3[i_18_];
                  }

                  huffmanAlgorithm3 = is_17_;
               }

               i_16_ >>>= 1;
            }

            huffmanAlgorithm3[i_14_] = ~i_5_;
            if (~i_4_ >= ~i_14_) {
               i_4_ = 1 + i_14_;
            }
         }
      }

   }

   public static final int decryptMessage(byte[] messageData, int messagedDataLength, byte[] streamBuffer, int streamOffset, int messageDataOffset) {
      if (~messagedDataLength == -1) {
         return 0;
      } else {
         int i = 0;
         messagedDataLength += messageDataOffset;
         int i_1_ = streamOffset;

         while(true) {
            byte i_2_ = streamBuffer[i_1_];
            if (~i_2_ <= -1) {
               ++i;
            } else {
               i = huffmanAlgorithm3[i];
            }

            int i_3_;
            if ((i_3_ = huffmanAlgorithm3[i]) < 0) {
               messageData[messageDataOffset++] = (byte)(~i_3_);
               if (messagedDataLength <= messageDataOffset) {
                  break;
               }

               i = 0;
            }

            if (~(i_2_ & 64) == -1) {
               ++i;
            } else {
               i = huffmanAlgorithm3[i];
            }

            if (~(i_3_ = huffmanAlgorithm3[i]) > -1) {
               messageData[messageDataOffset++] = (byte)(~i_3_);
               if (messagedDataLength <= messageDataOffset) {
                  break;
               }

               i = 0;
            }

            if (~(32 & i_2_) != -1) {
               i = huffmanAlgorithm3[i];
            } else {
               ++i;
            }

            if ((i_3_ = huffmanAlgorithm3[i]) < 0) {
               messageData[messageDataOffset++] = (byte)(~i_3_);
               if (messagedDataLength <= messageDataOffset) {
                  break;
               }

               i = 0;
            }

            if (~(16 & i_2_) != -1) {
               i = huffmanAlgorithm3[i];
            } else {
               ++i;
            }

            if ((i_3_ = huffmanAlgorithm3[i]) < 0) {
               messageData[messageDataOffset++] = (byte)(~i_3_);
               if (~messageDataOffset <= ~messagedDataLength) {
                  break;
               }

               i = 0;
            }

            if ((i_2_ & 8) == 0) {
               ++i;
            } else {
               i = huffmanAlgorithm3[i];
            }

            if ((i_3_ = huffmanAlgorithm3[i]) < 0) {
               messageData[messageDataOffset++] = (byte)(~i_3_);
               if (messageDataOffset >= messagedDataLength) {
                  break;
               }

               i = 0;
            }

            if (~(4 & i_2_) != -1) {
               i = huffmanAlgorithm3[i];
            } else {
               ++i;
            }

            if (~(i_3_ = huffmanAlgorithm3[i]) > -1) {
               messageData[messageDataOffset++] = (byte)(~i_3_);
               if (messageDataOffset >= messagedDataLength) {
                  break;
               }

               i = 0;
            }

            if ((2 & i_2_) != 0) {
               i = huffmanAlgorithm3[i];
            } else {
               ++i;
            }

            if (~(i_3_ = huffmanAlgorithm3[i]) > -1) {
               messageData[messageDataOffset++] = (byte)(~i_3_);
               if (messagedDataLength <= messageDataOffset) {
                  break;
               }

               i = 0;
            }

            if (~(1 & i_2_) != -1) {
               i = huffmanAlgorithm3[i];
            } else {
               ++i;
            }

            if ((i_3_ = huffmanAlgorithm3[i]) < 0) {
               messageData[messageDataOffset++] = (byte)(~i_3_);
               if (~messageDataOffset <= ~messagedDataLength) {
                  break;
               }

               i = 0;
            }

            ++i_1_;
         }

         return -streamOffset + i_1_ - -1;
      }
   }

   public static final int encryptMessage(int streamOffset, int messageDataLength, byte[] streamBuffer, int messageDataOffset, byte[] messageData) {
      int i = 0;
      messageDataLength += messageDataOffset;

      int i_19_;
      for(i_19_ = streamOffset << 309760323; messageDataOffset < messageDataLength; ++messageDataOffset) {
         int i_20_ = 255 & messageData[messageDataOffset];
         int i_21_ = huffmanAlgorithm1[i_20_];
         int i_22_ = huffmanAlgorithm2[i_20_];
         if (i_22_ == 0) {
            throw new RuntimeException("No codeword for data value " + i_20_);
         }

         int i_23_ = i_19_ >> -976077821;
         int i_24_ = 7 & i_19_;
         i &= -i_24_ >> -1041773793;
         int i_25_ = (-1 + i_24_ - -i_22_ >> -2003626461) + i_23_;
         i_19_ += i_22_;
         i_24_ += 24;
         streamBuffer[i_23_] = (byte)(i |= i_21_ >>> i_24_);
         if (i_25_ > i_23_) {
            i_24_ -= 8;
            ++i_23_;
            streamBuffer[i_23_] = (byte)(i = i_21_ >>> i_24_);
            if (~i_23_ > ~i_25_) {
               i_24_ -= 8;
               ++i_23_;
               streamBuffer[i_23_] = (byte)(i = i_21_ >>> i_24_);
               if (~i_23_ > ~i_25_) {
                  i_24_ -= 8;
                  ++i_23_;
                  streamBuffer[i_23_] = (byte)(i = i_21_ >>> i_24_);
                  if (~i_25_ < ~i_23_) {
                     ++i_23_;
                     i_24_ -= 8;
                     streamBuffer[i_23_] = (byte)(i = i_21_ << -i_24_);
                  }
               }
            }
         }
      }

      return -streamOffset + (7 + i_19_ >> 1737794179);
   }

   public static int sendEncryptMessage(OutputStream stream, String message) {
      try {
         int startOffset = stream.getOffset();
         byte[] messageData = Utils.getFormatedMessage(message);
         stream.writeSmart(messageData.length);
         stream.checkCapacityPosition(stream.getOffset() + message.length() * 2);
         stream.skip(encryptMessage(stream.getOffset(), messageData.length, stream.getBuffer(), 0, messageData));
         return stream.getOffset() - startOffset;
      } catch (Throwable var4) {
         return -1;
      }
   }

	// decrypt message
   public static final String readEncryptedMessage(InputStream stream) {
      return readEncryptedMessage(32767, stream);
   }

   public static final String readEncryptedMessage(int maxLength, InputStream stream) {
      try {
         int messageDataLength = stream.readUnsignedSmart();
         if (messageDataLength > maxLength) {
            messageDataLength = maxLength;
         }

         byte[] messageData = new byte[messageDataLength];
         stream.skip(decryptMessage(messageData, messageDataLength, stream.getBuffer(), stream.getOffset(), 0));
         String message = Utils.getUnformatedMessage(messageDataLength, 0, messageData);
         return message;
      } catch (Throwable var5) {
         return "";
      }
   }

   private Huffman() {
   }
}
