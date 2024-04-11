package stack.InterviewProblems.Pattern1;

import java.util.*;
import java.util.stream.Collectors;

//https://leetcode.com/problems/sum-of-subarray-minimums/
//Time complexity: O(n)
// Space Complexity : O(n) // stack
public class SumOfSubarrayMinimums {
    public static ArrayList<Integer> nextSmallerRight(ArrayList<Integer> arr, int n){
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = n - 1; i >= 0; i--){
            if(stack.isEmpty()){
                res.add(n);
            }
            else if(!stack.isEmpty() && stack.peek() < arr.get(i)){
                res.add(stack.peek());
            }
            else if(!stack.isEmpty() && stack.peek() >= arr.get(i)){
                while(!stack.isEmpty() && stack.peek() >= arr.get(i)){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    res.add(n);
                }else{
                    res.add(stack.peek());
                }
            }
            stack.push(arr.get(i));
        }
        Collections.reverse(res);
        return res;
    }
    public static int sumSubarrayMins(int[] arr) {
        int length = arr.length;
        ArrayList<Integer> ls =  Arrays.stream(arr).boxed().collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Integer> left = NextSmallerLeft.nextSmallerElement(ls, ls.size());
        ArrayList<Integer> right = nextSmallerRight(ls, ls.size());



        // The mod value for big integer operations to prevent overflow
        int mod = (int) 1e9 + 7;
        // The result variable to keep track of the sum of subarray minimums
        long answer = 0;

        // Calculate the contribution of each element as a minimum in its possible subarrays
        for (int i = 0; i < length; ++i) {
            // Total count of subarrays where arr[i] is min is (i - left[i]) * (right[i] - i)
            // Multiply the count by the value itself and apply modulo operation
            answer += (long) (i - left.get(i)) * (right.get(i) - i) % mod * arr[i] % mod;
            // Ensure the running sum doesn't overflow
            answer %= mod;
        }

        for(int ele : right) {
            System.out.print(ele + " ");
        }
        System.out.println();

        // Cast the long result to int before returning as per method return type
        return (int) answer;

    }
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        int output = sumSubarrayMins(arr);
        System.out.println(output);

    }
}
