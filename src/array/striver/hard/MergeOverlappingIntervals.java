package array.striver.hard;

import java.util.*;

public class MergeOverlappingIntervals {

    public static int[][] merge_bruteForce(int[][] intervals) {
       List<List<Integer>> output = new ArrayList<>();

       // Sort the intervals
        Comparator<int[]> comp = new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        };
        Arrays.sort(intervals, comp);

        for(int i = 0; i < intervals.length; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];

            if(!output.isEmpty() && end <= output.get(output.size() - 1).get(1)){
                continue;
            }
            for(int j = i + 1; j < intervals.length; j++){
                if(end >= intervals[j][0]){
                    end = Math.max(end, intervals[j][1]);
                }
                else{
                    break;
                }
            }

            ArrayList<Integer> ls = new ArrayList<>(2);
            ls.add(start);
            ls.add(end);
            output.add(ls);
        }


        int[][] result = new int[output.size()][2];
        int k = 0;
        for(List<Integer> element : output){
            int first = element.get(0);
            int second = element.get(1);

            result[k][0] = first;
            result[k][1] = second;
            k++;
        }


        return  result;
    }

    //T.C -> O(nlogn) + o(n)
    public static int[][] merge_optimal(int[][] intervals){
        int n = intervals.length;

        List<List<Integer>> output = new ArrayList<>();

        for(int i = 0; i < n; i++){

            if(output.isEmpty()){
                ArrayList<Integer> ls = new ArrayList<>(2);
                ls.add(intervals[i][0]);
                ls.add(intervals[i][1]);
                output.add(ls);
            }

            else {
                int start = output.get(output.size() - 1).get(0);
                int end = output.get(output.size() - 1).get(1);

                if(end >= intervals[i][0]){
                    int maxEnd = Math.max(end, intervals[i][1]);
                    output.get(output.size() - 1).set(1, maxEnd);
                }
                else{
                    ArrayList<Integer> ls = new ArrayList<>(2);
                    ls.add(intervals[i][0]);
                    ls.add(intervals[i][1]);
                    output.add(ls);
                }
            }


        }

        int[][] result = new int[output.size()][2];
        int k = 0;
        for(List<Integer> element : output){
            int first = element.get(0);
            int second = element.get(1);

            result[k][0] = first;
            result[k][1] = second;
            k++;
        }

        return result;
    }
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 17}, {18, 20}};
        int[][] output = merge_bruteForce(intervals);

        for(int[] element : output){
            System.out.println(element[0] + " " + element[1]);
        }

        System.out.println("Optimal Solution");
        // optimal
        int[][] output2 = merge_optimal(intervals);

        for(int[] element : output2){
            System.out.println(element[0] + " " + element[1]);
        }
    }
}
