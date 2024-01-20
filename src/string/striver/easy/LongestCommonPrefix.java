package string.striver.easy;
//Leetcode - 14
// https://leetcode.com/problems/longest-common-prefix/
public class LongestCommonPrefix {
    public static String smallestString(String[] strs){
        String smallest = "";
        int size = Integer.MAX_VALUE;
        for(String s : strs){
            if(s.length() < size){
                smallest = s;
                size = s.length();
            }
        }
        return smallest;

    }
    public static String longestCommonPrefix(String[] strs) {
        String ans = "";
        String smallestString = smallestString(strs);
        //System.out.println(smallestString);

        for(int i = 0; i < smallestString.length(); i++){
            for(int j = 0; j < strs.length; j++){
                if(smallestString.charAt(i) != strs[j].charAt(i)){
                    return ans;
                }
            }
            ans += smallestString.charAt(i);
        }

        return ans;
    }
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        String output = longestCommonPrefix(strs);
        System.out.println(output);
    }
}
