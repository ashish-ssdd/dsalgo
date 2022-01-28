package LinkedList.Questions;

import LinkedList.SinglyLinkedList.ListNode;

public class CheckPalindromeLL {
public boolean isPalindrome(ListNode head) {
        if(head == null || head.getNext() == null) return true;
        
        if(head.getNext().getNext() == null){
            return head.getData() == head.getNext().getData() ? true : false;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast != null && fast.getNext() != null){
            fast = fast.getNext().getNext();
            ListNode tmp = slow;
            slow = slow.getNext();
            
            if(tmp == head){
                tmp.setNext(null);
            }else{
                tmp.setNext(head);
            }
            
            head = tmp;
        }
        
        if(fast != null) slow = slow.getNext();
        
        while(head.getData() == slow.getData()){
            head = head.getNext();
            slow = slow.getNext();
            
            if(head == null && slow == null) return true;
            
            if(head.getData() != slow.getData()) break;
        }
        
        return false;
    }
    
}
