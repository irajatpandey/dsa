package BinarySearchTree.interview;

import BinarySearchTree.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoBST2 {
    // Flatten the BST into a doubly linked list and return the head of the list
    public static BinarySearchTree<Integer> flattenBSTAndGetHead(BinarySearchTree<Integer> root) {
        if (root == null) {
            return null;
        }

        BinarySearchTree<Integer> leftHead = flattenBSTAndGetHead(root.left);
        BinarySearchTree<Integer> rightHead = flattenBSTAndGetHead(root.right);

        root.left = null;
        root.right = rightHead;

        if (rightHead != null) {
            rightHead.left = root;
        }

        if (leftHead != null) {
            BinarySearchTree<Integer> leftTail = leftHead;
            while (leftTail.right != null) {
                leftTail = leftTail.right;
            }
            leftTail.right = root;
            root.left = leftTail;
            return leftHead;
        } else {
            return root;
        }
    }

    // Merge two sorted doubly linked lists into one sorted doubly linked list
    public static BinarySearchTree<Integer> mergeLinkedLists(BinarySearchTree<Integer> head1, BinarySearchTree<Integer> head2) {
        BinarySearchTree<Integer> dummy = new BinarySearchTree<>(-1);
        BinarySearchTree<Integer> current = dummy;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                current.right = head1;
                head1.left = current;
                head1 = head1.right;
            } else {
                current.right = head2;
                head2.left = current;
                head2 = head2.right;
            }
            current = current.right;
        }

        if (head1 != null) {
            current.right = head1;
            head1.left = current;
        } else if (head2 != null) {
            current.right = head2;
            head2.left = current;
        }

        BinarySearchTree<Integer> mergedHead = dummy.right;
        if (mergedHead != null) {
            mergedHead.left = null;
        }
        return mergedHead;
    }

    // Count the number of nodes in the doubly linked list
    public static int countNodes(BinarySearchTree<Integer> head) {
        int count = 0;
        BinarySearchTree<Integer> current = head;
        while (current != null) {
            count++;
            current = current.right;
        }
        return count;
    }

    // Convert a sorted doubly linked list to a balanced BST
    public static BinarySearchTree<Integer> sortedListToBST(BinarySearchTree<Integer>[] headRef, int n) {
        if (n <= 0) {
            return null;
        }

        BinarySearchTree<Integer> left = sortedListToBST(headRef, n / 2);
        BinarySearchTree<Integer> root = headRef[0];
        root.left = left;
        headRef[0] = headRef[0].right;
        root.right = sortedListToBST(headRef, n - n / 2 - 1);

        return root;
    }

    public static BinarySearchTree<Integer> createBSTFromList(BinarySearchTree<Integer> head) {
        int n = countNodes(head);
        BinarySearchTree<Integer>[] headRef = new BinarySearchTree[]{head};
        return sortedListToBST(headRef, n);
    }

    // Function to print doubly linked list
    public static void printDoublyLinkedList(BinarySearchTree<Integer> head) {
        BinarySearchTree<Integer> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.right;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create first BST
        // Tree structure:
        //      10
        //     /  \
        //    5   15
        //   / \    \
        //  3   7    18
        BinarySearchTree<Integer> root1 = new BinarySearchTree<>(10);
        root1.left = new BinarySearchTree<>(5);
        root1.right = new BinarySearchTree<>(15);
        root1.left.left = new BinarySearchTree<>(3);
        root1.left.right = new BinarySearchTree<>(7);
        root1.right.right = new BinarySearchTree<>(18);

        // Create second BST
        // Tree structure:
        //      20
        //     /  \
        //    16  25
        //   /   /  \
        //  12  23  30
        BinarySearchTree<Integer> root2 = new BinarySearchTree<>(20);
        root2.left = new BinarySearchTree<>(16);
        root2.right = new BinarySearchTree<>(25);
        root2.left.left = new BinarySearchTree<>(12);
        root2.right.left = new BinarySearchTree<>(23);
        root2.right.right = new BinarySearchTree<>(30);

        // Flatten the BSTs and get heads
        BinarySearchTree<Integer> head1 = flattenBSTAndGetHead(root1);
        BinarySearchTree<Integer> head2 = flattenBSTAndGetHead(root2);

        // Print the flattened DLLs
        System.out.println("Flattened DLL from first BST:");
        printDoublyLinkedList(head1);

        System.out.println("Flattened DLL from second BST:");
        printDoublyLinkedList(head2);

        // Merge the flattened linked lists
        BinarySearchTree<Integer> mergedHead = mergeLinkedLists(head1, head2);

        // Print the merged DLL
        System.out.println("Merged DLL:");
        printDoublyLinkedList(mergedHead);

        // Create a new BST from the merged list
        BinarySearchTree<Integer> newRoot = createBSTFromList(mergedHead);

        // Print the inorder traversal of the new BST
        List<Integer> mergedList = new ArrayList<>();
        inorder(newRoot, mergedList);
        System.out.println("Inorder traversal of the merged BST: " + mergedList);
    }

    // Function to do inorder traversal of the BST
    public static void inorder(BinarySearchTree<Integer> root, List<Integer> inorderOutput) {
        if (root == null) {
            return;
        }
        inorder(root.left, inorderOutput);
        inorderOutput.add(root.data);
        inorder(root.right, inorderOutput);
    }
}
