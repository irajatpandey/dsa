package linkedlist.hard;
import linkedlist.template.LinkedListImplementation;
import linkedlist.template.Node;
//Time Complexity: O(2N) The time complexity consists of actions of reversing segments of K and finding the Kth node which operates in linear time.
// Thus, O(N) + O(N) = O(2N), which simplifies to O(N).
//Space Complexity: O(1) The space complexity is O(1) as the algorithm operates in place without any additional space requirements.
// https://leetcode.com/problems/reverse-nodes-in-k-group/description/
public class ReverseKthNode {
    public static Node reverse(Node head){
        Node temp = head;
        Node prev = null;
        while(temp != null){

            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }

        return prev;

    }


    public static Node getKthNode(Node temp, int k) {
        k -= 1;

        while (temp != null && k > 0) {
            k--;
            temp = temp.next;
        }

        return temp;
    }
    public static Node kReverse(Node head, int k) {
        Node temp = head;
        Node prevLast = null;
        while(temp != null){
            Node kthNode = getKthNode(temp, k);
            if(kthNode == null){
                if(prevLast != null){
                    prevLast.next = temp;
                }
                break;
            }

            Node nextNode = kthNode.next;
            kthNode.next = null;
            reverse(temp);
            if(head == temp){
                head = kthNode;
            }
            else{
                prevLast.next = kthNode;
            }
            prevLast = temp;
            temp = nextNode;

        }
        return head;
    }
    public static void main(String[] args) {
        LinkedListImplementation<Integer> ls = new LinkedListImplementation<>();
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110};
        for(int ele : arr) ls.addAtEnd(ele);

        Node head = ls.getHead();

        Node outputHead = kReverse(head, 3);

        while(outputHead != null){
            System.out.print(outputHead.data + " ");
            outputHead = outputHead.next;
        }
    }
}
