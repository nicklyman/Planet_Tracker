import java.lang.*;
import java.util.*;
import java.util.Calendar;

public class DateTime {

  private int year;
  private int month;
  private int day;
  private int hour;
  private int minute;

  public DateTime(long systemMilliSeconds) {
    //create calendar object
    Calendar myCalendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));  //database ranges 4:00 to 12:00 UTC
    myCalendar.setTimeInMillis(systemMilliSeconds);

    //save our information
    this.year = myCalendar.get(Calendar.YEAR);
    this.month = myCalendar.get(Calendar.MONTH);
    this.day = myCalendar.get(Calendar.DAY_OF_MONTH);
    this.hour = myCalendar.get(Calendar.HOUR_OF_DAY);
    this.minute = myCalendar.get(Calendar.MINUTE);
  }


  public String getSimpleDateTime() {
    return String.valueOf(year) + "-" + this.convertMonthToString() + "-" + this.addZeroToDatesLessThanTen() + " " + String.valueOf(hour) + ":" + String.valueOf(minute);
  }

  public String getSimpleDateTimeRoundedDown() {
    return String.valueOf(year) + "-" + this.convertMonthToString() + "-" + this.addZeroToDatesLessThanTen() + " " + String.valueOf(hour) + ":00";
  }

  public static String convertUserInput(String year, String month, String day, String time) {
    return (year + "-" + month + "-" + day + " " + time);
  }

  //covert month number to string
  private String convertMonthToString() {
    if (month == 0) {
      return "Jan";
    } else if (month == 1) {
      return "Feb";
    } else if (month == 2) {
      return "Mar";
    } else if (month == 3) {
      return "Apr";
    } else if (month == 4) {
      return "May";
    } else if (month == 5) {
      return "Jun";
    } else if (month == 6) {
      return "Jul";
    } else if (month == 7) {
      return "Aug";
    } else if (month == 8) {
      return "Sep";
    } else if (month == 9) {
      return "Oct";
    } else if (month == 10) {
      return "Nov";
    } else if (month == 11) {
      return "Dec";
    } else {
      return null;
    }
  }

  //add padding to numbers below 10
  private String addZeroToDatesLessThanTen() {
    if (day < 10) {
      return String.format("%02d", day);
    } else {
      return String.valueOf(day);
    }
  }
}
