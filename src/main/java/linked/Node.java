package linked;

import lombok.Data;

@Data
public class Node {

  public Node(String key, String value) {
    this.key = key;
    this.value = value;
  }

  private String key;
  private String value;
  private Node nextNode;


}
