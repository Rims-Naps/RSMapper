package org.rsmapper.api.database.configuration;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * ConfigurationNode represents a node in a configuration hierarchy.
 * Each node can have multiple children nodes or key-value pairs.
 */
public class ConfigurationNode {
   private Map<String, Object> children = new HashMap();

   /**
    * Sets a key-value pair in the node.
    *
    * @param key The key to set.
    * @param value The value to associate with the key.
    */
   public void set(String key, Object value) {
      this.children.put(key, value);
   }

   /**
    * Checks if the node contains the specified key.
    *
    * @param key The key to check.
    * @return true if the key exists, false otherwise.
    */
   public boolean has(String key) {
      return this.children.containsKey(key);
   }

   /**
    * Retrieves a child node associated with the given name.
    *
    * @param name The name of the child node.
    * @return The child ConfigurationNode or null if not found.
    * @throws ConfigurationException if the value associated with the name is not a ConfigurationNode.
    */
   public ConfigurationNode nodeFor(String name) {
      if (this.children.containsKey(name)) {
         Object value = this.children.get(name);
         if (value.getClass() != this.getClass()) {
            throw new ConfigurationException("Invalid node " + name + "!");
         } else {
            return (ConfigurationNode)value;
         }
      } else {
         return null;
      }
   }

   /**
    * Lists all children of this node in a string representation.
    *
    * @return A string representation of all children.
    */
   public String listChildren() {
      StringBuilder builder = new StringBuilder();
      builder.append("[");

      for(Iterator var3 = this.children.entrySet().iterator(); var3.hasNext(); builder.append(", ")) {
         Entry<String, Object> entry = (Entry)var3.next();
         builder.append((String)entry.getKey()).append(" => ");
         if (entry.getValue() instanceof ConfigurationNode) {
            builder.append(((ConfigurationNode)entry.getValue()).listChildren());
         } else {
            builder.append(entry.getValue());
         }
      }

      if (builder.length() > 2) {
         builder.deleteCharAt(builder.length() - 1);
         builder.deleteCharAt(builder.length() - 1);
      }

      builder.append("]");
      return builder.toString();
   }

   /**
    * Retrieves the value associated with a given key.
    *
    * @param key The key to lookup.
    * @return The associated value or null if the key does not exist.
    */
   public Object get(String key) {
      return this.children.get(key);
   }

   /**
    * Retrieves the string value associated with a given key.
    *
    * @param string The key to lookup.
    * @return The associated string value or "null" if not a string.
    */
   public String getString(String string) {
      Object value = this.get(string);
      return value instanceof String ? (String)value : "null";
   }

   /**
    * Retrieves the integer value associated with a given key.
    *
    * @param key The key to lookup.
    * @return The associated integer value.
    */
   public int getInteger(String key) {
      return Integer.parseInt(this.getString(key));
   }

   /**
    * Retrieves the boolean value associated with a given key.
    *
    * @param key The key to lookup.
    * @return The associated boolean value.
    */
   public boolean getBoolean(String key) {
      return Boolean.parseBoolean(this.getString(key));
   }

   /**
    * Retrieves all children of this node.
    *
    * @return A map of all children.
    */
   public Map<String, Object> getChildren() {
      return this.children;
   }
}