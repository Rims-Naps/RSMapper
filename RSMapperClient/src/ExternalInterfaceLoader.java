import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ExternalInterfaceLoader {
   public static final String DIRECTORY = "resources/interfaces/";
   public static ArrayList<ExternalInterface> interfaces = new ArrayList<>();

   public static boolean loadInterfaces() {
      File folder = new File("resources/interfaces/");
      File[] interfaceFiles = folder.listFiles();
      int numInterfaces = interfaceFiles.length;

      for(int inter = 0; inter < numInterfaces; ++inter) {
         int interfaceId = -1;

         for(int i = 0; i < Class169_Sub1.aBooleanArray8788.length; ++i) {
            if (!Class169_Sub1.aBooleanArray8788[i]) {
               interfaceId = i;
               break;
            }
         }

         if (interfaceId == -1) {
            System.out.println("No available interfaceIds");
            return false;
         }

         File[] componentFiles = interfaceFiles[inter].listFiles();
         int numComponents = componentFiles.length;
         if (numComponents == 0) {
            Class169_Sub1.aBooleanArray8788[interfaceId] = true;
            return true;
         }

         Class134_Sub3.aWidgetArrayArray9035[interfaceId] = new IComponentDefinitions[numComponents];

         for(int component = 0; component < numComponents; ++component) {
            if (Class134_Sub3.aWidgetArrayArray9035[interfaceId][component] == null) {
               byte[] bs = getComponentData(componentFiles[component]);
               if (bs != null) {
                  IComponentDefinitions widget = Class134_Sub3.aWidgetArrayArray9035[interfaceId][component] = new IComponentDefinitions();
                  widget.ihash = component + (interfaceId << 16);
                  if (bs[0] != -1) {
                     throw new IllegalStateException("if1");
                  }

                  widget.decode(new Buffer(bs));
                  if (widget.parentId != -1) {
                     widget.parentId = widget.ihash - 1 + (widget.ihash & -65536);
                  }
               }
            }
         }

         Class169_Sub1.aBooleanArray8788[interfaceId] = true;
         interfaces.add(new ExternalInterface(interfaceFiles[inter].getName().split("\\.")[0].trim(), interfaceId));
      }

      return true;
   }

   public static boolean reloadInterface(String name) {
      int id = -1;
      Iterator<ExternalInterface> it$ = interfaces.iterator();

      while(it$.hasNext()) {
         ExternalInterface inter = it$.next();
         if (inter.name.equals(name)) {
            id = inter.id;
            it$.remove();
            break;
         }
      }

      if (id == -1) {
         return false;
      } else {
         Class134_Sub3.aWidgetArrayArray9035[id] = null;
         Class169_Sub1.aBooleanArray8788[id] = false;
         int newInterfaceId = -1;

         for(int i = 0; i < Class169_Sub1.aBooleanArray8788.length; ++i) {
            if (!Class169_Sub1.aBooleanArray8788[i]) {
               newInterfaceId = i;
               break;
            }
         }

         if (newInterfaceId == -1) {
            System.out.println("No available interfaceIds");
            return false;
         } else {
            File folder = new File("resources/interfaces/");
            File[] interfaceFiles = folder.listFiles();
            int numInterfaces = interfaceFiles.length;

            for(int inter = 0; inter < numInterfaces; ++inter) {
               if (interfaceFiles[inter].getName().equals(name)) {
                  File[] componentFiles = interfaceFiles[inter].listFiles();
                  int numComponents = componentFiles.length;
                  if (numComponents == 0) {
                     Class169_Sub1.aBooleanArray8788[newInterfaceId] = true;
                     return true;
                  }

                  Class134_Sub3.aWidgetArrayArray9035[newInterfaceId] = new IComponentDefinitions[numComponents];

                  for(int component = 0; component < numComponents; ++component) {
                     if (Class134_Sub3.aWidgetArrayArray9035[newInterfaceId][component] == null) {
                        byte[] bs = getComponentData(componentFiles[component]);
                        if (bs != null) {
                           IComponentDefinitions widget = Class134_Sub3.aWidgetArrayArray9035[newInterfaceId][component] = new IComponentDefinitions();
                           widget.ihash = component + (newInterfaceId << 16);
                           if (bs[0] != -1) {
                              throw new IllegalStateException("if1");
                           }

                           widget.decode(new Buffer(bs));
                           if (widget.parentId != -1) {
                              widget.parentId = widget.ihash - 1 + (widget.ihash & -65536);
                           }
                        }
                     }
                  }

                  Class169_Sub1.aBooleanArray8788[newInterfaceId] = true;
                  interfaces.add(new ExternalInterface(interfaceFiles[inter].getName().split("\\.")[0].trim(), newInterfaceId));
               }
            }

            return true;
         }
      }
   }

   public static int getInterfaceId(String name) {
      int interfaceId = -1;

      for(ExternalInterface inter : interfaces) {
         if (inter.name.equalsIgnoreCase(name)) {
            interfaceId = inter.id;
            break;
         }
      }

      return interfaceId;
   }

   public static String getInterfaceName(int id) {
      String name = null;

      for(ExternalInterface inter : interfaces) {
         if (inter.id == id) {
            name = inter.name;
            break;
         }
      }

      return name;
   }

   public static void openInterface(String name, int type) {
      if (!RSMapperClient.INTERFACES_LOADED) {
         loadInterfaces();
         RSMapperClient.INTERFACES_LOADED = true;
      }

      int interfaceId = getInterfaceId(name);
      if (interfaceId != -1) {
         openInterface(interfaceId, type);
      }
   }

   public static void openInterface(int interfaceId, int type) {
      if (!RSMapperClient.INTERFACES_LOADED) {
         loadInterfaces();
         RSMapperClient.INTERFACES_LOADED = true;
      }

      Node_Sub2 node_sub2 = new Node_Sub2();
      node_sub2.interfaceId = interfaceId;
      node_sub2.cliped = 3;
      Class93.method1047(type, interfaceId, 48889865, 0, false, true);
   }

   public static void closeInterface(String name) {
      if (!RSMapperClient.INTERFACES_LOADED) {
         loadInterfaces();
         RSMapperClient.INTERFACES_LOADED = true;
      }

      int interfaceId = getInterfaceId(name);
      if (interfaceId != -1) {
         if (name.equalsIgnoreCase("ModelViewer")) {
            RSMapperClient.editor.objectEditor.VIEWER_OPEN = false;
            RSMapperClient.editor.objectEditor.viewingObject = -1;
            Class24.aClass275_442.CONFIG_VALUES[2103] = 0;
         }

         reloadInterface(name);
      }
   }

   public static byte[] getComponentData(File interfaceFile) {
      File file = new File(interfaceFile.toString());
      byte[] bytesArray = new byte[(int)file.length()];

      try {
         FileInputStream fis = new FileInputStream(file);
         fis.read(bytesArray);
         fis.close();
      } catch (IOException var5) {
         var5.printStackTrace();
      }

      return bytesArray;
   }
}
