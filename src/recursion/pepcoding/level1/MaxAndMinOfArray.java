package recursion.pepcoding.level1;

public class MaxAndMinOfArray {
    public static int[] getMaxAndMin(int[] arr, int index, int currentMax, int currentMin){
        if(index == arr.length){
            int[] output = new int[2];
            output[0] = currentMax;
            output[1] = currentMin;
            return output;
        }

        if(currentMax < arr[index]){
            currentMax = arr[index];
        }
        if(currentMin > arr[index]){
            currentMin = arr[index];
        }
        return getMaxAndMin(arr, index + 1,currentMax, currentMin);

    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 17, 8};
        int index = 0;
        int currentMax = Integer.MIN_VALUE, currentMin = Integer.MAX_VALUE;
        int [] output = new int[2];
        int[] smallOutput = getMaxAndMin(arr, 0, currentMax, currentMin);
        System.out.println(smallOutput[0] + " " + smallOutput[1]);
    }
}
