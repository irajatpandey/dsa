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

    public static int merge(int[] arr, int start, int mid, int end){
        int left = 0, right = 0, count = 0;

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
                count += (mid + 1) - (start + left);
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
        return count;
    }
    public static int mergeSort(int[] arr, int start, int end){
        int count = 0;
        if(start < end){
            int mid = (start + end)/2;

            // Merge Sort Call
            count += mergeSort(arr, start, mid);
            count += mergeSort(arr, mid + 1, end);
            count += merge(arr,start, mid, end);
        }
        return count;
    }

    public static int numberOfInversions_mergeSort(int []arr, int n) {
        int totalCount = mergeSort(arr, 0, n);

        return totalCount;

    }



    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 4, 1};
        int n = arr.length;

        int output1 = numberOfInversions_bruteForce(arr, n);
        System.out.println(output1);

        int output2 = numberOfInversions_mergeSort(arr, n - 1);

        System.out.println(output2);

    }
}
