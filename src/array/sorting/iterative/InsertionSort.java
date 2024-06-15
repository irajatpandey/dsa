package array.sorting.iterative;

/**
 * Insertion Sort implementation to sort an array of integers in ascending order.
 * Time Complexity: O(n^2) - where n is the number of elements in the array.
 * Space Complexity: O(1) - constant space used.
 */
public class InsertionSort {

    /**
     * Sorts the given array using Insertion Sort algorithm.
     *
     * @param arr The integer array to be sorted.
     */
    public static void insertionSort(int[] arr) {
        int n = arr.length;

        // Iterate through the array starting from the second element
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Shift elements of arr[0..i-1], that are greater than key, to one position ahead of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Place the key in its correct position
            arr[j + 1] = key;

        }

        // Print sorted array
        System.out.print("Sorted Array: ");
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] arr1 = {4, 5, 6, 2, 3, 1};
        System.out.print("Original Array: ");
        for (int ele : arr1) {
            System.out.print(ele + " ");
        }
        System.out.println();
        insertionSort(arr1);
        System.out.println();

        // Test Case 2
        int[] arr2 = {12, 11, 13, 5, 6};
        System.out.print("Original Array: ");
        for (int ele : arr2) {
            System.out.print(ele + " ");
        }
        System.out.println();
        insertionSort(arr2);
        System.out.println();

        // Test Case 3
        int[] arr3 = {1, 2, 3, 4, 5};
        System.out.print("Original Array: ");
        for (int ele : arr3) {
            System.out.print(ele + " ");
        }
    }
}