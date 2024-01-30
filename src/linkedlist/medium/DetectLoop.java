package linkedlist.medium;
import linkedlist.template.LinkedListImplementation;
import linkedlist.template.Node;

import java.util.HashMap;
import java.util.HashSet;

public class DetectLoop {
    //Time complexity: O(N), Only one traversal of the loop is needed.
    //Auxiliary Space: O(1).
    public boolean hasCycle_floydAlgo(Node head) {
        if(head == null || head.next == null){
            return false;
        }
        Node slow, fast;
        slow = head;
        fast = head.next;

        while(slow != null && fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                return true;
            }
        }
        return false;
    }
    public boolean hasCycle(Node head) {

        HashSet<Node> set = new HashSet<Node>();

        Node temp = head;
        while (temp != null){
            if(set.contains(temp) == true){
                return true;
            }
            set.add(temp);
            temp = temp.next;
        }
        return false;
    }
    public static void main(String[] args) {

    }
}
