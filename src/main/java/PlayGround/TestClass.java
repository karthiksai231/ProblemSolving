package PlayGround;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestClass {
  public static void main(String[] args) {
    /*
    BinaryTree root = new BinaryTree(1);
    root.left = new BinaryTree(2);
    root.left.left = new BinaryTree(4);
    root.left.right = new BinaryTree(5);
    root.left.left.left = new BinaryTree(8);
    root.left.left.right = new BinaryTree(9);
    root.right = new BinaryTree(3);
    root.right.left = new BinaryTree(6);
    root.right.right = new BinaryTree(7);

    nodeDepths(root);
    */

    //String res  = caesarCypherEncryptor("abc", 52);
    //threeNumberSum(new int[] {12, 3, 1, 2, -6, 5, -8, 6}, 0);
    isMonotonic(new int[] {1, 2});
  }

  public static boolean isMonotonic(int[] array) {
    // Write your code here.
    int i = 0;
    int j = 1;

    while (i < array.length && j < array.length && array[i] == array[j]) {
      i++;
      j++;
      continue;
    }

    if (i >= array.length || j >= array.length) {
      return true;
    } else {
      return helper((array[i] < array[j]), array, i, j);
    }
  }

  public static boolean helper(boolean isIncreasing, int[] array, int i, int j) {
    while (i < array.length && j < array.length) {
      if (array[i] == array[j]) {
        i++;
        j++;
        continue;
      }

      if ((isIncreasing && array[i] > array[j]) || ( !isIncreasing && array[i] < array[j])) {
        return false;
      }
      i++;
      j++;
    }

    return true;
  }

  public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
    // Write your code here.
    Arrays.sort(array);
    List<Integer[]> res = new ArrayList<>();

    for (int i = 0; i < array.length - 2; i++) {
      int l = i + 1;
      int r = array.length - 1;
      while (l < r) {
        int sum = array[i] + array[l] + array[r];

        if (sum == targetSum) {
          res.add(new Integer[] {array[i], array[l], array[r]});
          l++;
          r--;
        } else if (sum > targetSum) {
          r--;
        } else {
          l++;
        }
      }
    }
    return res;
  }

  public static String caesarCypherEncryptor(String str, int key) {
    // Write your code here.
    StringBuilder builder = new StringBuilder();
    int value = 1;
    Map<Integer, Character> map = new HashMap<Integer, Character>();
    for(char c = 'a'; c <= 'z'; c++) {
      map.put((int) c - 'a', c);
    }

    for(char c : str.toCharArray()) {
      int res = c - 'a';
      res += key;

      helper(builder, res, map);
    }
    return builder.toString();
  }

  private static void helper(StringBuilder builder, int res, Map<Integer, Character> map) {
    if (res > 25) {
      helper(builder, res - 25 - 1, map);
    } else {
      builder.append(map.get(res));
    }
  }

  static class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;

    public BinaryTree(int value) {
      this.value = value;
      left = null;
      right = null;
    }
  }

  public static int nodeDepths(BinaryTree root) {
    // Write your code here.
    if (root == null) {
      return 0;
    }

    // Call helper
    List<List<Integer>> levels = new ArrayList<List<Integer>>();
    helper(root, levels, 0);

    int res = 0;
    int tempIdx = 0;

    for (List<Integer> l : levels) {
      res = res + ((tempIdx ++) * l.size());
    }

    return res;
  }

  public static void helper(BinaryTree node, List<List<Integer>> levels, int currLevel) {

    if (currLevel >= levels.size()) {
      List<Integer> subList = new ArrayList<Integer>();
      subList.add(node.value);
      levels.add(currLevel, subList);
    } else {
      levels.get(currLevel).add(node.value);
    }

    if (node.left != null) {
      helper(node.left, levels, currLevel + 1);
    }

    if (node.right != null) {
      helper(node.right, levels, currLevel + 1);
    }
  }
}
