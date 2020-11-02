package test;

import java.util.HashMap;

public class Test1 {

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        System.out.println(test1.hashCode());
        System.out.println(System.identityHashCode(test1));
        System.out.println(System.identityHashCode(test1));
    }
}
