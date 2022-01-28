package LinkedList.SinglyLinkedList;


public class ListNode{
    private int data;
    private ListNode next;

    public ListNode(int data){
        this.data = data;
    }

    public ListNode() {
        this.data = Integer.MIN_VALUE;
        this.next = null;

    }

    public void setData(int data){
        this.data = data;
    }

    public int getData(){
        return data;
    }

    public void setNext(ListNode next){
        this.next = next;
    }

    public ListNode getNext(){
        return this.next;
    }
}