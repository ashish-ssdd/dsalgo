package Queue.Implementation;

public class FixedSizeArrayQueue {

    private int[] queueRep;
    private int size, front, rear, cap;

    private static final int CAPACITY = 16;

    public FixedSizeArrayQueue(){
        cap = CAPACITY;
        queueRep = new int[CAPACITY];
        size= 0; front = 0; rear = 0;
    }
    public FixedSizeArrayQueue(int cap){
        this.cap = cap;
        queueRep = new int[cap];
        size = 0; front = 0 ; rear = 0;
    }

    public void enQueue(int data) throws NullPointerException, IllegalStateException{
        if(size == cap){
            throw new IllegalStateException("Queue is full: Overflow");
        }
        else{
            size++;
            queueRep[rear] = data;
            rear = ((rear+1) % cap);
        }

    }

    public int deQueue() throws IllegalStateException{
        if(size == 0){
            throw new IllegalStateException("Queue is empty: Underflow");

        }
        else{
            size--;
            int data = queueRep[front];
            queueRep[front] = Integer.MIN_VALUE;
            front = (front +1 )% cap;
            return data;
        }
    }

    public boolean isEmpty(){
        return size== 0;
    }

    public boolean isFull(){
        return size == cap;
    }
    public int size(){
        return size;
    }
    
}