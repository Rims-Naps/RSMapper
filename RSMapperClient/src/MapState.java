import java.util.ArrayList;

public class MapState {
   long timeCreated;
   boolean atmosphere;
   ArrayList<TileState> tileStates;
   boolean createdEnvironment;
   int environmentFlag;
   int sunDistanceX;
   int sunDistanceY;
   int sunDistanceZ;
   int highlightcolor;
   float brightness;
   float vibrance;
   float blackpoint;
   int fogcolor;
   int fogdensity;
   int i_7_;
   int i_8_;
   int i_9_;
   int i_10_;
   int i_11_;
   int i_12_;

   public MapState(boolean atmosphere, ArrayList<WorldTile> affectedTiles) {
      this.atmosphere = atmosphere;
      if (!atmosphere) {
         this.tileStates = new ArrayList<>();

         for(int plane = 0; plane < 4; ++plane) {
            for(WorldTile t : affectedTiles) {
               this.tileStates.add(new TileState(new WorldTile(t.getLocalX(), t.getLocalY(), plane, true)));
            }
         }
      } else {
         this.createdEnvironment = RSMapperClient.editor.mapEditor.createdEnvironment;
         this.environmentFlag = RSMapperClient.editor.mapEditor.environmentFlag[0];
         this.sunDistanceX = RSMapperClient.editor.mapEditor.sunDistanceX[0];
         this.sunDistanceY = RSMapperClient.editor.mapEditor.sunDistanceY[0];
         this.sunDistanceZ = RSMapperClient.editor.mapEditor.sunDistanceZ[0];
         this.highlightcolor = RSMapperClient.editor.mapEditor.highlightcolor[0];
         this.brightness = RSMapperClient.editor.mapEditor.brightness[0];
         this.vibrance = RSMapperClient.editor.mapEditor.vibrance[0];
         this.blackpoint = RSMapperClient.editor.mapEditor.blackpoint[0];
         this.fogcolor = RSMapperClient.editor.mapEditor.fogcolor[0];
         this.fogdensity = RSMapperClient.editor.mapEditor.fogdensity[0];
         this.i_7_ = RSMapperClient.editor.mapEditor.i_7_;
         this.i_8_ = RSMapperClient.editor.mapEditor.i_8_;
         this.i_9_ = RSMapperClient.editor.mapEditor.i_9_;
         this.i_10_ = RSMapperClient.editor.mapEditor.i_10_;
         this.i_11_ = RSMapperClient.editor.mapEditor.i_11_;
         this.i_12_ = RSMapperClient.editor.mapEditor.i_12_;
      }

      this.timeCreated = System.currentTimeMillis();
   }

   @Override
   public boolean equals(Object o) {
      if (o instanceof MapState) {
         MapState obj = (MapState)o;
         if (obj.timeCreated == this.timeCreated && obj.atmosphere == this.atmosphere) {
            return true;
         }
      }

      return false;
   }

   @Override
   public int hashCode() {
      return ("ms" + this.atmosphere).hashCode() + (int)this.timeCreated;
   }
}
