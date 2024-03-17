package binarysearch.striver.BinarySearchOnAnswers;
//https://leetcode.com/problems/median-of-two-sorted-arrays/description/
public class MedianOfTwoSortedArray {

    public static void merge(int[] arr1, int[] arr2, int[] arr3){
        int m = arr1.length, n = arr2.length;
        int i = 0, j = 0, k = 0;

        while(i < m && j < n){
            if(arr1[i] < arr2[j]){
                arr3[k++] = arr1[i];
                i++;
            } else{
                arr3[k++] = arr2[j];
                j++;
            }
        }

        while(i < m){
            arr3[k++] = arr1[i];
            i++;
        }

        while(j < n){
            arr3[k++] = arr2[j];
            j++;
        }
    }
    public static double medianOfTwoSortedArrayWithExtraSpace(int[] arr1, int[] arr2){
        int[] arr3 = new int[arr1.length + arr2.length];

        merge(arr1, arr2, arr3);
        if(arr3.length % 2 == 1){
            return arr3[arr3.length/2];
        } else{
            int index1 = arr3.length/2;
            int index2 = arr3.length/2 - 1;

            return (arr3[index1] + arr3[index2])/2.0;
        }
    }

    public static double medianOfTwoSortedArrayWithOutExtraSpace(int[] arr1, int[] arr2){
        int i = 0, j = 0, cnt = 0;
        int medianIndex1 = -1, medianIndex2  = -1;
        int medianIndexElement1 = -1, medianIndexElement2  = -1;
        int m = arr1.length, n = arr2.length;

        int len = m + n;

       medianIndex1 = len/2;
       medianIndex2 = medianIndex1 - 1;

        while(i < m && j < n){
            if(arr1[i] < arr2[j]){
                if(cnt == medianIndex1) medianIndexElement1 = arr1[i];
                if(cnt == medianIndex2) medianIndexElement1 = arr1[j];
                cnt++;
                i++;
            }
            else{
                if(cnt == medianIndex1) medianIndexElement2 = arr2[j];
                if(cnt == medianIndex2) medianIndexElement2 = arr2[j];

                j++;
                cnt++;
            }
        }

        while(i < m){
            if(cnt == medianIndex1) medianIndexElement1 = arr1[i];
            if(cnt == medianIndex2) medianIndexElement1 = arr1[j];
            cnt++;
            i++;

        }

        while(j < n){
            if(cnt == medianIndex1) medianIndexElement2 = arr2[j];
            if(cnt == medianIndex2) medianIndexElement2 = arr2[j];
            cnt++;
            j++;
        }


        if(len % 2 == 1){
            return medianIndexElement2;
        }
        else{
            return (medianIndexElement1 + medianIndexElement2)/2.0;
        }
    }

    //  O(log(min(n1,n2))), where n1 and n2 are the sizes of two given arrays.
    public static double medianOfTwoSortedArrayUsingBinarySearch(int[] arr1, int[] arr2){
        int n1 = arr1.length, n2 = arr2.length;

        if(n1 > n2){
            return medianOfTwoSortedArrayUsingBinarySearch(arr2, arr1);
        }

        int low = 0, high = n1;
        int left = (n1 + n2 + 1) / 2;

        while(low <= high){
            int cut1 = low + (high - low)/2;
            int cut2 = left - cut1;

            int l1 = cut1 == 0 ? Integer.MIN_VALUE : arr1[cut1 - 1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : arr2[cut2 - 1];
            int r1 = cut1 == n1 ? Integer.MAX_VALUE : arr1[cut1];
            int r2 = cut2 == n2 ? Integer.MAX_VALUE : arr2[cut2];


            if(l1 > r2){
                high = cut1 - 1;
            }
            else if(l2 > r1){
                low = cut1 + 1;
            }
            else{
                if((n1 + n2) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                }
                else{
                    return (Math.max(l1, l2));
                }
            }

        }
        return 0.0;
    }
    public static void main(String[] args) {
        int[] arr1 = {2, 4, 6};
        int[] arr2 = {1, 3};

        //double output1 = medianOfTwoSortedArrayWithExtraSpace(arr1, arr2);
        //System.out.println(output1);

        //double output2 = medianOfTwoSortedArrayWithOutExtraSpace(arr1, arr2);
        //System.out.println(output2);

        double output3 = medianOfTwoSortedArrayUsingBinarySearch(arr1, arr2);
        System.out.println(output3);
    }
}
