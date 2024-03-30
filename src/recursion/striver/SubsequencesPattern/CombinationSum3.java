package recursion.striver.SubsequencesPattern;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    public static void combinationSum3Help(int index, int sum,int k, int n, List<Integer> ans, ArrayList<ArrayList<Integer>> ls){
        if(ans.size() == k){
            if(sum == n){
                ls.add(new ArrayList<>(ans));
            }
            return;
        }

        for(int i = index; i < 10; i++){
            if(sum + i <= n){
                ans.add(i);
                combinationSum3Help(i + 1, sum + i, k, n, ans, ls);
                ans.remove(ans.size() - 1);
            }else{
                break;
            }
        }
    }
    public static ArrayList<ArrayList<Integer>> combinationSum3(int k, int n) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> ls = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        combinationSum3Help(1, 0, k, n, ans, ls);
        return ls;

    }

    public static void main(String[] args) {

    }
}
