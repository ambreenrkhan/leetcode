package leetCode.linkedList;

public class DeleteMiddleNode {

    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null) return null;

        ListNode fastPointer = head;
        ListNode slowPointer = head;
        ListNode slowPointerPrevious = null;
        ListNode slowPointerNext = head;

        int count =0;

        while (fastPointer != null) {
            fastPointer = fastPointer.next;
            if(++count%2==0 ){
                slowPointerPrevious = slowPointer;
                slowPointer = slowPointer.next;

            }else{
                slowPointerNext = slowPointerNext.next;
            }
        }

        if (slowPointerPrevious != null) {
            if(count%2==0){
                slowPointerPrevious.next = slowPointerNext.next;
            }else{
                slowPointerPrevious.next = slowPointerNext;
            }
        }

        return head;
    }

    public static void main(String[] args){
        ListNode node1 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node7 = new ListNode(7);
        ListNode node12 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node6 = new ListNode(6);
        node1.next = node3;
        node3.next = node4;
        node4.next = node7;
        node7.next = node12;
        node12.next = node2;
        node2.next = node6;

        System.out.println(ListNode.printLinkedList(node1));

        DeleteMiddleNode dmn = new DeleteMiddleNode();
        node1 = dmn.deleteMiddle(node1);
        System.out.println(ListNode.printLinkedList(node1));
    }
}
