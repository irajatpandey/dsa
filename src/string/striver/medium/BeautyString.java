package string.striver.medium;

public class BeautyString {
    public static int getFrequencyCount(int[] count) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int c : count) {
            if (c == 0)  // skip 0s
                continue;
            min = Math.min(min, c);
            max = Math.max(max, c);
        }

        return max - min;
    }

    public static int beautySum(String s) {
        int ans = 0;
        int n = s.length();
        int[] count;

        for (int i = 0; i < n; i++) {
            count = new int[26]; // reset counter
            for (int j = i; j < n; j++) {
                count[s.charAt(j) - 'a']++;
                if (j - i >= 2) { // string length should be >= 2
                    ans += getFrequencyCount(count);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "aabcb";
        int ans = beautySum(str);
        System.out.println(ans);
    }
}
