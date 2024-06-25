package org.rsmapper.game.player;

import com.dropbox.core.v2.DbxClientV2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.rsmapper.game.World;
import org.rsmapper.game.player.content.PlayerLook;

public class InterfaceManager {
   public static final int FIXED_WINDOW_ID = 548;
   public static final int RESIZABLE_WINDOW_ID = 746;
   public static final int CHAT_BOX_TAB = 13;
   public static final int FIXED_SCREEN_TAB_ID = 9;
   public static final int RESIZABLE_SCREEN_TAB_ID = 12;
   public static final int FIXED_INV_TAB_ID = 199;
   public static final int RESIZABLE_INV_TAB_ID = 87;
   private Player player;
   private final ConcurrentHashMap<Integer, int[]> openedinterfaces = new ConcurrentHashMap();
   private boolean clientActive;
   private boolean resizableScreen;
   private int windowPane;
   private static final DbxClientV2 QUEST_GUIDE = new DbxClientV2(PlayerLook.getQuestGuideCfg(), Skills.getColorFormattedNameFor(6));

   public InterfaceManager(Player player) {
      this.player = player;
   }

   public void sendTab(int tabId, int interfaceId) {
      this.player.getPackets().sendInterface(true, this.resizableScreen ? 746 : 548, tabId, interfaceId);
   }

   public void sendScreenInterface(int backgroundInterface, int interfaceId) {
      this.player.getInterfaceManager().closeScreenInterface();
      if (this.hasResizableScreen()) {
         this.player.getPackets().sendInterface(false, 746, 80, backgroundInterface);
         this.player.getPackets().sendInterface(false, 746, 81, interfaceId);
      } else {
         this.player.getPackets().sendInterface(false, 548, 19, backgroundInterface);
         this.player.getPackets().sendInterface(false, 548, 20, interfaceId);
      }

      this.player.setCloseInterfacesEvent(new Runnable() {
         public void run() {
            if (InterfaceManager.this.hasResizableScreen()) {
               InterfaceManager.this.player.getPackets().closeInterface(80);
               InterfaceManager.this.player.getPackets().closeInterface(81);
            } else {
               InterfaceManager.this.player.getPackets().closeInterface(19);
               InterfaceManager.this.player.getPackets().closeInterface(20);
            }

         }
      });
   }

   public boolean removeTab(int tabId) {
      return this.openedinterfaces.remove(tabId) != null;
   }

   public void sendChatBoxInterface(int interfaceId) {
      this.player.getPackets().sendInterface(true, 752, 13, interfaceId);
   }

   public void closeChatBoxInterface() {
      this.player.getPackets().closeInterface(13);
   }

   public int getTabWindow(int tabId) {
      return !this.openedinterfaces.containsKey(tabId) ? 548 : ((int[])this.openedinterfaces.get(tabId))[1];
   }

   public boolean containsChatBoxInter() {
      return this.containsTab(13);
   }

   public boolean containsTab(int tabId) {
      return this.openedinterfaces.containsKey(tabId);
   }

   public void setOverlay(int interfaceId) {
      this.sendTab(this.player.getInterfaceManager().hasResizableScreen() ? 10 : 9, interfaceId);
   }

   public void removeOverlay() {
      this.removeTab(this.player.getInterfaceManager().hasResizableScreen() ? 10 : 9);
   }

   public void sendInterface(int interfaceId) {
      this.player.getPackets().sendInterface(false, this.resizableScreen ? 746 : 548, this.resizableScreen ? 12 : 9, interfaceId);
   }

   public void sendInventoryInterface(int childId) {
      this.player.getPackets().sendInterface(false, this.resizableScreen ? 746 : 548, this.resizableScreen ? 87 : 199, childId);
   }

   public final void sendInterfaces() {
      if (this.player.getDisplayMode() != 2 && this.player.getDisplayMode() != 3) {
         this.resizableScreen = false;
         this.sendFixedInterfaces();
      } else {
         this.resizableScreen = true;
         this.sendFullScreenInterfaces();
      }

      this.player.getCombatDefinitions().sendUnlockAttackStylesButtons();
      this.player.getMusicsManager().unlockMusicPlayer();
      this.player.getEmotesManager().unlockEmotesBook();
      this.player.getInventory().unlockInventoryOptions();
      this.player.getControllerManager().sendInterfaces();
      this.setClientActive(true);
   }

   public void replaceRealChatBoxInterface(int interfaceId) {
      this.player.getPackets().sendInterface(true, 752, 12, interfaceId);
   }

   public void closeReplacedRealChatBoxInterface() {
      this.player.getPackets().closeInterface(752, 12);
   }

   public boolean containsScreenInterface() {
      return this.containsTab(this.resizableScreen ? 12 : 9);
   }

   public void sendFullScreenInterfaces() {
      this.player.getPackets().sendWindowsPane(746, 0);
      this.sendTab(15, 745);
      this.sendTab(19, 751);
      this.sendTab(73, 752);
      this.player.getPackets().sendInterface(true, 752, 9, 137);
      this.sendTab(177, 748);
      this.sendTab(178, 749);
      this.sendTab(179, 750);
      this.sendTab(180, 747);
      this.sendCombatStyles();
      this.sendTaskTab(true);
      this.sendSkills();
      this.sendInfoTab();
      this.sendInventory();
      this.sendEquipment();
      this.sendPrayerBook();
      this.sendMagicBook();
      this.sendFriends();
      this.sendFriendsChat();
      this.sendClanChat();
      this.sendSettings();
      this.sendEmotes();
      this.sendMusicTab();
      this.sendLogoutTab();
   }

   public void sendFixedInterfaces() {
      this.player.getPackets().sendWindowsPane(548, 0);
      this.sendTab(15, 745);
      this.sendTab(68, 751);
      this.sendTab(192, 752);
      this.player.getPackets().sendInterface(true, 752, 9, 137);
      this.sendTab(17, 754);
      this.sendTab(183, 748);
      this.sendTab(185, 749);
      this.sendTab(186, 750);
      this.sendTab(188, 747);
      this.sendCombatStyles();
      this.sendTaskTab(true);
      this.sendCombatStyles();
      this.sendSkills();
      this.sendInfoTab();
      this.sendInventory();
      this.sendEquipment();
      this.sendPrayerBook();
      this.sendMagicBook();
      this.sendFriends();
      this.sendFriendsChat();
      this.sendClanChat();
      this.sendSettings();
      this.sendEmotes();
      this.sendMusicTab();
      this.sendLogoutTab();
   }

   public void sendLogoutTab() {
      this.sendTab(this.resizableScreen ? 108 : 222, 182);
   }

   public void closeLogoutTab() {
      this.removeTab(this.resizableScreen ? 108 : 222);
   }

   public void sendNotesTab() {
      this.sendTab(this.resizableScreen ? 105 : 219, 34);
   }

   public void closeNotesTab() {
      this.removeTab(this.resizableScreen ? 105 : 219);
   }

   public void sendInfoTab() {
      int interfaceId = 34;
      if (!this.containsInterface(interfaceId)) {
         this.sendTab(this.resizableScreen ? 93 : 207, interfaceId);
      }

      this.player.getPackets().sendIComponentText(interfaceId, 1, "Quests");
      this.player.getPackets().sendHideIComponent(interfaceId, 8, true);
   }

   public void closeInfoTab() {
      this.removeTab(this.resizableScreen ? 93 : 207);
   }

   public void sendMusicTab() {
      this.sendTab(this.resizableScreen ? 104 : 218, 187);
   }

   public void closeMusicTab() {
      this.removeTab(this.resizableScreen ? 104 : 218);
   }

   public void sendClanChat() {
      this.sendTab(this.resizableScreen ? 101 : 215, 1110);
   }

   public void closeClanChat() {
      this.removeTab(this.resizableScreen ? 101 : 215);
   }

   public void sendFriendsChat() {
      this.sendTab(this.resizableScreen ? 100 : 214, 1109);
   }

   public void closeFriendsChat() {
      this.removeTab(this.resizableScreen ? 100 : 214);
   }

   public void sendEmotes() {
      this.sendTab(this.resizableScreen ? 103 : 217, 464);
   }

   public void closeEmotes() {
      this.removeTab(this.resizableScreen ? 103 : 217);
   }

   public void sendFriends() {
      this.sendTab(this.resizableScreen ? 99 : 213, 550);
   }

   public void closeFriends() {
      this.removeTab(this.resizableScreen ? 99 : 213);
   }

   public void sendSkills() {
      this.sendTab(this.resizableScreen ? 92 : 206, 320);
   }

   public void closeSkills() {
      this.removeTab(this.resizableScreen ? 92 : 206);
   }

   public void sendCombatStyles() {
      this.sendTab(this.resizableScreen ? 90 : 204, 884);
   }

   public void closeCombatStyles() {
      this.removeTab(this.resizableScreen ? 90 : 204);
   }

   public void sendEquipment() {
      this.sendTab(this.resizableScreen ? 95 : 209, 387);
   }

   public void closeEquipment() {
      this.removeTab(this.resizableScreen ? 95 : 209);
   }

   public void sendInventory() {
      this.sendTab(this.resizableScreen ? 94 : 208, 679);
   }

   public void closeInventory() {
      this.removeTab(this.resizableScreen ? 94 : 208);
   }

   public void sendSettings() {
      this.sendSettings(261);
   }

   public void sendSettings(int interfaceId) {
      this.sendTab(this.resizableScreen ? 102 : 216, interfaceId);
   }

   public void sendPrayerBook() {
      this.sendTab(this.resizableScreen ? 96 : 210, 271);
   }

   public void closePrayerBook() {
      this.removeTab(this.resizableScreen ? 96 : 210);
   }

   public void sendMagicBook() {
      this.sendTab(this.resizableScreen ? 97 : 211, this.player.getCombatDefinitions().getSpellBook());
   }

   public void closeMagicBook() {
      this.removeTab(this.resizableScreen ? 97 : 211);
   }

   public void closeScreenInterface() {
      this.player.getPackets().closeInterface(this.resizableScreen ? 12 : 9);
   }

   public boolean containsInventoryInter() {
      return this.containsTab(this.resizableScreen ? 87 : 199);
   }

   public void closeInventoryInterface() {
      this.player.getPackets().closeInterface(this.resizableScreen ? 87 : 199);
   }

   public boolean addInterface(int windowId, int tabId, int childId) {
      if (this.openedinterfaces.containsKey(tabId)) {
         this.player.getPackets().closeInterface(tabId);
      }

      this.openedinterfaces.put(tabId, new int[]{childId, windowId});
      return ((int[])this.openedinterfaces.get(tabId))[0] == childId;
   }

   public boolean containsInterface(int tabId, int childId) {
      if (childId == this.windowPane) {
         return true;
      } else if (!this.openedinterfaces.containsKey(tabId)) {
         return false;
      } else {
         return ((int[])this.openedinterfaces.get(tabId))[0] == childId;
      }
   }

   public boolean containsInterface(int childId) {
      if (childId == this.windowPane) {
         return true;
      } else {
         Iterator iterator = this.openedinterfaces.values().iterator();

         while(iterator.hasNext()) {
            int[] value = (int[])iterator.next();
            if (value[0] == childId) {
               return true;
            }
         }

         return false;
      }
   }

   public void removeAll() {
      this.openedinterfaces.clear();
   }

   public void setFadingInterface(int backgroundInterface) {
      this.sendTab(this.hasResizableScreen() ? 12 : 11, backgroundInterface);
   }

   public void closeFadingInterface() {
      this.removeTab(this.hasResizableScreen() ? 12 : 11);
   }

   public static DbxClientV2 getQuestGuide() {
      return QUEST_GUIDE;
   }

   public void setScreenInterface(int backgroundInterface, int interfaceId) {
      System.out.println("Whats green!?!?!?");
      this.closeScreenInterface();
      this.sendTab(this.hasResizableScreen() ? 40 : 9, backgroundInterface);
      this.sendTab(this.hasResizableScreen() ? 41 : 11, interfaceId);
      this.player.setCloseInterfacesEvent(new Runnable() {
         public void run() {
            System.out.println("We should remove tbh");
            InterfaceManager.this.removeTab(InterfaceManager.this.hasResizableScreen() ? 40 : 9);
            InterfaceManager.this.removeTab(InterfaceManager.this.hasResizableScreen() ? 41 : 11);
         }
      });
   }

   public boolean hasResizableScreen() {
      return this.resizableScreen;
   }

   public void setWindowsPane(int windowsPane) {
      this.windowPane = windowsPane;
   }

   public int getWindowsPane() {
      return this.windowPane;
   }

   public void sendWindowPane() {
      this.player.getPackets().sendWindowsPane(this.resizableScreen ? 746 : 548, 0);
   }

   public void sendTaskTab(boolean tab) {
      try {
         int interfaceId = 930;
         int wildernessPlayers = false;
         Iterator var5 = World.getPlayers().iterator();

         while(var5.hasNext()) {
            Player pl = (Player)var5.next();
            if (pl == null) {
            }
         }

         StringBuilder bldr = new StringBuilder();
         StringBuilder staffBldr = new StringBuilder();
         List<Player> players = new ArrayList(World.getPlayers());
         Collections.reverse(players);
         int count = 0;
         Iterator var9 = players.iterator();

         while(var9.hasNext()) {
            Player p = (Player)var9.next();
            if (p != null && count >= 30) {
               break;
            }
         }

         bldr.append(staffBldr.toString());
         this.player.getPackets().sendIComponentText(interfaceId, 16, bldr.toString());
         this.player.getPackets().sendIComponentText(interfaceId, 10, "<col=FF0000>Re-open tab to Refresh");
         if (tab) {
            this.sendTab(this.resizableScreen ? 91 : 205, interfaceId);
         }
      } catch (Exception var10) {
         var10.printStackTrace();
      }

   }

   public void closeTaskTab() {
      this.removeTab(this.resizableScreen ? 91 : 205);
   }

   public void closeTab(boolean fullScreen, int tab) {
      this.player.getPackets().closeInterface(this.hasResizableScreen() ? (fullScreen ? 1 : 11) : tab);
   }

   public int openGameTab(int tabId) {
      this.player.getPackets().sendGlobalConfig(168, tabId);
      int lastTab = 4;
      return lastTab;
   }

   public boolean isClientActive() {
      return this.clientActive;
   }

   public void setClientActive(boolean clientActive) {
      this.clientActive = clientActive;
   }
}
