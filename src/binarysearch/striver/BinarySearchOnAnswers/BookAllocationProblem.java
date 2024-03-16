package binarysearch.striver.BinarySearchOnAnswers;

import java.util.ArrayList;
import java.util.Collections;
//https://www.interviewbit.com/problems/allocate-books/


public class BookAllocationProblem {
    public static boolean isAllocationPossible(ArrayList<Integer> arr, int n, int m, int maxPages){

        int sum = 0;
        int students = 1;

        for(int i = 0; i < n; i++){
            sum += arr.get(i);
            if(sum > maxPages){
                students++;
                sum = arr.get(i);
            }
        }

        return students > m ? false : true;

    }

    // T.C O((sum - max + 1) * n)
    public static int findPages_linearSearch(ArrayList<Integer> arr, int n, int m){
        if(m > n) return -1;
        int res = -1;
        int start = Collections.max(arr);
        int end = 0;
        for(int ele : arr){
            end += ele;
        }

        for(int pages = start; pages <= end; pages++){
            if(isAllocationPossible(arr, n, m, pages)){
                return pages;
            }
        }
        return res;
    }


    // T.C O((sum - max + 1) * log(n))
    public static int findPages(ArrayList<Integer> arr, int n, int m) {

        if(m > n){
            return - 1;
        }
        int low = -1, high = 0;;
        low = Collections.max(arr);

        for(int ele : arr){
            high += ele;
        }
        int res = -1;

        while(low <= high){
            //System.out.println("Low " + low + " high " + high);
            int mid = low + (high - low)/2;
            //System.out.println("Mid " + mid);
            if(isAllocationPossible(arr, n, m, mid)){
                res = mid;
                // res = Math.min(res, mid);
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return res;
    }



    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(4);
        arr.add(1);
        arr.add(17);
        arr.add(14);
        arr.add(9);
        arr.add(15);
        arr.add(9);
        arr.add(14);
        int k = 7;

        int output = findPages(arr, arr.size(), k);
        System.out.println(output);
        int output2 = findPages_linearSearch(arr, arr.size(), k);
        System.out.println(output2);
    }
}
