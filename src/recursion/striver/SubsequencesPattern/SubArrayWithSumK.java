package recursion.striver.SubsequencesPattern;


import java.util.List;
import java.util.ArrayList;

public class SubArrayWithSumK {

    public static void printSubArraysHelper(List<Integer> arr, int index, List<Integer> ls, int k, List<List<Integer>> output) {
        if(arr.size() <= index){
            int sum = 0;
            for( int ele : ls){
                sum += ele;
            }
            System.out.println(ls);
            if(sum == k) {
                output.add(new ArrayList<>(ls));
            }
            return;
        }
        List<Integer> withCurrent = new ArrayList<>(ls);
        withCurrent.add(arr.get(index));
        printSubArraysHelper(arr, index + 1, withCurrent, k, output);
//        ls.remove(arr.remove(arr.size() - 1));
        printSubArraysHelper(arr, index + 1, ls, k, output);


    }
    public static List<List<Integer>> printSubArrays(List<Integer> arr, int k){
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();

        printSubArraysHelper(arr, 0,  ls, k, output);
        return output;
    }
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(1);
        arr.add(1);
        arr.add(1);

        int k = 3;

        List<List<Integer>> output = printSubArrays(arr, k);
        System.out.println(output);

    }
}
