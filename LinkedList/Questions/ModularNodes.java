package LinkedList.Questions;

import LinkedList.SinglyLinkedList.ListNode;

public class ModularNodes{
    

    //find last from begining whose n%k == 0, n being length of ll
    public ListNode modNodesFromBeg(ListNode head, int k){

        ListNode modularNode = null;
        int i = 0;
        if(k <= 0 )
        return null;

        for(; head != null; head = head.getNext()){
            if( i%k == 0){
                modularNode = head;
            }
            i++;
        }

        return modularNode;
    }

}