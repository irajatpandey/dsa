package linkedlist.medium;
import linkedlist.template.LinkedListImplementation;
import linkedlist.template.Node;

public class StartingPointOfLoop {
    public static Node<Integer> startingPointOfLoop(Node<Integer> head){
        if(head == null || head.next == null )
            return null;

        Node<Integer> fast = head, slow = head;
        boolean isCycle = false;

        while(slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                isCycle = true;
                break;
            }
        }
        if(isCycle == false){
            return null;
        }

        slow = head;

        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    public static void main(String[] args) {

    }
}
