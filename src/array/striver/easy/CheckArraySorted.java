package array.striver.easy;

public class CheckArraySorted {
    public static boolean isSorted(int n, int []arr) {
        // Write your code here.

        for(int i = 1; i < n; i++){
            if(arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        int n = arr.length;
        if(isSorted(n, arr)){
            System.out.println("Sorted");
        }
        else{
            System.out.println("Not Sorted!");
        }
    }
}
