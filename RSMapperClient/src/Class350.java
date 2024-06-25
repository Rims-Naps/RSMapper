import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.lang.reflect.Field;
import java.util.Calendar;

public class Class350 implements Interface16 {
   private Font aFont5361;
   static int anInt5362;
   static int anInt5363;
   private int anInt5364;
   static int anInt5365;
   private int anInt5366;
   static int anInt5367;
   static int anInt5368;
   static int anInt5369;
   private boolean aBoolean5370;
   private int anInt5371;
   private boolean aBoolean5372;
   private Color aColor5373;
   private Image anImage5374;
   private Image anImage5375;
   static int anInt5376;
   private Image anImage5377;
   private Image anImage5378;
   private int anInt5379;
   static int anInt5380;
   static int anInt5381;
   private Image anImage5382;
   private Image anImage5383;
   private int anInt5384;
   private int anInt5385;
   private Image anImage5386;
   private int anInt5387;
   private int anInt5388;
   private boolean aBoolean5389;
   private Image anImage5390;
   static Class170 aClass170_5391 = new Class170(6, 1);
   static int anInt5392;
   private int anInt5393;
   static int anInt5394;
   static int anInt5395;
   static int anInt5396;
   private FontMetrics aFontMetrics5397;
   private Image anImage5398;
   static int anInt5399;
   private Image anImage5400;
   static int anInt5401;
   static int anInt5402;
   static int anInt5403;

   @Override
   public final void method62(int i) {
      if (i == 1939) {
         ++anInt5367;
      }
   }

   @Override
   public final int method60(int i) {
      if (i <= 25) {
         return 10;
      } else {
         ++anInt5403;
         return 0;
      }
   }

   private final int method3991(byte b, int i) {
      int i_0_ = -122 / ((-47 - b) / 62);
      ++anInt5392;
      return this.aBoolean5372 ? (Class205.canvasHeight + -i) / 2 : 0;
   }

   static final void method3992(int componentHash, int spriteId, int i_2_) {
      ++anInt5395;
      if (i_2_ != 10) {
         method3992(100, 46, 121);
      }

      CacheNode_Sub2 cachenode_sub2 = Class320_Sub19.method3754(i_2_ + -7, 14, (long)componentHash);
      cachenode_sub2.method2288(0);
      cachenode_sub2.anInt9434 = spriteId;
   }

   static final boolean method3993(byte b) {
      if (b != 108) {
         return true;
      } else {
         ++anInt5401;
         return Class151.anInt1843 >= 1;
      }
   }

   private final int method3994(int i, int i_3_) {
      if (i != -24768) {
         return -96;
      } else {
         ++anInt5365;
         return this.aBoolean5370 ? (Class360.canvasWidth - i_3_) / 2 : 0;
      }
   }

   private final void method3995(int i) throws IllegalAccessException, NoSuchFieldException {
      ++anInt5381;
      Class var_class = Class96.anApplet1270.getClass();
      this.anImage5374 = (Image)this.method4001(var_class, "bar", (byte)-44);
      this.anImage5377 = (Image)this.method4001(var_class, "background", (byte)-44);
      this.anImage5390 = (Image)this.method4001(var_class, "left", (byte)-44);
      this.anImage5375 = (Image)this.method4001(var_class, "right", (byte)-44);
      this.anImage5382 = (Image)this.method4001(var_class, "top", (byte)-44);
      this.anImage5378 = (Image)this.method4001(var_class, "bottom", (byte)-44);
      this.anImage5383 = (Image)this.method4001(var_class, "bodyLeft", (byte)-44);
      this.anImage5398 = (Image)this.method4001(var_class, "bodyRight", (byte)-44);
      this.anImage5386 = (Image)this.method4001(var_class, "bodyFill", (byte)-44);
      this.aFont5361 = (Font)this.method4001(var_class, "bf", (byte)-44);
      this.aFontMetrics5397 = (FontMetrics)this.method4001(var_class, "bfm", (byte)-44);
      this.aColor5373 = (Color)this.method4001(var_class, "colourtext", (byte)-44);
      Object object = this.method4001(var_class, "lb", (byte)-44);
      Class var_class_4_ = object.getClass();
      this.aBoolean5370 = this.method4002(object, var_class_4_, false, "xMiddle");
      this.aBoolean5372 = this.method4002(object, var_class_4_, false, "yMiddle");
      this.anInt5387 = this.method3997(var_class_4_, object, true, "xOffset");
      this.anInt5388 = this.method3997(var_class_4_, object, true, "yOffset");
      if (i != 3630) {
         this.aFont5361 = null;
      }

      this.anInt5371 = this.method3997(var_class_4_, object, true, "width");
      this.anInt5393 = this.method3997(var_class_4_, object, true, "height");
      this.anInt5366 = this.method3997(var_class_4_, object, true, "boxXOffset");
      this.anInt5384 = this.method3997(var_class_4_, object, true, "boxYOffset");
      this.anInt5379 = this.method3997(var_class_4_, object, true, "boxWidth");
      this.anInt5364 = this.method3997(var_class_4_, object, true, "textYOffset");
      this.anInt5385 = this.method3997(var_class_4_, object, true, "offsetPerTenCycles");
   }

   @Override
   public final void method59(int i) {
      if (i == 6312) {
         Class71.method745(22732);
         ++anInt5402;
      }
   }

   private final void updateLoadingScreen(boolean bool) {
      Class163.drawLoadingScreen(
         Class243.aClass340_3069.method3958((byte)84),
         GLDrawableModel.aColorArray5590[Class178.anInt2118],
         Canvas.aColorArray73[Class178.anInt2118],
         Class382.aColorArray5258[Class178.anInt2118],
         Class243.aClass340_3069.method3957((byte)39),
         (byte)-117
      );
      ++anInt5380;
      if (!bool) {
         method3999(30L, true, -119, -71);
      }
   }

   private final int method3997(Class var_class, Object object, boolean bool, String string) throws IllegalAccessException, NoSuchFieldException {
      ++anInt5368;
      Field field = var_class.getDeclaredField(string);
      return !bool ? 101 : field.getInt(object);
   }

   static final int method3998(String string, int i) {
      if (i != -1) {
         aClass170_5391 = null;
      }

      ++anInt5362;
      return Class145.method1638(21642, string, 10, true);
   }

   @Override
   public final boolean method61(boolean bool, long l) {
      ++anInt5394;
      if (bool) {
         method3998(null, 103);
      }

      return true;
   }

   static final String method3999(long l, boolean bool, int i, int i_5_) {
      ++anInt5376;
      Calendar calendar;
      if (!bool) {
         Node_Sub43.method2941(6, l);
         calendar = Class141.aCalendar1756;
      } else {
         Class187.method1876(-1, l);
         calendar = Class141.LAUNCH_DATE;
      }

      int i_6_ = calendar.get(5);
      int i_7_ = calendar.get(2);
      int i_8_ = calendar.get(i_5_);
      int i_9_ = calendar.get(11);
      int i_10_ = calendar.get(12);
      return i == 3
         ? r_Sub1.method2369(bool, -54, l, i)
         : Integer.toString(i_6_ / 10)
            + i_6_ % 10
            + "-"
            + Class13.aStringArrayArray209[i][i_7_]
            + "-"
            + i_8_
            + " "
            + i_9_ / 10
            + i_9_ % 10
            + ":"
            + i_10_ / 10
            + i_10_ % 10;
   }

   public static void method4000(int i) {
      int i_11_ = -94 % ((i - 77) / 37);
      aClass170_5391 = null;
   }

   private final Object method4001(Class var_class, String string, byte b) throws IllegalAccessException, NoSuchFieldException {
      ++anInt5399;
      Field field = var_class.getDeclaredField(string);
      if (b != -44) {
         return null;
      } else {
         Object object = field.get(Class96.anApplet1270);
         field.set(Class96.anApplet1270, null);
         return object;
      }
   }

   @Override
   public final int method58(int i) {
      if (i != 27285) {
         method3999(-112L, false, -70, -27);
      }

      ++anInt5363;
      return 100;
   }

   @Override
   public final void method63(boolean bool, byte b) {
      if (!this.aBoolean5389) {
         if (Class96.anApplet1270 != null) {
            if (this.aFont5361 == null) {
               try {
                  this.method3995(3630);
               } catch (Exception var34) {
                  this.aBoolean5389 = true;
               }
            }
         } else {
            this.aBoolean5389 = true;
         }
      }

      ++anInt5369;
      if (this.aBoolean5389) {
         this.updateLoadingScreen(true);
      } else {
         Graphics graphics = Node_Sub38_Sub20.GAME_CANVAS.getGraphics();
         if (b > -61) {
            this.method3994(-65, -87);
         }

         if (graphics == null) {
            Node_Sub38_Sub20.GAME_CANVAS.repaint();
         } else {
            try {
               int i = Class243.aClass340_3069.method3958((byte)84);
               String string = Class243.aClass340_3069.method3957((byte)106);
               if (Class54.anImage813 == null) {
                  Class54.anImage813 = Node_Sub38_Sub20.GAME_CANVAS.createImage(Class360.canvasWidth, Class205.canvasHeight);
               }

               Graphics graphics_12_ = Class54.anImage813.getGraphics();
               graphics_12_.clearRect(0, 0, Class360.canvasWidth, Class205.canvasHeight);
               int i_13_ = this.anImage5383.getWidth(null);
               int i_14_ = this.anImage5398.getWidth(null);
               int i_15_ = this.anImage5386.getWidth(null);
               int i_16_ = this.anImage5383.getHeight(null);
               int i_17_ = this.anImage5398.getHeight(null);
               int i_18_ = this.anImage5386.getHeight(null);
               graphics_12_.drawImage(
                  this.anImage5383,
                  this.method3994(-24768, i_13_) + this.anInt5366 - this.anInt5379 / 2,
                  this.method3991((byte)-121, i_16_) - -this.anInt5384,
                  null
               );
               int i_19_ = i_13_ + -(this.anInt5379 / 2) + this.anInt5366;
               int i_20_ = this.anInt5379 / 2 + this.anInt5366;

               for(int i_21_ = i_19_; ~i_20_ <= ~i_21_; i_21_ += i_15_) {
                  graphics_12_.drawImage(
                     this.anImage5386, this.method3994(-24768, i_13_) + this.anInt5366 + i_21_, this.method3991((byte)-116, i_18_) - -this.anInt5384, null
                  );
               }

               graphics_12_.drawImage(
                  this.anImage5398,
                  this.method3994(-24768, i_14_) - -this.anInt5366 + this.anInt5379 / 2,
                  this.method3991((byte)-128, i_17_) + this.anInt5384,
                  null
               );
               int i_22_ = this.anImage5390.getWidth(null);
               int i_23_ = this.anImage5390.getHeight(null);
               int i_24_ = this.anImage5375.getWidth(null);
               int i_25_ = this.anImage5375.getHeight(null);
               int i_26_ = this.anImage5378.getHeight(null);
               int i_27_ = this.anImage5382.getWidth(null);
               int i_28_ = this.anImage5382.getHeight(null);
               int i_29_ = this.anImage5378.getWidth(null);
               int i_30_ = this.anImage5374.getWidth(null);
               int i_31_ = this.anImage5377.getWidth(null);
               int i_32_ = this.method3994(-24768, this.anInt5371) - -this.anInt5387;
               int i_33_ = this.method3991((byte)18, this.anInt5393) - -this.anInt5388;
               graphics_12_.drawImage(this.anImage5390, i_32_, i_33_ - -((-i_23_ + this.anInt5393) / 2), null);
               graphics_12_.drawImage(this.anImage5375, i_32_ + this.anInt5371 - i_24_, i_33_ + (this.anInt5393 + -i_25_) / 2, null);
               if (this.anImage5400 == null) {
                  this.anImage5400 = Node_Sub38_Sub20.GAME_CANVAS.createImage(-i_22_ + this.anInt5371 - i_24_, this.anInt5393);
               }

               Graphics graphics_34_ = this.anImage5400.getGraphics();

               for(int i_35_ = 0; ~i_35_ > ~(-i_24_ + this.anInt5371 + -i_22_); i_35_ += i_27_) {
                  graphics_34_.drawImage(this.anImage5382, i_35_, 0, null);
               }

               for(int i_36_ = 0; ~(-i_24_ + this.anInt5371 - i_22_) < ~i_36_; i_36_ += i_29_) {
                  graphics_34_.drawImage(this.anImage5378, i_36_, this.anInt5393 + -i_26_, null);
               }

               int i_37_ = i * (-i_24_ + this.anInt5371 - i_22_) / 100;
               if (~i_37_ < -1) {
                  Image image = Node_Sub38_Sub20.GAME_CANVAS.createImage(i_37_, -i_26_ + -i_28_ + this.anInt5393);
                  int i_38_ = image.getWidth(null);
                  Graphics graphics_39_ = image.getGraphics();
                  int i_40_ = this.anInt5385 * Class295.method3471((byte)-34) / 10 % i_30_;

                  for(int i_41_ = i_40_ + -i_30_; ~i_41_ > ~i_38_; i_41_ += i_30_) {
                     graphics_39_.drawImage(this.anImage5374, i_41_, 0, null);
                  }

                  graphics_34_.drawImage(image, 0, i_28_, null);
               }

               i_37_ = -i_24_ + -i_22_ + this.anInt5371 + -i_37_;
               if (i_37_ > 0) {
                  Image image = Node_Sub38_Sub20.GAME_CANVAS.createImage(i_37_, -i_26_ + -i_28_ + this.anInt5393);
                  int i_43_ = image.getWidth(null);
                  Graphics graphics_44_ = image.getGraphics();

                  for(int i_45_ = 0; i_43_ > i_45_; i_45_ += i_31_) {
                     graphics_44_.drawImage(this.anImage5377, i_45_, 0, null);
                  }

                  graphics_34_.drawImage(image, i_37_, i_28_, null);
               }

               graphics_12_.drawImage(this.anImage5400, i_32_ + i_22_, i_33_, null);
               graphics_12_.setFont(this.aFont5361);
               graphics_12_.setColor(this.aColor5373);
               graphics_12_.drawString(
                  string, (this.anInt5371 + -this.aFontMetrics5397.stringWidth(string)) / 2 + i_32_, this.anInt5364 + 4 + i_33_ + this.anInt5393 / 2
               );
               graphics.drawImage(Class54.anImage813, 0, 0, null);
            } catch (Exception var35) {
               this.aBoolean5389 = true;
            }
         }
      }
   }

   private final boolean method4002(Object object, Class var_class, boolean bool, String string) throws IllegalAccessException, NoSuchFieldException {
      if (bool) {
         this.anInt5366 = -90;
      }

      ++anInt5396;
      Field field = var_class.getDeclaredField(string);
      return field.getBoolean(object);
   }
}
