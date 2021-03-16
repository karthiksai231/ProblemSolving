package Problems;

import java.util.ArrayDeque;
import java.util.Queue;

public class BasicCalculator {
  public static int getSum(String s) {
    Queue<Character> q = new ArrayDeque<>();

    for (char c:
    s.toCharArray()) {

      if (c != ' ') {
        q.add(c);
      }
    }

    // We are adding this as a place holder because we have to calculate the last total for the last operation
    /*
    0 + 3 + 2  (0 -> placeholder)

    prev num sum prev op
    0     0   0   +
          3
    3     0   0   +
          2         (If we end here prev is 3 and sum is 0 which is wrong so add a placeholder)
    2         3
    */
    q.add(' ');

    return helper(q);
  }

  public static int helper(Queue<Character> q) {
    int num = 0;
    int prev = 0, sum = 0;
    char prevOp = '+';

    while (!q.isEmpty()) {
      Character c = q.poll();

      if (c >= '0' && c <= '9') {
        num = num * 10 + c - '0';
      } else if (c == '(') {
        num = helper(q);
      } else {
        switch (prevOp) {
          case '+' :
            sum += prev;
            prev = num;
            break;
          case '-':
            sum += prev;
            prev = -num;
            break;
          case '*':
            prev *= num;
            break;
          case '/':
            prev /= num;
            break;
        }

        if (c == ')') {
          break;
        }

        num = 0;
        prevOp = c;
      }
    }

    return sum + prev;
  }

  public static void main(String[] args) {
    System.out.println(getSum("(1+(4+5+2)-3)+(6+8)"));
  }
}
