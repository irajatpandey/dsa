package array.striver.medium;

import java.util.ArrayList;

public class RotateMatrix90Degree {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        // transpose
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // swap columns;

        for(int i = 0; i < n; i++){
            int left = 0;
            int right = n - 1;

            while(left < right){
                int c = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = c;
                left++;
                right--;
            }
        }
    }
    public static void display(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3},{4, 5, 6},{7, 8, 9}};
        rotate(matrix);
        display(matrix);

    }
}
