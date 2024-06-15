package array.striver.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two sorted arrays `a` and `b`, return a list containing their union.
 */
public class UnionSortedArray {

    /**
     * Computes the union of two sorted arrays `a` and `b`.
     *
     * @param a The first sorted array.
     * @param b The second sorted array.
     * @return A list containing elements from both arrays without duplicates.
     *
     * Time Complexity: O(m + n), where m and n are the lengths of arrays `a` and `b` respectively.
     * Space Complexity: O(m + n), for the list `li` to store the union elements.
     */
    public static List<Integer> sortedArray(int[] a, int[] b) {
        List<Integer> li = new ArrayList<>();
        int m = a.length;
        int n = b.length;
        int i = 0, j = 0;

        // Merge process to find the union of arrays `a` and `b`
        while (i < m && j < n) {
            if (a[i] < b[j]) {
                if (li.isEmpty() || li.get(li.size() - 1) != a[i]) {
                    li.add(a[i]);
                }
                i++;
            } else if (a[i] > b[j]) {
                if (li.isEmpty() || li.get(li.size() - 1) != b[j]) {
                    li.add(b[j]);
                }
                j++;
            } else {
                // If both elements are equal, add either to the union list
                if (li.isEmpty() || li.get(li.size() - 1) != a[i]) {
                    li.add(a[i]);
                }
                i++;
                j++;
            }
        }

        // If there are remaining elements in `a`, add them to the union list
        while (i < m) {
            if (li.isEmpty() || li.get(li.size() - 1) != a[i]) {
                li.add(a[i]);
            }
            i++;
        }

        // If there are remaining elements in `b`, add them to the union list
        while (j < n) {
            if (li.isEmpty() || li.get(li.size() - 1) != b[j]) {
                li.add(b[j]);
            }
            j++;
        }

        return li;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] a1 = {1, 2, 3, 4, 6};
        int[] b1 = {2, 3, 5};
        System.out.println("Test Case 1:");
        List<Integer> result1 = sortedArray(a1, b1);
        System.out.println(result1);

        // Test Case 2
        int[] a2 = {1, 2, 2, 2, 3, 4, 5};
        int[] b2 = {2, 2, 3};
        System.out.println("Test Case 2:");
        List<Integer> result2 = sortedArray(a2, b2);
        System.out.println(result2);

        // Test Case 3
        int[] a3 = {1, 2, 3};
        int[] b3 = {4, 5, 6};
        System.out.println("Test Case 3:");
        List<Integer> result3 = sortedArray(a3, b3);
        System.out.println(result3);
    }
}
