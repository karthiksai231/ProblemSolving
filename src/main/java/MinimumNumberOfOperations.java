public class MinimumNumberOfOperations {
    public static int getMinOperations(int x, int y) {
        int ops = 0;

        while(y > x) {
            if(y%2 == 0) {
                y /= 2;
            } else {
                y -= 1;
            }

            ops += 1;
        }

        ops += x - y;
        return ops;
    }

    public static void main(String[] args) {
        System.out.println(getMinOperations(6, 20));
    }
}
