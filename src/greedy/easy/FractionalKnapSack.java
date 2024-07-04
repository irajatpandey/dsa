package greedy.easy;
import java.util.Arrays;
import java.util.Comparator;
//https://www.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1
// Class representing an item with a value and weight
class Item {
    int value, weight;

    // Constructor to initialize the item
    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

public class FractionalKnapSack {

    // Comparator to sort items based on their value-to-weight ratio
    static class ItemComparator implements Comparator<Item> {
        @Override
        public int compare(Item a, Item b) {
            double ratio1 = (double) a.value / a.weight;
            double ratio2 = (double) b.value / b.weight;
            // Sort in descending order of value-to-weight ratio
            return Double.compare(ratio2, ratio1);
        }
    }

    /**
     * Finds the maximum value that can be obtained from the given items
     * for the fractional knapsack problem.
     *
     * @param w   The maximum capacity of the knapsack.
     * @param arr Array of items where each item has a value and weight.
     * @param n   The number of items.
     * @return The maximum value that can be obtained with the given capacity.
     *
     * Time Complexity: O(n log n) - Sorting the items based on their value-to-weight ratio.
     * Space Complexity: O(1) - Constant space used for the solution.
     */
    public static double fractionalKnapsack(int w, Item[] arr, int n) {
        // Sort the items by value-to-weight ratio in descending order
        Arrays.sort(arr, new ItemComparator());

        double currentValue = 0.0; // Total value in the knapsack
        double currentWeight = 0.0; // Total weight in the knapsack

        // Iterate over the sorted items and add to the knapsack
        for (Item item : arr) {
            if (currentWeight + item.weight <= w) {
                // If the item can be fully added without exceeding capacity
                currentWeight += item.weight;
                currentValue += item.value;
            } else {
                // Add the fractional part of the item to fit the remaining capacity
                int remainingWeight = w - (int) currentWeight;
                currentValue += item.value * ((double) remainingWeight / item.weight);
                break; // Knapsack is full
            }
        }

        return currentValue; // Return the maximum value obtained
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] values1 = {60, 100, 120};
        int[] weights1 = {10, 20, 30};
        int capacity1 = 50;
        Item[] items1 = new Item[values1.length];
        for (int i = 0; i < values1.length; i++) {
            items1[i] = new Item(values1[i], weights1[i]);
        }
        double output1 = fractionalKnapsack(capacity1, items1, items1.length);
        System.out.println("Test Case 1 - Expected Output: 240.0");
        System.out.println("Actual Output: " + output1);

        // Test Case 2
        int[] values2 = {50, 70, 30};
        int[] weights2 = {5, 10, 15};
        int capacity2 = 20;
        Item[] items2 = new Item[values2.length];
        for (int i = 0; i < values2.length; i++) {
            items2[i] = new Item(values2[i], weights2[i]);
        }
        double output2 = fractionalKnapsack(capacity2, items2, items2.length);
        System.out.println("Test Case 2 - Expected Output: 180.0");
        System.out.println("Actual Output: " + output2);

        // Test Case 3
        int[] values3 = {10, 20, 30};
        int[] weights3 = {1, 1, 1};
        int capacity3 = 2;
        Item[] items3 = new Item[values3.length];
        for (int i = 0; i < values3.length; i++) {
            items3[i] = new Item(values3[i], weights3[i]);
        }
        double output3 = fractionalKnapsack(capacity3, items3, items3.length);
        System.out.println("Test Case 3 - Expected Output: 50.0");
        System.out.println("Actual Output: " + output3);
    }
}

