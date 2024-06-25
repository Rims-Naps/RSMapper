package org.rsmapper.game.player;

import java.io.Serializable;
import java.util.ArrayList;
import org.rsmapper.cache.loaders.NPCDefinitions;
import org.rsmapper.game.Animation;
import org.rsmapper.game.Entity;
import org.rsmapper.game.Graphics;
import org.rsmapper.game.World;
import org.rsmapper.game.WorldTile;
import org.rsmapper.game.npc.NPC;
import org.rsmapper.game.tasks.WorldTask;
import org.rsmapper.game.tasks.WorldTasksManager;
import org.rsmapper.utilities.misc.Utils;

public final class EmotesManager implements Serializable {
   private static final long serialVersionUID = 8489480378717534336L;
   private ArrayList<Integer> unlockedEmotes = new ArrayList();
   private transient Player player;
   private transient long nextEmoteEnd;

   public EmotesManager() {
      for(int emoteId = 2; emoteId < 24; ++emoteId) {
         this.unlockedEmotes.add(emoteId);
      }

      this.unlockedEmotes.add(39);
   }

   public void setPlayer(Player player) {
      this.player = player;
   }

   public void unlockEmote(int id) {
      if (!this.unlockedEmotes.contains(id)) {
         if (this.unlockedEmotes.add(id)) {
            this.refreshListConfigs();
         }

      }
   }

   public static int getId(int slotId, int packetId) {
      System.out.println(slotId);
      if (slotId >= 50 && slotId <= 63) {
         return slotId;
      } else {
         switch(slotId) {
         case 0:
            return 2;
         case 1:
            return 3;
         case 2:
            if (packetId == 61) {
               return 4;
            }

            return -1;
         case 3:
            return 5;
         case 4:
            return 6;
         case 5:
            return 7;
         case 6:
            return 8;
         case 7:
            return 9;
         case 8:
            return 10;
         case 9:
            return 12;
         case 10:
            return 11;
         case 11:
            return 13;
         case 12:
            return 14;
         case 13:
            return 15;
         case 14:
            return 16;
         case 15:
            return 17;
         case 16:
            return 18;
         case 17:
            return 19;
         case 18:
            return 20;
         case 19:
            return 21;
         case 20:
            return 22;
         case 21:
            return 23;
         case 22:
            return 24;
         case 23:
            return 25;
         case 24:
            return 26;
         case 25:
            return 27;
         case 26:
            return 28;
         case 27:
            return 29;
         case 28:
            return 30;
         case 29:
            return 31;
         case 30:
            return 32;
         case 31:
            return 33;
         case 32:
            return 34;
         case 33:
            return 35;
         case 34:
            return 36;
         case 35:
            return 37;
         case 36:
            return 38;
         case 37:
            return 39;
         case 38:
            return 40;
         case 39:
            return 41;
         case 40:
            return 42;
         case 41:
            return 43;
         case 42:
            return 44;
         case 43:
            return 45;
         case 44:
            return 46;
         case 45:
            return 47;
         case 46:
            return 48;
         case 47:
            return 49;
         case 48:
            return 50;
         case 49:
            return 51;
         case 50:
            return 52;
         default:
            return -1;
         }
      }
   }

   public void useBookEmote(int id) {
      if (this.player.getAttackedByDelay() + 10000L > Utils.currentTimeMillis()) {
         this.player.getPackets().sendGameMessage("You can't do this while you're under combat.");
      } else {
         this.player.stopAll(false);
         if (this.isDoingEmote()) {
            this.player.getPackets().sendGameMessage("You're already doing an emote!");
         } else {
            if (id == 2) {
               this.player.setNextAnimation(new Animation(855));
            } else if (id == 3) {
               this.player.setNextAnimation(new Animation(856));
            } else if (id == 4) {
               this.player.setNextAnimation(new Animation(858));
            } else if (id == 5) {
               this.player.setNextAnimation(new Animation(859));
            } else if (id == 6) {
               this.player.setNextAnimation(new Animation(857));
            } else if (id == 7) {
               this.player.setNextAnimation(new Animation(863));
            } else if (id == 8) {
               this.player.setNextAnimation(new Animation(2113));
            } else if (id == 9) {
               this.player.setNextAnimation(new Animation(862));
            } else if (id == 10) {
               this.player.setNextAnimation(new Animation(864));
            } else if (id == 12) {
               this.player.setNextAnimation(new Animation(861));
            } else if (id == 11) {
               this.player.setNextAnimation(new Animation(2109));
            } else if (id == 13) {
               this.player.setNextAnimation(new Animation(2111));
            } else if (id == 14) {
               this.player.setNextAnimation(new Animation(866));
            } else if (id == 15) {
               this.player.setNextAnimation(new Animation(2106));
            } else if (id == 16) {
               this.player.setNextAnimation(new Animation(2107));
            } else if (id == 17) {
               this.player.setNextAnimation(new Animation(2108));
            } else if (id == 18) {
               this.player.setNextAnimation(new Animation(860));
            } else if (id == 19) {
               this.player.setNextAnimation(new Animation(1374));
               this.player.setNextGraphics(new Graphics(1702));
            } else if (id == 20) {
               this.player.setNextAnimation(new Animation(2105));
            } else if (id == 21) {
               this.player.setNextAnimation(new Animation(2110));
            } else if (id == 22) {
               this.player.setNextAnimation(new Animation(865));
            } else if (id == 23) {
               this.player.setNextAnimation(new Animation(2112));
            } else if (id == 24) {
               this.player.setNextAnimation(new Animation(2127));
            } else if (id == 25) {
               this.player.setNextAnimation(new Animation(2128));
            } else if (id == 26) {
               this.player.setNextAnimation(new Animation(1131));
            } else if (id == 27) {
               this.player.setNextAnimation(new Animation(1130));
            } else if (id == 28) {
               this.player.setNextAnimation(new Animation(1129));
            } else if (id == 29) {
               this.player.setNextAnimation(new Animation(1128));
            } else if (id == 30) {
               this.player.setNextAnimation(new Animation(4275));
            } else if (id == 31) {
               this.player.setNextAnimation(new Animation(1745));
            } else if (id == 32) {
               this.player.setNextAnimation(new Animation(4280));
            } else if (id == 33) {
               this.player.setNextAnimation(new Animation(4276));
            } else if (id == 34) {
               this.player.setNextAnimation(new Animation(3544));
            } else if (id == 35) {
               this.player.setNextAnimation(new Animation(3543));
            } else if (id == 36) {
               this.player.setNextAnimation(new Animation(7272));
               this.player.setNextGraphics(new Graphics(1244));
            } else if (id == 37) {
               this.player.setNextAnimation(new Animation(2836));
            } else if (id == 38) {
               this.player.setNextAnimation(new Animation(6111));
            } else {
               if (id == 39) {
                  final int capeId = this.player.getEquipment().getCapeId();
                  switch(capeId) {
                  case 9747:
                  case 9748:
                  case 10639:
                     this.player.setNextAnimation(new Animation(4959));
                     this.player.setNextGraphics(new Graphics(823));
                     break;
                  case 9750:
                  case 9751:
                  case 10640:
                     this.player.setNextAnimation(new Animation(4981));
                     this.player.setNextGraphics(new Graphics(828));
                     break;
                  case 9753:
                  case 9754:
                  case 10641:
                     this.player.setNextAnimation(new Animation(4961));
                     this.player.setNextGraphics(new Graphics(824));
                     break;
                  case 9756:
                  case 9757:
                  case 10642:
                     this.player.setNextAnimation(new Animation(4973));
                     this.player.setNextGraphics(new Graphics(832));
                     break;
                  case 9759:
                  case 9760:
                  case 10643:
                     this.player.setNextAnimation(new Animation(4979));
                     this.player.setNextGraphics(new Graphics(829));
                     break;
                  case 9762:
                  case 9763:
                  case 10644:
                     this.player.setNextAnimation(new Animation(4939));
                     this.player.setNextGraphics(new Graphics(813));
                     break;
                  case 9765:
                  case 9766:
                  case 10645:
                     this.player.setNextAnimation(new Animation(4947));
                     this.player.setNextGraphics(new Graphics(817));
                     break;
                  case 9768:
                  case 9769:
                  case 10647:
                     this.player.setNextAnimation(new Animation(14242));
                     this.player.setNextGraphics(new Graphics(2745));
                     break;
                  case 9771:
                  case 9772:
                  case 10648:
                     this.player.setNextAnimation(new Animation(4977));
                     this.player.setNextGraphics(new Graphics(830));
                     break;
                  case 9774:
                  case 9775:
                  case 10649:
                     this.player.setNextAnimation(new Animation(4969));
                     this.player.setNextGraphics(new Graphics(835));
                     break;
                  case 9777:
                  case 9778:
                  case 10650:
                     this.player.setNextAnimation(new Animation(4965));
                     this.player.setNextGraphics(new Graphics(826));
                     break;
                  case 9780:
                  case 9781:
                  case 10651:
                     this.player.setNextAnimation(new Animation(4949));
                     this.player.setNextGraphics(new Graphics(818));
                     break;
                  case 9783:
                  case 9784:
                  case 10652:
                     this.player.setNextAnimation(new Animation(4937));
                     this.player.setNextGraphics(new Graphics(812));
                     break;
                  case 9786:
                  case 9787:
                  case 10653:
                     this.player.setNextAnimation(new Animation(4967));
                     this.player.setNextGraphics(new Graphics(1656));
                     break;
                  case 9789:
                  case 9790:
                  case 10654:
                     this.player.setNextAnimation(new Animation(4953));
                     this.player.setNextGraphics(new Graphics(820));
                     break;
                  case 9792:
                  case 9793:
                  case 10655:
                     this.player.setNextAnimation(new Animation(4941));
                     this.player.setNextGraphics(new Graphics(814));
                     break;
                  case 9795:
                  case 9796:
                  case 10656:
                     this.player.setNextAnimation(new Animation(4943));
                     this.player.setNextGraphics(new Graphics(815));
                     break;
                  case 9798:
                  case 9799:
                  case 10657:
                     this.player.setNextAnimation(new Animation(4951));
                     this.player.setNextGraphics(new Graphics(819));
                     break;
                  case 9801:
                  case 9802:
                  case 10658:
                     this.player.setNextAnimation(new Animation(4955));
                     this.player.setNextGraphics(new Graphics(821));
                     break;
                  case 9804:
                  case 9805:
                  case 10659:
                     this.player.setNextAnimation(new Animation(4975));
                     this.player.setNextGraphics(new Graphics(831));
                     break;
                  case 9807:
                  case 9808:
                  case 10660:
                     this.player.setNextAnimation(new Animation(4957));
                     this.player.setNextGraphics(new Graphics(822));
                     break;
                  case 9810:
                  case 9811:
                  case 10611:
                     this.player.setNextAnimation(new Animation(4963));
                     this.player.setNextGraphics(new Graphics(825));
                     break;
                  case 9813:
                  case 10662:
                     this.player.setNextAnimation(new Animation(4945));
                     this.player.setNextGraphics(new Graphics(816));
                     break;
                  case 9948:
                  case 9949:
                  case 10646:
                     this.player.setNextAnimation(new Animation(5158));
                     this.player.setNextGraphics(new Graphics(907));
                     break;
                  case 12169:
                  case 12170:
                  case 12524:
                     this.player.setNextAnimation(new Animation(8525));
                     this.player.setNextGraphics(new Graphics(1515));
                     break;
                  case 18508:
                  case 18509:
                     final int rand = (int)(Math.random() * 3.0D);
                     this.player.setNextAnimation(new Animation(13190));
                     this.player.setNextGraphics(new Graphics(2442));
                     WorldTasksManager.schedule(new WorldTask() {
                        int step;

                        public void run() {
                           if (this.step == 1) {
                              EmotesManager.this.player.getAppearence().transformIntoNPC(rand == 0 ? 11227 : (rand == 1 ? 11228 : 11229));
                              EmotesManager.this.player.setNextAnimation(new Animation(rand > 0 ? 13192 : (rand == 1 ? 13193 : 13194)));
                           }

                           if (this.step == 3) {
                              EmotesManager.this.player.getAppearence().transformIntoNPC(-1);
                              this.stop();
                           }

                           ++this.step;
                        }
                     }, 0, 1);
                  case 19709:
                  case 19710:
                     break;
                  case 20763:
                     if (this.player.getControllerManager().getController() != null) {
                        this.player.getPackets().sendGameMessage("You cannot do this here!");
                        return;
                     }

                     this.player.setNextAnimation(new Animation(352));
                     this.player.setNextGraphics(new Graphics(1446));
                     break;
                  case 20765:
                     if (this.player.getControllerManager().getController() != null) {
                        this.player.getPackets().sendGameMessage("You cannot do this here!");
                        return;
                     }

                     int random = Utils.getRandom(2);
                     this.player.setNextAnimation(new Animation(122));
                     this.player.setNextGraphics(new Graphics(random == 0 ? 1471 : 1466));
                     break;
                  case 20767:
                     if (this.player.getControllerManager().getController() != null) {
                        this.player.getPackets().sendGameMessage("This emote is currently unavailable.");
                        return;
                     }

                     int size = NPCDefinitions.getNPCDefinitions(1224).size;
                     final WorldTile spawnTile = new WorldTile(new WorldTile(this.player.getX() + 1, this.player.getY(), this.player.getPlane()));
                     if (!World.canMoveNPC(spawnTile.getPlane(), spawnTile.getX(), spawnTile.getY(), size)) {
                        spawnTile = null;
                        int[][] dirs = Utils.getCoordOffsetsNear(size);

                        for(int dir = 0; dir < dirs[0].length; ++dir) {
                           WorldTile tile = new WorldTile(new WorldTile(this.player.getX() + dirs[0][dir], this.player.getY() + dirs[1][dir], this.player.getPlane()));
                           if (World.canMoveNPC(tile.getPlane(), tile.getX(), tile.getY(), size)) {
                              spawnTile = tile;
                              break;
                           }
                        }
                     }

                     if (spawnTile == null) {
                        this.player.getPackets().sendGameMessage("Need more space to perform this skillcape emote.");
                        return;
                     }

                     this.nextEmoteEnd = Utils.currentTimeMillis() + 15000L;
                     WorldTasksManager.schedule(new WorldTask() {
                        private int step;
                        private NPC npc;

                        public void run() {
                           if (this.step == 0) {
                              this.npc = new NPC(1224, spawnTile, -1, true);
                              this.npc.setNextAnimation(new Animation(1434));
                              this.npc.setNextGraphics(new Graphics(1482));
                              EmotesManager.this.player.setNextAnimation(new Animation(1179));
                              this.npc.setNextFaceEntity(EmotesManager.this.player);
                              EmotesManager.this.player.setNextFaceEntity(this.npc);
                           } else if (this.step == 2) {
                              this.npc.setNextAnimation(new Animation(1436));
                              this.npc.setNextGraphics(new Graphics(1486));
                              EmotesManager.this.player.setNextAnimation(new Animation(1180));
                           } else if (this.step == 3) {
                              this.npc.setNextGraphics(new Graphics(1498));
                              EmotesManager.this.player.setNextAnimation(new Animation(1181));
                           } else if (this.step == 4) {
                              EmotesManager.this.player.setNextAnimation(new Animation(1182));
                           } else if (this.step == 5) {
                              this.npc.setNextAnimation(new Animation(1448));
                              EmotesManager.this.player.setNextAnimation(new Animation(1250));
                           } else if (this.step == 6) {
                              EmotesManager.this.player.setNextAnimation(new Animation(1251));
                              EmotesManager.this.player.setNextGraphics(new Graphics(1499));
                              this.npc.setNextAnimation(new Animation(1454));
                              this.npc.setNextGraphics(new Graphics(1504));
                           } else if (this.step == 11) {
                              EmotesManager.this.player.setNextAnimation(new Animation(1291));
                              EmotesManager.this.player.setNextGraphics(new Graphics(1686));
                              EmotesManager.this.player.setNextGraphics(new Graphics(1598));
                              this.npc.setNextAnimation(new Animation(1440));
                           } else if (this.step == 16) {
                              EmotesManager.this.player.setNextFaceEntity((Entity)null);
                              this.npc.finish();
                              this.stop();
                           }

                           ++this.step;
                        }
                     }, 0, 1);
                     break;
                  case 20769:
                  case 20771:
                     if (!World.canMoveNPC(this.player.getPlane(), this.player.getX(), this.player.getY(), 3)) {
                        this.player.getPackets().sendGameMessage("Need more space to perform this skillcape emote.");
                        return;
                     }

                     this.nextEmoteEnd = Utils.currentTimeMillis() + 12000L;
                     WorldTasksManager.schedule(new WorldTask() {
                        private int step;

                        public void run() {
                           if (this.step == 0) {
                              EmotesManager.this.player.setNextAnimation(new Animation(356));
                              EmotesManager.this.player.setNextGraphics(new Graphics(307));
                           } else if (this.step == 2) {
                              EmotesManager.this.player.getAppearence().transformIntoNPC(capeId == 20769 ? 1830 : 3372);
                              EmotesManager.this.player.setNextAnimation(new Animation(1174));
                              EmotesManager.this.player.setNextGraphics(new Graphics(1443));
                           } else if (this.step == 4) {
                              EmotesManager.this.player.getPackets().sendCameraShake(3, 25, 50, 25, 50);
                           } else if (this.step == 5) {
                              EmotesManager.this.player.getPackets().sendStopCameraShake();
                           } else if (this.step == 8) {
                              EmotesManager.this.player.getAppearence().transformIntoNPC(-1);
                              EmotesManager.this.player.setNextAnimation(new Animation(1175));
                              this.stop();
                           }

                           ++this.step;
                        }
                     }, 0, 1);
                     break;
                  default:
                     this.player.getPackets().sendGameMessage("You need to be wearing a skillcape in order to perform this emote.");
                  }

                  return;
               }

               if (id == 40) {
                  this.player.setNextAnimation(new Animation(7531));
               } else if (id == 41) {
                  this.player.setNextAnimation(new Animation(2414));
                  this.player.setNextGraphics(new Graphics(1537));
                  this.player.getPackets().sendMusicEffect(302);
               } else if (id == 42) {
                  this.player.setNextAnimation(new Animation(8770));
                  this.player.setNextGraphics(new Graphics(1553));
               } else if (id == 43) {
                  this.player.setNextAnimation(new Animation(9990));
                  this.player.setNextGraphics(new Graphics(1734));
               } else if (id == 44) {
                  this.player.setNextAnimation(new Animation(10530));
                  this.player.setNextGraphics(new Graphics(1864));
               } else if (id == 45) {
                  this.player.setNextAnimation(new Animation(11044));
                  this.player.setNextGraphics(new Graphics(1973));
               } else if (id == 46) {
                  this.player.lock(15L);
                  this.nextEmoteEnd = Utils.currentTimeMillis() + 9000L;
                  WorldTasksManager.schedule(new WorldTask() {
                     private int step;

                     public void run() {
                        if (this.step == 0) {
                           EmotesManager.this.player.setNextAnimation(new Animation(10994));
                           EmotesManager.this.player.setNextGraphics(new Graphics(86));
                        } else if (this.step == 1) {
                           EmotesManager.this.player.setNextAnimation(new Animation(10996));
                           EmotesManager.this.player.getAppearence().transformIntoNPC(8499);
                        } else if (this.step == 6) {
                           EmotesManager.this.player.setNextAnimation(new Animation(10995));
                           EmotesManager.this.player.setNextGraphics(new Graphics(86));
                           EmotesManager.this.player.getAppearence().transformIntoNPC(-1);
                           this.stop();
                        }

                        ++this.step;
                     }
                  }, 0, 1);
               } else if (id == 47) {
                  this.player.setNextAnimation(new Animation(11542));
                  this.player.setNextGraphics(new Graphics(2037));
               } else if (id == 48) {
                  this.player.setNextAnimation(new Animation(12658));
                  this.player.setNextGraphics(new Graphics(780));
               } else if (id == 49) {
                  this.player.setNextAnimation(new Animation(14165));
               } else if (id == 50) {
                  this.player.setNextAnimation(new Animation(14869));
                  this.player.setNextGraphics(new Graphics(2837));
               } else if (id == 51) {
                  this.player.setNextAnimation(new Animation(15034));
                  this.player.setNextGraphics(new Graphics(2930));
               } else if (id == 52) {
                  this.nextEmoteEnd = Utils.currentTimeMillis() + 6000L;
                  WorldTasksManager.schedule(new WorldTask() {
                     int random = (int)(Math.random() * 3.0D);
                     private int step;

                     public void run() {
                        if (this.step == 0) {
                           EmotesManager.this.player.setNextAnimation(new Animation(15104));
                           EmotesManager.this.player.setNextGraphics(new Graphics(1287));
                        } else if (this.step == 1) {
                           EmotesManager.this.player.setNextAnimation(new Animation(15106));
                           EmotesManager.this.player.getAppearence().transformIntoNPC(this.random == 0 ? 13255 : (this.random == 1 ? 13256 : 13257));
                        } else if (this.step == 2) {
                           EmotesManager.this.player.setNextAnimation(new Animation(15108));
                        } else if (this.step == 3) {
                           EmotesManager.this.player.setNextAnimation(new Animation(15105));
                           EmotesManager.this.player.setNextGraphics(new Graphics(1287));
                           EmotesManager.this.player.getAppearence().transformIntoNPC(-1);
                           this.stop();
                        }

                        ++this.step;
                     }
                  }, 0, 1);
               } else if (id == 53) {
                  this.player.setNextAnimation(new Animation(15357));
                  this.player.setNextGraphics(new Graphics(1391));
               }
            }

            if (!this.isDoingEmote()) {
               this.setNextEmoteEnd();
            }

         }
      }
   }

   public void setNextEmoteEnd() {
      this.nextEmoteEnd = this.player.getLastAnimationEnd() - 600L;
   }

   public void setNextEmoteEnd(long delay) {
      this.nextEmoteEnd = Utils.currentTimeMillis() + delay;
   }

   public void refreshListConfigs() {
      int value1;
      for(value1 = 0; value1 <= 45; ++value1) {
         if (!this.unlockedEmotes.contains(value1)) {
            this.unlockEmote(value1);
         }
      }

      if (this.unlockedEmotes.contains(24) && this.unlockedEmotes.contains(25)) {
         this.player.getPackets().sendConfig(465, 7);
      }

      value1 = 0;
      if (this.unlockedEmotes.contains(32)) {
         ++value1;
      }

      if (this.unlockedEmotes.contains(30)) {
         value1 += 2;
      }

      if (this.unlockedEmotes.contains(33)) {
         value1 += 4;
      }

      if (this.unlockedEmotes.contains(31)) {
         value1 += 8;
      }

      if (value1 > 0) {
         this.player.getPackets().sendConfig(802, value1);
      }

      if (this.unlockedEmotes.contains(36)) {
         this.player.getPackets().sendConfig(1085, 249852);
      }

      int value2 = 0;
      if (this.unlockedEmotes.contains(29)) {
         ++value2;
      }

      if (this.unlockedEmotes.contains(26)) {
         value2 += 2;
      }

      if (this.unlockedEmotes.contains(27)) {
         value2 += 4;
      }

      if (this.unlockedEmotes.contains(28)) {
         value2 += 8;
      }

      if (this.unlockedEmotes.contains(37)) {
         value2 += 16;
      }

      if (this.unlockedEmotes.contains(35)) {
         value2 += 32;
      }

      if (this.unlockedEmotes.contains(34)) {
         value2 += 64;
      }

      if (this.unlockedEmotes.contains(38)) {
         value2 += 128;
      }

      if (this.unlockedEmotes.contains(39)) {
         value2 += 256;
      }

      if (this.unlockedEmotes.contains(40)) {
         value2 += 512;
      }

      if (this.unlockedEmotes.contains(41)) {
         value2 += 1024;
      }

      if (this.unlockedEmotes.contains(42)) {
         value2 += 2048;
      }

      if (this.unlockedEmotes.contains(43)) {
         value2 += 4096;
      }

      if (this.unlockedEmotes.contains(44)) {
         value2 += 8192;
      }

      if (this.unlockedEmotes.contains(46)) {
         value2 += 16384;
      }

      if (this.unlockedEmotes.contains(45)) {
         value2 += 32768;
      }

      if (value2 > 0) {
         this.player.getPackets().sendConfig(313, value2);
      }

   }

   public long getNextEmoteEnd() {
      return this.nextEmoteEnd;
   }

   public boolean isDoingEmote() {
      return this.nextEmoteEnd >= Utils.currentTimeMillis();
   }

   public void unlockEmotesBook() {
      this.player.getPackets().sendUnlockIComponentOptionSlots(590, 8, 0, 103, 0, 1);
   }
}
