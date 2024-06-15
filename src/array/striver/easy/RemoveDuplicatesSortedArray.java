package array.striver.easy;

import java.util.ArrayList;

/**
 * Remove duplicates from a sorted array (ArrayList) and return the new length of the array.
 */
public class RemoveDuplicatesSortedArray {

    /**
     * Removes duplicates from a sorted ArrayList and returns the new length of the array.
     *
     * @param arr The input ArrayList of integers.
     * @param n   The number of elements in the ArrayList.
     * @return The new length of the ArrayList after removing duplicates.
     *
     * Time Complexity: O(n), where n is the number of elements in the ArrayList.
     *                  We iterate through the ArrayList once.
     * Space Complexity: O(1), as we modify the ArrayList in-place and use a constant amount of extra space.
     */
    public static int removeDuplicates(ArrayList<Integer> arr, int n) {
        int j = 0; // Pointer to track the position for non-duplicate elements

        // Traverse through the ArrayList starting from the second element
        for (int i = 1; i < n; i++) {
            // If current element is different from the previous element, include it in the new array
            if (!arr.get(i).equals(arr.get(i - 1))) {
                arr.set(j++, arr.get(i - 1)); // Replace elements to remove duplicates
            }
        }

        // Add the last unique element to the modified ArrayList
        arr.set(j++, arr.get(n - 1));

        // Print modified ArrayList for verification
        System.out.println(arr);

        return j; // Return the new length of the modified ArrayList
    }

    public static void main(String[] args) {
        // Test Case 1
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(1);
        arr1.add(2);
        arr1.add(2);
        arr1.add(2);
        arr1.add(3);
        arr1.add(3);
        arr1.add(4);
        int output1 = removeDuplicates(arr1, arr1.size());
        System.out.println("Test Case 1: New length = " + output1); // Expected output: 4

        // Test Case 2
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(1);
        arr2.add(1);
        arr2.add(2);
        arr2.add(2);
        arr2.add(3);
        arr2.add(3);
        arr2.add(3);
        int output2 = removeDuplicates(arr2, arr2.size());
        System.out.println("Test Case 2: New length = " + output2); // Expected output: 3

        // Test Case 3
        ArrayList<Integer> arr3 = new ArrayList<>();
        arr3.add(1);
        arr3.add(1);
        arr3.add(1);
        arr3.add(1);
        arr3.add(1);
        int output3 = removeDuplicates(arr3, arr3.size());
        System.out.println("Test Case 3: New length = " + output3); // Expected output: 1
    }
}
