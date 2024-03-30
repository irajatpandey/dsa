package recursion.striver.SubsequencesPattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//https://www.naukri.com/code360/problems/subset-sum_3843086
public class SubsetSum1 {
    public static void subsetSumHelper(int[] arr, int index, int n, int sum, ArrayList<Integer> ls ){
        if(index == n){
            ls.add(sum);
            return;
        }
        sum += arr[index];
        subsetSumHelper(arr, index + 1, n, sum, ls);

        sum -= arr[index];
        subsetSumHelper(arr, index + 1, n, sum, ls);
    }

    public static ArrayList<Integer> subsetSum(int num[]) {
        // Arrays.sort(num);
        ArrayList<Integer> ls  = new ArrayList<>();
        subsetSumHelper(num, 0, num.length, 0, ls);
        Collections.sort(ls);
        return ls;


    }
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Arrays.sort(nums);
        List<Integer> output = subsetSum(nums);
        System.out.println(output);
    }
}
