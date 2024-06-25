package org.rsmapper.utilities.misc;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class LimitedQueue<T> implements Queue<T>, Iterable<T> {
   private final int limit;
   private final LinkedList<T> list = new LinkedList();

   public LimitedQueue(int limit) {
      this.limit = limit;
   }

   private boolean trim() {
      boolean changed = this.list.size() > this.limit;

      while(this.list.size() > this.limit) {
         this.list.remove();
      }

      return changed;
   }

   public boolean add(T o) {
      boolean changed = this.list.add(o);
      boolean trimmed = this.trim();
      return changed || trimmed;
   }

   public int size() {
      return this.list.size();
   }

   public boolean isEmpty() {
      return this.list.isEmpty();
   }

   public boolean contains(Object o) {
      return this.list.contains(o);
   }

   public Iterator<T> iterator() {
      return this.list.iterator();
   }

   public Object[] toArray() {
      return this.list.toArray();
   }

   public <T> T[] toArray(T[] a) {
      return this.list.toArray(a);
   }

   public boolean remove(Object o) {
      return this.list.remove(o);
   }

   public boolean containsAll(Collection<?> c) {
      return this.list.containsAll(c);
   }

   public boolean addAll(Collection<? extends T> c) {
      boolean changed = this.list.addAll(c);
      boolean trimmed = this.trim();
      return changed || trimmed;
   }

   public boolean removeAll(Collection<?> c) {
      return this.list.removeAll(c);
   }

   public boolean retainAll(Collection<?> c) {
      return this.list.retainAll(c);
   }

   public void clear() {
      this.list.clear();
   }

   public boolean offer(T e) {
      boolean changed = this.list.offer(e);
      boolean trimmed = this.trim();
      return changed || trimmed;
   }

   public T remove() {
      return this.list.remove();
   }

   public T poll() {
      return this.list.poll();
   }

   public T element() {
      return this.list.element();
   }

   public T peek() {
      return this.list.peek();
   }
}
