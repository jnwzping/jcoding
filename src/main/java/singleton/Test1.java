package singleton;

public class Test1 {

  public static void main(String[] args) {
    String a = "abc";
    String b = new String("abc");
    b.intern();
    System.out.println(a.equals(b));
  }
}
