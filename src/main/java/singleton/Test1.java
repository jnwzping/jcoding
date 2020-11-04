package singleton;

public class Test1 {
  public String ss = "sdsd";
  public Test1(String a){
    this.ss = a;
  }

  public static void main(String[] args) {
    String a = "abc";
    String b = new String("abc");
    b.intern();
    System.out.println(a.equals(b));
  }
}
