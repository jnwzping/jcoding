package string;

public class string {

  public static void main(String[] args) {
    String a = "abc";
    String b = new String("abc");
    String c = "abc";

    System.out.println(a == b);
    c.intern();
    System.out.println(a == c);


    b.intern();

    System.out.println(a == b);
    System.out.println(a == b);
    System.out.println(a == b);
  }


}
