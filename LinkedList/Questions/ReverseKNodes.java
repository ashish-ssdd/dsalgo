package LinkedList.Questions;

import LinkedList.SinglyLinkedList.ListNode;

public class ReverseKNodes {

    public static ListNode reverseKNodesRecursive(ListNode head, int k){
        ListNode current = head;
        ListNode next = null;
        ListNode prev = null;

        int count = k;

        while(current != null && count> 0){
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
            count--;
        }

        //now next points to k+1th node,
        if(next != null){
            head.setNext(reverseKNodesRecursive(next, k));
        }

        return prev;
    }
    
    public ListNode reverseKGroup(ListNode head, int k){
        int n = 0;
        //get length
        for(ListNode i = head; i != null ; n++ , i = i.getNext());

        ListNode dmy = new ListNode(0);
        dmy.setNext(head);
        //for until length of remaining list is greater than k
        for(ListNode prev = dmy, tail = head; n >= k; n -= k){
            for(int i = 1; i< k; i++){
                ListNode next = tail.getNext().getNext();
                tail.getNext().setNext(prev.getNext());
                prev.setNext(tail.getNext());
                tail.setNext(next);
            }

            prev = tail;
            tail = tail.getNext();
        }

        return dmy.getNext();
    }
}
