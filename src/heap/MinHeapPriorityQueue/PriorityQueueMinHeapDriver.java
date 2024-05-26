package heap.MinHeapPriorityQueue;

public class PriorityQueueMinHeapDriver {
    public static void main(String[] args) throws PriorityQueueException {
        int[] arr = new int[]{5, 1, 9, 2, 0};
        PriorityQueue pq = new PriorityQueue();
        for(int ele : arr) {
            pq.insert(ele);
        }

        while(!pq.isEmpty()) {
            System.out.print(pq.removeMin() + " ");
        }
    }
}
