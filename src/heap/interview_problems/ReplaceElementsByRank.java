package heap.interview_problems;

import java.util.PriorityQueue;

public class ReplaceElementsByRank {
    public static int[] findRanks(int[] arr) {
        // Create a priority queue of pairs (value, index)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Insert pairs (value, index) into the priority queue
        for (int i = 0; i < arr.length; i++) {
            pq.offer(new int[]{arr[i], i});
        }

        // Array to store ranks
        int[] ranks = new int[arr.length];

        // Current rank
        int rank = 1;

        // Assign ranks based on sorted order
        while (!pq.isEmpty()) {
            int[] pair = pq.poll();
            ranks[pair[1]] = rank;

            // If the next element is same as the current one, don't increment rank
            if (!pq.isEmpty() && pq.peek()[0] == pair[0]) {
                continue;
            }
            rank++;
        }

        return ranks;
    }
    public static void main(String[] args) {
        int[] arr = {20, 15, 26, 2, 98, 6};
        int[] ranks = findRanks(arr);
        for (int rank : ranks) {
            System.out.print(rank + " ");
        }
    }
}
