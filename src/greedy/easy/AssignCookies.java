package greedy.easy;

import java.util.Arrays;
//https://leetcode.com/problems/assign-cookies/description/
public class AssignCookies {

    /**
     * Finds the maximum number of children who can be content with the given cookies.
     * Each child i has a greed factor g[i], and each cookie j has a size s[j].
     * A child is content if and only if they get a cookie with a size greater than or equal to their greed factor.
     *
     * @param g Array representing the greed factor of each child.
     * @param s Array representing the sizes of the available cookies.
     * @return The maximum number of content children.
     *
     * Time Complexity: O(n log n + m log m) - Sorting the arrays takes O(n log n) and O(m log m), where n and m are the lengths of the arrays.
     * Space Complexity: O(1) - No extra space is used beyond the input and output.
     */
    public static int findContentChildren(int[] g, int[] s) {
        // Sort the greed factor array and the cookie size array
        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0; // To count the number of content children
        int i = 0, j = 0; // Pointers to traverse the cookies and greed factors

        // Try to satisfy as many children as possible with the given cookies
        while (i < s.length && j < g.length) {
            // If the current cookie can satisfy the current child's greed
            if (s[i] >= g[j]) {
                count++; // Increment the content children count
                j++; // Move to the next child
            }
            i++; // Move to the next cookie
        }
        return count;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] g1 = {1, 2, 3};
        int[] s1 = {1, 1};
        int output1 = findContentChildren(g1, s1);
        System.out.println("Test Case 1 - Expected Output: 1");
        System.out.println("Actual Output: " + output1);

        // Test Case 2
        int[] g2 = {1, 2};
        int[] s2 = {1, 2, 3};
        int output2 = findContentChildren(g2, s2);
        System.out.println("Test Case 2 - Expected Output: 2");
        System.out.println("Actual Output: " + output2);

        // Test Case 3
        int[] g3 = {10, 9, 8, 7};
        int[] s3 = {5, 6, 7, 8};
        int output3 = findContentChildren(g3, s3);
        System.out.println("Test Case 3 - Expected Output: 2");
        System.out.println("Actual Output: " + output3);
    }
}
