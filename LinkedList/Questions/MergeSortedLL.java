package LinkedList.Questions;


import LinkedList.SinglyLinkedList.ListNode;

public class MergeSortedLL {

    public static ListNode mergeTwoLLReccur(ListNode head1, ListNode head2){

        if(head1 == null)
            return head2;
        if(head2 == null)
            return head1;
        ListNode head = new ListNode(0);
        if(head1.getData() <= head2.getData()){
            head = head1;
            head.setNext(mergeTwoLLReccur(head1.getNext(), head2));
        } else{
            head = head2;
            head.setNext(mergeTwoLLReccur(head2.getNext(), head1));
        }

        return head;
    }
    
    public static ListNode mergeTwoLLIterative(ListNode head1, ListNode head2){
        ListNode head = new ListNode(0);

        ListNode curr= head;

        while(head1!= null && head2 != null){
            if(head1.getData() <= head2.getData()){
                curr.setNext(head1);
                head1= head1.getNext();
            } else{
                curr.setNext(head2);
                head2 = head2.getNext();
            }
        }
        if(head1 != null)
            curr.setNext(head1);
        else if(head2!= null)
            curr.setNext(head2);
        
        return head.getNext();
    }
}
