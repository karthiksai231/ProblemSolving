package LeetCode;

public class IntegerToEnglishWords {
  public static String numberToWords(int num) {
    if (num == 0) {
      return "Zero";
    }

    int billion = num/1000000000;
    int million = (num - billion * 1000000000)/1000000;
    int thousand = (num - billion * 1000000000 - million * 1000000)/1000;
    int rest = num - thousand * 1000 - billion * 1000000000 - million * 1000000;

    StringBuilder sb = new StringBuilder();

    //logic
    if (billion != 0) {
      sb.append(three(num));
      sb.append("Billion");
    }

    if (million != 0) {
      if (sb != null && !sb.toString().equals("")) {
        sb.append(" ");
      }
      sb.append(three(num));
      sb.append("Million");
    }

    if (thousand != 0 ) {
      if (sb != null && !sb.toString().equals("")) {
        sb.append(" ");
      }
      sb.append(three(num));
      sb.append("Thousand");
    }

    if (rest != 0 ) {
      if (sb != null && !sb.toString().equals("")) {
        sb.append(" ");
      }
      sb.append(three(num));
    }

    return sb.toString();
  }

  public static String ones(int n) {
    switch (n) {
      case 1: return "One";
      case 2: return "Two";
      case 3: return "Three";
      case 4: return "Four";
      case 5: return "Five";
      case 6: return "Six";
      case 7: return "Seven";
      case 8: return "Eight";
      case 9: return "Nine";
    }
    return "";
  }

  public static String teens(int n) {
    switch (n) {
      case 10: return "Ten";
      case 11: return "Eleven";
      case 12: return "Twelve";
      case 13: return "Thirteen";
      case 14: return "Fourteen";
      case 15: return "Fifteen";
      case 16: return "Sixteen";
      case 17: return "Seventeen";
      case 18: return "Eighteen";
      case 19: return "Nineteen";
    }
    return "";
  }

  public static String tens(int n) {
    switch (n) {
      case 20: return "Twenty";
      case 30: return "Thirty";
      case 40: return "Forty";
      case 50: return "Fifty";
      case 60: return "Sixty";
      case 70: return "Seventy";
      case 80: return "Eighty";
      case 90: return "Ninety";
    }
    return "";
  }

  public static String two(int n) {
    if (n == 0) {
      return "";
    } else if (n < 10) {
      return ones(n);
    } else if (n < 20) {
      return teens(n);
    } else {
      int t = n/10;
      int res = n - t * 10;

      if (res != 0) {
        return tens(t) + " " + ones(res);
      } else {
        return tens(t);
      }
    }
  }

  public static String three(int n) {
    int h = n/100;
    int res = n - h * 100;
    String result = "";

    if (h * res != 0) {
      result  = ones(h) + " " + two(res);
    } else if (h == 0 && res != 0 ){
      result = two(res);
    } else if (h != 0 && res == 0) {
      result = ones(h) + " " + "Hundred";
    }

    return result;
  }
}
