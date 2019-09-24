package leetcode;

/***
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 1、需要考虑进位场景
 * 2、需要考虑只有一个节点并进位场景
 */
public class LeetCode2 {

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode newNode = null;
    ListNode pre = null;
    ListNode ref1 = l1;
    ListNode ref2 = l2;
    int mod = 0;
    while (ref1 != null || ref2 != null) {
      int sum = 0;

      if (ref1 != null) {
        sum += ref1.val;
      }
      if (ref2 != null) {
        sum += ref2.val;
      }
      int acc = sum % 10 + mod;
      mod = 0;
      mod = sum / 10;
      if (pre == null) {
        pre = new ListNode(acc);
        newNode = pre;
      } else {
        pre.next = new ListNode(acc);
        pre = pre.next;
      }

      if (ref1 != null) {
        ref1 = ref1.next;
      } else {
        ref1 = null;
      }
      if (ref2 != null) {
        ref2 = ref2.next;
      } else {
        ref2 = null;
      }
    }
    return newNode;
  }

  public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
    ListNode pre = new ListNode(0);
    ListNode curr = pre;
    int add = 0;
    while (l1!=null||l2!=null){
      int x = l1==null?0:l1.val;
      int y = l2==null?0:l2.val;
      int sum = x+y;
      add = sum/10;
      curr.next = new ListNode(sum%10);
      curr = curr.next;

      if(l1!=null)l1=l1.next;
      if(l2!=null)l2=l2.next;
      if(add == 1) {
        curr.next = new ListNode(add);
      }
    }

    return pre.next;
  }

  public static void main(String[] args) {
    ListNode n1 = new ListNode(2);
    ListNode n2 = new ListNode(4);
    ListNode n3 = new ListNode(3);
    n1.next = n2;
    n2.next = n3;

    ListNode n4 = new ListNode(5);
    ListNode n5 = new ListNode(6);
    ListNode n6 = new ListNode(4);
    n4.next = n5;
    n5.next = n6;

    addTwoNumbers2(n1, n4);

  }
}
