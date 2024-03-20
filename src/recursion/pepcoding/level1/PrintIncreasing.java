package recursion.pepcoding.level1;

public class PrintIncreasing {
    public static void printIncreasing(int n){
        // base case
        if (n > 0) {
            printIncreasing(n - 1);
            System.out.println(n);
        }
    }
    public static void main(String[] args) {
        int n = 10;
        printIncreasing(n);
    }
}
