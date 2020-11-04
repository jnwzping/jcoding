package unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeUtil {
    public static Unsafe unsafe;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
            unsafe.allocateMemory(100);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void NewInstance(int x) throws InstantiationException, NoSuchFieldException {
        // 构造一个对象，且不调用其构造函数
        Test2 test = (Test2) unsafe.allocateInstance(Test2.class);
        // 得到一个对象内部属性的地址
        long x_addr = unsafe.objectFieldOffset(Test2.class.getDeclaredField("x"));
        // 直接给此属性赋值
        if (x == 47) {
            unsafe.getAndSetInt(test, x_addr, 47);
        }
        System.out.println(test.getX());
    }
}
