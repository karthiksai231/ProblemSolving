package LeetCode;

public class StringToInteger {
  public int myAtoi(String str) {
    long number = 0;
    int i = 0, sign = 1;
    int len = str.length();
    if (str == null || str.length() == 0) {
      return (int) number;
    }

    char[] cArr = str.toCharArray();

    while (i < len && cArr[i] == ' ') {
      i++;
    }

    if (i < len) {
      if (cArr[i] == '-') {
        i++;
        sign = -1;
      } else if (cArr[i] == '+') {
        i++;
      }
    }

    while (i < len && cArr[i] >= '0' && cArr[i] <= '9') {
      number = number * 10 + (cArr[i] - '0');

      if (sign * number > Integer.MAX_VALUE) {
        return Integer.MAX_VALUE;
      }

      if (sign * number < Integer.MIN_VALUE) {
        return Integer.MIN_VALUE;
      }
      i++;
    }
    return (int) (sign * number);
  }
}
