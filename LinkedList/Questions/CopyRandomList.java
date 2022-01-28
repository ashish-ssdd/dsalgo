package LinkedList.Questions;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {


public class RandomListNode{
    private int data;
    private RandomListNode next;
    private RandomListNode random;

    public RandomListNode(int data){
        this.data = data;
    }

    public RandomListNode() {
        this.data = Integer.MIN_VALUE;
        this.next = null;
        this.random = null;

    }

    public void setData(int data){
        this.data = data;
    }

    public int getData(){
        return data;
    }

    public void setNext(RandomListNode next){
        this.next = next;
    }
    public void setRandom(RandomListNode random){
        this.random = random;
    }

    public RandomListNode getNext(){
        return this.next;
    }

    public RandomListNode getRandom(){
        return this.random;
    }
}

    
    public RandomListNode copyRandomList(RandomListNode head){
        
        RandomListNode x = head, y;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        while(x != null){
            y = new RandomListNode(x.getData());
            y.setNext(null);
            y.setRandom(null);
            map.put(x,y);
            x = x.getNext();
        }

        x = head;
        while(x != null){
            y = map.get(x);
            y.setNext(map.get(x.getNext()));
            y.setRandom(map.get(x.getRandom()));
            x = x.getNext();
        }

        return map.get(head);
    }
    
}
