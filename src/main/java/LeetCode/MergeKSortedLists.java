package LeetCode;

import java.util.PriorityQueue;

public class MergeKSortedLists {
  public class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
      this.val = val;
    }
  }

  public ListNode mergeKLists(ListNode[] listNodes) {
    if (listNodes.length == 0) {
      return null;
    }

    PriorityQueue<Integer> heap = new PriorityQueue<>();
    // Because of the indexing we need to take the exact length of the list
    int len = listNodes.length - 1;

    while (len > 0) {
      for (int i = 0; i < listNodes.length; i++) {
        if (listNodes[i] != null) {
          heap.add(listNodes[i].val);
          listNodes[i] = listNodes[i].next;
        } else {
          // If the node is null replace the current list index
          // with the last value and decrement the length.
          listNodes[i] = listNodes[len--];
        }
      }
    }

    ListNode head = new ListNode(-1);
    ListNode current = head;

    while (!heap.isEmpty()) {
      current.next = new ListNode(heap.poll());
      current = current.next;
    }
    return head.next;
  }
}
