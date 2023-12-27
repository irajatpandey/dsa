package array.introduction;

public class SpanOfArray {
    public static void main(String[] args) {
        int []arr = {10, 4, 40, 21, 19, 27};
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int j : arr) {
            if (j > max) {
                max = j;
            }
            if (j < min) {
                min = j;
            }
        }

        System.out.println(max - min);
    }
}
