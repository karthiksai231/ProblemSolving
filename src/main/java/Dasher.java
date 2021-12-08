import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dasher {
  public static void main(String[] args) {
    getCodes("2021-12-1 10:00", "2021-12-1 14:00");
  }
  public static List<String> getCodes(String startTime, String endTime) {
    List<String> res = new ArrayList<>();
    DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    LocalDateTime sDate = LocalDateTime.from(f.parse(startTime));
    LocalDateTime eDate = LocalDateTime.from(f.parse(endTime));

    Map<String, Integer> map = new HashMap<>();
    map.put("Monday", 1);
    map.put("Tuesday", 2);
    map.put("Wednesday", 3);
    map.put("Thursday", 4);
    map.put("Friday", 5);
    map.put("Saturday", 6);
    map.put("Sunday", 7);

    while (sDate.isBefore(eDate)) {
      res.add(map.get(sDate.getDayOfWeek()) + Integer.toString(sDate.getHour()));
      sDate.plusMinutes(5);
    }

    return res;
  }
}
