package array.striver.easy;

import java.util.ArrayList;
import java.util.List;

public class UnionSortedArray {
    public static List< Integer > sortedArray(int []a, int []b) {
        // Write your code here
        List<Integer> li = new ArrayList<Integer>();
        int m = a.length;
        int n = b.length;
        int i = 0, j = 0;

        while(i < m && j < n){
            if(a[i] <= b[j]){
                if(li.size() == 0 || li.get(li.size() - 1) != a[i]){
                    li.add(a[i]);
                }
                ++i;
            }
            else{
                if(li.size() == 0 || li.get(li.size() - 1) != b[j]){
                    li.add(b[j]);
                }
                ++j;
            }
        }


        while(i < m){
            if((li.size() == 0 || li.get(li.size() - 1) != a[i])) {
                li.add(a[i]);
            }
            i++;
        }

        while(j < n){
            if((li.size() == 0 || li.get(li.size() - 1) != b[j])) {
                li.add(b[j]);
            }
            j++;
        }
        return li;
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 6};
        int b[] = {2, 3, 5};
        List<Integer> li = new ArrayList<Integer>();
        li = sortedArray(a, b);
        System.out.println(li);
    }
}
