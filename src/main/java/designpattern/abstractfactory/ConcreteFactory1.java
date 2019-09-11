package designpattern.abstractfactory;

/**
 *@program: jcoding
 *@description:
 *@author: liu yan
 *@create: 2019-09-11 20:55
 */
public class ConcreteFactory1 implements AbstractFactory {

  @Override
  public Product1 newProduct1() {
    return new ConcretePruduct1();
  }

  @Override
  public Product2 newProduct2() {
    return new ConcretePruduct2();
  }
}
