package linked;

public class NodeUtil {


  /**
   *
   * @param length
   * @return
   */
  public static Node getNode(Integer length) {
    Node head = new Node("key1", "value1");
    Node tmp = head;
    for (int i = 2; i <= length; i++) {
      String str = i + "";
      Node node = new Node("key" + str, "value" + str);
      head.setNextNode(node);
      head = node;
    }
    return tmp;
  }

  /**
   * 链表反转
   */
  public static Node reverse(Node head) {
    Node newNode = null;
    while (head != null) {
      Node tmp = head.getNextNode();
      head.setNextNode(newNode);
      newNode = head;
      head = tmp;
    }
    return newNode;
  }

  /**
   * 打印链表
   */
  public static void printNode(Node head) {
    if (head != null) {
      System.out.println("node key =" + head.getKey() + ",value = " + head.getValue());
      if (head.getNextNode() != null) {
        printNode(head.getNextNode());
      }
    }
  }
}
