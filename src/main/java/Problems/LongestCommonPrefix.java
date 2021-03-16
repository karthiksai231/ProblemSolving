package Problems;

public class LongestCommonPrefix {
  public static String getLongestCommonPrefix(String... strArray) {
    String prefix = strArray[0];

    for(int i = 1; i < strArray.length; i++) {
      while (strArray[i].indexOf(prefix) != 0) {
        prefix = prefix.substring(0, prefix.length() -1);

        if (prefix.isEmpty()) {
          return "";
        }
      }
    }

    return prefix;
  }

  public static void main(String[] args) {
    System.out.println(getLongestCommonPrefix(new String[] {"helloworld", "hellokitty", "he"}));
  }
}
