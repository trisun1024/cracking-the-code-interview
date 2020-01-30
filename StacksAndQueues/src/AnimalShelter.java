import java.util.LinkedList;

public class AnimalShelter {

    // An animal shelter, which holds only dogs and cats, operates on a strictly "first in, first out"
    // basis. People must adopt either the "oldest" of all animals at the shelter, or they can select
    // whether they would prefer a dog or a cat. They cannot select which specific animal they would like.
    // Create the data structures to maintain this system and implement operations such as enqueue,
    // dequeueAny, dequeueDog, and dequeueCat.

    LinkedList<Dog> dogs = new LinkedList<>();
    LinkedList<Cat> cats = new LinkedList<Cat>();
    private int order = 0;

    public void enqueue(Animal a) {
        a.setOrder(order);
        order++;

        if (a instanceof Dog) {
            dogs.addLast((Dog) a);
        } else if (a instanceof Cat) {
            cats.addLast((Cat) a);
        }
    }

    public Animal dequeueAny() {
        if (dogs.size() == 0) {
            return dequeueCats();
        } else if (cats.size() == 0) {
            return dequeueDogs();
        }
        Dog dog = dogs.peek();
        Cat cat = cats.peek();
        if (dog.isOlderThan(cat)) {
            return dequeueDogs();
        } else {
            return dequeueCats();
        }
    }

    public Dog dequeueDogs() {
        return dogs.poll();
    }

    public Cat dequeueCats() {
        return cats.poll();
    }

    static abstract class Animal {
        private int order;
        protected String name;

        public Animal(String n) {
            this.name = n;
        }

        public void setOrder(int ord) {
            this.order = ord;
        }

        public int getOrder() {
            return this.order;
        }

        public boolean isOlderThan(Animal a) {
            return this.order < a.getOrder();
        }
    }

    static class Dog extends Animal {
        Dog(String n) {
            super(n);
        }
    }

    static class Cat extends Animal {
        Cat(String n) {
            super(n);
        }
    }
}
