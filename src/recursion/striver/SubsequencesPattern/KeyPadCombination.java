package recursion.striver.SubsequencesPattern;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class KeyPadCombination {
    private static final String[] digitToLetters = {
            " ", // 0
            "", // 1
            "abc", // 2
            "def", // 3
            "ghi", // 4
            "jkl", // 5
            "mno", // 6
            "pqrs", // 7
            "tuv", // 8
            "wxyz" // 9
    };
    public static List<String> getKeyPadCombination(String digits){
        // base case
        if(digits.length() == 0){
            List<String> ls = new ArrayList<>();
            ls.add("");
            return ls;
        }
        char first = digits.charAt(0);
        String rest = digits.substring(1);
        List<String> output = getKeyPadCombination(rest);
        List<String> finalOutput = new ArrayList<>();

        String smallResult = digitToLetters[first - '0'];

        for(char ch : smallResult.toCharArray()){
            for(String str : output){
                finalOutput.add(ch + str);
            }
        }
        return finalOutput;
    }
    public static List<String> letterCombinations(String digits) {
        //String[] alpha = {"0", "1","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if(digits.length() == 0) return new ArrayList<>();
        return getKeyPadCombination(digits);
    }
    public static void main(String[] args) {
        String digits = "234";
        System.out.println(letterCombinations(digits));
    }
}
