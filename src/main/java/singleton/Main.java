package singleton;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/***
 * 单例序列化和反序列化
 */
public class Main {

  public static void main(String[] args) {
//    Singleton singleton = Singleton.getInstance();

    try {
      File file = new File("/tmp/memory.object.txt");
//      ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
//      objectOutputStream.writeObject(singleton);
//      objectOutputStream.flush();
//      objectOutputStream.close();

      ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
      Singleton singleton1 = (Singleton) objectInputStream.readObject();
      objectInputStream.close();

//      System.out.println(singleton);
      System.out.println(singleton1);

    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}
