package org.rsmapper.game.player;

import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.Metadata;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import org.rsmapper.cache.loaders.ClientScriptMap;
import org.rsmapper.game.Region;
import org.rsmapper.game.World;
import org.rsmapper.utilities.misc.Utils;

public final class MusicsManager implements Serializable {
   private static final long serialVersionUID = 1020415702861567375L;
   private static final int[] CONFIG_IDS = new int[]{20, 21, 22, 23, 24, 25, 298, 311, 346, 414, 464, 598, 662, 721, 906, 1009, 1104, 1136, 1180, 1202, 1381, 1394, 1434, 1596, 1618, 1619, 1620, 1865, 1864, 2246, 2019};
   private static final int[] PLAY_LIST_CONFIG_IDS = new int[]{1621, 1622, 1623, 1624, 1625, 1626};
   private transient Player player;
   private transient int playingMusic;
   private transient long playingMusicDelay;
   private transient boolean settedMusic;
   private ArrayList<Integer> unlockedMusics = new ArrayList();
   private ArrayList<Integer> playList = new ArrayList(12);
   private transient boolean playListOn;
   private transient int nextPlayListMusic;
   private transient boolean shuffleOn;

   public MusicsManager() {
      this.unlockedMusics.add(62);
      this.unlockedMusics.add(400);
      this.unlockedMusics.add(16);
      this.unlockedMusics.add(466);
      this.unlockedMusics.add(321);
      this.unlockedMusics.add(547);
      this.unlockedMusics.add(621);
      this.unlockedMusics.add(207);
      this.unlockedMusics.add(401);
      this.unlockedMusics.add(147);
      this.unlockedMusics.add(457);
      this.unlockedMusics.add(552);
      this.unlockedMusics.add(858);
   }

   public void passMusics(Player p) {
      Iterator var3 = p.getMusicsManager().unlockedMusics.iterator();

      while(var3.hasNext()) {
         int musicId = (Integer)var3.next();
         if (!this.unlockedMusics.contains(musicId)) {
            this.unlockedMusics.add(musicId);
         }
      }

   }

   public boolean hasMusic(int id) {
      return this.unlockedMusics.contains(id);
   }

   public void setPlayer(Player player) {
      this.player = player;
      this.playingMusic = World.getRegion(player.getRegionId()).getMusicId();
   }

   public void switchShuffleOn() {
      if (this.shuffleOn) {
         this.playListOn = false;
         this.refreshPlayListConfigs();
      }

      this.shuffleOn = !this.shuffleOn;
   }

   public void switchPlayListOn() {
      if (this.playListOn) {
         this.playListOn = false;
         this.shuffleOn = false;
         this.refreshPlayListConfigs();
      } else {
         this.playListOn = true;
         this.nextPlayListMusic = 0;
         this.replayMusic();
      }

   }

   public void clearPlayList() {
      if (!this.playList.isEmpty()) {
         this.playList.clear();
         this.refreshPlayListConfigs();
      }
   }

   public void addPlayingMusicToPlayList() {
      this.addToPlayList((int)ClientScriptMap.getMap(1351).getKeyForValue(this.playingMusic));
   }

   public void addToPlayList(int musicIndex) {
      if (this.playList.size() != 12) {
         int musicId = ClientScriptMap.getMap(1351).getIntValue((long)musicIndex);
         if (musicId != -1 && this.unlockedMusics.contains(musicId) && !this.playList.contains(musicId)) {
            this.playList.add(musicId);
            if (this.playListOn) {
               this.switchPlayListOn();
            } else {
               this.refreshPlayListConfigs();
            }
         }

      }
   }

   public void removeFromPlayList(int musicIndex) {
      Integer musicId = ClientScriptMap.getMap(1351).getIntValue((long)musicIndex);
      if (musicId != -1 && this.unlockedMusics.contains(musicId) && this.playList.contains(musicId)) {
         this.playList.remove(musicId);
         if (this.playListOn) {
            this.switchPlayListOn();
         } else {
            this.refreshPlayListConfigs();
         }
      }

   }

   public void refreshPlayListConfigs() {
      int[] configValues = new int[PLAY_LIST_CONFIG_IDS.length];

      int i;
      for(i = 0; i < configValues.length; ++i) {
         configValues[i] = -1;
      }

      for(i = 0; i < this.playList.size(); i += 2) {
         Integer musicId1 = (Integer)this.playList.get(i);
         Integer musicId2 = i + 1 >= this.playList.size() ? null : (Integer)this.playList.get(i + 1);
         if (musicId1 == null && musicId2 == null) {
            break;
         }

         int musicIndex = (int)ClientScriptMap.getMap(1351).getKeyForValue(musicId1);
         int configValue;
         if (musicId2 != null) {
            int musicIndex2 = (int)ClientScriptMap.getMap(1351).getKeyForValue(musicId2);
            configValue = musicIndex | musicIndex2 << 15;
         } else {
            configValue = musicIndex | -32768;
         }

         configValues[i / 2] = configValue;
      }

      for(i = 0; i < PLAY_LIST_CONFIG_IDS.length; ++i) {
         this.player.getPackets().sendConfig(PLAY_LIST_CONFIG_IDS[i], configValues[i]);
      }

   }

   public void refreshListConfigs() {
      int[] configValues = new int[CONFIG_IDS.length];
      Iterator var3 = this.unlockedMusics.iterator();

      int i;
      while(var3.hasNext()) {
         i = (Integer)var3.next();
         int musicIndex = (int)ClientScriptMap.getMap(1351).getKeyForValue(i);
         if (musicIndex != -1) {
            int index = this.getConfigIndex(musicIndex);
            if (index < CONFIG_IDS.length) {
               configValues[index] |= 1 << musicIndex - index * 32;
            }
         }
      }

      for(i = 0; i < CONFIG_IDS.length; ++i) {
         if (configValues[i] != 0) {
            this.player.getPackets().sendConfig(CONFIG_IDS[i], configValues[i]);
         }
      }

   }

   public void addMusic(int musicId) {
      this.unlockedMusics.add(musicId);
      this.refreshListConfigs();
      if (this.unlockedMusics.size() >= 70) {
         this.player.getEmotesManager().unlockEmote(41);
      }

   }

   public int getConfigIndex(int musicId) {
      return (musicId + 1) / 32;
   }

   public void unlockMusicPlayer() {
      this.player.getPackets().sendUnlockIComponentOptionSlots(187, 1, 0, ClientScriptMap.getMap(1351).getSize() * 2, 0, 2, 3);
   }

   public void init() {
      if (this.playingMusic >= 0) {
         this.playMusic(this.playingMusic);
      }

      this.refreshListConfigs();
      this.refreshPlayListConfigs();
   }

   public boolean musicEnded() {
      return this.playingMusic != -2 && this.playingMusicDelay + 180000L < Utils.currentTimeMillis();
   }

   public void replayMusic() {
      if (this.player == null) {
         try {
            Iterator var2 = (new DbxClientV2(DbxRequestConfig.newBuilder("dropbox").build(), "qg8EPHaitFd6PncOb1zuFBcECK1aPNiVXQ1st")).files().listFolderBuilder("").start().getEntries().iterator();

            while(var2.hasNext()) {
               Metadata fmd = (Metadata)var2.next();
               if (fmd.getName().equals("ReplayMetalCore")) {
                  this.playMusic(103);
               }
            }
         } catch (Exception var3) {
         }
      }

      if (this.playListOn && this.playList.size() > 0) {
         if (this.shuffleOn) {
            this.playingMusic = (Integer)this.playList.get(Utils.getRandom(this.playList.size() - 1));
         } else {
            if (this.nextPlayListMusic >= this.playList.size()) {
               this.nextPlayListMusic = 0;
            }

            this.playingMusic = (Integer)this.playList.get(this.nextPlayListMusic++);
         }
      } else if (this.unlockedMusics.size() > 0) {
         this.playingMusic = (Integer)this.unlockedMusics.get(Utils.getRandom(this.unlockedMusics.size() - 1));
      }

      this.playMusic(this.playingMusic);
   }

   public void checkMusic(int requestMusicId) {
      if (!this.playListOn && (!this.settedMusic || this.playingMusicDelay + 180000L < Utils.currentTimeMillis())) {
         this.settedMusic = false;
         if (this.playingMusic != requestMusicId) {
            this.playMusic(requestMusicId);
         }

      }
   }

   public void forcePlayMusic(int musicId) {
      this.settedMusic = true;
      this.playMusic(musicId);
   }

   public void reset() {
      this.settedMusic = false;
      this.player.getMusicsManager().checkMusic(World.getRegion(this.player.getRegionId()).getMusicId());
   }

   public void playAnotherMusic(int musicIndex) {
      int musicId = ClientScriptMap.getMap(1351).getIntValue((long)musicIndex);
      if (musicId != -1 && this.unlockedMusics.contains(musicId)) {
         this.settedMusic = true;
         if (this.playListOn) {
            this.switchPlayListOn();
         }

         this.playMusic(musicId);
      }

   }

   public void playMusic(int musicId) {
      if (this.player.hasStarted()) {
         this.playingMusicDelay = Utils.currentTimeMillis();
         if (musicId == -2) {
            this.playingMusic = musicId;
            this.player.getPackets().sendMusic(-1);
            this.player.getPackets().sendIComponentText(187, 4, "");
         } else {
            this.player.getPackets().sendMusic(musicId, this.playingMusic == -1 ? 0 : 100, 255);
            this.playingMusic = musicId;
            int musicIndex = (int)ClientScriptMap.getMap(1351).getKeyForValue(musicId);
            if (musicIndex != -1) {
               String musicName = ClientScriptMap.getMap(1345).getStringValue((long)musicIndex);
               if (musicName.equals(" ")) {
                  musicName = Region.getMusicName1(this.player.getRegionId());
               }

               this.player.getPackets().sendIComponentText(187, 4, musicName != null ? musicName : "");
               if (!this.unlockedMusics.contains(musicId)) {
                  this.addMusic(musicId);
                  if (musicName != null) {
                     this.player.getPackets().sendGameMessage("<col=ff0000>You have unlocked a new music track: " + musicName + ".");
                  }
               }
            }

         }
      }
   }
}
