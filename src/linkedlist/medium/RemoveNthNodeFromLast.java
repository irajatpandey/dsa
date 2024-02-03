package linkedlist.medium;
import linkedlist.template.LinkedListImplementation;
import linkedlist.template.Node;

public class RemoveNthNodeFromLast {

    public static Node<Integer> removeNthFromEnd(Node<Integer> head, int n) {
        Node<Integer> first = head, second = head;
        Node<Integer> curr = head;

        for(int i = 0; i < n; i++){
            first = first.next;
        }
        if (first == null) {
            head = head.next;
            return head;
        }
        while (first.next != null) {

            first = first.next;
            second = second.next;
        }
        System.out.println(second.data);

        second.next = second.next.next;
        return head;

    }



    public static void main(String[] args) {
        LinkedListImplementation<Integer> ls = new LinkedListImplementation<>();
        int arr[] = {1, 2, 3, 4, 5};
        for (int ele : arr) {
            ls.addAtEnd(ele);
        }
        int n = 2;

        Node<Integer> head = ls.getHead();
        head = removeNthFromEnd(head, n);

        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }


    }
}
