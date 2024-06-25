package org.rsmapper.utilities.misc;

public interface Colors {
   String RED = "FF0000";
   String DARK_RED = "CD0000";
   String BLUE = "000FF";
   String YELLOW = "FAFA34";
   String WHITE = "FFFFFF";
   String PURPLE = "660066";
   String LIGHT_BLUE = "99CCFF";
   String MILD_BLUE = "0066CC";
   String ORANGE = "FF6600";
   String LIGHT_GREY = "C2C2C2";
   String MILD_GREY = "747170";
   String DARK_GREY = "373737";
   String BLACK = "000000";
   String GREEN = "006600";
   String LIGHT_GREEN = "01C101";
   String MAROON = "800000";
   String DARK_GREEN = "003300";

   static String getHexFromRGB(int red, int green, int blue) {
      return String.format("%02X%02X%02X", red, green, blue);
   }

   static String getLevelDifferenceColor(int hiddenLevel, int displayedLevel) {
      int levelDifference = displayedLevel - hiddenLevel;
      if (levelDifference > 0) {
         return getHexFromRGB(255, levelDifference > 10 ? 0 : 255 - 25 * levelDifference, 0);
      } else {
         return levelDifference < 0 ? getHexFromRGB(levelDifference < -10 ? 0 : 255 - 25 * Math.abs(levelDifference), 255, 0) : getHexFromRGB(255, 255, 0);
      }
   }
}
