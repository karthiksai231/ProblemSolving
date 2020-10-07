package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class AddTwoNumbers {
  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
      this.val = val;
    }
  }

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode head = new ListNode(0);
    ListNode p = l1, q = l2, curr = head;
    int carry = 0;

    while (p != null || q != null) {
      int x = p != null ? p.val : 0;
      int y = q != null ? q.val : 0;

      int sum = x + y + carry;
      carry = sum/10;

      curr.next = new ListNode(sum % 10);
      curr = curr.next;

      if (p != null) {
        p = p.next;
      }

      if (q != null) {
        q = q.next;
      }
    }

    if (carry > 0) {
      curr.next = new ListNode(carry);
    }

    return head.next;
  }

  public static void main(String[] args) {
    ListNode list1 = buildNode(new ArrayList<Integer>(){{add(2);
    add(4);
    add(3);}});
    ListNode list2 = buildNode(new ArrayList<Integer>(){{add(5);
      add(6);
      add(4);}});

    ListNode res = addTwoNumbers(list1, list2);
    System.out.println(res);
  }

  public static ListNode buildNode(List<Integer> values) {
    ListNode head = new ListNode(-1);
    ListNode curr = head;

    for(int val : values) {
      curr.next = new ListNode(val);
      curr = curr.next;
    }

    return head.next;
  }
}
