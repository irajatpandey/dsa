package array.striver.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        List<Integer> output = new ArrayList<>();

        int minrow = 0;
        int maxrow = matrix.length - 1;
        int mincol = 0;
        int maxcol = matrix[0].length - 1;
        int count = 0;
        int totalElement = matrix.length * matrix[0].length;

        while(count < totalElement){

            // right wall
            for(int j = mincol, i = minrow ; j <= maxcol && count < totalElement; j++){
                output.add(matrix[i][j]);
                count++;
            }
            minrow++;
            // Down Wall
            for(int i = minrow, j = maxcol; i <= maxrow && count < totalElement; i++){
                output.add(matrix[i][j]);
                count++;
            }
            maxcol--;
            // Bottom Wall

            for(int j = maxcol, i = maxrow; j >= mincol && count < totalElement; j--){
                output.add(matrix[i][j]);
                count++;
            }
            maxrow--;
            // Up wall

            for(int j = mincol, i = maxrow; i >= minrow && count < totalElement; i--){
                output.add(matrix[i][j]);
                count++;
            }
            mincol++;

        }

        return output;
    }
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3},{4, 5, 6},{7, 8, 9}};
        List<Integer> output = spiralOrder(matrix);
        for(int ele : output){
            System.out.print(ele + " ");
        }

    }
}
