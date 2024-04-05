package recursion.striver.Backtracking;

import java.util.ArrayList;
import java.util.List;
//https://www.naukri.com/code360/problems/word-break-1_758963?
public class WordBreakCodingNinjas {
    public static List<String> getAllValidSentences(String s, String[] dict) {
        List<String> result = new ArrayList<>();
        List<String> dictionary = new ArrayList<>();
        for (String word : dict) {
            dictionary.add(word);
        }
        backtrack(s, dictionary, 0, "", result);
        return result;
    }

    private static void backtrack(String s, List<String> dict, int index, String current, List<String> result) {
        if (index == s.length()) {
            result.add(current.trim());
            return;
        }

        for (int i = index + 1; i <= s.length(); i++) {
            String prefix = s.substring(index, i);
            if (dict.contains(prefix)) {
                backtrack(s, dict, i, current + " " + prefix, result);
            }
        }
    }
    public static void main(String[] args) {
        String[] dict = {"god", "is", "now", "no", "where", "here"};
        String s = "godisnowherenowhere";
        List<String> sentences = getAllValidSentences(s, dict);
        for (String sentence : sentences) {
            System.out.println(sentence);
        }
    }
}
