package Problems;

import java.util.ArrayList;
import java.util.List;

public class ParanthesisGenerator {

  public static void generator(List<String> arr, String cStr, int open, int close, int max) {
    if (cStr.length() == max*2) {
      arr.add(cStr);
      return;
    }

    if (open < max) {
      generator(arr, cStr + "(", open + 1, close, max);
    }

    if (close < open) {
      generator(arr, cStr + ")", open, close + 1, max);
    }
  }

  public static void main(String[] args) {
    List<String> arr = new ArrayList<>();
    generator(arr, "", 0, 0, 3);
    System.out.println(arr.toString());
  }
}
