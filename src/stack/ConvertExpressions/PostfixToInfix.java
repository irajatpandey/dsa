package stack.ConvertExpressions;

import java.util.Stack;

public class PostfixToInfix {
    private static boolean isOperand(char ch){
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9');
    }
    public static String postfixToInfix(String exp){
        Stack<String> stack = new Stack<>();
        for(char ch : exp.toCharArray()){
            if(isOperand(ch)){
                stack.push(ch + "");
            }
            else{
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                String smallOutput = '(' + operand2 + ch + operand1 + ')';
                stack.push(smallOutput);
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        String exp = "ab*c+";
        System.out.println(postfixToInfix(exp));

    }
}
