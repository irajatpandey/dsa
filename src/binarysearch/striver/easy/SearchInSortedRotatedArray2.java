package binarysearch.striver.easy;

// T.C O(logn) for average case and O(n) for the worst case
// S.C O(1)
//https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
public class SearchInSortedRotatedArray2 {
    public static boolean searchInSortedRotatedArray2(int[] nums, int target){
        int start = 0, end = nums.length - 1;

        while(start <= end){
            while(start < end && nums[start] == nums[start + 1]) start++;
            while(start < end && nums[end] == nums[end - 1]) end--;

            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                return true;
            }
            // is Left Sorted
            else if(nums[start] <= nums[mid] ){
                if(nums[start] <= target && target < nums[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            }
            else{
                if(nums[mid] < target && target <= nums[end]){
                    start = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = {2,5,6,0,0,1,2};
        int n = nums.length;

        int target = 0;
        boolean ans = searchInSortedRotatedArray2(nums, target);
        System.out.println(ans);
    }
}
