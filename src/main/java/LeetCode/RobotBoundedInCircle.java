package LeetCode;

public class RobotBoundedInCircle {
  public static boolean isBoundedInCircle(String instructions) {
    int x = 0;
    int y = 0;
    String dir = "North";

    /*
        N
    W       E
        S
     */

    for (char c : instructions.toCharArray()) {
      if (c == 'G') {
        if (dir == "North") {
          y++;
        } else if (dir == "South") {
          y--;
        } else if (dir == "East") {
          x++;
        } else {
          x--;
        }
      } else if (c == 'L') {
        if (dir == "North") {
          dir = "West";
        } else if (dir == "South") {
          dir = "East";
        } else if (dir == "East") {
          dir = "North";
        } else {
          dir = "South";
        }
      } else if (c == 'R') {
        if (dir == "North") {
          dir = "East";
        } else if (dir == "South") {
          dir = "West";
        } else if (dir == "East") {
          dir = "South";
        } else {
          dir = "North";
        }
      }
    }

    if (x == 0 && y == 0) {
      return true;
    }

    if (dir.equals("North")) {
      return false;
    }

    return true;
  }
}
