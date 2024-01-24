package string.striver.medium;
/*
I     ->        1
V     ->        5
X     ->        10
L     ->        50
C     ->        100
D     ->        500
M     ->        1000
**/

// TC: o(n)
//SC: O(n)
public class RomanToInteger {
    public static final int[] table = new int[256];
    static {
        table['I'] = 1;
        table['V'] = 5;
        table['X'] = 10;
        table['L'] = 50;
        table['C'] = 100;
        table['D'] = 500;
        table['M'] = 1000;
    }

    public static int romanToInt(String s) {
        int value = 0;
        int n = s.length();
        int prev = -1;
        int current = 0;
        for (int i = n - 1; i >= 0; i--) {
            current = table[s.charAt(i)];
            if (prev >= current) {
                value -= current;
            }
            else
                value += current;
            prev = current;


        }
        return value;
    }
    public static void main(String[] args) {
        String str = "MCMXCIV";
        System.out.println(romanToInt(str));
    }
}
