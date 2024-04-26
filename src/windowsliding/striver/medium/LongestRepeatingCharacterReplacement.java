package windowsliding.striver.medium;
//https://leetcode.com/problems/longest-repeating-character-replacement/description/
public class LongestRepeatingCharacterReplacement {
    //The time complexity of the brute-force solution is O(n^3), where n is the length of the input string 's'.
    // The space complexity of the brute-force solution is O(1), i.e., constant space complexity.
    public static int longestRepeatingCharacterReplacementBruteForce(String str, int k){
        int ans = 0;
        for(int i = 0; i < str.length(); i++){
            for(int j = i; j < str.length(); j++){

                int maxCount = getCount(str.substring(i, j + 1));
                int replacementsNeeded = j - i + 1 - maxCount;

                if(replacementsNeeded <= k){
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }

    private static int getCount(String substring) {
        int count = 0;
        int[] freq = new int[26];
        for(int i = 0; i < substring.length(); i++){
            freq[substring.charAt(i) - 'A']++;
        }

        for(int c : freq){
            count = Math.max(count, c);
        }
        return count;
    }

    //The time complexity of the optimized solution is O(n),
    // The space complexity of the optimized solution is O(1),
    public static int longestRepeatingCharacterReplacement(String str, int k) {
        int i = 0, j = 0, maxCount = 0, maxLength = 0;
        int[] freq = new int[26];

        for(; j < str.length(); j++){
            char endChar = str.charAt(j);
            freq[str.charAt(j) - 'A']++;
            maxCount = Math.max(maxCount, freq[endChar - 'A']);

            // If the number of characters to replace exceeds 'k',
            // shrink the window from the start
            if(j - i + 1 - maxCount > k){
                char startChar = str.charAt(i);
                freq[startChar - 'A']--;
                i++;
            }
            // Update the maxLength for the current window
            maxLength = Math.max(maxLength, j - i + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String str = "AABABBA";
        int k = 1;

        int output = longestRepeatingCharacterReplacementBruteForce(str, k);
        System.out.println(output);

        int output2 = longestRepeatingCharacterReplacement(str, k);
        System.out.println(output2);

    }
}
