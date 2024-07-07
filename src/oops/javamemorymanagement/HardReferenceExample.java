package oops.javamemorymanagement;

public class HardReferenceExample {
    public static void main(String[] args) {
        // Creating a hard reference
        String hardRef = new String("Hard Reference");

        // hardRef is a hard reference to the String object
        System.out.println(hardRef);

        // Even if we set hardRef to null, the object will only be eligible for GC if there are no other hard references to it.
        hardRef = null;
    }
}
