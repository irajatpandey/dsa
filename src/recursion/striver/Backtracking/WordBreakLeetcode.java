package recursion.striver.Backtracking;

import java.util.*;
//https://leetcode.com/problems/word-break/description/
public class WordBreakLeetcode {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Convert wordDict to HashSet for O(1) lookup
        Set<String> wordSet = new HashSet<>(wordDict);
        // Memoization to store results for already visited prefixes
        Map<String, Boolean> memo = new HashMap<>();
        return wordBreakHelper(s, wordSet, memo);
    }

    private boolean wordBreakHelper(String s, Set<String> wordSet, Map<String, Boolean> memo) {
        // If the string is empty, we can break it down
        if (s.isEmpty()) return true;
        // If the result for this prefix is already computed, return it
        if (memo.containsKey(s)) return memo.get(s);

        // Try breaking the string at various points and check if both substrings are valid
        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            String suffix = s.substring(i);
            // Check if the prefix is in the wordSet and suffix can be broken further
            if (wordSet.contains(prefix) && wordBreakHelper(suffix, wordSet, memo)) {
                memo.put(s, true); // Memoize the result for this prefix
                return true;
            }
        }
        // Memoize the result for this prefix
        memo.put(s, false);
        return false;
    }
    public static void main(String[] args) {
        WordBreakLeetcode wb = new WordBreakLeetcode();
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println(wb.wordBreak(s, wordDict)); // Output: true
    }
}
