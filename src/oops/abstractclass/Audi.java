package oops.abstractclass;

public class Audi extends LuxaryCar {
    String model;
    Audi(String model) {
        this.model = model;
    }
    @Override
    public void applyEmergencyBreak() {
        System.out.println("Mechanism to apply emergency Break!");
    }
}
