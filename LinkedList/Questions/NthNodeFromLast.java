package LinkedList.Questions;

import LinkedList.SinglyLinkedList.ListNode;

public class NthNodeFromLast {
    
    int count = 1;
    public ListNode NthNodeFromEnd(ListNode head, int NthNode){
        ListNode temp = head, pthNode = head;

        int i = 1;
        while(temp != null && i < NthNode)
            temp = temp.getNext();
        
        while(temp!= null){
            pthNode = pthNode.getNext();
            temp = temp.getNext();
        }
        return pthNode;
    
    }

    public ListNode recursiveNthNodeFromEnd(ListNode head, int NthNode){
        if(head!= null){
            recursiveNthNodeFromEnd(head.getNext(), NthNode);
            count++;
            if(NthNode == count)
                return head;
        }
        return null;
    }
}
