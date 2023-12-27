package array.introduction;

import java.util.Arrays;
import java.util.*;

public class ReverseArray {
    public static void reverseArray(Integer arr[]){
        int i = 0;
        int j = arr.length - 1;
        while(i <= j){
            int c = arr[i];
            arr[i] = arr[j];
            arr[j] = c;
            i++;
            j--;
        }

        Collections.reverse(Arrays.asList(arr));
        System.out.println(Arrays.asList(arr));
    }
    public static void main(String[] args) {
        Integer arr[] = {10, 20, 30, 40 ,50};
        reverseArray(arr);
        for(int ele : arr){
            System.out.print(ele + " ");
        }
    }
}
