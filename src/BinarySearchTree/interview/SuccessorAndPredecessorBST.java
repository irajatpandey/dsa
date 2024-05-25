package BinarySearchTree.interview;

import BinarySearchTree.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to find the inorder predecessor and successor in a Binary Search Tree.
 */
public class SuccessorAndPredecessorBST {

    /**
     * Finds the inorder predecessor and successor of a given key in the BST.
     * Time Complexity: O(h) where h is the height of the BST.
     * Space Complexity: O(1) for the algorithm itself, excluding the space required for the result list.
     *
     * @param root the root of the BST
     * @param key the key to find the predecessor and successor for
     * @return a list containing the predecessor and successor
     */
    public static List<Integer> predecessorSuccessor(BinarySearchTree<Integer> root, int key) {
        List<Integer> ans = new ArrayList<>();
        int pred = -1; // To store predecessor
        int succ = -1; // To store successor

        BinarySearchTree<Integer> temp = root;

        // Traverse the tree to find the key
        while (temp != null && temp.data != key) {
            if (key < temp.data) {
                succ = temp.data; // Potential successor
                temp = temp.left;
            } else {
                pred = temp.data; // Potential predecessor
                temp = temp.right;
            }
        }

        // If key is not found in the tree
        if (temp == null) {
            ans.add(pred);
            ans.add(succ);
            return ans;
        }

        // Find the inorder predecessor
        BinarySearchTree<Integer> leftTree = temp.left;
        while (leftTree != null) {
            pred = leftTree.data;
            leftTree = leftTree.right;
        }

        // Find the inorder successor
        BinarySearchTree<Integer> rightTree = temp.right;
        while (rightTree != null) {
            succ = rightTree.data;
            rightTree = rightTree.left;
        }

        ans.add(pred);
        ans.add(succ);
        return ans;
    }

    /**
     * Inserts a key into the BST.
     *
     * @param root the root of the BST
     * @param key the key to insert
     * @return the root of the modified BST
     */
    public static BinarySearchTree<Integer> insertion(BinarySearchTree<Integer> root, int key) {
        // If root is null, create a new node with the key
        if (root == null)
            return new BinarySearchTree<>(key);

        // If the key is less than the current root data, insert it into the left subtree
        if (root.data > key) {
            root.left = insertion(root.left, key);
        } else {
            // If the key is greater than or equal to the current root data, insert it into the right subtree
            root.right = insertion(root.right, key);
        }
        return root;
    }

    /**
     * Main method to test the insertion and predecessorSuccessor methods.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        int[] arr = {10, 20, 8, 12, 16, 25};
        BinarySearchTree<Integer> root = new BinarySearchTree<>(15);

        // Insert elements into the BST
        for (int ele : arr) {
            insertion(root, ele);
        }

        int key = 10;

        // Find and print the predecessor and successor
        List<Integer> output = predecessorSuccessor(root, key);
        System.out.println("Predecessor: " + output.get(0));
        System.out.println("Successor: " + output.get(1));
    }
}
