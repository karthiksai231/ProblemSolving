package Problems;

public class DiameterOfBinaryTree {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode () {
        }

        TreeNode (int val) {
            this.val = val;
        }

        TreeNode (int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair{
        public int includedCount;
        public int excludedCount;

        Pair(int includedCount, int excludedCount) {
            this.includedCount = includedCount;
            this.excludedCount = excludedCount;
        }
    }


    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Pair result = helper(root);
        return Math.max(result.includedCount, result.excludedCount) - 1;
    }

    public static Pair helper(TreeNode root) {
        if (root == null) {
            return new Pair(0, 0);
        }

        Pair left = helper(root.left);
        Pair right = helper(root.right);

        int path = Math.max(left.excludedCount, right.excludedCount);

        if (left.includedCount + right.includedCount + 1 > path) {
            path = left.includedCount + right.includedCount + 1;
        }

        return new Pair(Math.max(left.includedCount, right.includedCount) + 1, path);
    }

    public static void main (String[] args) {

    }
}
