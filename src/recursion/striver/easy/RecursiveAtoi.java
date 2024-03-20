package recursion.striver.easy;

public class RecursiveAtoi {

    public static int atoi(String str) {
        return parseInteger(str.toCharArray(), 0);
    }

    private static int parseInteger(char[] chars, int index) {
        // Skip leading whitespace (non-recursively)
        while (index < chars.length && chars[index] == ' ') {
            index++;
        }

        // Handle sign
        int sign = 1;
        if (index < chars.length && (chars[index] == '+' || chars[index] == '-')) {
            sign = (chars[index] == '+') ? 1 : -1;
            index++;
        }

        // Extract digits recursively
        if (index >= chars.length) { // Check only for end of string
            return 0;
        } else if (!isDigit(chars[index])) {
            return 0; // Base case: non-digit encountered
        }

        int digitValue = chars[index] - '0';
        int result = parseInteger(chars, index + 1) + digitValue * sign * 10; // Apply sign before multiplication

        // Check for overflow/underflow before returning
        if ((result > Integer.MAX_VALUE / 10 ||
                (result == Integer.MAX_VALUE / 10 && digitValue > Integer.MAX_VALUE % 10)) && sign > 0) {
            return Integer.MAX_VALUE;
        } else if ((result < Integer.MIN_VALUE / 10 ||
                (result == Integer.MIN_VALUE / 10 && digitValue < Integer.MIN_VALUE % 10)) && sign < 0) {
            return Integer.MIN_VALUE;
        }

        return result;
    }

    // Custom digit-checking function (avoiding Character.isDigit())
    private static boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }
    public static void main(String[] args) {
        String str = "      -546+er";
        System.out.println(atoi(str));
    }
}
