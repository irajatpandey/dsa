package math;

public class FastExponentiation {
    //TC O(log(n))
    public static int modularExponentiation(int x, int n, int m) {
        long smallOutput = 1;
        long x1 = x;
        x1 = x1 % m;
        while(n > 0){
            if((n & 1) == 1){
                smallOutput = ((smallOutput)%m * (x1)%m)%m;
            }
            x1 = ((x1 % m) * (x1 % m)) % m;
            n = n >> 1;
        }
        return (int)(smallOutput % m);
    }
    public static void main(String[] args) {
        int x = 10000000, n = 2, m = 10000001;
        // output - 1
        int ans = modularExponentiation(x,n,m);
        System.out.println(ans);
    }
}
