package array.striver.easy;

/**
 * Implementation of Linear Search algorithm to find an element in an array.
 */
public class LinearSearch {

    /**
     * Performs linear search to find the index of an element in the array.
     *
     * @param arr The array of integers to search.
     * @param ele The element to search for in the array.
     * @return The index of the element if found, otherwise -1.
     *
     * Time Complexity: O(n), where n is the number of elements in the array.
     *                  In the worst case, we may need to iterate through all elements.
     * Space Complexity: O(1), no extra space is used other than a few variables.
     */
    public static int linearSearch(int[] arr, int ele) {
        int n = arr.length;

        // Iterate through the array to find the element
        for (int i = 0; i < n; i++) {
            if (arr[i] == ele) {
                return i; // Return the index of the element if found
            }
        }

        return -1; // Return -1 if the element is not found in the array
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 2, 44};
        int ele = 44;

        // Perform linear search on the array
        int output = linearSearch(arr, ele);

        // Print the result
        System.out.println("Element found at index: " + output);
    }
}
