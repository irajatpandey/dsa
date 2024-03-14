package binarysearch.striver.BinarySearchOnAnswers;
// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
public class ShipWithinDays {
    public static  boolean possible(int[] weights, int D, int capacity){
        int days = 1, current_capacity = 0;

        for(int weight : weights){
            if(current_capacity + weight > capacity){
                days++;
                current_capacity = weight;
            }else{
                current_capacity += weight;
            }
        }
        return days <= D;
    }
    public static int shipWithinDays(int[] weights, int days) {

        int low = Integer.MAX_VALUE, high = 0;

        for(int ele : weights){
            high += ele;
            low = Math.min(ele, low);
        }

        while(low <= high){
            int mid = low + (high - low)/2;
            if(possible(weights, days, mid)){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;

        System.out.println(shipWithinDays(weights, days));
    }
}
