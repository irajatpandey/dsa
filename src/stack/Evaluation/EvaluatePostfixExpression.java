package stack.Evaluation;

import java.util.Stack;

public class EvaluatePostfixExpression {
    private static boolean isOperand(char ch){
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9');
    }
    private static int evaluatePostfixExpression(String expression) {
        Stack<String> stack = new Stack<>();
        for (char ch : expression.toCharArray()) {
            if(isOperand(ch)){
                stack.push(String.valueOf(ch));
            }
            else{
                String operand1 = stack.pop();
                String operand2 = stack.pop();

                int op1 = Integer.parseInt(operand1);
                int op2 = Integer.parseInt(operand2);
                if(ch == '+')
                stack.push(String.valueOf(op2 + op1));
                else if(ch == '-'){
                    stack.push(String.valueOf(op2 - op1));
                }
                else if(ch == '*'){
                    stack.push(String.valueOf(op2 * op1));
                }
                else if(ch == '/'){
                    stack.push(String.valueOf(op2 / op1));
                }
            }
        }
        return Integer.parseInt(stack.pop());
    }
    public static void main(String[] args) {
        String expression = "231*+9-";
        int output = evaluatePostfixExpression(expression);
        System.out.println(output);
    }


}
