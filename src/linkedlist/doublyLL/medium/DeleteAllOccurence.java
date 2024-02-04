package linkedlist.doublyLL.medium;
import linkedlist.doublyLL.template.DoublyLinkedListImplementation;
import linkedlist.doublyLL.template.Node;

public class DeleteAllOccurence {
    public static Node<Integer> deleteAllOccurrences(Node<Integer> head, int k) {

        Node newHead = head;

        while(head != null){
            if(head.data == k){
                if(head.prev == null && head.next != null){
                    head = head.next;
                    head.prev = null;
                    newHead = head;
                }
                else if(head.prev == null && head.next == null){
                    return null;
                }
                else{
                    Node prev = head.prev;
                    prev.next = head.next;
                    head.prev = prev.prev;
                    head = head.next;

                }

            }
            else
                head = head.next;
        }
        return newHead;
    }
    public static void main(String[] args) {
        DoublyLinkedListImplementation<Integer> l1 = new DoublyLinkedListImplementation<>();
        l1.addAtEnd(10);
        l1.addAtEnd(20);
        l1.addAtEnd(10);
        l1.addAtEnd(30);
        l1.addAtEnd(10);

        Node<Integer> head = l1.getHead();
        int k = 10;
        Node<Integer> output = deleteAllOccurrences(head, k);

        while(output != null){
            System.out.print(output.data + " ");
            output = output.next;
        }

    }
}
