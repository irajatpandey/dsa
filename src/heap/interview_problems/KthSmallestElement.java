package heap.interview_problems;

import java.util.PriorityQueue;

public class KthSmallestElement {

    /**
     * Finds the kth smallest element in an array using a min-heap.
     * Time complexity: O(N log N), Space complexity: O(N)
     * @param nums The array of integers.
     * @param k    The value of k.
     * @return The kth smallest element.
     */
    public static int findKthSmallest(int[] nums, int k) {
        // Create a min-heap using PriorityQueue
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add all elements of the array to the min-heap
        for (int ele : nums) {
            minHeap.add(ele);
        }

        // Remove k - 1 smallest elements
        while (k > 1) {
            minHeap.poll(); // Remove the smallest element
            k--;
        }

        // Return the kth smallest element (peek the min-heap)
        return (!minHeap.isEmpty()) ? minHeap.poll() : -1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;

        // Find the kth smallest element and print it
        System.out.println("The " + k + "th smallest element is: " + findKthSmallest(nums, k));
    }
}
