package LeetCode;

import java.util.Arrays;
import java.util.TreeMap;

public class MaximumProfitInJobScheduling {
  public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
    int n = startTime.length;

    // creating a 2d array to store start time , end time and profit on each job at each row
    int[][] jobs = new int[n][3];

    for (int i = 0; i < n; i++) {
      jobs[i] = new int[] {startTime[i], endTime[i], profit[i]};
    }

    // sorting the jobs array on the basis of end time
    Arrays.sort(jobs, (a, b) -> a[1] - b[1]);

    // Reason to use TreeMap : it stores keys already in sorted order and searching any key take (logn) time as it uses Binary Search internally
    TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
    map.put(0, 0);

    for (int[] job : jobs) {
      // we have to find the highest value that is lower and equal to the provided start time
      int profitTillNow = job[2] + map.floorEntry(job[0]).getValue();

      // we'll only put the profit val in the map only if its val is greater than the last profit
      if (profitTillNow > map.lastEntry().getValue()) {
        map.put(job[1], profitTillNow);
      }
    }

    // simply returning the last entry of TreeMap ( as it already sorted ) so the last one will obvio have the max profit
    return map.lastEntry().getValue();
  }

  public static void main(String[] args) {
    jobScheduling(new int[] {1,2,3,3}, new int[] {3,4,5,6}, new int[] {50,10,40,70});
  }
}
