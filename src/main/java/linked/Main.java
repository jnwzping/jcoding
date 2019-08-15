package linked;

public class Main {

  public static void main(String[] args) {
    Node node1 = new Node("1", "1");
    Node node2 = new Node("2", "2");
    Node node3 = new Node("3", "3");
    Node node4 = new Node("4", "4");
    Node node5 = new Node("5", "5");
    Node node6 = new Node("6", "6");
    Node node7 = new Node("7", "7");
    Node node8 = new Node("8", "8");
    Node node9 = new Node("9", "9");
    Node node10 = new Node("10", "10");
    Node node11 = new Node("11", "11");
    Node node12 = new Node("12", "12");

    node1.setNextNode(node2);
    node2.setNextNode(node3);
    node3.setNextNode(node4);
    node4.setNextNode(node5);
    node5.setNextNode(node6);
    node6.setNextNode(node7);
    node7.setNextNode(node8);
    node8.setNextNode(node9);
    node9.setNextNode(node10);
    node10.setNextNode(node11);
    node11.setNextNode(node12);

    Node.printNode(node1);
  }
}
