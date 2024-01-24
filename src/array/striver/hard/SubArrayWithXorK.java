package array.striver.hard;

import java.util.HashMap;

public class SubArrayWithXorK {
    // TC O(n^2)
    public static int subArrayWithXorK_bruteForce(int arr[], int k){
        int n = arr.length;
        int count = 0;
        for(int i = 0; i < n; i++){
            int xorr = 0;
            for(int j = i; j < n; j++){
                xorr ^= arr[j];
                if(xorr == k){
                    count++;
                }
            }

        }

        return  count;
    }
    public static int subArrayWithXorK_optimal(int arr[], int k){
        int n = arr.length;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int xr = 0;
        for(int i = 0; i < n; i++){
            xr ^= arr[i];
            int x = xr ^ k;

            if(map.containsKey(x)){
                count += map.get(x);
            }
            map.put(xr, map.getOrDefault(xr, 0) + 1);
        }

        return  count;
    }
    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 6, 4};
        int k = 6;
        int output1 = subArrayWithXorK_bruteForce(arr, k);
        System.out.println(output1);

        int output2 = subArrayWithXorK_optimal(arr, k);
        System.out.println(output2);

    }
}
