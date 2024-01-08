package array.striver.medium;

public class MaxSumSubArray {
    public static int maxSumSubArray(int nums[]){
        int n = nums.length;
        int currentBestSum = 0;
        int maxSumSoFar = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            if(nums[i] + currentBestSum > nums[i]){
                currentBestSum += nums[i];
            }
            else{
                currentBestSum = nums[i];
            }
            maxSumSoFar = Math.max(currentBestSum, maxSumSoFar);
        }
        return maxSumSoFar;
    }
    public static void main(String[] args) {
        int nums[] = {4, 3, -2, 6, -14, 7, -1, 4, 5, 7, -10, 2, 9, -10, -5, -9, 6, 1};
        int output = maxSumSubArray(nums);
        System.out.println(output);
    }
}
