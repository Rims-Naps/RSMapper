import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.DirectColorModel;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.util.Hashtable;

public class GraphicsBuffer_Sub1 extends GraphicsBuffer {
   private Image anImage9876;
   private Rectangle aRectangle9877;
   private java.awt.Shape aShape9878;
   private java.awt.Canvas aCanvas9879;

   @Override
   final void method2597(int i, int i_0_, int i_1_, boolean bool, Graphics graphics, int i_2_, int i_3_, int i_4_) {
      this.aShape9878 = graphics.getClip();
      this.aRectangle9877.height = i_2_;
      this.aRectangle9877.x = i_1_;
      this.aRectangle9877.y = i_3_;
      this.aRectangle9877.width = i;
      graphics.setClip(this.aRectangle9877);
      graphics.drawImage(this.anImage9876, i_1_ - i_0_, i_3_ - i_4_, this.aCanvas9879);
      graphics.setClip(this.aShape9878);
      if (bool) {
         this.aCanvas9879 = null;
      }
   }

   @Override
   final void method2595(boolean bool, int i, int i_5_, java.awt.Canvas canvas) {
      this.aCanvas9879 = canvas;
      this.aRectangle9877 = new Rectangle();
      this.anInt7142 = i_5_;
      this.anInt7146 = i;
      if (!bool) {
         this.aShape9878 = null;
      }

      this.anIntArray7145 = new int[this.anInt7142 * this.anInt7146];
      DataBufferInt databufferint = new DataBufferInt(this.anIntArray7145, this.anIntArray7145.length);
      DirectColorModel directcolormodel = new DirectColorModel(32, 16711680, 65280, 255);
      WritableRaster writableraster = Raster.createWritableRaster(
         directcolormodel.createCompatibleSampleModel(this.anInt7146, this.anInt7142), databufferint, null
      );
      this.anImage9876 = new BufferedImage(directcolormodel, writableraster, false, new Hashtable());
   }

   GraphicsBuffer_Sub1() {
   }
}
