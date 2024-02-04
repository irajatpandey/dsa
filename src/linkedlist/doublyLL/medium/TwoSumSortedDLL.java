package linkedlist.doublyLL.medium;
import linkedlist.doublyLL.template.DoublyLinkedListImplementation;
import linkedlist.doublyLL.template.Node;

import java.util.ArrayList;


public class TwoSumSortedDLL {

    // https://www.geeksforgeeks.org/problems/find-pairs-with-given-sum-in-doubly-linked-list/1
    //Time Complexity: O(N)
    //Auxiliary Space: O(1)
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node<Integer> head) {
        // code here
        Node<Integer> left = head;

        Node<Integer> temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        Node<Integer> right = temp;
        ArrayList<ArrayList<Integer>> ls = new ArrayList<>();
        while(left.data < right.data){

            int sum = left.data + right.data;
            ArrayList<Integer> pair = new ArrayList<>();
            if(sum == target){
                pair.add(left.data);
                pair.add(right.data);

                ls.add(pair);
                left = left.next;
                right = right.prev;
            }
            else if(sum < target){
                left = left.next;
            }
            else{
                right = right.prev;
            }
        }

        return ls;
    }
    public static void main(String[] args) {
        DoublyLinkedListImplementation<Integer> l1 = new DoublyLinkedListImplementation<>();
        l1.addAtEnd(1);
        l1.addAtEnd(2);
        l1.addAtEnd(3);
        l1.addAtEnd(4);
        l1.addAtEnd(5);
        l1.addAtEnd(6);
        l1.addAtEnd(7);
        l1.addAtEnd(8);
        l1.addAtEnd(9);

        int target = 7;

        Node<Integer> head = l1.getHead();
        ArrayList<ArrayList<Integer>> output = findPairsWithGivenSum(target, head);

        for(ArrayList<Integer> pair : output){
            System.out.print(pair.get(0) + " " + pair.get(1));
            System.out.println();
        }
    }
}
