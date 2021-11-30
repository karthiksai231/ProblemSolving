import java.util.Arrays;

public class CiscoProblem {
  public static void main (String[] args) {
    /* code */
    System.out.println(getReverseString(""));
  }
  public static String getReverseString(String input) {
    if (input == null) {
      return "";
    }

    if (input.length() == 1) {
      return input;
    }

    int l = 0, r = input.length() - 1;
    char[] cArr = input.toCharArray();

    while (l < r) {
      if (!Character.isLetterOrDigit(cArr[l])) {
        l++;
        continue;
      }

      if (!Character.isLetterOrDigit(cArr[r])) {
        r--;
        continue;
      }

      char temp = cArr[l];
      cArr[l] = cArr[r];
      cArr[r] = temp;
      l++;
      r--;
    }

    StringBuilder stringBuilder = new StringBuilder();

    for (Character c: cArr
         ) {
      stringBuilder.append(c);
    }

    return stringBuilder.toString();

  }
}
