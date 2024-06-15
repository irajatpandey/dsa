package array.striver.easy;

import java.util.HashMap;

/**
 * Finds the length of the longest subarray with a sum equal to k.
 */
public class LongestSubArrayWithKSum {

    /**
     * Finds the length of the longest subarray with a sum equal to k.
     *
     * @param arr The input array of integers.
     * @param k   The target sum to find in subarrays.
     * @return The length of the longest subarray with sum equal to k.
     *
     * Time Complexity: O(n), where n is the number of elements in the array.
     *                  We iterate through the array once.
     * Space Complexity: O(n), due to the usage of HashMap to store prefix sums.
     */
    public static int longestSubArrayWithKSum(int[] arr, int k) {
        int maxLen = 0;
        int sum = 0;
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, -1); // Initialize with prefix sum 0 at index -1

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // Check if there exists a prefix sum (sum - k)
            int remaining = sum - k;
            if (prefixSumMap.containsKey(remaining)) {
                int currentLength = i - prefixSumMap.get(remaining);
                maxLen = Math.max(currentLength, maxLen);
            }

            // Store the current prefix sum if it doesn't exist in the map
            if (!prefixSumMap.containsKey(sum)) {
                prefixSumMap.put(sum, i);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] arr1 = {1, 2, 3, -3, 1, 1, 1, 4, 2, -3};
        int k1 = 3;
        int output1 = longestSubArrayWithKSum(arr1, k1);
        System.out.println("Test Case 1: " + output1); // Expected output: 4

        // Test Case 2
        int[] arr2 = {10, 5, 2, 7, 1, 9};
        int k2 = 15;
        int output2 = longestSubArrayWithKSum(arr2, k2);
        System.out.println("Test Case 2: " + output2); // Expected output: 4

        // Test Case 3
        int[] arr3 = {1, -1, 5, -2, 3};
        int k3 = 3;
        int output3 = longestSubArrayWithKSum(arr3, k3);
        System.out.println("Test Case 3: " + output3); // Expected output: 4
    }
}
