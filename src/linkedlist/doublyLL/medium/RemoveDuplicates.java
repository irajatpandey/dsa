package linkedlist.doublyLL.medium;
import linkedlist.doublyLL.template.DoublyLinkedListImplementation;
import linkedlist.doublyLL.template.Node;
public class RemoveDuplicates {

    public static Node<Integer> removeDuplicates(Node<Integer> head){
        if(head == null || head.next == null){
            return head;
        }
        Node<Integer> curr = head.next;
        Node<Integer> prevN = head;

        while(curr.next != null){

            if(curr.data == prevN.data){

                curr.next.prev = prevN;
                prevN.next = curr.next;

            }
            else{
                prevN = prevN.next;
            }
            curr = curr.next;
        }

        if(curr.data == prevN.data){

            prevN.next=null;
        }
        return head;
    }
    public static void main(String[] args) {
        DoublyLinkedListImplementation<Integer> l1 = new DoublyLinkedListImplementation<>();
        l1.addAtEnd(1);
        l1.addAtEnd(1);
        l1.addAtEnd(2);
        l1.addAtEnd(3);
        l1.addAtEnd(4);
        l1.addAtEnd(4);

        Node<Integer> head = l1.getHead();

        Node<Integer> output = removeDuplicates(head);

        while(output != null){
            System.out.print(output.data + " ");
            output = output.next;
        }

    }
}
