package LeetCode;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {
  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int[] nums3;

    nums3 = mergeArrays(nums1, nums2);

    int n = nums3.length;

    Arrays.sort(nums3);

    return  n % 2 == 0 ?
        (double) (nums3[(n - 1)/2] + nums3[n/2]) / 2.0 :
        (double) nums3[n/2];
   }

  public static int[] mergeArrays(int[] arr1, int[] arr2) {
    int[] arr3 = new int[arr1.length + arr2.length];

    int i = 0, n = 0;

    while (i < arr1.length) {
      arr3[n++] = arr1[i++];
    }

    i = 0;

    while (i < arr2.length) {
      arr3[n++] = arr2[i++];
    }

    return arr3;
  }
}
