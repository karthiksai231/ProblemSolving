package LeetCode;

public class StringCompression {
  public static int compress(char[] chars) {
    int result = 0, idx = 0;
    while (idx < chars.length) {
      char currChar = chars[idx];
      int count = 0;
      while (idx < chars.length && chars[idx] == currChar) {
        count++;
        idx++;
      }

      chars[result++] = currChar;

      if (count > 1) {
        // We need array for double digits like '26'
        for (char c :
             Integer.toString(count).toCharArray()) {
          chars[result++] = c;
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(compress(new char[] {'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
  }
}
