package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReorderDataInLogFiles {
  public static String[] reorderLogFiles(String[] logs) {
    List<Log> letterLogs = new ArrayList<>();
    List<String> digitLogs = new ArrayList<>();

    for (String str:
         logs) {
      int idx = str.indexOf(" ");
      String id = str.substring(0, idx);
      String content = str.substring(idx + 1);

      if (Character.isLetter(content.charAt(0))) {
        letterLogs.add(new Log(id, content));
      } else {
        digitLogs.add(str);
      }
    }

    Collections.sort(letterLogs, (a, b) -> a.content.equals(b.content) ? a.id.compareTo(b.id) :
        a.content.compareTo(b.content));

    String [] res = new String[logs.length];
    int counter = 0;

    for (Log l:
         letterLogs) {
      res[counter++] = l.id + " " + l.content;
    }

    for (String s:
         digitLogs) {
      res[counter++] = s;
    }

    return res;
  }

  public static class Log {
    String id;
    String content;

    Log(String id, String content) {
      this.id = id;
      this.content = content;
    }
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(reorderLogFiles(
        new String[] {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"})));
  }
}
