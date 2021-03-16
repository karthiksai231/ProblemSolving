package Problems;

public class TicTacToe {
  int[] rowCounter;
  int[] colCounter;
  int diag;
  int antiDiag;
  int n;

  /** Initialize your data structure here. */
  public TicTacToe(int n) {
    rowCounter = new int[n];
    colCounter = new int[n];
    diag = 0;
    antiDiag = 0;
    this.n = n;
  }

  /** Player {player} makes a move at ({row}, {col}).
   @param row The row of the board.
   @param col The column of the board.
   @param player The player, can be either 1 or 2.
   @return The current winning condition, can be either:
   0: No one wins.
   1: Player 1 wins.
   2: Player 2 wins. */
  public int move(int row, int col, int player) {

    int move = player == 1 ? 1 : -1;
    rowCounter[row] += move;
    colCounter[col] += move;

    if (row == col) {
      diag += move;
    }

    if (row == (n - col - 1)) {
      antiDiag += move;
    }

    if (rowCounter[row] == n ||
        colCounter[col] == n ||
        diag == n ||
        antiDiag == n) {
      return 1;
    } else if (rowCounter[row] == -n ||
        colCounter[col] == -n ||
        diag == -n ||
        antiDiag == -n) {
      return 2;
    }

    return 0;
  }
}

class Game {
  public static void main(String[] args) {
    int res = 0;
    TicTacToe game = new TicTacToe(3);
    res = game.move(0, 0, 1);
    res = game.move(0, 2, 2);
    res = game.move(2, 2, 1);
    res = game.move(1, 1, 2);
    res = game.move(2, 0, 1);
    res = game.move(1, 0, 2);
    res = game.move(2, 1, 1);

    System.out.println(res);
  }
}
