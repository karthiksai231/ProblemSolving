package Problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentElements {
  public static int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap();

    for (int n : nums) {
      map.put(n, map.getOrDefault(n, 0) + 1);
    }

    Queue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(map::get));

    for (int s : map.keySet()) {
      heap.add(s);

      if(heap.size() > k) {
        heap.remove();
      }
    }

    List<Integer> res = new ArrayList<>();

    while (!heap.isEmpty()) {
      res.add(heap.poll());
    }

    return res.stream().mapToInt(i -> i).toArray();
  }

  public static void main(String[] args) {
    topKFrequent(new int[] {1,1,1,2,2,3}, 2);
  }
}
