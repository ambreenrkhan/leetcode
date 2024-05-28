package leetCode.linkedList;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static String printLinkedList(ListNode node){
        StringBuilder sb = new StringBuilder();

        while(node!=null){
            sb.append(node.val);
            sb.append("->");
            node= node.next;
        }

        return sb.toString();
    }
}
