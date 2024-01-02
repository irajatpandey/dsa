package array.sorting.iterative;

public class InsertionSort {
    public static void insertionSort(int arr[]){
        int n = arr.length;
        for(int i = 1; i < n; i++){
            int key = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > key){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
            for(int ele : arr) System.out.print(ele + " ");
            System.out.println();
        }

        for(int ele : arr) System.out.print(ele + " ");
    }
    public static void main(String[] args) {
        int arr[]  = {4, 5, 6, 2, 3, 1};
        insertionSort(arr);
    }
}
