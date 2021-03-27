package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
  public static int lengthOfLongestSubstring(String s) {
    if (s.length() == 0) {
      return 0;
    }

    int i = 0;
    int j = 0;
    int max = 0;
    Set<Character> set = new HashSet<>();

    while (j < s.length()) {
      if (!set.contains((s.charAt(j)))) {
        set.add(s.charAt(j));
        max = Math.max(set.size(), max);
      } else {
        set.remove(s.charAt(i));
        i++;
      }
    }
    return max;
  }
}
