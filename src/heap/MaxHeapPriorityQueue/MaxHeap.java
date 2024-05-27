package heap.MaxHeapPriorityQueue;

import java.util.ArrayList;
import java.util.Collections;

class MaxHeap {
    private ArrayList<Integer> heap;

    // Constructor to initialize the heap
    public MaxHeap() {
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

    // Method to maintain max-heap property by moving up the heap
    private void heapifyUp(int i) {
        // While not at the root and the current node is greater than its parent
        while (i != 0 && heap.get(parent(i)) < heap.get(i)) {
            // Swap the current node with its parent
            swap(i, parent(i));
            // Move up to the parent node
            i = parent(i);
        }
    }

    // Method to maintain max-heap property by moving down the heap
    private void heapifyDown(int i) {
        int largest = i;
        while (true) {
            int left = leftChild(i);
            int right = rightChild(i);

            // Find the largest among the current node and its children
            if (left < heap.size() && heap.get(left) > heap.get(largest)) {
                largest = left;
            }
            if (right < heap.size() && heap.get(right) > heap.get(largest)) {
                largest = right;
            }

            // If the largest is not the current node, swap and continue heapifying down
            if (largest != i) {
                swap(i, largest);
                i = largest;
            } else {
                break;
            }
        }
    }

    // Method to insert a new element into the max-heap
    public void insert(int key) {
        // Add the new element to the end of the heap
        heap.add(key);
        // Restore the max-heap property by heapifying up
        heapifyUp(heap.size() - 1);
    }

    // Method to delete the maximum element (root) from the max-heap
    public void deleteMax() {
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
        // Restore the max-heap property by heapifying down
        heapifyDown(0);
    }

    // Method to print the elements of the heap
    public void printHeap() {
        System.out.println(heap);
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insert(3);
        maxHeap.insert(2);
        maxHeap.insert(15);
        maxHeap.insert(5);
        maxHeap.insert(4);
        maxHeap.insert(45);

        System.out.println("Max-Heap array:");
        maxHeap.printHeap();

        maxHeap.deleteMax();
        System.out.println("After deleting the root:");
        maxHeap.printHeap();

        maxHeap.insert(50);
        System.out.println("After inserting 50:");
        maxHeap.printHeap();
    }
}
