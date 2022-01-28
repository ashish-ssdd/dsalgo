package LinkedList.Questions;

import LinkedList.SinglyLinkedList.ListNode;

public class FractionalNode {

    public ListNode fractionalNodes(ListNode head, int k){
        ListNode fractionalNode = null;
        int i = 0;
        if(k <= 0){
            return null;
        }

        for(;head != null ;head = head.getNext()){
            if(i %k ==0){
                if(fractionalNode == null)
                    fractionalNode = head;
                else fractionalNode = fractionalNode.getNext();
            }
            i++;

        }
        return fractionalNode;
    }
    
}
