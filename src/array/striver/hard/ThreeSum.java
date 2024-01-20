package array.striver.hard;

import java.lang.reflect.Array;
import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        int target = 0;
        Arrays.sort(nums);

        for(int i = 0; i < n; i++) {
            // Skip duplicate elements for i
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int low = i + 1, high = n - 1;

            // Skip duplicate elements for j


            while(low < high){
                 int sum = nums[i] + nums[low] + nums[high];


                 if(sum == target){
                     ArrayList<Integer> ls = new ArrayList<>();
                     ls.add(nums[i]);
                     ls.add(nums[low]);
                     ls.add(nums[high]);
                     output.add(ls);

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

                 else if(sum > target){
                     high--;
                 }
                 else{
                     low++;
                 }
            }
        }

        return output;
    }
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> output = threeSum(nums);
        System.out.println(output);
    }
}
