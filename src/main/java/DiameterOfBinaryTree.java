import javafx.util.Pair;

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


    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Pair<Integer, Integer> result = helper(root);
        return Math.max(result.getKey(), result.getValue());
    }

    public static Pair<Integer, Integer> helper(TreeNode root) {
        if (root == null) {
            return new Pair<Integer, Integer>(0, 0);
        }

        Pair<Integer, Integer> left = helper(root.left);
        Pair<Integer, Integer> right = helper(root.right);

        int path = Math.max(left.getValue(), right.getValue());

        if (left.getKey() + right.getKey() + 1 > path) {
            path = left.getKey() + right.getKey() + 1;
        }

        return new Pair<>(Math.max(left.getKey(), right.getKey()) + 1, path);
    }

    public static void main (String[] args) {

    }
}
