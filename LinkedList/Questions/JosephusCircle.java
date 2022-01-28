package LinkedList.Questions;

import LinkedList.SinglyLinkedList.ListNode;

public class JosephusCircle {
    //N people in a circular position, find the last person remianing
    //when every Mth person around the circle is eleminated
    
    public ListNode GetJosephusPosition(int N, int M){
        ListNode p, q;
        //create circular linkedlist containing all players
        p = new ListNode(1);
        q = p;
        for(int i = 2 ; i<= N ; ++i){
            p.setNext(new ListNode(i));
            p = p.getNext();
        }

        p.setNext(q);

        for(int count = N; count > 1 ; --count){
            for(int i = 0 ; i< M -1 ; ++i){
                p = p.getNext();
            }
            p.setNext(p.getNext().getNext());
        }
        return p;
    }
    
}
