package binarysearch.striver.BinarySearchOnAnswers;
//https://leetcode.com/problems/kth-missing-positive-number/description/
public class KthMissingPositiveNumber {

    // bruteforce O(n)

    public static int findKthPositive_bruteForce(int[] arr, int k){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= k) //shifting k
                k++;
            else
                break;
        }
        return k;
    }
    //T.C O(logn)
    public static int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        // where exactly kth missing number will fall

        int low =  0, high = n - 1;

        while(low <= high){
            int mid = low + (high - low)/2;
            int  missing_number = (arr[mid]  - (mid + 1));
            if(missing_number < k){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        return low + k;
    }
    public static void main(String[] args) {
        int arr[] = {2,3,4,7,11};
        int k = 5;
        System.out.println(findKthPositive(arr, k));
        System.out.println(findKthPositive_bruteForce(arr, k));
    }
}
