package LinkedList.Questions;

import LinkedList.SinglyLinkedList.ListNode;

public class FindMiddle {

    //Find middle node of ll given head
    //Two pointer approach move one pointer twice the speed of other when the first one 
    //reaches end second will be at middle

    public static ListNode findMiddle(ListNode head){
        ListNode fastPtr = head, slowPtr = head;

        while(fastPtr != null && fastPtr.getNext()!= null){
            fastPtr = fastPtr.getNext().getNext();
            slowPtr = slowPtr.getNext();
        }

        return slowPtr;
    }
    
    public static int isLengthEven(ListNode head){
        while(head!= null && head.getNext()!= null)
            head = head.getNext().getNext();
        if(head == null)
            return 0;
        return 1;
    }
}
