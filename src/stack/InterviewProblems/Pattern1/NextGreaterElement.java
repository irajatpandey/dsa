package stack.InterviewProblems.Pattern1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Stack;

public class NextGreaterElement {
    private static ArrayList<Integer> nextGreaterElement_bruteForce(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < arr.length; i++) {
            int current_max = arr[i];
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[i] < arr[j]){
                    current_max = arr[j];
                    break;
                }
            }
            if(current_max == arr[i]){
                list.add(-1);
            }
            else{
                list.add(current_max);
            }
        }
        return list;
    }

    public static ArrayList<Integer> nextGreaterElement(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = arr.length - 1; i >= 0; i--) {
            if(stack.isEmpty()){
                list.add(-1);
            }
            else if(!stack.isEmpty() && stack.peek() > arr[i]){
                list.add(stack.peek());
            }
            else if(!stack.isEmpty() && stack.peek() <= arr[i]){
                while(!stack.isEmpty() && stack.peek() <= arr[i]){
                    stack.pop();
                }

                if(stack.isEmpty()){
                    list.add(-1);
                }
                else{
                    list.add(stack.peek());
                }
            }
            stack.push(arr[i]);
        }
        Collections.reverse(list);
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {13, 7, 6, 12};

//        ArrayList<Integer> output = nextGreaterElement_bruteForce(arr);
        ArrayList<Integer> output = nextGreaterElement(arr);
        System.out.println(output);
    }


}
