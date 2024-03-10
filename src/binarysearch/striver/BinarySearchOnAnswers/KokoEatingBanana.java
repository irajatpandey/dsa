package binarysearch.striver.BinarySearchOnAnswers;

//https://leetcode.com/problems/koko-eating-bananas/description/
public class KokoEatingBanana {
    public static int minEatingSpeed(int[] piles, int h) {
        long start = 0, end = 0, n = piles.length;
        long ans = 0;
        long total_bananas = 0;

        for(int banana : piles){
            total_bananas += banana;
            end = Math.max(end, banana);
        }

        start = total_bananas / h;
        // To cover the edge case if mid becomes 0, will throw arthimetic exception.
        // end will never become because it is in the range of 1 <= piles[i] <= 109
        if(start == 0){
            start = 1;
        }
        while(start <= end){
            long mid = start + (end - start)/2;
            long total_time = 0;
            for(int i = 0; i < n; i++){
                total_time += piles[i]/mid;
                if(piles[i] % mid != 0){
                    total_time++;
                }
            }
            if(total_time > h){
                start = mid + 1;
            }
            else{
                ans = mid;
                end = mid - 1;
            }
        }
        return (int)ans;
    }
    public static void main(String[] args) {
        int[]  piles = {3, 6, 7, 11};
        int h = 8;
        int output = minEatingSpeed(piles, h);
        System.out.println(output);

    }
}
