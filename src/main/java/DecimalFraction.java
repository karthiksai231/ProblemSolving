import java.util.ArrayList;
import java.util.List;

public class DecimalFraction {
    public static void ConvertToDecimalFraction(int numerator, int denominator) {
        int wholePart;
        List<Integer> fraction = new ArrayList<>();
        List<Integer> remainders = new ArrayList<>();
        int repeatingAt;

        wholePart = numerator/denominator;
        numerator = (numerator%denominator)*10;
        repeatingAt = -1;

        while(numerator > 0 && repeatingAt == -1) {
            remainders.add(numerator);
            int fWhole = numerator/denominator;
            numerator = (numerator%denominator)*10;
            fraction.add(fWhole);
            repeatingAt = remainders.indexOf(numerator);
        }

        StringBuilder sb = new StringBuilder(wholePart + ".");

        for(int i = 0; i<fraction.size(); i++) {
            if (repeatingAt == i) {
                sb.append("(");
            }
            sb.append(fraction.get(i));
        }

        if (repeatingAt >= 0) sb.append(")");

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        ConvertToDecimalFraction(1, 6);
    }
}
