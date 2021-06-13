package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class InsertDeleteGetRandom {
  public static class RandomizedSet {

    public static ArrayList<Integer> nums;
    public static Map<Integer, Integer> map;
    public static Random rand = new Random();

    public RandomizedSet() {
      nums = new ArrayList<>();
      map = new HashMap<>();
    }

    public boolean insertValue(int value) {
      boolean isExisting = map.containsKey(value);

      if (isExisting) {
        return false;
      }

      map.put(value, nums.size());
      nums.add(value);
      return true;
    }

    public boolean removeValue(int value) {
      boolean isExisting = map.containsKey(value);

      if (!isExisting) {
        return false;
      }

      int index = map.get(value);

      // If the index is not at the end on the list
      if (index < nums.size() - 1) {
        int endNum = nums.get(nums.size() - 1);
        nums.set(index, endNum);
        map.put(endNum, index);
      }

      map.remove(value);
      nums.remove(nums.size() - 1);
      return true;
    }

    public int getRandom() {
      return nums.get(rand.nextInt(nums.size()));
    }
  }
}
