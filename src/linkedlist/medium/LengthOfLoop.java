package linkedlist.medium;

import linkedlist.template.Node;

public class LengthOfLoop {
    public static int lengthOfLoop(Node<Integer> node){
        int count = 1;
        while(node != node.next){
            node = node.next;
            count++;
        }
        return count;
    }
    public int hasCycle_floydAlgo(Node head) {
        if(head == null || head.next == null){
            return 0;
        }
        Node slow, fast;
        slow = head;
        fast = head.next;

        while(slow != null && fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){

                int length = lengthOfLoop(slow);
                return length;
            }
        }
        return 0;
    }
}
