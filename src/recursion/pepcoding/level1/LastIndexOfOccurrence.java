package recursion.pepcoding.level1;

public class LastIndexOfOccurrence {
    public static int lastIndex(int[] arr, int index, int target){
        if(index < 0){
            return -1;
        }

        if(arr[index] == target){
            return index;
        }

        return lastIndex(arr, index - 1, target);

    }
    public static void main(String[] args) {
        int[] arr = {8, 12, 4, 3, 9, 7, 4, 3, 2, 1};
        int target = 3;

        int output = lastIndex(arr, arr.length - 1, target);
        System.out.println(output);
    }
}
