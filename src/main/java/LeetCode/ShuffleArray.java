package LeetCode;

import java.util.Random;

public class ShuffleArray {
  int[] nums;
  Random random;

  public ShuffleArray(int[] nums) {
    this.nums = nums;
    random = new Random();
  }

  public int[] shuffle() {
    if (nums == null) {
      return null;
    }

    int [] a = nums.clone();

    for (int i = 1; i < a.length; i++) {
      int index = random.nextInt(i + 1);
      swap(a, index, i);
    }

    return a;
  }

  private void swap(int[] arr, int index, int i) {
    int temp = arr[i];
    arr[i] = arr[index];
    arr[index] = temp;
  }

  public int[] reset() {
    return this.nums;
  }
}
