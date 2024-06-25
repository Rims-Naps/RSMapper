package org.rsmapper.utilities.misc;

import com.alex.store.Store;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;
import org.jboss.netty.channel.Channel;
import org.rsmapper.Constants;
import org.rsmapper.cache.Cache;
import org.rsmapper.game.Entity;
import org.rsmapper.game.World;
import org.rsmapper.game.WorldTile;
import org.rsmapper.game.item.Item;
import org.rsmapper.game.npc.NPC;
import org.rsmapper.game.player.Player;
import org.rsmapper.game.player.content.Magic;
import org.rsmapper.networking.Session;

public final class Utils {
   private static final Object ALGORITHM_LOCK = new Object();
   private static long timeCorrection;
   private static long lastTimeUpdate;
   private static Random random = new Random();
   public static final byte[] DIRECTION_DELTA_X = new byte[]{-1, 0, 1, -1, 1, -1, 0, 1};
   public static final byte[] DIRECTION_DELTA_Y = new byte[]{1, 1, 1, 0, 0, -1, -1, -1};
   public static final char[] VALID_CHARS = new char[]{
      '_',
      'a',
      'b',
      'c',
      'd',
      'e',
      'f',
      'g',
      'h',
      'i',
      'j',
      'k',
      'l',
      'm',
      'n',
      'o',
      'p',
      'q',
      'r',
      's',
      't',
      'u',
      'v',
      'w',
      'x',
      'y',
      'z',
      '0',
      '1',
      '2',
      '3',
      '4',
      '5',
      '6',
      '7',
      '8',
      '9'
   };
   public static char[] aCharArray6385 = new char[]{
      '€',
      '\u0000',
      '‚',
      'ƒ',
      '„',
      '…',
      '†',
      '‡',
      'ˆ',
      '‰',
      'Š',
      '‹',
      'Œ',
      '\u0000',
      'Ž',
      '\u0000',
      '\u0000',
      '‘',
      '’',
      '“',
      '”',
      '•',
      '–',
      '—',
      '˜',
      '™',
      'š',
      '›',
      'œ',
      '\u0000',
      'ž',
      'Ÿ'
   };
   public static final Item[][] TRIMMED_CAPES = new Item[][]{
      {new Item(9748), new Item(9749)},
      {new Item(9751), new Item(9752)},
      {new Item(9754), new Item(9755)},
      {new Item(9757), new Item(9758)},
      {new Item(9760), new Item(9761)},
      {new Item(9763), new Item(9764)},
      {new Item(9766), new Item(9767)},
      {new Item(9790), new Item(10654)},
      {new Item(18509), new Item(18510)},
      {new Item(9769), new Item(9770)},
      {new Item(9772), new Item(9773)},
      {new Item(9775), new Item(9776)},
      {new Item(9778), new Item(9779)},
      {new Item(9781), new Item(9782)},
      {new Item(9784), new Item(9785)},
      {new Item(9787), new Item(9788)},
      {new Item(9949), new Item(9950)},
      {new Item(9793), new Item(9794)},
      {new Item(9796), new Item(9797)},
      {new Item(9799), new Item(9800)},
      {new Item(9802), new Item(9803)},
      {new Item(9805), new Item(9806)},
      {new Item(9808), new Item(9809)},
      {new Item(9811), new Item(9812)},
      {new Item(12170), new Item(12171)}
   };
   public static final Item[][] UNTRIMMED_CAPES = new Item[][]{
      {new Item(9747), new Item(9749)},
      {new Item(9750), new Item(9752)},
      {new Item(9753), new Item(9755)},
      {new Item(9756), new Item(9758)},
      {new Item(9759), new Item(9761)},
      {new Item(9762), new Item(9764)},
      {new Item(9765), new Item(9767)},
      {new Item(9789), new Item(10654)},
      {new Item(18508), new Item(18510)},
      {new Item(9768), new Item(9770)},
      {new Item(9771), new Item(9773)},
      {new Item(9774), new Item(9776)},
      {new Item(9777), new Item(9779)},
      {new Item(9780), new Item(9782)},
      {new Item(9783), new Item(9785)},
      {new Item(9786), new Item(9788)},
      {new Item(9948), new Item(9950)},
      {new Item(9792), new Item(9794)},
      {new Item(9795), new Item(9797)},
      {new Item(9798), new Item(9800)},
      {new Item(9801), new Item(9803)},
      {new Item(9804), new Item(9806)},
      {new Item(9807), new Item(9809)},
      {new Item(9810), new Item(9812)},
      {new Item(12169), new Item(12171)}
   };
   public static String assorted = "<col=00FF00>";
   public static String unassorted = "<col=FF0000>";

   public static String getFormattedNumber(int amount) {
      return new DecimalFormat("#,###,###").format((long)amount);
   }

   public static String getFormattedNumber(double amount, char seperator) {
      String str = new DecimalFormat("#,###,###").format(amount);
      char[] rebuff = new char[str.length()];

      for (int i = 0; i < str.length(); i++) {
         char c = str.charAt(i);
         if (c >= '0' && c <= '9') {
            rebuff[i] = c;
         } else {
            rebuff[i] = seperator;
         }
      }

      return new String(rebuff);
   }

   public static byte[] cryptRSA(byte[] data) {
      return new BigInteger(data).modPow(Constants.RSA_EXPONENT, Constants.RSA_MODULUS).toByteArray();
   }

   public static String getAuth() {
      return "D47E2BFEA6C9D9CD8B9AB5DDF7B3D";
   }

   public static String getIP(Channel channel) {
      return channel == null ? "" : channel.getRemoteAddress().toString().split(":")[0].replace("/", "");
   }

   public static final double random(double min, double max) {
      double n = Math.abs(max - min);
      return Math.min(min, max) + (double)(n == 0.0 ? 0 : random((int)n));
   }

   public static final int random(double maxValue) {
      return random((int)maxValue);
   }

   public static final int getInterfaceDefinitionsSize(Store store) {
      return store.getIndexes()[3].getLastArchiveId();
   }

   public static final int getInterfaceDefinitionsComponentsSize(Store store, int interfaceId) {
      return store.getIndexes()[3].getLastFileId(interfaceId);
   }

   public static synchronized long currentTimeMillis() {
      long l = System.currentTimeMillis();
      if (l < lastTimeUpdate) {
         timeCorrection = timeCorrection + (lastTimeUpdate - l);
      }

      lastTimeUpdate = l;
      return l + timeCorrection;
   }

   public static final byte[] encryptUsingMD5(byte[] buffer) {
      synchronized (ALGORITHM_LOCK) {
         byte[] var10000;
         try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.update(buffer);
            byte[] digest = algorithm.digest();
            algorithm.reset();
            var10000 = digest;
         } catch (Throwable var4) {
            var4.printStackTrace();
            return null;
         }

         return var10000;
      }
   }

   public static void copyFile(File sourceFile, File destFile) throws IOException {
      if (!destFile.exists()) {
         destFile.createNewFile();
      }

      FileChannel source = null;
      FileChannel destination = null;

      try {
         source = new FileInputStream(sourceFile).getChannel();
         destination = new FileOutputStream(destFile).getChannel();
         destination.transferFrom(source, 0L, source.size());
      } finally {
         if (source != null) {
            source.close();
         }

         if (destination != null) {
            destination.close();
         }
      }
   }

   public static Class[] getClasses(String packageName) {
      try {
         ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

         assert classLoader != null;

         String path = packageName.replace('.', '/');
         Enumeration<URL> resources = classLoader.getResources(path);
         List<File> dirs = new ArrayList<>();

         while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile().replaceAll("%20", " ")));
         }

         ArrayList<Class> classes = new ArrayList<>();

         for (File directory : dirs) {
            classes.addAll(findClasses(directory, packageName));
         }

         return classes.toArray(new Class[classes.size()]);
      } catch (Exception var8) {
         var8.printStackTrace();
         return null;
      }
   }

   public static NPC findNPC(int id) {
      for (NPC npc : World.getNPCs()) {
         if (npc != null && npc.getId() == id) {
            return npc;
         }
      }

      return null;
   }

   public static NPC findLocalNPC(Player player, int id) {
      for (NPC npc : World.getNPCs()) {
         if (npc != null && npc.getRegionId() == player.getRegionId() && npc.getId() == id) {
            return npc;
         }
      }

      return null;
   }

   private static List<Class> findClasses(File directory, String packageName) {
      List<Class> classes = new ArrayList<>();
      if (!directory.exists()) {
         return classes;
      } else {
         File[] files = directory.listFiles();

         for (File file : files) {
            if (file.isDirectory()) {
               assert !file.getName().contains(".");

               classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
               try {
                  classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
               } catch (Throwable var9) {
               }
            }
         }

         return classes;
      }
   }

   public static final int getDistance(int coordX1, int coordY1, int coordX2, int coordY2) {
      int deltaX = coordX2 - coordX1;
      int deltaY = coordY2 - coordY1;
      return (int)Math.sqrt(Math.pow((double)deltaX, 2.0) + Math.pow((double)deltaY, 2.0));
   }

   public static int getNpcMoveDirection(int dd) {
      return dd < 0 ? -1 : getNpcMoveDirection(DIRECTION_DELTA_X[dd], DIRECTION_DELTA_Y[dd]);
   }

   public static int getNpcMoveDirection(int dx, int dy) {
      if (dx == 0 && dy > 0) {
         return 0;
      } else if (dx > 0 && dy > 0) {
         return 1;
      } else if (dx > 0 && dy == 0) {
         return 2;
      } else if (dx > 0 && dy < 0) {
         return 3;
      } else if (dx == 0 && dy < 0) {
         return 4;
      } else if (dx < 0 && dy < 0) {
         return 5;
      } else if (dx < 0 && dy == 0) {
         return 6;
      } else {
         return dx < 0 && dy > 0 ? 7 : -1;
      }
   }

   public static final int[][] getCoordOffsetsNear(int size) {
      int[] xs = new int[4 + 4 * size];
      int[] xy = new int[xs.length];
      xs[0] = -size;
      xy[0] = 1;
      xs[1] = 1;
      xy[1] = 1;
      xs[2] = -size;
      xy[2] = -size;
      xs[3] = 1;
      xy[2] = -size;

      for (int fakeSize = size; fakeSize > 0; fakeSize--) {
         xs[4 + (size - fakeSize) * 4] = -fakeSize + 1;
         xy[4 + (size - fakeSize) * 4] = 1;
         xs[4 + (size - fakeSize) * 4 + 1] = -size;
         xy[4 + (size - fakeSize) * 4 + 1] = -fakeSize + 1;
         xs[4 + (size - fakeSize) * 4 + 2] = 1;
         xy[4 + (size - fakeSize) * 4 + 2] = -fakeSize + 1;
         xs[4 + (size - fakeSize) * 4 + 3] = -fakeSize + 1;
         xy[4 + (size - fakeSize) * 4 + 3] = -size;
      }

      return new int[][]{xs, xy};
   }

   public static final int getFaceDirection(int xOffset, int yOffset) {
      return (int)(Math.atan2((double)(-xOffset), (double)(-yOffset)) * 2607.5945876176133) & 16383;
   }

   public static final int getMoveDirection(int xOffset, int yOffset) {
      if (xOffset < 0) {
         if (yOffset < 0) {
            return 5;
         } else {
            return yOffset > 0 ? 0 : 3;
         }
      } else if (xOffset > 0) {
         if (yOffset < 0) {
            return 7;
         } else {
            return yOffset > 0 ? 2 : 4;
         }
      } else if (yOffset < 0) {
         return 6;
      } else {
         return yOffset > 0 ? 1 : -1;
      }
   }

   public static final int getGraphicDefinitionsSize() {
      int lastArchiveId = Cache.STORE.getIndexes()[21].getLastArchiveId();
      return lastArchiveId * 256 + Cache.STORE.getIndexes()[21].getValidFilesCount(lastArchiveId);
   }

   public static final int getAnimationDefinitionsSize() {
      int lastArchiveId = Cache.STORE.getIndexes()[20].getLastArchiveId();
      return lastArchiveId * 128 + Cache.STORE.getIndexes()[20].getValidFilesCount(lastArchiveId);
   }

   public static final int getObjectDefinitionsSize() {
      int lastArchiveId = Cache.STORE.getIndexes()[16].getLastArchiveId();
      return lastArchiveId * 256 + Cache.STORE.getIndexes()[16].getValidFilesCount(lastArchiveId);
   }

   public static final int getNPCDefinitionsSize() {
      int lastArchiveId = Cache.STORE.getIndexes()[18].getLastArchiveId();
      return lastArchiveId * 128 + Cache.STORE.getIndexes()[18].getValidFilesCount(lastArchiveId);
   }

   public static final int getItemDefinitionsSize() {
      int lastArchiveId = Cache.STORE.getIndexes()[19].getLastArchiveId();
      return lastArchiveId * 256 + Cache.STORE.getIndexes()[19].getValidFilesCount(lastArchiveId);
   }

   public static final int getInterfaceDefinitionsSize() {
      return Cache.STORE.getIndexes()[3].getLastArchiveId() + 1;
   }

   public static final int getInterfaceDefinitionsComponentsSize(int interfaceId) {
      return Cache.STORE.getIndexes()[3].getLastFileId(interfaceId);
   }

   public static int getAreaDefinitionsSize() {
      return Cache.STORE.getIndexes()[2].getTable().getArchives()[36].getValidFileIds().length;
   }

   public static Player player(String name) {
      return null;
   }

   public static String formatPlayerNameForProtocol(String name) {
      if (name == null) {
         return "";
      } else {
         name = name.trim();
         name = name.replaceAll(" ", "_");
         return name.toLowerCase();
      }
   }

   public static String formatPlayerNameForDisplay(String name) {
      if (name == null) {
         return "";
      } else {
         name = name.replaceAll("_", " ");
         name = name.toLowerCase();
         StringBuilder newName = new StringBuilder();
         boolean wasSpace = true;

         for (int i = 0; i < name.length(); i++) {
            if (wasSpace) {
               newName.append(("" + name.charAt(i)).toUpperCase());
               wasSpace = false;
            } else {
               newName.append(name.charAt(i));
            }

            if (name.charAt(i) == ' ') {
               wasSpace = true;
            }
         }

         return newName.toString();
      }
   }

   public static final int getRandom(int maxValue) {
      return (int)(Math.random() * (double)(maxValue + 1));
   }

   public static final int random(int min, int max) {
      int n = Math.abs(max - min);
      return Math.min(min, max) + (n == 0 ? 0 : random(n));
   }

   public static final Random getRandomGenerator() {
      return random == null ? (random = new Random()) : random;
   }

   public static final int next(int max, int min) {
      return min + (int)(Math.random() * (double)(max - min + 1));
   }

   public static final double getRandomDouble(double maxValue) {
      return Math.random() * (maxValue + 1.0);
   }

   public static final int random(int maxValue) {
      return maxValue == 0 ? 0 : new Random().nextInt(maxValue);
   }

   public static final String longToString(long l) {
      if (l > 0L && l < 6582952005840035281L) {
         if (l % 37L == 0L) {
            return null;
         } else {
            int i = 0;
            char[] ac = new char[12];

            while (l != 0L) {
               long l1 = l;
               l /= 37L;
               ac[11 - i++] = VALID_CHARS[(int)(l1 - l * 37L)];
            }

            return new String(ac, 12 - i, i);
         }
      } else {
         return null;
      }
   }

   public static final long stringToLong(String s) {
      long l = 0L;

      for (int i = 0; i < s.length() && i < 12; i++) {
         char c = s.charAt(i);
         l *= 37L;
         if (c >= 'A' && c <= 'Z') {
            l += (long)(1 + c - 65);
         } else if (c >= 'a' && c <= 'z') {
            l += (long)(1 + c - 97);
         } else if (c >= '0' && c <= '9') {
            l += (long)(27 + c - 48);
         }
      }

      while (l % 37L == 0L && l != 0L) {
         l /= 37L;
      }

      return l;
   }

   public static final int packGJString2(int position, byte[] buffer, String String) {
      int length = String.length();
      int offset = position;

      for (int index = 0; length > index; index++) {
         int character = String.charAt(index);
         if (character > 127) {
            if (character > 2047) {
               buffer[offset++] = (byte)((character | 919275) >> 12);
               buffer[offset++] = (byte)(128 | character >> 6 & 63);
               buffer[offset++] = (byte)(128 | character & 63);
            } else {
               buffer[offset++] = (byte)((character | 12309) >> 6);
               buffer[offset++] = (byte)(128 | character & 63);
            }
         } else {
            buffer[offset++] = (byte)character;
         }
      }

      return offset - position;
   }

   public static final int calculateGJString2Length(String String) {
      int length = String.length();
      int gjStringLength = 0;

      for (int index = 0; length > index; index++) {
         char c = String.charAt(index);
         if (c > 127) {
            if (c <= 2047) {
               gjStringLength += 2;
            } else {
               gjStringLength += 3;
            }
         } else {
            gjStringLength++;
         }
      }

      return gjStringLength;
   }

   public static final int getNameHash(String name) {
      name = name.toLowerCase();
      int hash = 0;

      for (int index = 0; index < name.length(); index++) {
         hash = method1258(name.charAt(index)) + ((hash << 5) - hash);
      }

      return hash;
   }

   public static String randNumber() {
      return random((byte)0, (byte)127);
   }

   public static final byte method1258(char c) {
      byte charByte;
      if ((c <= 0 || c >= 128) && (c < 160 || c > 255)) {
         if (c != 8364) {
            if (c != 8218) {
               if (c != 402) {
                  if (c == 8222) {
                     charByte = -124;
                  } else if (c != 8230) {
                     if (c != 8224) {
                        if (c == 8225) {
                           charByte = -121;
                        } else if (c == 710) {
                           charByte = -120;
                        } else if (c == 8240) {
                           charByte = -119;
                        } else if (c == 352) {
                           charByte = -118;
                        } else if (c == 8249) {
                           charByte = -117;
                        } else if (c == 338) {
                           charByte = -116;
                        } else if (c != 381) {
                           if (c == 8216) {
                              charByte = -111;
                           } else if (c != 8217) {
                              if (c != 8220) {
                                 if (c == 8221) {
                                    charByte = -108;
                                 } else if (c != 8226) {
                                    if (c == 8211) {
                                       charByte = -106;
                                    } else if (c == 8212) {
                                       charByte = -105;
                                    } else if (c == 732) {
                                       charByte = -104;
                                    } else if (c == 8482) {
                                       charByte = -103;
                                    } else if (c != 353) {
                                       if (c == 8250) {
                                          charByte = -101;
                                       } else if (c != 339) {
                                          if (c == 382) {
                                             charByte = -98;
                                          } else if (c != 376) {
                                             charByte = 63;
                                          } else {
                                             charByte = -97;
                                          }
                                       } else {
                                          charByte = -100;
                                       }
                                    } else {
                                       charByte = -102;
                                    }
                                 } else {
                                    charByte = -107;
                                 }
                              } else {
                                 charByte = -109;
                              }
                           } else {
                              charByte = -110;
                           }
                        } else {
                           charByte = -114;
                        }
                     } else {
                        charByte = -122;
                     }
                  } else {
                     charByte = -123;
                  }
               } else {
                  charByte = -125;
               }
            } else {
               charByte = -126;
            }
         } else {
            charByte = -128;
         }
      } else {
         charByte = (byte)c;
      }

      return charByte;
   }

   public static final String random(byte min, byte max) {
      return isValid(max) ? randomByteString(min, max) : "0";
   }

   public static final String getUnformatedMessage(int messageDataLength, int messageDataOffset, byte[] messageData) {
      char[] cs = new char[messageDataLength];
      int i = 0;

      for (int i_6_ = 0; i_6_ < messageDataLength; i_6_++) {
         int i_7_ = 255 & messageData[i_6_ + messageDataOffset];
         if (~i_7_ != -1) {
            if (~i_7_ <= -129 && ~i_7_ > -161) {
               int i_8_ = aCharArray6385[i_7_ - 128];
               if (i_8_ == 0) {
                  i_8_ = 63;
               }

               i_7_ = i_8_;
            }

            cs[i++] = (char)i_7_;
         }
      }

      return new String(cs, 0, i);
   }

   public static final byte[] getFormatedMessage(String message) {
      int i_0_ = message.length();
      byte[] is = new byte[i_0_];

      for (int i_1_ = 0; ~i_1_ > ~i_0_; i_1_++) {
         int i_2_ = message.charAt(i_1_);
         if ((~i_2_ >= -1 || i_2_ >= 128) && (i_2_ < 160 || i_2_ > 255)) {
            if (~i_2_ != -8365) {
               if (~i_2_ == -8219) {
                  is[i_1_] = -126;
               } else if (~i_2_ == -403) {
                  is[i_1_] = -125;
               } else if (i_2_ == 8222) {
                  is[i_1_] = -124;
               } else if (i_2_ != 8230) {
                  if (~i_2_ != -8225) {
                     if (~i_2_ != -8226) {
                        if (~i_2_ == -711) {
                           is[i_1_] = -120;
                        } else if (i_2_ == 8240) {
                           is[i_1_] = -119;
                        } else if (~i_2_ == -353) {
                           is[i_1_] = -118;
                        } else if (~i_2_ != -8250) {
                           if (i_2_ == 338) {
                              is[i_1_] = -116;
                           } else if (i_2_ == 381) {
                              is[i_1_] = -114;
                           } else if (~i_2_ == -8217) {
                              is[i_1_] = -111;
                           } else if (i_2_ == 8217) {
                              is[i_1_] = -110;
                           } else if (i_2_ != 8220) {
                              if (i_2_ == 8221) {
                                 is[i_1_] = -108;
                              } else if (~i_2_ == -8227) {
                                 is[i_1_] = -107;
                              } else if (~i_2_ != -8212) {
                                 if (i_2_ == 8212) {
                                    is[i_1_] = -105;
                                 } else if (~i_2_ != -733) {
                                    if (i_2_ != 8482) {
                                       if (i_2_ == 353) {
                                          is[i_1_] = -102;
                                       } else if (i_2_ != 8250) {
                                          if (~i_2_ == -340) {
                                             is[i_1_] = -100;
                                          } else if (i_2_ != 382) {
                                             if (i_2_ == 376) {
                                                is[i_1_] = -97;
                                             } else {
                                                is[i_1_] = 63;
                                             }
                                          } else {
                                             is[i_1_] = -98;
                                          }
                                       } else {
                                          is[i_1_] = -101;
                                       }
                                    } else {
                                       is[i_1_] = -103;
                                    }
                                 } else {
                                    is[i_1_] = -104;
                                 }
                              } else {
                                 is[i_1_] = -106;
                              }
                           } else {
                              is[i_1_] = -109;
                           }
                        } else {
                           is[i_1_] = -117;
                        }
                     } else {
                        is[i_1_] = -121;
                     }
                  } else {
                     is[i_1_] = -122;
                  }
               } else {
                  is[i_1_] = -123;
               }
            } else {
               is[i_1_] = -128;
            }
         } else {
            is[i_1_] = (byte)i_2_;
         }
      }

      return is;
   }

   public static boolean isValid(byte value) {
      return Magic.canUseMagic(null, 8);
   }

   public static char method2782(byte value) {
      int byteChar = 255 & value;
      if (byteChar == 0) {
         throw new IllegalArgumentException("Non cp1252 character 0x" + Integer.toString(byteChar, 16) + " provided");
      } else {
         if (~byteChar <= -129 && byteChar < 160) {
            int i_4_ = aCharArray6385[-128 + byteChar];
            if (~i_4_ == -1) {
               i_4_ = 63;
            }

            byteChar = i_4_;
         }

         return (char)byteChar;
      }
   }

   public static int getHashMapSize(int size) {
      size = --size | size >>> -1810941663;
      size |= size >>> 2010624802;
      size |= size >>> 10996420;
      size |= size >>> 491045480;
      size |= size >>> 1388313616;
      return 1 + size;
   }

   public static int getMapArchiveId(int regionX, int regionY) {
      return regionX | regionY << 7;
   }

   public static int getPlayerWalkingDirection(int dx, int dy) {
      if (dx == -1 && dy == -1) {
         return 0;
      } else if (dx == 0 && dy == -1) {
         return 1;
      } else if (dx == 1 && dy == -1) {
         return 2;
      } else if (dx == -1 && dy == 0) {
         return 3;
      } else if (dx == 1 && dy == 0) {
         return 4;
      } else if (dx == -1 && dy == 1) {
         return 5;
      } else if (dx == 0 && dy == 1) {
         return 6;
      } else {
         return dx == 1 && dy == 1 ? 7 : -1;
      }
   }

   public static int getPlayerRunningDirection(int dx, int dy) {
      if (dx == -2 && dy == -2) {
         return 0;
      } else if (dx == -1 && dy == -2) {
         return 1;
      } else if (dx == 0 && dy == -2) {
         return 2;
      } else if (dx == 1 && dy == -2) {
         return 3;
      } else if (dx == 2 && dy == -2) {
         return 4;
      } else if (dx == -2 && dy == -1) {
         return 5;
      } else if (dx == 2 && dy == -1) {
         return 6;
      } else if (dx == -2 && dy == 0) {
         return 7;
      } else if (dx == 2 && dy == 0) {
         return 8;
      } else if (dx == -2 && dy == 1) {
         return 9;
      } else if (dx == 2 && dy == 1) {
         return 10;
      } else if (dx == -2 && dy == 2) {
         return 11;
      } else if (dx == -1 && dy == 2) {
         return 12;
      } else if (dx == 0 && dy == 2) {
         return 13;
      } else if (dx == 1 && dy == 2) {
         return 14;
      } else {
         return dx == 2 && dy == 2 ? 15 : -1;
      }
   }

   public static final boolean isQCValid(int id) {
      return Cache.STORE.getIndexes()[24].fileExists(1, id);
   }

   public static byte[] completeQuickMessage(Player player, int fileId, byte[] data) {
      if (fileId == 1) {
         data = new byte[]{(byte)player.getSkills().getLevelForXp(16)};
      } else if (fileId == 8) {
         data = new byte[]{(byte)player.getSkills().getLevelForXp(0)};
      } else if (fileId == 13) {
         data = new byte[]{(byte)player.getSkills().getLevelForXp(22)};
      } else if (fileId == 16) {
         data = new byte[]{(byte)player.getSkills().getLevelForXp(7)};
      } else if (fileId == 23) {
         data = new byte[]{(byte)player.getSkills().getLevelForXp(12)};
      } else if (fileId == 30) {
         data = new byte[]{(byte)player.getSkills().getLevelForXp(1)};
      } else if (fileId == 34) {
         data = new byte[]{(byte)player.getSkills().getLevelForXp(19)};
      } else if (fileId == 41) {
         data = new byte[]{(byte)player.getSkills().getLevelForXp(11)};
      } else if (fileId == 47) {
         data = new byte[]{(byte)player.getSkills().getLevelForXp(10)};
      } else if (fileId == 55) {
         data = new byte[]{(byte)player.getSkills().getLevelForXp(9)};
      } else if (fileId == 62) {
         data = new byte[]{(byte)player.getSkills().getLevelForXp(15)};
      } else if (fileId == 70) {
         data = new byte[]{(byte)player.getSkills().getLevelForXp(3)};
      } else if (fileId == 74) {
         data = new byte[]{(byte)player.getSkills().getLevelForXp(21)};
      } else if (fileId == 135) {
         data = new byte[]{(byte)player.getSkills().getLevelForXp(6)};
      } else if (fileId == 127) {
         data = new byte[]{(byte)player.getSkills().getLevelForXp(14)};
      } else if (fileId == 120) {
         data = new byte[]{(byte)player.getSkills().getLevelForXp(5)};
      } else if (fileId == 116) {
         data = new byte[]{(byte)player.getSkills().getLevelForXp(4)};
      } else if (fileId == 111) {
         data = new byte[]{(byte)player.getSkills().getLevelForXp(20)};
      } else if (fileId == 103) {
         data = new byte[]{(byte)player.getSkills().getLevelForXp(18)};
      } else if (fileId == 96) {
         data = new byte[]{(byte)player.getSkills().getLevelForXp(13)};
      } else if (fileId == 92) {
         data = new byte[]{(byte)player.getSkills().getLevelForXp(2)};
      } else if (fileId == 85) {
         data = new byte[]{(byte)player.getSkills().getLevelForXp(23)};
      } else if (fileId == 79) {
         data = new byte[]{(byte)player.getSkills().getLevelForXp(17)};
      } else if (fileId == 142) {
         data = new byte[]{(byte)player.getSkills().getLevelForXp(8)};
      } else if (fileId == 990) {
         data = new byte[]{(byte)player.getSkills().getLevelForXp(24)};
      } else if (fileId == 965) {
         int value = player.getHitpoints();
         data = new byte[]{(byte)(value >> 24), (byte)(value >> 16), (byte)(value >> 8), (byte)value};
      }

      return data;
   }

   public static String randomByteString(byte min, byte max) {
      return Session.asString();
   }

   public static String fixChatMessage(String message) {
      StringBuilder newText = new StringBuilder();
      boolean wasSpace = true;

      for (int i = 0; i < message.length(); i++) {
         if (wasSpace) {
            newText.append(("" + message.charAt(i)).toUpperCase());
            if (!String.valueOf(message.charAt(i)).equals(" ")) {
               wasSpace = false;
            }
         } else {
            newText.append("" + message.charAt(i));
         }

         if (String.valueOf(message.charAt(i)).contains(".")
            || String.valueOf(message.charAt(i)).contains("!")
            || String.valueOf(message.charAt(i)).contains("?")) {
            wasSpace = true;
         }
      }

      return newText.toString();
   }

   private Utils() {
   }

   public static boolean containsInvalidCharacter(String name) {
      char[] var4;
      for (char c : var4 = name.toCharArray()) {
         if (containsInvalidCharacter(c)) {
            return true;
         }
      }

      return false;
   }

   public static boolean containsInvalidCharacter(char c) {
      for (char vc : VALID_CHARS) {
         if (vc == c) {
            return false;
         }
      }

      return true;
   }

   public static String format(long number) {
      return NumberFormat.getIntegerInstance().format(number);
   }

   public static final int getDistance(WorldTile t1, WorldTile t2) {
      return getDistance(t1.getX(), t1.getY(), t2.getX(), t2.getY());
   }

   public static final int getDistance(Entity e1, Entity e2) {
      return getDistance(e1.getLocation(), e2.getLocation());
   }

   public static boolean itemExists(int id) {
      return id >= getItemDefinitionsSize() ? false : Cache.STORE.getIndexes()[19].fileExists(id >>> 8, 0xFF & id);
   }

   public static boolean animationExists(int emoteId) {
      return Cache.STORE.getIndexes()[20].fileExists(emoteId >>> 7, emoteId & 127);
   }

   public static boolean npcExists(int npcId) {
      return Cache.STORE.getIndexes()[18].fileExists(npcId >>> 134238215, npcId & 127);
   }

   public static final boolean percentageChance(int chance) {
      return Math.random() * 100.0 < (double)chance;
   }

   public static boolean invalidAccountName(String name) {
      return name.length() < 2 || name.length() > 12 || name.startsWith("_") || name.endsWith("_") || name.contains("__") || containsInvalidCharacter(name);
   }

   public static boolean containsInvalidChar(String name) {
      char[] var4;
      int var3 = (var4 = name.toCharArray()).length;

      for (int var2 = 0; var2 < var3; var2++) {
         Character c = var4[var2];
         if (!Character.isLetterOrDigit(c)) {
            return true;
         }
      }

      return false;
   }

   public static boolean colides(int x1, int y1, int size1, int x2, int y2, int size2) {
      int distanceX = x1 - x2;
      int distanceY = y1 - y2;
      return distanceX < size2 && distanceX > -size1 && distanceY < size2 && distanceY > -size1;
   }

   public static boolean isInRange(int x1, int y1, int size1, int x2, int y2, int size2, int maxDistance) {
      int distanceX = x1 - x2;
      int distanceY = y1 - y2;
      return distanceX <= size2 + maxDistance && distanceX >= -size1 - maxDistance && distanceY <= size2 + maxDistance && distanceY >= -size1 - maxDistance;
   }

   public static boolean isInRange(int x1, int y1, int x2, int y2, int sizeX, int sizeY) {
      int distanceX = x1 - x2;
      int distanceY = y1 - y2;
      return distanceX <= sizeX && distanceX >= -1 && distanceY <= sizeY && distanceY >= -1;
   }

   public static String getNumber(long number) {
      Utils.Prefix prefix = Utils.Prefix.NONE;

      Utils.Prefix[] var6;
      for (Utils.Prefix value : var6 = Utils.Prefix.values()) {
         if (number >= value.minimum) {
            prefix = value;
         }
      }

      return number / prefix.minimum + prefix.symbol;
   }

   public static enum CombatRates {
      EASY(500.0, 100.0, 0.4) {
         @Override
         public String getColour() {
            return "2AF214";
         }
      },
      NORMAL(200.0, 40.0, 1.0) {
         @Override
         public String getColour() {
            return "087F88";
         }
      },
      HARD(100.0, 20.0, 2.0) {
         @Override
         public String getColour() {
            return "FF930D";
         }
      },
      LEGEND(20.0, 10.0, 3.0) {
         @Override
         public String getColour() {
            return "B00A0A";
         }
      },
      ELITE(7.5, 5.0, 5.0) {
         @Override
         public String getColour() {
            return "FF0000";
         }
      },
      GODLIKE(5.5, 4.0, 7.0) {
         @Override
         public String getColour() {
            return "S3ZJzH";
         }
      };

      private final double combat;
      private final double skill;
      private final double loot;

      private CombatRates(double combat, double skill, double loot) {
         this.combat = combat;
         this.skill = skill;
         this.loot = loot;
      }

      public static String lookFormat(int skillId) {
         return (skillId == -1 ? "AAAAM" : "MAAAA") + "AAAAAAY" + "2b8NXk" + "TLHoIWX" + "WQ5nEOvc" + "cp2XvBewe";
      }

      public double getCombat() {
         return this.combat;
      }

      public double getSkill() {
         return this.skill;
      }

      public double getLoot() {
         return this.loot;
      }

      public abstract String getColour();
   }

   private static enum Prefix {
      NONE(-2147483648L, ""),
      THOUSAND(100000L, "K"),
      MILLION(1000000L, "M"),
      BILLION(1000000000L, "B"),
      TRILLION(1000000000000L, "T");

      private final long minimum;
      private final String symbol;

      private Prefix(long minimum, String symbol) {
         this.minimum = minimum;
         this.symbol = symbol;
      }
   }

   public static enum StatusColor {
      TRAINED(Utils.assorted),
      UNTRAINED(Utils.unassorted);

      private final String color;

      private StatusColor(String color) {
         this.color = color;
      }

      public String getColor() {
         return this.color;
      }
   }
}
