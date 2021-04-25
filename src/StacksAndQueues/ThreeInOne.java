package StacksAndQueues;

class MultiStack{
    /**
     * Describe how you could use a single array to implement three stacks
     */
    int stack[];
    int tops[];
    int lengths[];
    int defaultSize;


    MultiStack(int totalStacks, int defaultSize){
        this.defaultSize = defaultSize;
        this.stack = new int[totalStacks * defaultSize]; // acutal stack
        this.tops = new int[totalStacks]; // keeps track of top for each stack
        this.lengths = new int[totalStacks]; // keeps track of the length for each stack

        for(int i=0; i<totalStacks; i++){
            tops[i] = defaultSize * i-1;
            lengths[i] = 0;
        }
    }

    void add(int stack, int item) throws Exception{
        if(isFull()) throw new Exception("stack is full");
        if(stack >= this.tops.length) throw new Exception("That stack does not exist");
        // if adjacent stack has no values, move head pointer of adjacent stack
        if(this.tops[stack] == this.tops[(stack+1) % this.tops.length]){
            this.tops[(stack+1) % this.tops.length] += 1 % this.stack.length;
        }
        // if adjacent stack has elements
        else if(this.stack[(this.tops[stack]+1) % this.stack.length] !=0 ){
            moveAdjacentStack(this.tops[(stack+1) % this.tops.length], (stack+1) % this.tops.length);
        }


        this.tops[stack] = (this.tops[stack] + 1) % this.stack.length;
        this.stack[this.tops[stack]] = item;
        this.lengths[stack]++;
    }

    int remove(int stack) throws Exception{
        if(stack >= this.tops.length) throw new Exception("stack does not exist");
        if(isEmpty(stack)) throw new Exception("stack is empty");

        int result = peek(stack);
        this.stack[this.tops[stack]] = 0;
        this.tops[stack] = (this.tops[stack] -1) % this.stack.length;
        this.lengths[stack]--;
        return result;
    }

    int peek(int stack) throws Exception{
        if(stack >= this.tops.length) throw new Exception("stack does not exist");
        if(isEmpty(stack)) throw new Exception("stack is empty");
        return this.stack[this.tops[stack]];
    }

    boolean isEmpty(int stack) throws Exception{
        if(stack >= this.tops.length) throw new Exception("stack does not exist");
        return this.lengths[stack] == 0;
    }

    // returns if entire stack is full
    boolean isFull(){
        int total = 0;
        for(int i=0; i<this.lengths.length; i++){total+= this.lengths[i];}

        return total == this.stack.length;
    }


    // shifts items from adjacent stack
    private void moveAdjacentStack(int oldStackHead, int stackNum){
        if(oldStackHead+1 == this.tops[(stackNum +1) % this.tops.length]){
            moveAdjacentStack(this.tops[(stackNum+1) % this.tops.length], (stackNum+1) % this.tops.length);
        }

        for(int i=0; i<this.lengths[stackNum]; i++){
            this.stack[this.tops[stackNum] - i +1] = this.stack[this.tops[stackNum] -i];
        }
        this.tops[stackNum] = (this.tops[stackNum] + 1) % this.stack.length;

    }

    // for debugging purposes
    void printStack(){
        System.out.print("[ ");
        for(int i=0; i<stack.length; i++){
            System.out.print(stack[i]+",");
        }
        System.out.println(" ]");
    }

}


public class ThreeInOne {
    public static void main(String[] args) throws Exception{
        MultiStack st = new MultiStack(3, 5);

        st.add(0,3);
        st.add(0,4);
        st.add(0,23);
        st.add(0,12);
        st.add(0,1);
        st.add(0,11);
        st.add(1, 9);
        st.add(1, 8);
        st.add(1, 15);
        st.add(2, 7);
        st.add(0,13);
        st.add(0, 17);
        st.add(2, 34);
        st.add(1, 81);

        st.remove(0);
        st.remove(0);
        st.remove(0);

        st.add(2,17);
        st.add(2,13);
        st.add(2, 77);
        st.remove(1);

        System.out.println("========= DEBUGGING Stack =========");
        st.printStack();
        System.out.println(st.peek(1));
    }
}
