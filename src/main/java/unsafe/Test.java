package unsafe;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

public class Test {

  public static void main(String[] args) {
    try {
      Field field = Unsafe.class.getDeclaredField("theUnsafe");
      field.setAccessible(true);
      Unsafe unsafe = (Unsafe) field.get(null);
      unsafe.allocateMemory(100);
    } catch (NoSuchFieldException | IllegalAccessException e) {
      e.printStackTrace();
    }
  }

}