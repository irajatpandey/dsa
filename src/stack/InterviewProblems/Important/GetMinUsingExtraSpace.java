package stack.InterviewProblems.Important;
import java.util.Stack;

public class GetMinUsingExtraSpace {

    static class MinStack {

        Stack<Integer> stack;
        Stack<Integer> minStack;

        // Constructor
        MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        // Function to add another element equal to num at the top of stack.
        void push(int num) {
            stack.push(num);
            if (minStack.isEmpty() || num <= minStack.peek()) {
                minStack.push(num);
            }
        }

        // Function to remove the top element of the stack.
        int pop() {
            if (stack.isEmpty()) {
                return -1;
            }
            int top = stack.pop();
            if (top == minStack.peek()) {
                minStack.pop();
            }
            return top;
        }

        // Function to return the top element of stack if it is present. Otherwise
        // return -1.
        int top() {
            return stack.isEmpty() ? -1 : stack.peek();
        }

        // Function to return minimum element of stack if it is present. Otherwise
        // return -1.
        int getMin() {
            return minStack.isEmpty() ? -1 : minStack.peek();
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        System.out.print(minStack.getMin() + " ");
        System.out.print(minStack.pop() + " ");
        System.out.print(minStack.top());
    }
}
