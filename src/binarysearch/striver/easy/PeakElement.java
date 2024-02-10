package binarysearch.striver.easy;

public class PeakElement {
    public static int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1;
        int n = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if((mid == 0 || nums[mid - 1] < nums[mid]) &&
                    (mid == n || nums[mid] > nums[mid + 1])){
                return mid;
            }
            else if((mid == 0 || nums[mid - 1] < nums[mid]) &&
                    (mid == n || nums[mid] < nums[mid + 1])){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        int output = findPeakElement(nums);
        System.out.println(output);
    }
}
