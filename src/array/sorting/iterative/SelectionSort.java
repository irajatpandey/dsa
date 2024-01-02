package array.sorting.iterative;

import java.util.Collection;
import java.util.Collections;

public class SelectionSort {
    public static void selectionSort(int arr[]){
        int n = arr.length;
        for(int i = 0; i < n; i++){
            int minElemntIndex = i;
            for(int j = i; j < n; j++){
                if(arr[j] < arr[minElemntIndex]){
                    minElemntIndex = j;
                }
            }
            int c = arr[i];
            arr[i] = arr[minElemntIndex];
            arr[minElemntIndex] = c;

        }

        for(int ele : arr) System.out.print(ele + " ");

    }
    public static void main(String[] args) {
        int arr[]  = {9, 2, 4, 1, 3, 7};
        selectionSort(arr);

    }
}
