package array.striver.easy;

/**
 * Moves all zeros in an array to the end without changing the order of non-zero elements.
 */
public class MoveAllZeros {

    /**
     * Swaps elements at indices a and b in the array.
     *
     * @param arr The input array of integers.
     * @param a   Index of the first element to swap.
     * @param b   Index of the second element to swap.
     */
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /**
     * Moves all zeros in the array to the end without changing the order of non-zero elements.
     *
     * @param nums The input array of integers containing zeros and non-zeros.
     *
     * Time Complexity: O(n), where n is the number of elements in the array.
     *                  We iterate through the array once.
     * Space Complexity: O(1), as we use only a few extra variables (n, j).
     */
    public static void moveZeroes(int[] nums) {
        int n = nums.length;
        int j = 0; // Pointer to track the position for non-zero elements

        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                swap(nums, i, j); // Swap non-zero element with element at index j
                j++; // Increment j to move to the next position for non-zero element
            }
        }
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] arr1 = {0, 1, 0, 3, 12};
        moveZeroes(arr1);
        System.out.print("Test Case 1: ");
        for (int ele : arr1) {
            System.out.print(ele + " ");
        }
        System.out.println(); // Expected output: 1 3 12 0 0

        // Test Case 2
        int[] arr2 = {0, 0, 0, 1, 0};
        moveZeroes(arr2);
        System.out.print("Test Case 2: ");
        for (int ele : arr2) {
            System.out.print(ele + " ");
        }
        System.out.println(); // Expected output: 1 0 0 0 0

        // Test Case 3
        int[] arr3 = {1, 2, 3, 4, 5};
        moveZeroes(arr3);
        System.out.print("Test Case 3: ");
        for (int ele : arr3) {
            System.out.print(ele + " ");
        }
        System.out.println(); // Expected output: 1 2 3 4 5
    }
}
