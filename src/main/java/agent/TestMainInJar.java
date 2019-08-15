package agent;

public class TestMainInJar {

    public static void main(String[] args) throws InterruptedException {
        new HelloWorld().say();
        int count = 0;
        while (true) {
            Thread.sleep(2000);
            count++;
            new HelloWorld().say();
            System.out.println("count = " + count);
//            if (count >= 20) {
//                break;
//            }
        }
    }
}
