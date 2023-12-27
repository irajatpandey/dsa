package array.introduction;



public class RotateAnArray {
    public static void shift(int arr[]){
        int n = arr.length;
        int first = arr[0];
        int last = arr[n - 1];
        for(int i = n - 1; i >= 1; i--){
            arr[i] = arr[i - 1];
        }
        arr[0] = last;

        for(int ele : arr){
            System.out.print(ele + " ");
        }
        System.out.println();
    }
    public static void rightShift(int arr[]){
        int n = arr.length;
        int first = arr[0];
        for(int i = 1; i < n; i++){
            arr[i - 1] = arr[i];
        }
        arr[n - 1] = first;
        for(int ele : arr){
            System.out.print(ele + " ");
        }

        System.out.println();
    }

    public static void reverse(int arr[], int start, int end){
        while(start < end){
            int c = arr[start];
            arr[start] = arr[end];
            arr[end] = c;
            start++;
            end--;
        }
    }
    public static void optimalSolution(int arr[], int k){

        reverse(arr, arr.length - k, arr.length - 1);
        reverse(arr, 0, arr.length - k - 1);
        reverse(arr, 0, arr.length - 1);
        for(int ele : arr){
            System.out.print(ele + " ");
        }
    }
    public static void rotate(int arr[], int k){
        int n = arr.length;
        k = k % n;
        System.out.println(k);
        int j = arr.length - 1;
        int i = 0;
        if(k > 0){
            while(k > 0){
                shift(arr);
                k--;
            }
        }
        else if( k < 0){
            while(k < 0){
                rightShift(arr);
                k++;
            }
        }

        for(int ele : arr){
            System.out.print(ele + " ");
        }

    }
    public static void main(String[] args) {
        int []arr = {1, 2, 3, 4, 5};
        int k = 3;

        //rotate(arr, k);
        optimalSolution(arr, k);
    }
}
