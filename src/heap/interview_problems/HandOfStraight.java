package heap.interview_problems;

import java.util.TreeMap;

public class HandOfStraight {
    public static boolean isNStraightHand(int[] hand, int groupSize) {
        // Edge case: If the total number of cards is not divisible by W, it's not possible
        if (hand.length % groupSize != 0) {
            return false;
        }

        // TreeMap to store the frequency of each card, sorted by card values
        TreeMap<Integer, Integer> cardCountMap = new TreeMap<>();
        for (int card : hand) {
            cardCountMap.put(card, cardCountMap.getOrDefault(card, 0) + 1);
        }

        // Iterate through the cards in the TreeMap
        while (!cardCountMap.isEmpty()) {
            // Get the smallest card value
            int firstCard = cardCountMap.firstKey();

            // Try to form a group of W consecutive cards starting from the smallest card
            for (int card = firstCard; card < firstCard + groupSize; card++) {
                if (!cardCountMap.containsKey(card)) {
                    // If any card in the required sequence is missing, return false
                    return false;
                }
                // Decrement the count of the current card
                int count = cardCountMap.get(card);
                if (count == 1) {
                    cardCountMap.remove(card);
                } else {
                    cardCountMap.put(card, count - 1);
                }
            }
        }

        // If we successfully form all groups, return true
        return true;
    }
    public static void main(String[] args) {
        int[] hand = {1, 2, 3, 6, 2, 3, 4, 7, 8};
        int groupSize = 3;
        System.out.println(isNStraightHand(hand, groupSize)); // Output: true
    }
}
