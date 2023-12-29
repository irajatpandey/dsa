package math;

public class CountDigit {
    public static int getCountOfDigit(int n){
        int cnt = 0;
        while(n > 0){
            cnt++;
            n /= 10;
        }
        return cnt;
    }
    public static void main(String[] args) {
        int n = 2134;
        // Approach - 1, Time Complexity O(n)
        int ans = getCountOfDigit(n);
        System.out.println(ans);

        // Approach - 2 Time Complexity O(1)
        int output = (int) (Math.floor(Math.log10(n)) + 1);
        System.out.println(output);
    }
}
