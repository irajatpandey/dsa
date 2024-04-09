package stack.InterviewProblems.Pattern1;

import java.util.*;
//https://leetcode.com/problems/next-greater-element-ii/description/

// T.C : O(n)
// S.C: O(n)
public class NextGreaterElement2 {
    public static int[] nextGreaterElement2(int []arr) {
        int n = arr.length;
        int[] list = new int[2*n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 2 * n - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                list[i % n] = -1;
            } else if (!stack.isEmpty() && stack.peek() > arr[i % n]) {
                list[i % n] = stack.peek();
            } else if (!stack.isEmpty() && stack.peek() <= arr[i % n]) {
                while (!stack.isEmpty() && stack.peek() <= arr[i % n]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    list[i % n] = -1;
                } else {
                    list[i % n] = stack.peek();
                }
            }
            stack.push(arr[i % n]);
        }

        int[] ans = new int[n];
        for (int i = 0; i < n ; i++) {
            ans[i] = list[i];
        }
        return ans;
    }
    public static void main(String[] args) {

        int[] arr = {6, 10, 7, 4, 8, 9, 4};
        int[] output = nextGreaterElement2(arr);
        for(int i = 0; i < output.length; i++){
            System.out.println(arr[i] + " -> " + output[i]);
        }


    }
}
