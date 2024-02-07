package binarysearch.striver.easy;

public class SearchInSortedRotatedArray {
    public static int searchInSortedRotatedArray(int[] nums, int target){
        int start = 0, end = nums.length - 1;

        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                return mid;
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
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int n = nums.length;

        int target = 0;
        int ans = searchInSortedRotatedArray(nums, target);
        System.out.println(ans);
    }
}
