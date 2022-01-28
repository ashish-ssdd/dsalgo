package LinkedList.Questions;

import LinkedList.SinglyLinkedList.ListNode;

public class InsertInSortedLL {

    public static ListNode InsertInSortedList(ListNode head, ListNode newNode){
        ListNode current = head;
        if(head == null) return newNode;
        ListNode temp = current;
        //Traverse the list until you find item bigger the new node value
        while(current != null && current.getData() < newNode.getData()){
            temp = current;
            current = current.getNext();
        } 

        newNode.setNext(current);
        temp.setNext(newNode);
        return head;
    }
    
}
