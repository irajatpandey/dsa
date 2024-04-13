package queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        int rightIndex = 0;

        for(int i = 0; i < nums.length; i++) {
            if(!dq.isEmpty() && dq.peekFirst() == i - k) {
                System.out.println("kk");
                dq.poll();
            }

            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }
            dq.offer(i);
            if(i >= k - 1){
                result[rightIndex++] = nums[dq.peek()];
                for(int ele : result){
                    System.out.print("Result " + ele + " ");
                }
                System.out.println();
            }

            for(int ele : dq){
                System.out.print("Deque " + ele + " ");
            }
            System.out.println();
        }
        return result;
    }
    //This will give you TLE
    public static int[] maxSlidingWindowBruteForce(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];

        for(int i = 0, j = k - 1; i < nums.length - k + 1 && j < nums.length; i++, j++){
            int start = i, end = j;
            //System.out.println(i + " " + j);
            int max = Integer.MIN_VALUE;
            while(start <= end){
                max = Math.max(nums[start++], max);

            }
            result[i] = max;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);
        for(int i = 0; i < result.length; i++){
            System.out.print(result[i] + " ");
        }
    }
}
