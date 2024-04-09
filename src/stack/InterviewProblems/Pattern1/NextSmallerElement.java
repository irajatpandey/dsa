package stack.InterviewProblems.Pattern1;

import java.util.*;

public class NextSmallerElement {
    public static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n){
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = n - 1; i >= 0; i--){
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
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(1);
        arr.add(4);
        arr.add(3);

        ArrayList<Integer> output = nextSmallerElement(arr, arr.size());
        System.out.println(output);

    }
}
