package com.alex.loaders.interfaces;

import com.alex.io.InputStream;
import com.alex.store.Store;
import com.alex.utils.Utils;
import java.awt.Component;
import java.awt.Image;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.ReplicateScaleFilter;
import java.io.IOException;
import javax.swing.JComponent;

public class Interface {
   public int id;
   public Store cache;
   public IComponent[] components;
   public JComponent[] jcomponents;

   public static void main(String[] args) throws IOException {
   }

   public Interface(int id, Store cache) {
      this(id, cache, true);
   }

   public Interface(int id, Store cache, boolean load) {
      this.id = id;
      this.cache = cache;
      if (load) {
         this.getComponents();
      }

   }

   public void draw(JComponent parent) {
   }

   public Image resizeImage(Image image, int width, int height, Component c) {
      ImageFilter replicate = new ReplicateScaleFilter(width, height);
      ImageProducer prod = new FilteredImageSource(image.getSource(), replicate);
      return c.createImage(prod);
   }

   public void getComponents() {
      if (Utils.getInterfaceDefinitionsSize(this.cache) <= this.id) {
         throw new RuntimeException("Invalid interface id.");
      } else {
         this.components = new IComponent[Utils.getInterfaceDefinitionsComponentsSize(this.cache, this.id)];

         for(int componentId = 0; componentId < this.components.length; ++componentId) {
            this.components[componentId] = new IComponent();
            this.components[componentId].hash = this.id << 16 | componentId;
            byte[] data = this.cache.getIndexes()[3].getFile(this.id, componentId);
            if (data == null) {
               throw new RuntimeException("Interface " + this.id + ", component " + componentId + " data is null.");
            }

            if (data[0] != -1) {
               this.components[componentId].decodeNoscriptsFormat(new InputStream(data));
            } else {
               this.components[componentId].decodeScriptsFormat(new InputStream(data));
            }
         }

      }
   }
}
