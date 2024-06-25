public class Node_Sub11 extends Node {
   static int anInt7103;
   protected Class312 aClass312_7104 = new Class312();
   static int anInt7105 = 0;
   static int anInt7106;

   static final Node_Sub14 method2542(byte b) {
      ++anInt7106;
      if (WorldmapDefinitions.aClass312_331 != null && NpcDefinition.aClass157_2880 != null) {
         NpcDefinition.aClass157_2880.method1715(WorldmapDefinitions.aClass312_331, b ^ -74);
         Node_Sub14 node_sub14 = (Node_Sub14)NpcDefinition.aClass157_2880.method1714(2);
         if (node_sub14 == null) {
            return null;
         } else {
            if (b != -36) {
               method2542((byte)-128);
            }

            AreaDefinitions class79 = WorldmapDefinitions.aClass215_322.getAreaDefinitions((byte)115, node_sub14.anInt7128);
            return class79 != null && class79.aBoolean1064 && class79.method784((byte)127, WorldmapDefinitions.anInterface17_317)
               ? node_sub14
               : Class195.method1985(true);
         }
      } else {
         return null;
      }
   }

   static final void method2543(int i, int i_0_) {
      ++anInt7103;
      if (CacheNode_Sub15.loadInterface(7015, i)) {
         IComponentDefinitions[] widgets = Class134_Sub3.aWidgetArrayArray9035[i];

         for(int i_1_ = i_0_; ~i_1_ > ~widgets.length; ++i_1_) {
            IComponentDefinitions widget = widgets[i_1_];
            if (widget != null && widget.anAnimator4755 != null) {
               widget.anAnimator4755.method235(0);
            }
         }
      }
   }
}
