package array.striver.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of integers `nums` and an integer `target`, find all unique quadruplets
 * in the array which gives the sum of `target`.
 *
 * Time Complexity: O(n^3) - where n is the length of the input array `nums`.
 *                    Sorting takes O(n * logn), and the nested loops for 3Sum and outer loop contribute O(n^3).
 * Space Complexity: O(1) - ignoring the space required for the output list.
 */
public class FourSum {

    /**
     * Finds all unique quadruplets in `nums` that sum up to `target`.
     *
     * @param nums   The input array of integers.
     * @param target The target sum of the quadruplets.
     * @return A list of lists where each inner list represents a unique quadruplet.
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> output = new ArrayList<>();
        int n = nums.length;
        if (n < 4) return output;

        Arrays.sort(nums); // Sort the array to easily handle duplicates and maintain order

        for (int i = 0; i <= n - 4; i++) {
            // Skip duplicate values for the first element of the quadruplet
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int val1 = nums[i];
            List<List<Integer>> threeSumResult = threeSum(nums, target - val1, i + 1);

            // Add the current element nums[i] to each valid threeSum result
            for (List<Integer> triplet : threeSumResult) {
                triplet.add(val1);
                output.add(triplet);
            }
        }

        return output;
    }

    /**
     * Helper function to find all unique triplets in `nums` that sum up to `target`.
     *
     * @param nums           The input array of integers.
     * @param target         The target sum of the triplets.
     * @param startingIndex  The starting index to begin the search in `nums`.
     * @return A list of lists where each inner list represents a unique triplet.
     */
    public static List<List<Integer>> threeSum(int[] nums, long target, int startingIndex) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        for (int i = startingIndex; i <= n - 3; i++) {
            // Skip duplicate values for the second element of the triplet
            if (i > startingIndex && nums[i] == nums[i - 1]) {
                continue;
            }

            int low = i + 1;
            int high = n - 1;

            while (low < high) {
                long sum = (long) nums[i] + nums[low] + nums[high];

                if (sum == target) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[low]);
                    triplet.add(nums[high]);
                    result.add(triplet);

                    // Skip duplicate elements for low
                    while (low < high && nums[low] == nums[low + 1]) {
                        low++;
                    }
                    // Skip duplicate elements for high
                    while (low < high && nums[high] == nums[high - 1]) {
                        high--;
                    }
                    low++;
                    high--;
                } else if (sum < target) {
                    low++;
                } else {
                    high--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {1, 0, -1, 0, -2, 2};
        int target1 = 0;
        List<List<Integer>> result1 = fourSum(nums1, target1);
        System.out.println("Test Case 1:");
        System.out.println(result1);

        // Test Case 2
        int[] nums2 = {2, 2, 2, 2, 2};
        int target2 = 8;
        List<List<Integer>> result2 = fourSum(nums2, target2);
        System.out.println("Test Case 2:");
        System.out.println(result2);

        // Test Case 3
        int[] nums3 = {1000000000, 1000000000, 1000000000, 1000000000};
        int target3 = -294967296;
        List<List<Integer>> result3 = fourSum(nums3, target3);
        System.out.println("Test Case 3:");
        System.out.println(result3);
    }
}
