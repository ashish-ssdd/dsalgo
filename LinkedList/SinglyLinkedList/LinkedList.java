package LinkedList.SinglyLinkedList;

public class LinkedList{

    public LinkedList(){
        length = 0;
        
    }

    ListNode head;
    private int length = 0 ;
    //Traverse or give size of linkedList
    public int ListLength(ListNode headNode){
        int length = 0 ;
        ListNode currentNode = headNode;

        while(currentNode != null){
            length++;
            currentNode = currentNode.getNext();
        }

        return length;
    }

    //Retrun head of linkedList
    public synchronized ListNode getHead(){
        return head;
    }

    //Insert a node at the beginning of the list
    //Set next of new node as head 
    //then update head = newNode
    public synchronized void insertAtBegin(ListNode node){
        node.setNext(head);
        head = node;
        length++;
    }

    //Insert a node at the end of the list
    public synchronized void insertAtEnd(ListNode node){
        if(head == null){
            head = node;
        }
        else{
            ListNode p,q;
            //Traverse the list until p point to last Node
            for(p = head ; (q = p.getNext()) != null ; p = q);
            p.setNext(node);

        }
        length++;
        
    }

    //Insert at a position
    public void insert(int data, int position){
        if(position < 0) 
            position = 0;
        if(position > length)
            position = length;
        //if head is empty make it head
        if(head == null)
            head = new ListNode(data);
        //adding at the begining of the list
        else if(position == 0){
            insertAtBegin(new ListNode(data));
            return;
        }
        //find the correct position and add
        else{
            ListNode temp = head;

            for(int i=1 ; i< position; i++){
                temp = temp.getNext();
            }

            ListNode newNode = new ListNode(data);
            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
        }
        length++;
    }

    //Remove and return node from the end of linkedList
    public synchronized ListNode removeFromEnd(){
        if(head == null)
            return null;
        ListNode p = head, q = null , next = head.getNext();
        if(next == null){
            head = null;
            return p;
        }
        while((next = p.getNext()) != null){
            q = p;
            p = next;
        } 
        q.setNext(null);
        return p;
    }

    //Remove a specific node 
    public synchronized void removeMatched(ListNode node){
        if(head == null)
            return;
        if(head == node){
            head = head.getNext();
            return;
        }
        ListNode p = head, q = null;

        while((q = p.getNext())!= null){
            if(node.equals(q)){
                p.setNext(q.getNext());
                return;
            }
            p = q;
        }
    }

    //Remove from a specific position
    public void remove(int position){
        //fix position
        if(position < 0)
            position = 0;
        if(position >= length)
            position = length -1;
        
        if(head == null)
            return;
        if(position == 0)
            head = head.getNext();
        
        else{
            ListNode temp = head;
            for(int i = 0 ; i< position ;i++){
                temp = temp.getNext();
            }
            temp.setNext(temp.getNext().getNext());
        }
        length--;
    }

    //Return a string representation of this collection, in the form |"str1","str2",...|
    public String toString(){
        String result = "[";
        if(head == null)
            return result + "]";
        result = result + head.getData();

        ListNode temp = head.getNext();

        while(temp!= null){
            result += ","+temp.getData();
            temp = temp.getNext();
        }
        return result+"]";
    }

    //Return current Length of list
    public int length(){
        return length;
    }

    //Find position of first value that is equal to a given value
    public int getPosition(int data){
        ListNode temp = head;

        int pos = 0;

        while(temp != null){
            if(temp.getData() == data){
                return pos;
            }
            temp = temp.getNext();
            pos++;
        }

        return Integer.MIN_VALUE;
        
    }
    //Remove everything from the list
    public void clearList(){
        head = null;
        length = 0 ;
    }
}