package string;

/**
 *@program: jcoding
 *@description: 说说
 *@author: liu yan
 *@create: 2019-09-19 22:38
 */
public class Solution {

  public boolean isValid(String s) {
    int length = s.length();
    do {
      length = s.length();
      s = s.replaceAll("\\(\\)", "").replaceAll("\\{\\}", "").replaceAll("\\[\\]", "");
      System.out.println(s);
    } while (s.length() != length);
    return s.length() == 0;
  }

  /**
   * 解题思路1：计数器实现，未考虑："ababba"
   * @Author: wp
   * @Date: 2019-09-23 23:17
   */
  public boolean isValid2(String s) {
    char[] x = s.toCharArray();
    int y = 0;
    if (s.length() % 2 == 1) {
      return false;
    } else {
      for (int i = 0; i < s.length(); i++) {
        int tmp = 0;
        for (int j = 0; j < s.length(); j++) {
          if (x[i] == x[j]) {
            tmp++;
          }
        }
        if (i == 0) {
          y = tmp;
        } else if (y != tmp) {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * 解题思路2：KMP，KMP算法的时间复杂度O(m+n)
   * @Author: wp
   * @Date: 2019-09-23 23:17
   */
  public boolean isValid3(String s) {
    int l = s.length();
    int[] next = new int[l];
    next[0] = -1;
    int i, j = -1;
    for (i = 1; i < l; i++) {
      while (j >= 0 && s.charAt(i) != s.charAt(j + 1)) {
        j = next[j];
      }
      if (s.charAt(i) == s.charAt(j + 1)) {
        j++;
      }
      next[i] = j;
    }
    int lenSub = l - 1 - next[l - 1];
    return lenSub != l && l % lenSub == 0;
  }


  public static void main(String[] args) {
    System.out.println(new Solution().isValid3("ababc"));
  }
}
