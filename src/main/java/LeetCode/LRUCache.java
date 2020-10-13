package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
  public static class DLinkedList {
    int key;
    int value;
    DLinkedList prev;
    DLinkedList next;
  }

  static Map<Integer, DLinkedList> cache = new HashMap<>();
  static int size;
  static int capacity;
  static DLinkedList head, tail;

  LRUCache(int capacity) {
    this.size = 0;
    this.capacity = capacity;

    head = new DLinkedList();
    tail = new DLinkedList();

    head.next = tail;
    tail.prev = head;
  }

  public static int get(int key) {
    DLinkedList node = cache.get(key);

    if (node == null) {
      return -1;
    }
    moveToHead(node);
    return node.value;
  }

  public static void put(int key, int value) {
    DLinkedList node = cache.get(key);

    if(node == null) {
      DLinkedList newNode = new DLinkedList();
      newNode.key = key;
      newNode.value = value;

      cache.put(key, newNode);
      addNode(newNode);

      ++size;

      if(size > capacity) {
        DLinkedList popTailNode = popTail();
        cache.remove(popTailNode.key);
        --size;
      }
    } else {
      node.value = value;
      moveToHead(node);
    }
  }

  public static void moveToHead(DLinkedList node) {
    removeNode(node);
    addNode(node);
  }

  public static void addNode(DLinkedList node) {
    node.prev = head;
    node.next = head.next;

    head.next.prev = node;
    head.next = node;
  }

  public static  DLinkedList popTail() {
    DLinkedList res = tail.prev;
    removeNode(res);
    return res;
  }

  public static void removeNode(DLinkedList node) {
    DLinkedList prev = node.prev;
    DLinkedList next = node.next;

    prev.next = next;
    next.prev = prev;
  }
}
