package binarysearch.striver.BinarySearchOnAnswers;

import java.util.Arrays;
// https://www.codingninjas.com/studio/problems/aggressive-cows_1082559?
public class AggressiveCows {

    public static boolean canPlace(int []stalls, int k, int dist){
        int cows = 1;
        int last = stalls[0];

        for(int i = 1; i < stalls.length; i++){
            if(stalls[i] - last >= dist){
                cows++;
                last = stalls[i];
            }
            if(cows >= k)
                return true;
        }

        return false;
    }

    public static int aggressiveCows_linearSearch(int []stalls, int k) {

        // sort the stalls
        Arrays.sort(stalls);
        int max = stalls[stalls.length - 1], min = stalls[0];

        for(int i = 1; i <= (max - min); i++){

            if(!canPlace(stalls, k, i)){
                return i - 1;
            }
        }
        return (max - min);
    }

   // Time Complexity: O(NlogN) + O(N * log(max(stalls[])-min(stalls[]))), where N = size of the array,
   // max(stalls[]) = maximum element in stalls[] array, min(stalls[]) = minimum element in stalls[] array.
    public static int aggressiveCows(int []stalls, int k) {

        // sort the stalls
        Arrays.sort(stalls);
        int max = stalls[stalls.length - 1];
        int min = stalls[0];

        int low = 1, high = (max - min);
        while(low <= high){
            int mid = low + (high - low)/2;
            if(!canPlace(stalls, k, mid)){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return high;
    }
    public static void main(String[] args) {
        int[] stalls = {1, 2, 3};
        int k = 2;

        int output = aggressiveCows_linearSearch(stalls, k);
        int output2 = aggressiveCows(stalls, k);
        System.out.println(output);
        System.out.println(output2);
    }
}
