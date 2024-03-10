package binarysearch.striver.BinarySearchOnAnswers;

public class MinimumDaysToMakeMBouquet {
    public static boolean possible(int[] arr, int day, int m, int k) {
        int n = arr.length; // Size of the array
        int cnt = 0;
        int noOfB = 0;
        // Count the number of bouquets:
        for (int i = 0; i < n; i++) {
            if (arr[i] <= day) {
                cnt++;
            } else {
                noOfB += (cnt / k);
                cnt = 0;
            }
        }
        noOfB += (cnt / k);
        return noOfB >= m;
    }

    public static int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (m * k > n) return -1;
        int minimumDay = Integer.MAX_VALUE, maxDay = Integer.MIN_VALUE;
        for(int i = 0; i < bloomDay.length; i++){
            minimumDay = Math.min(minimumDay, bloomDay[i]);
            maxDay = Math.max(maxDay, bloomDay[i]);
        }

        int low = minimumDay, high = maxDay;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(possible(bloomDay, mid, m, k) == true){
               high = mid - 1;
            }

            else{
                low = mid + 1;
            }
        }

        return low;
    }
    public static int minDays_bruteforce(int[] bloomsDay, int m, int k) {
        int ans = -1;
        int n = bloomsDay.length;
        if(m * k >  n) return -1;

        int minimumDay = Integer.MAX_VALUE, maxDay = Integer.MIN_VALUE;
        for(int i = 0; i < bloomsDay.length; i++){
            minimumDay = Math.min(minimumDay, bloomsDay[i]);
            maxDay = Math.max(maxDay, bloomsDay[i]);
        }


        int total_bouquet = 0;
        int cnt = 0;

        for(int i = minimumDay; i <= maxDay; i++){

            if(possible(bloomsDay, i, m, k) == true){
                return i;
            }

        }

        return ans;
    }
    public static void main(String[] args) {
        int[] bloomsday = {1,10,3,10,2};
        int m = 3, k = 1;

        int output = minDays(bloomsday, m, k);
        System.out.println(output);

    }
}
