package org.rsmapper.game;

import java.util.AbstractCollection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class EntityList<T extends Entity> extends AbstractCollection<T> {
   private static final int MIN_VALUE = 1;
   private final Object[] entities;
   private final Set<Integer> indicies = new HashSet();
   private volatile int curIndex = 1;
   private final int capacity;
   private final Object lock = new Object();

   public EntityList(int capacity) {
      this.entities = new Object[capacity];
      this.capacity = capacity;
   }

   public boolean add(T entity) {
      synchronized(this.lock) {
         this.add(entity, this.curIndex);
         return true;
      }
   }

   public void remove(T entity) {
      synchronized(this.lock) {
         this.entities[entity.getIndex()] = null;
         this.indicies.remove(entity.getIndex());
         this.decreaseIndex();
      }
   }

   public T remove(int index) {
      synchronized(this.lock) {
         Object temp = this.entities[index];
         this.entities[index] = null;
         this.indicies.remove(index);
         this.decreaseIndex();
         return (Entity)temp;
      }
   }

   public T get(int index) {
      synchronized(this.lock) {
         return index >= this.entities.length ? null : (Entity)this.entities[index];
      }
   }

   public void add(T entity, int index) {
      if (this.entities[this.curIndex] != null) {
         this.increaseIndex();
         this.add(entity, this.curIndex);
      } else {
         this.entities[this.curIndex] = entity;
         entity.setIndex(index);
         this.indicies.add(this.curIndex);
         this.increaseIndex();
      }

   }

   public Iterator<T> iterator() {
      synchronized(this.lock) {
         return new EntityListIterator(this.entities, this.indicies, this);
      }
   }

   public void increaseIndex() {
      ++this.curIndex;
      if (this.curIndex >= this.capacity) {
         this.curIndex = 1;
      }

   }

   public void decreaseIndex() {
      --this.curIndex;
      if (this.curIndex <= this.capacity) {
         this.curIndex = 1;
      }

   }

   public boolean contains(T entity) {
      return this.indexOf(entity) > -1;
   }

   public int indexOf(T entity) {
      Iterator var3 = this.indicies.iterator();

      while(var3.hasNext()) {
         int index = (Integer)var3.next();
         if (this.entities[index].equals(entity)) {
            return index;
         }
      }

      return -1;
   }

   public int size() {
      return this.indicies.size();
   }
}
