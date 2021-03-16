package Problems;

import java.util.ArrayList;
import java.util.List;

public class ShortestDistanceToCharacter {
    public static List<Integer> getShortestDistToChar(String str, char targetChar) {
        List<Integer> targetIndexes = new ArrayList<>();
        List<Integer> resultList = new ArrayList<>();

        for(int i =0; i< str.length(); i++) {
            if (str.charAt(i) == targetChar) {
                targetIndexes.add(i);
            }
        }

        for(int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == targetChar) {
                resultList.add(0);
            } else {
                int currentMin = Math.abs(targetIndexes.get(0) - i);
                for (int t:
                     targetIndexes) {
                    int value = Math.min(currentMin, Math.abs(t-i));
                    currentMin = value;
                }
                resultList.add(currentMin);
            }
        }
        return  resultList;
    }

    public static void main(String[] args) {
        System.out.println(getShortestDistToChar("helloworld", 'l'));
    }
}
