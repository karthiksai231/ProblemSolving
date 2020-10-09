package LeetCode;

public class TrappingRainWater {
  public static int trap(int[] height) {
    int currLevel = 0;
    int res = 0, l = 0, r = height.length - 1;

    while (l < r) {
      int lower = height[height[l] < height[r] ? l++ : r--];
      currLevel = Math.max(currLevel, lower);
      res += currLevel - lower;
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
  }
}
