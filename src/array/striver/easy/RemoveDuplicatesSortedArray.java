package array.striver.easy;

import java.util.ArrayList;

public class RemoveDuplicatesSortedArray {
    public static int removeDuplicatesLeetCode(int[] nums) {
        int j = 0;
        int i = 0;
        int n = nums.length;
        while(i < n && j < n){
            if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
            else{
                j++;
            }
        }
        return i + 1;
    }
    public static int removeDuplicates(ArrayList<Integer> arr,int n) {
        // Write your code here.
        // 1 2 2 2 3 3 4
        int j = 0;
        for(int i = 1; i < n; i++){
            if(!(arr.get(i).equals(arr.get(i - 1)))){
                System.out.println(arr.get(i) + " " + arr.get(i - 1));
                arr.set(j++, arr.get(i - 1));

            }
        }
        System.out.println(arr);
        return j + 1;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(2);
        arr.add(2);
        arr.add(3);
        arr.add(3);
        arr.add(4);
        int output = removeDuplicates(arr, arr.size());
        System.out.println(output);

    }
}
