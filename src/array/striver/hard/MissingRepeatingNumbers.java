package array.striver.hard;

import java.util.HashMap;
import java.util.Map;

public class MissingRepeatingNumbers {
    public static int[] findMissingRepeatingNumbers_optimal(int []a) {
        int n = a.length; // Size of array 'a'

        long naturalSum = 1l * n * (n + 1) / 2l;
        long squareSum = 1l * n * (n + 1) * (2 * n + 1) / 6l;
        long repeating = 0l;
        long missing = 0l;

        for(int i = 0; i < n; ++i) {
            // Subtracting current element
            // from naturalSum
            naturalSum -= a[i];

            // Subtracting current element square
            // from squareSum
            squareSum -= 1l * a[i] * a[i];
        }
        missing = (naturalSum + (squareSum / naturalSum)) / 2;
        repeating = (missing - naturalSum);

        int []ans = new int[2];
        ans[0] = (int)repeating;
        ans[1] = (int)missing;
        return ans;
    }
    public static int[] findMissingRepeatingNumbers(int[] a) {
        int[] result = new int[2];
        int n = a.length;
        int[] hash = new int[n + 1];

        for(int i = 0; i < n; i++){
            hash[a[i]]++;
        }

        for(int i = 1; i <= n; i++){
            if(hash[i] == 2){
                result[0] = i;
            }
            else if(hash[i] == 0){
                result[1] = i;
            }
        }
        return result;

    }
    public static void main(String[] args) {
        int[] a = {3, 1, 2, 5, 3};

        int[] output = findMissingRepeatingNumbers(a);
        System.out.println(output[0] + " " + output[1]);

        int[] output2 = findMissingRepeatingNumbers_optimal(a);
        System.out.println(output2[0] + " " + output[1]);

    }
}
