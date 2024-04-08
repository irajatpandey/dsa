package stack.ConvertExpressions;

import java.util.Stack;
//Step 1: Reverse the infix expression. Note while reversing each ‘(‘ will become ‘)’ and each ‘)’ becomes ‘(‘.
//Step 2: Convert the reversed infix expression to “nearly” postfix expression.
//While converting to postfix expression, instead of using pop operation to pop operators with greater than or equal precedence, here we will only pop the operators from stack that have greater precedence.
//Step 3: Reverse the postfix expression.
public class InfixToPrefix {
    private static int getPrecedence(char c){
        if(c == '^'){
            return 3;
        }
        else if(c == '*' || c == '/'){
            return 2;
        }
        else if(c == '+' || c == '-'){
            return 1;
        }
        else{
            return 0;
        }
    }
    private static boolean isOperand(char ch){
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9');
    }
    private static String reverse(String expression){
        StringBuilder sb = new StringBuilder(expression);
        return sb.reverse().toString();
    }
    private static String convertInfixToPostfix(String str) {
        Stack<Character> st = new Stack<>();
        String output = "";
        str = reverse(str);
        String expression = '(' + str + ')';
        for(char ch : expression.toCharArray()){
            if(isOperand(ch)){
                output = output + ch;
            }
            else if(ch == '('){
                st.push(ch);
            }
            else if(ch == ')'){
                while(st.peek() != '('){
                    output += st.pop();
                }
                st.pop();
            }
            else {
                if (!st.isEmpty() && getPrecedence(ch) <= getPrecedence(st.peek())) {
                    output += st.pop();
                }
                st.push(ch);
            }
        }

        while(!st.isEmpty()){
            output += st.pop();
        }

        return  output;
    }

    public static void main(String[] args) {
        String str = "x+y*z/w+u";

        String output = convertInfixToPostfix(str);
        StringBuilder prefix = new StringBuilder(output);
        prefix.reverse();
        System.out.println(prefix);
        // ++x/*yzwu
    }

}
