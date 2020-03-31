import java.util.Arrays;

public class TransposeMatrix {
    public static int[][] getTransposeMatrix(int[][] input) {
        int rows = input.length;
        int columns = input[0].length;
        int[][] result = new int[columns][rows];

        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[j][i] = input[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] res = getTransposeMatrix(new int[][]{{1, 2, 3,}, {4, 5, 6}});
        for(int[] row : res) {
            System.out.println(Arrays.toString(row));
        }
    }
}
