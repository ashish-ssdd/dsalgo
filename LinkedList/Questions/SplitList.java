package LinkedList.Questions;

import LinkedList.SinglyLinkedList.ListNode;

public class SplitList {
    //Split a cll into two equal parts,
    // if odd numbers of nodes make first one have one extra

    public static void SplitCLL(ListNode head, ListNode head1, ListNode head2){
        if(head == null) return ;
        //First find middle using slow and fast ptr
        ListNode slowPtr = head, fastPtr = head;
        //if odd number of nodes fastPtr.next will be head
        //if even then fastPtr.next.next will be head
        while(fastPtr.getNext() != head && fastPtr.getNext().getNext()!= head){
            fastPtr = fastPtr.getNext().getNext();
            slowPtr = slowPtr.getNext();
        }
        //now slow pointer will point to mid 
        //if even number of nodes
        if(fastPtr.getNext().getNext() == head){
            fastPtr = fastPtr.getNext();
        }
        //now fastPtr will point to node before head
        head1 = head;
        //check if its not one node cll
        if(head.getNext() != head)
            head2 = slowPtr.getNext();
        fastPtr.setNext(slowPtr.getNext());
        slowPtr.setNext(head);
    }
}
