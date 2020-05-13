import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

public class CriticalNetworks {

  static int count = 1;

  public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    List<List<Integer>> res = new ArrayList<>();
    for (List<Integer> connection: connections) {
      //Add the Connection to the graph
      addConnectionToTheGraph(map, connection.get(0), connection.get(1));
      addConnectionToTheGraph(map, connection.get(1), connection.get(0));
    }

    int[] visited = new int[n];
    int[] lows = new int[n];
    int[] parents = new int[n];

    Arrays.fill(parents, -1);

    for (int i = 0; i < n; i++) {
      if (visited[i] > 0) {
        continue;
      }
      // dfs
      dfs(i, map, visited, lows, parents, res);
    }

    return res;
  }

  public static void dfs(int node, Map<Integer, List<Integer>> map, int[] visited, int[] lows, int[] parent,
      List<List<Integer>> res) {
    if (visited[node] > 0) {
      return;
    }

    visited[node] = count;
    lows[node] = count;
    count++;

    for (int child : map.get(node)) {
      // Child should not go to the parent
      if (parent[node] == child) {
        continue;
      }

      // The current node low should be the lower value of current low vs the child low
      if (visited[child] > 0 && child != parent[node]) {
        lows[node] = Math.min(lows[node], lows[child]);
      }

      // If the node is already discovered continue
      if (visited[child] > 0) {
        continue;
      }

      // Since we have just discovered the node mark the parent for the current node
      parent[child] = node;

      dfs(child, map, visited, lows, parent, res);

      // Critical Network
      if (lows[child] > visited[node]) {
        List<Integer> list = new ArrayList<>();
        list.add(node);
        list.add(child);
        res.add(list);
      }

      lows[node] = Math.min(lows[node], lows[child]);
    }

  }

  public static void addConnectionToTheGraph(Map<Integer, List<Integer>> map, int node1, int node2) {
    List<Integer> nextNeighbours = map.getOrDefault(node1, new ArrayList<>());
    nextNeighbours.add(node2);
    map.put(node1, nextNeighbours);
  }

  public static void main(String[] args) {
    List<List<Integer>> list = asList(
        asList( 0, 1 ),
        asList( 1, 2 ),
        asList( 2, 0 ),
        asList(1, 3));
    criticalConnections(4, list);
  }
}
