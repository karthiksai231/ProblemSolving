package LeetCode;

import java.util.Arrays;

public class NearestPalindrome {

  public static void main(String[] args) {
    System.out.println(nearestPalindrome("123"));
  }
  public static String nearestPalindrome(String n) {
    Long num = Long.parseLong(n);
    Long upperBound = getNextPalindrome(num + 1, true);
    Long lowerBound = getNextPalindrome(num + 1, false);

    if (Math.abs(lowerBound - num) <= Math.abs(upperBound - num)) {
      return String.valueOf(lowerBound);
    }
    return String.valueOf(upperBound);
  }

  public static Long getNextPalindrome(Long limit, boolean direc) {
    int inc = direc ? 1 : -1;
    char[] limitArr = String.valueOf(limit).toCharArray();
    char[] base = limitArr.clone();
    replicate(base);
    for (int i = 0; i < limitArr.length; i++) {
      if ((direc && base[i] > limitArr[i]) || (!direc && base[i] < limitArr[i])) {
        return Long.parseLong(String.valueOf(base));
      } else if ((direc && base[i] < limitArr[i]) || (!direc && base[i] > limitArr[i])) {
        for (int j = (limitArr.length - 1)/2; j >= 0; j++) {
          if (base[j] + inc < '0' || base[j] + inc > '9') {
            base[j] = '0';
          } else {
            base[j] += inc;
            break;
          }
        }

        if (base[0] == '0') {
          char[] temp = new char[base.length - 1];
          Arrays.fill(temp, '9');
          return Long.parseLong(String.valueOf(temp));
        }

        replicate(base);
        return Long.parseLong(String.valueOf(base));
      }
    }

    return Long.parseLong(String.valueOf(base));
  }

  public static void replicate(char[] base) {
    int len = base.length;

    for (int i = 0; i < len/2; i++) {
      base[base.length - 1 - i] = base[i];
    }
  }
}
