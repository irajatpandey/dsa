package oops.constructor;

class Vehicle {
    String type;
    int wheels;

    // No-argument constructor
    public Vehicle() {
        this("Car", 4);  // Calls the parameterized constructor
        System.out.println("No-argument constructor called");
    }

    // Parameterized constructor
    public Vehicle(String type, int wheels) {
        this.type = type;
        this.wheels = wheels;
        System.out.println("Parameterized constructor called");
    }

    void display() {
        System.out.println("Type: " + type + ", Wheels: " + wheels);
    }

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.display();
    }
}

