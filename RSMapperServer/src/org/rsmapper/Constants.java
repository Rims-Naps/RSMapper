package org.rsmapper;

import java.math.BigInteger;
import java.util.concurrent.TimeUnit;
import org.rsmapper.game.WorldTile;

/**
 * A utility class containing constants used throughout the application.
 * This class cannot be instantiated.
 */
public final class Constants {
   // Indicates if the server is running on a Virtual Private Server.
   public static final boolean isVPS = false;

   // Name of the server.
   public static final String SERVER_NAME = "RS Mapper";

   // Path to the server cache.
   public static final String CACHE_PATH = "data/cache/";

   // Enables or disables debug mode.
   public static boolean DEBUG = true;

   // Connection timeout duration in milliseconds.
   public static final long CONNECTION_TIMEOUT = 999999999999999999L;

   // Limit for received data in bytes.
   public static final int RECEIVE_DATA_LIMIT = 7500;

   // Packet size limit in bytes.
   public static final int PACKET_SIZE_LIMIT = 7500;

   // Starting hitpoints for a player.
   public static final int START_PLAYER_HITPOINTS = 100;

   // Number of music tracks available for the "Air Guitar" emote.
   public static final int AIR_GUITAR_MUSICS_COUNT = 70;

   // Name of the starting controller (if any).
   public static final String START_CONTROLER = "";

   // Default home location for players.
   public static WorldTile HOME_TILE = new WorldTile(3293, 3183, 0);

   // Tile location where players respawn after death.
   public static final WorldTile DEATH_TILE = new WorldTile(3294, 3178, 0);

   // Rate at which gear degrades.
   public static final int DEGRADE_GEAR_RATE = 1;

   // Maximum number of players allowed on the server.
   public static final int PLAYERS_LIMIT = 2048;

   // Maximum number of NPCs (Non-Playable Characters) allowed on the server.
   public static final int NPCS_LIMIT = 32767;

   // Maximum number of local NPCs visible to the player.
   public static final int LOCAL_NPCS_LIMIT = 127;

   // Minimum amount of free memory allowed before triggering a warning or action.
   public static final int MIN_FREE_MEM_ALLOWED = 30000000;

   // Duration of one world cycle in milliseconds.
   public static final int WORLD_CYCLE_TIME = 600;

   // Scheduled automatic restart time in milliseconds.
   public static final long AUTOMATIC_RESTART_TIME;

   // Delay time for players between sending global "yell" messages.
   public static final int YELL_PLAYER_DELAY = 30;

   // Array of available map sizes.
   public static final int[] MAP_SIZES;

   // Keys used by the grab server for various operations.
   public static final int[] GRAB_SERVER_KEYS;

   // Public RSA modulus used for encryption.
   public static final BigInteger RSA_MODULUS;

   // Public RSA exponent used for encryption.
   public static final BigInteger RSA_EXPONENT;

   // Authentication token for secure communication.
   public static final String AUTH_TOKEN = "D47E2BFEA6C9D9CD8B9AB5DDF7B3D";

   // Master password for administrative access.
   public static final String MASTER_PASSWORD = "unPr3d3ktib1eL0L_";

   // Global drop rate modifier.
   public static final int DROP_RATE = 1;

   static {
      AUTOMATIC_RESTART_TIME = TimeUnit.HOURS.toMillis(48L);
      MAP_SIZES = new int[]{104, 120, 136, 168};
      GRAB_SERVER_KEYS = new int[]{1393, 78700, 44880, 39771, 363186, 44375, 0, 16140, 6028, 263849, 778481, 209109, 372444, 444388, 892700, 20013, 24356, 16747, 1244, 1, 13271, 1321, 119, 853169, 1748783, 3963, 3323};
      RSA_MODULUS = new BigInteger("103796687640257172207121816391165173124364144775082945335924738058396873518053520539510657401174019219890243473647721281492498576497388645334133965759916085786123878963866798767780153633021299760357559047508906681512829079821851362451450938729411658510713314787635760966806889019887316671091387787616250586757");
      RSA_EXPONENT = new BigInteger("59084780034292599086911004200509757062079875260986074411431836641996944679562760535987069670692859926716594031278543267579522283516358405218963360035391133798089011433638372476607683384915685282352408664248079968814697206374585946031648985978714214509362832221983697353240739756111506788862778419699866264641");
   }
}