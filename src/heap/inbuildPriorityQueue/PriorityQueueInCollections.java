package heap.inbuildPriorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueInCollections {
    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4};

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // Min Heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> {
            return b - a;
        }); // max heap
        for (int i = 0; i < arr.length; i++) {
            maxHeap.add(arr[i]);
        }
        System.out.println(maxHeap);
        for (int i = 0; i < arr.length; i++) {

            System.out.print(maxHeap.poll() + " ");
        }
    }
}
