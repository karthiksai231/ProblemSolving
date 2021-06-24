package LeetCode;

public class CopyListWithRandomPointers {
  class Node {
    int val;
    Node next;
    Node random;

    public Node (int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }
  }

  // O(n)
  public Node copyRandomList(Node head) {
    if (head == null) {
      return null;
    }

    Node curr = head;

    while (curr != null) {
      Node newNode = new Node(curr.val);
      newNode.next = curr.next;
      curr.next = newNode;
      curr = newNode.next;
    }

    curr = head;

    while (curr != null) {
      curr.next.random = curr.random != null ? curr.random.next : null;
      curr = curr.next.next;
    }

    Node oldList = head, newList = head.next, newHead = head.next;

    while (oldList != null) {
      oldList.next = oldList.next.next;
      newList.next = newList.next != null ? newList.next.next : null;
      oldList = oldList.next;
      newList = newList.next;
    }

    return newHead;
  }
}
