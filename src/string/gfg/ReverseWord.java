package string.gfg;

public class ReverseWord {
    public static String reverseWord(String s) {
        String ans = "";
        int i = s.length() - 1;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == ' ') i--;
            int j = i;
            if (i < 0) break;

            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            if (ans.equals("")) {
                ans = ans.concat(s.substring(i + 1, j + 1));
            } else {
                ans = ans.concat(" " + s.substring(i + 1, j + 1));

            }
        }
        return ans;

    }
    public static void main(String[] args) {
        String str = "The Sky is Blue";
        String output = reverseWord(str);
        System.out.println(output);
    }
}
