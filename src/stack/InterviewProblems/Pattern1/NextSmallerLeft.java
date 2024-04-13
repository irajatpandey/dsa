package stack.InterviewProblems.Pattern1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class NextSmallerLeft {
    public static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n){
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < arr.size(); i++){
            if(stack.isEmpty()){
                res.add(-1);
            }
            else if(!stack.isEmpty() && stack.peek() < arr.get(i)){
                res.add(stack.peek());
            }
            else if(!stack.isEmpty() && stack.peek() >= arr.get(i)){
                while(!stack.isEmpty() && stack.peek() >= arr.get(i)){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    res.add(-1);
                }else{
                    res.add(stack.peek());
                }
            }
            stack.push(arr.get(i));
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.addAll(Arrays.asList(1, 2, 3));
        System.out.println(nextSmallerElement(arr, 3));
    }
}
