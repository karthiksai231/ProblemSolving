import java.util.PriorityQueue;

public class ProblemStatement {
  /*
  Problem Statement #
Given an array of positive numbers and a positive number ‘k,’
find the maximum sum of any contiguous subarray of size ‘k’.
Example 1:
Input: [2, 1, 5, 1, 3, 2], k=3
Output: 9
Explanation: Subarray with maximum sum is [5, 1, 3].
Example 2:
Input: [2, 3, 4, 1, 5], k=2
Output: 7
Explanation: Subarray with maximum sum is [3, 4].
   */

  public static int maxSum(int arr[],int n,int k)
  {
    //k must be greater
    if(n<k)
    {
      System.out.println("Invalid");
      return -1;
    }
    //compute sum of first window of size k
    int res = 0;
    for(int i=0;i<k;i++)
      res+= arr[i];
    int curr_sum = res;
    for(int i=k;i<n;i++)
    {
      curr_sum += arr[i] - arr[i-k];
      res = Math.max(res,curr_sum);
    }
    return res;
  }

  public static void getMaxSubarraySum(int[] arr, int k) {
    // Base Conditions
    if (arr == null || arr.length == 0 || arr.length < k) {
      System.out.println("Invalid input");
    }

    PriorityQueue<Integer> queue = new PriorityQueue<>();
    int maxSum = 0;

    for (int i = 0; i < arr.length - 1; i++) {
      int sum = arr[i] + arr[i + 1] + arr[i + 2];
      maxSum = sum > maxSum ? sum : maxSum;
    }

    System.out.println("The max sum is " + maxSum);
  }

  public static void main(String[] args) {
    System.out.println(maxSum(new int[] {2, 3, 4, 1, 5}, 5, 2));
  }
}
