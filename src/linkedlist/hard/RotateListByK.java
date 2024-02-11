package linkedlist.hard;
import linkedlist.template.LinkedListImplementation;
import linkedlist.template.Node;
public class RotateListByK {
    public static int getSize(Node head){
        int cnt = 0;
        while(head != null){
            cnt++;
            head = head.next;
        }
        return cnt;
    }
    //https://leetcode.com/problems/rotate-list/description/
    public static Node rotate(Node head, int k) {
        if(head == null) return null;
        int n = getSize(head);
        k = k % n;
        if(k == 0)
            return head;
        int traversalFromFront = n - k - 1;
        Node temp = head;
        while(temp != null && traversalFromFront > 0){
            temp = temp.next;
            traversalFromFront--;
        }
        Node nextNode = temp.next;
        Node finalHead = nextNode;
        temp.next = null;

        while(nextNode.next != null){
            nextNode = nextNode.next;
        }
        nextNode.next = head;

        return finalHead;
    }
    public static void main(String[] args) {
        LinkedListImplementation<Integer> ls = new LinkedListImplementation<>();
        int[] arr = {10, 20, 30, 40, 50};
        for(int ele : arr) ls.addAtEnd(ele);

        Node head = ls.getHead();
        Node outputHead = rotate(head, 3);

        while(outputHead != null){
            System.out.print(outputHead.data + " ");
            outputHead = outputHead.next;
        }
    }
}
