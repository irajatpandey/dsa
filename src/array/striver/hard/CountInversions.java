package array.striver.hard;

//https://www.geeksforgeeks.org/problems/inversion-of-array-1587115620/1
public class CountInversions {
    public static int numberOfInversions_bruteForce(int[] arr, int n) {
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (arr[i] > arr[j]) {
                    ans++;
                }
            }
        }

        return ans;
    }

    private static int merge(int[] arr, int start, int mid, int end) {
        int leftIndex = start; // Starting index for the left subarray
        int rightIndex = mid + 1; // Starting index for the right subarray
        int inversionCount = 0;
        int[] temp = new int[end - start + 1]; // Temporary array for merging
        int k = 0; // Index for the temporary array

        // Merge the two subarrays into the temporary array
        while (leftIndex <= mid && rightIndex <= end) {
            if (arr[leftIndex] <= arr[rightIndex]) {
                temp[k++] = arr[leftIndex++];
            } else {
                temp[k++] = arr[rightIndex++];
                // Count inversions: all remaining elements in the left subarray
                // are greater than the current element from the right subarray
                inversionCount += (mid - leftIndex + 1);
            }
        }

        // Copy the remaining elements of the left subarray, if any
        while (leftIndex <= mid) {
            temp[k++] = arr[leftIndex++];
        }

        // Copy the remaining elements of the right subarray, if any
        while (rightIndex <= end) {
            temp[k++] = arr[rightIndex++];
        }

        // Copy the merged subarray back into the original array
        for (int i = 0; i < temp.length; i++) {
            arr[start + i] = temp[i];
        }

        return inversionCount;
    }

    public static int mergeSort(int[] arr, int start, int end) {
        int count = 0;
        if (start < end) {
            int mid = (start + end) / 2;

            // Merge Sort Call
            count += mergeSort(arr, start, mid);
            count += mergeSort(arr, mid + 1, end);
            count += merge(arr, start, mid, end);
        }
        return count;
    }

    public static int numberOfInversions_mergeSort(int[] arr, int n) {
        int totalCount = mergeSort(arr, 0, n);

        return totalCount;

    }


    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 4, 1};
        int n = arr.length;

        int output1 = numberOfInversions_bruteForce(arr, n);
        System.out.println(output1);

        int output2 = numberOfInversions_mergeSort(arr, n - 1);

        System.out.println(output2);

    }
}
