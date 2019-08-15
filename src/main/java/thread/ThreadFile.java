package thread;

import static java.lang.System.out;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.ConcurrentHashMap;

/***
 * 四个线程，分别对文件写入1,2,3,4
 */
public class ThreadFile extends Thread {

  private static String path = "/tmp/";
  private Integer x = null;
  public static ConcurrentHashMap<Integer, OutputStream> concurrentHashMap = new ConcurrentHashMap();

  public ThreadFile(Integer idx) {
    this.x = idx;
  }

  @Override
  public void run() {
    while (true) {
      out.println(Thread.currentThread().getName() + " ## " + x);

      try {
        OutputStream os = concurrentHashMap.get(x);
        os.write(x.toString().getBytes());
        os.flush();
        Thread.sleep(1000);
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {
    Integer x = null;
    ThreadFile t0 = new ThreadFile(x);
    ThreadFile t1 = new ThreadFile(1);
    ThreadFile t2 = new ThreadFile(2);
    ThreadFile t3 = new ThreadFile(3);
    ThreadFile t4 = new ThreadFile(4);

    t1.setName("thread-1");
    t2.setName("thread-2");
    t3.setName("thread-3");
    t4.setName("thread-4");

    try {
      String fileName1 = path + "/file" + 1 + ".txt";
      String fileName2 = path + "/file" + 2 + ".txt";
      String fileName3 = path + "/file" + 3 + ".txt";
      String fileName4 = path + "/file" + 4 + ".txt";
      ThreadFile.concurrentHashMap.put(1, new FileOutputStream(new File(fileName1)));
      ThreadFile.concurrentHashMap.put(2, new FileOutputStream(new File(fileName2)));
      ThreadFile.concurrentHashMap.put(3, new FileOutputStream(new File(fileName3)));
      ThreadFile.concurrentHashMap.put(4, new FileOutputStream(new File(fileName4)));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    t0.start();
    t1.start();
    t2.start();
    t3.start();
    t4.start();
  }
}
