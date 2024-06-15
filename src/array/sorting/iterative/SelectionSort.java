package array.sorting.iterative;

/**
 * Selection Sort implementation to sort an array of integers in ascending order.
 * Time Complexity: O(n^2) - where n is the number of elements in the array.
 * Space Complexity: O(1) - constant space used.
 */
public class SelectionSort {

    /**
     * Sorts the given array using Selection Sort algorithm.
     * @param arr The integer array to be sorted.
     */
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        // Iterate through the array
        for (int i = 0; i < n; i++) {
            // Assume the current index has the minimum element
            int minElementIndex = i;

            // Find the index of the minimum element in the remaining unsorted array
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }

            // Swap the found minimum element with the first element of the unsorted part
            int temp = arr[i];
            arr[i] = arr[minElementIndex];
            arr[minElementIndex] = temp;

            // Print array after each pass (optional, for visualization)
            System.out.print("After pass " + (i + 1) + ": ");
            for (int ele : arr) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }

        // Print sorted array
        System.out.print("Sorted Array: ");
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] arr1 = {9, 2, 4, 1, 3, 7};
        System.out.print("Original Array: ");
        for (int ele : arr1) {
            System.out.print(ele + " ");
        }
        System.out.println();
        selectionSort(arr1);
        System.out.println();

        // Test Case 2
        int[] arr2 = {64, 25, 12, 22, 11};
        System.out.print("Original Array: ");
        for (int ele : arr2) {
            System.out.print(ele + " ");
        }
        System.out.println();
        selectionSort(arr2);
        System.out.println();

        // Test Case 3
        int[] arr3 = {5, 4, 3, 2, 1};
        System.out.print("Original Array: ");
        for (int ele : arr3) {
            System.out.print(ele + " ");
        }
        System.out.println();
        selectionSort(arr3);
    }
}
