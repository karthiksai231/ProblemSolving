import java.util.Arrays;
import java.util.HashMap;

public class CitizenBank {
  public static void main(String[] args) {
    System.out.println(compareArrays(new int[] {1, 2, 3, 4}, new int[] {4, 2, 1, 3}));
    //System.out.println(targetSum(new int[] {1, 2, 3, 4}, 7));
  }

  public static boolean compareArrays(int[] arr1, int[] arr2) {
    return (Arrays.equals(arr1, arr2));
  }

  public static boolean targetSum(int[] arr, int target) {
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < arr.length; i++) {
      int key = target - arr[i];
      map.put(key, i);
    }

    for (int i = 0; i < arr.length; i++) {
      if (map.containsKey(arr[i]) && map.get(arr[i]) != i) {
        return true;
      }
    }

    return false;
  }
}
