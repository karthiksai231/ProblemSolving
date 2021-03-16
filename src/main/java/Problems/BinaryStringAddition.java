package Problems;

public class BinaryStringAddition {
    public static String getBinaryAddedString(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        int carry  = 0;

        for (int i = s1.length()-1; i >= 0; i--) {
            if(s1.charAt(i) == '1' && s2.charAt(i) == '1') {
                if (carry == 1) {
                    sb.insert(0,'1');
                } else {
                    sb.insert(0,'0');
                }

                carry = 1;
            } else if (s1.charAt(i) == '0' && s2.charAt(i) == '0') {
                if (carry == 1) {
                    sb.insert(0,'1');
                    carry = 0;
                } else {
                    sb.insert(0,'0');
                }
            } else {
                if (carry == 1) {
                    sb.insert(0, '0');
                    carry = 1;
                } else {
                    sb.insert(0, '1');
                }
            }
        }

        if (carry == 1) {
            sb.insert(0, '1');
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getBinaryAddedString("11101", "01011"));
    }
}
