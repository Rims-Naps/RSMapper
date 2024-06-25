package org.rsmapper.utilities.misc;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class DateManager {
   public static final int YEAR_INDEX = 0;
   public static final int MONTH_INDEX = 1;
   public static final int DAY_INDEX = 2;
   public static final int HOUR_INDEX = 0;
   public static final int MIN_INDEX = 1;
   public static final int SEC_INDEX = 2;
   private static final DateManager INSTANCE = new DateManager();
   private static final boolean EXTENDED_WEEKEND;

   static {
      EXTENDED_WEEKEND = Boolean.TRUE;
   }

   public void setTime() {
      TimeZone.setDefault(TimeZone.getTimeZone("America/Los_Angeles"));
   }

   public static int[] getCurrentDate() {
      Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("PST"));
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.US);
      simpleDateFormat.setTimeZone(TimeZone.getTimeZone("PST"));
      String dateTime = simpleDateFormat.format(calendar.getTime());
      String date = dateTime.substring(0, 10);
      String[] splitDate = date.split("/");
      int[] dateArray = new int[3];
      int day = Integer.parseInt(splitDate[0]);
      int month = Integer.parseInt(splitDate[1]);
      int year = Integer.parseInt(splitDate[2]);
      dateArray[0] = year;
      dateArray[1] = month;
      dateArray[2] = day;
      return dateArray;
   }

   public static int[] getCurrentTime() {
      Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("PST"));
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.US);
      simpleDateFormat.setTimeZone(TimeZone.getTimeZone("PST"));
      String dateTime = simpleDateFormat.format(calendar.getTime());
      String time = dateTime.substring(11, 19);
      String[] splitDate = time.split(":");
      int[] timeArray = new int[3];
      int hours = Integer.parseInt(splitDate[0]);
      int minutes = Integer.parseInt(splitDate[1]);
      int seconds = Integer.parseInt(splitDate[2]);
      timeArray[0] = hours;
      timeArray[1] = minutes;
      timeArray[2] = seconds;
      return timeArray;
   }

   public static Date getCurrentDateTime() {
      return new Date(getCurrentDate()[0] - 1900, getCurrentDate()[1], getCurrentDate()[2], getCurrentTime()[0], getCurrentTime()[1], getCurrentTime()[2]);
   }

   public static int getSecondsLeftFromDate(Date fromDate) {
      long duration = fromDate.getTime() - getCurrentDateTime().getTime();
      int secondsLeft = (int)TimeUnit.MILLISECONDS.toSeconds(duration);
      return secondsLeft <= 0 ? 0 : secondsLeft;
   }

   public static int[] getTimeLeftBetweenDates(Date fromDate) {
      int secondsLeft = getSecondsLeftFromDate(fromDate);
      int days = (int)TimeUnit.SECONDS.toDays((long)secondsLeft);
      int hours = (int)(TimeUnit.SECONDS.toHours((long)secondsLeft) - (long)(days * 24));
      int minutes = (int)(TimeUnit.SECONDS.toMinutes((long)secondsLeft) - TimeUnit.SECONDS.toHours((long)secondsLeft) * 60L);
      int seconds = (int)(TimeUnit.SECONDS.toSeconds((long)secondsLeft) - TimeUnit.SECONDS.toMinutes((long)secondsLeft) * 60L);
      return new int[]{days, hours, minutes, seconds};
   }

   public List<Date> getFirstWeekendOfMonth() {
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(this.getDate());
      List<Date> weekendDates = new ArrayList();
      Iterator var4 = this.getDaysInMonth(calendar.getTime()).iterator();

      while(var4.hasNext()) {
         Date date = (Date)var4.next();
         if (weekendDates.size() == 2) {
            break;
         }

         int day = date.getDay();
         switch(day) {
         case 0:
         case 6:
            weekendDates.add(date);
         }
      }

      return weekendDates;
   }

   public boolean isFirstWeekendOfMonth() {
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(this.getDate());
      int date = calendar.getTime().getDate();
      Iterator var4 = this.getFirstWeekendOfMonth().iterator();

      while(var4.hasNext()) {
         Date weekendDate = (Date)var4.next();
         if (weekendDate.getDate() == date) {
            return true;
         }
      }

      return false;
   }

   public String timeTillDXP() {
      List<Date> weekend = this.getFirstWeekendOfMonth();
      Date saturday = (Date)weekend.get(0);
      long saturdayMS = saturday.getTime();
      long currentTime = System.currentTimeMillis();
      long difference = saturdayMS - currentTime;
      if (difference < 0L) {
         return "Passed...";
      } else {
         int seconds = (int)(difference / 1000L) % 60;
         int minutes = (int)(difference / 60000L % 60L);
         int hours = (int)(difference / 3600000L % 24L);
         long days = difference / 86400000L;
         return days + ":" + hours + ":" + minutes + ":" + seconds;
      }
   }

   private int getDaysPerMonth(Calendar calendar) {
      return calendar.getActualMaximum(5);
   }

   private List<Date> getDaysInMonth(Date currentDate) {
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(currentDate);
      List<Date> dates = new ArrayList();

      for(int date = 1; date <= this.getDaysPerMonth(calendar); ++date) {
         Calendar c = Calendar.getInstance();
         c.set(1, calendar.get(1));
         c.set(2, calendar.getTime().getMonth());
         c.set(5, date);
         c.set(11, 0);
         c.set(12, 0);
         c.set(13, 0);
         c.set(14, 0);
         dates.add(c.getTime());
      }

      return dates;
   }

   public String timeTillWeekday() {
      long diff = get().getNextWeekday().getTime() - get().getDate().getTime();
      long diffMinutes = diff / 60000L % 60L;
      long diffHours = diff / 3600000L;
      long diffSeconds = diff / 1000L % 60L;
      return diffHours + ":" + diffMinutes + ":" + diffSeconds;
   }

   public Date getNextWeekday() {
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(this.getDate());
      int dayOfWeek = calendar.get(7);
      if (dayOfWeek == 6) {
         calendar.add(5, 3);
      } else if (dayOfWeek == 7) {
         calendar.add(5, 2);
      } else if (EXTENDED_WEEKEND && dayOfWeek == 2) {
         calendar.add(5, 1);
      } else {
         calendar.add(5, 1);
      }

      calendar.set(11, 0);
      calendar.set(12, 0);
      calendar.set(13, 0);
      calendar.set(14, 0);
      return calendar.getTime();
   }

   public Date getDate() {
      return new Date();
   }

   public static DateManager get() {
      return INSTANCE;
   }
}
