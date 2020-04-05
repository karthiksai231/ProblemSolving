import java.util.Arrays;

public class ReshapeMatrix {
    public static int[][] reshapeGivenMatrix(int[][] m, int x, int y) {
        int i = 0;
        int j = 0;

        int[][] res = new int[x][y];

        if (x * y != m[0].length * m.length) {
            return null;
        }

        for(int[] row : m) {
            for(int cell : row) {
                res[i][j] = cell;

                j += 1;

                if (j >= y) {
                    i += 1;
                    j = 0;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Arrays.stream(reshapeGivenMatrix(new int[][] {{1, 2}, {3, 4}}, 1, 4)).forEach(row -> System.out.println(Arrays.toString(row)));
    }
}
