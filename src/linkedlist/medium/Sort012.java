package linkedlist.medium;
import linkedlist.template.LinkedListImplementation;
import linkedlist.template.Node;

public class Sort012 {

    // T.C - O(n)
    //https://www.codingninjas.com/studio/problems/sort-linked-list-of-0s-1s-2s_1071937
    public static Node sort012(Node<Integer> head) {
        Node zeroTail = null, oneHead = null, twoHead = null, twoTail = null;
        Node finalHead = null, oneTail = null;

        while(head != null){
            if(head.data == 0){
                if(finalHead == null){
                    finalHead = head;
                    zeroTail = head;
                }
                else{
                    zeroTail.next = head;
                    zeroTail = head;

                }
            }
            else if(head.data == 1){
                if(oneHead == null){
                    oneHead = head;
                    oneTail = head;
                }
                else{
                    oneTail.next = head;
                    oneTail = head;
                }
            }
            else{
                if(twoHead == null){
                    twoHead = head;
                    twoTail = head;
                }
                else{
                    twoTail.next = head;
                    twoTail = head;
                }
            }

            head = head.next;
        }

        zeroTail.next = oneHead;
        oneTail.next = twoHead;
        twoTail.next = null;

        return finalHead;

    }

    public static void main(String[] args) {
        LinkedListImplementation<Integer> ls = new LinkedListImplementation<>();
        int arr[] = {1, 0, 2, 1, 0, 2, 1};
        for (int ele : arr) {
            ls.addAtEnd(ele);
        }
        Node<Integer> head = ls.getHead();

        head = sort012(head);

        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }

    }
}
