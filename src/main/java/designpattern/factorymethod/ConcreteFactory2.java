package designpattern.factorymethod;

/**
 *@program: jcoding
 *@description:
 *@author: liu yan
 *@create: 2019-09-11 20:16
 */
public class ConcreteFactory2 implements AbstractFactory {

  @Override
  public Product newProduct() {
    return new ConcreteProduct2();
  }
}
