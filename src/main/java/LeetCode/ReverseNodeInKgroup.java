package LeetCode;

import java.util.List;

public class ReverseNodeInKgroup {
  // O(n)
  public class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
      this.val = val;
    }
  }

  public ListNode reverseList(ListNode head, int k) {
    if (head == null ||
    head.next == null ||
    k <= 0) {
      return head;
    }

    ListNode ptr = head;
    int count = 0;

    while (ptr != null && count < k) {
      ptr = ptr.next;
      count++;
    }

    if (count == k) {
      return helper(head, k);
    }

    return head;
  }

  public ListNode helper(ListNode head, int k) {
    ListNode curr = head, start = null, end = null, front = null, back = null, temp = null;
    int count = 0, subList = 0;

    while (curr != null) {
      count = 0;
      back =null;
      start = curr;
      temp = curr;

      while (temp != null && count < k) {
        count++;
        temp = temp.next;
      }

      if (count < k) {
        // Change the link to reverse order for the last node
        end.next = curr;
        return head;
      }

      count = 0;

      while (curr != null  && count < k) {
        front = curr.next;
        curr.next = back;

        back = curr;
        curr = front;

        count++;
      }

      subList++;

      if (subList == 1) {
        head = back;
      } else {
        end.next = back;
      }

      end = start;

    }

    return head;
  }
}
