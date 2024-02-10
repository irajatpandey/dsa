package binarysearch.striver.easy;

public class NumberOfTimesArrayIsRotated {
    // https://www.codingninjas.com/studio/problems/rotation_7449070?
    // T.C : O(logn)
    // S.C : O(1)
    public static int findKRotation(int []arr){
        // Write your code here.
        int low = 0, high = arr.length - 1;
        int ans = Integer.MAX_VALUE;
        int minIndex = -1;
        while(low <= high){
            int mid = low + (high - low)/2;

            if(arr[low] <= arr[mid]){
                if(ans > arr[low]){
                    minIndex = low;
                    ans = arr[low];
                }
                low = mid + 1;
            }
            else{
                if(ans > arr[mid]){
                    minIndex = mid;
                    ans = arr[mid];
                }
                high = mid - 1;
            }
        }
        return minIndex;
    }
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 2};
        int output = findKRotation(arr);
        System.out.println(output);

    }
}
