package singleton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main2 {

  public static void main(String[] args) {
    SingletonDouble singleton = SingletonDouble.getInstance();

    try {
      File file = new File("/tmp/object2.txt");
      ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
      objectOutputStream.writeObject(singleton);
      objectOutputStream.flush();
      objectOutputStream.close();

      ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
      SingletonDouble singleton1 = (SingletonDouble) objectInputStream.readObject();
      objectInputStream.close();

      System.out.println(singleton);
      System.out.println(singleton1);

    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}
