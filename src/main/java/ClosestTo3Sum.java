import java.lang.reflect.Array;
import java.util.*;

public class ClosestTo3Sum {
    public static List<Integer> getClosest3SumIndex(int[] n, int target) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(n);
        int closest = n[0] + n[1] + n[2];
        res.add(0, n[0]);
        res.add(1, n[1]);
        res.add(2, n[2]);
        for(int i = 0; i < n.length-2; i++) {
            int l = i + 1;
            int r = n.length-1;

            while (l < r) {
                int sum = n[i] + n[l] + n[r];

                if (sum == target) {
                    res.set(0, n[i]);
                    res.set(1, n[l]);
                    res.set(2, n[r]);

                    return res;
                }

                if(Math.abs(target - sum) < Math.abs(target - closest)) {
                    closest = sum;
                    res.set(0, n[i]);
                    res.set(1, n[l]);
                    res.set(2, n[r]);
                }

                if(sum < target) {
                    l += 1;
                } else {
                    r -= 1;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(getClosest3SumIndex(new int[] {2, 1, -5, 4}, 1).toString());
        strStr("hello", "ll");
    }

    public static int strStr(String haystack, String needle) {
        int needleLen = needle.length();
        int hayLength = haystack.length();
        int hayPtr = 0;
        int limit = hayLength - needleLen + 1;

        while (hayPtr < limit) {
            while (hayPtr < limit && haystack.charAt(hayPtr) != needle.charAt(0)) {
                hayPtr++;
            }

            int needlePtr = 0; int currLen = 0;

            while (hayPtr < hayLength &&
                needlePtr < needleLen &&
                haystack.charAt(hayPtr) == needle.charAt(needlePtr)) {
                hayPtr++;
                needlePtr++;
                currLen++;
            }

            if (currLen == needleLen) {
                return hayPtr - needleLen;
            }

            hayPtr = hayPtr - currLen + 1; // +1 because we have to increment the counter
        }

        return 0;
    }
}
