package LeetCode;

public class FindCelebrity {
  public int findCelebrity(int n) {
    int candidate = 0;

    for (int i = 1; i < n; i++) {
      if (knows(candidate, i)) {
        candidate = i;
      }
    }

    for (int i = 0; i < n; i++) {
      if (i == candidate) {
        continue;
      }

      if (!knows(i, candidate) || knows(candidate, i)) {
        return -1;
      }
    }
    return candidate;
  }

  private boolean knows (int a, int b) {
    return true;
  }
}
