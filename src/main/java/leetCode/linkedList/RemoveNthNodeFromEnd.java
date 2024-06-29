package leetCode.linkedList;

public class RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n <0) return null;
        ListNode trailingNode = head;
        ListNode previousTrailingNode = head;
        ListNode currentNode = head;
        int i=0;

        for(i=0;i<n;i++){
            if(currentNode==null){
                return null;
            }else{
                currentNode = currentNode.next;
            }
        }

        while(currentNode!=null){
            currentNode = currentNode.next;
            previousTrailingNode = trailingNode;
            trailingNode = trailingNode.next;
        }

        if(previousTrailingNode.next==null && trailingNode.next==null){
            return null;
        }

        if(previousTrailingNode.next!=null && previousTrailingNode.next.equals(trailingNode.next)){
            return trailingNode.next;
        }
        previousTrailingNode.next = trailingNode.next;

        return head;
    }
}
