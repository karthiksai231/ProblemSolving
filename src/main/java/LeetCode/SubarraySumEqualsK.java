package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
  public static int subArray(int[] arr, int k) {
    int count = 0, sum = 0;
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);

    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];

      if (map.containsKey(sum - k)) {
        count += map.get(sum - k);
      }

      map.put(sum, map.getOrDefault(sum, 0) + 1);
    }

    return count;
  }

  public static void main(String[] args) {
    System.out.println(subArray(new int[] {1, 2, 8, 3}, 3));
  }
}
