package array.striver.hard;

import java.util.ArrayList;

public class CountInversions {
    public static int numberOfInversions_bruteForce(int []arr, int n) {
        int ans = 0;

        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(arr[i] > arr[j]){
                    ans++;
                }
            }
        }

        return ans;
    }

    public static void merge(int[] arr, int start, int mid, int end, ArrayList<Integer> ls){
        int left = 0, right = 0;

        // Create Two Arrays
        int[] leftArray = new int[mid - start + 1];
        int[] rightArray = new int[end - mid];

        // Copy first Half
        for(int i = 0; i < leftArray.length; i++){
            leftArray[i] = arr[start + i];
        }

        // Copy Second Half
        for(int i = 0; i < rightArray.length; i++){
            rightArray[i] = arr[mid + 1 + i];
        }

        // Merge
        int k = start;
        while(left < leftArray.length && right < rightArray.length){
            if(leftArray[left] <= rightArray[right]){
                arr[k] = leftArray[left];
                left++;
            }
            else{
                arr[k] = rightArray[right];
                right++;
            }
            k++;
        }

        while(left < leftArray.length){
            arr[k] = leftArray[left];
            k++;
            left++;
        }

        while(right < rightArray.length){
            arr[k] = rightArray[right];
            k++;
            right++;
        }
    }
    public static void mergeSort(int[] arr, int start, int end,  ArrayList<Integer> ls){

        if(start < end){
            int mid = (start + end)/2;
            //System.out.println(mid);
            int[] leftArray = new int[mid - start + 1];
            int[] rightArray = new int[end - mid];



            mergeSort(arr, start, mid, ls);
            mergeSort(arr, mid + 1, end, ls);
            merge(arr,start, mid, end, ls);
        }

    }

    public static int numberOfInversions_mergeSort(int []arr, int n) {
        int count = 0;

        ArrayList<Integer> ls = new ArrayList<>();
        mergeSort(arr, 0, n, ls);

        for(int ele : ls){
            System.out.print(ele + " ");
        }

        return  count;

    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 4, 1};
        int n = arr.length;

//        int output1 = numberOfInversions_bruteForce(arr, n);
//        System.out.println(output1);

        int output2 = numberOfInversions_mergeSort(arr, n - 1);

        for(int ele : arr) System.out.print(ele + " ");


    }
}
