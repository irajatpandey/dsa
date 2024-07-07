package oops.abstractclass;

abstract class Car {
    int numberOfWheels;
    Car(int wheels) {
        this.numberOfWheels = wheels;
    }
    public abstract void applyBreak();
    public abstract void applyClutch();

    public int getNumberOfWheels() {
        return this.numberOfWheels;
    }
}
