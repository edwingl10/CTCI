package ThreadsAndLocks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * In the famous dining philosophers problem, a bunch of philosophers are sitting around a
 * circular table with one chopstick between each of them. A philosopher needs both chopsticks to eat,
 * and always picks up the left chopstick before the right one. A deadlock could potentially occur if all
 * the philosophers reached for the left chopstick at the same time. Using threads and locks,
 * implement a simulation of the dining philosophers problem that prevents deadlocks
 */

// implement strategy where a philosopher will put down left chopstick if unable to obtain right one
class ChopStick{
    private Lock lock;

    public ChopStick(){
        lock = new ReentrantLock();
    }

    public boolean pickUp(){
        return lock.tryLock();
    }
    public void putDown(){
        lock.unlock();
    }
}

class Philosopher extends Thread{
    private int bites = 10;
    private ChopStick left, right;

    public Philosopher(ChopStick left, ChopStick right){
        this.left = left;
        this.right = right;
    }
    public void eat(){
        if(pickUp()){
            chew();
            putDown();
        }
    }
    public boolean pickUp(){
        if(!left.pickUp())
            return false;
        if(!right.pickUp()){
            left.putDown();
            return false;
        }
        return true;
    }
    public void chew(){}
    public void putDown(){
        left.putDown();
        right.putDown();
    }

    public void run(){
        for(int i=0; i<bites; i++)
            eat();
    }
}

/**
//can label chopsticks from 0 to N-1. Each philosopher goes for left chopstick before right one, except for
// philosopher who does this in reverse. This will break the cycle
public class Philosopher extends Thread{
    private int bites = 10;
    private ChopStick lower, higher;
    private int index;

    public Philosopher(int i, ChopStick left, ChopStick right){
        index = i;
        if(left.getNumber() < right.getNumber()){
            this.lower = left;
            this.higher = right;
        }
        else{
            this.lower = right;
            this.higher = left;
        }
    }

    public void eat(){
        pickUp();
        chew();
        putDown();
    }
    public void pickUp(){
        lower.pickUp();
        higher.pickUp();
    }
    public void chew(){}
    public void putDown(){
        higher.putDown();
        lower.putDown();
    }

    public void run(){
        for(int i=0; i<bites; i++
            eat();
    }
}

class Chopstick{
    private Lock lock;
    private int number;

    public Chopstick(int n){
        lock = new ReentrantLock();
        this.number = n;
    }
    public void pickUp(){
        lock.lock();
    }
    public void putDown(){
        lock.unlock();
    }
    public int getNumber(){
        return number;
    }
}
*/

public class DinningPhilosophers {}
