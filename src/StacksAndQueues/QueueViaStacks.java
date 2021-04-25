package StacksAndQueues;
import java.util.Stack;

class MyQueue<T>{
    /**
     * Implement a MyQueue class which implements a queue using two stacks.
     */
    Stack<T> oldest, newest;
    MyQueue(){
        oldest = new Stack<T>();
        newest = new Stack<T>();
    }

    public int size(){
        return oldest.size() + newest.size();
    }
    public void add(T value){
        newest.push(value);
    }

    private void shiftStacks(){
        if(!oldest.empty()) return;

        while(!newest.empty()){
            oldest.push(newest.pop());
        }
    }

    public T peek(){
        shiftStacks();
        return oldest.peek();
    }

    public T remove(){
        shiftStacks();
        return oldest.pop();
    }


}

public class QueueViaStacks {
    public static void main(String[] args){
        MyQueue<Integer> mq = new MyQueue<Integer>();
        mq.add(3);
        mq.add(4);
        mq.add(9);
        mq.add(1);

        System.out.println(mq.remove());
        System.out.println(mq.remove());
        System.out.println(mq.remove());
        System.out.println(mq.remove());
    }
}
