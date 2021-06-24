package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AccountsMerge {
  public static List<List<String>> mergeAccounts(List<List<String>> accounts) {
    List<List<String>> result = new ArrayList<>();

    if (accounts == null || accounts.size() == 0) {
      return result;
    }

    Map<String, String> names = new HashMap<>(); // emails -> username
    Map<String, Set<String>> map = new HashMap<>(); // email -> neighbours
    Set<String> emails = new HashSet<>();

    for (List<String> account : accounts) {
      String name = account.get(0);

      for (int i = 1; i < account.size(); i++) {
        String email = account.get(i);
        emails.add(email);
        names.put(email, name);
        map.putIfAbsent(email, new HashSet<String>());

        if (i == 1) {
          continue;
        }

        // build edge between two adjacent nodes
        map.get(account.get(i - 1)).add(email);
        map.get(email).add(account.get(i - 1));
      }
    }

      Set<String> visited = new HashSet<>();
      for (String s:
           emails) {
        if (!visited.contains(s)) {
          visited.add(s);
          List<String> buffer = new ArrayList<>();
          buffer.add(s);
          helper(s, map, visited, buffer);
          Collections.sort(buffer);
          buffer.add(0, names.get(s));
          result.add(buffer);
        }
      }
    return result;
  }

  public static void helper(String s, Map<String, Set<String>> map, Set<String> visited, List<String> buffer) {
    for (String node:
         map.get(s)) {
      if (!visited.contains(node)) {
        visited.add(node);
        buffer.add(node);
        helper(node, map, visited, buffer);
      }
    }
  }

  public static void main(String[] args) {
    List<List<String>> acc = List.of(
        List.of("John","johnsmith@mail.com","john_newyork@mail.com"),
            List.of("John","johnsmith@mail.com","john00@mail.com"),
            List.of("Mary","mary@mail.com"),
            List.of("John","johnnybravo@mail.com"));
    mergeAccounts(acc);
  }
}
