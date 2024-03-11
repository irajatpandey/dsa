package binarysearch.striver.OneDimensionalArray;

public class LowerBound {
    public static int lowerBound(int[] arr, int n, int target) {

        int start = 0, end = n - 1;
        int lower_bound = arr.length;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] >= target) {
                lower_bound = mid;

                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }
        return lower_bound;

    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 15, 19};
        int target = 24;
        int output = lowerBound(arr, arr.length, target);
        System.out.println(output);
    }
}
