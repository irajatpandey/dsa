package stack.ConvertExpressions;

import java.util.Stack;

public class PrefixToPostfix {
    private static boolean isOperand(char ch){
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9');
    }

    private static String prefixToPostfix(String expression){
        Stack<String> stack = new Stack<>();
        for(int i = expression.length()-1; i >= 0; i--){
            char ch = expression.charAt(i);
            if(isOperand(ch)){
                stack.push(String.valueOf(ch));
            }
            else{
                String op1 = stack.pop();
                String op2 = stack.pop();
                String smallOutput = op1 + op2 + ch;
                stack.push(smallOutput);
            }
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        System.out.println(prefixToPostfix("*-A/BC-/AKL"));
    }
}
