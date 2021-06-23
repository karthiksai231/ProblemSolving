package LeetCode;

public class LowestCommonAncestor {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode (int val) {
      this.val = val;
    }
  }

  public TreeNode getLCA(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return null;
    }

    if (root == p || root == q) {
      return root;
    }

    TreeNode left = getLCA(root.left, p, q);
    TreeNode right = getLCA(root.right, p, q);

    if (left != null && right != null) {
      return root;
    }

    if (left == null && right == null) {
      return null;
    }

    return left != null ? left : right;
  }
}
