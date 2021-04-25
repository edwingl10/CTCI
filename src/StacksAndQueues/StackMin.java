package StacksAndQueues;
import java.util.Stack;

public class StackMin extends Stack<Integer>{
    Stack<Integer> mins;

    StackMin(){
        this.mins = new Stack<Integer>();
    }

    void push(int val){
        if(val <= min()){
            mins.push(val);
        }
        super.push(val);
    }
    public Integer pop(){
        if(super.peek() == min()){
            mins.pop();
        }
        return super.pop();
    }

    public int min(){
        if(mins.isEmpty()) return Integer.MAX_VALUE;

        return mins.peek();
    }

    public static void main(String[] args){
        StackMin st = new StackMin();
        st.push(5);
        st.push(10);
        st.push(3);
        st.push(7);
        st.push(3);
        st.push(2);

        st.pop();
        st.pop();
        st.pop();
        st.pop();
        st.pop();

        System.out.println(st.min());
    }

}
