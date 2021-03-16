package Problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class FreqStack {
  static List<Stack<Integer>> list = null;
  static int maxFreq = 0;
  static Map<Integer, Integer> freq = null;

  public FreqStack() {
    list = new ArrayList<>();
    list.add(new Stack<>());
    freq = new HashMap<>();
  }

  public void push(int x) {
    freq.put(x, freq.getOrDefault(x, 0)+1);
    maxFreq = Math.max(maxFreq, freq.get(x));
    if(list.size() == maxFreq)
      list.add(new Stack<Integer>());
    list.get(freq.get(x)).push(x);
  }

  public static int pop() {
    Stack<Integer> maxStack = list.get(maxFreq);
    int x = maxStack.pop();
    freq.put(x, freq.get(x)-1);
    if(maxStack.isEmpty())
      --maxFreq;
    return x;
  }
}

class Test {
  public static void main(String[] args) {
    FreqStack f = new FreqStack();
    f.push(5);
    f.push(7);
    f.push(5);
    f.push(7);
    f.push(4);
    f.push(5);
    System.out.println(f.pop());
    System.out.println(f.pop());
    System.out.println(f.pop());
    System.out.println(f.pop());
  }
}
