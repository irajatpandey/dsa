package linkedlist.medium;
import linkedlist.template.LinkedListImplementation;
import linkedlist.template.Node;

// https://leetcode.com/problems/middle-of-the-linked-list/description/
public class MiddleOfALinkedList {
    public static int length(Node head){
        int count = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            count++;
        }
        return  count;
    }

    // Naive approach
    // Time complexity: O(n) + O(n/2) = O(n)
    public static Node<Integer> middleOfList_naive(Node head){
        if(head == null){
            return null;
        }
        int n = length(head)/2;
        Node temp = head;
        for(int i = 1; i <= n; i++){
            temp = temp.next;
        }

        return temp;

    }

    public static Node<Integer> middleOfList_optimized(Node<Integer> head){
        Node<Integer> fast, slow;
        fast = slow =  head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        LinkedListImplementation<Integer> ls = new LinkedListImplementation<>();
        int arr[] = {10, 20, 30, 40, 50};
        for(int ele : arr){
            ls.addAtEnd(ele);
        }
        Node head = ls.getHead();
        System.out.println(length(head));

        Node middle = middleOfList_naive(head);

        System.out.println(middle.data);
        ls.display();
        System.out.println("Optimal Approach");
        Node middleList = middleOfList_optimized(head);
        System.out.println(middleList.data);
    }
}
