package StacksAndQueues;
import java.util.Stack;

public class SortStack {
    /**
     * Write a program to sort a stack such that the smallest items are on the top.
     * You can use an additional temporary stack, but you may not copy the elements into
     * any other data structure (such as an array). The stack supports the following
     * operations: push, pop, peek, and is Empty.
     */

    void sort(Stack<Integer> s){
        Stack<Integer> sorted = new Stack<Integer>();

        while(!s.empty()){
            int temp = s.pop();
            while(!sorted.empty() && sorted.peek() > temp){
                s.push(sorted.pop());
            }
            sorted.push(temp);
        }

        while(!sorted.empty()){
            s.push(sorted.pop());
        }
    }

    public static void main(String[] args){
        SortStack ss = new SortStack();
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(7);
        stack.push(10);
        stack.push(5);
        stack.push(1);
        stack.push(3);
        stack.push(8);

        ss.sort(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

}
