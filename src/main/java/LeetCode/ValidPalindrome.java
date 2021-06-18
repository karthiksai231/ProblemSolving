package LeetCode;

public class ValidPalindrome {
  public boolean isValidPalindrome(String s) {
    if (s == null ||  s.isEmpty()) {
      return false;
    }

    int left = 0, right = s.length() - 1;
    char firstChar, secondChar;

    while (left <= right) {
      firstChar = s.charAt(left);
      secondChar = s.charAt(right);

      if (!Character.isLetterOrDigit(firstChar)) {
        left++;
      } else if (!Character.isLetterOrDigit(secondChar)) {
        right--;
      } else {
        if (Character.toLowerCase(firstChar) != Character.toLowerCase(secondChar)) {
          return false;
        }

        left++;
        right--;
      }
    }
    return true;
  }

//  private static boolean isLetterOrDigit(char c) {
//    return (c >= 'a' && c <= 'z') ||
//        (c >= 'A' && c <= 'Z') ||
//        (c >= '0' && c <= '9');
//  }
}
