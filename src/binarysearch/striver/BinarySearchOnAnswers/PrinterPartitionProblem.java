package binarysearch.striver.BinarySearchOnAnswers;

import java.util.ArrayList;
// https://www.codingninjas.com/studio/problems/painter-s-partition-problem_1089557?
public class PrinterPartitionProblem {

    public static boolean canSplitIntoGroups(ArrayList<Integer> boards, int k, int mid){
        int sum = 0;
        int count = 1;
        for(int ele : boards){
            sum += ele;
            if(sum > mid){
                count++;
                sum = ele;
            }
        }
        return count > k ? false : true;
    }
    public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
        int low = Integer.MIN_VALUE, high = 0;
        if(k > boards.size()) return -1;
        for(int ele : boards){
            high += ele;
            low = Math.max(low, ele);
        }

        int res = -1;

        while(low <= high){

            int mid = low + (high - low)/2;
            if(canSplitIntoGroups(boards, k, mid)){
                res = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
