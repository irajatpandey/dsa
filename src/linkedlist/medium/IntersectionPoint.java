package linkedlist.medium;
import linkedlist.template.LinkedListImplementation;
import linkedlist.template.Node;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class IntersectionPoint {
    public static int length(Node head){
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }
        return count;
    }

    // Optimized Approach
    // Time Complexity: O(m+n)
    // Auxiliary Space: O(1)
    // https://leetcode.com/problems/intersection-of-two-linked-lists/

    public static Node getIntersectionNode(Node headA, Node headB) {
        int m = length(headA);
        int n = length(headB);

        if(m > n){
            for(int i = 0; i < (m - n); i++){
                headA = headA.next;
            }
        }
        else{
            for(int i = 0; i < (n - m); i++){
                headB = headB.next;
            }
        }

        while(headA != null && headB != null){
            if(headA == headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;

    }

    // Naive Approach
    // Time complexity: O(n), where n is the length of the longer list.
    // This is because we need to traverse both of the linked lists in order to find the intersection point.
    // Auxiliary Space: O(n) , because we are using unordered set.

    public static Node getInsersectionNode_Hashmap(Node head1, Node head2){
        HashSet<Node> hs = new HashSet<Node>();

        while(head1 != null){
            hs.add(head1);
            head1 = head1.next;
        }

        while(head2 != null){
            if(hs.contains(head2)){
                return head2;
            }
            head2 = head2.next;
        }
        return null;
    }
    public static void main(String[] args) {

    }
}
