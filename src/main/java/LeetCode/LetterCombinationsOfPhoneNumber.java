package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {
  Map<String, String> map = new HashMap<String, String>() {{
    put("2", "abc");
    put("3", "def");
    put("4", "ghi");
    put("5", "jkl");
    put("6", "mno");
    put("7", "pqrs");
    put("8", "tuv");
    put("9", "wxyz");
  }};
  public List<String> letterCombinations(String digits) {
    List<String> res = new ArrayList<>();

    if (digits == null || digits.length() == 0) {
      return res;
    }

    helper(res, "", digits);
    return res;
  }

  public void helper(List<String> result, String combination, String digits) {
    if (digits.length() == 0) {
      result.add(combination);
    } else {
      String digit = digits.substring(0, 1);
      String letters = map.get(digit);

      for (int i = 0; i < letters.length(); i++) {
        String letter = letters.substring(i, i + 1);
        helper(result, combination + letter, digits.substring(1));
      }
    }
  }
}
