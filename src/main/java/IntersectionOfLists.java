import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfLists {
    public static List<Integer> getResultList(int[] list1, int[] list2, int[] list3) {
        int len1 = list1.length;
        int len2 = list2.length;
        int len3 = list3.length;
        int idx1, idx2, idx3;
        idx1 = idx2 = idx3 = 0;
        List<Integer> list = new ArrayList<>();

        while(idx1 < len1 && idx2 < len2 && idx3 < len3) {
            if (list1[idx1] == list2[idx2] && list2[idx2] == list3[idx3]) {
                list.add(list1[idx1]);
                idx1++;
                idx2++;
                idx3++;
                continue;
            }

            int tempMax = Math.max(list1[idx1], list2[idx2]);
            int finalMax = Math.max(tempMax, list3[idx3]);

            while (list1[idx1] < finalMax){
                idx1++;
            }

            while (list2[idx2] < finalMax) {
                idx2++;
            }

            while (list3[idx3] < finalMax) {
                idx3++;
            }
        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println(getResultList(new int[] {1,2,3,4}, new int[] {2,4,6,8}, new int[] {3,4,5}));
    }
}
