package recursion.striver.Backtracking;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/n-queens/description/
//Time Complexity: Exponential in nature since we are trying out all ways, to be precise its O(N! * N).
public class NQueen {
    private static boolean isSafeToPlaceQueen(char[][] board, int row, int col) {
        // check in the column
        for(int i = row - 1, j = col;  i >= 0 && j >= 0; i--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        for(int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
    private static void getNQueensHelper(char[][] board, int row, List<String> ansSoFar, List<List<String>> output) {
        if(board.length == row){
            output.add(new ArrayList<>(construct(board)));
            return;
        }

        for(int col = 0; col < board.length; col++){
            if(isSafeToPlaceQueen(board, row, col)){
                board[row][col] = 'Q';
                getNQueensHelper(board, row + 1, ansSoFar, output);
                board[row][col] = '.';
            }
        }
    }

    private static ArrayList<String> construct(char[][] board) {
        ArrayList<String> ls = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            String row = new String(board[i]);
            ls.add(row);
        }
        return ls;
    }


    private static List<List<String>> getNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }

        List<List<String>> output = new ArrayList<>();
        List<String> ansSoFar = new ArrayList<>();

        getNQueensHelper(board, 0, ansSoFar, output);
        return output;
    }



    public static void main(String[] args) {
        int n = 4;
        List<List<String>> output = getNQueens(n);
        System.out.println(output);
    }

}
