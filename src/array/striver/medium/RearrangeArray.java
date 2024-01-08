package array.striver.medium;

public class RearrangeArray {
    public static int[] rearrangeArray(int[] nums){
        int n = nums.length;
        int ans[] = new int[nums.length];

        int positiveIndex = 0;
        int negativeIndex = 1;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                ans[positiveIndex] = nums[i];
                positiveIndex += 2;
            }
            else{
                ans[negativeIndex] = nums[i];
                negativeIndex += 2;
            }
        }
        return ans;

    }
    public static void main(String[] args) {
        int[] nums = {3, 1,-2,-5,2,-4};
        int ans[] = rearrangeArray(nums);
        for(int ele : ans)
            System.out.print(ele + " ");

    }
}
