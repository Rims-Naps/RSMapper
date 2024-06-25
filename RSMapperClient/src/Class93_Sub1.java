import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class Class93_Sub1 extends Class93 implements MouseListener, MouseMotionListener, MouseWheelListener {
   private int mouseX;
   private Class312 aClass312_6033 = new Class312();
   private int anInt6034;
   private int mouseY;
   private Class312 aClass312_6036 = new Class312();
   private int anInt6037;
   private int anInt6038;
   private int anInt6039;
   private boolean aBoolean6040;
   private Component aComponent6041;

   @Override
   final int getLastMousePosY(boolean bool) {
      return this.mouseY;
   }

   @Override
   public final synchronized void mouseReleased(MouseEvent mouseevent) {
      int i = this.method1055(mouseevent, (byte)123);
      if ((this.anInt6037 & i) == 0) {
         i = this.anInt6037;
      }

      if ((1 & i) != 0) {
         this.handeMouseWheelMove(mouseevent.getY(), mouseevent.getX(), 3, 0, mouseevent.getClickCount());
      }

      if ((4 & i) != 0) {
         this.handeMouseWheelMove(mouseevent.getY(), mouseevent.getX(), 5, 0, mouseevent.getClickCount());
      }

      if ((i & 2) != 0) {
         this.handeMouseWheelMove(mouseevent.getY(), mouseevent.getX(), 4, 0, mouseevent.getClickCount());
      }

      this.anInt6037 &= ~i;
      if (mouseevent.isPopupTrigger()) {
         mouseevent.consume();
      }
   }

   private final void handeMouseWheelMove(int y, int x, int button, int junk, int notches) {
      Node_Sub5_Sub1 node_sub5_sub1 = new Node_Sub5_Sub1();
      node_sub5_sub1.lastMouseX = x;
      node_sub5_sub1.lastClickedMouseButton = button == 2 ? 5 : (button == 5 ? 2 : button);
      node_sub5_sub1.lastMouseY = y;
      node_sub5_sub1.timeSinceMouseClicked = Class313.method3650(false);
      node_sub5_sub1.mouseNotches = notches;
      this.aClass312_6036.method3625((byte)-54, node_sub5_sub1);
   }

   private final void method1053(boolean bool, int i, int i_4_) {
      this.anInt6039 = i_4_;
      this.anInt6038 = i;
      if (this.aBoolean6040) {
         this.handeMouseWheelMove(i, i_4_, -1, 0, 0);
      }
   }

   @Override
   final Node_Sub5 method1048() {
      return (Node_Sub5)this.aClass312_6033.method3619(-83);
   }

   private final void method1054(Component component) {
      this.method1056(-89);
      this.aComponent6041 = component;
      this.aComponent6041.addMouseListener(this);
      this.aComponent6041.addMouseMotionListener(this);
      this.aComponent6041.addMouseWheelListener(this);
   }

   private final int method1055(MouseEvent mouseevent, byte b) {
      if (mouseevent.getButton() == 1) {
         return mouseevent.isMetaDown() ? 4 : 1;
      } else if (mouseevent.getButton() == 2) {
         return 2;
      } else {
         return mouseevent.getButton() == 3 ? 4 : 0;
      }
   }

   private final void method1056(int i) {
      if (this.aComponent6041 != null) {
         this.aComponent6041.removeMouseWheelListener(this);
         this.aComponent6041.removeMouseMotionListener(this);
         this.aComponent6041.removeMouseListener(this);
         if (i >= -2) {
            this.mouseDragged(null);
         }

         this.aClass312_6036 = null;
         this.mouseX = this.mouseY = this.anInt6034 = 0;
         this.aClass312_6033 = null;
         this.anInt6039 = this.anInt6038 = this.anInt6037 = 0;
         this.aComponent6041 = null;
      }
   }

   @Override
   public final synchronized void mouseWheelMoved(MouseWheelEvent mousewheelevent) {
      int x = mousewheelevent.getX();
      int y = mousewheelevent.getY();
      int notches = mousewheelevent.getWheelRotation();
      this.handeMouseWheelMove(y, x, 6, 0, notches);
      mousewheelevent.consume();
   }

   @Override
   public final synchronized void mouseExited(MouseEvent mouseevent) {
      this.method1053(false, mouseevent.getY(), mouseevent.getX());
   }

   @Override
   public final synchronized void mouseDragged(MouseEvent mouseevent) {
      this.method1053(false, mouseevent.getY(), mouseevent.getX());
   }

   @Override
   final boolean method1039() {
      return (this.anInt6034 & 1) != 0;
   }

   @Override
   final int getLastMousePosX() {
      return this.mouseX;
   }

   @Override
   public final synchronized void mousePressed(MouseEvent mouseevent) {
      int i = this.method1055(mouseevent, (byte)-79);
      if (i != 1) {
         if (i != 4) {
            if (i == 2) {
               this.handeMouseWheelMove(mouseevent.getY(), mouseevent.getX(), 1, 0, mouseevent.getClickCount());
            }
         } else {
            this.handeMouseWheelMove(mouseevent.getY(), mouseevent.getX(), 2, 0, mouseevent.getClickCount());
         }
      } else {
         this.handeMouseWheelMove(mouseevent.getY(), mouseevent.getX(), 0, 0, mouseevent.getClickCount());
      }

      this.anInt6037 |= i;
      if (mouseevent.isPopupTrigger()) {
         mouseevent.consume();
      }
   }

   @Override
   final synchronized void method1038() {
      this.anInt6034 = this.anInt6037;
      this.mouseX = this.anInt6039;
      this.mouseY = this.anInt6038;
      Class312 class312 = this.aClass312_6033;
      this.aClass312_6033 = this.aClass312_6036;
      this.aClass312_6036 = class312;
      this.aClass312_6036.method3614(-601);
   }

   @Override
   final boolean method1040() {
      return (4 & this.anInt6034) != 0;
   }

   @Override
   public final synchronized void mouseMoved(MouseEvent mouseevent) {
      this.method1053(false, mouseevent.getY(), mouseevent.getX());
   }

   @Override
   final void method1045() {
      this.method1056(-79);
   }

   @Override
   public final synchronized void mouseEntered(MouseEvent mouseevent) {
      this.method1053(false, mouseevent.getY(), mouseevent.getX());
   }

   @Override
   final boolean method1044() {
      return (this.anInt6034 & 2) != 0;
   }

   @Override
   public final synchronized void mouseClicked(MouseEvent mouseevent) {
      if (mouseevent.isPopupTrigger()) {
         mouseevent.consume();
      }
   }

   Class93_Sub1(Component component, boolean bool) {
      this.method1054(component);
      this.aBoolean6040 = bool;
   }
}
