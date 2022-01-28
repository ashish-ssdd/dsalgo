package LinkedList.Questions;

import LinkedList.SinglyLinkedList.ListNode;

public class ReverseSinglyLinkedList {
    
    public static ListNode reverseListIterative(ListNode head){

        ListNode current = head;
        ListNode prev = null;
        while(current != null){
            ListNode nextNode = current.getNext();
            current.setNext(prev);
            prev = current;
            current = nextNode;
        }
        return prev;
    }

    //Recursive Version
    public static ListNode reverseListRecur(ListNode head){
        //Stop if head is null or we are at last node
        if(head == null || head.getNext() == null)
            return head;
        ListNode newHead = reverseListRecur(head.getNext());
        //now head is pointing to second last Node
        head.getNext().setNext(head);
        head.setNext(null);

        return newHead;
    }
}
