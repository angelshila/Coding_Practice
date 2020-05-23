package Q6_Animal_Shelter;

import java.util.LinkedList;

public class AnimalQueue {
    //Enqueue
    //Dequeue Any
    //Dequeue Dog
    //Dequeue Cat
    //Peek
    //isEmpty

    LinkedList<Dog> dogs = new LinkedList<>();
    LinkedList<Cat> cats = new LinkedList<>();
    int order = 0;

    public boolean isEmpty() {
        return (dogs.size() + cats.size()) == 0;
    }

    public Animal peek() {
        if(dogs.isEmpty())
            return cats.peek();
        else if(cats.isEmpty())
            return cats.peek();

        return dogs.peek().isOlderThan(cats.peek())?dogs.peek():cats.peek();
    }

    public void enqueue(Animal a) {
        a.order = order;
        order++;
        if(a instanceof Dog) {
            dogs.add((Dog)a);
        }else {
            cats.add((Cat)a);
        }
    }

    public Animal dequeueAny() {
        if (dogs.isEmpty()){
            return dequeueCats();
        }else if (cats.isEmpty()){
            return dequeueDogs();
        }
        // Both filled
        Dog d = dogs.peek();
        Cat c = cats.peek();

        return d.isOlderThan(c)?dequeueDogs():dequeueCats();
    }

    private Animal dequeueCats() {
        return cats.poll();
    }

    private Animal dequeueDogs() {
        return dogs.poll();
    }

    public static void main(String[] args) {
        AnimalQueue animals = new AnimalQueue();
        animals.enqueue(new Cat("Callie"));
        animals.enqueue(new Cat("Kiki"));
        animals.enqueue(new Dog("Fido"));
        animals.enqueue(new Dog("Dora"));
        animals.enqueue(new Cat("Kari"));
        animals.enqueue(new Dog("Dexter"));
        animals.enqueue(new Dog("Dobo"));
        animals.enqueue(new Cat("Copa"));

        System.out.println(animals.dequeueAny().name());
        System.out.println(animals.dequeueAny().name());
        System.out.println(animals.dequeueAny().name());

        animals.enqueue(new Dog("Dapa"));
        animals.enqueue(new Cat("Kilo"));

        while (!animals.isEmpty()) {
            System.out.println(animals.dequeueAny().name());
        }
    }

}

 abstract class Animal {

    String name;
    int order;

    public Animal(String name) {
        this.name = name;
    }

    public abstract String name ();

    // Lower value of order = older
    public boolean isOlderThan(Animal a) {
        return this.order < a.order;
    }
}

class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    public String name(){
        return "Cat "+name;
    }
}

class Dog extends Animal {

     public Dog(String name){
         super(name);
     }

     public String name() {
         return "Dog "+name;
     }
}

