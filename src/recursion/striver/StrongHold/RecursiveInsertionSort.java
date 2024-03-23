package recursion.striver.StrongHold;

import java.util.ArrayList;

public class RecursiveInsertionSort {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(4);
        list.add(5);
        list.add(3);
        list.add(1);

        System.out.println("Original list:");
        System.out.println(list);

        insertionSort(list, list.size());

        System.out.println("\nSorted list:");
        System.out.println(list);
    }

    // Recursive Insertion Sort
    public static void insertionSort(ArrayList<Integer> list, int n) {
        // Base case: If only one element is remaining, list is already sorted
        if (n <= 1)
            return;

        // Insert last element at its correct position in sorted list[0..n-1]
        int last = list.remove(n - 1);
        insertionSort(list, n - 1);
        System.out.println();
        insert(list, last);
    }

    // Recursive function to insert element at its correct position in sorted list
    public static void insert(ArrayList<Integer> list, int element) {
        // Base case: If list is empty or last element is less than or equal to current element, insert at current position
        if (list.isEmpty() || list.get(list.size() - 1) <= element) {
            list.add(element);
            return;
        }

        // Move the last element one position ahead
        int last = list.remove(list.size() - 1);
        System.out.println(list);
        insert(list, element);

        // Restore the last element to the end of the list
        list.add(last);
    }
}