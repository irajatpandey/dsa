package stack.InterviewProblems.Pattern1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

//https://leetcode.com/problems/largest-rectangle-in-histogram/description/
// Time Complexity: O(n)
// Space Complexity: O(n)
public class LargestAreaHistogram {
    private static ArrayList<Integer> findNextSmallerLeftIndex(int[] heights) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Pair> stack = new Stack<>();

        for(int i = 0; i < heights.length; i++) {
            if(stack.isEmpty()) {
                res.add(-1);
            }
            else if(!stack.isEmpty() && stack.peek().value < heights[i]){
                res.add(stack.peek().index);
            }
            else if(!stack.isEmpty() && stack.peek().value >= heights[i]){
                while(!stack.isEmpty() && stack.peek().value >= heights[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    res.add(-1);
                }
                else{
                    res.add(stack.peek().index);
                }
            }

            stack.push(new Pair(heights[i], i));
        }
        return res;
    }

    private static ArrayList<Integer> findNextSmallerRightIndex(int[] heights) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Pair> stack = new Stack<>();
        int index = heights.length;
        for(int i = heights.length - 1; i >= 0; i--) {
            if(stack.isEmpty()) {
                res.add(index);
            }
            else if(!stack.isEmpty() && stack.peek().value < heights[i]){
                res.add(stack.peek().index);
            }
            else if(!stack.isEmpty() && stack.peek().value >= heights[i]){
                while(!stack.isEmpty() && stack.peek().value >= heights[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    res.add(index);
                }
                else{
                    res.add(stack.peek().index);
                }
            }

            stack.push(new Pair(heights[i], i));
        }
        Collections.reverse(res);
        return res;
    }
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;;
        int area = -1;

        ArrayList<Integer> nextSmallerRight = findNextSmallerRightIndex(heights);
        ArrayList<Integer> nextSmallerLeft = findNextSmallerLeftIndex(heights);

        //System.out.println(nextSmallerRight);
        //System.out.println(nextSmallerLeft);
        for(int i = 0; i < n; i++){
            int width = nextSmallerRight.get(i) - nextSmallerLeft.get(i) - 1;
            area = Math.max(area, heights[i] * width);
        }
        return area;
    }



    public static void main(String[] args) {
        int[] height = {6, 2, 5, 4, 5, 1, 6};
//        int[] height = {2, 4}; // edge case
//        int[] height = {1, 1}; // edge case
        int area = largestRectangleArea(height);
        System.out.println(area);
    }
}
