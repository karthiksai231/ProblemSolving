package Problems;

public class MedianofTwoSortedArrays {
  public static double getTheMedian(int[] nums1, int[] nums2) {
    int len1 = nums1.length;
    int len2 = nums2.length;
    int last = 0;
    int prev = 0;
    int mid = (len1 + len2)/2;
    boolean flag = (mid)%2 == 0;

    if (len1 == 0) {
      if (flag) {
        prev = nums2[mid - 1];
      }

      last = nums2[mid];
    } else if (len2 == 0) {
      if (flag) {
        prev = nums1[mid - 1];
      }

      last = nums1[mid];
    } else if (nums1[0] > nums2[len2 -1]) {
      if (flag) {
        prev = mid - 1 < len2 ? nums2[mid - 1] : nums1[mid - 1 - len1];
      }

      last = mid < len2 ? nums2[mid] : nums1[mid - len2];
    } else if (nums2[0] > nums1[len1 -1]) {
      if (flag) {
        prev = mid - 1  < len1 ? nums1[mid - 1] : nums2[mid - 1 - len1];
      }

      last = mid < len1 ? nums1[mid] : nums2[mid - len1];
    } else {
      int i = 0, j = 0;

      while (mid-- >= 0) {

        if (flag) {
          prev = last;
        }

        if (i == len1) {
          last = nums2[j++];
        } else if(j == len2) {
          last = nums1[i++];
        } else if (nums1[i] > nums2[j]) {
          last = nums2[j++];
        } else {
          last = nums1[i++];
        }
      }
    }

    if (flag) {
      return (prev + last)/2.0;
    }

    return last;
  }

  public static void main(String[] args) {
    getTheMedian(new int[] {1, 3}, new int[] {2});
  }
}
