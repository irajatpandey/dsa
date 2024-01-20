package string.striver.easy;

import java.util.HashMap;

public class IsomorphicString {
    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> mp = new HashMap<>();

        if(s.length() != t.length()) return false;

        for(int i = 0; i < s.length(); i++){
            if(mp.containsKey(s.charAt(i))){
                if(t.charAt(i) != mp.get(s.charAt(i))){
                    return false;
                }
            }
            else{
                if(mp.containsValue(t.charAt(i))){
                    return false;
                }
                mp.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "paper";
        String s2 = "title";

        System.out.println(isIsomorphic(s1, s2));
    }
}
