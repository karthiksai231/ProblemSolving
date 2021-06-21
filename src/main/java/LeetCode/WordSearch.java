package LeetCode;

public class WordSearch {
  public boolean exist(char[][] board, String word) {
    if ((board == null || board.length == 0) && word != null) {
      return false;
    }

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == word.charAt(0) && dfs(board, i, j, 0, word)) {
          return true;
        }
      }
    }
    return false;
  }

  public boolean dfs(char[][] board, int row, int column, int index, String word) {
    if (word.length() == index) {
      return true;
    }

    if (row < 0 ||
    row >= board.length ||
    column < 0 ||
    column >= board[row].length ||
    board[row][column] != word.charAt(index)) {
      return false;
    }

    char temp = board[row][column];
    board[row][column] = ' ';
    boolean flag = dfs(board, row + 1, column, index + 1, word) ||
        dfs(board, row - 1, column, index + 1, word) ||
        dfs(board, row, column + 1, index + 1, word) ||
        dfs(board, row, column - 1, index + 1, word);

    board[row][column] = temp;
    return flag;
  }
}
