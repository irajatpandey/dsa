package array.windowsliding.adityaverma;

import java.util.*;

public class MaxSumSubArray {
    public static int maxSumSubArray(int arr[], int n, int k){
         // n size of the array.
        int left = 0, right = 0; // 2 pointers
        long sum = arr[0];
        int maxLen = 0;
        while (right < n) {
            // if sum > k, reduce the subarray from left
            // until sum becomes less or equal to k:

            // if sum = k, update the maxLen i.e. answer:
            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            // Move forward thw right pointer:
            right++;
            if (right < n) sum += arr[right];

            while (left <= right && sum > k) {
                sum -= arr[left];
                left++;
            }
        }

        return maxLen;
    }
    public static int maxSumSubArray2(int arr[], int n, int k){
        int sum = 0;
        int maxLen = 0;
        Map<Integer, Integer> mp = new HashMap<>();

        for(int i = 0; i < n; i++){
            sum += arr[i];

            if(sum == k){
                maxLen = Math.max(maxLen, i + 1);
            }
            int remainingSum = sum - k;
            if(mp.containsKey(remainingSum)){
                int len = i - mp.get(remainingSum);
                maxLen = Math.max(maxLen, len);
            }

            if(!mp.containsKey(remainingSum)){
                mp.put(remainingSum, i);
            }

        }
        return maxLen;
    }
    public static void main(String[] args) {
        int arr[] = {2, 3, 5, 1, 9};
        //int arr[] = {1, 2, 3, 1, 1, 1, 1};
        int n = arr.length;
        int k = 10;

        int output = maxSumSubArray(arr, n, k);
        System.out.println(output);

        int output2 = maxSumSubArray2(arr, n, k);
        System.out.println(output2);
    }
}
