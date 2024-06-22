package slidingwindow.striver.medium;

import java.util.HashMap;

public class FindMaxFruits {
    // The time complexity of the solution is O(n), where n is the number of elements in the input array arr.
    // Space Complexity : O(1)
    //https://www.naukri.com/code360/problems/fruits-and-baskets_985356?
    public static int findMaxFruits(int []arr, int n) {
        HashMap<Integer, Integer> fruitCount = new HashMap<>();

        // Initialize variables
        int maxFruits = 0;  // Maximum number of fruits in both baskets
        int start = 0;      // Start of the window

        // Iterate over the array
        for (int end = 0; end < arr.length; end++) {
            int fruit = arr[end];
            fruitCount.put(fruit, fruitCount.getOrDefault(fruit, 0) + 1);

            // Shrink the window if there are more than two types of fruits
            while (fruitCount.size() > 2) {
                int startFruit = arr[start];
                fruitCount.put(startFruit, fruitCount.get(startFruit) - 1);
                if (fruitCount.get(startFruit) == 0) {
                    fruitCount.remove(startFruit);
                }
                start++;
            }

            // Update maxFruits if needed
            maxFruits = Math.max(maxFruits, end - start + 1);
        }

        return maxFruits;
    }
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3};
        System.out.println(findMaxFruits(arr, arr.length));
    }
}
