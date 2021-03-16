package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Comparator;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> res = new ArrayList();
        int[] currInterval = intervals[0];
        res.add(currInterval);

        for (int[] interval:
             intervals) {
            int currEnd = currInterval[1];

            int nextBegin = interval[0];
            int nextEnd = interval[1];

            if (currEnd >= nextBegin) {
                currInterval[1] = Math.max(currEnd, nextEnd);
            } else {
                currInterval = interval;
                res.add(currInterval);
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
