package LeetCode;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
  PriorityQueue<Integer> minHeap;
  PriorityQueue<Integer> maxHeap;

  public MedianFinder() {
    minHeap = new PriorityQueue<>();
    maxHeap = new PriorityQueue<>(Collections.reverseOrder());

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
    PriorityQueue<Integer> biggerHeap = maxHeap.size() > minHeap.size() ? maxHeap :
        minHeap;
    PriorityQueue<Integer> smallerHeap = minHeap.size() > maxHeap.size() ? minHeap :
        maxHeap;

    if (biggerHeap.size() - smallerHeap.size() >= 2) {
      smallerHeap.add(biggerHeap.poll());
    }
  }

  public double findMedian() {
    PriorityQueue<Integer> biggerHeap = maxHeap.size() > minHeap.size() ? maxHeap :
        minHeap;
    PriorityQueue<Integer> smallerHeap = minHeap.size() > maxHeap.size() ? minHeap :
        maxHeap;
    if (biggerHeap.size() == smallerHeap.size()) {
      return (biggerHeap.peek() + smallerHeap.peek())/2.0;
    } else {
      return biggerHeap.peek();
    }
  }
}
