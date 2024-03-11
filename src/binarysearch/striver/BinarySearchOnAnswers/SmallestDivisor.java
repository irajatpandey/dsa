package binarysearch.striver.BinarySearchOnAnswers;
// https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
public class SmallestDivisor {
    public static int getSum(int[] nums, int divisor){
        int sum = 0;
        for(int item : nums){
            sum += (item + divisor - 1) / divisor;
        }
        return sum;
    }
    public static int smallestDivisor(int[] nums, int threshold) {
        int low = 1, high  = Integer.MIN_VALUE;
        // Find the maximum value in the array
        for (int num : nums) {
            high = Math.max(high, num);
        }
        while(low <= high) {
            int mid = low + (high - low)/2;
            int smallOutput = getSum(nums, mid);
            // if sum is exceeding the threshold, which means we need larger value to minimise the sum,
            // hence low = mid + 1
            if(smallOutput > threshold){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,5,9};
        int threshold = 6;

        System.out.println(smallestDivisor(nums, threshold));


    }
}
