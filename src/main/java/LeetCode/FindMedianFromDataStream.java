package LeetCode;

import java.util.PriorityQueue;

public class FindMedianFromDataStream {
  PriorityQueue<Integer> minHeap;
  PriorityQueue<Integer> maxHeap;

  public FindMedianFromDataStream () {
    minHeap = new PriorityQueue<>();
    maxHeap = new PriorityQueue<>();
  }

  public void addNum(int num) {
    if (maxHeap.size() == 0 || num < maxHeap.peek()) {
      maxHeap.add(num);
    } else {
      minHeap.add(num);
    }

    rebalance();
  }

  private void rebalance() {
    PriorityQueue<Integer> smallHeap = maxHeap.size() > minHeap.size() ? minHeap : maxHeap;
    PriorityQueue<Integer> largeHeap = maxHeap.size() > minHeap.size() ? maxHeap : minHeap;

    if (largeHeap.size() - smallHeap.size() >= 2) {
      smallHeap.add(largeHeap.poll());
    }
  }

  public double findMedian() {
    PriorityQueue<Integer> smallHeap = maxHeap.size() > minHeap.size() ? minHeap : maxHeap;
    PriorityQueue<Integer> largeHeap = maxHeap.size() > minHeap.size() ? maxHeap : minHeap;

    if (largeHeap.size() == smallHeap.size()) {
      return (largeHeap.peek() + smallHeap.peek())/2.0;
    } else {
      return largeHeap.peek();
    }
  }
}
