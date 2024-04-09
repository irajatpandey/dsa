package stack.ConvertExpressions;

import java.util.Stack;

public class InfixToPostfix {
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
    private static String convertInfixToPostfix(String str) {
        Stack<Character> st = new Stack<>();
        String output = "";
        for(char ch : str.toCharArray()){
            if(isOperand(ch)){
                output = output + ch;
            }
            else if(ch == '('){
                st.push(ch);
            }
            else if(ch == ')'){
                while(!st.isEmpty() && st.peek() != '('){
                    output += st.pop();
                }
                st.pop();
            }
            else {
                while (!st.isEmpty() && getPrecedence(ch) <= getPrecedence(st.peek())) {
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
//        String str = "A*B-(C+D)+E";
        String str = "a+b*(c^d-e)^(f+g*h)-i";
        String output = convertInfixToPostfix(str);
        System.out.println(output);
    }


}
