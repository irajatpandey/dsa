package recursion.striver.Backtracking;

public class SudokuSolver {
    public static boolean isValid(char[][] board, int x, int y, char val){
        for(int j = 0; j < board.length; j++){
            if(board[x][j] == val){
                return false;
            }
        }

        for(int i = 0; i < board.length; i++){
            if(board[i][y] == val){
                return false;
            }
        }

        int subMatrixRow = (x / 3) * 3;
        int subMatrixCol = (y / 3) * 3;

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[subMatrixRow + i][subMatrixCol + j] == val){
                    return false;
                }
            }
        }
        return true;
    }
    public static void solveSudokuHelper(char board[][], int row, int col, char[][] output) {
        if (row == board.length) {

            for (int x = 0; x < board.length; x++) {
                for (int y = 0; y < board[0].length; y++) {
                    output[x][y] = board[x][y];
                }
            }
            return;
        }
        int nextRow = 0;
        int nextCol = 0;
        if(col == (board[0].length - 1)){
            nextRow = row + 1;
            nextCol = 0;
        }
        else{
            nextRow = row;
            nextCol = col + 1;
        }

        if (board[row][col] != '.') {
            solveSudokuHelper(board, nextRow, nextCol, output);
        } else {
            //po--> possible options
            for (char possibleOption = '1'; possibleOption <= '9'; possibleOption++) {
                if (isValid(board, row, col, possibleOption)) {
                    board[row][col] = possibleOption;
                    solveSudokuHelper(board, nextRow, nextCol, output);
                    board[row][col] = '.';
                }
            }
        }
    }
    public static boolean checkValid(char[][] board) {
        char[][] output = new char[9][9];
        solveSudokuHelper(board, 0, 0, output);
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if (board[i][j] == 0)
                    return false;
                board[i][j] = output[i][j];
            }
        }
        display(board);
        return true;
    }
    public static boolean solveSudoku(char[][] board) {

        return checkValid(board);

    }
    public static void display(char board[][]) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                System.out.print(board[i][j] + " ");
            }
             System.out.println();
        }
    }
    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},
                         {'6','.','.','1','9','5','.','.','.'},
                         {'.','9','8','.','.','.','.','6','.'},
                         {'8','.','.','.','6','.','.','.','3'},
                         {'4','.','.','8','.','3','.','.','1'},
                         {'7','.','.','.','2','.','.','.','6'},
                         {'.','6','.','.','.','.','2','8','.'},
                         {'.','.','.','4','1','9','.','.','5'},
                         {'.','.','.','.','8','.','.','7','9'}};

        solveSudoku(board);

        boolean ans = checkValid(board);
        System.out.println(ans);


    }


}
