package recursion.array;

public class PrintArray {
    public static void printArray(int arr[], int n){
        if(n > arr.length - 1){
            return;
        }
        System.out.println(arr[n]);
        printArray(arr, n + 1);

    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        int n = arr.length;

        printArray(arr, 0);
    }
}
