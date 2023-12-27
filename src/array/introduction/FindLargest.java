package array.introduction;

public class FindLargest {
    static int largestElement(int[] arr, int n) {
        // Write your code here.

        int largest = arr[0];
        for(int ele : arr){
            if(largest < ele){
                largest = ele;
            }
        }
        return largest;

    }
    public static void main(String[] args) {

        int arr[] = {12,34,31, -1, 2323, 23,45};
        int smallOutput = largestElement(arr, arr.length);
        System.out.println(smallOutput);
    }
}
