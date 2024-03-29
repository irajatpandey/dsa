package recursion.striver.SubsequencesPattern;
import java.util.List;
import java.util.ArrayList;

public class Subset {
    public static List<List<Integer>> subsets(int[] nums, int index) {
        List<Integer> ls = new ArrayList<>();
        List<List<Integer>> output = new ArrayList<>();
        subsetsHelper(nums, index, ls, output);
        return output;
    }

    private static void subsetsHelper(int[] nums, int index, List<Integer> ls, List<List<Integer>> output) {
        // Base Condition
        if(index == nums.length){
            output.add(new ArrayList<>(ls));
            System.out.println(index + " " + ls);

            return;
        }
        ls.add(nums[index]);
//        System.out.println(index + " " + ls);

        subsetsHelper(nums, index + 1, ls, output);
        ls.remove(ls.size() - 1);
//        System.out.println(index + " " + ls);
        subsetsHelper(nums, index + 1, ls, output);

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<Integer> ls = new ArrayList<>();
        List<List<Integer>> output = subsets(nums, 0);
        System.out.println(output);

    }
}
