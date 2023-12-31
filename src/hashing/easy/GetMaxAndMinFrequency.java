package hashing.easy;

import java.util.HashMap;
import java.util.Map;
// Highest / Lowest Frequency Elements
public class GetMaxAndMinFrequency {
    public static int[] getFrequencies(int []v) {
        // Write Your Code Here
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < v.length; i++){
            if(mp.containsKey(v[i])){
                mp.put(v[i], mp.get(v[i]) + 1);
            }
            else{
                mp.put(v[i], 1);
            }
        }
        int maxFrequency = 0, minFrequency = v.length, maxElement = 0, minElement = 0;

        for(Map.Entry<Integer, Integer> pair : mp.entrySet()){
            int value = pair.getValue();
            int key = pair.getKey();

            if(value > maxFrequency){
                maxFrequency = value;
                maxElement = key;
            }
            else if(value == maxFrequency){
                if(key < maxElement){
                    maxElement = key;
                }
            }

            if(value < minFrequency){
                minFrequency = value;
                minElement = key;
            }
            else if(value == minFrequency){
                if(key < minElement){
                    minElement = key;
                }
            }
        }
        int ans[] = {maxElement, minElement};
        return ans;

    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 1, 1, 4};
        int ans[] = getFrequencies(arr);
        System.out.println(ans[0] + " " + ans[1]);
    }
}
