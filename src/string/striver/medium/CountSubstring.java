package string.striver.medium;

import java.util.Arrays;
import java.util.HashMap;

public class CountSubstring {

    public static int countSubStringsAtLeastKDistictCharacter(String str, int k) {
        int[] frequency = new int[26];
        int j = 0;
        int n = str.length();
        int distinctCount = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            while (j < n && distinctCount < k) {
                frequency[str.charAt(j) - 'a']++;
                if (frequency[str.charAt(j) - 'a'] == 1) {
                    distinctCount++;
                }
                j++;
            }
            if (distinctCount >= k) {
                count = count + n - j + 1;
            }

            frequency[str.charAt(i) - 'a']--;
            if (frequency[str.charAt(i) - 'a'] == 0) {
                distinctCount--;
            }
        }
        return count;

    }

    public static int countSubString(String str, int k) {
        int output = countSubStringsAtLeastKDistictCharacter(str, k) - countSubStringsAtLeastKDistictCharacter(str, k + 1);
        return output;
    }

    // Brute Force
    // TC : O(n^2)
    public static int countkDist(String str, int k) {
        // Initialize result
        int count = 0;
        int n = str.length();

        // To store seen characters from 'a' to 'z'
        boolean seen[] = new boolean[26];

        // Consider all substrings beginning with
        // str[i]
        for (int i = 0; i < n; i++) {
            int distCount = 0;

            // mark all chars as unseen
            Arrays.fill(seen, false);

            // Consider all substrings between str[i..j]
            for (int j = i; j < n; j++) {
                // If this is a new character for this
                // substring, increment dist_count.
                if (!seen[str.charAt(j) - 'a'])
                    distCount++;

                // mark current char as seen
                seen[str.charAt(j) - 'a'] = true;

                // If distinct character count becomes k,
                // then increment result.
                if (distCount == k)
                    count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String str = "aacfssa";
        int k = 3;
        int output = countSubString(str, k);
        System.out.println(output);

        System.out.println(countkDist(str, k));

    }
}



