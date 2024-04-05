package recursion.striver.Backtracking;

import java.util.ArrayList;
//https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
//Time Complexity: O(4^(m*n)), because on every cell we need to try 4 different directions.
//Space Complexity:  O(m*n), Maximum Depth of the recursion tree(auxiliary space).
class RatInMaze{
    public static void findPathHelper(int[][] m, int row, int col, int n, String ans, ArrayList<String> output){
        if(row >= n || row < 0 || col >= n || col < 0 || m[row][col] != 1){
            return;
        }

        if(row == n - 1 && col == n - 1){
            output.add(ans);
            return;
        }

        m[row][col] = 0;
        findPathHelper(m, row, col - 1, n, ans + "L", output);
        findPathHelper(m, row, col + 1, n, ans + "R", output);
        findPathHelper(m, row - 1, col , n, ans + "U", output);
        findPathHelper(m, row + 1, col, n, ans + "D", output);
        m[row][col] = 1;


    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> output = new ArrayList<>();
        findPathHelper(m, 0, 0, n, "", output);
        return output;
    }

    public static void main(String[] args) {
        int m[][] = {{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}};
        int n = 3;
//        int m[][] = {{1, 0, 0}, {1, 1, 1}, {1, 1, 1}};
        ArrayList<String> output = findPath(m, n);
        System.out.println(output);
    }
}
