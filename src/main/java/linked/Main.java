package linked;

public class Main {

  public static void main(String[] args) {
    //测试链表反转
    System.out.println("开始打印链表！");
    Node node = NodeUtil.getNode(10);
    NodeUtil.printNode(node);
    System.out.println("结束打印链表！");

    Node nodeReverse = NodeUtil.reverse(node);
    System.out.println("开始打印链表！");
    NodeUtil.printNode(nodeReverse);
    System.out.println("结束打印链表！");
  }
}
