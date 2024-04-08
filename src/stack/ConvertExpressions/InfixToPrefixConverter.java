package stack.ConvertExpressions;

import java.util.Stack;
import java.util.Stack;

public class InfixToPrefixConverter {

    public static String infixToPrefix(String infix) {
        // Step 1: Reverse the infix expression
        String reversedInfix = reverseString(infix);

        // Step 2: Convert the reversed infix to postfix
        String postfix = infixToPostfix(reversedInfix);

        // Step 3: Reverse the postfix to get the prefix expression
        String prefix = reverseString(postfix);

        return prefix;
    }

    private static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    private static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c : infix.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            } else if (c == ')') {
                stack.push(c);
            } else if (c == '(') {
                while (!stack.isEmpty() && stack.peek() != ')') {
                    postfix.append(stack.pop());
                }
                stack.pop(); // Discard the ')'
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public static void main(String[] args) {
        String infixExpression = "x+y*z/w+u";
        String prefixExpression = infixToPrefix(infixExpression);
        System.out.println("Prefix Expression: " + prefixExpression);
    }
}
