package thread;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 有两个线程交替打印奇偶数，两个线程频率不同，定时交替打印另一个线程数
 */
public class DoubleThread extends Thread {

  /**
   * 总线切换开关
   */
  public volatile static Boolean swap = false;

  /**
   * 切换时计数，NUM = 2，关闭总线切换开关
   */
  public volatile static Integer NUM = 0;

  /**
   * 保存两个线程最后打印值
   */
  public static ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap(2);

  /**
   * 本地切换开关
   */
  public volatile Boolean swap_ = false;
  /**
   * 区分线程类型，1为奇数打印线程，2为偶数打印线程，属性随时变更
   */

  public Integer key = null;

  public DoubleThread(Integer key) {
    this.key = key;
    map.put(key, key);
  }

  @Override
  public void run() {
    while (true) {
      swapThread();
      printNum();
    }
  }

  /**
   * 切换线程奇偶打印类型
   */
  public void swapThread() {
    if (swap) {
      swap_ = true;
      if (swap_) {
        synchronized (swap) {
          System.out.println(Thread.currentThread().getName() + " : " + "开始切换线程！");
          NUM = NUM + 1;
          if ((key % 2) == 1) {
            key = 2;
          } else {
            key = 1;
          }
          if (NUM == 2) {
            swap = false;
            NUM = 0;
            System.out.println("结束切换线程!");
          }
        }
      }
      swap_ = false;
    }
  }

  /**
   * 打印奇偶数并设置下一个打印数
   */
  public void printNum() {
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
    }
    System.out.println(Thread.currentThread().getName() + "-key-" + key + " : " + map.get(key));
    map.put(key, map.get(key) + 2);
  }

  public static void main(String[] args) {
    DoubleThread te1 = new DoubleThread(1);
    te1.setName("thread1");

    DoubleThread te2 = new DoubleThread(2);
    te2.setName("thread2");

    te1.start();
    te2.start();

    for (int i = 0; i < 10; i++) {
      try {
        Thread.sleep(5000);
        DoubleThread.swap = true;
        System.out.println("开启切换线程!");
      } catch (InterruptedException e) {
      }
    }
  }
}
