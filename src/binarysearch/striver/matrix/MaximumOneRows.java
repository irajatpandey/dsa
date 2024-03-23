package binarysearch.striver.matrix;

import java.util.ArrayList;
import java.util.Arrays;
// https://www.codingninjas.com/studio/problems/row-of-a-matrix-with-maximum-ones_982768

// Amazon, Microsoft, Flipkart
public class MaximumOneRows {
    // Time Complexity nlog(m)
    public static int lower_bound(ArrayList<Integer> arr, int m, int ele){
        int low = 0, high = m - 1;
        int res = m;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr.get(mid) >= ele){
                res = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return res;
    }
    public static int maximumOnesRow(ArrayList<ArrayList<Integer>> matrix, int n, int m){
        int index = -1, maxCount = 0;

        for(int i = 0; i < n; i++){

            int countOnes = m - lower_bound(matrix.get(i), m, 1);
            //  System.out.println(countOnes);
            if (countOnes > maxCount){
                maxCount = countOnes;
                index = i;
            }
        }
        return index;
    }
    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>(3);

        ArrayList<Integer> ls1 = new ArrayList<>(Arrays.asList(1, 1, 1));
        ArrayList<Integer> ls2 = new ArrayList<>(Arrays.asList(0, 0, 1));
        ArrayList<Integer> ls3 = new ArrayList<>(Arrays.asList(0, 0, 0));

        matrix.add(ls1);
        matrix.add(ls2);
        matrix.add(ls3);

        int output = maximumOnesRow(matrix, matrix.size(), ls1.size());
        System.out.println(matrix);
        System.out.println(output);

    }
}
