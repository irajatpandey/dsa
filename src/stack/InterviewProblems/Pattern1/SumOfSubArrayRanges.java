package stack.InterviewProblems.Pattern1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
//https://leetcode.com/problems/sum-of-subarray-ranges/
public class SumOfSubArrayRanges {
    public static int[] nextGreaterToLeft(int[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            if(stack.isEmpty()){
                res[k++] = -1;
            }
            else if (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                res[k++] = stack.peek();
            }
            else if(!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                    stack.pop();
                }
                if(stack.isEmpty()){
                    res[k++] = -1;
                }
                else{
                    res[k++] = stack.peek();
                }
            }
            stack.push(i);
        }
        return res;
    }
    public static int[] nextGreaterRight(int[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if(stack.isEmpty()){
                res[i] = n;
            }
            else if (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                res[i] = stack.peek();
            }
            else if(!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                    stack.pop();
                }
                if(stack.isEmpty()){
                    res[i] = n;
                }
                else{
                    res[i] = stack.peek();
                }
            }
            stack.push(i);
        }
        return res;
    }
    private static long calculateSubarrayValues(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = nums.length;
        int[] left = nextGreaterToLeft(nums, n);
        int[] right = nextGreaterRight(nums, n);


        long sum = 0; // Initialize the sum to aggregate the subarray values
        // Calculate the sum of values using the left and right bounds
        for (int i = 0; i < n; ++i) {
            sum += (long) (i - left[i]) * (right[i] - i) * nums[i];
        }

        // Return the total sum of subarray values for either max or min based on the nums state
        return sum;
    }
    public static long subArrayRanges(int[] nums) {
        // Calculate the sum of max elements in all subarrays
        long sumOfMax = calculateSubarrayValues(nums);

        // Invert all numbers in nums to find the sum of min elements using the same function
        for (int i = 0; i < nums.length; ++i) {
            nums[i] *= -1;
        }
        long sumOfMin = calculateSubarrayValues(nums);

        // The total sum of subarray ranges is the sum of max elements plus the (inverted) sum of min elements
        return sumOfMax + sumOfMin;
    }

    public static void main(String[] args) {
        int []nums = {1, 2, 3};
        long output = subArrayRanges(nums);
        System.out.println(output);
    }
}
