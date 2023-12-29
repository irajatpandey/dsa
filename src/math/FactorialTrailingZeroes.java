package math;

public class FactorialTrailingZeroes {
    public static int getTrailingZeroes(int n){
        int result = 0;
        for (int i = 5; n / i >= 1; i *= 5)
            result += n / i;

        return result;
    }
    public static void main(String[] args) {
        int n = 200;
        int answer = getTrailingZeroes(n);
        System.out.println(answer);
    }
}
