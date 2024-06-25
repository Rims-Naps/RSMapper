public class TileState {
   WorldTile tile;
   int height;
   byte flag;
   byte overlay;
   byte underlay;
   byte shape;
   byte rotation;
   int um_height;
   byte um_overlay;
   byte um_underlay;
   byte um_shape;
   byte um_rotation;
   CachedEffect effect;
   int[][] objects;
   int[][] ul_objects;

   public TileState(WorldTile tile) {
      this.tile = tile;
      int localX = tile.getLocalX();
      int localY = tile.getLocalY();
      int plane = tile.getPlane();
      this.height = RSMapperClient.editor.mapEditor.heights[plane][localX][localY];
      this.flag = RSMapperClient.editor.mapEditor.flags[plane][localX][localY];
      this.overlay = RSMapperClient.editor.mapEditor.overlays[plane][localX][localY];
      this.underlay = RSMapperClient.editor.mapEditor.underlays[plane][localX][localY];
      this.shape = RSMapperClient.editor.mapEditor.shapes[plane][localX][localY];
      this.rotation = RSMapperClient.editor.mapEditor.rotations[plane][localX][localY];
      if (plane == 0 && RSMapperClient.undermapArchiveId != -1) {
         this.um_height = RSMapperClient.editor.mapEditor.um_heights[plane][localX][localY];
         this.um_overlay = RSMapperClient.editor.mapEditor.um_overlays[plane][localX][localY];
         this.um_underlay = RSMapperClient.editor.mapEditor.um_underlays[plane][localX][localY];
         this.um_shape = RSMapperClient.editor.mapEditor.um_shapes[plane][localX][localY];
         this.um_rotation = RSMapperClient.editor.mapEditor.um_rotations[plane][localX][localY];
      }

      this.effect = RSMapperClient.editor.mapEditor.getEffectOnTile(tile);
      this.objects = RSMapperClient.editor.objectEditor.getObjectsOnTile(tile, false);
      if (plane == 0 && RSMapperClient.underlandArchiveId != -1) {
         this.ul_objects = RSMapperClient.editor.objectEditor.getObjectsOnTile(tile, true);
      }
   }

   @Override
   public boolean equals(Object o) {
      if (o instanceof WorldTile && ((WorldTile)o).equals(this.tile)) {
         return true;
      } else {
         return o instanceof TileState && ((TileState)o).tile.equals(this.tile);
      }
   }

   @Override
   public int hashCode() {
      return ("ts" + this.tile.toString()).hashCode();
   }
}
