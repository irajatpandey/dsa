package mylib;

public class MyLibrary<T> {
    public void swap(T first, T second){
        T temp = first;
        first = second;
        second = temp;
    }
    public void reverse(T array[]){
        int left = 0;
        int right = array.length - 1;

        while(left < right){
            swap(array[left], array[right]);
            left++;
            right--;
        }
    }
}
