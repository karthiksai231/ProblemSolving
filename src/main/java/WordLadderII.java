import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordLadderII {
  // Add the sub-lists to the result set from the map
  private static void dfs(List<List<String>> result, List<String> subList, String word, String endWord,
      Map<String, List<String>> map) {
    if (word.equals(endWord)) {
      result.add(new ArrayList(subList));
      return;
    }

    if (map.get(word) == null) {
      return;
    }

    for (String w: map.get(word)) {
      subList.add(w);
      dfs(result, subList, w, endWord, map);
      subList.remove(subList.size() - 1);
    }
  }

  // Form the Map for the give set of Words
  private static void bfs(Set<String> startSet, String endWord, Map<String, List<String>> map, Set<String> dict) {

    if (startSet.size() == 0) {
      return;
    }

    Set<String> temp = new HashSet<>();
    dict.removeAll(startSet); // ***Remove all the dict words before start***
    boolean finish = false;

    for (String s : startSet) {
      char[] chars = s.toCharArray();

      for (int i = 0; i < chars.length; i++) {
        char oldChar = chars[i];


        for (char c = 'a'; c <= 'z'; c++) {
          chars[i] = c;
          String word = new String(chars);

          if (dict.contains(word)) {
            if (word.equals(endWord)) {
              finish = true;
            } else {
              temp.add(word);
            }

            if (map.get(s) == null) {
              map.put(s, new ArrayList<>());
            }

            map.get(s).add(word);
          }
        }

        chars[i] = oldChar;
      }
    }

    if (!finish) {
      bfs(temp, endWord, map, dict);
    }
  }

  public static void main(String[] args) {
    String beginWord = "hit";
    String endWord = "cog";
    List<String> wordList = new ArrayList<>();
    wordList.add("hot");
    wordList.add("dot");
    wordList.add("dog");
    wordList.add("lot");
    wordList.add("log");
    wordList.add("cog");
    List<List<String>> result = new ArrayList<>();
    Set<String> dict = new HashSet<>(wordList);

    Map<String, List<String>> map = new HashMap<>();
    Set<String> startSet = new HashSet<>();
    startSet.add(beginWord);
    bfs(startSet, endWord, map, dict);

    List<String> subList = new ArrayList<>();
    subList.add(beginWord);
    dfs(result, subList, beginWord, endWord, map);
  }
}
