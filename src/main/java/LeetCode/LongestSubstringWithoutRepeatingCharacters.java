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

  public static int lengthOfLongestSubstrings(String s)
  {
    int ans = 0;
    int[] index = new int[128];
    int len = s.length();

    for (int j =0, i=0; j<len;j++){
      i = Math.max(index[s.charAt(j)], i );
      ans = Math.max(ans, j-i+1);
      index[s.charAt(j)] = j+1;
    }
    return ans;
  }

  public static void main(String[] args) {
    lengthOfLongestSubstrings("abcabcbb");
  }
}
