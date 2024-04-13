package stack.InterviewProblems.Important;

import java.util.Stack;
//https://leetcode.com/problems/remove-k-digits/
public class RemoveKDigit {
    //Time and Space Complexity: O(n)
    public static String removeKDigit(String num, int k) {
        int len = num.length();
        if (k == len) return "0"; // If we remove all digits, return "0"

        StringBuilder result = new StringBuilder();
        // Iterate over each digit in the number
        for (char digit : num.toCharArray()) {
            // While k > 0 and result is not empty and last digit of result is greater than current digit
            while (k > 0 && result.length() > 0 && result.charAt(result.length() - 1) > digit) {
                result.deleteCharAt(result.length() - 1); // Remove last digit from result
                k--; // Decrement k as we removed a digit
            }
            // Append current digit to result
            result.append(digit);
        }

        // Remove remaining k digits from the end
        while (k > 0 && result.length() > 0) {
            result.deleteCharAt(result.length() - 1);
            k--;
        }

        // Remove leading zeros
        int nonZeroIndex = 0;
        while (nonZeroIndex < result.length() && result.charAt(nonZeroIndex) == '0') {
            nonZeroIndex++;
        }
        return (nonZeroIndex == result.length()) ? "0" : result.substring(nonZeroIndex);
    }
    public static String removeKDigitUsingStack(String num, int k) {
        int len = num.length();
        if (k == len) return "0"; // If we remove all digits, return "0"
        Stack<Character> stack = new Stack<>();
        for (char digit : num.toCharArray()) {
            while(!stack.isEmpty() && k > 0 && stack.peek() > digit){
                stack.pop();
                k--;
            }
            stack.push(digit);
        }
        while(k > 0){
            stack.pop();
            k--;
        }

        StringBuilder result = new StringBuilder();
        // Remove leading zeros
        boolean leadingZero = true;
        for(char digit : stack){
            if(leadingZero && digit == '0') continue;
            leadingZero = false;
            result.append(digit);
        }
        return result.length() == 0 ? "0" : result.toString();
    }
    public static void main(String[] args) {
        String str = "1432219";
        int k = 3;
        System.out.println(removeKDigitUsingStack(str, k));

    }
}
