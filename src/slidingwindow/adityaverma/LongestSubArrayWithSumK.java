package slidingwindow.adityaverma;

public class LongestSubArrayWithSumK {
    public static int longestSubArrayWithSumk(int arr[], int n, int sum){
        int i = 0, j = 0, total = 0;
        int windowSize = -1;
        while (j < n && i < n){
            total += arr[j];
            if(sum > total){
                j++;
            }
            else if(sum == total){
                windowSize = Math.max(windowSize, j - i + 1);
                j++;

            }
            else if(total > sum && i < n){
                while(total > sum && i < n) {
                    total = total - arr[i];
                    i++;
                }
                j++;
            }
            //System.out.println(i + " " + j);
        }
        return windowSize;
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 1, 1, 1, 1};
        int n = arr.length;
        int sum = 3;
        int output = longestSubArrayWithSumk(arr, n, sum);
        System.out.println(output);
    }
}
