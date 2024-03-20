package recursion.pepcoding.level1;

public class PringDecreasing {
    public static void printIncreasing(int n){
        // base case
        if (n > 0) {
            System.out.println(n);
            printIncreasing(n - 1);
        }
    }
    public static void main(String[] args) {
        int n = 10;
        printIncreasing(n);
    }
}
