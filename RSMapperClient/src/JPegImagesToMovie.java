import java.awt.Desktop;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.util.Vector;
import javax.media.ConfigureCompleteEvent;
import javax.media.ControllerEvent;
import javax.media.ControllerListener;
import javax.media.DataSink;
import javax.media.EndOfMediaEvent;
import javax.media.Format;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.PrefetchCompleteEvent;
import javax.media.Processor;
import javax.media.RealizeCompleteEvent;
import javax.media.ResourceUnavailableEvent;
import javax.media.Time;
import javax.media.control.TrackControl;
import javax.media.datasink.DataSinkErrorEvent;
import javax.media.datasink.DataSinkEvent;
import javax.media.datasink.DataSinkListener;
import javax.media.datasink.EndOfStreamEvent;
import javax.media.format.VideoFormat;
import javax.media.protocol.ContentDescriptor;
import javax.media.protocol.DataSource;
import javax.media.protocol.PullBufferDataSource;
import javax.media.protocol.PullBufferStream;
import javax.swing.JOptionPane;

public class JPegImagesToMovie implements ControllerListener, DataSinkListener {
   Object waitSync = new Object();
   boolean stateTransitionOK = true;
   Object waitFileSync = new Object();
   boolean fileDone = false;
   boolean fileSuccess = true;

   public boolean doIt(int width, int height, int frameRate, Vector inFiles, MediaLocator outML, int videoNum) throws MalformedURLException {
      JPegImagesToMovie.ImageDataSource ids = new JPegImagesToMovie.ImageDataSource(width, height, frameRate, inFiles);

      Processor p;
      try {
         p = Manager.createProcessor(ids);
      } catch (Exception var17) {
         System.err.println("Yikes!  Cannot create a processor from the data source.");
         return false;
      }

      p.addControllerListener(this);
      p.configure();
      if (!this.waitForState(p, 180)) {
         System.err.println("Failed to configure the processor.");
         return false;
      } else {
         p.setContentDescriptor(new ContentDescriptor("video.quicktime"));
         TrackControl[] tcs = p.getTrackControls();
         Format[] f = tcs[0].getSupportedFormats();
         if (f != null && f.length > 0) {
            tcs[0].setFormat(f[0]);
            p.realize();
            if (!this.waitForState(p, 300)) {
               System.err.println("Failed to realize the processor.");
               return false;
            } else {
               DataSink dsink;
               if ((dsink = this.createDataSink(p, outML)) == null) {
                  System.err.println("Failed to create a DataSink for the given output MediaLocator: " + outML);
                  return false;
               } else {
                  dsink.addDataSinkListener(this);
                  this.fileDone = false;
                  System.out.println("Generating the video : " + outML.getURL().toString());

                  try {
                     p.start();
                     dsink.start();
                  } catch (IOException var16) {
                     System.err.println("IO error during processing");
                     return false;
                  }

                  this.waitForFileDone();

                  try {
                     dsink.close();
                  } catch (Exception var15) {
                  }

                  p.removeControllerListener(this);
                  int choice = JOptionPane.showOptionDialog(null, "View Video?", "Video Saved", 0, 3, null, new Object[]{"Yes", "No"}, "No");
                  if (choice == 0) {
                     try {
                        Desktop.getDesktop().open(new File(Recorder.storeVideo));
                        Desktop.getDesktop().open(new File(Recorder.storeVideo + "/video_" + videoNum + ".mov"));
                     } catch (IOException var14) {
                        var14.printStackTrace();
                     }
                  }

                  return true;
               }
            }
         } else {
            System.err.println("The mux does not support the input format: " + tcs[0].getFormat());
            return false;
         }
      }
   }

   DataSink createDataSink(Processor p, MediaLocator outML) {
      DataSource ds;
      if ((ds = p.getDataOutput()) == null) {
         System.err.println("Something is really wrong: the processor does not have an output DataSource");
         return null;
      } else {
         try {
            DataSink dsink = Manager.createDataSink(ds, outML);
            dsink.open();
            return dsink;
         } catch (Exception var6) {
            System.err.println("Cannot create the DataSink: " + var6);
            return null;
         }
      }
   }

   boolean waitForState(Processor p, int state) {
      synchronized(this.waitSync) {
         try {
            while(p.getState() < state && this.stateTransitionOK) {
               this.waitSync.wait();
            }
         } catch (Exception var5) {
         }
      }

      return this.stateTransitionOK;
   }

   public void controllerUpdate(ControllerEvent evt) {
      if (evt instanceof ConfigureCompleteEvent || evt instanceof RealizeCompleteEvent || evt instanceof PrefetchCompleteEvent) {
         synchronized(this.waitSync) {
            this.stateTransitionOK = true;
            this.waitSync.notifyAll();
         }
      } else if (evt instanceof ResourceUnavailableEvent) {
         synchronized(this.waitSync) {
            this.stateTransitionOK = false;
            this.waitSync.notifyAll();
         }
      } else if (evt instanceof EndOfMediaEvent) {
         evt.getSourceController().stop();
         evt.getSourceController().close();
      }
   }

   boolean waitForFileDone() {
      synchronized(this.waitFileSync) {
         try {
            while(!this.fileDone) {
               this.waitFileSync.wait();
            }
         } catch (Exception var3) {
         }
      }

      return this.fileSuccess;
   }

   public void dataSinkUpdate(DataSinkEvent evt) {
      if (evt instanceof EndOfStreamEvent) {
         synchronized(this.waitFileSync) {
            this.fileDone = true;
            this.waitFileSync.notifyAll();
         }
      } else if (evt instanceof DataSinkErrorEvent) {
         synchronized(this.waitFileSync) {
            this.fileDone = true;
            this.fileSuccess = false;
            this.waitFileSync.notifyAll();
         }
      }
   }

   static void prUsage() {
      System.err.println("Usage: java JpegImagesToMovie -w <width> -h <height> -f <frame rate> -o <output URL> <input JPEG file 1> <input JPEG file 2> ...");
      System.exit(-1);
   }

   static MediaLocator createMediaLocator(String url) {
      MediaLocator ml;
      if (url.indexOf(":") > 0 && (ml = new MediaLocator(url)) != null) {
         return ml;
      } else {
         if (url.startsWith(File.separator)) {
            if ((ml = new MediaLocator("file:" + url)) != null) {
               return ml;
            }
         } else {
            String file = "file:" + System.getProperty("user.dir") + File.separator + url;
            if ((ml = new MediaLocator(file)) != null) {
               return ml;
            }
         }

         return null;
      }
   }

   class ImageDataSource extends PullBufferDataSource {
      JPegImagesToMovie.ImageSourceStream[] streams = new JPegImagesToMovie.ImageSourceStream[1];

      ImageDataSource(int width, int height, int frameRate, Vector images) {
         this.streams[0] = JPegImagesToMovie.this.new ImageSourceStream(width, height, frameRate, images);
      }

      public void setLocator(MediaLocator source) {
      }

      public MediaLocator getLocator() {
         return null;
      }

      public String getContentType() {
         return "raw";
      }

      public void connect() {
      }

      public void disconnect() {
      }

      public void start() {
      }

      public void stop() {
      }

      public PullBufferStream[] getStreams() {
         return this.streams;
      }

      public Time getDuration() {
         return DURATION_UNKNOWN;
      }

      public Object[] getControls() {
         return new Object[0];
      }

      public Object getControl(String type) {
         return null;
      }
   }

   class ImageSourceStream implements PullBufferStream {
      Vector images;
      int width;
      int height;
      VideoFormat format;
      int nextImage = 0;
      boolean ended = false;

      public ImageSourceStream(int width, int height, int frameRate, Vector images) {
         this.width = width;
         this.height = height;
         this.images = images;
         this.format = new VideoFormat("jpeg", new Dimension(width, height), -1, Format.byteArray, (float)frameRate);
      }

      public boolean willReadBlock() {
         return false;
      }

      public void read(javax.media.Buffer buf) throws IOException {
         if (this.nextImage >= this.images.size()) {
            buf.setEOM(true);
            buf.setOffset(0);
            buf.setLength(0);
            this.ended = true;
         } else {
            String imageFile = (String)this.images.elementAt(this.nextImage);
            ++this.nextImage;
            RandomAccessFile raFile = new RandomAccessFile(imageFile, "r");
            byte[] data = null;
            if (buf.getData() instanceof byte[]) {
               data = (byte[])buf.getData();
            }

            if (data == null || (long)data.length < raFile.length()) {
               data = new byte[(int)raFile.length()];
               buf.setData(data);
            }

            raFile.readFully(data, 0, (int)raFile.length());
            buf.setOffset(0);
            buf.setLength((int)raFile.length());
            buf.setFormat(this.format);
            buf.setFlags(buf.getFlags() | 16);
            raFile.close();
         }
      }

      public Format getFormat() {
         return this.format;
      }

      public ContentDescriptor getContentDescriptor() {
         return new ContentDescriptor("raw");
      }

      public long getContentLength() {
         return 0L;
      }

      public boolean endOfStream() {
         return this.ended;
      }

      public Object[] getControls() {
         return new Object[0];
      }

      public Object getControl(String type) {
         return null;
      }
   }
}
