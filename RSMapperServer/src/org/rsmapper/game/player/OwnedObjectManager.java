package org.rsmapper.game.player;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.rsmapper.game.World;
import org.rsmapper.game.WorldObject;
import org.rsmapper.game.tasks.WorldTask;
import org.rsmapper.game.tasks.WorldTasksManager;
import org.rsmapper.utilities.misc.Utils;

public class OwnedObjectManager {
   public static final AtomicLong keyMaker = new AtomicLong();
   private static final Map<String, OwnedObjectManager> ownedObjects = new ConcurrentHashMap();
   private Player player;
   private WorldObject[] objects;
   private int count;
   private long[] cycleTimes;
   private long lifeTime;
   private String managerKey;
   private OwnedObjectManager.ProcessEvent event;

   public static void processAll() {
      Iterator var1 = ownedObjects.values().iterator();

      while(var1.hasNext()) {
         OwnedObjectManager object = (OwnedObjectManager)var1.next();
         object.process();
      }

   }

   public static boolean isPlayerObject(Player player, WorldObject object) {
      Iterator it = player.getOwnedObjectManagerKeys().iterator();

      while(it.hasNext()) {
         OwnedObjectManager manager = (OwnedObjectManager)ownedObjects.get(it.next());
         if (manager == null) {
            it.remove();
         } else if (manager.getCurrentObject().getX() == object.getX() && manager.getCurrentObject().getY() == object.getY() && manager.getCurrentObject().getPlane() == object.getPlane() && manager.getCurrentObject().getId() == object.getId()) {
            return true;
         }
      }

      return false;
   }

   public static Player getOwner(WorldObject object) {
      Player owner = null;
      Iterator var3 = World.getPlayers().iterator();

      while(var3.hasNext()) {
         Player p = (Player)var3.next();
         if (isPlayerObject(p, object)) {
            owner = p;
         }
      }

      return owner;
   }

   public static boolean convertIntoObject(WorldObject object, WorldObject toObject, OwnedObjectManager.ConvertEvent event) {
      Iterator var4 = ownedObjects.values().iterator();

      OwnedObjectManager manager;
      do {
         if (!var4.hasNext()) {
            return false;
         }

         manager = (OwnedObjectManager)var4.next();
      } while(manager.getCurrentObject().getX() != toObject.getX() || manager.getCurrentObject().getY() != toObject.getY() || manager.getCurrentObject().getPlane() != toObject.getPlane() || manager.getCurrentObject().getId() != object.getId());

      if (event != null && !event.canConvert(manager.player)) {
         return false;
      } else {
         manager.convertIntoObject(toObject);
         return true;
      }
   }

   public static boolean removeObject(Player player, WorldObject object) {
      Iterator it = player.getOwnedObjectManagerKeys().iterator();

      while(it.hasNext()) {
         final OwnedObjectManager manager = (OwnedObjectManager)ownedObjects.get(it.next());
         if (manager == null) {
            it.remove();
         } else if (manager.getCurrentObject().getX() == object.getX() && manager.getCurrentObject().getY() == object.getY() && manager.getCurrentObject().getPlane() == object.getPlane() && manager.getCurrentObject().getId() == object.getId()) {
            WorldTasksManager.schedule(new WorldTask() {
               public void run() {
                  manager.delete();
               }
            });
            return true;
         }
      }

      return false;
   }

   public static void linkKeys(Player player) {
      Iterator it = player.getOwnedObjectManagerKeys().iterator();

      while(it.hasNext()) {
         OwnedObjectManager manager = (OwnedObjectManager)ownedObjects.get(it.next());
         if (manager == null) {
            it.remove();
         } else {
            manager.player = player;
         }
      }

   }

   public static void addOwnedObjectManager(Player player, WorldObject object, long cycleTime) {
      addOwnedObjectManager(player, new WorldObject[]{object}, new long[]{cycleTime});
   }

   public static void addOwnedObjectManager(Player player, WorldObject[] object, long[] cycleTimes) {
      addOwnedObjectManager(player, object, cycleTimes, (OwnedObjectManager.ProcessEvent)null);
   }

   public static void addOwnedObjectManager(Player player, WorldObject[] object, long[] cycleTimes, OwnedObjectManager.ProcessEvent event) {
      new OwnedObjectManager(player, object, cycleTimes, event);
   }

   private OwnedObjectManager(Player player, WorldObject[] objects, long[] cycleTimes, OwnedObjectManager.ProcessEvent event) {
      this.managerKey = player.getUsername() + "_" + keyMaker.getAndIncrement();
      this.cycleTimes = cycleTimes;
      this.objects = objects;
      this.player = player;
      this.event = event;
      this.spawnObject();
      player.getOwnedObjectManagerKeys().add(this.managerKey);
      ownedObjects.put(this.managerKey, this);
   }

   public static int getObjectsforValue(Player player, int objectId) {
      int count = 0;
      Iterator it = player.getOwnedObjectManagerKeys().iterator();

      while(it.hasNext()) {
         OwnedObjectManager manager = (OwnedObjectManager)ownedObjects.get(it.next());
         if (manager == null) {
            it.remove();
         } else if (manager.getCurrentObject().getId() == objectId) {
            ++count;
         }
      }

      return count;
   }

   public static boolean containsObjectValue(Player player, int... objectIds) {
      Iterator it = player.getOwnedObjectManagerKeys().iterator();

      while(true) {
         while(it.hasNext()) {
            OwnedObjectManager manager = (OwnedObjectManager)ownedObjects.get(it.next());
            if (manager == null) {
               it.remove();
            } else {
               int[] var7 = objectIds;
               int var6 = objectIds.length;

               for(int var5 = 0; var5 < var6; ++var5) {
                  int objectId = var7[var5];
                  if (manager.getCurrentObject().getId() == objectId) {
                     return true;
                  }
               }
            }
         }

         return false;
      }
   }

   public void reset() {
      Iterator var2 = ownedObjects.values().iterator();

      while(var2.hasNext()) {
         OwnedObjectManager object = (OwnedObjectManager)var2.next();
         object.delete();
      }

   }

   public void resetLifeTime() {
      this.lifeTime = Utils.currentTimeMillis() + this.cycleTimes[this.count];
   }

   public boolean forceMoveNextStage() {
      if (this.count != -1) {
         this.destroyObject(this.objects[this.count]);
      }

      ++this.count;
      if (this.count == this.objects.length) {
         this.remove();
         return false;
      } else {
         this.spawnObject();
         return true;
      }
   }

   private void spawnObject() {
      World.spawnObject(this.objects[this.count]);
      if (this.event != null) {
         this.event.spawnObject(this.player, this.getCurrentObject());
      }

      this.resetLifeTime();
   }

   public void convertIntoObject(WorldObject object) {
      this.destroyObject(this.objects[this.count]);
      this.objects[this.count] = object;
      this.spawnObject();
   }

   private void remove() {
      ownedObjects.remove(this.managerKey);
      if (this.player != null) {
         this.player.getOwnedObjectManagerKeys().remove(this.managerKey);
      }

   }

   public void delete() {
      this.destroyObject(this.objects[this.count]);
      this.remove();
   }

   public void process() {
      boolean infinite = this.getCurrentObject().getDefinitions().name.equals("Dwarf multicannon");
      if (!infinite && Utils.currentTimeMillis() > this.lifeTime) {
         this.forceMoveNextStage();
      } else if (this.event != null) {
         this.event.process(this.player, this.getCurrentObject());
      }

   }

   public WorldObject getCurrentObject() {
      return this.objects[this.count];
   }

   public void destroyObject(WorldObject object) {
      World.removeObject(object);
   }

   public interface ConvertEvent {
      boolean canConvert(Player var1);
   }

   public interface ProcessEvent {
      void spawnObject(Player var1, WorldObject var2);

      void process(Player var1, WorldObject var2);
   }
}
