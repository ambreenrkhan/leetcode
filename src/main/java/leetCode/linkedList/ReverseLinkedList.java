package leetCode.linkedList;

public class ReverseLinkedList {
 public ListNode reverseList(ListNode head) {
   if(head == null || head.next == null) return head;

    ListNode current = head;
    ListNode previous = null;
    ListNode next = null; // main variable storage

    while(current!=null){
      next = current.next; // main storage
      current.next = previous;
      previous = current;
      current = next;
    }

    head = previous;

    return head;
 }

 public static void main(String[] args){
   ListNode node1 = new ListNode(1);
   ListNode node2 = new ListNode(2);
   ListNode node3 = new ListNode(3);
   ListNode node4 = new ListNode(4);
   ListNode node5 = new ListNode(5);
   node1.next = node2;
   node2.next = node3;
   node3.next = node4;
   node4.next = node5;
   System.out.println(ListNode.printLinkedList(node1));

   ReverseLinkedList rvs = new ReverseLinkedList();
   node1 = rvs.reverseList(node1);
   System.out.println(ListNode.printLinkedList(node1));
 }

}


