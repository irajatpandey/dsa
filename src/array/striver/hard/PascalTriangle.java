package array.striver.hard;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/pascals-triangle/description/
public class PascalTriangle {
    //Using recursion
    public static List<List<Integer>> generate_triangle(int numRows) {
        if (numRows == 0) return new ArrayList<>();
        if (numRows == 1) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(Arrays.asList(1));
            return result;
        }

        List<List<Integer>> prevRows = generate_triangle(numRows - 1);
        List<Integer> newRow = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            newRow.add(1);
        }

        for (int i = 1; i < numRows - 1; i++) {
            newRow.set(i, prevRows.get(numRows - 2).get(i - 1) + prevRows.get(numRows - 2).get(i));
        }

        prevRows.add(newRow);
        return prevRows;
    }


    public static List<List<Integer>> generate(int numRows) {
       List<List<Integer>> output = new ArrayList<List<Integer>>();
       if(numRows <= 0) return output;
       ArrayList<Integer> ls = new ArrayList<>();
       ls.add(1);
       output.add(ls);


       for(int i = 1; i < numRows; i++){
           ArrayList<Integer> list = new ArrayList<>();
           list.add(1);

           for(int j = 1; j < i; j++){
               int sum = output.get(i - 1).get(j - 1) + output.get(i - 1).get(j);
               list.add(sum);
           }
           list.add(1);
           output.add(list);

       }

       return output;
    }

    public static void main(String[] args) {

        int n = 5;
        List<List<Integer>> output = generate(n);
        List<List<Integer>> output2 = generate_triangle(n);
        System.out.println(output);
        System.out.println(output2);

    }
}
