package array.striver.easy;

public class CheckArraySorted {

    /**
     * Checks if an array of integers is sorted in non-decreasing order.
     *
     * @param n   The number of elements in the array.
     * @param arr The array of integers to check.
     * @return True if the array is sorted, false otherwise.
     *
     * Time Complexity: O(n), where n is the number of elements in the array.
     *                  We iterate through the array once.
     * Space Complexity: O(1), no extra space is used other than a few variables.
     */
    public static boolean isSorted(int n, int[] arr) {
        for (int i = 1; i < n; i++) {
            // Compare each element with its previous element
            if (arr[i - 1] > arr[i]) {
                return false; // If any element is greater than its next element, array is not sorted
            }
        }
        return true; // If all elements are in non-decreasing order, array is sorted
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int n = arr.length;

        // Check if the array is sorted
        if (isSorted(n, arr)) {
            System.out.println("Sorted");
        } else {
            System.out.println("Not Sorted!");
        }
    }
}
