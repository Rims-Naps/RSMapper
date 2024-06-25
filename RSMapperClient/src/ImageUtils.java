import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.RGBImageFilter;
import java.awt.image.WritableRaster;

public class ImageUtils {
   public static BufferedImage horizontalFlip(BufferedImage img) {
      int w = img.getWidth();
      int h = img.getHeight();
      BufferedImage flippedImage = new BufferedImage(w, h, img.getType());
      Graphics2D g = flippedImage.createGraphics();
      g.drawImage(img, 0, 0, w, h, w, 0, 0, h, null);
      g.dispose();
      return flippedImage;
   }

   public static BufferedImage verticalFlip(BufferedImage img) {
      int w = img.getWidth();
      int h = img.getHeight();
      BufferedImage flippedImage = new BufferedImage(w, h, img.getColorModel().getTransparency());
      Graphics2D g = flippedImage.createGraphics();
      g.drawImage(img, 0, 0, w, h, 0, h, w, 0, null);
      g.dispose();
      return flippedImage;
   }

   public static BufferedImage getScaledImage(BufferedImage src, double factor) {
      int finalw = src.getWidth();
      int finalh = src.getHeight();
      if (src.getWidth() > src.getHeight()) {
         factor = (double)src.getHeight() / (double)src.getWidth();
         finalh = (int)((double)finalw * factor);
      } else {
         factor = (double)src.getWidth() / (double)src.getHeight();
         finalw = (int)((double)finalh * factor);
      }

      BufferedImage resizedImg = new BufferedImage(finalw, finalh, 3);
      Graphics2D g2 = resizedImg.createGraphics();
      g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
      g2.drawImage(src, 0, 0, finalw, finalh, null);
      g2.dispose();
      return resizedImg;
   }

   public static BufferedImage makeColorTransparent(BufferedImage im, Color color) {
      ImageFilter filter = new RGBImageFilter() {
         public int markerRGB;

         {
            this.markerRGB = markerRGB | 0xFF000000;
         }

         @Override
         public final int filterRGB(int x, int y, int rgb) {
            return (rgb | 0xFF000000) == this.markerRGB ? 16777215 & rgb : rgb;
         }
      };
      return imageToBufferedImage(Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(im.getSource(), filter)));
   }

   public static BufferedImage imageToBufferedImage(Image img) {
      if (img instanceof BufferedImage) {
         return (BufferedImage)img;
      } else {
         BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), 2);
         Graphics2D bGr = bimage.createGraphics();
         bGr.drawImage(img, 0, 0, null);
         bGr.dispose();
         return bimage;
      }
   }

   public static BufferedImage convert(BufferedImage src, int bufImgType) {
      BufferedImage img = new BufferedImage(src.getWidth(), src.getHeight(), bufImgType);
      Graphics2D g2d = img.createGraphics();
      g2d.drawImage(src, 0, 0, null);
      g2d.dispose();
      return img;
   }

   public static BufferedImage createColoredBackground(BufferedImage image, Color color) {
      BufferedImage copy = new BufferedImage(image.getWidth(), image.getHeight(), 2);
      Graphics2D g2d = copy.createGraphics();
      g2d.setColor(color);
      g2d.fillRect(0, 0, copy.getWidth(), copy.getHeight());
      g2d.drawImage(image, 0, 0, null);
      g2d.dispose();
      return copy;
   }

   public static BufferedImage resize(BufferedImage img, int newW, int newH) {
      if (newW <= 0) {
         newW = img.getWidth();
      }

      if (newH <= 0) {
         newH = img.getHeight();
      }

      Image tmp = img.getScaledInstance(newW, newH, 4);
      BufferedImage dimg = new BufferedImage(newW, newH, 2);
      Graphics2D g2d = dimg.createGraphics();
      g2d.drawImage(tmp, 0, 0, null);
      g2d.dispose();
      return dimg;
   }

   public static BufferedImage colorImage(BufferedImage image, Color col) {
      int width = image.getWidth();
      int height = image.getHeight();
      WritableRaster raster = image.getRaster();

      for(int xx = 0; xx < width; ++xx) {
         for(int yy = 0; yy < height; ++yy) {
            int[] pixels = raster.getPixel(xx, yy, (int[]) null);
            pixels[0] = col.getRed();
            pixels[1] = col.getGreen();
            pixels[2] = col.getBlue();
            raster.setPixel(xx, yy, pixels);
         }
      }

      return image;
   }
}
