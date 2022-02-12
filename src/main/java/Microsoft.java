import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Microsoft {
  /*
  Given an array of integers, find a pair whose sum is X

Sample input:  array = {1, -2, 3, 0, 4, -2, 1}, X =-4
Expected Output: {-2,-2}
   */

  /*
  Let's say you're given a singly linked list as input, create a method that returns a reordered list with group of all the nodes with odd indices together followed by the nodes with even indices.

first node is odd, and the second node is even, and so on.

Input:
1 -> 2 -> 3 -> 4 -> 5

Ans:
1 -> 3 -> 5 -> 2 -> 4
   */

  public static void main(String[] args) {
    System.out.println(getPair(new int[] {1, -2, 0, 4, -2, 1, -2, -2}, -4));
    //String s = getCleanString("ab#c");
    printString();

    Node n = new Node(1);
//    n.next = new Node(2);
//    n.next.next = new Node(3);
//    n.next.next.next = new Node(4);
//    n.next.next.next.next = new Node(5);
//    getOddEvenIndices(n);

    //familySeats(2, "1A 2F 1C");
    LSB(77, 4);
  }


  public static List<List<Integer>> getPair(int[] arr, int x) {
    if (arr == null || arr.length <= 1) {
      System.out.println("Invalid array");
      return null;
    }

    if (arr.length == 2) {
      int sum = arr[0] + arr[1];
      if (sum == x) {
        return List.of(List.of(arr[0], arr[1]));
      }

      System.out.println("Invalid array");
      return null;
    }

    HashMap<Integer, Integer> map = new HashMap<>();
    List<List<Integer>> res = new ArrayList<>();

    for (int i = 0; i < arr.length; i++) {
      map.put(arr[i], i);
    }

    HashMap<Integer, Integer> map1 = new HashMap<>();

    for (int i = 0; i < arr.length; i++) {
      map1.put(arr[i], map1.getOrDefault(arr[i], 0) + 1);
    }

    for (int i = 0; i < arr.length; i++) {
      int otherNumber = x - arr[i];

//      if (map.containsKey(otherNumber) && map.get(otherNumber) != i) {
//        return List.of(i, map.get(otherNumber));
//      }

      if (map1.containsKey(otherNumber) && map1.get(otherNumber) > 0) {
        res.add(List.of(arr[i], otherNumber));
        map1.put(otherNumber, map1.get(otherNumber) - 1);
      }
    }

    // System.out.println("Target number doesn't exist in the array");
    return res;

  }

  static class Node {
    int val;
    Node next;

    Node (int val) {
      this.val = val;
    }
  }

  /*
   index = 3
   oddHead = 1 , 3
   oddTail= 3
   evenHead =
   evenTail =
   */

  /*
  Space Complexity: O(1)
  Time Complexity: O(n) where n is the length of the linked list
   */

  public static Node getOddEvenIndices(Node head) {

    // Base Conditions
    if (head == null || head.next == null) {
      return head;
    }

    Node oddHead = null, evenHead = null, oddTail = null, evenTail = null;
    Node curr = head;
    int i = 1;

    while (curr != null) {
      // Generate all the odd indices
      if (i%2 == 1) {
        if (oddHead == null) {
          oddHead = curr;
          oddTail = curr;
        } else {
          oddTail.next = curr;
          oddTail = oddTail.next;
        }
      } else { // Generate all the even indices
        if (evenHead == null) {
          evenHead = curr;
          evenTail = curr;
        } else {
          evenTail.next = curr;
          evenTail = evenTail.next;
        }
      }

      curr = curr.next;
      i++;
    }
    evenTail.next = null;
    oddTail.next = evenHead;

    return oddHead;
  }

  public static String getCleanString(String str) {
    StringBuilder sb = new StringBuilder();

    char[] carr = str.toCharArray();

    for (int i = 0 ; i < str.length(); i++) {
      if (str.charAt(i) == '#') {
        sb.deleteCharAt(sb.length() - 1);
        continue;
      }
      sb.append(str.charAt(i));
    }

    return sb.toString();
  }

  public static void printString() {
    String s = "abcdefghijklmnopqrstuvwxyz       ";
    StringBuilder builder = new StringBuilder();

    for (int i = 0; i < 100; i++) {
      int idx = (int) (s.length() * Math.random());
      builder.append(s.charAt(idx));
    }

    String[] sArr = builder.toString().trim().split(" +");
    List<String> list = new ArrayList<>();
    HashSet<Character> set;

    for (String str:
         sArr) {
      set = new HashSet<>();
      char[] carr = str.toCharArray();

      for (Character c:
           carr) {
        if (set.contains(c)) {
          break;
        }
        set.add(c);
      }

      if (carr.length == set.size()) {
        list.add(str);
      }
    }

    System.out.println(list.toString());

    boolean flag = true;
    int countIdx = 0;
    int counter = 0;
    Map<String, Integer> map = new HashMap<>();

    while (flag) {
      String currentWord = list.get(countIdx);

      for (int i = 0; i < list.size(); i++) {
        if (countIdx == i) {
          continue;
        }

        int val = currentWord.indexOf(list.get(i));

        if (val != -1) {
          System.out.println("CurrentWord: " + currentWord + " listWord: " + list.get(i));
          map.put(currentWord, map.getOrDefault(currentWord, 0) + 1);
        }
      }

      countIdx++;

      if (countIdx == list.size()) {
        flag = false;
      }
    }

    System.out.println(map);
  }

  public static  int familySeats(int planeRows,String occupiedSeats){
    Map<Integer, String> seatMap = new HashMap<>();
    int countFamilySeats = 0;
    if (occupiedSeats == null || occupiedSeats.isEmpty()) {
      return planeRows * 3;
    }
    //for the Aisles : i have mentioned Z character
    for (int i = 1; i <= planeRows; i++) {
      String myData = new String("ABCZDEFGZHJK");
      seatMap.put(i, myData);
    }
    String[] occupiedSeatsArray = occupiedSeats.split(" ");

    System.out.println(seatMap.size());
    // int i=0;
    for (String occupied : occupiedSeatsArray) {
      char seatRow = occupied.charAt(0);
      char seatName = occupied.charAt(1);
      int row = Character.getNumericValue(seatRow);
      String seatNameCurrent = seatMap.get(row);

      String newSeatName = seatNameCurrent != null ? seatNameCurrent.replace(seatName, 'X') : null;
      System.out.println("Updating : " +newSeatName + " for row " + row);
      seatMap.put(row, newSeatName);
    }

    // AB?|DE?F|HJK
    for (Map.Entry<Integer, String> entry : seatMap.entrySet()) {

      String seatMapWithOccupiedData = entry.getValue();

      if (seatMapWithOccupiedData!=null && seatMapWithOccupiedData.contains("X")) {
        String[] tempSeatName = entry.getValue().split("X");
        for (String combinedSeats : tempSeatName) {
          if (combinedSeats.length() <= 3) {
            continue;
          }
          System.out.println("X is found : " + combinedSeats);
          if (combinedSeats.length() >= 3 && !combinedSeats.contains("Z")) {
            countFamilySeats++;
          } else if (combinedSeats.length() >= 3 && combinedSeats.contains("Z")) {
            String[] temp = combinedSeats.split("Z");
            System.out.println(temp.length);
            for (String t1 : temp) {
              System.out.println("AISLE Separation " + t1);
              if (t1.length() >= 3)
                countFamilySeats++;
            }
          } else {
            System.out.println("This portion is not suitable for family" + combinedSeats);
          }

        }
      } else {
        countFamilySeats += 3;
      }

      System.out.println(" Till this row :"+entry.getKey()+"  family seats allowed :  " + countFamilySeats);

    }
    return countFamilySeats;
  }

  static void LSB(int num, int K)
  {
    boolean x = (num & (1 << (K-1))) != 0;

    //Function call
    if(x)
      System.out.println("1") ;
    else
      System.out.println("0");
  }


}