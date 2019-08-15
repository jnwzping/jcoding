package designpattern;

public class Main {
  public static void main(String[] args) {
    //1、创建被观察者
    ObservableOOP ob = new ObservableOOP();
    //2、创建观察者
    ObserverImpl obs = new ObserverImpl();
    //3、调用被观察者add方法添加观察者
    ob.addObserver(obs);

    //4、设置被观察者，调用监视方法
    ob.setTemperature(26);
    ob.monitor();
  }
}
