package LinkedList;

/*
public class UnrolledLinkedList<E> extends AbstractList<E> implements List<E>, Serializable {
    //maximum capacity that can be stored in a single node
    private int nodeCapacity;
    //Current Size of list
    private int size = 0 ;
    //first and last node of list
    private ListNode firstNode;
    private ListNode lastNode;
    //Empty list with specified capacity
    public UnrolledLinkedList(int nodeCapacity) throws IllegalArgumentException{
        if(nodeCapacity < 8){
            throw new IllegalArgumentException("node capacity < 8");
        }
        this.nodeCapacity = nodeCapacity;
        firstNode = new ListNode();
        lastNode = firstNode;

    } 
    public UnrolledLinkedList(){
        this(16);
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    private class ListNode{
        ListNode next;
        ListNode previous;
        int numElements = 0;
        Object[] elements;

        ListNode(){
            elements = new Object[nodeCapacity];
        }
    }

    private class ULLIterator implements ListIterator<E>{
        ListNode currentNode;
        int ptr;
        int index;
        private int expectedModCount = modCount;
        ULLIterator(ListNode node, int ptr, int index){
            this.currentNode = node;
            this.ptr = ptr;
            this.index = index;
        }

        public boolean hasNext(){
            return (index< size- 1);
        }

        public E next(){
            ptr++;
            if(ptr >= currentNode.numElements){
                if(currentNode.next != null){
                    currentNode = currentNode.next;
                    ptr = 0;
                }
                else{
                    throw new NoSuchElementException();
                }
            }
        }
    }
    //Remove first occurrence of specified element from this list
    public boolean remove(Object o){
        int index = 0 ;
        ListNode node = firstNode;

        if(o == null){
            while(node != null){
                for(int ptr = 0; ptr < node.numElements; ptr++){
                    if(node.elements[ptr] == null){
                        removeFromNode(node, ptr);
                        return true;
                    }
                }
                index += node.numElements;
                node = node.getNext();
            }
        
        }
    }
    public boolean contains(Object o){
        return (indexOf(o) != -1);
    }


    public Iterator<E> iterator(){
        return new ULLIterator(firstNode, 0, 0);
    }

    //add to the end of the list
    public boolean add(E e){
        insertIntroNode(lastNode, lastNode.numElements , e);
        return true;
    }
}

*/