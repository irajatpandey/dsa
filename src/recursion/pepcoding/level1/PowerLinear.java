package recursion.pepcoding.level1;

public class PowerLinear {
    public static int power(int x, int n){
        if(n == 1){
            return x;
        }

        int smallOutput = power(x, n - 1);
        return smallOutput * x;
    }
    public static void main(String[] args) {
        int x = 2, n = 5;
        int output = power(x, n);
        System.out.println(output);
    }
}
