package array.striver.easy;

import java.util.Arrays;

/**
 * Given an array of integers `nums`, sort the array such that:
 * - nums[0], nums[2], nums[4], ... are all even,
 * - nums[1], nums[3], nums[5], ... are all odd.
 */
public class SortArrayByParityII {

    /**
     * Sorts the array `nums` by parity using an auxiliary array `ans`.
     *
     * @param nums The input array to be sorted.
     * @return The sorted array where even numbers are at even indices and odd numbers are at odd indices.
     *
     * Time Complexity: O(n), where n is the number of elements in `nums`.
     * Space Complexity: O(n), for the auxiliary array `ans`.
     */
    public static int[] sortArrayByParityII(int[] nums) {
        int oddIndex = 1;
        int evenIndex = 0;
        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                ans[evenIndex] = nums[i];
                evenIndex += 2;
            } else {
                ans[oddIndex] = nums[i];
                oddIndex += 2;
            }
        }
        return ans;
    }

    /**
     * Sorts the array `nums` in place by parity using two pointers.
     *
     * @param nums The input array to be sorted.
     * @return The sorted array where even numbers are at even indices and odd numbers are at odd indices.
     *
     * Time Complexity: O(n), where n is the number of elements in `nums`.
     * Space Complexity: O(1), as it sorts the array in place without using any extra space.
     */
    public static int[] sortArrayByParityII_InPlace(int[] nums) {
        int n = nums.length;
        int evenIndex = 0;
        int oddIndex = 1;

        while (evenIndex < n && oddIndex < n) {
            // Find the first misplaced even number at an odd index
            while (evenIndex < n && nums[evenIndex] % 2 == 0) {
                evenIndex += 2;
            }

            // Find the first misplaced odd number at an even index
            while (oddIndex < n && nums[oddIndex] % 2 == 1) {
                oddIndex += 2;
            }

            // Swap the misplaced even and odd numbers
            if (evenIndex < n && oddIndex < n) {
                int temp = nums[evenIndex];
                nums[evenIndex] = nums[oddIndex];
                nums[oddIndex] = temp;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {4, 2, 5, 7};
        System.out.println("Test Case 1:");
        int[] ans1 = sortArrayByParityII(nums1);
        Arrays.stream(ans1).forEach(a -> System.out.print(a + " "));
        System.out.println();

        // Test Case 2
        int[] nums2 = {3, 1, 2, 4};
        System.out.println("Test Case 2:");
        int[] ans2 = sortArrayByParityII(nums2);
        Arrays.stream(ans2).forEach(a -> System.out.print(a + " "));
        System.out.println();

        // Test Case 3
        int[] nums3 = {2, 3, 1, 4};
        System.out.println("Test Case 3:");
        int[] ans3 = sortArrayByParityII_InPlace(nums3);
        Arrays.stream(ans3).forEach(a -> System.out.print(a + " "));
        System.out.println();
    }
}
