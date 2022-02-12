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

  public static double binarySearch(int[] nums1, int[] nums2) {
    int n = nums1.length;
    int m = nums2.length;
    if(n>m){
      return binarySearch(nums2,nums1);   //search is applied on smaller array
    }
    int s = 0;                                               //start here
    int e = n;                                              //end here
    int mid = (n+m+1)/2;                     //middle index of merged array
    while(s<=e){
      int mi = (s+e)/2;                         //middle of smaller array
      int al = (mi>0)?nums1[mi-1]:Integer.MIN_VALUE;  // checking for bounds
      int ar = (mi<n)?nums1[mi]:Integer.MAX_VALUE;
      int bl = Integer.MIN_VALUE;
      int x = mid-mi;
      if(x>0)
        bl = nums2[(x-1)];
      int br = (mid-mi<m)?nums2[mid-mi]:Integer.MAX_VALUE;
      if(al<=br&&bl<=ar){                         // if left values are smaller than right values means all smaller elements are on left of current index
        if((m+n)%2==0)
          return (Math.max(al,bl)+Math.min(ar,br))/2.0;
        else
          return Math.max(al,bl);
      }
      else if(al>br)                                //if partitioning is not correct then reiterate
        e = mi-1;
      else
        s = mi+1;
    }
    return 0.0;
  }
}
