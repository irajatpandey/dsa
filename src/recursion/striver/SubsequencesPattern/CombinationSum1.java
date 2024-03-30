package recursion.striver.SubsequencesPattern;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combination-sum/
/*Time Complexity: O(2^t * k) where t is the target, k is the average length
Reason: Assume if you were not allowed to pick a single element multiple times, every element will have a couple of options: pick or not pick which is 2^n different recursion calls, also assuming that the average length of every combination generated is k. (to put length k data structure into another data structure)

Why not (2^n) but (2^t) (where n is the size of an array)?
Assume that there is 1 and the target you want to reach is 10 so 10 times you can “pick or not pick” an element.
Space Complexity: O(k*x), k is the average length and x is the no. of combinations */

public class CombinationSum1 {
    public static void combinationSumHelper(int[] candidates, int index, int target, List<Integer> answerSoFar, List<List<Integer>> ans){
        if(candidates.length == index){
            if(target == 0)
                ans.add(new ArrayList<>(answerSoFar));
            return;
        }

        if(target >= candidates[index]){
            answerSoFar.add(candidates[index]);
            combinationSumHelper(candidates, index, target - candidates[index], answerSoFar, ans);
            answerSoFar.remove(answerSoFar.size() - 1);
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
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> output = combinationSum(candidates, target);

        System.out.println(output);
    }
}
