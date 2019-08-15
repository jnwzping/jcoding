package com.guanchazhe;

import java.util.Observable;
import lombok.Data;

/**
 * 1、被观察者继承Observable
 * 2、实现监控逻辑，变化时调用父类notifyObservers()通知所有观察者
 */
@Data
public class ObservableOOP extends Observable {

  private int temperature;// 温度

  /**
   * 监控温度
   */
  public void monitor() {
    if (temperature > 25) {
      System.out.println("温度高于25°C，通知观察者...");
      // 温度变化
      super.setChanged();
      // 通知观察者
      super.notifyObservers(temperature);
    }
  }

}
