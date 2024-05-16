package BinarySearchTree.interview;

import BinarySearchTree.BinarySearchTree;
//Time complexity: O(n), Space complexity: O(h) where n is the number of nodes in the tree and h is the height of the tree.
//https://leetcode.com/problems/validate-binary-search-tree/
public class ValidateBST {

    /**
     * Checks if a binary tree is a valid binary search tree (BST).
     *
     * @param root the root node of the binary tree
     * @param min  the minimum value a node's value can have
     * @param max  the maximum value a node's value can have
     * @return true if the binary tree is a valid BST, false otherwise
     */
    public static boolean isValidBST(BinarySearchTree<Integer> root, long min, long max) {
        if (root == null) {
            return true; // An empty tree is a valid BST
        }

        // Check if the current node's value violates the BST property
        if (root.data >= max || root.data <= min) {
            return false; // Violation of BST property
        }

        // Recursively check the left and right subtrees
        return isValidBST(root.left, min, root.data) && isValidBST(root.right, root.data, max);
    }

    public static void main(String[] args) {
         /* Constructing the binary search tree:
                   5
                  / \
                 3   8
                / \ / \
               1  4 7  9
        */
        BinarySearchTree<Integer> root = new BinarySearchTree<>(5);
        root.left = new BinarySearchTree<>(3);
        root.right = new BinarySearchTree<>(8);
        root.left.left = new BinarySearchTree<>(1);
        root.left.right = new BinarySearchTree<>(4);
        root.right.left = new BinarySearchTree<>(7);
        root.right.right = new BinarySearchTree<>(9);

        // Check if the constructed binary tree is a valid BST
        if (isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE)) {
            System.out.println("The binary tree is a valid binary search tree.");
        } else {
            System.out.println("The binary tree is not a valid binary search tree.");
        }
    }
}
