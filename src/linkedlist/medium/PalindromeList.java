package linkedlist.medium;
import linkedlist.template.LinkedListImplementation;
import linkedlist.template.Node;

public class PalindromeList {
    public static void printList(Node head){
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
    public static Node reverse(Node head){
        if(head == null || head.next == null)
            return head;

        Node smalloutput = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return smalloutput;

    }
    public static boolean isPalindrome(Node head) {

        Node slow=head;
        Node fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node aftermid = reverse(slow.next);
        while(aftermid!=null){
            if(head.data != aftermid.data)
                return false;
            head = head.next;
            aftermid = aftermid.next;
        }
        return true;
    }

    public static void main(String[] args) {
        LinkedListImplementation<Integer> ls = new LinkedListImplementation<>();
        ls.addAtBeginning(1);
        ls.addAtBeginning(2);
        ls.addAtBeginning(2);
        ls.addAtBeginning(1);

        Node temp = ls.getHead();
        System.out.println(isPalindrome(temp));
    }
}
