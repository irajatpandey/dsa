package recursion.pepcoding.level1;

public class Factorial {
    public static int factorial(int n){
        if(n == 0){
            return 1;
        }
        int smallOutput = factorial(n - 1);
        return smallOutput * n;
    }
    public static void main(String[] args) {
        int n = 5;
        int output = factorial(5);
        System.out.println(output);
    }
}
