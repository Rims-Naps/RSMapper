package org.eclipse.wb.swing;

import java.awt.Component;
import java.awt.Container;
import java.awt.FocusTraversalPolicy;

public class FocusTraversalOnArray extends FocusTraversalPolicy {
   private final Component[] m_Components;

   public FocusTraversalOnArray(Component[] components) {
      this.m_Components = components;
   }

   private int indexCycle(int index, int delta) {
      int size = this.m_Components.length;
      return (index + delta + size) % size;
   }

   private Component cycle(Component currentComponent, int delta) {
      int index = -1;

      label37:
      for(int i = 0; i < this.m_Components.length; ++i) {
         Component component = this.m_Components[i];

         for(Component c = currentComponent; c != null; c = c.getParent()) {
            if (component == c) {
               index = i;
               break label37;
            }
         }
      }

      int initialIndex = index;

      Component component;
      do {
         int newIndex = this.indexCycle(index, delta);
         if (newIndex == initialIndex) {
            return currentComponent;
         }

         index = newIndex;
         component = this.m_Components[newIndex];
      } while(!component.isEnabled() || !component.isVisible() || !component.isFocusable());

      return component;
   }

   @Override
   public Component getComponentAfter(Container container, Component component) {
      return this.cycle(component, 1);
   }

   @Override
   public Component getComponentBefore(Container container, Component component) {
      return this.cycle(component, -1);
   }

   @Override
   public Component getFirstComponent(Container container) {
      return this.m_Components[0];
   }

   @Override
   public Component getLastComponent(Container container) {
      return this.m_Components[this.m_Components.length - 1];
   }

   @Override
   public Component getDefaultComponent(Container container) {
      return this.getFirstComponent(container);
   }
}
