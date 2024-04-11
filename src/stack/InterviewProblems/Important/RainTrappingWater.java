package stack.InterviewProblems.Important;

//https://leetcode.com/problems/trapping-rain-water/description/
public class RainTrappingWater {
    public static int rainTrappedWater(int[] heights){
        int n = heights.length;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];

        //find Max of Left
        maxLeft[0] = heights[0];

        for(int i = 1; i < n; i++){
            maxLeft[i] = Math.max(maxLeft[i-1], heights[i]);
        }
        maxRight[n-1] = heights[n-1];

        for(int i = n-2; i >= 0; i--){
            maxRight[i] = Math.max(maxRight[i+1], heights[i]);
        }

        int water = 0;
        for(int i = 0; i < n; i++){
            water += Math.min(maxLeft[i], maxRight[i]) - heights[i];
        }
        return water;
    }
    public static void main(String[] args) {
        int[] heights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(rainTrappedWater(heights));
    }
}
