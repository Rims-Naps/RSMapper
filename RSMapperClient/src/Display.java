import java.awt.DisplayMode;
import java.awt.Frame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.lang.reflect.Field;

public class Display {
   private DisplayMode aDisplayMode863;
   private GraphicsDevice aGraphicsDevice864;

    private final void enter(Frame frame, int i2) {
        Field field2;
      boolean bool = false;
      try {
            field2 = Class.forName("sun.awt.Win32GraphicsDevice").getDeclaredField("valid");
            field2.setAccessible(true);
            boolean bool_0_ = (Boolean)field2.get(this.aGraphicsDevice864);
         if (bool_0_) {
            bool = true;
                field2.set(this.aGraphicsDevice864, Boolean.FALSE);
         }
      }
        catch (Throwable throwable) {
            // empty catch block
        }
        if (i2 != 1503493474) {
         this.aDisplayMode863 = null;
      }
      try {
         this.aGraphicsDevice864.setFullScreenWindow(frame);
        }
        finally {
         if (bool) {
            try {
                    Field field3 = Class.forName("sun.awt.Win32GraphicsDevice").getDeclaredField("valid");
                    field3.set(this.aGraphicsDevice864, Boolean.TRUE);
                }
                catch (Throwable throwable) {}
            }
        }
        if (bool) {
            try {
                field2 = Class.forName("sun.awt.Win32GraphicsDevice").getDeclaredField("valid");
                field2.set(this.aGraphicsDevice864, Boolean.TRUE);
            }
            catch (Throwable throwable) {
                // empty catch block
            }
         }
      }

    public final void enter(Frame frame, int i2, int i_1_, int i_2_, int i_3_) {
      this.aDisplayMode863 = this.aGraphicsDevice864.getDisplayMode();
      if (this.aDisplayMode863 == null) {
         throw new NullPointerException();
        }
         frame.setUndecorated(true);
         frame.enableInputMethods(false);
         this.enter(frame, 1503493474);
         if (i_3_ == 0) {
            int i_4_ = this.aDisplayMode863.getRefreshRate();
            DisplayMode[] displaymodes = this.aGraphicsDevice864.getDisplayModes();
            boolean bool = false;
            int i_5_ = 0;
            while (~displaymodes.length < ~i_5_) {
                if (i2 == displaymodes[i_5_].getWidth() && displaymodes[i_5_].getHeight() == i_1_ && displaymodes[i_5_].getBitDepth() == i_2_) {
                  int i_6_ = displaymodes[i_5_].getRefreshRate();
                  if (!bool || ~Math.abs(-i_4_ + i_6_) > ~Math.abs(i_3_ - i_4_)) {
                     i_3_ = i_6_;
                     bool = true;
                  }
               }
                ++i_5_;
            }
            if (!bool) {
               i_3_ = i_4_;
            }
         }
        this.aGraphicsDevice864.setDisplayMode(new DisplayMode(i2, i_1_, i_2_, i_3_));
      }

   public final int[] listmodes() {
      DisplayMode[] displaymodes = this.aGraphicsDevice864.getDisplayModes();
      int[] is = new int[displaymodes.length << 2];
        int i2 = 0;
        while (~i2 > ~displaymodes.length) {
            is[i2 << 2] = displaymodes[i2].getWidth();
            is[(i2 << 2) + 1] = displaymodes[i2].getHeight();
            is[(i2 << 2) + 2] = displaymodes[i2].getBitDepth();
            is[(i2 << 2) - -3] = displaymodes[i2].getRefreshRate();
            ++i2;
      }
      return is;
   }

   public final void exit() {
      if (this.aDisplayMode863 != null) {
         this.aGraphicsDevice864.setDisplayMode(this.aDisplayMode863);
         if (!this.aGraphicsDevice864.getDisplayMode().equals(this.aDisplayMode863)) {
            throw new RuntimeException("Did not return to correct resolution!");
         }
         this.aDisplayMode863 = null;
      }
      this.enter(null, 1503493474);
   }

   public Display() throws Exception {
      GraphicsEnvironment graphicsenvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
      this.aGraphicsDevice864 = graphicsenvironment.getDefaultScreenDevice();
      if (!this.aGraphicsDevice864.isFullScreenSupported()) {
            GraphicsDevice[] graphicsdevices;
            GraphicsDevice[] graphicsdevices_7_ = graphicsdevices = graphicsenvironment.getScreenDevices();
            int i2 = 0;
            while (~i2 > ~graphicsdevices_7_.length) {
                GraphicsDevice graphicsdevice = graphicsdevices_7_[i2];
            if (graphicsdevice != null && graphicsdevice.isFullScreenSupported()) {
               this.aGraphicsDevice864 = graphicsdevice;
               return;
            }
                ++i2;
         }
         throw new Exception();
      }
   }
}

