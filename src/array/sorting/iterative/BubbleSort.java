package array.sorting.iterative;
// Total number of passes : n - 1
// Total number of comparisions : n(n-1)/2
// Time Complexity : O(n^2)
public class BubbleSort {
    public static void bubbleSort(int arr[]){
     int n = arr.length;
     for(int i = 0; i < n; i++){
         for(int j = 0; j < n - i - 1; j++) {
             if (arr[j] > arr[j + 1]) {
                 int t = arr[j + 1];
                 arr[j + 1] = arr[j];
                 arr[j] = t;
             }
         }
         for(int ele : arr){
             System.out.print(ele + " ");
         }
         System.out.println();
      }
        System.out.println("Result");
     for(int ele : arr){
         System.out.print(ele + " ");
     }
    }
    public static void main(String[] args) {
        int arr[] = {9, 3, 4, 2, 5, 6, 8, 7, 1};
        bubbleSort(arr);
    }
}
