package string.striver.medium;

public class StringToInteger {
    public static int myAtoi(String s) {
        int i = 0;
        int sign = 1;
        long output = 0;
        while(i < s.length() && s.charAt(i) == ' ') i++;

        if(i < s.length() && s.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        else if(i < s.length() && s.charAt(i) == '+') i++;

        while(i < s.length()) {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                output = output * 10 + (s.charAt(i) - '0');
                if(output > Integer.MAX_VALUE && sign == -1)
                    return Integer.MIN_VALUE;
                else if(output > Integer.MAX_VALUE && sign == 1)
                    return Integer.MAX_VALUE;
                i++;
            }
            else
                return (int)output * sign;
        }
        return (int)(output * sign);
    }
    public static void main(String[] args) {
        String str = "4193 with words";
        int output = myAtoi(str);
        System.out.println(output);
    }
}
