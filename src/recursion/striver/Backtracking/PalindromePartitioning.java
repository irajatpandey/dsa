package recursion.striver.Backtracking;
import java.util.List;
import java.util.ArrayList;

//https://leetcode.com/problems/palindrome-partitioning/description/

/*
*
*
* Time Complexity: O( (2^n) * k*(n/2) )
Reason: O(2^n) to generate every substring and O(n/2)  to check if the substring generated is a palindrome. O(k) is for inserting the palindromes in another data structure,
* where k  is the average length of the palindrome list.

Space Complexity: O(k * x)

Reason: The space complexity can vary depending upon the length of the answer. k is the average length of the list of palindromes and
* if we have x such list of palindromes in our final answer.
* The depth of the recursion tree is n, so the auxiliary space required is equal to the O(n).
*
*
* */
public class PalindromePartitioning {
    private static boolean isPalindrome(String str){
        int start = 0, end = str.length() - 1;
        while(start <= end){
            if(str.charAt(start++) != str.charAt(end--)){
                return false;
            }
        }
        return true;
    }
    private static void getPalindromePartitioningHelper(String str, List<String> smallOutput, List<List<String>> output) {
        // base case
        if(str.length() == 0){
            output.add(new ArrayList<>(smallOutput));
            return;
        }
        for(int i = 0; i < str.length(); i++){
            String prefix = str.substring(0, i + 1);
            String restOfString = str.substring(i + 1);

            // check if prefix is Palindrome or not

            if(isPalindrome(prefix)){
                smallOutput.add(prefix);
                getPalindromePartitioningHelper(restOfString, smallOutput, output);
                smallOutput.remove(smallOutput.size() - 1);
            }
        }
    }
    private static List<List<String>> getPalindromePartitioning(String str) {
        List<List<String>> output= new ArrayList<>();
        List<String> smallOutput = new ArrayList<>();
        getPalindromePartitioningHelper(str, smallOutput, output);
        return output;
    }

    public static void main(String[] args) {
        String str = "aabb";
        List<List<String>> output = getPalindromePartitioning(str);
        System.out.println(output);
    }
}
