package math;

public class GCD {
    public static int calcGCD(int a, int b) {
        if (a == 0)
            return b;
        else if (b == 0)
            return a;
        while (a != b) {
            if (a > b)
                a = a - b;
            else
                b = b - a;
        }
        return a;
    }
    public static void main(String[] args) {
        int a = 12, b = 6;
        System.out.println(calcGCD(a, b));
    }
}
