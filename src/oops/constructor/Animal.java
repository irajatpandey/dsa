package oops.constructor;

class Animal {
    String name;

    // Constructor of the superclass
    public Animal(String name) {
        this.name = name;
        System.out.println("Animal constructor called");
    }
}

class Dog extends Animal {
    String breed;

    // Constructor of the subclass
    public Dog(String name, String breed) {
        super(name);  // Calls the constructor of the superclass
        this.breed = breed;
        System.out.println("Dog constructor called");
    }

    void display() {
        System.out.println("Name: " + name + ", Breed: " + breed);
    }

    public static void main(String[] args) {
        Dog dog = new Dog("Buddy", "Golden Retriever");
        dog.display();
    }
}
