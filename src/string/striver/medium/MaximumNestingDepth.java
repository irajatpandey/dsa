package string.striver.medium;

public class MaximumNestingDepth {
    public static int maxDepth(String s) {
        int count = 0;
        int max = -1;
        for(char ch : s.toCharArray()){
            if(ch == '(') count++;
            else if(ch == ')') count--;
            max = Math.max(max, count);
        }

        return max;
    }
    public static void main(String[] args) {
        String s =  "(1+(2*3)+((8)/4))+1";
        int ans = maxDepth(s);
        System.out.println(ans);
    }
}
