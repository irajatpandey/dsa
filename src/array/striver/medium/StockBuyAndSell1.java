package array.striver.medium;

public class StockBuyAndSell1 {
    public static int[] getMaxAndMin(int[] prices, int n, int start){
        int max = 0;
        int min = 0;
        int myMin = prices[start];
        for(int i = start + 1; i < n; i++){
            max = Math.max(max, prices[i]);
        }
        int output[] = {max, myMin};
        return output;
    }
    public static int bestTimeToBuyStock_bruteForce(int[] prices){
        int maxProfit = 0;
        for(int i = 0;  i < prices.length - 1; i++){
            int ans[] = getMaxAndMin(prices, prices.length, i);
            System.out.println(ans[0] + " " + ans[1]);
            maxProfit = Math.max(maxProfit, ans[0] - ans[1]);
        }
        return maxProfit;
    }

    public static int bestTimeToBuyStock_optimal(int[] prices){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < prices.length; i++){
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }
    public static void main(String[] args) {
        int prices[] = {7,6,4,3,1};
        //int output = bestTimeToBuyStock_bruteForce(prices);
        //System.out.println(output);
        int output2 = bestTimeToBuyStock_optimal(prices);
        System.out.println(output2);
    }
}
