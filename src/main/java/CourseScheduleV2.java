import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseScheduleV2 {
  public static String[] getCourseList(Map<String, List<String>> courses) {
    List<String> res = new ArrayList<>();
    Queue<String> q = new LinkedList<>();
    Map<String, List<String>> map = new HashMap<>();
    Map<String, Integer> inDegree = new HashMap<>();

    for (String key:
         courses.keySet()) {
      if (!inDegree.containsKey(key)) {
        inDegree.put(key, courses.get(key).size());
      }
      for (String val : courses.get(key)) {
        if (map.containsKey(val)) {
          map.get(val).add(key);
        } else {
          List<String> l = new ArrayList<>();
          l.add(key);
          map.put(val, l);
        }
      }
    }

    for (String key : courses.keySet()) {
      if (courses.get(key) == null || courses.get(key).size() == 0) {
        q.add(key);
      }
    }

    int count = 0;

    while (!q.isEmpty()) {
      String curr = q.poll();
      res.add(curr);
      count++;

      if (map.containsKey(curr)) {
        for (String val : map.get(curr)) {
          inDegree.put(val, inDegree.getOrDefault(val, 0)-1);
          if (inDegree.get(val) <= 0) {
            q.add(val);
          }
        }
      }
    }

    return res.toArray(new String[res.size()]);
  }

  public static void main(String[] args) {
    Map<String, List<String>> map = new HashMap<>();
    map.put("CSC300", Arrays.asList(new String[]{"CSC100", "CSC200"}));
    map.put("CSC200", Arrays.asList(new String[] {"CSC100"}));
    map.put("CSC100", new ArrayList<>());
    getCourseList(map);
  }
}
