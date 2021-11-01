import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class StringProblem {
  public static void main(String[] args) {
    String input = "Hrishikesh Kochikar";
    getNonRepetitiveCharacter(input);
  }

  private static void getNonRepetitiveCharacter(String input) {
    // Map<String, Integer> map = new HashMap<>();
    int [] count = new int[26];
    input = input.toLowerCase();

    for (int i = 0; i < input.length(); i++) {
      if (input.charAt(i) == ' ') {
        continue;
      }
      int val = input.charAt(i) - 'a';
      count[val]++;
    }

    for (int i = 0; i < input.length(); i++) {
      if (input.charAt(i) == ' ') {
        continue;
      }
      int idx = input.charAt(i) - 'a';
      if (count[idx] == 1) {
        System.out.println(input.charAt(i));
        return;
      }
    }

    System.out.println("-1");
  }
}
