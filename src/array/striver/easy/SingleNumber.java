package array.striver.easy;

/**
 * Find the single number in an array where every other element appears twice.
 */
public class SingleNumber {

    /**
     * Finds the single number in the array using XOR operation.
     *
     * @param arr The input array of integers.
     * @param n   The number of elements in the array.
     * @return The single number that appears only once in the array.
     *
     * Time Complexity: O(n), where n is the number of elements in the array.
     *                  We traverse through the array once.
     * Space Complexity: O(1), as we use a constant amount of extra space (only one integer).
     */
    public static int singleNumber(int[] arr, int n) {
        int ans = 0; // Initialize the result

        // Perform XOR of all elements in the array
        for (int i = 0; i < n; i++) {
            ans ^= arr[i];
        }

        return ans; // Return the single number
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] arr1 = {1, 2, 1, 2, 4};
        int n1 = arr1.length;
        System.out.println("Test Case 1: " + singleNumber(arr1, n1)); // Expected output: 4

        // Test Case 2
        int[] arr2 = {2, 2, 1};
        int n2 = arr2.length;
        System.out.println("Test Case 2: " + singleNumber(arr2, n2)); // Expected output: 1

        // Test Case 3
        int[] arr3 = {4, 1, 2, 1, 2};
        int n3 = arr3.length;
        System.out.println("Test Case 3: " + singleNumber(arr3, n3)); // Expected output: 4
    }
}
