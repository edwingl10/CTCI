package ThreadsAndLocks;

/**
 * In the classic problem FizzBuzz, you are told to print the numbers from 1  to n.
 * However, when the number is  divisible by 3,  print "Fizz''. When it is  divisible by 5,
 * print "Buzz''. When it is divisible by 3 and 5, print"FizzBuzz''.
 * In this problem, you are asked to do this in a multithreaded way.
 * Implement a multithreaded version of FizzBuzz with four threads.
 * One thread checks for divisibility of 3 and prints"Fizz''.
 * Another thread is responsible for divisibility of 5 and prints"Buzz''.
 * A third thread is responsible for divisibility of 3 and 5 and prints "FizzBuzz''.
 * A fourth thread does the numbers.
 */

class FizzBuzzThread extends Thread{
    private static Object lock = new Object();
    protected static int current = 1;
    private int max;
    private boolean div3, div5;
    private String toPrint;

    public FizzBuzzThread(boolean div3, boolean div5, int max, String toPrint){
        this.div3 = div3;
        this.div5 = div5;
        this.max = max;
        this.toPrint = toPrint;
    }

    public void print(){
        System.out.println(toPrint);
    }

    public void run(){
        while(true){
            synchronized (lock){
                if(current > max)
                    return;
                if((current % 3 == 0) == div3 && (current % 5 == 0) == div5){
                    print();
                    current++;
                }
            }
        }
    }
}

class NumberThread extends FizzBuzzThread {
    public NumberThread(boolean div3, boolean div5, int max){
        super(div3, div5, max, null);
    }

    public void print(){
        System.out.println(current);
    }
}

public class FizzBuzz {
    public static void main(String[] args){
        int n = 20;
        Thread[] threads = {new FizzBuzzThread(true, true, n, "FizzBuzz"),
        new FizzBuzzThread(true, false, n, "Fizz"),
        new FizzBuzzThread(false, true, n, "Buzz"),
        new NumberThread(false, false, n)};

        for(Thread thread: threads)
            thread.start();
    }
}
