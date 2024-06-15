package array.striver.easy;

/**
 * Finds the length of the maximum consecutive sequence of ones in an array.
 */
public class MaximumConsecutiveOnes {

    /**
     * Finds the length of the maximum consecutive sequence of ones in an array.
     *
     * @param arr The input array of integers containing 0s and 1s.
     * @param n   The number of elements in the array.
     * @return The length of the maximum consecutive sequence of ones.
     *
     * Time Complexity: O(n), where n is the number of elements in the array.
     *                  We iterate through the array once.
     * Space Complexity: O(1), no extra space is used other than a few variables.
     */
    public static int maximumOnes(int[] arr, int n) {
        int max = -1; // Maximum length of consecutive ones found
        int track = 0; // Track the current length of consecutive ones

        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                track++; // Increment the length of consecutive ones
            } else { // When encounter a 0
                max = Math.max(track, max); // Update max if current track is larger
                track = 0; // Reset track for the next potential sequence of ones
            }
        }

        max = Math.max(track, max); // Update max for the last sequence of ones
        return max;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] arr1 = {1, 1, 0, 1, 1, 1};
        int n1 = arr1.length;
        int ans1 = maximumOnes(arr1, n1);
        System.out.println("Test Case 1: " + ans1); // Expected output: 3

        // Test Case 2
        int[] arr2 = {0, 0, 0, 1};
        int n2 = arr2.length;
        int ans2 = maximumOnes(arr2, n2);
        System.out.println("Test Case 2: " + ans2); // Expected output: 1

        // Test Case 3
        int[] arr3 = {1, 1, 1, 1};
        int n3 = arr3.length;
        int ans3 = maximumOnes(arr3, n3);
        System.out.println("Test Case 3: " + ans3); // Expected output: 4
    }
}
