package oops.abstractclass;

public class Main {
    public static void main(String[] args) {
        Audi a1 = new Audi("A8");
        a1.applyBreak();
        a1.applyClutch();
        a1.applyEmergencyBreak();
        int wheels = a1.getNumberOfWheels();
        System.out.println(wheels);
    }
}
