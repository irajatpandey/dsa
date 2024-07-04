package greedy.easy;

import java.util.Arrays;
import java.util.Comparator;

//https://leetcode.com/problems/maximum-units-on-a-truck/description/
public class MaximumUnitsOnTruck {

    /**
     * Method to calculate the maximum units that can be loaded onto the truck.
     *
     * @param boxTypes Array of box types where each type is represented as [numberOfBoxes, numberOfUnitsPerBox].
     * @param truckSize The maximum number of boxes that the truck can carry.
     * @return The maximum number of units that can be loaded onto the truck.
     */
    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        // Sort the box types by number of units per box in descending order.
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return b[1] - a[1]; // Compare based on number of units per box
            }
        });

        int maxUnits = 0;

        // Iterate through the sorted box types.
        for (int[] boxType : boxTypes) {
            int numberOfBoxes = boxType[0];
            int unitsPerBox = boxType[1];

            // Calculate the number of boxes we can take.
            int boxesToTake = Math.min(truckSize, numberOfBoxes);

            // Add the units from these boxes to the total units.
            maxUnits += boxesToTake * unitsPerBox;

            // Decrease the truck size by the number of boxes taken.
            truckSize -= boxesToTake;

            // If the truck is full, break out of the loop.
            if (truckSize == 0) {
                break;
            }
        }

        return maxUnits;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[][] boxTypes1 = {{1, 3}, {2, 2}, {3, 1}};
        int truckSize1 = 4;
        int output1 = maximumUnits(boxTypes1, truckSize1);
        System.out.println("Test Case 1 - Expected Output: 8");
        System.out.println("Actual Output: " + output1);

        // Test Case 2
        int[][] boxTypes2 = {{5, 10}, {2, 5}, {4, 7}, {3, 9}};
        int truckSize2 = 10;
        int output2 = maximumUnits(boxTypes2, truckSize2);
        System.out.println("Test Case 2 - Expected Output: 91");
        System.out.println("Actual Output: " + output2);

        // Test Case 3
        int[][] boxTypes3 = {{10, 5}, {5, 8}, {2, 3}, {4, 7}};
        int truckSize3 = 12;
        int output3 = maximumUnits(boxTypes3, truckSize3);
        System.out.println("Test Case 3 - Expected Output: 84");
        System.out.println("Actual Output: " + output3);
    }
}

