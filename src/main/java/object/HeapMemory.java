package object;

import org.openjdk.jol.info.ClassLayout;

/**
 * java.lang.Object object internals:
 * OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
 * 0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
 * 4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
 * 8     4        (object header)                           e5 01 00 f8 (11100101 00000001 00000000 11111000) (-134217243)
 * 12     4        (loss due to the next object alignment)
 * Instance size: 16 bytes
 * <p>
 * Object 大小 16 bytes
 * byte 大小 16 bytes
 * Byte 大小 16 bytes
 * long 大小 24 bytes (4byte填充，需要保持 8倍数)
 */
public class HeapMemory {

    public static void main(String[] args) {
        Person objMemoryList = new Person();
        objMemoryList.age = 2;
        objMemoryList.name = "name";
        System.out.println(ClassLayout.parseInstance(objMemoryList).toPrintable());
    }
}
