package string.striver.medium;

import java.lang.reflect.Array;
import java.util.*;

public class FrequencySort {
    public static HashMap<Character, Integer> sortHashMapOnValue(HashMap<Character, Integer> mp){
        List<Map.Entry<Character, Integer> > list =  new LinkedList<Map.Entry<Character, Integer> >(mp.entrySet());
        //
        Comparator<Map.Entry<Character, Integer>> comp = new Comparator<Map.Entry<Character, Integer>>() {
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2){
                return (o2.getValue()).compareTo(o1.getValue());
            }
        };

        Collections.sort(list, comp);

        HashMap<Character, Integer> temp = new LinkedHashMap<Character, Integer>();

        for (Map.Entry<Character, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
    public static String frequencySort(String s) {

        HashMap<Character, Integer> mp = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            mp.put(s.charAt(i), mp.getOrDefault(s.charAt(i), 0) + 1);
        }
        HashMap<Character, Integer>outputMap = sortHashMapOnValue(mp);
        String output = "";
        for(Map.Entry<Character,Integer> pair : outputMap.entrySet()){
            int freq = pair.getValue();
            while(freq > 0){
                output += pair.getKey();
                freq--;
            }
        }
        return  output;
    }
    public static void main(String[] args) {
        String str = "tree";
        System.out.println(frequencySort(str));
    }
}
