package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseScheduleII {
  public int[] getPrerequisiteOrder(int numCourses, int[][] prerequisites) {
    // To Store the result
    List<Integer> result = new ArrayList<>();
    // Number of Courses to take in order to finish the degree
    int[] inDegree = new int[numCourses];
    // Add courses which does not require pre-requisites
    Queue<Integer> queue = new LinkedList<>();
    // pre-requisite -> course count
    // If the pre-req is completed those many courses can be completed
    Map<Integer, List<Integer>> map = new HashMap<>();

    for (int i = 0; i < prerequisites.length; i++) {
      inDegree[prerequisites[i][0]]++;

      if (map.containsKey(prerequisites[i][1])) {
        map.get(prerequisites[i][1]).add(prerequisites[i][0]);
      } else {
        List<Integer> list = new ArrayList<>();
        list.add(prerequisites[i][0]);
        map.put(prerequisites[i][1], list);
      }
    }

    for (int i = 0; i < numCourses; i++) {
      // This particular course has no pre-requisites
      if (inDegree[i] == 0) {
        queue.add(i);
      }
    }

    int count = 0;

    while (!queue.isEmpty()) {
      int current = queue.poll();
      result.add(current);
      count++;
      if (map.containsKey(current)) {
        for (int value : map.get(current)) {
          inDegree[value]--;

          if (inDegree[value] == 0) {
            queue.add(value);
          }
        }
      }
    }
    return count == numCourses ?
        result.stream().mapToInt(i -> i).toArray()
        : new int[0];
  }
}
