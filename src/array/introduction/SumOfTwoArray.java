package array.introduction;

import java.util.Collections;

public class SumOfTwoArray {
    public static void main(String[] args) {
        int[] arr1 = {9, 9, 9};
        int[] arr2 = {1};
        int[] arr3 = new int[Math.max(arr1.length, arr2.length)];
        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int k = arr3.length - 1;
        int carry = 0;
        while (k >= 0) {
            int digit = carry;
            if (i >= 0) {
                digit += arr1[i];
            }
            if (j >= 0) {
                digit += arr2[j];
            }
            carry = digit / 10;
            digit = digit % 10;
            arr3[k] = digit;
            i--;
            j--;
            k--;
        }
        if (carry != 0) {
            System.out.print(carry);
        }
        for (int ele : arr3) {
            System.out.print(ele);
        }
    }

}