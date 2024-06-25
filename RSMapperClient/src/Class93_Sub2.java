import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Class93_Sub2 extends Class93 implements MouseListener, MouseMotionListener {
   static int anInt6042;
   static int anInt6043;
   static int anInt6044;
   static int anInt6045;
   static int anInt6046;
   private Class312 aClass312_6047 = new Class312();
   static int anInt6048;
   static Index aClass302_6049;
   static int anInt6050;
   static int anInt6051;
   static int anInt6052;
   static int anInt6053;
   static int anInt6054;
   static int anInt6055;
   static int anInt6056;
   private int mouseX;
   private int mouseY;
   static int mouseCoordX;
   static int mouseCoordY;
   static int mouseLocalX;
   static int mouseLocalY;
   static java.awt.Point mousePointOnTile;
   static int mouseCoordXOnTile;
   static int mouseCoordYOnTile;
   static int anInt6059;
   static int anInt6060;
   static int anInt6061;
   static int anInt6062;
   static int anInt6063;
   static int anInt6064;
   private int anInt6065;
   static int anInt6066;
   static int anInt6067 = 0;
   static int anInt6068;
   private Class312 aClass312_6069 = new Class312();
   private int anInt6070;
   private int anInt6071;
   private int anInt6072;
   private Component aComponent6073;
   private boolean aBoolean6074;

   private final void method1057(int mouseX, int clickcount, int i_1_, int mouseY) {
      ++anInt6053;
      Node_Sub5_Sub2 node_sub5_sub2 = new Node_Sub5_Sub2();
      node_sub5_sub2.anInt9411 = mouseX;
      node_sub5_sub2.anInt9408 = mouseY;
      node_sub5_sub2.anInt9419 = i_1_;
      node_sub5_sub2.anInt9414 = clickcount;
      node_sub5_sub2.aLong9415 = Class313.method3650(false);
      this.aClass312_6069.method3625((byte)-54, node_sub5_sub2);
   }

   @Override
   final boolean method1039() {
      ++anInt6044;
      return (1 & this.anInt6065) != 0;
   }

   @Override
   final boolean method1040() {
      ++anInt6052;
      return (this.anInt6065 & 4) != 0;
   }

   private final int method1058(MouseEvent mouseevent) {
      ++anInt6060;
      int i_4_ = mouseevent.getModifiers();
      boolean bool = (i_4_ & 16) != 0;
      boolean bool_5_ = (i_4_ & 8) != 0;
      boolean bool_6_ = (4 & i_4_) != 0;
      if (bool_5_ && (bool || bool_6_)) {
         bool_5_ = false;
      }

      if (bool && bool_6_) {
         return 4;
      } else if (bool) {
         return 1;
      } else if (bool_5_) {
         return 2;
      } else {
         return bool_6_ ? 4 : 0;
      }
   }

   @Override
   public final synchronized void mouseEntered(MouseEvent mouseevent) {
      ++anInt6046;
      this.setMouseXandY(mouseevent.getX(), mouseevent.getY());
   }

   @Override
   public final synchronized void mouseExited(MouseEvent mouseevent) {
      this.setMouseXandY(mouseevent.getX(), mouseevent.getY());
      ++anInt6063;
   }

   private final void method1059(Component component) {
      ++anInt6055;
      this.aComponent6073 = component;
      this.aComponent6073.addMouseListener(this);
      this.aComponent6073.addMouseMotionListener(this);
   }

   private final void method1060() {
      ++anInt6050;
      if (this.aComponent6073 != null) {
         this.aComponent6073.removeMouseMotionListener(this);
         this.aComponent6073.removeMouseListener(this);
         this.aComponent6073 = null;
         this.aClass312_6069 = null;
         this.aClass312_6047 = null;
         this.mouseX = this.mouseY = this.anInt6065 = 0;
         this.anInt6071 = this.anInt6070 = this.anInt6072 = 0;
      }
   }

   static final void checkCreateRightClickDialogue(GraphicsToolkit graphicstoolkit, boolean bool) {
      if (!Class213.rightClickDialogueIsOpen) {
         Class295.method3470(graphicstoolkit, 117);
      } else {
         Class230_Sub1.createRightClickDialogueBox(95, graphicstoolkit);
      }

      ++anInt6064;
      if (bool) {
         aClass302_6049 = null;
      }
   }

   @Override
   public final synchronized void mouseMoved(MouseEvent mouseevent) {
      this.setMouseXandY(mouseevent.getX(), mouseevent.getY());
      ++anInt6051;
   }

   @Override
   final void method1045() {
      ++anInt6059;
      this.method1060();
   }

   @Override
   public final synchronized void mousePressed(MouseEvent mouseevent) {
      ++anInt6045;
      int i = this.method1058(mouseevent);
      if (i != 1) {
         if (i == 4) {
            this.method1057(mouseevent.getX(), mouseevent.getClickCount(), 2, mouseevent.getY());
         } else if (i == 2) {
            this.method1057(mouseevent.getX(), mouseevent.getClickCount(), 1, mouseevent.getY());
         }
      } else {
         this.method1057(mouseevent.getX(), mouseevent.getClickCount(), 0, mouseevent.getY());
      }

      this.anInt6072 |= i;
      if (mouseevent.isPopupTrigger()) {
         mouseevent.consume();
      }
   }

   @Override
   final int getLastMousePosX() {
      ++anInt6061;
      return this.mouseX;
   }

   @Override
   final int getLastMousePosY(boolean bool) {
      ++anInt6068;
      return this.mouseY;
   }

   private final void setMouseXandY(int mouseX, int mouseY) {
      ++anInt6056;
      this.anInt6071 = mouseX;
      this.anInt6070 = mouseY;
      if (this.aBoolean6074) {
         this.method1057(mouseX, 0, -1, mouseY);
      }
   }

   @Override
   public final synchronized void mouseDragged(MouseEvent mouseevent) {
      ++anInt6048;
      this.setMouseXandY(mouseevent.getX(), mouseevent.getY());
   }

   @Override
   final boolean method1044() {
      ++anInt6066;
      return (this.anInt6065 & 2) != 0;
   }

   @Override
   public final synchronized void mouseClicked(MouseEvent mouseevent) {
      if (mouseevent.isPopupTrigger()) {
         mouseevent.consume();
      }

      ++anInt6054;
   }

   @Override
   final Node_Sub5 method1048() {
      ++anInt6062;
      return (Node_Sub5)this.aClass312_6047.method3619(-119);
   }

   @Override
   public final synchronized void mouseReleased(MouseEvent mouseevent) {
      ++anInt6043;
      int i = this.method1058(mouseevent);
      if ((i & this.anInt6072) == 0) {
         i = this.anInt6072;
      }

      if ((1 & i) != 0) {
         this.method1057(mouseevent.getX(), mouseevent.getClickCount(), 3, mouseevent.getY());
      }

      if ((4 & i) != 0) {
         this.method1057(mouseevent.getX(), mouseevent.getClickCount(), 5, mouseevent.getY());
      }

      if ((2 & i) != 0) {
         this.method1057(mouseevent.getX(), mouseevent.getClickCount(), 4, mouseevent.getY());
      }

      this.anInt6072 &= ~i;
      if (mouseevent.isPopupTrigger()) {
         mouseevent.consume();
      }
   }

   public static void method1063(boolean bool) {
      aClass302_6049 = null;
      if (!bool) {
         method1063(true);
      }
   }

   @Override
   final synchronized void method1038() {
      ++anInt6042;
      this.anInt6065 = this.anInt6072;
      this.mouseX = this.anInt6071;
      this.mouseY = this.anInt6070;
      Class312 class312 = this.aClass312_6047;
      this.aClass312_6047 = this.aClass312_6069;
      this.aClass312_6069 = class312;
      this.aClass312_6069.method3614(-601);
   }

   Class93_Sub2(Component component, boolean bool) {
      this.method1059(component);
      this.aBoolean6074 = bool;
   }
}
