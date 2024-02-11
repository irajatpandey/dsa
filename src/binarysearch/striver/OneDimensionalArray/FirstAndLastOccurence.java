package binarysearch.striver.OneDimensionalArray;

public class FirstAndLastOccurence {

    public static int firstOccurrence(int[] nums, int target){
       int start = 0, end = nums.length - 1, outputIndex = -1;
       while (start <= end){
           int mid = start + (end - start)/2;
           if(nums[mid] == target){
               outputIndex = mid;
               end = mid - 1;
           }
           else if(nums[mid] > target){
               end = mid - 1;
           }
           else{
               start = mid + 1;
           }
       }
       return outputIndex == -1 ? outputIndex : nums[outputIndex];
    }

    public static int lastOccurrence(int[] nums, int target){
        int start = 0, end = nums.length - 1, outputIndex = -1;
        while (start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                outputIndex = mid;
                start = mid + 1;
            }
            else if(nums[mid] > target){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }

        return outputIndex == -1 ? outputIndex : nums[outputIndex];
    }
    public static int[] firstAndLastOccurence(int[] nums, int target){
        int[] ans = new int[2];
        ans[0] = firstOccurrence(nums, target);
        ans[1] = lastOccurrence(nums, target);

        return ans;
    }
    public static void main(String[] args) {
//      int[] nums = {5,7,7,8,8,10};
        int target = 6;
        int[] a = {0, 0};

        int []ans = firstAndLastOccurence(a, target);
        System.out.println(ans[0] + " " + ans[1]);
    }
}
