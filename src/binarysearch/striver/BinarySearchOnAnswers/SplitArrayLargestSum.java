package binarysearch.striver.BinarySearchOnAnswers;
// https://leetcode.com/problems/split-array-largest-sum/description/

public class SplitArrayLargestSum {
    public static boolean canSplitIntoGroups(int[] nums, int k, int mid){
        int sum = 0;
        int count = 1;
        for(int ele : nums){
            sum += ele;
            if(sum > mid){
                count++;
                sum = ele;
            }
        }
        return count > k ? false : true;
    }
    public static int splitArray(int[] nums, int k) {
        int low = Integer.MIN_VALUE, high = 0;
        if(k > nums.length) return -1;
        for(int ele : nums){
            high += ele;
            low = Math.max(low, ele);
        }

        int res = -1;

        while(low <= high){

            int mid = low + (high - low)/2;
            if(canSplitIntoGroups(nums, k, mid)){
                res = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {7, 2, 5, 10, 8};
        int k = 2;
        int output = splitArray(nums, k);
        System.out.println(output);
    }
}
