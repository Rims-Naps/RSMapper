import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.PixelGrabber;

public class Class299 {
   private boolean aBoolean3742 = false;
   private int anInt3743;
   private static int anInt3744 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\u00A3$%^&*()-_=+[{]};:'@#~,<.>/?\\| \u00C4\u00CB\u00CF\u00D6\u00DC\u00E4\u00EB\u00EF\u00F6\u00FC\u00FF\u00DF\u00C1\u00C0\u00C9\u00C8\u00CD\u00CC\u00D3\u00D2\u00DA\u00D9\u00E1\u00E0\u00E9\u00E8\u00ED\u00EC\u00F3\u00F2\u00FA\u00F9\u00C2\u00CA\u00CE\u00D4\u00DB\u00E2\u00EA\u00EE\u00F4\u00FB\u00C6\u00E6\u00E3\u00C3\u00F5\u00D5\u00E7\u00C7"
      .length();
   private int[] anIntArray3745;
   private GLSprite[] aGLSpriteArray3746;
   private static int[] anIntArray3747 = new int[256];
   private int[] anIntArray3748 = new int[4];
   private int anInt3749;

   static {
      for(int i = 0; i < 256; ++i) {
         int i_22_ = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\u00A3$%^&*()-_=+[{]};:'@#~,<.>/?\\| \u00C4\u00CB\u00CF\u00D6\u00DC\u00E4\u00EB\u00EF\u00F6\u00FC\u00FF\u00DF\u00C1\u00C0\u00C9\u00C8\u00CD\u00CC\u00D3\u00D2\u00DA\u00D9\u00E1\u00E0\u00E9\u00E8\u00ED\u00EC\u00F3\u00F2\u00FA\u00F9\u00C2\u00CA\u00CE\u00D4\u00DB\u00E2\u00EA\u00EE\u00F4\u00FB\u00C6\u00E6\u00E3\u00C3\u00F5\u00D5\u00E7\u00C7"
            .indexOf(i);
         if (i_22_ == -1) {
            i_22_ = 74;
         }

         anIntArray3747[i] = i_22_;
      }
   }

   final int method3487() {
      return this.anInt3749 - 1;
   }

   private final void method3488(GraphicsToolkit graphicstoolkit, String string, int[] is, int i, int i_0_, int i_1_, boolean bool) {
      if (i_1_ == 0) {
         bool = false;
      }

      i_1_ |= -16777216;

      for(int i_2_ = 0; i_2_ < string.length(); ++i_2_) {
         int i_3_ = anIntArray3747[string.charAt(i_2_)];
         if (bool) {
            this.aGLSpriteArray3746[i_3_].method1191(i + 1, i_0_ + 1, 0, -16777216, 1);
         }

         this.aGLSpriteArray3746[i_3_].method1191(i, i_0_, 0, i_1_, 1);
         i += this.anIntArray3745[i_3_];
      }
   }

   final int method3489() {
      return this.anInt3743;
   }

   final int method3490(String string) {
      int i = 0;

      for(int i_4_ = 0; i_4_ < string.length(); ++i_4_) {
         int i_5_ = anIntArray3747[string.charAt(i_4_)];
         i += this.anIntArray3745[i_5_];
      }

      return i;
   }

   final void method3491(GraphicsToolkit graphicstoolkit, String string, int i, int i_6_, int i_7_, boolean bool) {
      int i_8_ = this.method3490(string) / 2;
      graphicstoolkit.K(this.anIntArray3748);
      if (i - i_8_ <= this.anIntArray3748[2]
         && i + i_8_ >= this.anIntArray3748[0]
         && i_6_ - this.anInt3743 <= this.anIntArray3748[3]
         && i_6_ + this.anInt3749 >= this.anIntArray3748[1]) {
         this.method3488(graphicstoolkit, string, this.anIntArray3748, i - i_8_, i_6_, i_7_, bool);
      }
   }

   private final void method3492(GraphicsToolkit graphicstoolkit, Font font, FontMetrics fontmetrics, char c, int i, boolean bool) {
      int i_9_ = fontmetrics.charWidth(c);
      int i_10_ = i_9_;
      if (bool) {
         try {
            if (c == '/') {
               bool = false;
            }

            if (c == 'f' || c == 't' || c == 'w' || c == 'v' || c == 'k' || c == 'x' || c == 'y' || c == 'A' || c == 'V' || c == 'W') {
               ++i_9_;
            }
         } catch (Exception var22) {
         }
      }

      int i_11_ = fontmetrics.getMaxAscent();
      int i_12_ = fontmetrics.getMaxAscent() + fontmetrics.getMaxDescent();
      int i_13_ = fontmetrics.getHeight();
      Image image = Node_Sub38_Sub20.GAME_CANVAS.createImage(i_9_, i_12_);
      Graphics graphics = image.getGraphics();
      graphics.setColor(Color.black);
      graphics.fillRect(0, 0, i_9_, i_12_);
      graphics.setColor(Color.white);
      graphics.setFont(font);
      graphics.drawString(String.valueOf(c), 0, i_11_);
      if (bool) {
         graphics.drawString(String.valueOf(c), 1, i_11_);
      }

      int[] is = new int[i_9_ * i_12_];
      PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, i_9_, i_12_, is, 0, i_9_);

      try {
         pixelgrabber.grabPixels();
      } catch (Exception var21) {
      }

      image.flush();
      Object object = null;
      int i_14_ = 0;

      label65:
      for(int i_15_ = 0; i_15_ < i_12_; ++i_15_) {
         for(int i_16_ = 0; i_16_ < i_9_; ++i_16_) {
            int i_17_ = is[i_16_ + i_15_ * i_9_];
            if ((i_17_ & 16777215) != 0) {
               i_14_ = i_15_;
               break label65;
            }
         }
      }

      for(int i_18_ = 0; i_18_ < is.length; ++i_18_) {
         if ((is[i_18_] & 16777215) == 0) {
            is[i_18_] = 0;
         }
      }

      this.anInt3743 = i_11_ - i_14_;
      this.anInt3749 = i_13_;
      this.anIntArray3745[i] = i_10_;
      this.aGLSpriteArray3746[i] = graphicstoolkit.method1235(i_9_, i_9_, i_12_, is, 0, 7468);
   }

   public static void method3493() {
      anIntArray3747 = null;
   }

   Class299(GraphicsToolkit graphicstoolkit, int i, boolean bool, Component component) {
      this.aBoolean3742 = false;
      this.aGLSpriteArray3746 = new GLSprite[256];
      this.anIntArray3745 = new int[256];
      Font font = new Font("Helvetica", bool ? 1 : 0, i);
      FontMetrics fontmetrics = component.getFontMetrics(font);

      for(int i_19_ = 0; i_19_ < anInt3744; ++i_19_) {
         this.method3492(
            graphicstoolkit,
            font,
            fontmetrics,
            "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\u00A3$%^&*()-_=+[{]};:'@#~,<.>/?\\| \u00C4\u00CB\u00CF\u00D6\u00DC\u00E4\u00EB\u00EF\u00F6\u00FC\u00FF\u00DF\u00C1\u00C0\u00C9\u00C8\u00CD\u00CC\u00D3\u00D2\u00DA\u00D9\u00E1\u00E0\u00E9\u00E8\u00ED\u00EC\u00F3\u00F2\u00FA\u00F9\u00C2\u00CA\u00CE\u00D4\u00DB\u00E2\u00EA\u00EE\u00F4\u00FB\u00C6\u00E6\u00E3\u00C3\u00F5\u00D5\u00E7\u00C7"
               .charAt(i_19_),
            i_19_,
            false
         );
      }

      if (bool && this.aBoolean3742) {
         this.aBoolean3742 = false;
         font = new Font("Helvetica", 0, i);
         fontmetrics = component.getFontMetrics(font);

         for(int i_20_ = 0; i_20_ < anInt3744; ++i_20_) {
            this.method3492(
               graphicstoolkit,
               font,
               fontmetrics,
               "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\u00A3$%^&*()-_=+[{]};:'@#~,<.>/?\\| \u00C4\u00CB\u00CF\u00D6\u00DC\u00E4\u00EB\u00EF\u00F6\u00FC\u00FF\u00DF\u00C1\u00C0\u00C9\u00C8\u00CD\u00CC\u00D3\u00D2\u00DA\u00D9\u00E1\u00E0\u00E9\u00E8\u00ED\u00EC\u00F3\u00F2\u00FA\u00F9\u00C2\u00CA\u00CE\u00D4\u00DB\u00E2\u00EA\u00EE\u00F4\u00FB\u00C6\u00E6\u00E3\u00C3\u00F5\u00D5\u00E7\u00C7"
                  .charAt(i_20_),
               i_20_,
               false
            );
         }

         if (!this.aBoolean3742) {
            this.aBoolean3742 = false;

            for(int i_21_ = 0; i_21_ < anInt3744; ++i_21_) {
               this.method3492(
                  graphicstoolkit,
                  font,
                  fontmetrics,
                  "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\u00A3$%^&*()-_=+[{]};:'@#~,<.>/?\\| \u00C4\u00CB\u00CF\u00D6\u00DC\u00E4\u00EB\u00EF\u00F6\u00FC\u00FF\u00DF\u00C1\u00C0\u00C9\u00C8\u00CD\u00CC\u00D3\u00D2\u00DA\u00D9\u00E1\u00E0\u00E9\u00E8\u00ED\u00EC\u00F3\u00F2\u00FA\u00F9\u00C2\u00CA\u00CE\u00D4\u00DB\u00E2\u00EA\u00EE\u00F4\u00FB\u00C6\u00E6\u00E3\u00C3\u00F5\u00D5\u00E7\u00C7"
                     .charAt(i_21_),
                  i_21_,
                  true
               );
            }
         }
      }
   }
}
