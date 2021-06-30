package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
  public static List<List<String>> groupAnagrams(String[] strs) {
    if (strs == null || strs.length == 0) {
      return  new ArrayList<>();
    }

    Map<String, List<String>> map = new HashMap<>();

    for (String s : strs) {
      char[] cArr = new char[26];

      for(char c : s.toCharArray()) {
        cArr[c - 'a']++;
      }

      String value = String.valueOf(cArr);

      if (!map.containsKey(value)) {
        map.put(value, new ArrayList<>());
      }

      map.get(value).add(s);
    }

    return new ArrayList<>(map.values());
  }

  public static void main(String[] args) {
    groupAnagrams(new String[] {"eat", "tea"});
  }
}
