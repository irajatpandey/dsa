package array.introduction;

public class ArrayExample {

    public static void main(String[] args) {
        int[] arr = new int[5];
        for(int i = 0; i < 5; i++){
            arr[i] = 100 + i;
        }

        for(int item : arr){
            System.out.println(item);
        }
    }

}
