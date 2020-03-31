import java.util.Stack;

public class RemoveDuplicateCharacters {
    public static String getValue(String str) {
        char[] cArr = str.toCharArray();
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < cArr.length; i++) {
            if (!st.isEmpty()) {
                if (st.peek() == cArr[i]) {
                    st.pop();
                    continue;
                }
            }

            st.push(cArr[i]);
        }

        StringBuilder sb = new StringBuilder();

        st.iterator().forEachRemaining(c -> sb.append(c.toString()));

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getValue("cabd"));
    }

}
