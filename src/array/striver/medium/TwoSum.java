package array.striver.medium;

import java.util.Collection;
import java.util.HashMap;

// Leetcode https://leetcode.com/problems/two-sum/
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int output[] = new int[2];
        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int i = 0; i < n; i++){
            if(mp.containsKey(target - nums[i])){
                output[1] = i;
                output[0] = mp.get(target -nums[i]);
                return output;
            }
            else {
                mp.put(nums[i], i);
            }

        }
        return output;
    }
    public static void main(String[] args) {
        int nums[] = {3, 3};
        int target = 9;
        int output[] = twoSum(nums, target);
        System.out.println(output[0] + " " + output[1]);
    }
}
