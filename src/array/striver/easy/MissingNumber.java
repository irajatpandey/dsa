package array.striver.easy;

public class MissingNumber {
    public static int missingNumber(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int ele : nums) sum += ele;
        int total = (n * (n + 1)/2);
        return total - sum;
    }
    public static void main(String[] args) {
        int arr[] = {0, 1, 3};
        System.out.println(missingNumber(arr));

    }
}
