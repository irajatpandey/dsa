package array.striver.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array `nums`, find all elements that appear more than ⌊ n/3 ⌋ times,
 * where n is the length of the array.
 *
 * Time Complexity: O(n) - where n is the length of the input array `nums`.
 * Space Complexity: O(1) - excluding the space required for the output list `ls`.
 */
public class MajorityElementTwo {

    /**
     * Finds all elements in `nums` that appear more than ⌊ n/3 ⌋ times.
     *
     * @param nums The input integer array.
     * @return A list of integers representing the majority elements.
     */
    public static List<Integer> majorityElement(int[] nums) {
        int cnt1 = 0, cnt2 = 0;
        int first = Integer.MIN_VALUE, second = Integer.MAX_VALUE;
        List<Integer> ls = new ArrayList<>();

        // Finding potential candidates for majority elements
        for (int i = 0; i < nums.length; i++) {
            if (first == nums[i]) {
                cnt1++;
            } else if (second == nums[i]) {
                cnt2++;
            } else if (cnt1 == 0) {
                first = nums[i];
                cnt1 = 1;
            } else if (cnt2 == 0) {
                second = nums[i];
                cnt2 = 1;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        // Reset counts to count occurrences of candidates
        cnt1 = 0;
        cnt2 = 0;

        for (int ele : nums) {
            if (ele == first) {
                cnt1++;
            }
            if (ele == second) {
                cnt2++;
            }
        }

        // Adding elements to result list that appear more than ⌊ n/3 ⌋ times
        if (cnt1 > nums.length / 3) {
            ls.add(first);
        }
        if (cnt2 > nums.length / 3) {
            ls.add(second);
        }

        return ls;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {3, 2, 3};
        System.out.println("Test Case 1:");
        System.out.println(majorityElement(nums1)); // Expected output: [3]

        // Test Case 2
        int[] nums2 = {1};
        System.out.println("Test Case 2:");
        System.out.println(majorityElement(nums2)); // Expected output: [1]

        // Test Case 3
        int[] nums3 = {1, 2, 3, 4};
        System.out.println("Test Case 3:");
        System.out.println(majorityElement(nums3)); // Expected output: []
    }
}
