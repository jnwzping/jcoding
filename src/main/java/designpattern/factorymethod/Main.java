package designpattern.factorymethod;

/** 工厂方法模式只生产一个等级的产品，而抽象工厂模式可生产多个等级的产品
 *@program: jcoding
 *@description:
 *@author: liu yan
 *@create: 2019-09-11 20:36
 */
public class Main {

  public static void main(String[] args) {
    AbstractFactory abstractFactory = new ConcreteFactory1();
    abstractFactory.newProduct().show();
  }
}
