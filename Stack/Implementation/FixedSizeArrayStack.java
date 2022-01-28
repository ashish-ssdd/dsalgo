package Stack.Implementation;

public class FixedSizeArrayStack {
    //Length of the array used for stack
    protected int capacity;
    //Default capacity
    public static final int CAPACITY = 10;

    //array used for stack
    protected int[] stackRep;

    //index of the top element of the stack
    protected int top = -1;

    //Initialize stack to the given length
    public FixedSizeArrayStack(int cap){
        capacity = cap;
        stackRep = new int[capacity];
    }
    //Initializes the stack to use array of default length;
    public FixedSizeArrayStack(){
        this(CAPACITY);
    }
    //Return numbers of elements in the stack
    public int size(){
        return top+1;
    }

    //stack empty or not
    public boolean isEmpty(){
        return (top < 0);
    }

    //Insert at the top of stack
    public void push(int data) throws Exception{
        if(size() == capacity)
            throw new Exception("Stack is full.");
        stackRep[++top] = data;
    }

    //return the top element
    public int pop() throws Exception{
        if(isEmpty())
            throw new Exception("Stack is empty");
        int data = stackRep[top];
        stackRep[top--] = Integer.MIN_VALUE;
        return data;
    }



    
}
