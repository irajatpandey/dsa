package heap.InPlaceHeapSort;

import java.util.ArrayList;
import java.util.Arrays;

class MaxHeapSort {
    private ArrayList<Integer> heap;
    private int size;

    // Constructor to initialize the heap
    public MaxHeapSort(ArrayList<Integer> array) {
        this.heap = array;
        this.size = array.size();
        buildMaxHeap();
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
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // Method to maintain max-heap property by moving down the heap
    private void heapifyDown(int i) {
        int largest = i;
        while (true) {
            int left = leftChild(i);
            int right = rightChild(i);

            // Find the largest among the current node and its children
            if (left < size && heap.get(left) > heap.get(largest)) {
                largest = left;
            }
            if (right < size && heap.get(right) > heap.get(largest)) {
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

    // Method to build a max-heap from an unsorted array
    private void buildMaxHeap() {
        for (int i = parent(size - 1); i >= 0; i--) {
            heapifyDown(i);
        }
    }

    // Method to perform in-place heap sort
    public void heapSort() {
        for (int i = size - 1; i > 0; i--) {
            // Swap the root (maximum element) with the last element
            swap(0, i);
            // Reduce the heap size by one
            size--;
            // Restore the max-heap property by heapifying down the new root
            heapifyDown(0);
        }
    }

    // Method to print the elements of the heap
    public void printHeap() {
        System.out.println(heap);
    }

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(3, 2, 15, 5, 4, 45));
        MaxHeapSort maxHeap = new MaxHeapSort(array);

        System.out.println("Array representation of Max-Heap:");
        maxHeap.printHeap();

        maxHeap.heapSort();
        System.out.println("Array after in-place heap sort:");
        maxHeap.printHeap();
    }
}

