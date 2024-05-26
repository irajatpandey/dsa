package heap.MinHeapPriorityQueue;

import java.util.ArrayList;

public class PriorityQueue {
    private ArrayList<Integer> heap;

    // Constructor to initialize the heap
    public PriorityQueue() {
        heap = new ArrayList<>();
    }

    // Method to check if the priority queue is empty
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    // Method to get the size of the priority queue
    public int size() {
        return heap.size();
    }

    // Method to get the minimum element (root) of the priority queue
    public int getMin() throws PriorityQueueException {
        if (isEmpty()) {
            throw new PriorityQueueException("Priority queue is empty.");
        }
        return heap.get(0);
    }

    // Method to insert a new element into the priority queue
    public void insert(int element) {
        heap.add(element);
        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex - 1) / 2;

        // Up-heapify process to maintain the heap property
        while (childIndex > 0 && heap.get(childIndex) < heap.get(parentIndex)) {
            int temp = heap.get(childIndex);
            heap.set(childIndex, heap.get(parentIndex));
            heap.set(parentIndex, temp);

            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }
    }

    // Method to remove and return the minimum element from the priority queue
    public int removeMin() throws PriorityQueueException {
        if (isEmpty()) {
            throw new PriorityQueueException("Priority queue is empty.");
        }

        int minElement = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        // Down-heapify process to maintain the heap property
        int index = 0;
        int minIndex = index;
        int leftChildIndex = 1;
        int rightChildIndex = 2;

        while (leftChildIndex < heap.size()) {
            if (heap.get(leftChildIndex) < heap.get(minIndex)) {
                minIndex = leftChildIndex;
            }
            if (rightChildIndex < heap.size() && heap.get(rightChildIndex) < heap.get(minIndex)) {
                minIndex = rightChildIndex;
            }
            if (index == minIndex) {
                break;
            } else {
                int temp = heap.get(index);
                heap.set(index, heap.get(minIndex));
                heap.set(minIndex, temp);

                index = minIndex;
                leftChildIndex = 2 * index + 1;
                rightChildIndex = 2 * index + 2;
            }
        }

        return minElement;
    }
}
