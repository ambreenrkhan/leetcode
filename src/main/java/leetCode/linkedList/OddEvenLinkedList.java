package leetCode.linkedList;

import lombok.val;

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode oddNode = head;
        ListNode evenNode = head.next;
        ListNode evenHead = evenNode;

        while (evenNode != null && evenNode.next != null) {
            oddNode.next = evenNode.next;
            oddNode = oddNode.next;
            evenNode.next = oddNode.next;
            evenNode = evenNode.next;
        }

        oddNode.next = evenHead;
        return head;
    }

    public static void main(String[] args){
        ListNode node1 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node7 = new ListNode(7);
        ListNode node5 = new ListNode(5);
        ListNode node2 = new ListNode(2);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        System.out.println(ListNode.printLinkedList(node1));

        OddEvenLinkedList dmn = new OddEvenLinkedList();
        node1 = dmn.oddEvenList(node1);
        System.out.println(ListNode.printLinkedList(node1));
    }
}
