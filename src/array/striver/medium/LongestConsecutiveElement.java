package array.striver.medium;

import java.util.HashSet;

public class LongestConsecutiveElement {
    public static int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<Integer>();
        int longest = 1;
        for(int ele : nums){
            set.add(ele);

        }

        for(int it : set){
            if(!set.contains(it - 1)){
                int x = it;
                int cnt = 1;
                while(set.contains(x + 1)){
                    x++;
                    cnt++;
                }
                longest = Math.max(longest, cnt);
            }
        }
        return longest;
    }
    public static void main(String[] args) {
        int arr[] = {100,4,200,1,3,2};
        int ans = longestConsecutive(arr);
        System.out.println(ans);
    }
}
