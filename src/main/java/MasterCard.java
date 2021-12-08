import java.util.List;

public class MasterCard {

  //Input: "50"
  //Output: Number of even and odd numbers

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    getEvenAndOddCount("2486135723");
    long endTime = System.currentTimeMillis();
    long totalTime = endTime - startTime;
    System.out.println("Total time: " +  totalTime + " ms");
  }
  public static List<Integer> getEvenAndOddCount(String input) {

    if (input == null) {
      return List.of(0, 0);
    }

    char[] cArr = input.toCharArray();
    int oddCount = 0, evenCount = 0;

    for (char c: cArr) {
      // Validate if it is a digit
      if (!Character.isDigit(c)) {
        continue;
      }

      int val = c;

      if (val % 2 == 0) {
        evenCount++;
      } else {
        oddCount++;
      }
    }

    System.out.println("EventCount: " + evenCount);
    System.out.println("OddCount: " + oddCount);
    return List.of(evenCount, oddCount);
  }
}


/*
Employee -> Id, name
Employee Salary -> Id, EmpId, Salary

select top 5 e.name, es.salary from Employee as e JOIN  EmployeeSalary as es ON e.if = es.empid ORDER BY es.salary desc;


 */
