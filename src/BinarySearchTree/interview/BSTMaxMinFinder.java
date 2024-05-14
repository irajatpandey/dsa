package BinarySearchTree.interview;

import BinarySearchTree.BinarySearchTree;

public class BSTMaxMinFinder {

    /**
     * Method to find the maximum value in the Binary Search Tree.
     *
     * @param root The root of the Binary Search Tree
     * @return The maximum value in the Binary Search Tree, or Integer.MIN_VALUE if the tree is empty
     */
    public static int findMax(BinarySearchTree<Integer> root) {
        // If the root is null, return the smallest possible integer value
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int rightMax = findMax(root.right);

        // Return the maximum value among root, left subtree max, and right subtree max
        return Math.max(root.data, rightMax);
    }

    /**
     * Method to find the minimum value in the Binary Search Tree.
     *
     * @param root The root of the Binary Search Tree
     * @return The minimum value in the Binary Search Tree, or Integer.MAX_VALUE if the tree is empty
     */
    public static int findMin(BinarySearchTree<Integer> root) {
        // If the root is null, return the largest possible integer value
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        // Recursively find the minimum values in the left and right subtrees
        int leftMin = findMin(root.left);

        // Return the minimum value among root, left subtree min, and right subtree min
        return Math.min(root.data, leftMin);
    }

    public static void main(String[] args) {
        // Create a sample Binary Search Tree
        BinarySearchTree<Integer> root = new BinarySearchTree<>(2);

        // Manually set child nodes
        root.left = new BinarySearchTree<>(1);
        root.right = new BinarySearchTree<>(5);

        // Further build the Binary Search Tree manually
        root.left.left = new BinarySearchTree<>(0);
        root.left.right = new BinarySearchTree<>(3);
        root.right.left = new BinarySearchTree<>(4);
        root.right.right = new BinarySearchTree<>(6);

        // Find and print the maximum value in the Binary Search Tree
        int max = findMax(root);
        System.out.println("Maximum value in the Binary Search Tree: " + max);

        // Find and print the minimum value in the Binary Search Tree
        int min = findMin(root);
        System.out.println("Minimum value in the Binary Search Tree: " + min);
    }
}
