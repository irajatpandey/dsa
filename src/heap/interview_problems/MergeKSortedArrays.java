package heap.interview_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//https://www.geeksforgeeks.org/problems/merge-k-sorted-arrays/1

// Helper class to represent elements in the priority queue
class PairElements implements Comparable<PairElements> {
    int listIndex; // Index of the array from which the element is taken
    int dataIndex; // Index of the element in the respective array
    int val;       // Value of the element

    public PairElements(int listIndex, int dataIndex, int val) {
        this.listIndex = listIndex;
        this.dataIndex = dataIndex;
        this.val = val;
    }

    @Override
    public int compareTo(PairElements o) {
        return this.val - o.val; // Min-heap based on value
    }
}

public class MergeKSortedArrays {

    /**
     * Merges K sorted arrays into one sorted list.
     *
     * @param arr 2D array containing K sorted arrays.
     * @return A list containing all elements from K sorted arrays, merged and sorted.
     *
     * Time Complexity: O(K^2 * log K)
     * Space Complexity: O(K^2)
     */
    private static List<Integer> mergeKSortedArrays(int[][] arr) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<PairElements> pq = new PriorityQueue<>();

        // Initialize the priority queue with the first element of each array
        for (int i = 0; i < arr.length; i++) {
            PairElements p = new PairElements(i, 0, arr[i][0]);
            pq.add(p);
        }

        // Merge arrays by extracting the smallest element from the min-heap
        while (!pq.isEmpty()) {
            PairElements p = pq.poll(); // Get the smallest element
            res.add(p.val); // Add it to the result list

            // Move to the next element in the same array
            p.dataIndex += 1;
            if (p.dataIndex < arr[p.listIndex].length) {
                p.val = arr[p.listIndex][p.dataIndex];
                pq.add(p); // Add the next element from the same array to the heap
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> list = mergeKSortedArrays(arr);

        // Print the merged and sorted list
        System.out.println(list);
    }
}
