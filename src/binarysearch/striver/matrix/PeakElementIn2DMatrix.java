package binarysearch.striver.matrix;

public class PeakElementIn2DMatrix {
    public static int findMax(int[][] matrix, int col){
        int row = matrix.length, index = -1;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < row; i++){
            if(max < matrix[i][col]){
                index = i;
                max = matrix[i][col];
            }
        }
        return index;
    }
    public static int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int low = 0, high = m - 1;
        int[] output = new int[2];
        while(low <= high){
            int mid = low + (high - low)/2;
            int maxRowIndex = findMax(mat, mid);
            int left = mid - 1 >= 0 ? mat[maxRowIndex][mid - 1] : -1;
            int right = mid + 1 < m ? mat[maxRowIndex][mid + 1] : -1;

            if(mat[maxRowIndex][mid] > left && mat[maxRowIndex][mid] > right ){
                output[0] = maxRowIndex;
                output[1] = mid;
                return output;
            }
            else if(mat[maxRowIndex][mid] < left){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return output;
    }
    public static void main(String[] args) {
        int[][] matrix = {{10,20,15},{21,30,14},{7,16,32}};
        int[] output = findPeakGrid(matrix);
        System.out.println(output[0] + " " + output[1]);
    }
}
