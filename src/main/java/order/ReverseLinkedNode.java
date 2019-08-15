package order;

import lombok.Data;

@Data
public class ReverseLinkedNode {

    private String k;
    private String v;
    private ReverseLinkedNode next;

    ReverseLinkedNode(String a, String b) {
        k = a;
        v = b;
    }

    public ReverseLinkedNode initLinkedList() {
        ReverseLinkedNode no1 = new ReverseLinkedNode("key1", "value1");
        ReverseLinkedNode no2 = new ReverseLinkedNode("key2", "value2");
        ReverseLinkedNode no3 = new ReverseLinkedNode("key3", "value3");
        ReverseLinkedNode no4 = new ReverseLinkedNode("key4", "value4");
        ReverseLinkedNode no5 = new ReverseLinkedNode("key5", "value5");
        no1.setNext(no2);
        no2.setNext(no3);
        no3.setNext(no4);
        no4.setNext(no5);
        return no1;
    }

    public ReverseLinkedNode reverse(ReverseLinkedNode head){
        ReverseLinkedNode pre = null;
        while(head!=null){
            ReverseLinkedNode tmp = head.getNext();
            head.setNext(pre);
            pre = head;
            head = tmp;
        }

        return pre;
    }

    public void printList(ReverseLinkedNode head){
        if(head!=null){
            System.out.println("k = "+head.k+" v = "+head.v);
            printList(head.getNext());
        }
    }

    public static void main(String[] args) {
        ReverseLinkedNode test = new ReverseLinkedNode("test","test");
        ReverseLinkedNode no = test.initLinkedList();
        test.printList(no);
        System.out.println("反转后顺序");
        test.printList(test.reverse(no));
    }

}
