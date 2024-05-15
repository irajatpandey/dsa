package BinarySearchTree.interview;

import BinarySearchTree.BinarySearchTree;

//the time complexity to find the ceil in a Binary Search Tree (BST) is O(h), where h is the height of the tree.
public class FloorInBST {

    /**
     * Function to find the floor value in a Binary Search Tree (BST).
     * The floor is the greatest key in the tree that is less than or equal to the given key.
     * @param root The root of the BST
     * @param key The key for which floor value needs to be found
     * @return The floor value if found, otherwise -1
     */
    public static int floor(BinarySearchTree<Integer> root, int key) {
        // Initialize floor value
        int floorValue = Integer.MIN_VALUE;

        // Traverse the BST
        while (root != null) {
            // If current node's key is same as the given key
            if (root.data == key)
                return root.data;

            // If given key is greater than current node's key
            // Floor must be in the right subtree
            if (root.data < key) {
                floorValue = root.data;
                root = root.right;
            }
            // If given key is smaller than current node's key
            // Move to the left subtree
            else
                root = root.left;
        }
        return floorValue == Integer.MIN_VALUE ? -1 : floorValue;
    }

    public static void main(String[] args) {
        // Create a BST
        BinarySearchTree<Integer> root = new BinarySearchTree<>(8);
        root.left = new BinarySearchTree<>(4);
        root.right = new BinarySearchTree<>(12);
        root.left.left = new BinarySearchTree<>(2);
        root.left.right = new BinarySearchTree<>(6);
        root.right.left = new BinarySearchTree<>(10);
        root.right.right = new BinarySearchTree<>(14);

        int key = 5;
        // Find the floor value
        int floorValue = floor(root, key);
        System.out.println("Floor of " + key + " in the BST is: " + floorValue);
    }
}
