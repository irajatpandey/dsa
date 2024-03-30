package recursion.striver.SubsequencesPattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/subsets-ii/description/
public class SubsetSum2 {
    public static void subsetWithDupHelp(int[] nums, int index, List<Integer> ans, List<List<Integer>> ls){
        if(nums.length == index){
            ls.add(new ArrayList<>(ans));
            return;
        }
        ans.add(nums[index]);
        subsetWithDupHelp(nums, index + 1, ans, ls);
        ans.remove(ans.size() - 1);
        while(index + 1 != nums.length && nums[index] == nums[index + 1]){
            index++;
        }
        subsetWithDupHelp(nums, index + 1, ans, ls);

    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ls = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        subsetWithDupHelp(nums, 0, ans, ls);

        return ls;

    }
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        Arrays.sort(nums);
        List<List<Integer>> output = subsetsWithDup(nums);
        System.out.println(output);
    }
}
