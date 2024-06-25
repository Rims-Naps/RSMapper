import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.PointerInfo;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.MalformedURLException;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.media.MediaLocator;

public class Recorder {
   public static int screenWidth = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
   public static int screenHeight = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
   public static int captureInterval = 60;
   public static String storeImages = "videos/tmp";
   public static String storeVideo = "videos";
   public static boolean record = false;

   public static void startRecord(final boolean fullscreen) {
      int spriteId = 2047;
      final Image mouseCursor = Utils.getImageFromSprite(28, 28, 2047);
      Thread recordThread = new Thread() {
         @Override
         public void run() {
            int cnt = 0;

            try {
               for(Robot rt = new Robot(); cnt == 0 || Recorder.record; Thread.sleep((long)Recorder.captureInterval)) {
                  int x = fullscreen ? RSMapperClient.client_frame.getX() : RSMapperClient.client_frame.getX() + 79;
                  int y = fullscreen ? RSMapperClient.client_frame.getY() : RSMapperClient.client_frame.getY() + 90;
                  int width = fullscreen ? RSMapperClient.client_frame.getWidth() : Node_Sub38_Sub20.GAME_CANVAS.getWidth();
                  int height = fullscreen ? RSMapperClient.client_frame.getHeight() : Node_Sub38_Sub20.GAME_CANVAS.getHeight();
                  BufferedImage img = rt.createScreenCapture(new Rectangle(x, y, width, height));
                  PointerInfo pointer = MouseInfo.getPointerInfo();
                  int mouseX = (int)pointer.getLocation().getX();
                  int mouseY = (int)pointer.getLocation().getY();
                  img.getGraphics().drawImage(mouseCursor, mouseX - x - 3, mouseY - y, null);
                  ImageIO.write(img, "jpeg", new File("./" + Recorder.storeImages + "/" + System.currentTimeMillis() + ".jpeg"));
                  if (cnt == 0) {
                     Recorder.record = true;
                     cnt = 1;
                  }
               }
            } catch (Exception var11) {
               var11.printStackTrace();
            }
         }
      };
      recordThread.start();
   }

   public static void makeVideo() throws MalformedURLException {
      record = false;
      System.out.println("#### Processing Video ####");
      JPegImagesToMovie imageToMovie = new JPegImagesToMovie();
      Vector<String> imgLst = new Vector<>();
      File f = new File(storeImages);
      File[] fileLst = f.listFiles();

      for(int i = 0; i < fileLst.length; ++i) {
         imgLst.add(fileLst[i].getAbsolutePath());
      }

      int videoNum = new File(storeVideo).listFiles().length;
      MediaLocator oml;
      if ((oml = JPegImagesToMovie.createMediaLocator(storeVideo + "/video_" + videoNum + ".mov")) == null) {
         System.err.println("Cannot build media locator from: " + videoNum);
      } else {
         imageToMovie.doIt(Node_Sub38_Sub20.GAME_CANVAS.getWidth(), Node_Sub38_Sub20.GAME_CANVAS.getHeight(), 1000 / captureInterval, imgLst, oml, videoNum);
      }
   }

   public static void record(boolean fullscreen) {
      try {
         if (!record) {
            System.out.println("######### Starting Easy Capture Recorder #######");
            Thread.sleep(1000L);
            File f = new File(storeImages);
            if (!f.exists()) {
               f.mkdir();
            } else {
               File[] var5;
               for(File img : var5 = f.listFiles()) {
                  img.delete();
               }
            }

            startRecord(fullscreen);
         }
      } catch (Exception var6) {
         var6.printStackTrace();
      }
   }
}
