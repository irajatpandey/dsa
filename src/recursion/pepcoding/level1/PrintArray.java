package recursion.pepcoding.level1;

public class PrintArray {
    public static void printArray(int[] arr, int index){
        if(index == arr.length){
            return;
        }
        System.out.print(arr[index] + " ");
        printArray(arr, index + 1);
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int n = arr.length;
        printArray(arr, 0);
    }
}
