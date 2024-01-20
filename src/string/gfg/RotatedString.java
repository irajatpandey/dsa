package string.gfg;

import java.util.HashMap;

public class RotatedString {
    public static boolean areRotations(String s1, String s2 )
    {
        // Your code here
        HashMap<Character, Integer> mp = new HashMap<Character, Integer>();

        int n1 = s1.length();
        int n2 = s2.length();

        for(int i = 0; i < s1.length(); i++){
            mp.put(s1.charAt(i), mp.getOrDefault(mp.get(s1.charAt(i)), 0 ) + 1);
        }

        for(int i = 0; i < s2.length(); i++){
            if(mp.containsKey(s2.charAt(i))){
                mp.remove(s2.charAt(i));
            }
        }

        return mp.size() == 0;


    }
    public static void main(String[] args) {
        String s1 = "geeksforgeeks";
        String s2 = "forgeeksgeeks";

        System.out.println(areRotations(s1, s2));
    }
}
