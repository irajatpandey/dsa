package linkedlist.medium;
import linkedlist.template.LinkedListImplementation;
import linkedlist.template.Node;

public class AddOne {

    //https://www.geeksforgeeks.org/problems/add-1-to-a-number-represented-as-linked-list/1
    // T.C O(n)
    // S.C O(1)
    public static Node reverse(Node head){
        if(head == null || head.next == null) return head;
        Node smallOutput = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return smallOutput;
    }
    public static Node addNode(Node<Integer> head) {
        int carry = 1, sum = 0;
        Node temp = null;

        head = reverse(head);
        Node current = head;

        while(head != null){
            sum = carry + (head != null ? head.data : 0);
            carry = sum / 10;
            head.data = sum % 10;
            temp = head;
            head = head.next;
        }
        if(carry > 0){
            temp.next = new Node<Integer>(carry);
        }
        return reverse(current);
    }
    public static void main(String[] args) {
        LinkedListImplementation<Integer> ls = new LinkedListImplementation<>();
        int arr[] = {9};
        for (int ele : arr) {
            ls.addAtEnd(ele);
        }
        Node<Integer> head = ls.getHead();

        head = addNode(head);

        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }

    }
}
