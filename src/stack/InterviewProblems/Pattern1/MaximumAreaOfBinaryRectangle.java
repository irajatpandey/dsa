package stack.InterviewProblems.Pattern1;
import stack.InterviewProblems.Pattern1.LargestAreaHistogram.*;
import java.util.Arrays;

public class MaximumAreaOfBinaryRectangle {
    public static int maximalAreaOfSubMatrixOfAll1(int[][] mat, int n, int m) {
        int maxArea = -1;

        int maxSoFar = LargestAreaHistogram.largestRectangleArea(mat[0]);
        maxArea = Math.max(maxSoFar, maxArea);

        for(int i = 1; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if(mat[i][j] == 0) {
                    mat[i][j] = 0;
                }
                else{
                    mat[i][j] = mat[i][j] + mat[i - 1][j];
                }
            }
            maxSoFar = LargestAreaHistogram.largestRectangleArea(mat[i]);
            maxArea = Math.max(maxSoFar, maxArea);
        }


        return maxArea;
    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 1, 0}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 0, 0}};
        int n = matrix.length;
        int m = matrix[0].length;

        int maxArea = maximalAreaOfSubMatrixOfAll1(matrix, n, m);
        System.out.println(maxArea);
    }
}
