package hashcode;

public class Main {

  /**
   * 测试String hashCode 生成方式
   * @param args
   */
  public static void main(String[] args) {
    char[] value = "11298371293123912312317239".toCharArray();
    int h = 0;
    if (h == 0 && value.length > 0) {
      char val[] = value;
      for (int i = 0; i < value.length; i++) {
        h = 31 * h + val[i];
        System.out.println(h);
      }
    }
    System.out.println("====" + h);
  }
}
