package LeetCode;

public class ReconstructOriginalWords {

  /*
   z(zero) -> 0
   x(six)  -> 6
   u(four) -> 4
   w(two)  -> 2
   g(eight)-> 8
   f(five+four) -> 5 && 4
   O(one +two + four + zero) -> 1 && 2 && 4 && 0
   t(three + eight + two) -> 3 && 8 && 2
   s(seven + six) -> 7 && 6
   i(nine + five + six + eight) -> 9 && 5 && 6 && 8
   */
  public static String originalDigits(String s) {
    int[] frequency = new int[26];

    for (Character c : s.toCharArray()) {
      frequency[c - 'a']++;
    }

    int[] digit = new int[10];

    digit[0] = frequency['z' - 'a'];
    digit[6] = frequency['x' - 'a'];
    digit[4] = frequency['u' - 'a'];
    digit[2] = frequency['w' - 'a'];
    digit[8] = frequency['g' - 'a'];
    digit[5] = frequency['f' - 'a'] - digit[4];
    digit[1] = frequency['o' - 'a'] - digit[2] - digit[4] - digit[0];
    digit[3] = frequency['t' - 'a'] - digit[8] - digit[2];
    digit[7] = frequency['s' - 'a'] - digit[6];
    digit[9] = frequency['i' - 'a'] - digit[5] - digit[6] - digit[8];

    StringBuilder builder = new StringBuilder("");
    for (int i = 0; i < 10; i++) {
      int f = digit[i];
      while (f > 0) {
        builder.append(i);
        f--;
      }
    }

    return builder.toString();
  }
}
