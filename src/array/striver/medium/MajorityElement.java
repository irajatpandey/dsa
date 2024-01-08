package array.striver.medium;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static int majorityElement_bruteForce(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int majorityElement = 0;
        int n = nums.length;
        for(int ele : nums){
            if(mp.containsKey(ele)){
                mp.put(ele, mp.get(ele) + 1);
            }
            else{
                mp.put(ele, 1);
            }
        }

        for(Map.Entry<Integer, Integer> pair : mp.entrySet()){
            System.out.println(pair.getKey() + " " + pair.getValue());
            if(pair.getValue() > n/2){
                majorityElement = pair.getKey();
            }
        }
        return majorityElement;
    }
    public static int majorityElement_MooreVotingAlgo(int nums[]){
        int element = Integer.MIN_VALUE;
        int count = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(count == 0){
                count = 1;
                element = nums[i];
            }
            else if(element == nums[i]){
                count++;
            }
            else{
                count--;
            }

        }

        //checking if the stored element
        // is the majority element:
        int cnt1 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == element)
                cnt1++;
        }

        if (cnt1 > (n / 2)) return element;
        return -1;
    }
    public static void main(String[] args) {
        int nums[] = {2, 2, 1, 1, 1,2,2};
        int n = nums.length;

//        int output = majorityElement_bruteForce(nums);
//        System.out.println(output);

        int output2 = majorityElement_MooreVotingAlgo(nums);
        System.out.println(output2);

    }
}
