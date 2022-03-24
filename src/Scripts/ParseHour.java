package Scripts;

public final class ParseHour {
  public static Boolean checkHour(String str) {
    if (!str.matches("\\d{2}:\\d{2}")
        && !str.matches("\\d{1}:\\d{2}")
        && !str.matches("\\d{2}:\\d{1}")
        && !str.matches("\\d{1}:\\d{1}"))
      return false;
    String[] splited = str.split(":");
    try {
      int hour = Integer.parseInt(splited[0]);
      int minutes = Integer.parseInt(splited[1]);
      if (hour < 0 || hour > 23) {
        return false;
      }
      if (minutes < 0 || minutes > 60) {
        return false;
      }
    } catch (NumberFormatException e) {
      return false;
    }
    return true;
  }
}
