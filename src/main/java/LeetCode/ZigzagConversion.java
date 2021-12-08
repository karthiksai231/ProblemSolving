package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class ZigzagConversion {

  public static void main(String[] args) {
    System.out.println(convert("PAYPALISHIRING", 3));
  }
  public static String convert(String s, int numRows) {
    if (s.length() <= 1) {
      return s;
    }

    List<String> res = new ArrayList<>();

    for (int i = 0; i < numRows; i++) {
      res.add("");
    }

    int row = 0, step = 1;
    for (char c: s.toCharArray()) {
      res.set(row, res.get(row) + c);

      if (row == 0) {
        step = 1;
      } else if (row == numRows - 1) {
        step = -1;
      }

      row += step;
    }

    StringBuilder builder = new StringBuilder();

    for (String str : res) {
      builder.append(str);
    }

    return builder.toString();
  }
}
