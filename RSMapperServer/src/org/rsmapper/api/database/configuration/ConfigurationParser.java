package org.rsmapper.api.database.configuration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConfigurationParser {
   private final Pattern scalarPattern = Pattern.compile("\\s*(.*?)\\s*\"((?:\\\"|[^\"])+?)\"\\s*(?:\\#.*)?$");
   private final Pattern arrayPattern = Pattern.compile("\\s*(.*?)\\s*\\s*\\{\\s*(?:\\#.*)?$");
   private final Pattern nestedArrayPattern = Pattern.compile("\\s*(.*?)\\s*\"((?:\\\"|[^\"])+?)\"\\s*\\(\\s*(?:\\#.*)?$");
   private final Pattern nestedHashPattern = Pattern.compile("\\s*(.*?)\\s*\"((?:\\\\\"|[^\"])+?)\"\\s*\\{\\s*(?:\\#.*)?$");
   private final Pattern nestedEndPattern = Pattern.compile("^\\s*(}|\\))\\s*");
   private BufferedReader reader;

   public ConfigurationParser(InputStream input) {
      this.reader = new BufferedReader(new InputStreamReader(input));
   }

   public ConfigurationNode parse() throws IOException {
      ConfigurationNode node = new ConfigurationNode();

      try {
         this.parse(node);
      } finally {
         this.reader.close();
      }

      return node;
   }

   public void parse(ConfigurationNode node) throws IOException {
      String line = this.reader.readLine();
      if (line != null) {
         line = line.trim();
         if (!line.startsWith("#") && line.length() != 0) {
            Matcher scalar = this.scalarPattern.matcher(line);
            Matcher array = this.arrayPattern.matcher(line);
            Matcher nestedArrayBlock = this.nestedArrayPattern.matcher(line);
            Matcher nestedHashBlock = this.nestedHashPattern.matcher(line);
            if (scalar.find()) {
               node.set(scalar.group(1), scalar.group(2));
            } else {
               String name;
               String key;
               if (nestedArrayBlock.find()) {
                  name = nestedArrayBlock.group(1);
                  key = nestedArrayBlock.group(2);
                  key = key.replaceAll("\\\"", "\"");
                  if (!node.has(name)) {
                     node.set(name, new ConfigurationNode());
                  }

                  this.parse(node.nodeFor(name));
               } else if (nestedHashBlock.find()) {
                  name = nestedHashBlock.group(1);
                  key = nestedHashBlock.group(2);
                  ConfigurationNode sub = node.has(name) ? node.nodeFor(name) : new ConfigurationNode();
                  if (!node.has(name)) {
                     node.set(name, sub);
                  }

                  if (!sub.has(key)) {
                     sub.set(key, new ConfigurationNode());
                  }

                  this.parse(sub.nodeFor(key));
               } else if (array.find()) {
                  ConfigurationNode newNode = new ConfigurationNode();
                  node.set(array.group(1), newNode);
                  this.parse(newNode);
               }
            }

            Matcher nestedEnd = this.nestedEndPattern.matcher(line);
            if (nestedEnd.find()) {
               return;
            }
         }

         this.parse(node);
      }
   }
}
