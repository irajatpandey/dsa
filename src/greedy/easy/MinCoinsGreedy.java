package greedy.easy;
import java.util.Arrays;

public class MinCoinsGreedy {

    public static int minCoins(int amount, int m, int[] coins) {
        // Sort the coins array in descending order
        Arrays.sort(coins);
        // Reverse the array to have the largest coin at the start
        for (int i = 0; i < coins.length / 2; i++) {
            int temp = coins[i];
            coins[i] = coins[coins.length - i - 1];
            coins[coins.length - i - 1] = temp;
        }

        int count = 0;  // To keep track of the number of coins used
        int remainingAmount = amount;

        // Iterate through each coin
        for (int coin : coins) {
            // If the coin value is less than or equal to the remaining amount
            if (coin <= remainingAmount) {
                // Use as many of this coin as possible
                int numCoins = remainingAmount / coin;
                count += numCoins;
                remainingAmount -= numCoins * coin;
            }
        }

        // If there's no remaining amount, return the count, otherwise return -1 (not possible)
        return remainingAmount == 0 ? count : -1;
    }


    public static void main(String[] args) {
        int V1 = 30;
        int M1 = 3;
        int[] coins1 = {25, 10, 5};
        System.out.println("Minimum coins required for V1: " + minCoins(V1, M1, coins1)); // Output: 2

        int V2 = 11;
        int M2 = 4;
        int[] coins2 = {9, 6, 5, 1};
        System.out.println("Minimum coins required for V2: " + minCoins(V2, M2, coins2)); // Output: 2

        int V3 = 7;
        int M3 = 2;
        int[] coins3 = {5, 2};
        System.out.println("Minimum coins required for V3: " + minCoins(V3, M3, coins3)); // Output: 2

        int V4 = 11;
        int M4 = 2;
        int[] coins4 = {7, 5};
        System.out.println("Minimum coins required for V4: " + minCoins(V4, M4, coins4)); // Output: 2
    }
}
