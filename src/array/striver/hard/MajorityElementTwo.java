package array.striver.hard;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementTwo {
    public static List<Integer> majorityElement(int[] nums) {
        int cnt1 = 0;
        int cnt2 = 0;
        int first = Integer.MIN_VALUE, second = Integer.MAX_VALUE;
        List<Integer> ls = new ArrayList<Integer>();

        for(int i = 0; i < nums.length; i++){
            if(first == nums[i]) cnt1++;
            else if(second == nums[i]) cnt2++;
            else if(cnt1 == 0){
                first = nums[i];
                cnt1 = 1;
            }
            else if(cnt2 == 0){
                second = nums[i];
                cnt2 = 1;
            }
            else {
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = 0; cnt2 = 0;

        for(int ele : nums){
            if(ele == first) cnt1++;
            if(ele == second) cnt2++;
        }


        if(cnt1 > nums.length/3) ls.add(first);
        if(cnt2 > nums.length/3) ls.add(second);
        return ls;
    }
    public static void main(String[] args) {
        int nums[] = {3, 2, 3};
        System.out.println(majorityElement(nums));
    }
}
