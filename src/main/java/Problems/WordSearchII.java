package Problems;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
    public static List<String>  finalWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (board == null || board.length == 0) {
            return res;
        }

        // Initialize the Problems.Trie Structure
        TrieNode root = new TrieNode();
        // Build the Problems.Trie Structure
        buildTrie(root, words);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char c = board[i][j];
                if (root.children[c - 'a'] != null) {
                    dfs(board, i, j, root, res);
                }
            }
        }

        return res;
    }

    private static void dfs(char[][] board, int i, int j, TrieNode curr, List<String> res) {
        if (i < 0 ||
        i >= board.length ||
        j < 0 ||
        j >= board[i].length) {
            return;
        }

        if (board[i][j] == '#') {
            return;
        }

        char c = board[i][j];

        if (curr.children[c - 'a'] == null) {
            return;
        }

        curr = curr.children[c - 'a'];

        if (curr.word != null) {
            res.add(curr.word);
            curr.word = null;
        }

        board[i][j] = '#';
        dfs(board, i + 1, j, curr, res);
        dfs(board, i - 1, j, curr, res);
        dfs(board, i, j + 1, curr, res);
        dfs(board, i, j - 1, curr, res);

        board[i][j] = c;
    }

    public static class TrieNode{
        public TrieNode[] children;
        public String word;

        public TrieNode() {
            children = new TrieNode[26];
            word = null;
        }
    }

    private static void buildTrie(TrieNode root, String[] words) {
        for (String s : words) {
            TrieNode curr = root;

            for (char c : s.toCharArray()) {
                int index = (int) c - 'a';

                if (curr.children[index] == null) {
                    curr.children[index] = new TrieNode();
                }

                curr = curr.children[index];
            }

            curr.word = s;
        }
    }

    public static void main (String[] args) {
        char[][] board = {{'o','a','a','n'},
        {'e','t','a','e'},
        {'i','h','k','r'},
        {'i','f','l','v'}};

        List<String> res = finalWords(board, new String[] {"oath","pea","eat","rain"});
    }
}
