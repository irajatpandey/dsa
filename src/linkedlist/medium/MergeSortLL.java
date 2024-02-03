package linkedlist.medium;

import linkedlist.template.LinkedListImplementation;
import linkedlist.template.Node;

// https://leetcode.com/problems/sort-list/description/
public class MergeSortLL {
    public static Node<Integer> findMiddle(Node<Integer> head) {
        Node<Integer> fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node<Integer> merge(Node<Integer> head1, Node<Integer> head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        Node<Integer> finalHead = null;
        Node<Integer> finalTail = null;

        if(head1. data < head2.data){
            finalHead = head1;
            finalTail = head1;
            head1 = head1.next;
        }
        else{
            finalHead = head2;
            finalTail = head2;
            head2 = head2.next;
        }



        while (head1 != null && head2 != null) {
            if(head1.data > head2.data){
                finalTail.next = head2;
                finalTail = head2;
                head2  = head2.next;
            }
            else{
                finalTail.next = head1;
                finalTail = head1;
                head1 = head1.next;
            }
        }

        if(head1 != null){
            finalTail.next = head1;
        }
        if(head2 != null)
            finalTail.next = head2;

        return finalHead;
    }

    public static void printList(Node<Integer> head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static Node<Integer> mergeSort(Node<Integer> head) {
        if (head == null || head.next == null) return head;

        Node<Integer> mid = findMiddle(head);
        Node<Integer> head2 = mid.next;
        mid.next = null;

        head = mergeSort(head);
        head2 = mergeSort(head2);
        Node<Integer> finalList = merge(head, head2);
        printList(finalList);
//        printList(head2);
        return finalList;

    }

    public static Node<Integer> sortList(Node<Integer> head) {

        return mergeSort(head);
    }

    public static void main(String[] args) {
        LinkedListImplementation<Integer> ls = new LinkedListImplementation<>();
        int arr[] = {4,2,1,3};
        for (int ele : arr) {
            ls.addAtEnd(ele);
        }
        Node<Integer> head = ls.getHead();

        head = sortList(head);

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }

    }

}
