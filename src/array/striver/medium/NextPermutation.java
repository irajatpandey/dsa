package array.striver.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NextPermutation {
    public static List< Integer > nextGreaterPermutation(List< Integer > nums) {
        // Write your code here.
        int index = -1;
        int n = nums.size();

        //List<Integer> ls = new ArrayList<>(n);
        for(int i = n - 2; i >= 0; i--){
            if(nums.get(i) < nums.get(i + 1)){
                index = i;
                break;
            }
        }
        System.out.println("Index " + index);
        if(index == -1){
            Collections.reverse(nums);
            return nums;
        }
        for(int i = n - 1; i >= index; i--){
            if(nums.get(i) > nums.get(index)){
                int c = nums.get(i);
                nums.set(i, nums.get(index));
                nums.set(index, c);
                break;
            }
        }
        for(Integer ele : nums){
            System.out.print(ele + " ");
        }
        System.out.println();

        Collections.reverse(nums.subList(index + 1, n));
        for(Integer ele : nums){
            System.out.print(ele + " ");
        }
        System.out.println();
        return nums;
    }
    public static void reverse(int nums[], int start, int end){
        while(start < end){
            int c = nums[start];
            nums[start] = nums[end];
            nums[end] = c;

            start++;
            end--;
        }
    }
    public static void nextPermutation(int[] nums){
        int index = -1;
        int n = nums.length;
        for(int i = n - 2; i >= 0; i--){
            if(nums[i] < nums[i + 1]){
                index = i;
                break;
            }
        }
        System.out.println("Index " + index);
        if(index == -1){
            reverse(nums, 0, n - 1);
        }
        for(int i = n - 1; i >= index; i--){
            if(nums[i] > nums[index]){
                int c = nums[i];
                nums[i] = nums[index];
                nums[index] = c;
                break;
            }
        }

        reverse(nums, index + 1, n - 1);
    }
    public static void main(String[] args) {
        int nums[] = {3,1,2};
        List<Integer> ls = new ArrayList<>(3);
        ls.add(3);
        ls.add(1);
        ls.add(2);
        ls = nextGreaterPermutation(ls);
        for(Integer ele : ls){
            System.out.print(ele + " ");
        }
        //nextPermutation(nums);
//        for(int ele : nums){
//            System.out.print(ele + " ");
//        }
    }
}
