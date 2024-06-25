package org.rsmapper.game;

import java.util.Iterator;
import java.util.Set;

public class EntityListIterator<E extends Entity> implements Iterator<E> {
   private Integer[] indicies;
   private Object[] entities;
   private EntityList entityList;
   private int curIndex = 0;

   public EntityListIterator(Object[] entities, Set<Integer> indicies, EntityList entityList) {
      this.entities = entities;
      this.indicies = (Integer[])indicies.toArray(new Integer[indicies.size()]);
      this.entityList = entityList;
   }

   public boolean hasNext() {
      return this.indicies.length != this.curIndex;
   }

   public E next() {
      Object temp = this.entities[this.indicies[this.curIndex]];
      ++this.curIndex;
      return (Entity)temp;
   }

   public void remove() {
      if (this.curIndex >= 1) {
         this.entityList.remove(this.indicies[this.curIndex - 1]);
      }

   }
}
