package array.introduction;

public class SecondLargest {
    public static int[] getSecondOrderElements(int n, int []a) {
        // Write your code here.
        int result[] = new int[2];
        int largest = a[0], smallest= a[0];
        int secondLargest = a[1], secondSmallest = a[1];

        for(int i = 0; i < n; i++){
            if(a[i] > largest){
                secondLargest = largest;
                largest = a[i];
            }
            if(a[i] < smallest){
                secondSmallest = smallest;
                smallest = a[i];
            }
        }

        result[0] = secondLargest;
        result[1] = secondSmallest;
        return result;
    }

    public static void main(String[] args) {
        int []a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int []result  = getSecondOrderElements(10, a);
        for(var ele : result){
            System.out.print(ele + " ");
        }
    }
}
