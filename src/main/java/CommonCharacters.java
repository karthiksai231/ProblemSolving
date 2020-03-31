import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonCharacters {
    public static List<Character> commonChars(String[] strArr) {
        List<String> newStr = new ArrayList<>();

        for (String s:
             strArr) {
            newStr.add(removeDuplicates(s));
        }

        Map<Character, Integer> map = new HashMap<>();

        for (char c:
             newStr.get(0).toCharArray()) {
            map.put(c, 1);
        }

        for(int i = 1; i < newStr.size(); i++) {
            char[] newStrArray = newStr.get(i).toCharArray();
            for (char c:
                 newStrArray) {
                if (map.containsKey(c)) {
                    int value = map.get(c) + 1;
                    map.replace(c, value);
                }
            }
        }

        List<Character> result = new ArrayList<>();
        map.entrySet().stream().filter(x -> x.getValue() == newStr.size()).forEach((val) -> result.add(val.getKey()));

        return result;
    }

    public static String removeDuplicates(String str) {
        List<Character> map = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for(char c : str.toCharArray()) {
            if(!map.contains(c)) {
                map.add(c);
            }
        }

        map.stream().forEach((val) -> sb.append(val));
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(commonChars(new String[] {"googlee", "faceebook", "yooooeeeeutubee"}));
    }
}
