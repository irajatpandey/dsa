package array.searching.linearsearch;

public class LinearSearch {

    // TC O(n)
    public static int findIterative(int arr[], int ele, int n){
        for(int i = 0; i < n; i++){
            if(arr[i] == ele){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {1, 3, 4, 5, 6, 8, -2, 34};
        int n = arr.length;
        int ele = -21;
        int elementIndex = findIterative(arr, ele, n);
        System.out.println(elementIndex);
    }
}
