package recursion.striver.StrongHold;

public class RecursiveAtoi {

    public static int atoi(String str) {
        // Skip leading whitespace (non-recursively)
        int i = 0, sign = 1;
        while(i < str.length() && str.charAt(i) == ' ') i++;

        // Handle sign
        if(i < str.length() && str.charAt(i) == '+') {
            sign = 1;
            i++;
        }
        if(i < str.length() && str.charAt(i) == '-'){
            sign = -1;
            i++;
        }


        return parseInteger(str.toCharArray(), i, sign, 0);
    }

    private static int parseInteger(char[] chars, int index, int sign, int res) {
        //System.out.println(chars[index]);
        if (isDigit(chars[index])) {
            // Extract digits recursively
            if (index >= chars.length) { // Check only for end of string
                return sign * res;
            }

            int digitValue = chars[index] - '0';

            res = parseInteger(chars, index + 1, sign, res * 10 + digitValue);
             //Check for overflow/underflow before returning
            if ((res > Integer.MAX_VALUE / 10 ||
                    (res == Integer.MAX_VALUE / 10 && digitValue > Integer.MAX_VALUE % 10)) && sign > 0) {
                return Integer.MAX_VALUE;
            } else if ((res < Integer.MIN_VALUE / 10 ||
                    (res == Integer.MIN_VALUE / 10 && digitValue < Integer.MIN_VALUE % 10)) && sign < 0) {
                return Integer.MIN_VALUE;
            }

            return res;
        }
        return res;
    }

    // Custom digit-checking function (avoiding Character.isDigit())
    public static boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }
    public static void main(String[] args) {
        String str = "      -546+er";
        System.out.println(atoi(str));
    }
}
