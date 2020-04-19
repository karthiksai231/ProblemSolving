public class CompareVersions {
  public static int compareVersion(String version1, String version2) {
    String[] v1 = version1.split("\\.");
    String[] v2 = version2.split("\\.");
    int v1Len = v1.length;
    int v2Len = v2.length;

    int val1, val2;
    for (int i = 0; i < Math.max(v1Len, v2Len); i++) {
      val1 = i < v1Len ? Integer.parseInt(v1[i]) : 0;
      val2 = i < v2Len ? Integer.parseInt(v2[i]) : 0;

      if (val1 != val2) {
        return val1 > val2 ? 1 : -1;
      }
    }

    return 0;
  }

  public static void main(String[] args) {
    System.out.println(compareVersion("0.1", "1.1"));
  }
}
