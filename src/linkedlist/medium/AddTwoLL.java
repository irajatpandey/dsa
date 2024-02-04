package linkedlist.medium;
import linkedlist.template.LinkedListImplementation;
import linkedlist.template.Node;

public class AddTwoLL {
    public static Node<Integer> addTwoLL(Node<Integer> head1, Node<Integer> head2){
        int sum = 0, carry = 0;

        Node output = new Node(-1);
        Node result = output;
        while(head1 != null && head2 != null){
            sum = carry + head1.data + head2.data;
            output.next = new Node(sum % 10);
            output = output.next;
            carry = sum / 10;
            head1 = head1.next;
            head2 = head2.next;
        }
        while(head1 != null){
            sum = carry + head1.data;
            output.next = new Node(sum % 10);
            output = output.next;
            carry = sum / 10;
            head1 = head1.next;
        }
        while(head2 != null){
            sum = carry + head2.data;
            output.next = new Node(sum % 10);
            output = output.next;
            carry = sum / 10;
            head2 = head2.next;
        }
        if(carry > 0){
            output.next = new Node(carry);
        }

        result = result.next;
        return result;
    }
    public static void printList(Node<Integer> head){
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        LinkedListImplementation<Integer> l1 = new LinkedListImplementation<>();
        l1.addAtEnd(2);
        l1.addAtEnd(4);
        l1.addAtEnd(3);

        Node<Integer> h1 = l1.getHead();
        printList(h1);
        LinkedListImplementation<Integer> l2 = new LinkedListImplementation<>();
        l2.addAtEnd(5);
        l2.addAtEnd(6);
        l2.addAtEnd(4);
        Node<Integer> h2 = l2.getHead();

        printList(h2);

        Node<Integer> output = addTwoLL(h1, h2);

        printList(output);



    }
}
