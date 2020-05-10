import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchAutoComplete {
  // Implementing Trie Structure
  class TrieNode implements Comparable<TrieNode> {
    TrieNode[] children;
    String s;
    int times;
    List<TrieNode> hotList;

    public TrieNode() {
      children = new TrieNode[128];
      s = null;
      times = 0;
      hotList = new ArrayList<>();
    }

    @Override
    public int compareTo(TrieNode o) {
      if (this.times == o.times) {
        return this.s.compareTo(o.s);
      }
      return o.times - this.times;
    }

    public void update(TrieNode node) {
      if (!this.hotList.contains(node)) {
        this.hotList.add(node);
      }

      Collections.sort(hotList);

      if (hotList.size() > 3) {
        hotList.remove(hotList.size() - 1);
      }
    }
  }

  TrieNode root;
  TrieNode curr;
  StringBuilder sb;

  public SearchAutoComplete(String[] sentence, int[] times) {
    root = new TrieNode();
    curr = root;
    sb = new StringBuilder();

    for (int i = 0; i < times.length; i++) {
      add(sentence[i], times[i]);
    }
  }

  public void add(String sentence, int t) {
    TrieNode temp = root;
    List<TrieNode> visited = new ArrayList<>();

    for(char c : sentence.toCharArray()) {
      if (temp.children[c] == null) {
        temp.children[c] = new TrieNode();
      }

      temp = temp.children[c];
      visited.add(temp);
    }

    temp.s = sentence;
    temp.times += t;

    for (TrieNode n : visited) {
      n.update(temp);
    }
  }

  public List<String> input(char c) {
    List<String> res = new ArrayList<>();
    if (c == '#') {
      add(sb.toString(), 1);
      sb = new StringBuilder();
      curr = root;
      return res;
    }

    sb.append(c);
    if (curr != null) {
      curr = curr.children[c];
    }

    if (curr == null) return res;
    for (TrieNode node : curr.hotList) {
      res.add(node.s);
    }

    return res;
  }
}
