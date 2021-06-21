package LeetCode;

import java.util.Stack;

public class BasicCalculatorII {
  public int calculate(String s) {
    int len;

    if (s == null || (len = s.length()) == 0) {
      return 0;
    }

    Stack<Integer> stack = new Stack<>();
    int num = 0;
    char sign = '+';

    for (int  i = 0; i < len; i++) {
      char currentChar = s.charAt(i);

      if (currentChar >= '0' && currentChar <= '9') {
        num = num * 10 + currentChar - '0';
      }

      if ((!Character.isDigit(currentChar) && ' ' != currentChar) || i == len -1) {
        if (sign == '-') {
          stack.push(-num);
        }
        if (sign == '+') {
          stack.push(num);
        }
        if (sign == '*') {
          stack.push(stack.pop() * num);
        }
        if (sign == '/') {
          stack.push(stack.pop()/num);
        }
        sign = currentChar;
        num = 0;
      }
    }

    int total = 0;
    while (!stack.isEmpty()) {
      total += stack.pop();
    }

    return total;
  }
}
