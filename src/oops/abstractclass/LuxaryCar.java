package oops.abstractclass;

abstract class LuxaryCar extends Car {
    LuxaryCar() {
        super(4);
        System.out.println("Inside Luxary Car Constructors");
    }
    @Override
    public void applyBreak() {
        System.out.println("Mechanism for applying break");
    }

    @Override
    public void applyClutch() {
        System.out.println("Mechanism for applying clutch");
    }

    public abstract void applyEmergencyBreak();

}
