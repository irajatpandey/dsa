package heap.MinHeapPriorityQueue;

import java.util.ArrayList;
import java.util.Collections;

class MinHeap {
    private ArrayList<Integer> heap;

    // Constructor to initialize the heap
    public MinHeap() {
        this.heap = new ArrayList<>();
    }

    // Helper method to get the index of the parent node
    private int parent(int i) {
        return (i - 1) / 2;
    }

    // Helper method to get the index of the left child node
    private int leftChild(int i) {
        return 2 * i + 1;
    }

    // Helper method to get the index of the right child node
    private int rightChild(int i) {
        return 2 * i + 2;
    }

    // Swap the elements at indices i and j
    private void swap(int i, int j) {
        Collections.swap(heap, i, j);
    }

    // Method to maintain min-heap property by moving up the heap
    private void heapifyUp(int i) {
        // While not at the root and the current node is less than its parent
        while (i != 0 && heap.get(parent(i)) > heap.get(i)) {
            // Swap the current node with its parent
            swap(i, parent(i));
            // Move up to the parent node
            i = parent(i);
        }
    }

    // Method to maintain min-heap property by moving down the heap
    private void heapifyDown(int i) {
        int smallest = i;
        while (true) {
            int left = leftChild(i);
            int right = rightChild(i);

            // Find the smallest among the current node and its children
            if (left < heap.size() && heap.get(left) < heap.get(smallest)) {
                smallest = left;
            }
            if (right < heap.size() && heap.get(right) < heap.get(smallest)) {
                smallest = right;
            }

            // If the smallest is not the current node, swap and continue heapifying down
            if (smallest != i) {
                swap(i, smallest);
                i = smallest;
            } else {
                break;
            }
        }
    }

    // Method to insert a new element into the min-heap
    public void insert(int key) {
        // Add the new element to the end of the heap
        heap.add(key);
        // Restore the min-heap property by heapifying up
        heapifyUp(heap.size() - 1);
    }

    // Method to delete the minimum element (root) from the min-heap
    public void deleteMin() {
        if (heap.size() <= 0) {
            System.out.println("Heap is empty");
            return;
        }
        if (heap.size() == 1) {
            heap.remove(0);
            return;
        }
        // Replace the root with the last element
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        // Restore the min-heap property by heapifying down
        heapifyDown(0);
    }

    // Method to print the elements of the heap
    public void printHeap() {
        System.out.println(heap);
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();
        minHeap.insert(3);
        minHeap.insert(2);
        minHeap.insert(15);
        minHeap.insert(5);
        minHeap.insert(4);
        minHeap.insert(45);

        System.out.println("Min-Heap array:");
        minHeap.printHeap();

        minHeap.deleteMin();
        System.out.println("After deleting the root:");
        minHeap.printHeap();

        minHeap.insert(1);
        System.out.println("After inserting 1:");
        minHeap.printHeap();
    }
}

