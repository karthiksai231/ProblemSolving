import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseScheduleII {
  public static int[] getPrerequisiteOrder(int numberOfCourses, int[][] prerequisites) {
    List<Integer> res = new ArrayList<>();
    int[] inDegree = new int[numberOfCourses];
    Queue<Integer> q = new LinkedList<>();
    Map<Integer, List<Integer>> map = new HashMap<>();

    for (int i = 0; i < prerequisites.length; i++) {
      inDegree[prerequisites[i][0]]++;

      if (map.containsKey(prerequisites[i][1])) {
        map.get(prerequisites[i][1]).add(prerequisites[i][0]);
      } else {
        List<Integer> l = new ArrayList<>();
        l.add(prerequisites[i][0]);
        map.put(prerequisites[i][1], l);
      }
    }

    for (int i = 0; i < numberOfCourses; i++) {
      if(inDegree[i] == 0) {
        q.add(i);
      }
    }

    int count = 0;

    while (!q.isEmpty()) {
      int curr = q.poll();
      res.add(curr);
      count++;

      if (map.containsKey(curr)) {
        for (int val :  map.get(curr)) {
          inDegree[val]--;
          if (inDegree[val] == 0) {
            q.add(val);
          }
        }
      }
    }

    return res.stream().mapToInt(i -> i).toArray();
  }

  public static void main(String[] args) {
    int[][] arr = new int[4][2];
    arr[0] = new int[] {0, 1};
    arr[1] = new int[] {0, 2};
    arr[2] = new int[] {2, 3};
    arr[3] = new int[] {1, 3};
    System.out.println(getPrerequisiteOrder(4, arr));
  }
}
