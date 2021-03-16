package Problems;

public class RemoveDuplicatesFromSortedList {
  public static int removeDuplicates(int a[]) {
    int counter = 0;

    for (int i = 1; i < a.length; i++) {
      if (a[counter] != a[i]) {
        counter++;
        a[counter] = a[i];
      }
    }

    return counter + 1;
  }

  public static void main(String[] args) {
    System.out.println(removeDuplicates(new int [] {1,2,2,3}));
    //System.out.println(removeDuplicates(new int [] {1,1,2,3,4,4,4,4,4,5,5,6,7,9}));
  }
}
