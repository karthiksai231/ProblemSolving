package LeetCode;

public class FirstMissingPositiveInteger {
  public static int firstMissingPositiveInteger(int[] nums) {
    int i = 0;
    while (i < nums.length) {
      if(nums[i] >= 1 && nums[i] <= nums.length && nums[nums[i]-1] != nums[i]) {
        swap(nums, i, nums[i]-1);
      }else{
        i++;
      }
//      if (nums[i] == i+1 ||
//      nums[i] <= 0 ||
//      nums[i] > nums.length) {
//        i++;
//      } else if (nums[nums[i] - 1] != nums[i]) {
//        swap(nums, i, nums[i]-1);
//      } else {
//        i++;
//      }
    }

    i = 0;

    while (i < nums.length && nums[i] == i + 1) {
      i++;
    }

    return i+1;
  }

  public static void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public static void main(String[] args) {
    System.out.println(firstMissingPositiveInteger(new int[] {3, 4, -1, 1}));
  }
}
