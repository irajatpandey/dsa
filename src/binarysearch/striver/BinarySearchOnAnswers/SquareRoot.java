package binarysearch.striver.BinarySearchOnAnswers;

public class SquareRoot {
    // T.C O(logn)
    public static int findSqrt(int n){
        int ans = 0;
        int low = 1, high = n;
        while (low <= high){
            int mid = (low + high)/2;
            if((mid * mid) <= n){
                ans = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int n = 7;
        System.out.println(findSqrt(n));

    }
}
