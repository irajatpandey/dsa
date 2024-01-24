package array.striver.hard;

import java.util.Arrays;

public class MergeTwoSortedArray {
    public static void swapIfGreater(int[] arr1, int[] arr2, int ind1, int ind2) {
        if (arr1[ind1] > arr2[ind2]) {
            int temp = arr1[ind1];
            arr1[ind1] = arr2[ind2];
            arr2[ind2] = temp;
        }
    }
    public static void merge_WithExtraSpace(int[] arr1, int[] arr2, int n, int m){
        int left = 0, right = 0;
        int[] output = new int[m + n];
        int index = 0;
        while(left < n && right < m){
            if(arr1[left] <= arr2[right]){
                output[index++] = arr1[left++];
            }
            else{
                output[index++] = arr2[right++];
            }
        }

//        System.out.println(left + " " + right);

        while(left < n){
            output[index++] = arr1[left++];
        }

        while(right < m){
            output[index++] = arr2[right++];

        }

        for(int i = 0; i < output.length; i++){
            if(i  < n){
                arr1[i] = output[i];
            }
            else {
                arr2[i - n] = output[i];
            }
        }

        for(int ele : arr1) System.out.print(ele + " ");
        System.out.println();
        for(int ele : arr2) System.out.print(ele + " ");

    }

    //Time Complexity: O(min(n, m)) + O(n*logn) + O(m*logm), where n and m are the sizes of the given arrays.
    //Reason: O(min(n, m)) is for swapping the array elements. And O(n*logn) and O(m*logm) are for sorting the two arrays.
    //
    //Space Complexity: O(1) as we are not using any extra space.
    public static void merge_Optimal1(int[] arr1, int[] arr2, int n, int m){
        int pointer1 = n - 1;
        int pointer2 = 0;

        while(pointer1 >= 0 && pointer2 < m){
            if(arr1[pointer1] >= arr2[pointer2]){
                int c = arr1[pointer1];
                arr1[pointer1] = arr2[pointer2];
                arr2[pointer2] = c;
                pointer1--;
                pointer2++;
            }
            else{
                pointer1--;
                pointer2++;
            }
        }

        Arrays.sort(arr1, 0, n);
        Arrays.sort(arr2, 0, m);

        for(int ele : arr1) System.out.print(ele + " ");
        System.out.println();
        for(int ele : arr2) System.out.print(ele + " ");


    }

    // Time Complexity: O((n+m)*log(n+m)), where n and m are the sizes of the given arrays.
    public static void merge_gapAlgo(int[] arr1, int[] arr2, int n, int m){
        int len = n + m;

        // Initial gap:
        int gap = (len / 2) + (len % 2);

        while(gap > 0) {
            // Place 2 pointers:
            int left = 0;
            int right = left + gap;
            while (right < len) {
                if (left < n && right >= n) {
                    swapIfGreater(arr1, arr2, left, right - n);
                } else if (left >= n) {
                    swapIfGreater(arr1, arr2, left - n, right - n);

                } else {
                    swapIfGreater(arr1, arr2, left, right);
                }
                left++;
                right++;
            }

            // break if iteration gap=1 is completed:
            if (gap == 1) break;

            // Otherwise, calculate new gap:
            gap = (gap / 2) + (gap % 2);
        }

        for(int ele : arr1) System.out.print(ele + " ");
        System.out.println();
        for(int ele : arr2) System.out.print(ele + " ");
    }
    public static void main(String[] args) {
        int arr1[] = {1,2,3};
        int arr2[] = {2,5,6};

//        merge_WithExtraSpace(arr1, arr2, arr1.length, arr2.length);
//        merge_Optimal1(arr1, arr2, arr1.length, arr2.length);
        merge_gapAlgo(arr1, arr2, arr1.length, arr2.length);
    }
}
