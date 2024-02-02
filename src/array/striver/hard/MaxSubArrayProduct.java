package array.striver.hard;

public class MaxSubArrayProduct {
    public static int maxProduct(int[] nums) {
        int n = nums.length;
        int leftToRightMax = nums[0];
        int rightToLeftMax = nums[n - 1];
        int product = 1;

        for(int i = 0; i < n; i++){
            product = product * nums[i];
            leftToRightMax = Math.max(leftToRightMax, product);
            if(product == 0){
                product = 1;
            }
        }
        product = 1;

        for(int i = n - 1; i >= 0; i--){
            product = product * nums[i];
            rightToLeftMax = Math.max(rightToLeftMax, product);
            if(product == 0){
                product = 1;
            }
        }

        return Math.max(leftToRightMax, rightToLeftMax);
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        int output = maxProduct(nums);
        System.out.println(output);
    }
}
