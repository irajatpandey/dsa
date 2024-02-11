package binarysearch.striver.OneDimensionalArray;

public class MinInSortedRotatedArray {
    //https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
    // T.C : O(logn)
    // S.C : O(1)
    public static int findMin(int[] nums) {
        int end = nums.length - 1, start = 0, ans = Integer.MAX_VALUE;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[start] <= nums[mid]){
                ans = Integer.min(ans, nums[start]);
                start = mid + 1;
            }
            else{
                ans = Integer.min(ans, nums[mid]);
                end = mid - 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        int output = findMin(nums);
        System.out.println(output);
    }
}
