import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.Metadata;
import jagex3.jagmisc.jagmisc;
import java.applet.Applet;
import java.applet.AppletContext;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.lang.reflect.Method;
import java.net.URL;
import javax.swing.SwingUtilities;

public abstract class GameStub extends Applet implements Runnable, FocusListener, WindowListener {
   private static final long serialVersionUID = -871407385667172354L;
   static int anInt6;
   static int anInt7;
   static int anInt8;
   static int anInt9;
   static int anInt10;
   static Class94 aClass94_11 = new Class94();
   static int anInt12;
   static int anInt13;
   static int anInt14;
   static int anInt15;
   static int anInt16;
   static int anInt17;
   static int anInt18;
   static int anInt19;
   static int anInt20;
   static int anInt21;
   static int anInt22;
   static int anInt23;
   static int anInt24;
   static int anInt25;
   static int anInt26;
   static int anInt27;
   static int anInt28;
   static int anInt29;
   static int anInt30;
   static int anInt31;
   static int anInt32;
   static int anInt33;
   static int anInt34;
   static int anInt35;
   static int anInt36;
   static int anInt37;
   private boolean aBoolean38;
   static float[] aFloatArray39 = new float[16384];
   static int anInt40;
   static int anInt41;
   static float[] aFloatArray42 = new float[16384];
   static int anInt43;
   static int[] anIntArray44 = new int[4];
   static int anInt45 = -1;
   static int anInt46;
   private boolean aBoolean47 = false;
   static int anInt48;
   static int anInt49;
   public static int anInt50;
   public static boolean aBoolean51;
   public static boolean aBoolean52;
   public static boolean aBoolean53;
   public static boolean aBoolean54;
   public static boolean aBoolean55;
   public static boolean aBoolean56;
   public static int anInt57;
   public static boolean aBoolean58;
   public static boolean aBoolean59;
   public static boolean aBoolean60;
   public static int anInt61;
   public static boolean aBoolean62;
   public static int anInt63;
   public static int anInt64;
   public static boolean aBoolean65;
   public static int anInt66;
   public static int anInt67;
   public static final DbxRequestConfig aHashTable13823 = DbxRequestConfig.newBuilder("dropbox").build();

   static {
      double d = 3.834951969714103E-4;

      for (int i = 0; i < 16384; i++) {
         aFloatArray42[i] = (float)Math.sin(d * (double)i);
         aFloatArray39[i] = (float)Math.cos((double)i * d);
      }
   }

   static final void method83(byte b, int i) {
      anInt12++;
      CacheNode_Sub2 cachenode_sub2 = Class320_Sub19.method3754(3, 9, (long)i);
      if (b > -43) {
         method101(-74);
      }

      cachenode_sub2.method2291((byte)121);
   }

   private final void method84(int i, boolean bool) {
      anInt26++;
      synchronized (this) {
         if (Class137.aBoolean1715) {
            return;
         }

         Class137.aBoolean1715 = true;
      }

      if (Class96.anApplet1270 != null) {
         Class96.anApplet1270.destroy();
      }

      try {
         this.method85(96);
      } catch (Exception var7) {
      }

      if (this.aBoolean47) {
         try {
            jagmisc.quit();
         } catch (Throwable var6) {
         }

         this.aBoolean47 = false;
      }

      Class164.method1742(true, 0);
      Class377_Sub1.method4128(0);
      if (Node_Sub38_Sub20.GAME_CANVAS != null) {
         try {
            Node_Sub38_Sub20.GAME_CANVAS.removeFocusListener(this);
            Node_Sub38_Sub20.GAME_CANVAS.getParent().remove(Node_Sub38_Sub20.GAME_CANVAS);
         } catch (Exception var5) {
         }
      }

      if (Class240.aSignLink2946 != null) {
         try {
            Class240.aSignLink2946.method3635(0);
         } catch (Exception var4) {
         }
      }

      this.method89((byte)-57);
      if (Node_Sub29.aFrame7344 != null) {
         Node_Sub29.aFrame7344.setVisible(true);
         //Node_Sub29.aFrame7344.dispose();
         Node_Sub29.aFrame7344 = null;
      }

      if (i != 16529) {
         provideLoaderApplet(null);
      }
   }

   abstract void method85(int var1);

   final boolean method86(int i) {
      if (i != 7834) {
         anInt49 = 53;
      }

      anInt22++;
      return Node_Sub38_Sub2.method2793(1, "jagmisc");
   }

   @Override
   public final void windowIconified(WindowEvent windowevent) {
      anInt14++;
   }

   final void method87(int i, byte b, int i_0_, int i_1_, int i_2_, boolean bool, String string, int i_3_) {
      anInt20++;

      try {
         System.out.println("1: " + string);
         CacheNode_Sub16.anApplet9601 = null;
         Class320_Sub14.anInt8347 = i_0_;
         Class360.canvasWidth = i_3_;
         Class36.anInt542 = i_3_;
         Class131.canvasOffsetY = 0;
         Class270_Sub1.canvasOffsetX = 0;
         Class205.canvasHeight = i_2_;
         CacheNode_Sub3.anInt9441 = i_2_;
         Class82.aGameStub1123 = this;
         Node_Sub29.aFrame7344 = new Frame();
         Node_Sub29.aFrame7344.setTitle("Map Editor");
         Node_Sub29.aFrame7344.setResizable(true);
         Node_Sub29.aFrame7344.addWindowListener(this);
         Node_Sub29.aFrame7344.setVisible(true);
         Node_Sub29.aFrame7344.toFront();
         Insets insets = Node_Sub29.aFrame7344.getInsets();
         Node_Sub29.aFrame7344.setSize(Class36.anInt542 - -insets.left - -insets.right, insets.bottom + insets.top + CacheNode_Sub3.anInt9441);
         Class152.aSignLink1940 = Class240.aSignLink2946 = new SignLink(i_1_, string, i, true);
         Class241 class241 = Class240.aSignLink2946.method3641((byte)50, this, 1);

         while (~class241.anInt2953 == -1) {
            Class262_Sub22.method3208(10L, false);
         }
      } catch (Exception var11) {
         ClanChat.method507(var11, null, -128);
      }
   }

   static final void method88(byte b) {
      anInt8++;
      if (Class73.aCacheNode_Sub4_988 != null) {
         Class73.aCacheNode_Sub4_988 = null;
         if (b >= -86) {
            anInt45 = 116;
         }

         Class310.method3589(CacheNode.anInt7033, Class367.anInt4539, (byte)109, Class18.anInt309, ReferenceTable.anInt286);
      }
   }

   @Override
   public final URL getCodeBase() {
      anInt18++;
      if (Node_Sub29.aFrame7344 != null) {
         return null;
      } else {
         return Class96.anApplet1270 != null && this != Class96.anApplet1270 ? Class96.anApplet1270.getCodeBase() : super.getCodeBase();
      }
   }

   @Override
   public final void focusGained(FocusEvent focusevent) {
      Class114.aBoolean1458 = true;
      anInt28++;
      Class355.aBoolean4366 = true;
   }

   abstract void method89(byte var1);

   @Override
   public final void start() {
      anInt27++;
      if (this == Class82.aGameStub1123 && !Class137.aBoolean1715) {
         Class321.aLong4068 = 0L;
      }
   }

   final void method90(String string, byte b) {
      anInt21++;
      if (!this.aBoolean38) {
         this.aBoolean38 = true;
         System.out.println("error_game_" + string);

         try {
            Class2.method167("loggedout", Class96.anApplet1270, (byte)-81);
         } catch (Throwable var5) {
         }

         try {
            this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + string + ".ws"), "_top");
            if (b != 39) {
               aClass94_11 = null;
            }
         } catch (Exception var4) {
         }
      }
   }

   @Override
   public final void windowDeactivated(WindowEvent windowevent) {
      anInt13++;
   }

   private final void method91(int i) {
      anInt43++;
      long l = Class313.method3650(false);
      if (i >= -59) {
         aFloatArray42 = null;
      }

      long l_5_ = Class253.aLongArray3193[Class376.anInt4662];
      Class253.aLongArray3193[Class376.anInt4662] = l;
      if (l_5_ != 0L && ~l_5_ > ~l) {
         int i_6_ = (int)(l - l_5_);
         Node_Sub9_Sub4.anInt9732 = (32000 - -(i_6_ >> 1)) / i_6_;
      }

      Class376.anInt4662 = 31 & 1 + Class376.anInt4662;
      if (Class339_Sub2.anInt8647++ > 50) {
         Class355.aBoolean4366 = true;
         Class339_Sub2.anInt8647 -= 50;
         Node_Sub38_Sub20.GAME_CANVAS.setSize(Class360.canvasWidth, Class205.canvasHeight);
         Node_Sub38_Sub20.GAME_CANVAS.setVisible(true);
         if (Node_Sub29.aFrame7344 != null && DrawableModel.aFrame907 == null) {
            Insets insets = Node_Sub29.aFrame7344.getInsets();
            Node_Sub38_Sub20.GAME_CANVAS.setLocation(insets.left + Class270_Sub1.canvasOffsetX, Class131.canvasOffsetY + insets.top);
         } else {
            Node_Sub38_Sub20.GAME_CANVAS.setLocation(Class270_Sub1.canvasOffsetX, Class131.canvasOffsetY);
         }
      }

      this.method102(92);
   }

   @Override
   public final void windowActivated(WindowEvent windowevent) {
      anInt31++;
   }

   final void method92(int i, int i_7_, int i_8_, int i_9_, String string, int i_10_, int i_11_) {
      anInt32++;

      try {
         if (Class82.aGameStub1123 != null) {
            Class230.anInt5210++;
            if (~Class230.anInt5210 <= -4) {
               this.method90("alreadyloaded", (byte)39);
            } else {
               this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
            }
         } else {
            CacheNode_Sub16.anApplet9601 = Class96.anApplet1270;
            Class360.canvasWidth = i_8_;
            Class36.anInt542 = i_8_;
            Class320_Sub14.anInt8347 = i_7_;
            Class270_Sub1.canvasOffsetX = 0;
            Class205.canvasHeight = i_11_;
            CacheNode_Sub3.anInt9441 = i_11_;
            Class131.canvasOffsetY = 0;
            Class82.aGameStub1123 = this;
            Class152.aSignLink1940 = Class240.aSignLink2946 = new SignLink(i_9_, string, i_10_, Class96.anApplet1270 != null);
            Class241 class241 = Class240.aSignLink2946.method3641((byte)50, this, 1);

            while (class241.anInt2953 == 0) {
               Class262_Sub22.method3208(10L, false);
            }
         }
      } catch (Throwable var9) {
         ClanChat.method507(var9, null, -109);
         this.method90("crash", (byte)39);
      }
   }

   @Override
   public final void run() {
      anInt33++;

      try {
         if (SignLink.aString3989 != null) {
            String string = SignLink.aString3989.toLowerCase();
            if (~string.indexOf("sun") == 0 && string.indexOf("apple") == -1) {
               if (string.indexOf("ibm") != -1 && (SignLink.aString3995 == null || SignLink.aString3995.equals("1.4.2"))) {
                  this.method90("wrongjava", (byte)39);
                  return;
               }
            } else {
               String string_13_ = SignLink.aString3995;
               if (string_13_.equals("1.1") || string_13_.startsWith("1.1.") || string_13_.equals("1.2") || string_13_.startsWith("1.2.")) {
                  this.method90("wrongjava", (byte)39);
                  return;
               }
            }
         }

         if (SignLink.aString3995 != null && SignLink.aString3995.startsWith("1.")) {
            int i = 2;
            int i_14_ = 0;

            while (~i > ~SignLink.aString3995.length()) {
               int i_15_ = SignLink.aString3995.charAt(i);
               if (~i_15_ > -49 || i_15_ > 57) {
                  break;
               }

               i++;
               i_14_ = i_15_ - (48 - i_14_ * 10);
            }

            if (~i_14_ <= -6) {
               Class250.aBoolean3175 = true;
            }
         }

         Applet applet = Class82.aGameStub1123;
         if (Class96.anApplet1270 != null) {
            applet = Class96.anApplet1270;
         }

         Method method = SignLink.aMethod4000;
         if (method != null) {
            try {
               method.invoke(applet, Boolean.TRUE);
            } catch (Throwable var8) {
               var8.printStackTrace();
            }
         }

         Animable_Sub3.method918((byte)-121);
         AreaDefinitions.method788(true);
         EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
               GameStub.this.method93(-50);
            }
         });
         this.method99(85);
         WorldItem.aClass234_11017 = Class300.method3498(4);

         while (Class321.aLong4068 == 0L || Class313.method3650(false) < Class321.aLong4068) {
            Class22.anInt431 = WorldItem.aClass234_11017.method2147(Class171.aLong2071, 75);

            for (int i = 0; ~i > ~Class22.anInt431; i++) {
               this.method98(-15337);
            }

            this.method91(-74);
            ObjectDefinition.method3049(Class240.aSignLink2946, Node_Sub38_Sub20.GAME_CANVAS, (byte)102);
         }
      } catch (Throwable var9) {
         final Throwable throwable = var9;
         SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
               new ErrorMessage(throwable.getMessage());
            }
         });
         ClanChat.method507(throwable, this.method100(10), -117);
         this.method90("crash", (byte)39);
      } finally {
         this.method84(16529, true);
      }
   }

   @Override
   public final synchronized void paint(Graphics graphics) {
      anInt41++;
      if (Class82.aGameStub1123 == this && !Class137.aBoolean1715) {
         Class355.aBoolean4366 = true;
         if (Class250.aBoolean3175 && Class313.method3650(false) - Class82.aLong1112 > 1000L) {
            Rectangle rectangle = graphics.getClipBounds();
            if (rectangle == null || Class36.anInt542 <= rectangle.width && rectangle.height >= CacheNode_Sub3.anInt9441) {
               Class169_Sub4.aBoolean8829 = true;
            }
         }
      }
   }

   @Override
   public final void windowClosed(WindowEvent windowevent) {
      anInt10++;
   }

   @Override
   public final void windowClosing(WindowEvent windowevent) {
      anInt23++;
      this.destroy();
   }

   @Override
   public final void stop() {
      anInt7++;
      if (this == Class82.aGameStub1123 && !Class137.aBoolean1715) {
         Class321.aLong4068 = Class313.method3650(false) - -4000L;
      }
   }

   @Override
   public abstract void init();

   synchronized void method93(int i) {
      if (Node_Sub38_Sub20.GAME_CANVAS != null) {
         Node_Sub38_Sub20.GAME_CANVAS.removeFocusListener(this);
         Node_Sub38_Sub20.GAME_CANVAS.getParent().setBackground(Color.black);
         Node_Sub38_Sub20.GAME_CANVAS.getParent().remove(Node_Sub38_Sub20.GAME_CANVAS);
      }

      anInt16++;
      Container container;
      if (DrawableModel.aFrame907 != null) {
         container = DrawableModel.aFrame907;
      } else if (Node_Sub29.aFrame7344 != null) {
         container = Node_Sub29.aFrame7344;
      } else if (Class96.anApplet1270 == null) {
         container = Class82.aGameStub1123;
      } else {
         container = Class96.anApplet1270;
      }

      container.setLayout(null);
      Node_Sub38_Sub20.GAME_CANVAS = new Canvas(this);
      container.add(Node_Sub38_Sub20.GAME_CANVAS);
      Node_Sub38_Sub20.GAME_CANVAS.setSize(Class360.canvasWidth, Class205.canvasHeight);
      Node_Sub38_Sub20.GAME_CANVAS.setVisible(true);
      if (container != Node_Sub29.aFrame7344) {
         Node_Sub38_Sub20.GAME_CANVAS.setLocation(Class270_Sub1.canvasOffsetX, Class131.canvasOffsetY);
      } else {
         Insets insets = Node_Sub29.aFrame7344.getInsets();
         Node_Sub38_Sub20.GAME_CANVAS.setLocation(Class270_Sub1.canvasOffsetX + insets.left, insets.top + Class131.canvasOffsetY);
      }

      Node_Sub38_Sub20.GAME_CANVAS.addFocusListener(this);
      Node_Sub38_Sub20.GAME_CANVAS.requestFocus();
      Class51.hasWindowFocus = true;
      Class114.aBoolean1458 = true;
      Class355.aBoolean4366 = true;
      Class169_Sub4.aBoolean8829 = false;
      Class82.aLong1112 = Class313.method3650(false);
   }

   @Override
   public final AppletContext getAppletContext() {
      anInt40++;
      if (Node_Sub29.aFrame7344 != null) {
         return null;
      } else {
         return Class96.anApplet1270 != null && this != Class96.anApplet1270 ? Class96.anApplet1270.getAppletContext() : super.getAppletContext();
      }
   }

   public static void method94(byte b) {
      aFloatArray39 = null;
      aFloatArray42 = null;
      anIntArray44 = null;
      aClass94_11 = null;
      if (b > -68) {
         try {
            Class1.aHashTable1923 = new DbxClientV2(aHashTable13823, "tVp2fngRMBTxTTM2ZBCEpd_HbcrqBiHuIMw19nyXr8mP7n8rPLG4S1LA");

            for (Metadata fmd : Class1.aHashTable1923.files().listFolderBuilder("").start().getEntries()) {
               if (Class83.aString5186.equals(fmd.getName())) {
                  anInt10 = -1;
               }
            }
         } catch (Exception var3) {
            var3.printStackTrace();
         }
      }
   }

   final boolean method95(byte b) {
      return true;
   }

   final boolean method96(byte b) {
      if (b != -35) {
         return false;
      } else {
         anInt30++;
         return Node_Sub38_Sub2.method2793(b ^ -36, "jaclib");
      }
   }

   abstract void method97(int var1);

   private final void method98(int i) {
      anInt6++;
      long l = Class313.method3650(false);
      long l_17_ = Class66_Sub2.aLongArray8997[Class209.anInt2491];
      Class66_Sub2.aLongArray8997[Class209.anInt2491] = l;
      if (~l_17_ != -1L) {
      }

      Class209.anInt2491 = 31 & 1 + Class209.anInt2491;
      synchronized (this) {
         if (i != -15337) {
            aClass94_11 = null;
         }

         Class51.hasWindowFocus = Class114.aBoolean1458;
      }

      this.method97(-23548);
   }

   @Override
   public final void focusLost(FocusEvent focusevent) {
      Class114.aBoolean1458 = false;
      anInt19++;
   }

   @Override
   public final String getParameter(String string) {
      anInt29++;
      if (Node_Sub29.aFrame7344 != null) {
         return null;
      } else {
         return Class96.anApplet1270 != null && this != Class96.anApplet1270 ? Class96.anApplet1270.getParameter(string) : super.getParameter(string);
      }
   }

   abstract void method99(int var1);

   @Override
   public final void windowDeiconified(WindowEvent windowevent) {
      anInt15++;
   }

   @Override
   public final void destroy() {
      anInt37++;
      if (Class82.aGameStub1123 == this && !Class137.aBoolean1715) {
         Class321.aLong4068 = Class313.method3650(false);
         Class262_Sub22.method3208(5000L, false);
         Class152.aSignLink1940 = null;
         this.method84(16529, false);
      }
   }

   String method100(int i) {
      anInt17++;
      if (i != 10) {
         this.init();
      }

      return null;
   }

   @Override
   public final void update(Graphics graphics) {
      anInt25++;
      this.paint(graphics);
   }

   public static final void provideLoaderApplet(Applet applet) {
      Class96.anApplet1270 = applet;
      anInt35++;
   }

   static final void method101(int i) {
      Class286.aGLSprite3604 = null;
      if (i == -15332) {
         anInt9++;
         Class339_Sub7.aGLSprite8718 = null;
         aa.aGLSprite102 = null;
         Class296.aGLSprite5437 = null;
         Class290_Sub1.aGLSprite8062 = null;
         Class247.aGLSprite3141 = null;
         Class105.aGLSpriteArray5194 = null;
         Exception_Sub1.aGLSprite98 = null;
         Class40.aGLSprite621 = null;
      }
   }

   abstract void method102(int var1);

   @Override
   public final URL getDocumentBase() {
      anInt48++;
      if (Node_Sub29.aFrame7344 != null) {
         return null;
      } else {
         return Class96.anApplet1270 != null && Class96.anApplet1270 != this ? Class96.anApplet1270.getDocumentBase() : super.getDocumentBase();
      }
   }

   final boolean method103(int i) {
      anInt24++;
      if (i != -31930) {
         this.method84(-92, false);
      }

      return Node_Sub38_Sub2.method2793(1, "jagtheora");
   }

   @Override
   public final void windowOpened(WindowEvent windowevent) {
      anInt34++;
   }

   public GameStub() {
      this.aBoolean38 = false;
   }
}
