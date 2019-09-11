package hashcode;

public class Main {

  /**
   * 测试String hashCode 生成方式
   * @param args
   */
  public static void main(String[] args) {
    String a = "abc";
    String b = new String("abc");
    System.out.println(b.intern() == a);
  }
}
