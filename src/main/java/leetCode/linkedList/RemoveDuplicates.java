package leetCode.linkedList;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        Set<Integer> encounteredElements = new HashSet<>();

        ListNode currentNode = head;
        ListNode previousNode = head;

        while(currentNode!=null){
            if(encounteredElements.contains(currentNode.val)){
                previousNode.next= currentNode.next;
            }else{
                encounteredElements.add(currentNode.val);
                previousNode = currentNode;
            }

            currentNode = currentNode.next;
        }

        return head;

    }
}
