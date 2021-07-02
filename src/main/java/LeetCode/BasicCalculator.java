package LeetCode;

import java.util.Stack;

public class BasicCalculator {
  public int calculate(String s) {
    int num = 0;
    int sign = 1;
    int res = 0;

    Stack<Integer> st = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      if (Character.isDigit(s.charAt(i))) {
        num = 0;
         while (i < s.length() && Character.isDigit(s.charAt(i))) {
           num = num * 10 + s.charAt(i++) - '0';
         }
         i--;
         res = res + num * sign;
      } else if (s.charAt(i) == '+') {
        sign = 1;
      } else if (s.charAt(i) == '-') {
        sign = -1;
      } else if (s.charAt(i) == '(') {
        st.push(res);
        st.push(sign);

        //Reset the sign and result for next iterations
        sign = 1;
        res = 0;
      } else if (s.charAt(i) == ')') {
        // First is sign the next one is result
        res = res * st.pop() + st.pop();
      }
    }
    return res;
  }
}
