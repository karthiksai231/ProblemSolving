import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RangeSearchingInASortedList {

  // O(N) solution
  public static List<Integer> getRange(int [] arr, int t) {
    int left = 0;
    int right = arr.length - 1;
    int start = -1;
    int end = -1;
    boolean foundStart = false;
    boolean foundEnd = false;

    if (arr.length == 1 && arr[0] == t) {
      return Arrays.asList(0, 0);
    }

    while (left <= right) {
      if (arr[left] == t) {
        start = left;
        foundStart = true;
      } else {
        left++;
      }

      if (arr[right] == t) {
        end = right;
        foundEnd = true;
      } else {
        right--;
      }

      if (foundStart && foundEnd) {
        break;
      }
    }

    return Arrays.asList(start, end);
  }

  // O(logN) solution
  public static List<Integer> searchRange(int[] nums, int target) {
    List<Integer> targetRange = new ArrayList<>();
    targetRange.add(0, -1);
    targetRange.add(1, -1);

    int leftIdx = extremeInsertionIndex(nums, target, true);

    if (leftIdx == nums.length || nums[leftIdx] != target) {
      return targetRange;
    }

    return Arrays.asList(leftIdx, extremeInsertionIndex(nums, target, false)-1);
  }

  private static int extremeInsertionIndex(int[] nums, int target, boolean left) {
    int lo = 0;
    int hi = nums.length;

    while (lo < hi) {
      int mid = (lo + hi) / 2;
      if (nums[mid] > target || (left && target == nums[mid])) {
        hi = mid;
      }
      else {
        lo = mid+1;
      }
    }

    return lo;
  }

  public static void main(String[] args) {
    //System.out.println(getRange(new int[] {5,7,7,8,8,8,8,10}, 8));
    System.out.println(searchRange(new int[] {5,7,7,8,8,8,8,10}, 8));
  }
}
