package windowsliding.striver.medium;

import java.util.HashSet;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
public class LongestSubstringWithoutRepeatingCharacters {
    // Time Complexity: O(n^3)
    // Therefore, the overall space complexity is O(min(n, m)),
    // where n is the length of the input string and m is the size of the character set.
    public static int lengthOfLongestSubstring_BruteForce(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (allUnique(s, i, j)) {
                    ans = Math.max(ans, j - i);
                }
            }
        }
        return ans;
    }

    public static boolean allUnique(String s, int start, int end) {
        HashSet<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            char ch = s.charAt(i);
            if (set.contains(ch)) {
                return false;
            }
            set.add(ch);
        }
        return true;
    }
    public static int lengthOfLongestSubstring(String s) {
        int[] cnt = new int[128];
        int i = 0, j = 0, N = s.length(), ans = 0;
        for (; j < N; ++j) {
            cnt[s.charAt(j)]++;
            while (cnt[s.charAt(j)] > 1)
                cnt[s.charAt(i++)]--;
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(str));
        System.out.println(lengthOfLongestSubstring_BruteForce(str));
    }
}
