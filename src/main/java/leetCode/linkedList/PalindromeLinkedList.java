package leetCode.linkedList;

import java.util.Stack;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();

        ListNode slowPointer = head;
        ListNode fastPointer = head;

        int fastCounter = 0;
        int slowCounter = 0;
        while(fastPointer!=null){
            fastPointer = fastPointer.next;
            ++fastCounter;

            while(slowCounter<(fastCounter/2)){
                stack.push(slowPointer.val);
                slowPointer = slowPointer.next;
                ++slowCounter;
            }
        }

        if(fastCounter%2!=0){
            slowPointer = slowPointer.next;
        }

        while(slowPointer!=null){
            int slowPointerVal = slowPointer.val;
            int currentValueInStack = stack.pop();

            if(slowPointerVal!=currentValueInStack){
                return false;
            }
            slowPointer = slowPointer.next;

        }

        return true;
    }
}
