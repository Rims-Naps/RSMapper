package org.rsmapper.networking.codec.handlers;

import java.util.HashMap;
import java.util.Iterator;
import org.rsmapper.api.event.EventManager;
import org.rsmapper.api.input.IntegerInputAction;
import org.rsmapper.cache.loaders.ItemDefinitions;
import org.rsmapper.game.WorldTile;
import org.rsmapper.game.item.Item;
import org.rsmapper.game.player.EmotesManager;
import org.rsmapper.game.player.Equipment;
import org.rsmapper.game.player.Player;
import org.rsmapper.game.player.Skills;
import org.rsmapper.game.player.content.Magic;
import org.rsmapper.game.player.content.PlayerLook;
import org.rsmapper.networking.codec.stream.InputStream;
import org.rsmapper.utilities.misc.Utils;

public class ButtonHandler {
   private static final Object[][] info = new Object[][]{{31, 0, "Stab"}, {32, 1, "Slash"}, {33, 2, "Crush"}, {34, 3, "Magic"}, {35, 4, "Range"}, {36, 5, "Stab"}, {37, 6, "Slash"}, {38, 7, "Crush"}, {39, 8, "Magic"}, {40, 9, "Range"}, {41, 10, "Summoning"}, {42, 11, "Absorb Melee"}, {43, 12, "Absorb Magic"}, {44, 13, "Absorb Range"}, {45, 14, "Strength"}, {46, 15, "Ranged Str"}, {47, 16, "Prayer"}, {48, 17, "Magic Damage"}};

   public static void handleButtons(final Player player, InputStream stream, int packetId) {
      int interfaceHash = stream.readIntV2();
      int interfaceId = interfaceHash >> 16;
      if (Utils.getInterfaceDefinitionsSize() > interfaceId) {
         int componentId = interfaceHash - (interfaceId << 16);
         if (componentId == 65535 || Utils.getInterfaceDefinitionsComponentsSize(interfaceId) + 1 > componentId) {
            if (interfaceId == 746 && componentId == 51) {
               if (!player.getInterfaceManager().containsScreenInterface()) {
                  player.stopAll();
                  player.getInterfaceManager().sendInterface(742);
               }
            } else {
               int itemId = stream.readUnsignedShortLE128();
               final int slotId = stream.readUnsignedShort();
               if (player.getControllerManager().processButtonClick(interfaceId, componentId, slotId, packetId)) {
                  if (!EventManager.get().handleButtonClick(player, interfaceId, componentId, packetId, slotId, itemId)) {
                     if (interfaceId != 458) {
                        int skillId;
                        if (interfaceId == 387) {
                           if (componentId == 39 & packetId == 61) {
                              player.stopAll();
                              player.getInterfaceManager().sendInterface(667);
                              player.getPackets().sendIComponentSettings(667, 7, 0, 15, 1538);
                              player.getPackets().sendGlobalConfig(779, player.getEquipment().getWeaponRenderEmote());
                              refreshEquipBonuses(player);
                           }

                           if (componentId == 8 && packetId == 25) {
                              player.getEquipment().sendExamine(0);
                           } else if (componentId == 8 && packetId == 61) {
                              sendRemove(player, 0);
                           } else if (componentId == 17 && packetId == 61) {
                              sendRemove(player, 3);
                           } else if (componentId == 17 && packetId == 25) {
                              player.getEquipment().sendExamine(3);
                           } else if (componentId == 20 && packetId == 25) {
                              player.getEquipment().sendExamine(4);
                           } else if (componentId == 20 && packetId == 61) {
                              sendRemove(player, 4);
                           } else if (componentId == 23) {
                              if (packetId == 25) {
                                 player.getEquipment().sendExamine(5);
                              } else if (packetId != 64 && packetId == 61) {
                                 sendRemove(player, 5);
                              }
                           } else if (componentId == 26 && packetId == 25) {
                              player.getEquipment().sendExamine(7);
                           } else if (componentId == 26 && packetId == 61) {
                              sendRemove(player, 7);
                           } else if (componentId == 29 && packetId == 25) {
                              player.getEquipment().sendExamine(9);
                           } else if (componentId == 29 && packetId == 61) {
                              sendRemove(player, 9);
                           } else if (componentId == 32 && packetId == 25) {
                              player.getEquipment().sendExamine(10);
                           } else if (componentId == 32 && packetId == 61) {
                              sendRemove(player, 10);
                           } else if (componentId == 35 && packetId == 61) {
                              sendRemove(player, 12);
                           } else if (componentId == 35 && packetId == 25) {
                              player.getEquipment().sendExamine(12);
                           } else if (componentId == 38 && packetId == 25) {
                              player.getEquipment().sendExamine(13);
                           } else if (componentId == 38 && packetId == 61) {
                              sendRemove(player, 13);
                           } else if (componentId == 14 && packetId == 61) {
                              sendRemove(player, 2);
                           } else if (componentId == 14 && packetId == 25) {
                              player.getEquipment().sendExamine(2);
                           } else if (componentId == 11 && packetId == 61) {
                              sendRemove(player, 1);
                           } else if (componentId == 11 && packetId == 25) {
                              player.getEquipment().sendExamine(1);
                           } else if (componentId == 11 && packetId == 64 && itemId != 19748) {
                              ItemDefinitions definitions = ItemDefinitions.getItemDefinitions(itemId);
                              if (definitions.getName().contains("cape")) {
                                 skillId = -1;

                                 for(int i = 0; i < Skills.SKILL_NAME.length; ++i) {
                                    String skillName = Skills.SKILL_NAME[i];
                                    if (skillName.equalsIgnoreCase(definitions.getName().split(" ")[0])) {
                                       skillId = i;
                                       break;
                                    }
                                 }

                                 if (skillId != -1) {
                                    player.getSkills().set(skillId, 101);
                                 }
                              }
                           } else if (componentId == 11 && itemId == 19748) {
                              switch(packetId) {
                              case 4:
                                 Magic.sendNormalTeleportSpell(player, 1, 0.0D, new WorldTile(2673, 3374, 0));
                              case 52:
                                 break;
                              case 64:
                                 Magic.sendNormalTeleportSpell(player, 1, 0.0D, new WorldTile(2606, 3223, 0));
                                 break;
                              default:
                                 System.out.println(packetId);
                              }
                           }
                        }

                        int tabId;
                        if (interfaceId != 548 && interfaceId != 746 && interfaceId != 387) {
                           if (interfaceId == 182) {
                              if (player.getInterfaceManager().containsInventoryInter()) {
                                 return;
                              }

                              if ((componentId == 6 || componentId == 13) && !player.hasFinished()) {
                                 player.logout();
                              }
                           } else if (interfaceId == 309) {
                              PlayerLook.handleBeardButtons(player, componentId, slotId);
                           } else if (interfaceId == 187) {
                              if (componentId == 1) {
                                 if (packetId == 61) {
                                    player.getMusicsManager().playAnotherMusic(slotId / 2);
                                 } else if (packetId == 4) {
                                    player.getMusicsManager().addToPlayList(slotId / 2);
                                 } else if (packetId == 52) {
                                    player.getMusicsManager().removeFromPlayList(slotId / 2);
                                 }
                              } else if (componentId == 4) {
                                 player.getMusicsManager().addPlayingMusicToPlayList();
                              } else if (componentId == 10) {
                                 player.getMusicsManager().switchPlayListOn();
                              } else if (componentId == 11) {
                                 player.getMusicsManager().clearPlayList();
                              } else if (componentId == 13) {
                                 player.getMusicsManager().switchShuffleOn();
                              }
                           } else if (interfaceId == 464) {
                              player.getEmotesManager().useBookEmote(interfaceId == 464 ? componentId : EmotesManager.getId(slotId, packetId));
                           } else if (interfaceId == 192) {
                              if (componentId == 2) {
                                 player.getCombatDefinitions().switchDefensiveCasting();
                              } else if (componentId == 7) {
                                 player.getCombatDefinitions().switchShowCombatSpells();
                              } else if (componentId == 9) {
                                 player.getCombatDefinitions().switchShowTeleportSkillSpells();
                              } else if (componentId == 11) {
                                 player.getCombatDefinitions().switchShowMiscallaneousSpells();
                              } else if (componentId == 13) {
                                 player.getCombatDefinitions().switchShowSkillSpells();
                              } else if (componentId >= 15 & componentId <= 17) {
                                 player.getCombatDefinitions().setSortSpellBook(componentId - 15);
                              } else {
                                 Magic.processNormalSpell(player, componentId, packetId);
                              }
                           } else if (interfaceId != 300 && interfaceId != 206) {
                              if (interfaceId == 193) {
                                 if (componentId == 5) {
                                    player.getCombatDefinitions().switchShowCombatSpells();
                                 } else if (componentId == 7) {
                                    player.getCombatDefinitions().switchShowTeleportSkillSpells();
                                 } else if (componentId >= 9 && componentId <= 11) {
                                    player.getCombatDefinitions().setSortSpellBook(componentId - 9);
                                 } else if (componentId == 18) {
                                    player.getCombatDefinitions().switchDefensiveCasting();
                                 } else {
                                    Magic.processAncientSpell(player, componentId, packetId);
                                 }
                              } else if (interfaceId == 430) {
                                 if (componentId == 5) {
                                    player.getCombatDefinitions().switchShowCombatSpells();
                                 } else if (componentId == 7) {
                                    player.getCombatDefinitions().switchShowTeleportSkillSpells();
                                 } else if (componentId == 9) {
                                    player.getCombatDefinitions().switchShowMiscallaneousSpells();
                                 } else if (componentId >= 11 & componentId <= 13) {
                                    player.getCombatDefinitions().setSortSpellBook(componentId - 11);
                                 } else if (componentId == 20) {
                                    player.getCombatDefinitions().switchDefensiveCasting();
                                 } else {
                                    Magic.processLunarSpell(player, componentId, packetId);
                                 }
                              } else if (interfaceId == 261) {
                                 System.out.println(componentId);
                                 if (player.getInterfaceManager().containsInventoryInter()) {
                                    return;
                                 }

                                 if (componentId == 18) {
                                    return;
                                 }

                                 if (componentId == 14) {
                                    if (player.getInterfaceManager().containsScreenInterface()) {
                                       player.getPackets().sendGameMessage("Please close the interface you have open before setting your graphic options.");
                                       return;
                                    }

                                    player.stopAll();
                                    player.getInterfaceManager().sendInterface(742);
                                 } else if (componentId == 4) {
                                    player.switchAllowChatEffects();
                                 } else if (componentId == 5) {
                                    player.getInterfaceManager().sendSettings(982);
                                 } else if (componentId == 6) {
                                    player.switchMouseButtons();
                                 } else if (componentId == 16) {
                                    if (player.getInterfaceManager().containsScreenInterface()) {
                                       player.getPackets().sendGameMessage("Please close the interface you have open before setting your audio options.");
                                       return;
                                    }

                                    player.stopAll();
                                    player.getInterfaceManager().sendInterface(743);
                                 } else if (componentId == 7) {
                                    player.switchAcceptAid();
                                 }
                              } else if (interfaceId == 398) {
                                 if (componentId == 19) {
                                    player.getInterfaceManager().sendSettings();
                                 } else if (componentId == 15 || componentId == 1) {
                                    boolean visitorsAllowed = componentId != 1;
                                    player.getPackets().sendIComponentSprite(interfaceId, 1, visitorsAllowed ? 170 : 179);
                                    player.getPackets().sendIComponentSprite(interfaceId, 15, visitorsAllowed ? 179 : 170);
                                 }
                              } else if (interfaceId == 402) {
                                 if (componentId >= 93) {
                                 }
                              } else if (interfaceId != 394 && interfaceId != 396) {
                                 if (interfaceId == 499) {
                                    tabId = -1;
                                    if (player.getTemporaryAttributes().get("skillMenu") != null) {
                                       tabId = (Integer)player.getTemporaryAttributes().get("skillMenu");
                                    }

                                    switch(componentId) {
                                    case 10:
                                       player.getPackets().sendConfig(965, tabId);
                                       break;
                                    case 11:
                                       player.getPackets().sendConfig(965, 1024 + tabId);
                                       break;
                                    case 12:
                                       player.getPackets().sendConfig(965, 2048 + tabId);
                                       break;
                                    case 13:
                                       player.getPackets().sendConfig(965, 3072 + tabId);
                                       break;
                                    case 14:
                                       player.getPackets().sendConfig(965, 4096 + tabId);
                                       break;
                                    case 15:
                                       player.getPackets().sendConfig(965, 5120 + tabId);
                                       break;
                                    case 16:
                                       player.getPackets().sendConfig(965, 6144 + tabId);
                                       break;
                                    case 17:
                                       player.getPackets().sendConfig(965, 7168 + tabId);
                                       break;
                                    case 18:
                                       player.getPackets().sendConfig(965, 8192 + tabId);
                                       break;
                                    case 19:
                                       player.getPackets().sendConfig(965, 9216 + tabId);
                                       break;
                                    case 20:
                                       player.getPackets().sendConfig(965, 10240 + tabId);
                                       break;
                                    case 21:
                                       player.getPackets().sendConfig(965, 11264 + tabId);
                                       break;
                                    case 22:
                                       player.getPackets().sendConfig(965, 12288 + tabId);
                                       break;
                                    case 23:
                                       player.getPackets().sendConfig(965, 13312 + tabId);
                                    case 24:
                                    case 25:
                                    case 26:
                                    case 27:
                                    case 28:
                                    default:
                                       break;
                                    case 29:
                                       player.stopAll();
                                    }
                                 } else if (interfaceId == 640) {
                                    if (componentId != 18 && componentId != 22) {
                                       if (componentId == 19 || componentId == 21) {
                                          player.getTemporaryAttributes().put("WillDuelFriendly", false);
                                          player.getPackets().sendConfig(283, 134217728);
                                       }
                                    } else {
                                       player.getTemporaryAttributes().put("WillDuelFriendly", true);
                                       player.getPackets().sendConfig(283, 67108864);
                                    }
                                 } else if (interfaceId == 650) {
                                    if (componentId == 17) {
                                       player.stopAll();
                                       player.setNextWorldTile(new WorldTile(2974, 4384, 0));
                                       player.getControllerManager().startController("CorpBeastControler");
                                    } else if (componentId == 18) {
                                       player.closeInterfaces();
                                    }
                                 } else if (interfaceId == 670) {
                                    if (componentId == 0) {
                                       if (slotId >= player.getInventory().getItemsContainerSize()) {
                                          return;
                                       }

                                       Item item = player.getInventory().getItem(slotId);
                                       if (item == null) {
                                          return;
                                       }

                                       if (packetId == 61) {
                                          if (sendWear(player, slotId, item.getId())) {
                                             refreshEquipBonuses(player);
                                          }
                                       } else if (packetId == 52) {
                                          player.getInventory().sendExamine(slotId);
                                       }
                                    }
                                 } else if (interfaceId == 742) {
                                    if (componentId == 46) {
                                       player.stopAll();
                                    }
                                 } else if (interfaceId == 743) {
                                    if (componentId == 20) {
                                       player.stopAll();
                                    }
                                 } else if (interfaceId == 741) {
                                    if (componentId == 9) {
                                       player.stopAll();
                                    }
                                 } else if (interfaceId != 749) {
                                    if (interfaceId == 750) {
                                       if (componentId == 1) {
                                          if (packetId == 61) {
                                             player.toggleRun(!player.isResting());
                                             if (player.isResting()) {
                                                player.stopAll();
                                             }
                                          } else if (packetId == 64) {
                                             if (player.isResting()) {
                                                player.stopAll();
                                                return;
                                             }

                                             long currentTime = Utils.currentTimeMillis();
                                             if (player.getEmotesManager().getNextEmoteEnd() >= currentTime) {
                                                player.getPackets().sendGameMessage("You can't rest while perfoming an emote.");
                                                return;
                                             }

                                             if (player.getLockDelay() >= currentTime) {
                                                player.getPackets().sendGameMessage("You can't rest while perfoming an action.");
                                                return;
                                             }

                                             player.stopAll();
                                          }
                                       }
                                    } else if (interfaceId == 11) {
                                       if (componentId == 17) {
                                          if (packetId == 61) {
                                             player.getBank().depositItem(slotId, 1, true);
                                          } else if (packetId == 64) {
                                             player.getBank().depositItem(slotId, 5, true);
                                          } else if (packetId == 4) {
                                             player.getBank().depositItem(slotId, 10, true);
                                          } else if (packetId == 52) {
                                             player.getBank().depositItem(slotId, Integer.MAX_VALUE, true);
                                          } else if (packetId == 81) {
                                             player.getPackets().sendInputIntegerScript("Enter Amount:", new IntegerInputAction() {
                                                public void handle(int input) {
                                                   player.getBank().depositItem(slotId, input, true);
                                                }
                                             });
                                          } else if (packetId == 91) {
                                             player.getInventory().sendExamine(slotId);
                                          }
                                       } else if (componentId == 18) {
                                          player.getBank().depositAllInventory(false);
                                       } else if (componentId == 20) {
                                          player.getBank().depositAllEquipment(false);
                                       }
                                    } else if (interfaceId == 762) {
                                       if (componentId == 15) {
                                          player.getBank().switchInsertItems();
                                       } else if (componentId == 19) {
                                          player.getBank().switchWithdrawNotes();
                                       } else if (componentId == 33) {
                                          player.getBank().depositAllInventory(true);
                                       } else if (componentId == 35) {
                                          player.getBank().depositAllEquipment(true);
                                       } else if (componentId >= 44 && componentId <= 62) {
                                          tabId = 9 - (componentId - 44) / 2;
                                          if (packetId == 61) {
                                             player.getBank().setCurrentTab(tabId);
                                          } else if (packetId == 64) {
                                             player.getBank().collapse(tabId);
                                          }
                                       } else if (componentId == 93) {
                                          if (packetId == 61) {
                                             player.getBank().withdrawItem(slotId, 1);
                                          } else if (packetId == 64) {
                                             player.getBank().withdrawItem(slotId, 5);
                                          } else if (packetId == 4) {
                                             player.getBank().withdrawItem(slotId, 10);
                                          } else if (packetId == 52) {
                                             player.getBank().withdrawLastAmount(slotId);
                                          } else if (packetId == 81) {
                                             player.getPackets().sendInputIntegerScript("Enter Amount:", new IntegerInputAction() {
                                                public void handle(int input) {
                                                   player.getBank().withdrawItem(slotId, input);
                                                   player.getBank().setLastX(input);
                                                   player.getBank().refreshLastX();
                                                }
                                             });
                                          } else if (packetId == 91) {
                                             player.getBank().withdrawItem(slotId, Integer.MAX_VALUE);
                                          } else if (packetId == 18) {
                                             player.getBank().withdrawItemButOne(slotId);
                                          } else if (packetId == 25) {
                                             player.getBank().sendExamine(slotId);
                                          }
                                       }
                                    } else if (interfaceId == 763) {
                                       if (componentId == 0) {
                                          if (packetId == 61) {
                                             player.getBank().depositItem(slotId, 1, true);
                                          } else if (packetId == 64) {
                                             player.getBank().depositItem(slotId, 5, true);
                                          } else if (packetId == 4) {
                                             player.getBank().depositItem(slotId, 10, true);
                                          } else if (packetId == 52) {
                                             player.getBank().depositLastAmount(slotId);
                                          } else if (packetId == 81) {
                                             player.getPackets().sendInputIntegerScript("Enter Amount:", new IntegerInputAction() {
                                                public void handle(int input) {
                                                   player.getBank().depositItem(slotId, input, !player.getInterfaceManager().containsInterface(11));
                                                   player.getBank().setLastX(input);
                                                   player.getBank().refreshLastX();
                                                }
                                             });
                                          } else if (packetId == 91) {
                                             player.getBank().depositItem(slotId, Integer.MAX_VALUE, true);
                                          } else if (packetId == 25) {
                                             player.getInventory().sendExamine(slotId);
                                          }
                                       }
                                    } else if (interfaceId == 767) {
                                       if (componentId == 10) {
                                          player.getBank().openBank();
                                       }
                                    } else if (interfaceId == 884) {
                                       if (componentId == 4) {
                                          tabId = player.getEquipment().getWeaponId();
                                          if (player.hasInstantSpecial(tabId)) {
                                             player.performInstantSpecial(tabId);
                                             return;
                                          }

                                          player.getCombatDefinitions().switchUsingSpecialAttack();
                                       } else if (componentId >= 11 && componentId <= 14) {
                                          player.getCombatDefinitions().setAttackStyle(componentId - 11);
                                       } else if (componentId == 15) {
                                          player.getCombatDefinitions().switchAutoRelatie();
                                       }
                                    } else if (interfaceId == 755) {
                                       if (componentId == 44) {
                                          player.getPackets().sendWindowsPane(player.getInterfaceManager().hasResizableScreen() ? 746 : 548, 2);
                                       }
                                    } else if (interfaceId == 1056) {
                                       if (componentId == 102) {
                                          player.getInterfaceManager().sendInterface(917);
                                       }
                                    } else if (interfaceId == 900) {
                                       PlayerLook.handleMageMakeOverButtons(player, componentId);
                                    } else if (interfaceId == 1079) {
                                       player.closeInterfaces();
                                    }
                                 }
                              }
                           }
                        } else {
                           tabId = player.getEquipment().getCapeId();
                           if (componentId == 11) {
                              if (tabId == 20771) {
                                 switch(packetId) {
                                 case 4:
                                    Magic.sendNormalTeleportSpell(player, 1, 0.0D, new WorldTile(2668, 3374, 0));
                                 case 52:
                                 default:
                                    break;
                                 case 64:
                                    Magic.sendNormalTeleportSpell(player, 1, 0.0D, new WorldTile(2606, 3220, 0));
                                 }
                              }

                              if (packetId != 81) {
                              }
                           }

                           if (componentId == 14) {
                              skillId = player.getEquipment().getAmuletId();
                              if (packetId == 64) {
                                 if ((skillId > 1712 || skillId < 1706) && (skillId < 10354 || skillId > 10361) && (skillId == 1704 || skillId == 10352)) {
                                    player.getPackets().sendGameMessage("The amulet has ran out of charges. You need to recharge it if you wish it use it once more.");
                                 }
                              } else if (packetId != 4) {
                                 if (packetId == 52) {
                                    if ((skillId > 1712 || skillId < 1706) && skillId >= 10354) {
                                    }
                                 } else if (packetId == 81 && (skillId > 1712 || skillId < 1706) && skillId >= 10354) {
                                 }
                              }
                           }

                           if (interfaceId == 548 && componentId == 180 || interfaceId == 746 && componentId == 182) {
                              player.getPackets().sendWindowsPane(755, 0);
                              skillId = player.getX() << 14 | player.getY();
                              player.getPackets().sendGlobalConfig(622, skillId);
                              player.getPackets().sendGlobalConfig(674, skillId);
                           } else if ((interfaceId == 548 && componentId == 0 || interfaceId == 746 && componentId == 229) && packetId == 10) {
                              player.getSkills().resetXpCounter();
                           }
                        }

                     }
                  }
               }
            }
         }
      }
   }

   public static void sendRemove(Player player, int slotId) {
      if (slotId < 15) {
         Item item = player.getEquipment().getItem(slotId);
         if (item != null) {
            if (player.getInventory().addItem(item.getId(), item.getAmount())) {
               player.getEquipment().getItems().set(slotId, (Item)null);
               player.getEquipment().refresh(slotId);
               player.getAppearence().generateAppearenceData();
               if (slotId == 3) {
                  player.getCombatDefinitions().desecreaseSpecialAttack(0);
               }

               player.getPackets().sendGlobalConfig(779, player.getEquipment().getWeaponRenderEmote());
            }
         }
      }
   }

   public static boolean sendWear(Player player, int slotId, int itemId) {
      if (!player.hasFinished() && !player.isDead()) {
         Item item = player.getInventory().getItem(slotId);
         if (item != null && item.getId() == itemId) {
            if (!Equipment.canWear(item, player)) {
               return false;
            } else if (item.getDefinitions().isNoted() || !item.getDefinitions().isWearItem(player.getAppearence().isMale()) && item.getDefinitions().id != 4084) {
               player.getPackets().sendGameMessage("You can't wear that.");
               return true;
            } else {
               int targetSlot = Equipment.getItemSlot(itemId);
               if (targetSlot == -1) {
                  player.getPackets().sendGameMessage("You can't wear that.");
                  return true;
               } else {
                  boolean isTwoHandedWeapon = targetSlot == 3 && Equipment.isTwoHandedWeapon(item);
                  if (isTwoHandedWeapon && !player.getInventory().hasFreeSlots() && player.getEquipment().hasShield()) {
                     player.getPackets().sendGameMessage("Not enough free space in your inventory.");
                     return true;
                  } else {
                     HashMap<Integer, Integer> requiriments = item.getDefinitions().getWearingSkillRequiriments();
                     boolean hasRequiriments = true;
                     int oldAmt;
                     if (requiriments != null) {
                        Iterator var9 = requiriments.keySet().iterator();

                        while(var9.hasNext()) {
                           oldAmt = (Integer)var9.next();
                           if (oldAmt <= 24 && oldAmt >= 0) {
                              int level = (Integer)requiriments.get(oldAmt);
                              if (level >= 0 && level <= 120 && player.getSkills().getLevelForXp(oldAmt) < level) {
                                 if (hasRequiriments) {
                                    player.getPackets().sendGameMessage("You are not high enough level to use this item.");
                                 }

                                 hasRequiriments = false;
                                 String name = Skills.SKILL_NAME[oldAmt].toLowerCase();
                                 player.getPackets().sendGameMessage("You need to have a" + (name.startsWith("a") ? "n" : "") + " " + name + " level of " + level + ".");
                              }
                           }
                        }
                     }

                     if (!hasRequiriments) {
                        return true;
                     } else if (!player.getControllerManager().canEquip(targetSlot, itemId)) {
                        return false;
                     } else {
                        player.getInventory().deleteItem(slotId, item);
                        if (targetSlot == 3) {
                           if (isTwoHandedWeapon && player.getEquipment().getItem(5) != null) {
                              if (!player.getInventory().addItem(player.getEquipment().getItem(5).getId(), player.getEquipment().getItem(5).getAmount())) {
                                 player.getInventory().getItems().set(slotId, item);
                                 player.getInventory().refresh(slotId);
                                 return true;
                              }

                              player.getEquipment().getItems().set(5, (Item)null);
                           }
                        } else if (targetSlot == 5 && player.getEquipment().getItem(3) != null && Equipment.isTwoHandedWeapon(player.getEquipment().getItem(3))) {
                           if (!player.getInventory().addItem(player.getEquipment().getItem(3).getId(), player.getEquipment().getItem(3).getAmount())) {
                              player.getInventory().getItems().set(slotId, item);
                              player.getInventory().refresh(slotId);
                              return true;
                           }

                           player.getEquipment().getItems().set(3, (Item)null);
                        }

                        if (player.getEquipment().getItem(targetSlot) != null && (itemId != player.getEquipment().getItem(targetSlot).getId() || !item.getDefinitions().isStackable())) {
                           if (player.getInventory().getItems().get(slotId) == null) {
                              player.getInventory().getItems().set(slotId, new Item(player.getEquipment().getItem(targetSlot).getId(), player.getEquipment().getItem(targetSlot).getAmount()));
                              player.getInventory().refresh(slotId);
                           } else {
                              player.getInventory().addItem(new Item(player.getEquipment().getItem(targetSlot).getId(), player.getEquipment().getItem(targetSlot).getAmount()));
                           }

                           player.getEquipment().getItems().set(targetSlot, (Item)null);
                        }

                        oldAmt = 0;
                        if (player.getEquipment().getItem(targetSlot) != null) {
                           oldAmt = player.getEquipment().getItem(targetSlot).getAmount();
                        }

                        Item item2 = new Item(itemId, oldAmt + item.getAmount());
                        player.getEquipment().getItems().set(targetSlot, item2);
                        player.getEquipment().refresh(targetSlot, targetSlot == 3 ? 5 : (targetSlot == 3 ? 0 : 3));
                        player.getAppearence().generateAppearenceData();
                        player.getPackets().sendSound(2240, 0, 1);
                        if (targetSlot == 3) {
                           player.getCombatDefinitions().desecreaseSpecialAttack(0);
                        }

                        player.getPackets().sendGlobalConfig(779, player.getEquipment().getWeaponRenderEmote());
                        if (player.getInterfaceManager().containsInterface(667)) {
                           refreshEquipBonuses(player);
                        }

                        return true;
                     }
                  }
               }
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   public static void refreshEquipBonuses(Player player) {
      int interfaceId = true;
      Object[][] var5;
      int var4 = (var5 = info).length;

      for(int var3 = 0; var3 < var4; ++var3) {
         Object[] element = var5[var3];
         int bonus = player.getCombatDefinitions().getBonuses()[(Integer)element[1]];
         String sign = bonus > 0 ? "+" : "";
         player.getPackets().sendIComponentText(667, (Integer)element[0], element[2] + ": " + sign + bonus);
      }

   }
}
