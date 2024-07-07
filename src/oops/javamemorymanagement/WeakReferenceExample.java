package oops.javamemorymanagement;

import java.lang.ref.WeakReference;

public class WeakReferenceExample {
    public static void main(String[] args) {
        // Creating a weak reference to a String object
        String strongRef = new String("Weak Reference Example");
        WeakReference<String> weakRef = new WeakReference<>(strongRef);

        // The object is still strongly reachable through strongRef
        System.out.println("Before nullifying strongRef: " + weakRef.get());

        // Nullifying the strong reference
        strongRef = null;

        // Now the object is only weakly reachable through weakRef
        System.out.println("After nullifying strongRef: " + weakRef.get());

        // Suggesting the garbage collector to run (not guaranteed)
        System.gc();

        // Checking if the object is reclaimed
        System.out.println("After GC: " + weakRef.get());
    }
}
