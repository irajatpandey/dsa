package string.striver.medium;

import java.util.ArrayList;

public class LongestPalindromicSubString {
    public static boolean isPalindrome(String s){
        int j = s.length() - 1;
        int i = 0;

        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return  false;
            }
            i++;
            j--;
        }
        return true;
    }
    // Naive Approach
    // TC : O(n^3)
    public static String longestPalindrome_bruteForce(String s) {
        ArrayList<String> ls = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            for(int j = i; j <= s.length(); j++){
//                System.out.println(s.substring(i, j));
                if(isPalindrome(s.substring(i, j))){
                    ls.add(s.substring(i, j));
                }
            }
        }
        int max = Integer.MIN_VALUE;
        String output = "";
        for(String str : ls){
            if(str.length() > max){
                max = str.length();
                output = str;
            }
        }
        return output;
    }

    // Optimal Approach

    public static int expandFromCenter(String s, int i, int j){
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }

        return j - i - 1;
    }
    public static String longestPalindrome(String s){
        int start = 0, end = 0;
        for(int i = 0; i < s.length(); i++){
            int len1 = expandFromCenter(s, i, i + 1);
            int len2 = expandFromCenter(s, i, i);

            int finalLen = Math.max(len1, len2);

            if(end - start <  finalLen){
                start = i - (finalLen - 1 )/2;
                end = i + finalLen/2;
            }

        }

        return s.substring(start, end + 1);
    }


    public static void main(String[] args) {
        String str = "cbbc";
//        String output = longestPalindrome_bruteForce(str);
//        System.out.println(output);

        String output2 = longestPalindrome(str);
        System.out.println(output2);
    }

}
