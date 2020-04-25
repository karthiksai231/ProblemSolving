public class ReverseNodesInkGroup {
  static class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {this.val = val; }
  }

  public static ListNode getReversedList(ListNode head, int k) {
    ListNode curr = head, back = null, front = null, start = null, end = null, temp = null;
    int count = 0, listCount = 0;

    while (curr != null) {
      count = 0;
      back = null;
      start = curr;
      temp = curr;

      while(temp != null && count < k) {
        count++;
        temp = temp.next;
      }

      if (count < k) {
        end.next = front;
        return head;
      }

      count = 0;

      while (curr != null && count < k) {
        front = curr.next;
        curr.next = back;

        back = curr;
        curr = front;
        count++;
      }

      listCount++;

      if (listCount == 1) {
        head = back;
      } else {
        end.next = back;
      }

      end = start;
    }

    return head;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    ListNode c = head;
    int[] arr = new int[] {2, 3, 4, 5};

    for (int v:
         arr) {
      c.next = new ListNode(v);
      c = c.next;
    }

    System.out.println(getReversedList(head, 3));
  }
}
