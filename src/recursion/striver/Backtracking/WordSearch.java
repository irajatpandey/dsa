package recursion.striver.Backtracking;


//https://leetcode.com/problems/word-search/
/*
Time Complexity:  O(m*n*4^k), where “K” is the length of the word. And we are searching for the letter m*n times in the worst case.
Here 4 in 4^k is because at each level of our decision tree we are making 4 recursive calls which equal 4^k in the worst case.

Space Complexity: O(K), Where k is the length of the given words.
* */
// Asked in Microsoft, GoldmanSachs, MorganStanley etc.
public class WordSearch {
    public static boolean find(char[][] board, int i, int j ,int count, String word){
        if(count == word.length()){
            return true;
        }
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(count)){
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '*';
        boolean found = find(board, i + 1, j, count + 1, word) ||
                        find(board, i - 1, j, count + 1, word) ||
                        find(board, i, j + 1, count + 1, word) ||
                        find(board, i, j - 1, count + 1, word);
        board[i][j] = temp;
        return found;
    }
    public static boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0) && find(board, i, j, 0, word)){
                    return true;
                }
            }

        }
        return false;
    }
    public static void main(String[] args) {
        char[][] boards = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";

        boolean output = exist(boards, word);
        System.out.println(output);
    }
}
