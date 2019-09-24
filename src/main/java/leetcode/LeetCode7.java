package leetcode;

/***
 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

 示例 1:
 输入: 123
 输出: 321
 示例 2:
 输入: -123
 输出: -321
 示例 3:
 输入: 1534236469
 输出: 0

 解题思路：
 1.数字取最后一位可以通过 x%=10，窃取最后一位 x/=10 来获取
 2.整形操作判断时候溢出，可以通过未处理的原值比较Integer.MAX_VALUE 做反操作来判断是否溢出
 */
public class LeetCode7 {

  public static int reverse(int x) {
    int y = 0;
    while (x != 0) {
      int pop = x % 10;
      if (y > Integer.MAX_VALUE / 10 || (y == Integer.MAX_VALUE / 10 && pop > 7)) {
        return 0;
      }
      if (y < Integer.MIN_VALUE / 10 || (y == Integer.MAX_VALUE / 10 && pop < -8)) {
        return 0;
      }
      y = y * 10 + pop;
      x /= 10;
    }
    return y;
  }

  public static void main(String[] args) {
    System.out.println(reverse(1534236469));
  }
}
