package StacksAndQueues;
import java.util.LinkedList;

class Animal{
    private int order;
    String name;
    Animal(String n){this.name = n;}
    public void setOrder(int ord){this.order = ord;}
    public int getOrder(){return this.order;}

    public boolean isOlderThan(Animal a){
        return this.order < a.getOrder();
    }
}
class Dog extends Animal{
    Dog(String n){super(n);}
}
class Cat extends Animal{
    Cat(String n){super(n);}
}
class AnimalQueue{
    LinkedList<Dog> dogs = new LinkedList<Dog>();
    LinkedList<Cat> cats = new LinkedList<Cat>();
    private int order = 0; //timestamp

    public void enqueue(Animal a){
        a.setOrder(order);
        order++;

        if(a instanceof Dog) dogs.addLast((Dog) a);
        else if(a instanceof Cat) cats.addLast((Cat) a);
    }

    public Dog dequeueDog(){
        return dogs.poll();
    }

    public Cat dequeueCat(){
        return cats.poll();
    }

    public Animal dequeueAny(){
        if(dogs.isEmpty()) return cats.poll();
        if(cats.isEmpty()) return dogs.poll();

        Dog d = dogs.peek();
        Cat c = cats.peek();

        if(d.getOrder() < c.getOrder()) return dequeueDog();
        return dequeueCat();
    }

}


public class AnimalShelter {
    /**
     * An animal shelter, which holds only dogs and cats, operates on a strictly"first in, first out" basis.
     * People must adopt either the "oldest" (based on arrival time) of all animals at the shelter, or
     * they can select whether they would prefer a dog or a cat (and will receive the oldest animal of that type).
     * They cannot select which specific animal they would like. Create the data structures to maintain this system
     * and implement operations such as enqueue, dequeueAny, dequeueDog, and dequeueCat.
     * You may use the built-in Linkedlist data structure.
     */
    public static void main(String args[]){
        AnimalQueue aq = new AnimalQueue();
        Dog d = new Dog("carl");
        Dog d2 = new Dog("bob");
        Dog d3 = new Dog("cooper");

        Cat c = new Cat("cotton");
        Cat c1 = new Cat("furball");


        aq.enqueue(d);
        aq.enqueue(d2);
        aq.enqueue(c);
        aq.enqueue(d3);
        aq.enqueue(c1);

        System.out.println(aq.dequeueAny().name);
        System.out.println(aq.dequeueAny().name);
        System.out.println(aq.dequeueAny().name);
        System.out.println(aq.dequeueAny().name);
        System.out.println(aq.dequeueAny().name);
    }
}
