import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShortestDistanceToCharacter2 {
    public static int[] getShortestDistToChar(String str, char targetChar) {
        int[] resultList = new int[str.length()];
        int index = str.length()-1;

        int maxVal = Integer.MAX_VALUE;
        while(index != -1) {
            resultList[index] = maxVal;
            index--;
        }
        int charIndex = maxVal;
        for(int i =0; i< str.length(); i++) {
            if (str.charAt(i) == targetChar) {
                resultList[i] =  0;
                charIndex = i;
            } else if (charIndex != maxVal) {
                resultList[i] = i - charIndex;
            }
        }

        charIndex = maxVal;
        for(int i =str.length()-1; i>= 0; i--) {
            if (str.charAt(i) == targetChar) {
                charIndex = i;
                resultList[i] = 0;
            } else if (charIndex != maxVal) {
                resultList[i] = Math.min(resultList[i], charIndex - i );
            }
        }

        return  resultList;
    }

    public static void main(String[] args) {
        Arrays.stream(getShortestDistToChar("helloworld", 'l')).forEach(
                x -> System.out.println(x)
        );
    }
}
