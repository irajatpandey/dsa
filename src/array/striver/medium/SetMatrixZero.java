package array.striver.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Pair {
    int row;
    int col;

    Pair(int row , int col){
        this.row = row;
        this.col = col;
    }
}

public class SetMatrixZero {
    public static void setZeroes_optimal(int[][] matrix){
        int row = matrix.length;
        int col = matrix[0].length;

        boolean row_zero = false;
        boolean col_zero = false;

        for(int i = 0; i < row; i++) if(matrix[i][0] == 0) row_zero = true;
        for(int j = 0; j < col; j++) if(matrix[0][j] == 0) col_zero = true;


        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }


        for(int i = 1; i < row; i++){
            if(matrix[i][0] == 0){
                for(int j = 0; j < col; j++){
                    matrix[i][j] = 0;
                }
            }
        }

        for(int j = 1; j < col; j++){
            if(matrix[0][j] == 0){
                for(int i = 0; i < row; i++){
                    matrix[i][j] = 0;
                }
            }
        }

        if(row_zero){
            for(int i = 0; i < row; i++){
                matrix[i][0] = 0;
            }
        }

        if(col_zero){
            for(int j = 0; j < col; j++){
                matrix[0][j] = 0;
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
    public static void setZero(int[][] matrix, int row, int col){
        int m = matrix.length;
        int n = matrix[0].length;
        //System.out.println("row " + row + " " + "col " + col);
        for(int i = 0; i < n; i++){
            matrix[row][i] = 0;
        }

        for(int i = 0; i < m; i++){
            matrix[i][col] = 0;
        }

    }
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        ArrayList<Pair> ls = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    Pair p = new Pair(i, j);
                    ls.add(p);
                }

            }
        }

        for(Pair p : ls){
            int row = p.row;
            int col = p.col;
            System.out.println(row + " " + col);

            setZero(matrix, row, col);
        }
        display(matrix);

    }
    public static void main(String[] args) {
        int matrix[][] = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes_optimal(matrix);
        display(matrix);
//       setZeroes(matrix);

    }
}
