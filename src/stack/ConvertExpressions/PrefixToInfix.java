package stack.ConvertExpressions;

import java.util.Stack;

public class PrefixToInfix {
    private static boolean isOperator(char ch) {
        return ((ch == '+') || (ch == '-') || (ch == '*') || (ch == '/') || (ch == '^'));
    }
    private static String prefixToInfix(String str) {
        Stack<String> st = new Stack<>();

        for(int i = str.length() - 1; i >= 0; i--){
            char c = str.charAt(i);

            if(isOperator(c)){
                String t1 = st.pop();
                String t2 = st.pop();

                String smallOutput = "(" + t1 + c + t2 +  ")";
                st.push(smallOutput);

            }
            else{
                st.push(c + "");
            }
        }

         return st.pop();
    }
    public static void main(String[] args) {
        String str = "*-A/BC-/AKL";
        System.out.println(prefixToInfix(str));
    }


}
