package heap.interview_problems;

import java.util.PriorityQueue;
//https://leetcode.com/problems/kth-largest-element-in-an-array/description/
public class KthLargestElement {

    /**
     * Finds the kth largest element in an array using a max-heap.
     *Time complexity: O(N log N), Space complexity: O(N)
     * @param nums The array of integers.
     * @param k    The value of k.
     * @return The kth largest element.
     */
    public static int findKthLargest(int[] nums, int k) {
        // Create a max-heap using PriorityQueue with a custom comparator
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        // Add all elements of the array to the max-heap
        for (int ele : nums) {
            maxHeap.add(ele);
        }
        System.out.println(maxHeap);

        // Remove k - 1 largest elements
        while (k > 1) {
            maxHeap.poll(); // Remove the largest element
            k--;
        }

        // Return the kth largest element or -1 if the heap is empty
        return (!maxHeap.isEmpty()) ? maxHeap.poll() : -1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;

        // Find the kth largest element and print it
        System.out.println("The " + k + "th largest element is: " + findKthLargest(nums, k));
    }
}
