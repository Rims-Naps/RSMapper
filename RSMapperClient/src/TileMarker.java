import java.util.ArrayList;

public class TileMarker extends EntityNode {
   static IncommingPacket aClass192_5956 = new IncommingPacket(132, -2);
   static IncommingPacket aClass192_5952 = new IncommingPacket(74, 11);
   static IncommingPacket aClass192_5958 = new IncommingPacket(15, 0);
   static IncommingPacket aClass192_5954 = new IncommingPacket(39, 6);
   static int anInt5949;
   protected int pointX1 = 1;
   protected int pointY1 = 1;
   protected int pointX2 = 1;
   protected int pointY2 = 1;
   protected boolean gridPoints;
   protected int x;
   protected int y;
   protected int plane;
   protected int height;
   protected String message;
   protected TileMarker.Type type;
   protected int spriteId = -1;
   protected int color;
   protected int completeCycle;
   ArrayList<Point[]> points = new ArrayList<>();

   public static void method935(int i) {
      aClass192_5952 = null;
      if (i == -7576) {
         aClass192_5958 = null;
         aClass192_5954 = null;
         aClass192_5956 = null;
      }
   }

   static final long getTimeSinceLaunch(int i, int i_0_, int i_1_, int i_2_, int i_3_, int i_4_, byte b) {
      ++anInt5949;
      Class141.LAUNCH_DATE.clear();
      Class141.LAUNCH_DATE.set(i_1_, i, i_3_, i_4_, i_2_, i_0_);
      return b <= 71 ? -52L : Class141.LAUNCH_DATE.getTime().getTime();
   }

   public static enum Type {
      TEXT,
      TILE,
      SHAPE,
      LINE,
      HEIGHT;
   }
}
