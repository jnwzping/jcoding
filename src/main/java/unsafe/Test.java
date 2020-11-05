package unsafe;

import java.lang.reflect.Field;

import memory.object.Person;

public class Test {

    public static void main(String[] args) {
        try {
            Field field2 = Person.class.getDeclaredField("age");
            // 一旦这个类实例化后，该属性在内存中的偏移位置
            long offset2 = UnsafeUtil.unsafe.objectFieldOffset(field2);
            System.out.println("name offset = " + offset2);

            System.out.println(Integer.MAX_VALUE);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

}