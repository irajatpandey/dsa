package array.striver.easy;

// Leetcode - 1752
// https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/
public class CheckArraySortedAndRotated {
    public static boolean isSortedAndRotated(int n, int []arr) {
        // Write your code here.
        int k = 0;
        for(int i = 0; i < n; i++){
            System.out.println(arr[i] + " " + arr[(i + 1) % n]);
            if(arr[i] > arr[(i + 1) % n]){
                k++;
            }
            if(k > 1) {
                return false;
            }

        }
        return true;
    }
    public static void main(String[] args) {

        int arr[] = {3, 4, 5, 1, 2};
        int n = arr.length;
        if(isSortedAndRotated(n, arr)){
            System.out.println("Sorted");
        }
        else{
            System.out.println("Not Sorted!");
        }
    }
}
