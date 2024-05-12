package binaryTree.traversal;

import binaryTree.TreeNode;

// Time Complexity O(n)
// Space Complexity O(1)
public class MorrisPreorderTraversal {

    /**
     * Finds the predecessor of a given node in the tree.
     * Predecessor is the rightmost node in the left subtree of the given node.
     *
     * @param root The root of the tree.
     * @param curr The current node for which predecessor needs to be found.
     * @return The predecessor node of the given node.
     */
    public static TreeNode<Integer> findPredecessor(TreeNode<Integer> root, TreeNode<Integer> curr) {
        if (root == null)
            return null;

        root = root.left;
        while (root.right != null && root.right != curr) {
            root = root.right;
        }
        return root;
    }

    /**
     * Performs Morris Preorder Traversal on the binary tree.
     * Prints the elements of the tree in preorder.
     *
     * @param root The root of the binary tree.
     */
    public static void morrisPreorderTraversal(TreeNode<Integer> root) {
        TreeNode<Integer> current = root;
        while (current != null) {
            if (current.left == null) {
                // If left child is null, print current node and move to right child
                System.out.print(current.data + " ");
                current = current.right;
            } else {
                // Find the predecessor of current node
                TreeNode<Integer> pred = findPredecessor(current, current);
                if (pred.right == null) {
                    // If predecessor's right child is null, set it to current, print current node, and move to left child
                    pred.right = current;
                    System.out.print(current.data + " "); // Print before traversing left
                    current = current.left;
                } else {
                    // If predecessor's right child is current, revert the change and move to right child
                    pred.right = null;
                    current = current.right;
                }
            }
        }
    }

    /**
     * Main method to test the Morris Preorder Traversal.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // Creating a binary tree
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);
        root.right.right = new TreeNode<>(6);

        // Performing Morris Preorder Traversal
        morrisPreorderTraversal(root);
    }
}
