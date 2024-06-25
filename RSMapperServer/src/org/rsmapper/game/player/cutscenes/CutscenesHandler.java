package org.rsmapper.game.player.cutscenes;

import java.util.HashMap;

public class CutscenesHandler {
   private static final HashMap<Object, Class<Cutscene>> handledCutscenes = new HashMap();

   public static final void init() {
      try {
         Class<Cutscene> value1 = Class.forName(EdgeWilderness.class.getCanonicalName());
         handledCutscenes.put("EdgeWilderness", value1);
         Class<Cutscene> value2 = Class.forName(DTPreview.class.getCanonicalName());
         handledCutscenes.put("DTPreview", value2);
         Class<Cutscene> value4 = Class.forName(TowersPkCutscene.class.getCanonicalName());
         handledCutscenes.put("TowersPkCutscene", value4);
         Class<Cutscene> value5 = Class.forName(HomeCutScene.class.getCanonicalName());
         handledCutscenes.put("HomeCutScene", value5);
         handledCutscenes.put("HomeGazer", Class.forName(HomeGazer.class.getCanonicalName()));
      } catch (Throwable var4) {
         var4.printStackTrace();
      }

   }

   public static final void reload() {
      handledCutscenes.clear();
      init();
   }

   public static final Cutscene getCutscene(Object key) {
      Class<Cutscene> classC = (Class)handledCutscenes.get(key);
      if (classC == null) {
         return null;
      } else {
         try {
            return (Cutscene)classC.newInstance();
         } catch (InstantiationException var3) {
            var3.printStackTrace();
         } catch (IllegalAccessException var4) {
            var4.printStackTrace();
         }

         return null;
      }
   }
}
