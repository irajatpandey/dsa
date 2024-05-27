package heap.interview_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class ListNodeWrapper implements Comparable<ListNodeWrapper> {
    ListNode node;

    public ListNodeWrapper(ListNode node) {
        this.node = node;
    }

    @Override
    public int compareTo(ListNodeWrapper other) {
        return this.node.val - other.node.val;
    }
}
public class MergeKSortedList {
    /**
     * Merges k sorted linked lists and returns a single sorted linked list.
     *
     * @param lists An array of k sorted linked lists.
     * @return A merged sorted linked list.
     *
     * Time Complexity: O(N log k), where N is the total number of nodes and k is the number of lists.
     * Space Complexity: O(k), the space for the priority queue.
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        // Create a priority queue (min-heap) to keep track of the smallest elements from each list
        PriorityQueue<ListNodeWrapper> pq = new PriorityQueue<>();

        // Add the first node of each list to the priority queue
        for (ListNode list : lists) {
            if (list != null) {
                pq.add(new ListNodeWrapper(list));
            }
        }

        // Dummy node to facilitate the construction of the result list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Merge the nodes from the priority queue
        while (!pq.isEmpty()) {
            ListNodeWrapper wrapper = pq.poll();
            current.next = wrapper.node;
            current = current.next;

            // If there is a next node in the current list, add it to the priority queue
            if (wrapper.node.next != null) {
                pq.add(new ListNodeWrapper(wrapper.node.next));
            }
        }

        return dummy.next;
    }

    // Helper method to print a linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example usage
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);

        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(4);

        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(6);

        // Print each linked list before merging
        System.out.println("Before merging:");
        for (int i = 0; i < lists.length; i++) {
            System.out.print("List " + (i + 1) + ": ");
            printList(lists[i]);
        }

        ListNode mergedList = mergeKLists(lists);

        // Print the merged linked list
        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
    }
}
