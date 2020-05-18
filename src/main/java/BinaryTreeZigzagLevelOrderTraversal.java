import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {

  public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    if (root == null) {
      return new ArrayList<List<Integer>>();
    }

    // call helper
    List<List<Integer>> results = new ArrayList<List<Integer>>();
    helper(root, 0, results);

    return results;
  }

  public static void helper(TreeNode node, int level, List<List<Integer>> results) {
    if (level >= results.size()) {
      LinkedList<Integer> newLevel = new LinkedList<Integer>();
      newLevel.add(node.val);
      results.add(newLevel);
    } else {
      if (level % 2 == 0) {
        results.get(level).add(node.val);
      } else {
        results.get(level).add(0, node.val);
      }
    }

    if (node.left != null) {
      helper(node.left, level + 1, results);
    }

    if (node.right != null) {
      helper(node.right, level + 1, results);
    }
  }

  public static class TreeNode {
      int val;
      TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);
    List<List<Integer>> list = zigzagLevelOrder(root);
  }

//  public static void buildNode(List<Integer> nodes, TreeNode root, int i) {
//    for (Integer val : nodes) {
//      TreeNode temp = new TreeNode(val);
//      root = temp;
//
//      root.left = buildNode(nodes, root.left, );
//    }
//  }

}
