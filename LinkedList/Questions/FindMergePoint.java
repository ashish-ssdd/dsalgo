package LinkedList.Questions;

import LinkedList.SinglyLinkedList.ListNode;

public class FindMergePoint {

    //Given two linkedList that merge at some point into one linkedlist find the merging point 
    //both ll can have different length before they merge into one

    //Brute force compare each node of one ll with every other node of ll 
    //one that matches it the intersecting point
    public static ListNode bruteIntersection(ListNode oneStart, ListNode twoStart){
        if(oneStart == null|| twoStart == null)
            return null;
        
        //Start with firstLinkedList and compare it with everyother node of second linked list
        ListNode temp1 = oneStart;
        while(temp1!= null){
        ListNode temp2 = twoStart;
            while(temp2!= null){
                if(temp1 == temp2)
                    return temp1;
                temp2 = temp2.getNext();
            }
            temp1 = temp1.getNext();
        }

        return null;
    }

    //Hashtable method 
    //Store one ll in ht and traverse other and for every node search if that node already
    //exists in ht or not, if it does it's the starting point of merge
    // T O(m)+ O(n)  S= O(n) or O(m)

    //Stack method
    //Push both ll in their stack and then start popping from both simultaneoulsy the point
    //when the popped node are not equal is the point after the the ll merges
    // T= O(m + n) S= O(m+n)
    
    //using FirstRepeating element approach
    //create an array and keep all the next pointers of both list in array 
    //in the array find first repeating element
    //T= O(m+n) S= O(m+n)

    //Sorting and searching
    //Create an array and keep all the next pointers ofthe first ll in array and sort it
    //for each node of second ll search in the sorted array, the first repeating element 
    //is the merge point
    //T= O(Max(mlogm, nlogn))   S= O(Max(m,n))

    //Efficient method
    //Find lengths of both ll
    //take difference of length d
    //make d steps in longer ll
    //step in both list in parallel until links to next node matches 
    //T = O(Max(m,n)) S= O(1)
    public static ListNode findIntersectingNode(ListNode ll1, ListNode ll2){
        if(ll1 == null || ll2 == null)
            return null;

        int l1 = 0, l2 = 0, diff = 0;
        ListNode head1 = ll1, head2 = ll2;

        while(head1!= null){
            head1= head1.getNext();
            l1++;
        }
        while(head2!= null){
            head2 = head2.getNext();
            l2++;
        }
        diff = Math.abs(l1 - l2);

        head1 = l1 > l2 ? ll1 : ll2;
        head2 = l1 > l2 ? ll2 : ll1;


        for(int i = 0 ; i< diff ;i++){
            head1 = head1.getNext();
        }

        while(head1!= null && head2!= null){
            if(head1 == head2){
                return head1;
            }
            head1 = head1.getNext();
            head2 = head2.getNext();
        }

        return null;
    }
}
