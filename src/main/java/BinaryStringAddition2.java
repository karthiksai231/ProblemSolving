public class BinaryStringAddition2 {
    public static String getValue(String s1, String s2) {
        int l1 = s1.length()-1;
        int l2 = s2.length()-1;
        StringBuilder sb = new StringBuilder();

        int carry = 0;

        while(l1 >= 0 || l2 >= 0) {
            int x = 0;
            int y = 0;

            if (l1 >= 0) {
                x = s1.charAt(l1) - '0';
                l1--;
            }

            if (l2 >= 0) {
                y = s2.charAt(l2) - '0';
                l2--;
            }

            int sum = x + y + carry;

            carry = sum/2;
            sum = sum % 2;
            sb.insert(0, String.valueOf(sum));
        }

        if (carry == 1) {
            sb.insert(0, String.valueOf(1));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getValue("11101", "1011"));
    }
}
