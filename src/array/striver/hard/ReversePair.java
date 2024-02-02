package array.striver.hard;

import java.math.BigInteger;

public class ReversePair {
    public static int reversePairs_bruteForce(int[] nums) {
        int output = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                long twice = (long)2 * nums[j];
                if(nums[i] > twice){
                    output++;
                }
            }
        }
        return output;
    }

    public static void merge(int[] arr, int start, int mid, int end){
        int left = 0, right = 0;

        // Create Two Arrays
        int[] leftArray = new int[mid - start + 1];
        int[] rightArray = new int[end - mid];

        // Copy first Half
        for(int i = 0; i < leftArray.length; i++){
            leftArray[i] = arr[start + i];
        }

        // Copy Second Half
        for(int i = 0; i < rightArray.length; i++){
            rightArray[i] = arr[mid + 1 + i];
        }

        // Merge
        int k = start;
        while(left < leftArray.length && right < rightArray.length){
            if(leftArray[left] <= rightArray[right]){
                arr[k] = leftArray[left];
                left++;
            }
            else{
                arr[k] = rightArray[right];
                right++;
            }
            k++;
        }

        while(left < leftArray.length){
            arr[k] = leftArray[left];
            k++;
            left++;
        }

        while(right < rightArray.length){
            arr[k] = rightArray[right];
            k++;
            right++;
        }
    }
    public static int countPairs(int[] nums, int start, int mid, int end){
        int right = mid + 1;
        int count = 0;
        for(int i = start; i <= mid; i++){
            while(right <= end && nums[i] > (long)2 * nums[right]){
                right++;
            }
            count += (right - (mid + 1));
        }
        return count;
    }
    public static int mergeSort(int start, int end, int[] nums){

        int count = 0;
        int mid = (start + end)/2;
        if(start >= end){
            return count;
        }
        count += mergeSort(start, mid, nums);
        count += mergeSort(mid + 1, end, nums);
        count += countPairs(nums, start, mid, end);
        merge(nums, start, mid, end);
        return count;
    }
    /*
        Time Complexity: O(2N*logN), where N = size of the given array.
        Reason: Inside the mergeSort() we call merge() and countPairs() except mergeSort() itself. Now, inside the function countPairs(),
        though we are running a nested loop, we are actually iterating the left half once and the right half once in total.
        That is why, the time complexity is O(N). And the merge() function also takes O(N). The mergeSort() takes O(logN) time complexity.
        Therefore, the overall time complexity will be O(logN * (N+N)) = O(2N*logN).

        Space Complexity: O(N), as in the merge sort We use a temporary array to store elements in sorted order.
    */
    public static int reversePairs(int[] nums){

        int output = mergeSort(0, nums.length - 1, nums);

        return output;
    }
    public static void main(String[] args) {
//       int[] nums = {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};
        int[] nums = {5, 4, 3, 2, 1};
       int output1 = reversePairs_bruteForce(nums);

        System.out.println(output1);

        int output2 = reversePairs(nums);
        System.out.println(output2);

    }
}
