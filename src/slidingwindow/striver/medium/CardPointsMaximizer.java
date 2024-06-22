package slidingwindow.striver.medium;
//https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/description/
public class CardPointsMaximizer {

    //This brute force solution has a time complexity of O(n * k)
    public static int maxScoreBruteForce(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int maxScore = Integer.MIN_VALUE;

        // Iterate through all possible combinations of k cards from the beginning and end
        for (int left = 0; left <= k; left++) {
            int right = k - left;
            int currentScore = 0;

            // Calculate the score by selecting cards from the beginning
            for (int i = 0; i < left; i++) {
                currentScore += cardPoints[i];
            }

            // Calculate the score by selecting cards from the end
            for (int i = n - 1; i >= n - right; i--) {
                currentScore += cardPoints[i];
            }

            // Update the maximum score if the current score is greater
            maxScore = Math.max(maxScore, currentScore);
        }

        return maxScore;
    }

    // Time Complextiy : O(2*K)
    // Space Complexity : O(1)
    public static int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int leftSum = 0, ans = 0, rightSum = 0;

        // Calculate the initial sum of the first 'k' cards from the left
        for (int i = 0; i < k; i++)
            leftSum += cardPoints[i];

        ans = leftSum; // Initialize 'ans' with the sum of the first 'k' cards

        // Slide the window to the right, updating the left and right sums
        for (int i = 0; i < k; i++) {
            leftSum -= cardPoints[k - i - 1];
            rightSum += cardPoints[n - i - 1];
            ans = Math.max(ans, leftSum + rightSum);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] cardPoints = new int[]{1, 2, 3, 4, 5, 6, 1};
        int k = 3;
        int output = maxScore(cardPoints, k);
        System.out.println(output);
    }
}
