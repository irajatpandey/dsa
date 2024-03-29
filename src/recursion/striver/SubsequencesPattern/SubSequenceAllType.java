package recursion.striver.SubsequencesPattern;

import java.util.ArrayList;
import java.util.List;

public class SubSequenceAllType {

    // to check any subset/subsequence is present or not
    // https://www.naukri.com/code360/problems/subset-sum_630213
    public static boolean isSubsetPresentHelper(int []arr, int n, int index, int k, int sumSoFar) {

        if(sumSoFar > k) return false;
        if(index == n){
            if(sumSoFar == k){
                return true;
            }
            else{
                return false;
            }
        }

        sumSoFar += arr[index];
        if(isSubsetPresentHelper(arr, n, index + 1, k, sumSoFar)){
            return true;
        }
        sumSoFar -= arr[index];
        if(isSubsetPresentHelper(arr, n, index + 1, k, sumSoFar)){
            return true;
        }

        return false;

    }

    public static void printSubsequencesWithSumK(int[] arr, int index, int n, int sumSoFar, int k, List<Integer> subsequence){
        if(index == n){
            if(k == sumSoFar){
                for(int ele : subsequence){
                    System.out.print(ele + " ");
                }
                System.out.println();
            }
            return;
        }
        sumSoFar += arr[index];
        subsequence.add(arr[index]);
        printSubsequencesWithSumK(arr, index + 1, n, sumSoFar, k, subsequence);

        sumSoFar = sumSoFar - arr[index];
        subsequence.remove(subsequence.size() - 1);
        printSubsequencesWithSumK(arr, index + 1, n, sumSoFar, k, subsequence);

    }

    public static int countSubsequencesWithSumK(int[] arr, int index, int n, int sumSoFar, int k){
        if(index == n){
            if(sumSoFar == k){
                return 1;
            }else{
                return 0;
            }
        }
        sumSoFar += arr[index];
        int left = countSubsequencesWithSumK(arr, index + 1, n, sumSoFar, k);
        sumSoFar = sumSoFar - arr[index];
        int right = countSubsequencesWithSumK(arr, index + 1, n, sumSoFar,k);

        return left + right;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        int n = arr.length;
        int k = 2;

        List<Integer> subsequence = new ArrayList<>();
        printSubsequencesWithSumK(arr, 0, n, 0, k, subsequence);

        int output = countSubsequencesWithSumK(arr, 0, n, 0, k);
        System.out.println(output);
        
        boolean output2 = isSubsetPresentHelper(arr, n, 0, k, 0 );
        System.out.println(output2);


    }
}
