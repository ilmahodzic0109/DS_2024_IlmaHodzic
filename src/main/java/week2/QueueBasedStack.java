package week2;

import java.util.NoSuchElementException;

public class QueueBasedStack<Data> {
    private Queue<Data> q1;
    private Queue<Data> q2;

    public QueueBasedStack() {
        q1= new Queue<>();
        q2= new Queue<>();
    }

    public void push(Data data) {
        q2.enqueue(data);
        while(!q1.isEmpty()){
            q2.enqueue(q1.peek());
            q1.dequeue();
        }
        Queue<Data> temp=q1;
        q1=q2;
        q2=temp;
    }

    public Data pop() {
        if (q1.isEmpty())
            return null;
        return q1.dequeue();
    }

    public Data peek() {
        if(q1.isEmpty())
            throw new NoSuchElementException("The queue is empty.");
        return q1.peek();
    }

    public int size() {

        return q1.size();
    }

    public boolean isEmpty() {

        return q1.isEmpty();
    }
}
