package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
The nice thing about DFS is it tries a path, and if that's wrong (i.e. path does not lead to solution), DFS goes one step back and tries another path. It continues to do so until we've found the correct path (which leads to the solution). You need to always bear this nice feature in mind when utilizing DFS to solve problems.

In this problem, the path we are going to find is an itinerary which:

uses all tickets to travel among airports
preferably in ascending lexical order of airport code
Keep in mind that requirement 1 must be satisfied before we consider 2. If we always choose the airport with the smallest lexical order, this would lead to a perfectly lexical-ordered itinerary, but pay attention that when doing so, there can be a "dead end" somewhere in the tickets such that we are not able visit all airports (or we can't use all our tickets), which is bad because it fails to satisfy requirement 1 of this problem. Thus we need to take a step back and try other possible airports, which might not give us a perfectly ordered solution, but will use all tickets and cover all airports.

Thus it's natural to think about the "backtracking" feature of DFS. We start by building a graph and then sorting vertices in the adjacency list so that when we traverse the graph later, we can guarantee the lexical order of the itinerary can be as good as possible. When we have generated an itinerary, we check if we have used all our airline tickets. If not, we revert the change and try another ticket. We keep trying until we have used all our tickets.
 */

public class ReconstructItinerary {
  public List<String> findItinerary(List<List<String>> tickets) {
    HashMap<String, List<String>> map = new HashMap<>();

    for (List<String> ticket:
         tickets) {
      String from = ticket.get(0);
      String to = ticket.get(1);
      map.putIfAbsent(from, new ArrayList<>());
      map.get(from).add(to);
    }

    for (String airport: map.keySet()) {
      Collections.sort(map.get(airport));
    }

    List<String> result = new ArrayList<>();
    dfs("JFK", map, result);
    return result;
  }

  public boolean dfs(String current, HashMap<String, List<String>> map, List<String> result) {
    // When you have no airports in the map
    if (map.keySet().size() == 0) {
      result.add(current);
      return true;
    } else if (!map.containsKey(current)) {
      return false;
    } // Airport is visited or this airport is not a from airport

    for (int i = 0; i < map.get(current).size(); i++) {
      String to = map.get(current).get(i);
      result.add(current);

      // Remove to airport from the current airport list
      map.get(current).remove(i);

      if (map.get(current).size() == 0) {
        map.remove(current);
      }

      if (dfs(to, map, result)) {
        return true;
      }

      // Restore Map
      map.putIfAbsent(current, new ArrayList<String >());
      map.get(current).add(i, to);

      result.remove(result.size() -1);
    }

    return false;
  }
  // Reference Link: https://leetcode.com/problems/reconstruct-itinerary/discuss/78799/Very-Straightforward-DFS-Solution-with-Detailed-Explanations
}
