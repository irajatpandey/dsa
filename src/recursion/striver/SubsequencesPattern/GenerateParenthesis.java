package recursion.striver.SubsequencesPattern;

import java.util.ArrayList;
import java.util.List;
// https://leetcode.com/problems/generate-parentheses/
public class GenerateParenthesis {
    public static void generateParenthesisHelper(String current, int openBracketCount, int close, int n, List<String> result){
        if(openBracketCount == n && close == n){
            result.add(current);
            return;
        }
        // Add openBracketCount parenthesis if the count of openBracketCount parentheses is less than n
        if (openBracketCount < n) {
            generateParenthesisHelper(current + "(", openBracketCount + 1, close, n, result);
        }

        // Add close parenthesis if the count of close parentheses is less than openBracketCount parentheses
        if (close < openBracketCount) {
            generateParenthesisHelper(current + ")", openBracketCount, close + 1,n,  result);
        }

    }
    public static void generateParenthesis(int n) {
        List<String> ls = new ArrayList<>();
        generateParenthesisHelper("", 0, 0, n, ls);
        System.out.println(ls);
    }
    public static void main(String[] args) {
        int n = 3;
        generateParenthesis(n);
    }
}
