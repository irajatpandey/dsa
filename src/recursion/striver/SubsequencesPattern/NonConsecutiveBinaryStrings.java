package recursion.striver.SubsequencesPattern;

import java.util.ArrayList;
import java.util.List;

public class NonConsecutiveBinaryStrings {
   // Time Complexity : O(2^n)
    // Space Complexity : O(2^n + n)
    public static void generateBinaryStrings(int n, String currentString, List<String> ls) {
        if (n == 0) {
            ls.add(currentString);
            return;
        }

        generateBinaryStrings(n - 1, currentString + "0", ls);  // Append a 0 to the current string and recurse

        if(currentString.length() == 0 || currentString.charAt(currentString.length() - 1) != '1')
            generateBinaryStrings(n - 1, currentString + "1", ls);  // Append a 1 to the current string and recurse
    }

    public static void main(String[] args) {
        int n = 3;  // Example: Generate binary strings of length 3

        List<String> ls = new ArrayList<>();
        generateBinaryStrings(n, "", ls);
        System.out.println(ls);
    }
}
