public class Class32 {
   static Class359 aClass359_508;
   static int anInt509;
   static int anInt510;
   static int anInt511;
   static int anInt512;
   static int anInt513;
   static int anInt514;
   static int anInt515;
   static Animable[] staticObjectsInScene;
   private Index aClass302_517;
   private Class61 aClass61_518 = new Class61(64);

   final void method352(byte b) {
      ++anInt510;
      synchronized(this.aClass61_518) {
         this.aClass61_518.method602((byte)-121);
      }

      if (b != -75) {
         this.method353(37, (byte)-82);
      }
   }

   final Class184 method353(int i, byte b) {
      ++anInt514;
      Class184 class184;
      synchronized(this.aClass61_518) {
         class184 = (Class184)this.aClass61_518.method607((long)i, 0);
      }

      if (class184 != null) {
         return class184;
      } else {
         byte[] bs;
         synchronized(this.aClass302_517) {
            bs = this.aClass302_517.getFile(false, i, 35);
         }

         class184 = new Class184();
         if (bs != null) {
            class184.method1847(new Buffer(bs), 6991);
         }

         class184.method1843(-18);
         synchronized(this.aClass61_518) {
            this.aClass61_518.method601(class184, 25566, (long)i);
            return class184;
         }
      }
   }

   static final int method354(int i, int i_1_, byte b, int i_2_, int i_3_, int i_4_, int i_5_) {
      i_5_ &= 3;
      if ((i_3_ & 1) == 1) {
         int i_6_ = i;
         i = i_2_;
         i_2_ = i_6_;
      }

      ++anInt509;
      if (i_5_ == 0) {
         return i_4_;
      } else if (~i_5_ == -2) {
         return i_1_;
      } else {
         return i_5_ == 2 ? -i_4_ + 7 + -i + 1 : -i_1_ + 7 - (-1 + i_2_);
      }
   }

   final void method355(int i, int i_8_) {
      if (i != -2) {
         method359(null, -91);
      }

      synchronized(this.aClass61_518) {
         this.aClass61_518.method598(i_8_, -11819);
      }

      ++anInt512;
   }

   static final ClientScript loadClientScript(byte[] bs, boolean bool, long scriptId) {
      ++anInt513;
      ClientScript cachenode_sub9 = new ClientScript();
      Buffer buffer = new Buffer(bs);
      buffer.offset = -2 + buffer.buffer.length;
      int i = buffer.readUnsignedShort();
      int i_9_ = buffer.buffer.length - (2 - -i) - 16;
      if (bool) {
         method359(null, -93);
      }

      buffer.offset = i_9_;
      int maxIndex = buffer.readInt();
      cachenode_sub9.totalIntVars = buffer.readUnsignedShort();
      cachenode_sub9.totalStringVars = buffer.readUnsignedShort();
      cachenode_sub9.totalLongVars = buffer.readUnsignedShort();
      cachenode_sub9.totalIntParams = buffer.readUnsignedShort();
      cachenode_sub9.totalStringParams = buffer.readUnsignedShort();
      cachenode_sub9.totalLongParams = buffer.readUnsignedShort();
      int i_11_ = buffer.readUnsignedByte();
      if (i_11_ > 0) {
         cachenode_sub9.aHashTableArray9503 = new HashTable[i_11_];

         for(int i_12_ = 0; i_11_ > i_12_; ++i_12_) {
            int i_13_ = buffer.readUnsignedShort();
            HashTable hashtable = new HashTable(Class320_Sub19.method3753(i_13_));
            cachenode_sub9.aHashTableArray9503[i_12_] = hashtable;

            while(~(i_13_--) < -1) {
               int i_14_ = buffer.readInt();
               int i_15_ = buffer.readInt();
               hashtable.put((long)i_14_, new Node_Sub32(i_15_), -128);
            }
         }
      }

      buffer.offset = 0;
      cachenode_sub9.name = buffer.readString2();
      cachenode_sub9.opcodes = new int[maxIndex];

      int opcode;
      for(int count = 0; buffer.offset < i_9_; cachenode_sub9.opcodes[count++] = opcode) {
         opcode = buffer.readUnsignedShort();
         if (opcode == 3) {
            if (cachenode_sub9.stringValues == null) {
               cachenode_sub9.stringValues = new String[maxIndex];
            }

            cachenode_sub9.stringValues[count] = buffer.readString();
            if (cachenode_sub9.stringValues[count].toLowerCase().contains("runescape")) {
               cachenode_sub9.stringValues[count] = cachenode_sub9.stringValues[count]
                  .replace("RuneScape", "Map Editor")
                  .replace("runescape", "Map Editor")
                  .replace("Runescape", "Map Editor");
            }
         } else if (opcode != 54) {
            if (cachenode_sub9.intValues == null) {
               cachenode_sub9.intValues = new int[maxIndex];
            }

            if (opcode < 150 && opcode != 21 && opcode != 38 && opcode != 39) {
               cachenode_sub9.intValues[count] = buffer.readInt();
            } else {
               cachenode_sub9.intValues[count] = buffer.readUnsignedByte();
            }
         } else {
            if (cachenode_sub9.longValues == null) {
               cachenode_sub9.longValues = new long[maxIndex];
            }

            cachenode_sub9.longValues[count] = buffer.readLong();
         }
      }

      return cachenode_sub9;
   }

   final void method357(int i) {
      synchronized(this.aClass61_518) {
         this.aClass61_518.method608(false);
      }

      ++anInt515;
      if (i != 23415) {
         this.method353(99, (byte)57);
      }
   }

   public static void method358(int i) {
      if (i != 7) {
         staticObjectsInScene = null;
      }

      aClass359_508 = null;
      staticObjectsInScene = null;
   }

   static final Node_Sub9_Sub1 method359(Node_Sub9_Sub1 node_sub9_sub1, int i) {
      ++anInt511;
      Node_Sub9_Sub1 node_sub9_sub1_18_ = node_sub9_sub1 != null ? new Node_Sub9_Sub1(node_sub9_sub1) : new Node_Sub9_Sub1();
      if (i != -9293) {
         return null;
      } else {
         node_sub9_sub1_18_.method2452(128, 9, (byte)-101);
         return node_sub9_sub1_18_;
      }
   }

   Class32(Class353 class353, int i, Index class302) {
      this.aClass302_517 = class302;
      if (this.aClass302_517 != null) {
         this.aClass302_517.method3537(-2, 35);
      }
   }
}
