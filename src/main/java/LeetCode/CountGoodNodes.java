package LeetCode;

import apple.laf.JRSUIUtils;

public class CountGoodNodes {
  int goodNodes;
  public int goodNodes(TreeNode root) {
    goodNodes = 0;
    helper(root, Integer.MIN_VALUE);
    return  goodNodes;
  }

  public void helper(TreeNode node, int max) {
    if (node == null) {
      return;
    }

    if (node.val >= max) {
      goodNodes++;
    }

    max = Math.max(node.val, max);

    helper(node.left, max);
    helper(node.right, max);
  }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) {
      this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
