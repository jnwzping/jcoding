package singleton;

import java.io.Serializable;

public class Singleton implements Serializable {

  private String name = "12";
  private String value = "12";
  private static Singleton singleton = new Singleton();

  private Singleton() {
    if (singleton != null) {
      throw new RuntimeException();
    }
  }

  public static Singleton getInstance() {
    System.out.println("Singleton2222");
    return singleton;
  }

//  private Object readResolve() {
//    System.out.println("01010100101010");
//    return singleton;
//  }

}
