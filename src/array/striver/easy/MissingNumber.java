package array.striver.easy;

/**
 * Finds the missing number in an array of distinct integers from 0 to n.
 */
public class MissingNumber {

    /**
     * Finds the missing number in the array.
     *
     * @param nums The input array of integers from 0 to n with one number missing.
     * @return The missing number.
     *
     * Time Complexity: O(n), where n is the number of elements in the array.
     *                  We iterate through the array once to calculate the sum.
     * Space Complexity: O(1), as we use only a few extra variables (sum, n, total).
     */
    public static int missingNumber(int[] nums) {
        int sum = 0;
        int n = nums.length;

        // Calculate the sum of all elements in nums
        for (int ele : nums) {
            sum += ele;
        }

        // Calculate the expected total sum from 0 to n using the formula n * (n + 1) / 2
        int total = (n * (n + 1)) / 2;

        // The missing number is the difference between total sum and sum of nums
        return total - sum;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] arr1 = {0, 1, 3};
        int expected1 = 2;
        System.out.println("Test Case 1: " + missingNumber(arr1) + " (Expected: " + expected1 + ")");

        // Test Case 2
        int[] arr2 = {0, 1, 2, 4, 5};
        int expected2 = 3;
        System.out.println("Test Case 2: " + missingNumber(arr2) + " (Expected: " + expected2 + ")");

        // Test Case 3
        int[] arr3 = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        int expected3 = 8;
        System.out.println("Test Case 3: " + missingNumber(arr3) + " (Expected: " + expected3 + ")");
    }
}
