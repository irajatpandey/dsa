package array.sorting.iterative;

/**
 * Bubble Sort implementation to sort an array of integers in ascending order.
 * Time Complexity: O(n^2) - where n is the number of elements in the array.
 * Space Complexity: O(1) - constant space used.
 */
public class BubbleSort {

    /**
     * Sorts the given array using Bubble Sort algorithm.
     * @param arr The integer array to be sorted.
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        // Perform n-1 passes
        for (int i = 0; i < n; i++) {
            // Perform comparisons and swaps within the unsorted portion
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

            // Print array after each pass (optional, for visualization)
            System.out.println("After pass " + (i + 1) + ":");
            for (int ele : arr) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }

        // Print sorted array
        System.out.println("Sorted Array:");
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] arr1 = {9, 3, 4, 2, 5, 6, 8, 7, 1};
        System.out.println("Original Array:");
        for (int ele : arr1) {
            System.out.print(ele + " ");
        }
        System.out.println();
        bubbleSort(arr1);
        System.out.println();

        // Test Case 2
        int[] arr2 = {5, 1, 4, 2, 8};
        System.out.println("Original Array:");
        for (int ele : arr2) {
            System.out.print(ele + " ");
        }
        System.out.println();
        bubbleSort(arr2);
        System.out.println();

        // Test Case 3
        int[] arr3 = {1, 2, 3, 4, 5};
        System.out.println("Original Array:");
        for (int ele : arr3) {
            System.out.print(ele + " ");
        }
        System.out.println();
        bubbleSort(arr3);
    }
}
