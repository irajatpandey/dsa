package recursion.striver.SubsequencesPattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/combination-sum-ii/
public class CombinationSum2 {
    public static void combinationSumHelper(int[] candidates, int index, int target, List<Integer> answerSoFar, List<List<Integer>> ans){
        if(candidates.length == index || target == 0) {
            if (target == 0) {
                ans.add(new ArrayList<>(answerSoFar));
                return;
            }
            return;
        }

        if(target >= candidates[index]){
           answerSoFar.add(candidates[index]);
           combinationSumHelper(candidates, index + 1, target - candidates[index], answerSoFar, ans);
           answerSoFar.remove(answerSoFar.size() - 1);
        }
        while(index + 1 < candidates.length && candidates[index] == candidates[index + 1]) {
            index++;
        }
        combinationSumHelper(candidates, index + 1, target, answerSoFar, ans);

    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> answerSoFar = new ArrayList<>();

        combinationSumHelper(candidates, 0, target, answerSoFar,ans);

        return ans;
    }
    public static void main(String[] args) {
        int[] candidates = {1, 2, 3, 1, 5};
        int target = 5;
        Arrays.sort(candidates);
        List<List<Integer>> output = combinationSum(candidates, target);

        System.out.println(output);
    }
}
