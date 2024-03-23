package binarysearch.striver.matrix;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchInMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int low = 0, high = ((n * m) - 1);
        while(low <= high){
            int mid = low + (high - low)/2;
            int row = mid / m;
            int col = mid % m;

            if(matrix[row][col] == target){
                return true;
            }
            else if(matrix[row][col] > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>(3);
        matrix.add(new ArrayList<Integer>(Arrays.asList(1, 3, 7)));
        matrix.add(new ArrayList<Integer>(Arrays.asList(10, 12, 15)));
        matrix.add(new ArrayList<Integer>(Arrays.asList(19, 20, 21)));

        int target = 12;

        // convert 2D ArrayList into Matrix
        int[][] mat  = matrix.stream()
                .map(list -> list.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);

        System.out.println(searchMatrix(mat, target));

    }
}
