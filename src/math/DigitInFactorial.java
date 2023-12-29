package math;

public class DigitInFactorial {
    public static void main(String[] args) {
        int n = 100;
        double sum = 0.0;
        for(int i = 1; i <= n; i++){
            sum += Math.log10(i);
        }
        int ans = (int)(Math.floor(sum) + 1);
        System.out.println(ans);

    }
}
