import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniqueSumCombinations {

  // Get unique combinations by using the element only once
  public static void getUniqueCombinations(int[] arr, List<List<Integer>> res, List<Integer> subArr, int index, int target) {

    if (target <= 0) {
      if (target == 0) {
        res.add(new ArrayList<>(subArr));
      }
      return;
    }

    for(int i = index; i < arr.length; i++) {

      if (index == i || arr[i] != arr[i-1]) {
        subArr.add(arr[i]);
        getUniqueCombinations(arr, res, subArr, i + 1, target-arr[i]);
        subArr.remove(subArr.size() - 1);
      }
    }
  }

  public static void main(String[] args) {
    List<List<Integer>> res = new ArrayList<>();
    int[] arr = new int[] {10, 1, 2, 7, 6, 1, 5};
    Arrays.sort(arr);
    getUniqueCombinations(arr, res, new ArrayList<>(), 0, 8);
    System.out.println(res);
    //combinationSum(arr, 8);
  }

  // Get the sum by using the same element unlimited number of times
  public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> ret = new ArrayList<>();
    dfs(candidates, target, 0, new ArrayList<>(), ret);
    return ret;
  }

  private static void dfs(int[] candidates, int target, int idx, List<Integer> path, List<List<Integer>> ret) {
    if (target <= 0) {
      if (target == 0) {
        ret.add(path);
      }
      return;
    }
    for (int i = idx; i < candidates.length; i++) {
      List<Integer> p = new ArrayList<>(path);
      p.add(candidates[i]);
      dfs(candidates, target-candidates[i], i, p, ret);
    }
  }
}
