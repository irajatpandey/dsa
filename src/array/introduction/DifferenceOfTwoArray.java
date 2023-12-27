package array.introduction;

public class DifferenceOfTwoArray {
    public static void main(String[] args) {
        int[] arr1 = {9, 9, 0};
        int[] arr2 = {1};

        int[] arr3 = new int[Math.max(arr1.length, arr2. length)];

        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int k = arr3.length - 1;

        if(arr2.length > arr1. length){
            System.out.println("Subtraction is not possible");
        }
        else if(arr1.length == arr2.length){
            if(arr2[0] > arr1[0]){
                System.out.println("First array is smalller than second, not possible!");
            }
        }
        int carry = 0;
        while(k >= 0){
            int a, b;
            if(i >= 0 && j >= 0){
                if(arr1[i] < arr2[j]){
                    arr1[i] += 10;
                    arr1[i - 1]--;
                }
                arr3[k] = arr1[i] - arr2[j];
            }
            else{
                arr3[k] = arr1[i];
            }
            i--;
            j--;
            k--;

        }

        for(int ele : arr3){
            System.out.print(ele);
        }
    }
}
