package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode (int val) {
      this.val = val;
    }
  }

  public String serialize(TreeNode root) {
    return serializationHelper(root, "");
  }

  public String serializationHelper(TreeNode node, String s) {
    if (node == null) {
      s += "null,";
    } else {
      s += s.valueOf(node.val) + ",";
      s = serializationHelper(node.left, s);
      s = serializationHelper(node.right, s);
    }

    return s;
  }

  public TreeNode deserialize(String data) {
    Queue<String> queue = new LinkedList<>();
    queue.addAll(Arrays.asList(data.split(",")));
    return deserializationHelper(queue);
  }

  public TreeNode deserializationHelper(Queue<String> queue) {
    String value = queue.poll();

    if (value == null) {
      return null;
    }

    TreeNode node = new TreeNode(Integer.valueOf(value));
    node.left = deserializationHelper(queue);
    node.right = deserializationHelper(queue);
    return node;

  }
}
