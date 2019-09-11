package thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *@program: jcoding
 *@description:
 *@author: liu yan
 *@create: 2019-09-09 22:36
 */
public class ExecutorTest {

  public static void main(String[] args) {
//    Executors.newFixedThreadPool(1);
    ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 5,
        1000L, TimeUnit.SECONDS,
        new SynchronousQueue<>(),
        new ThreadFactoryBuilder().build(), new ThreadPoolExecutor.CallerRunsPolicy());

    for (int x = 0; x < 50; x++) {
      System.out.println("主线程循环i = " + x);
      poolExecutor.submit(() -> {
        System.out.println("-- 执行线程 --" + Thread.currentThread().getName());
        try {
          Thread.sleep(5000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      });
    }

    System.out.println("=== 主线程循环结束！！！===");
  }
}
