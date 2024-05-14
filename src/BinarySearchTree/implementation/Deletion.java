package BinarySearchTree.implementation;

import BinarySearchTree.BinarySearchTree;
import BinarySearchTree.implementation.PrintBST;

public class Deletion {

    /**
     * Deletes a node with the given value from the Binary Search Tree.
     *
     * @param root The root of the Binary Search Tree
     * @param value The value to be deleted
     * @return The modified Binary Search Tree after deletion
     */
    public static BinarySearchTree<Integer> deleteInBST(BinarySearchTree<Integer> root, int value) {
        // If the root is null, return null
        if (root == null)
            return null;

        // If value is less than root's data, go to the left subtree
        if (value < root.data)
            root.left = deleteInBST(root.left, value);
            // If value is greater than root's data, go to the right subtree
        else if (value > root.data)
            root.right = deleteInBST(root.right, value);
        else {
            // If the node to be deleted has no children
            if (root.left == null && root.right == null) {
                return null;
            }
            // If the node to be deleted has only right child
            else if (root.left == null) {
                return root.right;
            }
            // If the node to be deleted has only left child
            else if (root.right == null) {
                return root.left;
            }
            // If the node to be deleted has both left and right children
            else {
                // Find the minimum value in the right subtree
                BinarySearchTree<Integer> temp = root.right;
                while (temp.left != null) {
                    temp = temp.left;
                }
                // Replace the data of the root node with minimum value
                root.data = temp.data;
                // Delete the node with minimum value from the right subtree
                root.right = deleteInBST(root.right, temp.data);
                return root;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> root = null;
        int[] keys = {50, 30, 70, 20, 40, 60, 80};

        /*
               50
             /    \
           30      70
          /  \    /  \
        20   40  60   80
        */

        // Insert keys into the Binary Search Tree
        for (int key : keys) {
            root = Insertion.insertion(root, key);
        }

        // Print the Binary Search Tree
        System.out.println("Before deletion: ");
        PrintBST.printBinaryTree(root);

        // Delete a node with value 40
        BinarySearchTree<Integer> result = deleteInBST(root, 40);

        // Print the Binary Search Tree after deletion
        System.out.println("After deletion: ");
        PrintBST.printBinaryTree(result);
    }
}
