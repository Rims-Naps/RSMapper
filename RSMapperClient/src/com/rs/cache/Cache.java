package com.rs.cache;

import com.alex.io.OutputStream;
import com.alex.store.Store;
import com.alex.util.whirlpool.Whirlpool;
import com.alex.utils.Utils;
import java.io.IOException;
import java.math.BigInteger;

public final class Cache {
   public static Store STORE;

   private Cache() {
   }

   public static void init() throws IOException {
      STORE = new Store("data/cache/");
   }

   public static byte[] generateUkeysFile() {
      OutputStream stream = new OutputStream();
      stream.writeByte(STORE.getIndexes().length);

      for(int index = 0; index < STORE.getIndexes().length; ++index) {
         if (STORE.getIndexes()[index] == null) {
            stream.writeInt(0);
            stream.writeInt(0);
            stream.writeBytes(new byte[64]);
         } else {
            stream.writeInt(STORE.getIndexes()[index].getCRC());
            stream.writeInt(STORE.getIndexes()[index].getTable().getRevision());
            stream.writeBytes(STORE.getIndexes()[index].getWhirlpool());
         }
      }

      byte[] archive = new byte[stream.getOffset()];
      stream.setOffset(0);
      stream.getBytes(archive, 0, archive.length);
      OutputStream hashStream = new OutputStream(65);
      hashStream.writeByte(0);
      hashStream.writeBytes(Whirlpool.getHash(archive, 0, archive.length));
      byte[] hash = new byte[hashStream.getOffset()];
      hashStream.setOffset(0);
      hashStream.getBytes(hash, 0, hash.length);
        hash = Utils.cryptRSA(
         hash,
         new BigInteger(
            "95776340111155337321344029627634178888626101791582245228586750697996713454019354716577077577558156976177994479837760989691356438974879647293064177555518187567327659793331431421153203931914933858526857396428052266926507860603166705084302845740310178306001400777670591958466653637275131498866778592148380588481"
         ),
         new BigInteger(
            "119555331260995530494627322191654816613155476612603817103079689925995402263457895890829148093414135342420807287820032417458428763496565605970163936696811485500553506743979521465489801746973392901885588777462023165252483988431877411021816445058706597607453280166045122971960003629860919338852061972113876035333"
         )
      );
      stream.writeBytes(hash);
      archive = new byte[stream.getOffset()];
      stream.setOffset(0);
      stream.getBytes(archive, 0, archive.length);
      return archive;
   }

   public static Store getStore() {
      return STORE;
   }
}
