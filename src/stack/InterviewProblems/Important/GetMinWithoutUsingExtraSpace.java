package stack.InterviewProblems.Important;

import java.util.Stack;
//https://leetcode.com/problems/min-stack/
public class GetMinWithoutUsingExtraSpace {

    static class MinStack {

        Stack<Integer> stack;
        int minElement;

        // Constructor
        MinStack() {
            stack = new Stack<>();
            minElement = Integer.MAX_VALUE;
        }

        // Function to add another element equal to num at the top of stack.
        void push(int num) {
            if(stack.isEmpty()){
                stack.push(num);
                minElement = num;
            }
            else if(minElement > num){
                stack.push(2*num - 1);
                minElement = num;

            }
            else if(minElement >= num){
                stack.push(2*num - minElement);
            }
        }

        // Function to remove the top element of the stack.
        int pop() {
            if(stack.isEmpty()){
                return -1;
            }
            else {
                if(stack.peek() >= minElement){
                    return stack.pop();
                }
                else if (stack.peek() < minElement) {
                    minElement = 2*minElement - stack.peek();
                    return stack.pop();
                }
            }

            return -1;
        }

        // Function to return the top element of stack if it is present. Otherwise
        // return -1.
        int top() {
            if(stack.isEmpty()){ return - 1;}
            return stack.peek();
        }

        // Function to return minimum element of stack if it is present. Otherwise
        // return -1.
        int getMin() {
            if(stack.isEmpty()) return -1;

            return minElement;
        }
    }
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(18);
        minStack.push(19);
        minStack.push(15);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());


    }
}
