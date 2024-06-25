import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public final class Sprite {
   public static final int FLAG_VERTICAL = 1;
   public static final int FLAG_ALPHA = 2;
   private final int width;
   private final int height;
   private final BufferedImage[] frames;

   public static Sprite decode(ByteBuffer buffer) {
      try {
         ((java.nio.Buffer)buffer).position(buffer.limit() - 2);
         int size = buffer.getShort() & '\uffff';
         int[] offsetsX = new int[size];
         int[] offsetsY = new int[size];
         int[] subWidths = new int[size];
         int[] subHeights = new int[size];
         ((java.nio.Buffer)buffer).position(buffer.limit() - size * 8 - 7);
         int width = buffer.getShort() & '\uffff';
         int height = buffer.getShort() & '\uffff';
         int[] palette = new int[(buffer.get() & 255) + 1];
         Sprite set = new Sprite(width, height, size);

         for(int i = 0; i < size; ++i) {
            offsetsX[i] = buffer.getShort() & '\uffff';
         }

         for(int i = 0; i < size; ++i) {
            offsetsY[i] = buffer.getShort() & '\uffff';
         }

         for(int i = 0; i < size; ++i) {
            subWidths[i] = buffer.getShort() & '\uffff';
         }

         for(int i = 0; i < size; ++i) {
            subHeights[i] = buffer.getShort() & '\uffff';
         }

         ((java.nio.Buffer)buffer).position(buffer.limit() - size * 8 - 7 - (palette.length - 1) * 3);
         palette[0] = 0;

         for(int index = 1; index < palette.length; ++index) {
            palette[index] = getMedium(buffer);
            if (palette[index] == 0) {
               palette[index] = 1;
            }
         }

         ((java.nio.Buffer)buffer).position(0);

         for(int id = 0; id < size; ++id) {
            int subWidth = subWidths[id];
            int subHeight = subHeights[id];
            int offsetX = offsetsX[id];
            int offsetY = offsetsY[id];
            if (subWidth <= 1000 && subHeight <= 1000 && width <= 1000 && height <= 1000) {
               BufferedImage image = set.frames[id] = new BufferedImage(width, height, 2);
               int[][] indices = new int[subWidth][subHeight];
               int flags = buffer.get() & 255;
               if (image != null) {
                  if ((flags & 1) != 0) {
                     for(int x = 0; x < subWidth; ++x) {
                        for(int y = 0; y < subHeight; ++y) {
                           indices[x][y] = buffer.get() & 255;
                        }
                     }
                  } else {
                     for(int y = 0; y < subHeight; ++y) {
                        for(int x = 0; x < subWidth; ++x) {
                           try {
                              indices[x][y] = buffer.get() & 255;
                           } catch (Exception var23) {
                           }
                        }
                     }
                  }

                  if ((flags & 2) != 0) {
                     if ((flags & 1) != 0) {
                        for(int x = 0; x < subWidth; ++x) {
                           for(int y = 0; y < subHeight; ++y) {
                              int alpha = buffer.get() & 255;
                              image.setRGB(x + offsetX, y + offsetY, alpha << 24 | palette[indices[x][y]]);
                           }
                        }
                     } else {
                        for(int y = 0; y < subHeight; ++y) {
                           for(int x = 0; x < subWidth; ++x) {
                              int alpha = buffer.get() & 255;

                              try {
                                 image.setRGB(x + offsetX, y + offsetY, alpha << 24 | palette[indices[x][y]]);
                              } catch (Exception var22) {
                              }
                           }
                        }
                     }
                  } else {
                     for(int x = 0; x < subWidth; ++x) {
                        for(int y = 0; y < subHeight; ++y) {
                           int index = indices[x][y];
                           if (index == 0) {
                              image.setRGB(x + offsetX, y + offsetY, 0);
                           } else {
                              image.setRGB(x + offsetX, y + offsetY, 0xFF000000 | palette[index]);
                           }
                        }
                     }
                  }
               }
            }
         }

         return set;
      } catch (Exception var24) {
         return null;
      }
   }

   public Sprite(int width, int height) {
      this(width, height, 1);
   }

   public Sprite(int width, int height, int size) {
      if (size < 1) {
         throw new IllegalArgumentException();
      } else {
         this.width = width;
         this.height = height;
         this.frames = new BufferedImage[size];
      }
   }

   public ByteBuffer encode() throws IOException {
      ByteArrayOutputStream bout = new ByteArrayOutputStream();
      DataOutputStream os = new DataOutputStream(bout);

      ByteBuffer var15;
      try {
         List<Integer> palette = new ArrayList<>();
         palette.add(0);

         for(BufferedImage image : this.frames) {
            if (image.getWidth() != this.width || image.getHeight() != this.height) {
               throw new IOException("All frames must be the same size.");
            }

            int flags = 1;

            for(int x = 0; x < this.width; ++x) {
               for(int y = 0; y < this.height; ++y) {
                  int argb = image.getRGB(x, y);
                  int alpha = argb >> 24 & 0xFF;
                  int rgb = argb & 16777215;
                  if (rgb == 0) {
                     rgb = 1;
                  }

                  if (alpha != 0 && alpha != 255) {
                     flags |= 2;
                  }

                  if (!palette.contains(rgb)) {
                     if (palette.size() >= 256) {
                        throw new IOException("Too many colours in this sprite!");
                     }

                     palette.add(rgb);
                  }
               }
            }

            os.write(flags);

            for(int x = 0; x < this.width; ++x) {
               for(int y = 0; y < this.height; ++y) {
                  int argb = image.getRGB(x, y);
                  int alpha = argb >> 24 & 0xFF;
                  int rgb = argb & 16777215;
                  if (rgb == 0) {
                     rgb = 1;
                  }

                  if ((flags & 2) == 0 && alpha == 0) {
                     os.write(0);
                  } else {
                     os.write(palette.indexOf(rgb));
                  }
               }
            }

            if ((flags & 2) != 0) {
               for(int x = 0; x < this.width; ++x) {
                  for(int y = 0; y < this.height; ++y) {
                     int argb = image.getRGB(x, y);
                     int alpha = argb >> 24 & 0xFF;
                     os.write(alpha);
                  }
               }
            }
         }

         for(int i = 1; i < palette.size(); ++i) {
            int rgb = palette.get(i);
            os.write((byte)(rgb >> 16));
            os.write((byte)(rgb >> 8));
            os.write((byte)rgb);
         }

         os.writeShort(this.width);
         os.writeShort(this.height);
         os.write(palette.size() - 1);

         for(int i = 0; i < this.frames.length; ++i) {
            os.writeShort(0);
            os.writeShort(0);
            os.writeShort(this.width);
            os.writeShort(this.height);
         }

         os.writeShort(this.frames.length);
         byte[] bytes = bout.toByteArray();
         var15 = ByteBuffer.wrap(bytes);
      } finally {
         os.close();
      }

      return var15;
   }

   public BufferedImage getFrame(int id) {
      return this.frames[id];
   }

   public int getHeight() {
      return this.height;
   }

   public int getWidth() {
      return this.width;
   }

   public void setFrame(int id, BufferedImage frame) {
      if (frame.getWidth() == this.width && frame.getHeight() == this.height) {
         this.frames[id] = frame;
      } else {
         throw new IllegalArgumentException("The frame's dimensions do not match with the sprite's dimensions.");
      }
   }

   public int size() {
      return this.frames.length;
   }

   public static int getMedium(ByteBuffer buf) {
      return (buf.get() & 0xFF) << 16 | (buf.get() & 0xFF) << 8 | buf.get() & 0xFF;
   }
}
