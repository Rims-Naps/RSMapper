public class TemporaryItemDefinition {
   protected int[] maleWornModelIds;
   static long aLong562 = -1L;
   protected short[] modifiedTextureColors;
   protected int[] anIntArray564;
   static d aD565;
   protected int[] femaleWornModelIds;
   protected short[] modifiedModelColors;
   protected int[] anIntArray568 = new int[2];
   static int anInt569;

   public static void method402(int i) {
      aD565 = null;
      if (i != 0) {
         aLong562 = 8L;
      }
   }

   static final void method403(int i) {
      ++anInt569;
      if (Node_Sub38_Sub8.anInt10163 != i) {
         Class320_Sub23.aClass123_8432.method1513(i ^ -28176);
         Class375.method4115((byte)-97);
         Class297.method3479((byte)-119);
      }
   }

   TemporaryItemDefinition(ItemDefinitions itemdefinition) {
      this.anIntArray564 = new int[2];
      this.maleWornModelIds = new int[3];
      this.femaleWornModelIds = new int[3];
      this.maleWornModelIds[0] = itemdefinition.maleEquip1;
      this.maleWornModelIds[1] = itemdefinition.maleEquip2;
      this.maleWornModelIds[2] = itemdefinition.maleEquipModelId3;
      this.femaleWornModelIds[0] = itemdefinition.femaleEquip1;
      this.femaleWornModelIds[1] = itemdefinition.femaleEquip2;
      this.femaleWornModelIds[2] = itemdefinition.femaleEquipModelId3;
      this.anIntArray564[0] = itemdefinition.maleDialogueModel;
      this.anIntArray564[1] = itemdefinition.maleDialogueHat;
      this.anIntArray568[0] = itemdefinition.femaleDialogueModel;
      this.anIntArray568[1] = itemdefinition.femaleDialogueHat;
      if (itemdefinition.modifiedModelColors != null) {
         this.modifiedModelColors = new short[itemdefinition.modifiedModelColors.length];
         Class311.method3606(itemdefinition.modifiedModelColors, 0, this.modifiedModelColors, 0, this.modifiedModelColors.length);
      }

      if (itemdefinition.modifiedTextureColors != null) {
         this.modifiedTextureColors = new short[itemdefinition.modifiedTextureColors.length];
         Class311.method3606(itemdefinition.modifiedTextureColors, 0, this.modifiedTextureColors, 0, this.modifiedTextureColors.length);
      }
   }
}
