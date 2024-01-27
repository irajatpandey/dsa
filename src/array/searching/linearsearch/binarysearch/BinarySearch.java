package array.searching.linearsearch.binarysearch;

public class BinarySearch {

    //Iterative Approach
    public static int binarySearch_iterative(int[] arr, int start, int end, int target){
        while(start <= end){
            int mid = (start + end)/2;
            if(arr[mid] > target){
                end = mid - 1;
            }
            else if(arr[mid] == target){
                return mid;
            }
            else{
                start = mid + 1;
            }
        }
        return -1;
    }

    // Recursive Apporach
    public static int binarySearch_recursive(int[] arr, int start, int end, int target){
        if(start > end){
            return -1;
        }
        int mid = (start + end)/2;

        if(arr[mid] > target){
            return binarySearch_recursive(arr, start, mid - 1, target);
        }
        else if(arr[mid] == target){
            return mid;
        }
        else{
            return binarySearch_recursive(arr, mid + 1, end, target);
        }

    }
    public static void main(String[] args) {

        int arr[] = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int target = 100;

        int output1 = binarySearch_iterative(arr, 0, arr.length - 1, target);
        System.out.println(output1);

        int output2 = binarySearch_recursive(arr, 0, arr.length - 1, 30);
        System.out.println(output2);


    }
}
