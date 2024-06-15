package array.striver.easy;

// Leetcode - 1752
// https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/
public class CheckArraySortedAndRotated {

    /**
     * Checks if an array is sorted and rotated.
     *
     * @param n   The number of elements in the array.
     * @param arr The array of integers to check.
     * @return True if the array is sorted and rotated, false otherwise.
     *
     * Time Complexity: O(n), where n is the number of elements in the array.
     *                  We iterate through the array once.
     * Space Complexity: O(1), no extra space is used other than a few variables.
     */
    public static boolean isSortedAndRotated(int n, int[] arr) {
        int k = 0; // Count of inversions

        for (int i = 0; i < n; i++) {
            // Compare current element with the next element in a circular manner
            if (arr[i] > arr[(i + 1) % n]) {
                k++; // Increase inversion count if current element is greater than the next
            }
            if (k > 1) {
                return false; // If more than one inversion is found, array is not sorted and rotated
            }
        }
        return true; // If at most one inversion is found, array is sorted and rotated
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 2};
        int n = arr.length;

        // Check if the array is sorted and rotated
        if (isSortedAndRotated(n, arr)) {
            System.out.println("Sorted and Rotated");
        } else {
            System.out.println("Not Sorted and Rotated");
        }
    }
}
