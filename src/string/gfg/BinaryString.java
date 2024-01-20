package string.gfg;

public class BinaryString {
    // Idea is nC2
    public static int binarySubstring(String str) {
        // Your code here
        int cnt = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '1'){
                cnt++;
            }
        }

        int ans = ((cnt)*(cnt - 1))/2;

        return ans;
    }
    public static void main(String[] args) {
        String str = "1111";
        int ans = binarySubstring(str);
        System.out.println(ans);
    }
}
