package thread;

public class IntegerTest implements Runnable {

  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName() + "=========");
  }

  public static void main(String[] args) {
    IntegerTest a = new IntegerTest();

    Thread b = new Thread(a);
    b.setName("123");
    b.start();

  }
}
