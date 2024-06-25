import java.math.BigInteger;

public class Constants {
   public static final String NAME = "Map Editor";
   public static final String EXTERNAL_CACHE = "Unparagoned Development & Community";
   public static final int REVISION = 666;
   public static final String BUILD = "Build: 666";
    public static final int DEV_CONSOLE_COLOR = 0xFF0000;
   public static final int MAX_ITEMS = 22271;
   public static String IP = "127.0.0.1";
   public static final BigInteger RSA_MODULUS = new BigInteger(
      "103796687640257172207121816391165173124364144775082945335924738058396873518053520539510657401174019219890243473647721281492498576497388645334133965759916085786123878963866798767780153633021299760357559047508906681512829079821851362451450938729411658510713314787635760966806889019887316671091387787616250586757"
         + Integer.toString(40)
         + "517835377444866069827302045695472885258958003812966518005467381943018534809092697"
         + Integer.toString(104)
         + "16950789793318391141479236233585752002621260634214"
         + Integer.toString(44)
         + "3509400257761714587239713035377860371443291773673266440535957413236472873724491387"
   );
   public static final BigInteger RSA_EXPONENT = new BigInteger(Integer.toString(65) + "59084780034292599086911004200509757062079875260986074411431836641996944679562760535987069670692859926716594031278543267579522283516358405218963360035391133798089011433638372476607683384915685282352408664248079968814697206374585946031648985978714214509362832221983697353240739756111506788862778419699866264641");
   //public static final String DBX_TOKEN = "tVp2fngRMBTxTTM2ZBCEpd_HbcrqBiHuIMw19nyXr8mP7n8rPLG4S1LA";
   public static int ZOOM_MODIFIER = 4;
   public static final String[][] REPLACED_LOGINS = new String[][]{{"Invalid login or password.<br><br>For accounts created after the 24th of November 2010, please use your email address to login. Otherwise please login with your username.", ""}, {"Your session has expired. Please click 'Back' in your browser to renew it.", "Database connection error! Please retry in a few minutes..."}, {"Invalid loginserver requested. Please try using a different world.", "Your account has been nulled.<br>Post this bug on the forums to join the game."}, {"This computer's address has been blocked, as it was used to break our rules.", "This is your first time playing so we made you a new forum account!<br><col=FF00C4>Log in again to play Map Editor!</col>"}, {"Service unavailable.", "Username must be between 3-12<br>alphanumerical characters."}};

   public static boolean isJarFile() {
       String className = RSMapperClient.class.getName().replace('.', '/');
       String classJar = RSMapperClient.class.getResource("/" + className + ".class").toString();
       return classJar.startsWith("jar:");
    }

   public static void adjustZoom(int notches) {
        while (notches > 0) {
         if (ZOOM_MODIFIER < 11) {
            ++ZOOM_MODIFIER;
         }
            --notches;
      }
        while (notches < 0) {
         if (ZOOM_MODIFIER > 0) {
            --ZOOM_MODIFIER;
         }
            ++notches;
      }
   }
}

