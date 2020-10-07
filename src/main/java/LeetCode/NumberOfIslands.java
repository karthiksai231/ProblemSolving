package LeetCode;

public class NumberOfIslands {
  public static int getMaxNumberOfIslands(char[][] grid) {
    int maxIslands = 0;
    if (grid == null || grid.length == 0) {
      return 0;
    }

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        maxIslands += helper(grid, i, j);
      }
    }
    return maxIslands;
  }

  public static int helper(char[][] grid, int i, int j) {
    if (i < 0 ||
    i >= grid.length ||
    j < 0 ||
    j >= grid[i].length ||
    grid[i][j] == '0') {
      return 0;
    }

    grid[i][j] = '0';

    helper(grid, i + 1, j);
    helper(grid, i - 1, j);
    helper(grid, i, j +1);
    helper(grid, i, j -1);

    return 1;
  }

  public static void main(String[] args) {
    System.out.println(getMaxNumberOfIslands(new char[][]{{'1','1','0','0','0'},
        {'1','1','0','0','0'},
        {'0','0','1','0','0'},
        {'0','0','0','1','1'}}));
  }
}
