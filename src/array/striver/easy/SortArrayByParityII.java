package array.striver.easy;

import java.util.Arrays;
import java.util.Collections;

//Time Complexity: O(n)
//Space Complexity: O(1)
public class SortArrayByParityII {

    public static int[] sortArrayByParityII(int[] nums) {
        int oddIndex = 1;
        int evenIndex = 0;

        int ans[] = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] % 2 == 0) {
                ans[evenIndex] = nums[i];
                evenIndex += 2;
            }
            else{
                ans[oddIndex] = nums[i];
                oddIndex += 2;
            }
        }
        return ans;
    }

    public static int[] sortArrayByParityII_InPlace(int[] nums) {
        int n = nums.length;
        int evenIndex = 0;
        int oddIndex = 1;

        while (evenIndex < n && oddIndex < n) {
            // Find the first misplaced even number at an odd index
            while (evenIndex < n && nums[evenIndex] % 2 == 0) {
                evenIndex += 2;
            }

            // Find the first misplaced odd number at an even index
            while (oddIndex < n && nums[oddIndex] % 2 == 1) {
                oddIndex += 2;
            }

            // Swap the misplaced even and odd numbers
            if (evenIndex < n && oddIndex < n) {
                int temp = nums[evenIndex];
                nums[evenIndex] = nums[oddIndex];
                nums[oddIndex] = temp;
            }
        }
        return nums;

    }
    public static void main(String[] args) {
        int[] nums = {4, 2, 5, 7};
        int[] ans = sortArrayByParityII(nums);
        Arrays.stream(ans).forEach(a -> System.out.print(a + " "));
        System.out.println();
        int[] output = sortArrayByParityII_InPlace(nums);
        Arrays.stream(ans).forEach(a -> System.out.print(a + " "));

    }
}
