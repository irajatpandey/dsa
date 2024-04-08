package stack.ConvertExpressions;

import java.util.Stack;

public class PostfixToPrefix {
    private static boolean isOperand(char ch){
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9');
    }
    private static String postfixToPrefix(String expression) {
        Stack<String> stack = new Stack<String>();
        String output = "";

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (isOperand(ch)){
                stack.push(ch + "");
            }
            else{
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                String smallOutput = ch + operand1 + operand2;
                stack.push(smallOutput);
            }
        }
        return stack.peek();
    }
    public static void main(String[] args) {
        String output = postfixToPrefix("ABC/-AK/L-*");
        System.out.println(output);
    }


}
