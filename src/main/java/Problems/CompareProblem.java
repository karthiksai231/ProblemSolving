package Problems;

public class CompareProblem {
  /*
  import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

interface OnlineAccount {
	int basePrice = 120;
	int regularMoviePrice = 45;
	int exclusiveMoviePrice = 80;
}

class Account implements OnlineAccount, Comparable<Account> {

    int noOfRegularMovies, noOfExclusiveMovies;
    String ownerName;

    // 1) Add a parameterized constructor that initializes the attributes noOfExclusiveMovies and noOfExclusiveMovies.
    Account (String ownerName, int noOfRegularMovies, int noOfExclusiveMovies) {
        this.ownerName = ownerName;
        this.noOfExclusiveMovies = noOfExclusiveMovies;
        this.noOfRegularMovies = noOfRegularMovies;
    }


    // 2. This method returns the monthly cost for the account.
    public int monthlyCost() {
        return basePrice + this.noOfRegularMovies * regularMoviePrice + this.noOfExclusiveMovies * exclusiveMoviePrice;
    }

    // 3. Override the compareTo method of the Comparable interface such that two accounts can be compared based on their monthly cost.
    @Override
    public int compareTo(Account account) {
        return this.monthlyCost() <= account.monthlyCost() ? -1 : 0;
    }

    // 4. Returns "Owner is [ownerName] and monthly cost is [monthlyCost] USD."
    public String toString() {
        return String.format("Owner is %s and monthly cost is %s USD.", this.ownerName, this.monthlyCost());
    }
}

public class Solution {
    public static void main(String args[] ) throws Exception {

  Scanner sc = new Scanner(System.in);
  String sub = sc.nextLine();

  int t = Integer.parseInt(sub);

  ArrayList<Account> list = new ArrayList<Account>();

        for(int i=0; i<t; i++) {
    String[] input = sc.nextLine().split(" ");
    list.add(new Account(input[0],
        Integer.parseInt(input[1]),
        Integer.parseInt(input[2])));
  }

        Collections.sort(list);

        System.out.println("Most valuable account details:");
        System.out.println(list.get(list.size() - 1));
}
}
   */
}
