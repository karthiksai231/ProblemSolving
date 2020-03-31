import java.util.HashMap;
import java.util.Map;

public class HexaDecimalRepresentation {
    public static String getHexaDecimalNumber(int number) {
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "0");
        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");
        map.put(4, "4");
        map.put(5, "5");
        map.put(6, "6");
        map.put(7, "7");
        map.put(8, "8");
        map.put(9, "9");
        map.put(10, "A");
        map.put(11, "B");
        map.put(12, "C");
        map.put(12, "D");
        map.put(14, "E");
        map.put(15, "F");
        StringBuilder stringBuilder = new StringBuilder();
        int result = 0, remainder = 0;
        result = number/16;
        remainder = number%16;
        stringBuilder.append(map.get(remainder));

        while(result != 0) {
            remainder = result%16;
            result = result/16;
            stringBuilder.append(map.get(remainder));
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println("Hex Number: " + getHexaDecimalNumber(1128));
    }
}
