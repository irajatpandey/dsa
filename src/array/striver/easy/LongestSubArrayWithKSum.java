package array.striver.easy;

import java.util.HashMap;

public class LongestSubArrayWithKSum {
    public static int longestSubArrayWithKSum(int[] arr, int k){
        int maxLen = 0, sum = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1); // <PrefixSum, Index>
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            int remaining = sum - k;
            if(mp.containsKey(remaining) == true){
                int currentLength = i - mp.get(remaining);
                maxLen = Math.max(currentLength, maxLen);
            }
            if(mp.containsKey(sum) == false){
                mp.put(sum, i);
            }
        }


        return  maxLen;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -3, 1, 1, 1, 4, 2, -3};
        int k = 3;

        int output = longestSubArrayWithKSum(arr, k);
        System.out.println(output);
    }
}
