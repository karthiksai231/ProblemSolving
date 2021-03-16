package Problems;

import java.util.LinkedList;

public class CourseSchedule {
  public static boolean canFinish(int numCourses, int[][] prerequisites) {

    if (prerequisites.length == 0) {
      return true;
    }

//    if (prerequisites.length == 1 &&
//        prerequisites[0][0] != prerequisites[0][1]) {
//      return  true;
//    }

    int[] inDegree = new int[numCourses];
    int count = 0;

    for (int i = 0; i < prerequisites.length; i++) {
      inDegree[prerequisites[i][0]]++;
    }

    LinkedList<Integer> st = new LinkedList<Integer>();

    for (int i = 0; i < inDegree.length; i++) {
      if (inDegree[i] == 0) {
        st.push(i);
      }
    }

    while (!st.isEmpty()) {
      int curr = st.pop();
      count++;

      for (int i = 0; i < prerequisites.length; i++) {
        if (prerequisites[i][1] == curr) {
          inDegree[prerequisites[i][0]]--;

          if (inDegree[prerequisites[i][0]] == 0) {
            st.push(prerequisites[i][0]);
          }
        }
      }
    }
    return count == numCourses;
  }

  public static void main(String[] args) {
    int[][] arr = new int[4][2];
    arr[0] = new int[] {0, 1};
    arr[1] = new int[] {0, 2};
    arr[2] = new int[] {2, 3};
    arr[3] = new int[] {1, 3};
    System.out.println(canFinish(4, arr));
  }
}
