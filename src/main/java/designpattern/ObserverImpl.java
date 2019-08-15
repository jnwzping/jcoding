package designpattern;

import java.util.Observable;
import java.util.Observer;

/**
 * 1、观察者实现Observer接口
 * 2、重写update方法
 */
public class ObserverImpl implements Observer {

  @Override
  public void update(Observable o, Object arg) {
    System.out.println("ObserverImpl 执行 update 方法");
  }
}
