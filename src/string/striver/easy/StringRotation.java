package string.striver.easy;
//https://leetcode.com/problems/rotate-string/description/
//TC O(n^2)
public class StringRotation {
    public static boolean rotateString(String s, String goal) {

        if(s.length() != goal.length()) return false;
        String doubleString = s.concat(s);
        System.out.println(doubleString);

        return doubleString.contains(goal);
    }
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "abced";

        boolean result = rotateString(s1, s2);
        System.out.println(result);
    }
}
