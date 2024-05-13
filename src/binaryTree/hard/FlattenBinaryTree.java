package binaryTree.hard;

import binaryTree.TreeNode;
//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
// Time Complexity: O(n)
// Space Complexity : O(1)
public class FlattenBinaryTree {

    /**
     * Flattens a binary tree into a linked list in-place.
     *
     * @param root The root node of the binary tree
     */
    public static void flatten(TreeNode<Integer> root) {
        TreeNode<Integer> curr = root;
        while(curr != null) {
            if(curr.left != null) {
                TreeNode<Integer> p = curr.left;
                while(p.right != null) {
                    p = p.right;
                }

                p.right = curr.right; // Attach the right subtree of the current node to the rightmost node of the left subtree
                curr.right = curr.left; // Make the left subtree the new right subtree
                curr.left = null; // Clear the left subtree
            }
            curr = curr.right; // Move to the next node in the flattened structure
        }
    }

    /**
     * Prints the flattened binary tree.
     *
     * @param root The root node of the flattened binary tree
     */
    public static void printTree(TreeNode<Integer> root) {
        while (root != null) {
            System.out.print(root.data + " -> "); // Print node data
            root = root.right; // Move to the next node
        }
        System.out.println("null"); // Print "null" to indicate the end of the linked list
    }

    public static void main(String[] args) {
        // Create a binary tree
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(5);
        root.left.left = new TreeNode<>(3);
        root.left.right = new TreeNode<>(4);
        root.right.right = new TreeNode<>(6);

        // Flatten the binary tree
        flatten(root);

        // Print the flattened tree
        printTree(root);
    }
}
