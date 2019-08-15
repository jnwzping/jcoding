package singleton;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SingletonDouble implements Serializable {

  /**
   * 私有化构造器
   */
  private SingletonDouble() {

  }

  private static SingletonDouble singleton = new SingletonDouble();

  private transient static Singleton singleton2 = Singleton.getInstance();

  public static SingletonDouble getInstance() {
    return singleton;
  }

  private void writeObject(ObjectOutputStream out) throws IOException {
    System.out.println("writeOject");
    out.writeObject(new StringBuffer("1111"));
  }

  private void readObject(java.io.ObjectInputStream s) throws java.io.IOException {
    System.out.println("readOject");
  }
}
