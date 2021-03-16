package Problems;

import java.util.Arrays;

public class PascalTriangle {
    public static int[][] getPascalTriangle(int size) {
        int[][] result = new int[size][];
        result[0] = new int[1];
        result[0][0] = 1;
        result[1] = new int[2];
        result[1][0] = 1;
        result[1][1] = 1;

        for(int i = 2; i < size; i++) {
            result[i] = new int[i+1];
            for(int j = 0; j < i+1; j++) {
                if (j == 0 || j == i) {
                    result[i][j] = 1;
                } else {
                    result[i][j] = result[i -1][j -1]  + result[i-1][j];
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Arrays.stream(getPascalTriangle(5)).forEach(x -> System.out.println(Arrays.toString(x)));
    }
}
