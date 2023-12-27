package array.introduction;

public class InverseArray {
    public static void main(String[] args) {
        int arr[] = {3, 4, 2, 0, 1} ;

        int smallOutput[] = new int[arr.length];

        for(int i = 0; i < arr.length; i++){
            smallOutput[arr[i]] = i;
        }
        for(int ele : smallOutput){
            System.out.print(ele + " ");
        }
    }
}
