public class Point {
   private int x;
   private int y;

   public Point(int x, int y) {
      this.x = x;
      this.y = y;
   }

   public int getX() {
      return this.x;
   }

   public int getY() {
      return this.y;
   }

   @Override
   public String toString() {
      return "x=" + this.x + ", y=" + this.y;
   }

   @Override
   public boolean equals(Object o) {
      if (o == null) {
         return false;
      } else if (!(o instanceof Point)) {
         return false;
      } else {
         return this.x == ((Point)o).x && this.y == ((Point)o).y;
      }
   }

   @Override
   public int hashCode() {
      return this.x << 8 * this.y << 8;
   }
}
