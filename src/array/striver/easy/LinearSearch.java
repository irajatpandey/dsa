package array.striver.easy;

public class LinearSearch {
    public static int linearSearch(int arr[], int ele){
        int n = arr.length;
        for(int i = 0; i < n; i++){
            if(arr[i] == ele) {
                return i;
            }
        }
        return -1;

    }
    public static void main(String[] args) {
        int arr[] = {1, 4, 3, 2, 44};
        int ele = 44;
        int output = linearSearch(arr, ele);
        System.out.println(output);
    }
}
