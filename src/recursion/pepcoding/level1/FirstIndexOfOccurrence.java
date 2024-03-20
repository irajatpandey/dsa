package recursion.pepcoding.level1;

public class FirstIndexOfOccurrence {
    public static int firstIndex(int[] arr, int index, int target){
        if(index == arr.length){
            return -1;
        }
        if(arr[index] == target){
            return index;
        }
        return firstIndex(arr, index + 1, target);
    }
    public static void main(String[] args) {
        int[] arr = {8, 12, 4, 3, 9, 7, 4, 3, 2, 1};
        int target = 3;

        int output = firstIndex(arr, 0, target);
        System.out.println(output);
    }
}
