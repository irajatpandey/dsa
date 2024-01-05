package array.striver.easy;

public class MaximumConsecutiveOnes {

    public static int maximumOnes(int arr[], int n){
        int max = -1;
        int track = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] == 1){
               track++;
            }
            else if(arr[i] != 1){
                max = track > max ? track : max;
                track = 0;
            }
        }
        max = track > max ? track : max;
        return max;
    }
    public static void main(String[] args) {
        int arr[] = {1, 1, 0, 1, 1, 1};
        int n = arr.length;

        int ans = maximumOnes(arr, n);
        System.out.println(ans);
    }
}

