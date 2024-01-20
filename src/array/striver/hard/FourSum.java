package array.striver.hard;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/4sum/description/
// TC: O(n * logn) + O(n ^ 3) => O(n ^ 3)
// SC: O(1) - ignoring the output array
public class FourSum {
    public static List<List<Integer>> threeSum(int[] nums, long target, int startingIndex){
        int n = nums.length;
        List<List<Integer>> subResult = new ArrayList<>();
        if(n < 3) return subResult;

        // Duplicates

        for(int i = startingIndex; i <= n - 3; i++){

            // Duplicates
            if(i > startingIndex && nums[i - 1] == nums[i]){
                continue;
            }

            int low = i + 1;
            int high = n - 1;

            while(low < high){
                long sum = (long)nums[i] + (long)nums[low] + (long)nums[high];
                System.out.println(sum);
                if(target == sum){
                    ArrayList<Integer> ls = new ArrayList<>();
                    ls.add(nums[i]);
                    ls.add(nums[low]);
                    ls.add(nums[high]);
                    subResult.add(ls);
                    while (low < high && nums[low] == nums[low + 1]) {
                        low++;
                    }

                    // Skip duplicate elements for high
                    while (low < high && nums[high] == nums[high - 1]) {
                        high--;
                    }
                    low++;
                    high--;
                }

                else if(target < sum){
                    high--;
                }
                else{
                    low++;
                }
            }


        }

        return subResult;
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> output = new ArrayList<>();
        int n = nums.length;
        if(n < 4) return output;
        Arrays.sort(nums);

        for(int i = 0; i <= n - 4; i++){
            // Duplicate
            if(i > 0 && nums[i - 1] == nums[i]){
                continue;
            }

            Integer val1 = nums[i];
            List<List<Integer>> list = threeSum(nums, target - val1, i + 1);
            for(List<Integer> ls : list){
                ls.add(val1);
                output.add(ls);
            }

        }

        return output;

    }
    public static void main(String[] args) {

        int[] nums = {1000000000,1000000000,1000000000,1000000000};
        int target = -294967296;
        List<List<Integer>> output = fourSum(nums, target);
        System.out.println(output);
    }
}
