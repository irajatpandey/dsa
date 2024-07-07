package oops.constructor;

class Singleton {
    private static Singleton instance;

    private Singleton() {
        // private constructor to prevent instantiation
        System.out.println("Inside Constructor");
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
public class Main {
    public static void main(String[] args) {
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();
        if(obj1 == obj2) {
            System.out.println("Same");
        }
        else{
            System.out.println("Different");
        }
    }
}
