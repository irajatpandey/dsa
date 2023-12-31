package hashing.easy;

import java.util.HashMap;

public class CountArrayFrequency {
    public static int[] countFrequency(int n, int x, int []nums){
        // Write your code here.
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans[] = new int[n];
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i]) == true) {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            else {
                //System.out.println("else");
                map.put(nums[i], 1);
            }
        }
        for(int i = 1; i <= n; i++){
            ans[i - 1] = map.getOrDefault(i, 0);
        }

        return ans;

    }
    public static void main(String[] args) {
        int nums[] = {11, 14, 8, 3, 12, 14, 1, 7, 4, 3} ;
        int n = nums.length;
        int x = 14;
        int ans[] = countFrequency(n, x, nums);
        for(int i = 0; i < ans.length; i++){
            System.out.println(i + 1 + " " + ans[i]);
        }

    }
}
