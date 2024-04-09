package stack.InterviewProblems.Pattern1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SmallestNumberOnLeft {

    public static List<Integer> leftSmaller(int n, int arr[]) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < n; i++) {
            if(stack.isEmpty()){
                list.add(-1);
            }
            else if(!stack.isEmpty() && stack.peek() < arr[i]) {
                list.add(stack.peek());
            }
            else if(!stack.isEmpty() &&  stack.peek() >= arr[i] ){
                while(!stack.isEmpty() && stack.peek() >= arr[i]){
                    stack.pop();
                }

                if(stack.isEmpty()){
                    list.add(-1);
                }else {
                    list.add(stack.peek());
                }
            }
            stack.push(arr[i]);
        }
        return list;
    }
    public static void main(String[] args) {
        int[] arr = {1, 5, 0, 3, 4, 5};
        List<Integer> output = leftSmaller(arr.length, arr);
        System.out.println(output);
    }
}
