import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.Proxy.Type;
import java.nio.charset.Charset;
import java.util.List;

public class Class41_Sub2 extends Class41 {
   private ProxySelector aProxySelector5548 = ProxySelector.getDefault();
   static Class aClass5549;
   static Class aClass5550;

   /**
    * Method to create a socket connection via a Proxy
    * @param b a byte parameter
    * @param proxy the Proxy to use for the connection
    * @return an established Socket or null if unable to connect
    * @throws IOException if an I/O error occurs
    */
   private final Socket method438(byte b, Proxy proxy) throws IOException {
      if (proxy.type() == Type.DIRECT) {
         return this.method434(false);
      } else {
         SocketAddress socketaddress = proxy.address();
         if (!(socketaddress instanceof InetSocketAddress)) {
            return null;
         } else {
            if (b != -68) {
               this.aProxySelector5548 = null;
            }

            InetSocketAddress inetsocketaddress = (InetSocketAddress)socketaddress;
            if (proxy.type() == Type.HTTP) {
               String string = null;

               try {
                  Class var_class = Class.forName("sun.net.www.protocol.http.AuthenticationInfo");
                  Method method = var_class.getDeclaredMethod(
                     "getProxyAuth", aClass5549 == null ? (aClass5549 = method440("java.lang.String")) : aClass5549, Integer.TYPE
                  );
                  method.setAccessible(true);
                  Object object = method.invoke(null, inetsocketaddress.getHostName(), new Integer(inetsocketaddress.getPort()));
                  if (object != null) {
                     Method method_0_ = var_class.getDeclaredMethod("supportsPreemptiveAuthorization");
                     method_0_.setAccessible(true);
                     if (method_0_.invoke(object) != null) {
                        Method method_1_ = var_class.getDeclaredMethod("getHeaderName");
                        method_1_.setAccessible(true);
                        Method method_2_ = var_class.getDeclaredMethod(
                           "getHeaderValue",
                           aClass5550 == null ? (aClass5550 = method440("java.net.URL")) : aClass5550,
                           aClass5549 == null ? (aClass5549 = method440("java.lang.String")) : aClass5549
                        );
                        method_2_.setAccessible(true);
                        String string_3_ = (String)method_1_.invoke(object);
                        String string_4_ = (String)method_2_.invoke(object, new URL("https://" + this.aString625 + "/"), "https");
                        string = string_3_ + ": " + string_4_;
                     }
                  }
               } catch (Exception var14) {
               }

               return this.method439(inetsocketaddress.getHostName(), inetsocketaddress.getPort(), string);
            } else if (proxy.type() == Type.SOCKS) {
               Socket socket = new Socket(proxy);
               socket.connect(new InetSocketAddress(this.aString625, this.anInt624));
               return socket;
            } else {
               return null;
            }
         }
      }
   }

   /**
    * Method to establish an HTTP tunnel connection
    * @param string the host to connect to
    * @param i the port to connect to
    * @param string_5_ the proxy authorization header value
    * @return an established Socket or null if unable to connect
    * @throws IOException if an I/O error occurs
    */
   private final Socket method439(String string, int i, String string_5_) throws IOException {
      Socket socket = new Socket(string, i);
      socket.setSoTimeout(10000);
      OutputStream outputstream = socket.getOutputStream();
      if (string_5_ == null) {
         outputstream.write(("CONNECT " + this.aString625 + ":" + this.anInt624 + " HTTP/1.0\n\n").getBytes(Charset.forName("ISO-8859-1")));
      } else {
         outputstream.write(("CONNECT " + this.aString625 + ":" + this.anInt624 + " HTTP/1.0\n" + string_5_ + "\n\n").getBytes(Charset.forName("ISO-8859-1")));
      }

      outputstream.flush();
      BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      String string_6_ = bufferedreader.readLine();
      if (string_6_ != null) {
         if (string_6_.startsWith("HTTP/1.0 200") || string_6_.startsWith("HTTP/1.1 200")) {
            return socket;
         }

         if (string_6_.startsWith("HTTP/1.0 407") || string_6_.startsWith("HTTP/1.1 407")) {
            int i_7_ = 0;
            String string_8_ = "proxy-authenticate: ";

            for(string_6_ = bufferedreader.readLine(); string_6_ != null && ~i_7_ > -51; string_6_ = bufferedreader.readLine()) {
               if (string_6_.toLowerCase().startsWith(string_8_)) {
                  string_6_ = string_6_.substring(string_8_.length()).trim();
                  int i_9_ = string_6_.indexOf(32);
                  if (-1 != i_9_) {
                     string_6_ = string_6_.substring(0, i_9_);
                  }

                  throw new IOException_Sub1(string_6_);
               }

               ++i_7_;
            }

            throw new IOException_Sub1("");
         }
      }

      outputstream.close();
      bufferedreader.close();
      socket.close();
      return null;
   }

   /**
    * Method to establish a socket connection using system proxies
    * @param i an integer parameter
    * @return an established Socket or null if unable to connect
    * @throws IOException if an I/O error occurs
    */
   @Override
   final Socket method435(int i) throws IOException {
      boolean bool = Boolean.parseBoolean(System.getProperty("java.net.useSystemProxies"));
      if (!bool) {
         System.setProperty("java.net.useSystemProxies", "true");
      }

      boolean bool_10_ = RSMapperClient.PORT_ID == this.anInt624;

      List list;
      List list_11_;
      try {
         list = this.aProxySelector5548.select(new URI((bool_10_ ? "https" : "http") + "://" + this.aString625));
         list_11_ = this.aProxySelector5548.select(new URI((!bool_10_ ? "https" : "http") + "://" + this.aString625));
         if (i != 30749) {
            this.aProxySelector5548 = null;
         }
      } catch (URISyntaxException var16) {
         return this.method434(false);
      }

      list.addAll(list_11_);
      Object[] objects = list.toArray();
      IOException_Sub1 ioexception_sub1 = null;
      Object[] objects_12_ = objects;

      for(int i_13_ = 0; ~i_13_ > ~objects_12_.length; ++i_13_) {
         Object object = objects_12_[i_13_];
         Proxy proxy = (Proxy)object;

         try {
            Socket socket_14_ = this.method438((byte)-68, proxy);
            if (socket_14_ != null) {
               return socket_14_;
            }
         } catch (IOException_Sub1 var14) {
            ioexception_sub1 = var14;
         } catch (IOException var15) {
         }
      }

      if (ioexception_sub1 != null) {
         throw ioexception_sub1;
      } else {
         return this.method434(false);
      }
   }

   /**
    * Method to find and return a Class object for a given class name
    * @param string the name of the class
    * @return the Class object representing the class
    */
   static Class method440(String string) {
      try {
         return Class.forName(string);
      } catch (ClassNotFoundException var3) {
         throw (NoClassDefFoundError)new NoClassDefFoundError().initCause(var3);
      }
   }
}