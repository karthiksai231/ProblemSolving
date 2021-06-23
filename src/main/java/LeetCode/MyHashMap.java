package LeetCode;

public class MyHashMap {
  ListNode[] nodes = new ListNode[10000];

  private class ListNode {
    int key;
    int value;
    ListNode next;
    ListNode(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }
  public MyHashMap() {

  }

  public int get(int key) {
    int index = getIndex(key);
    ListNode prev = findElement(index, key);
    return prev.next == null ? -1 : prev.next.value;
  }

  public void put(int key, int value) {
    int index = getIndex(key);
    ListNode prev = findElement(index, key);

    if (prev.next == null) {
      prev.next = new ListNode(key, value);
    } else {
      prev.next.value = value;
    }
  }

  private int getIndex(int key) {
    return Integer.hashCode(key) % nodes.length;
  }

  private ListNode findElement(int index, int key) {
    if (nodes[index] == null) {
      return nodes[index] = new ListNode(-1, -1);
    }

    ListNode prev = nodes[index];

    while (prev.next != null && prev.next.key != key) {
      prev = prev.next;
    }

    return prev;
  }

  public void remove(int key) {
    int index = getIndex(key);
    ListNode prev = findElement(index, key);

    if (prev.next != null) {
      prev.next = prev.next.next;
    }
  }
}
