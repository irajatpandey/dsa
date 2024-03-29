package recursion.striver.SubsequencesPattern;
import java.util.List;
import java.util.ArrayList;

public class PrintSubArrays {

    public static void printSubArraysHelper(List<Integer> arr, int index, List<Integer> ls, List<List<Integer>> output) {
            if(arr.size() <= index){
                output.add(new ArrayList<>(ls));
                return;
            }
            ls.add(arr.get(index));
            System.out.println(ls);
            printSubArraysHelper(arr, index + 1, ls, output);
            ls.remove(arr.remove(arr.size() - 1));
            printSubArraysHelper(arr, index + 1, ls, output);


    }
    public static List<List<Integer>> printSubArrays(List<Integer> arr){
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();

        printSubArraysHelper(arr, 0,  ls, output);
        return output;
    }
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);

        List<List<Integer>> output = printSubArrays(arr);
        System.out.println(output);

    }
}
