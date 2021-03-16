package Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FourSum {
  public static List<List<Integer>> getFourSum(int[] num, int target) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (num.length < 4) {
      return result;
    }
    Arrays.sort(num);

    for (int i = 0; i < num.length - 3; i++) {
      if (i > 0 && num[i] == num[i - 1]) {
        continue;
      }
      for (int j = num.length - 1; j > i + 2; j--) {
        if (j < num.length - 1 && num[j] == num[j + 1]) {
          continue;
        }
        int start = i + 1;
        int end = j - 1;
        int n = target - num[i] - num[j];
        while (start < end) {
          if (num[start] + num[end] == n) {
            List<Integer> four = new ArrayList<Integer>();
            four.add(num[i]);
            four.add(num[start]);
            four.add(num[end]);
            four.add(num[j]);
            result.add(four);
            do { start++; } while (start < end && num[start] == num[start - 1]);
            do { end--; } while (start < end && num[end] == num[end + 1]);
          }
          else if (num[start] + num[end] < n) {
            do { start++; } while (start < end && num[start] == num[start - 1]);
          }
          else {
            do { end--; } while (start < end && num[end] == num[end + 1]);
          }

        }
      }
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(getFourSum(new int[] {1, 1, -1, 0, -2, 1, -1}, 0));
  }
}
