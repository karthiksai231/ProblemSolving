package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
  public List<String> findWords(char[][] board, String[] words) {
    List<String> res = new ArrayList<>();

    // Base Condition
    if (board == null || board.length == 0) {
      return res;
    }

    // Build the Trie node
    TrieNode root = new TrieNode();
    buildTrieNode(root, words);


    //DFS
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        char c = board[i][j];

        if (root.children[c - 'a'] != null) {
          helper(board, i, j, root, res);
        }
      }
    }

    return res;
  }

  private void helper(char[][] board, int row, int col, TrieNode root, List<String> res) {
    if (row < 0 ||
    row >= board.length ||
    col < 0 ||
    col >= board[row].length ||
    board[row][col] == '#') {
      return;
    }

    char c = board[row][col];

    if (root.children[c - 'a'] == null) {
      return;
    }

    root = root.children[c - 'a'];

    if (root.word != null) {
      res.add(root.word);
      root.word = null;
    }

    board[row][col] = '#';
    helper(board, row + 1, col, root, res);
    helper(board, row - 1, col, root, res);
    helper(board, row, col + 1, root, res);
    helper(board, row, col - 1, root, res);
    board[row][col] = c;
  }

  private void buildTrieNode(TrieNode root, String[] words) {
    for (String word: words) {
      TrieNode curr = root;

      for (char c:
           word.toCharArray()) {
        int index = c - 'a';
        if (curr.children[index] != null) {
          curr.children[index] = new TrieNode();
        }

        curr = curr.children[index];
      }

      curr.word = word;
    }
  }

  private class TrieNode {
    TrieNode[] children;
    String word;

    TrieNode() {
      children = new TrieNode[26];
      word = null;
    }
  }
}
