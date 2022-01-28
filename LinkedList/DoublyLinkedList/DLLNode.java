package LinkedList.DoublyLinkedList;

public class DLLNode{
    private int data;
    private DLLNode next,prev;

    public DLLNode(int data, DLLNode prev, DLLNode next){
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
    
    public DLLNode(int data){
        this.data = data;
        next = null;
        prev = null;
    }

    public int getData(){
        return this.data;
    }

    public void setData(int data){
        this.data = data;
    }
    public DLLNode getNext(){
        return this.next;
    }

    public DLLNode getPrev(){
        return this.prev;
    }

    public void setNext(DLLNode next){
        this.next = next;
    }

    public void setPrev(DLLNode prev){
        this.prev = prev;
    }

}