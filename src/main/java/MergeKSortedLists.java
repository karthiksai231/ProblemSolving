import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {
  public static ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
    int len = lists.length - 1;

    while(len >= 0) {
      for (int i = 0; i <= len; i++) {
        if (lists[i] != null) {
          heap.add(lists[i].val);
          lists[i] = lists[i].next;
        } else {
          lists[i] = lists[len--];
        }
      }
    }

    ListNode newHead = new ListNode(-1);
    ListNode curr = newHead;

    while (!heap.isEmpty()) {
      curr.next = new ListNode(heap.poll());
      curr = curr.next;
    }

    return newHead.next;
  }

  public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

  public static void main(String[] args) {
    List<ListNode> lists = new ArrayList<>();
    lists.add(getListNode(new int[] {1, 4, 5}));
    lists.add(getListNode(new int[] {1, 3, 4}));
    lists.add(getListNode(new int[] {2, 6}));

    ListNode[] nodes = new ListNode[3];

    for (int i = 0; i < 3; i++) {
      nodes[i] = lists.get(i);
    }

    mergeKLists(nodes);
  }

  public static ListNode getListNode(int[] values) {
    ListNode newHead = new ListNode(-1);
    ListNode curr = newHead;

    for (int i = 0; i < values.length; i++) {
      curr.next = new ListNode(values[i]);
      curr = curr.next;
    }

    return newHead.next;
  }
}
