package stack.InterviewProblems.Pattern1;
//https://leetcode.com/problems/maximal-rectangle/description/
//Time Complexity
//O(N*M), where 'N' is the number of rows and ‘M’ is the number of columns in the matrix.
//Space Complexity
//O(M), where 'M' is the number of columns in the matrix.
import java.util.Stack;
class Pair{
    int value;
    int index;
    Pair(int value, int index){
        this.value = value;
        this.index = index;
    }
}
public class StockSpan {
    public static int[] findStockSpansBruteForce(int []prices) {
        int n = prices.length;
        int[] ans = new int[n];
        for(int i = n - 1; i >= 0; i--) {
            int count = 1;
            for(int j = i  - 1; j >= 0; j--) {
                if(prices[j] < prices[i]) {
                    count++;
                }
                else{
                    break;
                }
            }
            ans[i] = count;
        }
        return ans;
    }
    public static int[] findNextGreaterLeft(int []prices) {
        int n = prices.length;
        int[] ans = new int[n];
        Stack<Pair> stack = new Stack<>();
        int k = 0;
        for(int i = 0; i < n; i++) {
            if(stack.isEmpty()){
                ans[k++] = -1;
            }
            else if(!stack.isEmpty() && stack.peek().value >= prices[i]){
                ans[k++] = stack.peek().index;
            }
            else if(!stack.isEmpty() && stack.peek().value < prices[i]){
                while(!stack.isEmpty() && stack.peek().value < prices[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    ans[k++] = -1;
                }
                else{
                    ans[k++] = stack.peek().index;
                }
            }

            stack.push(new Pair(prices[i], i));
        }

        return ans;
    }
    public static int[] findStockSpans(int []prices) {
        int n = prices.length;
        int[] ans = new int[n];

        int[] nextGreaterLeft = findNextGreaterLeft(prices);
        for(int ele : nextGreaterLeft) {
            System.out.print(ele + " ");
        }
        System.out.println();
        int k = 0;
        for(int i = 0; i < n; i++) {
            ans[k++] = i - nextGreaterLeft[i];
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] prices = new int[]{100, 80, 60, 70, 60, 75, 85};
//        int []prices = {2, 1, 2, 4};
        int[] result = findStockSpans(prices);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
