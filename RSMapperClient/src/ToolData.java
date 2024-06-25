import java.util.HashMap;

public class ToolData {
   static int[] defaultDoubleClickAction = new int[]{ToolData.ActionValues.SINGLE_COPY.getValue(), ToolData.ActionValues.SINGLE_SPAWN.getValue()};
   static int defaultMapHeight;
   static int defaultMapFlag;
   static int defaultMapOverlay;
   static int defaultMapUnderlay;
   static int defaultMapShape;
   static int defaultMapRotation;
   static int defaultUMapHeight;
   static int defaultUMapOverlay;
   static int defaultUMapUnderlay;
   static int defaultUMapShape;
   static int defaultUMapRotation;
   static int[][] copiedProperties = new int[2][6];
   static int defaultObjectId = -1;
   static int defaultObjectType;
   static int defaultObjectRotation;
   static boolean defaultSpawnUnderland = false;
   static boolean defaultObjectRandomizeRotation;
   static boolean defaultObjectRemoveAll;
   static boolean defaultObjectCopyAbovePlanes;
   static boolean defaultObjectDeleteOnCopy;
   static boolean defaultObjectPasteInputRotation;
   static int[][][] defaultCopiedObjects = new int[4][4][3];
   static int[] brushDoubleClickAction = new int[]{ToolData.ActionValues.BRUSH_APPLY.getValue(), ToolData.ActionValues.BRUSH_SPAWN.getValue()};
   static boolean[][] includedBrushProperties = new boolean[2][6];
   static int[][] brushProperties = new int[2][6];
   static boolean[] brushIncludedObjectSlots = new boolean[]{true, false, false};
   static int[] brushIncludedObjectId = new int[]{-1, -1, -1};
   static int[] brushIncludedObjectType = new int[3];
   static int[] brushIncludedObjectRotation = new int[3];
   static boolean brushObjectRandomizeRotation;
   static boolean brushObjectRemoveAll;
   static boolean brushObjectCopyAbovePlanes;
   static boolean brushObjectDeleteOnCopy;
   static int brushObjectsCopiedFromPlane;
   static HashMap<int[], int[][]> brushCopiedObjects;
   static int[] heightDoubleClickAction = new int[]{ToolData.ActionValues.HEIGHT_SMOOTH.getValue(), -1};
   static HeightTool.Mode heightMode;
   static boolean heightSmoothUndermap = false;
   static boolean heightHillUndermap = false;
   static boolean heightInverseHill = false;
   static int heightHillIntensity = 1;
   static boolean heightAdjustDown = false;
   static boolean heightAdjustUndermap = false;
   static int heightAdjustValue = 1;
   static boolean heightRampUndermap = false;
   static boolean[] HeightSameincludedPlanes = new boolean[3];
   static int[] bridgeDoubleClickAction = new int[]{ToolData.ActionValues.BRIDGE_MAKE.getValue(), -1};
   static int bridgeOverlay;
   static int bridgeFloorObjectId = -1;
   static int bridgeFloorObjectRotation;
   static boolean bridgeManualHeights;
   static int bridgeHeightPoint1;
   static int bridgeHeightPoint2;
   static int[] shapeDoubleClickAction = new int[]{ToolData.ActionValues.SHAPE_APPLY.getValue(), -1};
   static boolean shapeUseOverlay;
   static int shapeOverlay;
   static boolean shapeUseUnderlay;
   static int shapeUnderlay;
   static boolean shapeShowOnHover;
   static int[] FXDoubleClickAction = new int[]{ToolData.ActionValues.EFFECTS_POSITION.getValue(), -1};
   static CachedEffect FXToolEffectOnTile;
   static CachedEffect FXToolCopiedEffect;

   public static enum ActionValues {
      TELEPORT,
      LOAD_REGION,
      LOAD_REGION_DATA,
      SINGLE_COPY,
      SINGLE_PASTE,
      SINGLE_SPAWN,
      SINGLE_REMOVE,
      SINGLE_OBJ_COPY,
      SINGLE_OBJ_PASTE,
      BRUSH_APPLY,
      BRUSH_SPAWN,
      BRUSH_REMOVE,
      BRUSH_OBJ_COPY,
      BRUSH_OBJ_PASTE,
      HEIGHT_SMOOTH,
      HEIGHT_RAMP,
      HEIGHT_RAMP_CLEAR,
      HEIGHT_HILL,
      HEIGHT_ADJUST,
      HEIGHT_SAME,
      BRIDGE_MAKE,
      BRIDGE_CLEAR_POINTS,
      EFFECTS_POSITION,
      EFFECTS_DELETE,
      EFFECTS_COPY,
      EFFECTS_PASTE,
      SHAPE_APPLY,
      SHAPE_REVERSE,
      SHAPE_COPY,
      SHAPE_REMOVE,
      SHAPE_CLEAR_POINTS;

      public int getValue() {
         return this.ordinal() + 2;
      }

      public static ToolData.ActionValues getActionByValue(int value) {
         for(int i = 0; i < values().length; ++i) {
            if (values()[i].getValue() == value) {
               return values()[i];
            }
         }

         return null;
      }

      public static int[] getValues() {
         int[] values = new int[values().length];

         for(int i = 0; i < values.length; ++i) {
            values[i] = values()[i].getValue();
         }

         return values;
      }
   }
}
