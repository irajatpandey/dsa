package recursion.striver.SubsequencesPattern;

public class GenerateBinaryStrings {
 // The time complexity of the provided code to generate all binary strings using recursion is O(2^n),
 // where n is the length of the desired binary strings.
    public static void generateBinaryStrings(int n, String currentString) {
        if (n == 0) {
            System.out.println(currentString);
            return;
        }
        generateBinaryStrings(n - 1, currentString + "0");  // Append a 0 to the current string and recurse
        generateBinaryStrings(n - 1, currentString + "1");  // Append a 1 to the current string and recurse
    }

    public static void main(String[] args) {
        int n = 3;  // Example: Generate binary strings of length 3
        generateBinaryStrings(n, "");
    }
}
