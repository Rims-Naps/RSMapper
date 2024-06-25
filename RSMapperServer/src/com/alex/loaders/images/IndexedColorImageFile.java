package com.alex.loaders.images;

import com.alex.io.InputStream;
import com.alex.io.OutputStream;
import com.alex.store.Store;
import java.awt.image.BufferedImage;
import java.util.Arrays;

public final class IndexedColorImageFile {
   private BufferedImage[] images;
	private int pallete[];
	private int pixelsIndexes[][];
	private byte alpha[][];
   private boolean[] usesAlpha;
   private int biggestWidth;
   private int biggestHeight;

   public IndexedColorImageFile(BufferedImage... images) {
      this.images = images;
   }

   public IndexedColorImageFile(Store cache, int archiveId, int fileId) {
      this(cache, 8, archiveId, fileId);
   }

   public IndexedColorImageFile(Store cache, int idx, int archiveId, int fileId) {
      this.decodeArchive(cache, idx, archiveId, fileId);
   }

   public void decodeArchive(Store cache, int idx, int archiveId, int fileId) {
      byte[] data = cache.getIndexes()[idx].getFile(archiveId, fileId);
      if (data != null) {
         InputStream stream = new InputStream(data);
         stream.setOffset(data.length - 2);
         int count = stream.readUnsignedShort();
         this.images = new BufferedImage[count];
         this.pixelsIndexes = new int[this.images.length][];
         this.alpha = new byte[this.images.length][];
         this.usesAlpha = new boolean[this.images.length];
         int[] imagesMinX = new int[this.images.length];
         int[] imagesMinY = new int[this.images.length];
         int[] imagesWidth = new int[this.images.length];
         int[] imagesHeight = new int[this.images.length];
         stream.setOffset(data.length - 7 - this.images.length * 8);
         this.setBiggestWidth(stream.readShort());
         this.setBiggestHeight(stream.readShort());
         int palleteLength = (stream.readUnsignedByte() & 255) + 1;

         int i_20_;
         for(i_20_ = 0; i_20_ < this.images.length; ++i_20_) {
            imagesMinX[i_20_] = stream.readUnsignedShort();
         }

         for(i_20_ = 0; i_20_ < this.images.length; ++i_20_) {
            imagesMinY[i_20_] = stream.readUnsignedShort();
         }

         for(i_20_ = 0; i_20_ < this.images.length; ++i_20_) {
            imagesWidth[i_20_] = stream.readUnsignedShort();
         }

         for(i_20_ = 0; i_20_ < this.images.length; ++i_20_) {
            imagesHeight[i_20_] = stream.readUnsignedShort();
         }

         stream.setOffset(data.length - 7 - this.images.length * 8 - (palleteLength - 1) * 3);
         this.pallete = new int[palleteLength];

         for(i_20_ = 1; i_20_ < palleteLength; ++i_20_) {
            this.pallete[i_20_] = stream.read24BitInt();
            if (this.pallete[i_20_] == 0) {
               this.pallete[i_20_] = 1;
            }
         }

         stream.setOffset(0);

         for(i_20_ = 0; i_20_ < this.images.length; ++i_20_) {
            int pixelsIndexesLength = imagesWidth[i_20_] * imagesHeight[i_20_];
            this.pixelsIndexes[i_20_] = new int[pixelsIndexesLength];
            this.alpha[i_20_] = new byte[pixelsIndexesLength];
            int maskData = stream.readUnsignedByte();
            int i_31_;
            if ((maskData & 2) == 0) {
               int i_24_;
               if ((maskData & 1) == 0) {
                  for(i_24_ = 0; i_24_ < pixelsIndexesLength; ++i_24_) {
                     this.pixelsIndexes[i_20_][i_24_] = (byte)stream.readByte();
                  }
               } else {
                  for(i_24_ = 0; i_24_ < imagesWidth[i_20_]; ++i_24_) {
                     for(i_31_ = 0; i_31_ < imagesHeight[i_20_]; ++i_31_) {
                        this.pixelsIndexes[i_20_][i_24_ + i_31_ * imagesWidth[i_20_]] = (byte)stream.readByte();
                     }
                  }
               }
            } else {
               this.usesAlpha[i_20_] = true;
               boolean bool = false;
               if ((maskData & 1) == 0) {
                  for(i_31_ = 0; i_31_ < pixelsIndexesLength; ++i_31_) {
                     this.pixelsIndexes[i_20_][i_31_] = (byte)stream.readByte();
                  }

                  for(i_31_ = 0; i_31_ < pixelsIndexesLength; ++i_31_) {
                     byte i_28_ = this.alpha[i_20_][i_31_] = (byte)stream.readByte();
                     bool |= i_28_ != -1;
                  }
               } else {
                  int i_32_;
                  for(i_31_ = 0; i_31_ < imagesWidth[i_20_]; ++i_31_) {
                     for(i_32_ = 0; i_32_ < imagesHeight[i_20_]; ++i_32_) {
                        this.pixelsIndexes[i_20_][i_31_ + i_32_ * imagesWidth[i_20_]] = stream.readByte();
                     }
                  }

                  for(i_31_ = 0; i_31_ < imagesWidth[i_20_]; ++i_31_) {
                     for(i_32_ = 0; i_32_ < imagesHeight[i_20_]; ++i_32_) {
                        byte i_33_ = this.alpha[i_20_][i_31_ + i_32_ * imagesWidth[i_20_]] = (byte)stream.readByte();
                        bool |= i_33_ != -1;
                     }
                  }
               }

               if (!bool) {
                  this.alpha[i_20_] = null;
               }
            }

            this.images[i_20_] = this.getBufferedImage(imagesWidth[i_20_], imagesHeight[i_20_], this.pixelsIndexes[i_20_], this.alpha[i_20_], this.usesAlpha[i_20_]);
         }

      }
   }

   public BufferedImage getBufferedImage(int width, int height, int[] pixelsIndexes, byte[] extraPixels, boolean useExtraPixels) {
      if (width > 0 && height > 0) {
         BufferedImage image = new BufferedImage(width, height, 6);
         int[] rgbArray = new int[width * height];
         int i = 0;
         int i_43_ = 0;
         int i_46_;
         int i_47_;
         if (useExtraPixels && extraPixels != null) {
            for(i_46_ = 0; i_46_ < height; ++i_46_) {
               for(i_47_ = 0; i_47_ < width; ++i_47_) {
                  rgbArray[i_43_++] = extraPixels[i] << 24 | this.pallete[pixelsIndexes[i] & 255];
                  ++i;
               }
            }
         } else {
            for(i_46_ = 0; i_46_ < height; ++i_46_) {
               for(i_47_ = 0; i_47_ < width; ++i_47_) {
                  int i_48_ = this.pallete[pixelsIndexes[i++] & 255];
                  rgbArray[i_43_++] = i_48_ != 0 ? -16777216 | i_48_ : 0;
               }
            }
         }

         image.setRGB(0, 0, width, height, rgbArray, 0, width);
         image.flush();
         return image;
      } else {
         return null;
      }
   }

   public byte[] encodeFile() {
      if (this.pallete == null) {
         this.generatePallete();
      }

      OutputStream stream = new OutputStream();

      int imageId;
      int pixelsMask;
      int index;
      for(imageId = 0; imageId < this.images.length; ++imageId) {
         pixelsMask = 0;
         if (this.usesAlpha[imageId]) {
            pixelsMask |= 2;
         }

         stream.writeByte(pixelsMask);

         for(index = 0; index < this.pixelsIndexes[imageId].length; ++index) {
            stream.writeByte(this.pixelsIndexes[imageId][index]);
         }

         if (this.usesAlpha[imageId]) {
            for(index = 0; index < this.alpha[imageId].length; ++index) {
               stream.writeByte(this.alpha[imageId][index]);
            }
         }
      }

      for(imageId = 0; imageId < this.pallete.length; ++imageId) {
         stream.write24BitInt(this.pallete[imageId]);
      }

      if (this.biggestWidth == 0 && this.biggestHeight == 0) {
         BufferedImage[] var5;
         index = (var5 = this.images).length;

         for(pixelsMask = 0; pixelsMask < index; ++pixelsMask) {
            BufferedImage image = var5[pixelsMask];
            if (image.getWidth() > this.biggestWidth) {
               this.biggestWidth = image.getWidth();
            }

            if (image.getHeight() > this.biggestHeight) {
               this.biggestHeight = image.getHeight();
            }
         }
      }

      stream.writeShort(this.biggestWidth);
      stream.writeShort(this.biggestHeight);
      stream.writeByte(this.pallete.length - 1);

      for(imageId = 0; imageId < this.images.length; ++imageId) {
         stream.writeShort(this.images[imageId].getMinX());
      }

      for(imageId = 0; imageId < this.images.length; ++imageId) {
         stream.writeShort(this.images[imageId].getMinY());
      }

      for(imageId = 0; imageId < this.images.length; ++imageId) {
         stream.writeShort(this.images[imageId].getWidth());
      }

      for(imageId = 0; imageId < this.images.length; ++imageId) {
         stream.writeShort(this.images[imageId].getHeight());
      }

      stream.writeShort(this.images.length);
      byte[] container = new byte[stream.getOffset()];
      stream.setOffset(0);
      stream.getBytes(container, 0, container.length);
      return container;
   }

   public int getPalleteIndex(int rgb) {
      if (this.pallete == null) {
         this.pallete = new int[1];
      }

      for(int index = 0; index < this.pallete.length; ++index) {
         if (this.pallete[index] == rgb) {
            return index;
         }
      }

      if (this.pallete.length == 256) {
         System.out.println("Pallete to big, please reduce images quality.");
         return 0;
      } else {
         int[] newpallete = new int[this.pallete.length + 1];
         System.arraycopy(this.pallete, 0, newpallete, 0, this.pallete.length);
         newpallete[this.pallete.length] = rgb;
         this.pallete = newpallete;
         return this.pallete.length - 1;
      }
   }

   public int addImage(BufferedImage image) {
      BufferedImage[] newImages = (BufferedImage[])Arrays.copyOf(this.images, this.images.length + 1);
      newImages[this.images.length] = image;
      this.images = newImages;
      this.pallete = null;
      this.pixelsIndexes = null;
      this.alpha = null;
      this.usesAlpha = null;
      return this.images.length - 1;
   }

   public void replaceImage(BufferedImage image, int index) {
      this.images[index] = image;
      this.pallete = null;
      this.pixelsIndexes = null;
      this.alpha = null;
      this.usesAlpha = null;
   }

   public void generatePallete() {
      this.pixelsIndexes = new int[this.images.length][];
      this.alpha = new byte[this.images.length][];
      this.usesAlpha = new boolean[this.images.length];

      for(int index = 0; index < this.images.length; ++index) {
         BufferedImage image = this.images[index];
         int[] rgbArray = new int[image.getWidth() * image.getHeight()];
         image.getRGB(0, 0, image.getWidth(), image.getHeight(), rgbArray, 0, image.getWidth());
         this.pixelsIndexes[index] = new int[image.getWidth() * image.getHeight()];
         this.alpha[index] = new byte[image.getWidth() * image.getHeight()];

         for(int pixel = 0; pixel < this.pixelsIndexes[index].length; ++pixel) {
            int rgb = rgbArray[pixel];
            int medintrgb = this.convertToMediumInt(rgb);
            int i = this.getPalleteIndex(medintrgb);
            this.pixelsIndexes[index][pixel] = i;
            if (rgb >> 24 != 0) {
               this.alpha[index][pixel] = (byte)(rgb >> 24);
               this.usesAlpha[index] = true;
            }
         }
      }

   }

   public int convertToMediumInt(int rgb) {
      OutputStream out = new OutputStream(4);
      out.writeInt(rgb);
      InputStream stream = new InputStream(out.getBuffer());
      stream.setOffset(1);
      rgb = stream.read24BitInt();
      return rgb;
   }

   public BufferedImage[] getImages() {
      return this.images;
   }

   public int getBiggestWidth() {
      return this.biggestWidth;
   }

   public void setBiggestWidth(int biggestWidth) {
      this.biggestWidth = biggestWidth;
   }

   public int getBiggestHeight() {
      return this.biggestHeight;
   }

   public void setBiggestHeight(int biggestHeight) {
      this.biggestHeight = biggestHeight;
   }
}
