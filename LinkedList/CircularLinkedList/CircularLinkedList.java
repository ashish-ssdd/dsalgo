package LinkedList.CircularLinkedList;

public class CircularLinkedList {
    protected CLLNode tail;
    protected int length;

    public CircularLinkedList(){
        tail = null;
        length = 0;
    }

    //Add to head of list
    public void addToHead(int data){
        CLLNode newNode = new CLLNode(data);
        //First node
        if(tail == null){
            tail = newNode;
            tail.setNext(tail);
        }
        else{
            newNode.setNext(tail.getNext());
            tail.setNext(newNode);
        }
        length++;
    }

    public void addToTail(int data){
        addToHead(data);
        tail = tail.getNext();
    }

    //Return data at head of list
    public int peek(){
        return tail.getNext().getData();

    }

    public int tailPeek(){
        return tail.getData();
    }
    public boolean isEmpty(){
        return tail==null;
    }
    public int removeFromHead(){
        if(isEmpty()){
            return Integer.MIN_VALUE;
        }
        CLLNode temp = tail.getNext();
        if(tail == tail.getNext()){
            tail = null;
        } else{
            tail.setNext(temp.getNext());
            temp.setNext(null);
        }
        length--;
        return temp.getData();
    }

    public int removeFromTail(){
        if(isEmpty())
            return Integer.MIN_VALUE;
        CLLNode finger = tail;
        while(finger.getNext() != tail){
            finger = finger.getNext();
        }
        CLLNode temp = tail;
        if(finger == tail){
            tail = null;
        }
        else{
            finger.setNext(tail.getNext());
            tail = finger;
        }
        length--;
        return temp.getData();
    }

    public boolean contains(int data){
        if(tail == null)
            return false;
        CLLNode finger = tail.getNext();
        while(finger!= tail && (!(finger.getData() == data))){
            finger = finger.getNext();
        }

        return finger.getData() == data;
    }

    //Removes and returns element equal to data 
    public int remove(int data){
        if(tail == null) return Integer.MIN_VALUE;
        CLLNode finger = tail.getNext();
        CLLNode previous = tail;
        int compares = 0;
        for(compares = 0 ; compares < length && (!(finger.getData() == data)); compares++){
            previous = finger;
            finger = finger.getNext();
        }
        if(finger.getData() == data){
            if(tail == tail.getNext()){
                tail = null;
            }
            else{
                if(finger == tail)
                    tail = previous;
                previous.setNext(previous.getNext().getNext());
            }
            finger.setNext(null);
            length--;
            return finger.getData();
        }
        return Integer.MIN_VALUE;
    }
}
