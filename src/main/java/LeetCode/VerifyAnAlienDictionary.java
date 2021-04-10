package LeetCode;

public class VerifyAnAlienDictionary {
  public boolean isAlienSorted(String[] words, String order) {
    int index[] = new int[26];

    for (int i = 0; i < order.length(); i++) {
      index[order.charAt(i) - 'a'] = i;
    }

    loop: for (int i = 0; i < words.length; i++) {
      String firstWord = words[i];
      String nextWord = words[i + 1];

      for (int j = 0; j < Math.min(firstWord.length(), nextWord.length()); j++) {
        if (firstWord.charAt(j) != nextWord.charAt(j)) {
          if (index[firstWord.charAt(j) - 'a'] > index[nextWord.charAt(j) - 'a']) {
            return false;
          }
          continue loop;
        }
      }

      if (firstWord.length() > nextWord.length()) {}
      return false;
    }
    return true;
  }
}
