package LinkedList.Questions;

import LinkedList.SinglyLinkedList.ListNode;

public class ReversePair {

    public static ListNode ReversePairRecursive(ListNode head){
        ListNode temp; 
        //base case for empty or one element list
        if(head == null || head.getNext() == null)
            return head;
       else{
           //get second node
           temp =head.getNext();
           //set first node's next to second node's next node
           head.setNext(temp.getNext());
           //set second node's next to first node
           temp.setNext(head);
           //new head is the former second node
           head = temp;
           //set now current second node's next 
           head.getNext().setNext(ReversePairRecursive(head.getNext().getNext()));;

           //return new head
           return head;
       } 
    }

    public static ListNode ReversePairIterative(ListNode head){
        ListNode temp = null;
        ListNode newHead = null;
        while(head!= null && head.getNext()!= null){
            //temp will point to the previous node of head
            if(temp!= null){
                temp.getNext().setNext(head.getNext());
            }
            temp = head.getNext();
            head.setNext(temp.getNext());
            //now node second to head is before head
            temp.setNext(head);
            if(newHead == null){
                newHead = temp;
            }
            head = head.getNext();
        }
        return newHead;
    }
}
