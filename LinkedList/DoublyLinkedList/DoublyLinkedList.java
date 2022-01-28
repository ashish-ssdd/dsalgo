package LinkedList.DoublyLinkedList;

public class DoublyLinkedList{

    private DLLNode head;
    private DLLNode tail;
    private int length;

    public DoublyLinkedList(){
        head = null;
        tail = null;
        length = 0;
    }

    //Get the value at a given position
    public int get(int position){
        if(length == 0)
            return Integer.MIN_VALUE;
        if(position < 0 ) position = 0;
        if(position >= length) position = length-1;

        int count = 0 ;
        DLLNode temp = head;
        while(count < position){
            temp = temp.getNext();
            count++;
        }
        return head==null ? Integer.MIN_VALUE : temp.getData();        

    }

    //Get the position of node whose value is equal to a given value
    public int getPosition(int data){
        DLLNode temp = head;
        int pos = 0 ;
        while(temp != null){
            if(temp.getData() == data){
                return pos;
            }
            pos++;
            temp = temp.getNext();
        }
        //no pos found return invalid position
        return Integer.MIN_VALUE;
    }

    //Return current length
    public int getLength(){
        return length;
    }

    //Add a new value at the front
    public void insertAtBegin(int newValue){
        DLLNode newNode = new DLLNode(newValue, null, head);
        if(head !=null){
            newNode.getNext().setPrev(newNode);   
        }else{
            tail = newNode;
        }
        head= newNode;
        length++;
    }

    public void insertAtEnd(int newValue){
        //If the list is empty insertAtBegin and insertAtEnd are same
       if(head == null){
           insertAtBegin(newValue);
           return;
       }
       DLLNode newNode = new DLLNode(newValue, tail, null);
       newNode.getPrev().setNext(newNode);
       tail = newNode;
       length++;
    }

    //Add new value to the list at a given position
    public void insert(int data, int position){
        //fix position
        if(position < 0){
            position = 0;
            insertAtBegin(data);
            return;
        }
        else if(position >= length){
            position = length -1;
            insertAtEnd(data);
            return;
        }

        DLLNode temp = head;
        for(int i = 0; i< position ; i++){
            temp = temp.getNext();
        }
        DLLNode newNode = new DLLNode(data, temp, temp.getNext());
        temp.setNext(newNode);
        newNode.getNext().setPrev(newNode);
        length++;
    }
    public void clearList(){
        head = null;
        tail = null;
        length = 0;
    }
    public int removeHead(){
        if(head == null)
            return Integer.MIN_VALUE;
        length--;
        DLLNode temp = head;
        int data = temp.getData();
        //if its a single node in list
        if(temp.getNext() == null){
            clearList();
        }
        else{
            temp = temp.getNext();
            head.setNext(null);
            temp.setPrev(null);
            head = temp;
        }
        return data; 
    }
    
    public int removeTail(){
        if(tail ==null){
            return Integer.MIN_VALUE;
        }
        length--;
        DLLNode temp = tail;
        int data = temp.getData();
        //if its a single node in list
        if(temp.getPrev() == null){
            clearList();
        }    
        tail = temp.getPrev();
        tail.setNext(null);
        temp.setPrev(null);
        return data;
    }    
    
    //remove from a given position
    public int remove(int position){
        //fix position
        if(position <= 0)
            return removeHead();
        else if(position >= length-1)
            return removeTail();
        
        DLLNode temp = head;
        for(int i = 0; i< position ; i++){
            temp = temp.getNext();
        }
        DLLNode del = temp.getNext();
        temp.setNext(del.getNext());
        del.getNext().setPrev(temp);
        del.setNext(null);
        del.setPrev(null);
        length--;
        return del.getData();
    }

    //Remove a node with match witha given node
    public void removeMatched(DLLNode node){
        if(head == null){
            return;
        }
        if(node.equals(head)){
            removeHead();
        }
        DLLNode temp = head.getNext();
        while(temp != null){
            if(node.equals(temp)){
                temp.getPrev().setNext(temp.getNext());
                temp.getNext().setPrev(temp.getPrev());
                temp.setNext(null);
                temp.setPrev(null);
                return;

            }
            temp = temp.getNext();
        }
    }

}