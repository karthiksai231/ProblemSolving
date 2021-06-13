package LeetCode;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
  public static int[] productExceptSelf(int[] nums) {
    int[] ret = new int[nums.length];

    ret[0] = 1;

    for (int i = 1; i < nums.length; i++) {
      ret[i] = nums[i - 1] * ret[i -1];
    }

    int right = 1;

    for (int i = nums.length-1; i >= 0; i--) {
      ret[i] = ret[i] * right;
      right *= nums[i];
    }

    return ret;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(productExceptSelf(new int[] {4, 5, 8, 11})));
  }
}
