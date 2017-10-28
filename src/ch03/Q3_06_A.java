package ch03;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jun097kim on 2017-10-28.
 */
public class Q3_06_A {
    public static void main(String[] args) {
        AnimalShelter animalShelter = new AnimalShelter();

        animalShelter.enqueue(new Cat());
        animalShelter.enqueue(new Dog());
        animalShelter.enqueue(new Dog());
        animalShelter.enqueue(new Cat());
        animalShelter.enqueue(new Cat());

        System.out.println(animalShelter.dequeueDog().animalNo);
        System.out.println(animalShelter.dequeueAny().animalNo);
        System.out.println(animalShelter.dequeueCat().animalNo);
    }
}

class AnimalShelter {
    private Queue<Dog> dogQueue = new LinkedList<>();
    private Queue<Cat> catQueue = new LinkedList<>();

    void enqueue(Animal element) {
        if (element instanceof Dog) {
            dogQueue.add((Dog) element);
        } else if (element instanceof Cat) {
            catQueue.add((Cat) element);
        }
    }

    Animal dequeueAny() {
        if (dogQueue.size() == 0 && catQueue.size() == 0) {
            return null;
        } else if (dogQueue.size() == 0) {
            return catQueue.remove();
        } else if (catQueue.size() == 0) {
            return dogQueue.remove();
        }

        if (dogQueue.peek().animalNo < catQueue.peek().animalNo) {
            return dogQueue.remove();
        } else {
            return catQueue.remove();
        }
    }

    Dog dequeueDog() {
        return dogQueue.poll();
    }

    Cat dequeueCat() {
        return catQueue.poll();
    }
}

class Animal {
    private static int i;
    int animalNo;

    Animal() {
        animalNo = i++;
    }
}

class Dog extends Animal {
}

class Cat extends Animal {
}
