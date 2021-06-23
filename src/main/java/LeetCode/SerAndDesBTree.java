package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerAndDesBTree {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode (int val) {
      this.val = val;
    }
  }

  public String serialize(TreeNode root) {
    return serializeHelper(root, "");
  }

  public String serializeHelper(TreeNode root, String s) {
    if (root == null) {
      return "null";
    } else {
      s += s.valueOf(root.val) + ",";
      s = serializeHelper(root.left, s);
      s = serializeHelper(root.right, s);
    }
    return s;
  }

  public TreeNode deserialize(String data) {
    Queue<String> queue = new LinkedList<>();
    queue.addAll(Arrays.asList(data.split(",")));
    return deserializeHelper(queue);
  }

  public TreeNode deserializeHelper(Queue<String> queue) {
    String val = queue.poll();

    if (val == "null") {
      return null;
    }

    TreeNode node = new TreeNode(Integer.valueOf(val));

    node.left = deserializeHelper(queue);
    node.right = deserializeHelper(queue);

    return node;
  }
}
