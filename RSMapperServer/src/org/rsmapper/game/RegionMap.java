package org.rsmapper.game;

public class RegionMap {
   private int regionX;
   private int regionY;
   private int[][][] masks;
   private boolean clipedOnly;

   public RegionMap(int regionId, boolean clipedOnly) {
      this.regionX = (regionId >> 8) * 64;
      this.regionY = (regionId & 255) * 64;
      this.masks = new int[4][64][64];
      this.clipedOnly = clipedOnly;
   }

   public int[][][] getMasks() {
      return this.masks;
   }

   public int getRegionX() {
      return this.regionX;
   }

   public int getRegionY() {
      return this.regionY;
   }

   public void addUnwalkable(int plane, int x, int y) {
      this.addMask(plane, x, y, 2097152);
   }

   public void addFloor(int plane, int x, int y) {
      this.addMask(plane, x, y, 262144);
   }

   public void removeFloor(int plane, int x, int y) {
      this.removeMask(plane, x, y, 262144);
   }

   public void addObject(int plane, int x, int y, int sizeX, int sizeY, boolean solid, boolean notAlternative) {
      int mask = 256;
      if (solid) {
         mask |= 131072;
      }

      if (notAlternative) {
         mask |= 1073741824;
      }

      for(int tileX = x; tileX < x + sizeX; ++tileX) {
         for(int tileY = y; tileY < y + sizeY; ++tileY) {
            this.addMask(plane, tileX, tileY, mask);
         }
      }

   }

   public void removeObject(int plane, int x, int y, int sizeX, int sizeY, boolean solid, boolean notAlternative) {
      int mask = 256;
      if (solid) {
         mask |= 131072;
      }

      if (notAlternative) {
         mask |= 1073741824;
      }

      for(int tileX = x; tileX < x + sizeX; ++tileX) {
         for(int tileY = y; tileY < y + sizeY; ++tileY) {
            this.removeMask(plane, tileX, tileY, mask);
         }
      }

   }

   public void addWall(int plane, int x, int y, int type, int rotation, boolean solid, boolean notAlternative) {
      if (type == 0) {
         if (rotation == 0) {
            this.addMask(plane, x, y, 128);
            this.addMask(plane, x - 1, y, 8);
         }

         if (rotation == 1) {
            this.addMask(plane, x, y, 2);
            this.addMask(plane, x, 1 + y, 32);
         }

         if (rotation == 2) {
            this.addMask(plane, x, y, 8);
            this.addMask(plane, 1 + x, y, 128);
         }

         if (rotation == 3) {
            this.addMask(plane, x, y, 32);
            this.addMask(plane, x, -1 + y, 2);
         }
      }

      if (type == 1 || type == 3) {
         if (rotation == 0) {
            this.addMask(plane, x, y, 1);
            this.addMask(plane, -1 + x, 1 + y, 16);
         }

         if (rotation == 1) {
            this.addMask(plane, x, y, 4);
            this.addMask(plane, 1 + x, 1 + y, 64);
         }

         if (rotation == 2) {
            this.addMask(plane, x, y, 16);
            this.addMask(plane, x + 1, -1 + y, 1);
         }

         if (rotation == 3) {
            this.addMask(plane, x, y, 64);
            this.addMask(plane, x - 1, -1 + y, 4);
         }
      }

      if (type == 2) {
         if (rotation == 0) {
            this.addMask(plane, x, y, 130);
            this.addMask(plane, -1 + x, y, 8);
            this.addMask(plane, x, y + 1, 32);
         }

         if (rotation == 1) {
            this.addMask(plane, x, y, 10);
            this.addMask(plane, x, 1 + y, 32);
            this.addMask(plane, 1 + x, y, 128);
         }

         if (rotation == 2) {
            this.addMask(plane, x, y, 40);
            this.addMask(plane, 1 + x, y, 128);
            this.addMask(plane, x, -1 + y, 2);
         }

         if (rotation == 3) {
            this.addMask(plane, x, y, 160);
            this.addMask(plane, x, -1 + y, 2);
            this.addMask(plane, -1 + x, y, 8);
         }
      }

      if (solid) {
         if (type == 0) {
            if (rotation == 0) {
               this.addMask(plane, x, y, 65536);
               this.addMask(plane, x - 1, y, 4096);
            }

            if (rotation == 1) {
               this.addMask(plane, x, y, 1024);
               this.addMask(plane, x, 1 + y, 16384);
            }

            if (rotation == 2) {
               this.addMask(plane, x, y, 4096);
               this.addMask(plane, x + 1, y, 65536);
            }

            if (rotation == 3) {
               this.addMask(plane, x, y, 16384);
               this.addMask(plane, x, -1 + y, 1024);
            }
         }

         if (type == 1 || type == 3) {
            if (rotation == 0) {
               this.addMask(plane, x, y, 512);
               this.addMask(plane, x - 1, y + 1, 8192);
            }

            if (rotation == 1) {
               this.addMask(plane, x, y, 2048);
               this.addMask(plane, x + 1, 1 + y, 32768);
            }

            if (rotation == 2) {
               this.addMask(plane, x, y, 8192);
               this.addMask(plane, x + 1, y - 1, 512);
            }

            if (rotation == 3) {
               this.addMask(plane, x, y, 32768);
               this.addMask(plane, x - 1, -1 + y, 2048);
            }
         }

         if (type == 2) {
            if (rotation == 0) {
               this.addMask(plane, x, y, 66560);
               this.addMask(plane, -1 + x, y, 4096);
               this.addMask(plane, x, y + 1, 16384);
            }

            if (rotation == 1) {
               this.addMask(plane, x, y, 5120);
               this.addMask(plane, x, y + 1, 16384);
               this.addMask(plane, 1 + x, y, 65536);
            }

            if (rotation == 2) {
               this.addMask(plane, x, y, 20480);
               this.addMask(plane, x + 1, y, 65536);
               this.addMask(plane, x, y - 1, 1024);
            }

            if (rotation == 3) {
               this.addMask(plane, x, y, 81920);
               this.addMask(plane, x, -1 + y, 1024);
               this.addMask(plane, x - 1, y, 4096);
            }
         }
      }

      if (notAlternative) {
         if (type == 0) {
            if (rotation == 0) {
               this.addMask(plane, x, y, 536870912);
               this.addMask(plane, x - 1, y, 33554432);
            }

            if (rotation == 1) {
               this.addMask(plane, x, y, 8388608);
               this.addMask(plane, x, y + 1, 134217728);
            }

            if (rotation == 2) {
               this.addMask(plane, x, y, 33554432);
               this.addMask(plane, x + 1, y, 536870912);
            }

            if (rotation == 3) {
               this.addMask(plane, x, y, 134217728);
               this.addMask(plane, x, y - 1, 8388608);
            }
         }

         if (type == 1 || type == 3) {
            if (rotation == 0) {
               this.addMask(plane, x, y, 4194304);
               this.addMask(plane, x - 1, y + 1, 67108864);
            }

            if (rotation == 1) {
               this.addMask(plane, x, y, 16777216);
               this.addMask(plane, 1 + x, 1 + y, 268435456);
            }

            if (rotation == 2) {
               this.addMask(plane, x, y, 67108864);
               this.addMask(plane, x + 1, -1 + y, 4194304);
            }

            if (rotation == 3) {
               this.addMask(plane, x, y, 268435456);
               this.addMask(plane, -1 + x, y - 1, 16777216);
            }
         }

         if (type == 2) {
            if (rotation == 0) {
               this.addMask(plane, x, y, 545259520);
               this.addMask(plane, -1 + x, y, 33554432);
               this.addMask(plane, x, 1 + y, 134217728);
            }

            if (rotation == 1) {
               this.addMask(plane, x, y, 41943040);
               this.addMask(plane, x, 1 + y, 134217728);
               this.addMask(plane, x + 1, y, 536870912);
            }

            if (rotation == 2) {
               this.addMask(plane, x, y, 167772160);
               this.addMask(plane, 1 + x, y, 536870912);
               this.addMask(plane, x, y - 1, 8388608);
            }

            if (rotation == 3) {
               this.addMask(plane, x, y, 671088640);
               this.addMask(plane, x, y - 1, 8388608);
               this.addMask(plane, -1 + x, y, 33554432);
            }
         }
      }

   }

   public void removeWall(int plane, int x, int y, int type, int rotation, boolean solid, boolean notAlternative) {
      if (type == 0) {
         if (rotation == 0) {
            this.removeMask(plane, x, y, 128);
            this.removeMask(plane, x - 1, y, 8);
         }

         if (rotation == 1) {
            this.removeMask(plane, x, y, 2);
            this.removeMask(plane, x, 1 + y, 32);
         }

         if (rotation == 2) {
            this.removeMask(plane, x, y, 8);
            this.removeMask(plane, 1 + x, y, 128);
         }

         if (rotation == 3) {
            this.removeMask(plane, x, y, 32);
            this.removeMask(plane, x, -1 + y, 2);
         }
      }

      if (type == 1 || type == 3) {
         if (rotation == 0) {
            this.removeMask(plane, x, y, 1);
            this.removeMask(plane, -1 + x, 1 + y, 16);
         }

         if (rotation == 1) {
            this.removeMask(plane, x, y, 4);
            this.removeMask(plane, 1 + x, 1 + y, 64);
         }

         if (rotation == 2) {
            this.removeMask(plane, x, y, 16);
            this.removeMask(plane, x + 1, -1 + y, 1);
         }

         if (rotation == 3) {
            this.removeMask(plane, x, y, 64);
            this.removeMask(plane, x - 1, -1 + y, 4);
         }
      }

      if (type == 2) {
         if (rotation == 0) {
            this.addMask(plane, x, y, 130);
            this.removeMask(plane, -1 + x, y, 8);
            this.removeMask(plane, x, y + 1, 32);
         }

         if (rotation == 1) {
            this.removeMask(plane, x, y, 10);
            this.removeMask(plane, x, 1 + y, 32);
            this.removeMask(plane, 1 + x, y, 128);
         }

         if (rotation == 2) {
            this.removeMask(plane, x, y, 40);
            this.removeMask(plane, 1 + x, y, 128);
            this.removeMask(plane, x, -1 + y, 2);
         }

         if (rotation == 3) {
            this.removeMask(plane, x, y, 160);
            this.removeMask(plane, x, -1 + y, 2);
            this.removeMask(plane, -1 + x, y, 8);
         }
      }

      if (solid) {
         if (type == 0) {
            if (rotation == 0) {
               this.removeMask(plane, x, y, 65536);
               this.removeMask(plane, x - 1, y, 4096);
            }

            if (rotation == 1) {
               this.removeMask(plane, x, y, 1024);
               this.removeMask(plane, x, 1 + y, 16384);
            }

            if (rotation == 2) {
               this.removeMask(plane, x, y, 4096);
               this.removeMask(plane, x + 1, y, 65536);
            }

            if (rotation == 3) {
               this.removeMask(plane, x, y, 16384);
               this.removeMask(plane, x, -1 + y, 1024);
            }
         }

         if (type == 1 || type == 3) {
            if (rotation == 0) {
               this.removeMask(plane, x, y, 512);
               this.removeMask(plane, x - 1, y + 1, 8192);
            }

            if (rotation == 1) {
               this.removeMask(plane, x, y, 2048);
               this.removeMask(plane, x + 1, 1 + y, 32768);
            }

            if (rotation == 2) {
               this.removeMask(plane, x, y, 8192);
               this.removeMask(plane, x + 1, y - 1, 512);
            }

            if (rotation == 3) {
               this.removeMask(plane, x, y, 32768);
               this.removeMask(plane, x - 1, -1 + y, 2048);
            }
         }

         if (type == 2) {
            if (rotation == 0) {
               this.removeMask(plane, x, y, 66560);
               this.removeMask(plane, -1 + x, y, 4096);
               this.removeMask(plane, x, y + 1, 16384);
            }

            if (rotation == 1) {
               this.removeMask(plane, x, y, 5120);
               this.removeMask(plane, x, y + 1, 16384);
               this.removeMask(plane, 1 + x, y, 65536);
            }

            if (rotation == 2) {
               this.removeMask(plane, x, y, 20480);
               this.removeMask(plane, x + 1, y, 65536);
               this.removeMask(plane, x, y - 1, 1024);
            }

            if (rotation == 3) {
               this.removeMask(plane, x, y, 81920);
               this.removeMask(plane, x, -1 + y, 1024);
               this.removeMask(plane, x - 1, y, 4096);
            }
         }
      }

      if (notAlternative) {
         if (type == 0) {
            if (rotation == 0) {
               this.removeMask(plane, x, y, 536870912);
               this.removeMask(plane, x - 1, y, 33554432);
            }

            if (rotation == 1) {
               this.removeMask(plane, x, y, 8388608);
               this.removeMask(plane, x, y + 1, 134217728);
            }

            if (rotation == 2) {
               this.removeMask(plane, x, y, 33554432);
               this.removeMask(plane, x + 1, y, 536870912);
            }

            if (rotation == 3) {
               this.removeMask(plane, x, y, 134217728);
               this.removeMask(plane, x, y - 1, 8388608);
            }
         }

         if (type == 1 || type == 3) {
            if (rotation == 0) {
               this.removeMask(plane, x, y, 4194304);
               this.removeMask(plane, x - 1, y + 1, 67108864);
            }

            if (rotation == 1) {
               this.removeMask(plane, x, y, 16777216);
               this.removeMask(plane, 1 + x, 1 + y, 268435456);
            }

            if (rotation == 2) {
               this.removeMask(plane, x, y, 67108864);
               this.removeMask(plane, x + 1, -1 + y, 4194304);
            }

            if (rotation == 3) {
               this.removeMask(plane, x, y, 268435456);
               this.removeMask(plane, -1 + x, y - 1, 16777216);
            }
         }

         if (type == 2) {
            if (rotation == 0) {
               this.removeMask(plane, x, y, 545259520);
               this.removeMask(plane, -1 + x, y, 33554432);
               this.removeMask(plane, x, 1 + y, 134217728);
            }

            if (rotation == 1) {
               this.removeMask(plane, x, y, 41943040);
               this.removeMask(plane, x, 1 + y, 134217728);
               this.removeMask(plane, x + 1, y, 536870912);
            }

            if (rotation == 2) {
               this.removeMask(plane, x, y, 167772160);
               this.removeMask(plane, 1 + x, y, 536870912);
               this.removeMask(plane, x, y - 1, 8388608);
            }

            if (rotation == 3) {
               this.removeMask(plane, x, y, 671088640);
               this.removeMask(plane, x, y - 1, 8388608);
               this.removeMask(plane, -1 + x, y, 33554432);
            }
         }
      }

   }

   public void setMask(int plane, int x, int y, int mask) {
      if (x < 64 && y < 64 && x >= 0 && y >= 0) {
         this.masks[plane][x][y] = mask;
      } else {
         WorldTile tile = new WorldTile(this.regionX + x, this.regionY + y, plane);
         int regionId = tile.getRegionId();
         int newRegionX = (regionId >> 8) * 64;
         int newRegionY = (regionId & 255) * 64;
         if (this.clipedOnly) {
            World.getRegion(tile.getRegionId()).forceGetRegionMapClipedOnly().setMask(plane, tile.getX() - newRegionX, tile.getY() - newRegionY, mask);
         } else {
            World.getRegion(tile.getRegionId()).forceGetRegionMap().setMask(plane, tile.getX() - newRegionX, tile.getY() - newRegionY, mask);
         }

      }
   }

   public void addMask(int plane, int x, int y, int mask) {
      if (x < 64 && y < 64 && x >= 0 && y >= 0) {
         this.masks[plane][x][y] |= mask;
      } else {
         WorldTile tile = new WorldTile(this.regionX + x, this.regionY + y, plane);
         int regionId = tile.getRegionId();
         int newRegionX = (regionId >> 8) * 64;
         int newRegionY = (regionId & 255) * 64;
         if (this.clipedOnly) {
            World.getRegion(tile.getRegionId()).forceGetRegionMapClipedOnly().addMask(plane, tile.getX() - newRegionX, tile.getY() - newRegionY, mask);
         } else {
            World.getRegion(tile.getRegionId()).forceGetRegionMap().addMask(plane, tile.getX() - newRegionX, tile.getY() - newRegionY, mask);
         }

      }
   }

   public void removeMask(int plane, int x, int y, int mask) {
      if (x < 64 && y < 64 && x >= 0 && y >= 0) {
         int[] var10000 = this.masks[plane][x];
         var10000[y] &= ~mask;
      } else {
         WorldTile tile = new WorldTile(this.regionX + x, this.regionY + y, plane);
         int regionId = tile.getRegionId();
         int newRegionX = (regionId >> 8) * 64;
         int newRegionY = (regionId & 255) * 64;
         if (this.clipedOnly) {
            World.getRegion(tile.getRegionId()).forceGetRegionMapClipedOnly().removeMask(plane, tile.getX() - newRegionX, tile.getY() - newRegionY, mask);
         } else {
            World.getRegion(tile.getRegionId()).forceGetRegionMap().removeMask(plane, tile.getX() - newRegionX, tile.getY() - newRegionY, mask);
         }

      }
   }
}
