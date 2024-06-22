package slidingwindow.striver.medium;
//https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
public class SubstringsContainingAllThreeChars {

    // the time complexity is O(n^2) and the space complexity is O(1).
    public static int numberOfSubstringsBruteForce(String s) {
        int count = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int[] freq = new int[3]; // Frequency array for characters 'a', 'b', 'c'

            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++; // Increment frequency for the current character

                if (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                    count++; // Substring contains all three characters
                }
            }
        }

        return count;
    }



    //time complexity of the algorithm is O(n),
    //  the space complexity of the algorithm is O(1)
    public static int numberOfSubstrings(String s) {
        int i = 0, j = 0, ans = 0;
        int freq[] = new int[3];
        for(; j < s.length(); j++){
            freq[s.charAt(j) - 'a']++;

            while(freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                ans += s.length() - j;
                freq[s.charAt(i) - 'a']--;
                i++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abcabc";
        int output = numberOfSubstrings(s);
        System.out.println(output);

        int output2 = numberOfSubstringsBruteForce(s);
        System.out.println(output2);

    }
}
