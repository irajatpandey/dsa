package linkedlist.medium;

import linkedlist.template.LinkedListImplementation;
import linkedlist.template.Node;

// https://leetcode.com/problems/odd-even-linked-list/description/
public class OddEvenLinkedList {

    // T.C O(n)
    // S.C O(1)
    public static Node<Integer> oddEvenList(Node<Integer> head) {
        if (head == null) return null;
        Node odd = head, even = head.next;
        Node evenHead = head.next;

        while (odd.next != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;

        return head;

    }

    // https://www.codingninjas.com/studio/problems/segregate-even-and-odd-nodes-in-a-linked-list_1116100
    // T.C O(n)
    // S.C O(1)
    public static Node<Integer> segregateEvenOdd(Node<Integer> head) {
        // on values
        Node evenHead = null;
        Node evenTail = null;
        Node oddHead = null;
        Node oddTail = null;
        Node<Integer> currentNode = head;
//        System.out.println(head.data);

        while (currentNode != null) {
            int element = currentNode.data;
            if (element % 2 == 0) {
                if (evenHead == null) {
                    evenHead = currentNode;
                    evenTail = evenHead;
                } else {
                    evenTail.next = currentNode;
                    evenTail = evenTail.next;
                }
            } else { //odd
                if (oddHead == null) {
                    oddHead = currentNode;
                    oddTail = oddHead;
                } else {
                    oddTail.next = currentNode;
                    oddTail = oddTail.next;
                }
            }
            currentNode = currentNode.next;
        }
        if(oddHead == null || evenHead == null){
            return head;
        }
        evenTail.next = oddHead;
        oddTail.next = null;
        head = evenHead;
        return head;
    }

    public static void main(String[] args) {
        LinkedListImplementation<Integer> ls = new LinkedListImplementation<>();
        int arr[] = {6, 5, 3, 4, 7, 1, 2};
        for (int ele : arr) {
            ls.addAtEnd(ele);
        }

        Node head = ls.getHead();
        System.out.println(head.data);

//        head = oddEvenList(head);
//
//        while (head != null) {
//            System.out.print(head.data + " ");
//            head = head.next;
//        }
//        System.out.println();

        Node head2 = ls.getHead();

        head2 = segregateEvenOdd(head2);
        while (head2 != null) {
            System.out.print(head2.data + " ");
            head2 = head2.next;
        }




    }
}
