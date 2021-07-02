package LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII {
  public int minMeetingRooms(int[][] intervals) {
    if (intervals == null || intervals.length == 0) {
      return 0;
    }

    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
    PriorityQueue<Integer> heap = new PriorityQueue<>();
    heap.add(intervals[0][1]);

    for (int i = 1; i < intervals.length; i++) {
      int nextMeeting = intervals[i][0];
      int lastEndtime = heap.peek();

      if (lastEndtime <= nextMeeting) {
        heap.poll();
      }

      heap.add(intervals[i][1]);
    }

    return heap.size();
  }
}
