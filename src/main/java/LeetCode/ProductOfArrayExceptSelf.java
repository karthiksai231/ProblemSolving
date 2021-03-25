package LeetCode;

public class ProductOfArrayExceptSelf {
  public static int[] productExceptSelf(int[] nums) {
    int [] output = new int[nums.length];

    output[0] = 1;

    for (int i = 1; i < nums.length; i++) {
      output[i] = nums[i -1] * output[i -1];
    }

    int right = 1;

    for (int i = nums.length -1; i >= 0; i--) {
      output[i] = nums[i] * right;
      right *= output[i];
    }

    return output;
  }
}
