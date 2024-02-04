package binarysearch;

public class UpperBound {
    public static int upperBound(int []arr, int n, int target) {

        int start = 0, end = n - 1;
        int lower_bound = -1;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(arr[mid] > target) {
                lower_bound = mid;

                end = mid - 1;
            }
            else{
                start = mid + 1;
            }

        }
        return lower_bound;

    }
    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 15, 19};
        int target = 9;
        int output = upperBound(arr, arr.length, target);
        System.out.println(output);
    }
}
