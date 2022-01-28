package LinkedList.Questions;

import LinkedList.SinglyLinkedList.ListNode;
//same as reversing in pairs 

public class ExchangeAdjacent {
    public static ListNode exchangeAdjacentNode(ListNode head){
        //Create empty Node
        ListNode temp = new ListNode(0);
        //Set this node's next as head
        temp.setNext(head);
        //prev points to new empty node created
        //curr is head
        ListNode prev = temp, curr = head;
        //until list is not empty or we get to the last node
        while(curr != null && curr.getNext() != null){
            //store curr's Next to Next node in a temporary variable
            //ex- if curr is head tmp will have the 3 node (i.e first being head itself)
            ListNode tmp = curr.getNext().getNext();
            //change first node's next to the head as prev hold the emptynode whoese next is head
            curr.getNext().setNext(prev.getNext());
            prev.setNext(curr.getNext());
            curr.setNext(tmp);
            prev = curr;
            curr = prev.getNext();
        }
        return temp.getNext();
    }
    
}
