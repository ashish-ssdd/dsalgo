package LinkedList.Questions;

import LinkedList.SinglyLinkedList.ListNode;

public class FloydsCycle {
    
    public static boolean findIfLoopExistsUsingFloyds(ListNode head){
        ListNode fastptr = head, slowPtr = head;
        while(fastptr!= null && fastptr.getNext()!= null){
            fastptr = fastptr.getNext().getNext();
            slowPtr = slowPtr.getNext();
            if(fastptr == slowPtr)
                return true;
        }
        return false;
    }

    public static int findLengthOfTheLoop(ListNode head){
        ListNode fastPt = head;
        ListNode slowPt = head;
        boolean loopExists = false;
        while(fastPt != null && fastPt.getNext()!= null ){
            fastPt = fastPt.getNext().getNext();
            slowPt = slowPt.getNext();
            if(fastPt == slowPt){
                loopExists = true;
                break;
            }
        }
        int length = 0;
        if(loopExists){
            do{
                slowPt = slowPt.getNext();
                length++;
            } while(slowPt != fastPt);
        }
        return length;
    }
    public static ListNode findBeginOfLoop(ListNode head){
        boolean loopExists = false;
        ListNode fastptr = head, slowPtr = head;
        while(fastptr!= null && fastptr.getNext()!= null){
            fastptr = fastptr.getNext().getNext();
            slowPtr = slowPtr.getNext();
            if(fastptr == slowPtr)
            {
                loopExists = true;
                break;
            }
        }
        if(loopExists){
            slowPtr = head;
            while(slowPtr != fastptr){
                slowPtr = slowPtr.getNext();
                fastptr = fastptr.getNext();
            }
            return fastptr;
        }
        return null;
        

    }

}
