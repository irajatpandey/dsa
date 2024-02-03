package linkedlist.medium;
import linkedlist.template.LinkedListImplementation;
import linkedlist.template.Node;
public class DeleteMiddle {

    public static Node<Integer> deleteMiddle(Node<Integer> head) {
        Node prev = null;
        Node fast = head, slow = head;
        if(head == null || head.next == null)
            return null;

        while(fast.next != null && fast.next.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = slow.next;
        return head;

    }

    public static void main(String[] args) {
        LinkedListImplementation<Integer> ls = new LinkedListImplementation<>();
        int arr[] = {1, 2, 3, 4, 5};
        for (int ele : arr) {
            ls.addAtEnd(ele);
        }
        Node<Integer> head = ls.getHead();

        head = deleteMiddle(head);

        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }


    }
}
