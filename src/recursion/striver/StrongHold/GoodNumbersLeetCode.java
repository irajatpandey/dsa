package recursion.striver.StrongHold;

public class GoodNumbersLeetCode {
    public static long powMod(long base, long exp) {
        if (exp == 0) {
            return 1;
        }
        long half = powMod(base, exp / 2) % 1000000007;
        long result = (half * half) % 1000000007;
        if (exp % 2 == 1) {
            result = (result * base) % 1000000007;
        }
        return result;
    }
    public static int countGoodNumbers(long n) {
        long odd = n/2;
        long even = n/2 + n % 2;

        long output = powMod(4, odd) % 1000000007 * powMod(5, even) % 1000000007;

        output = output % 1000000007;

        return (int)output;
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println(countGoodNumbers(n));
    }

}
