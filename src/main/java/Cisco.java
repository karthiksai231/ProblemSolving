//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//public class Cisco {
//  public static void main(String[] args) {
//    System.out.println(isValidPalindrome("cidvic"));
//  }
//
//  /*
//  Write an efficient function that checks whether any permutation of an input string is a palindrome
//  Examples:
//"civic" should return True
//"ivicc" should return True
//"civil" should return False
//"livci" should return False
//   */
//
//  public static boolean isValidPalindrome(String input) {
//    // Base condition
//    if (input == null || input.isEmpty()) {
//      return true;
//    }
//
//    int start = 0, end = input.length() - 1;
//    HashMap<Character, Integer> map = new HashMap<>();
//
//    for (char c:
//         input.toCharArray()) {
//      map.put(c, map.getOrDefault(c, 0) + 1);
//    }
//
//    boolean flag = false;
//
//    for (char c: map.keySet()) {
//      if (map.get(c) % 2 == 1) {
//        if (flag) {
//          return false;
//        }
//
//        flag = true;
//      }
//    }
//
//    return true;
//  }
//
//  /*
//  def letterCombinations(letters,count):
//    """
//   :type letters: List[str]
//    :type count: int
//    :rtype: List[str]
//  """
//print(letterCombinations(['r','g'], 1 )) # -> [[‘r’],[‘g’]]/ ['r', 'g']
//print(letterCombinations(['r','g'], 2 )) # -> [[‘r,’r’],[‘g’,’g’],[‘r’,’g’],[‘g’,’r’]]
//print(letterCombinations(['r','g'], 3 )) # -> [[‘r’,’r’,’r’],[‘g’,’g’,’r’],[‘r’,’g’,’r’],[‘g’,’r’,’r’],[‘r’,’r’,’g’],[‘g’,’g’,’g’],[‘g’,’r’,’r’],[‘g’,’r’,’g’]]
//`print(letterCombinations(['r','g'], 3 )) # -> [‘rrr’,‘ggr’,'rgr’,‘grr’,rrg,‘ggg’,‘grr’,‘grg’]`
//   */
//
//  public static List<String> getAllPermutations(List<String> input, int size) {
//    if (size < 1 || input == null) {
//      return new ArrayList<>();
//    }
//
//    List<String> result = new ArrayList<>();
//    StringBuilder builder = new StringBuilder();
//    int count = size;
//
//    if (size == 1) {
//      return  input;
//    }
//
//    while (count < 1) {
//      for (String str:
//           input) {
//
//      }
//    }
//
//  }
//}
