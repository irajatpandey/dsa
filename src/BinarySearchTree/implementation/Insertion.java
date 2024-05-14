package BinarySearchTree.implementation;

import BinarySearchTree.BinarySearchTree;

import java.util.Queue;
import java.util.LinkedList;

public class Insertion {

    /**
     * Inserts a new node with the given key into the Binary Search Tree.
     *
     * @param root The root of the Binary Search Tree
     * @param key  The key to be inserted
     * @return The updated root of the Binary Search Tree
     */
    public static BinarySearchTree<Integer> insertion(BinarySearchTree<Integer> root, int key) {
        // If root is null, create a new node with the key
        if (root == null)
            return new BinarySearchTree<>(key);

        // If the key is less than the current root data, insert it into the left subtree
        if (root.data > key) {
            root.left = insertion(root.left, key);
        } else {
            // If the key is greater than or equal to the current root data, insert it into
            // the right subtree
            root.right = insertion(root.right, key);
        }
        return root;
    }

    public static BinarySearchTree<Integer> insertion_iterative(BinarySearchTree<Integer> root, int key) {
        BinarySearchTree<Integer> newNode = new BinarySearchTree<>(key);
        if (root == null) return newNode;

        BinarySearchTree<Integer> parent = null;
        BinarySearchTree<Integer> current = root;

        while (current != null) {
            parent = current;
            if (current.data == key) {
                // Key already exists, you might want to handle this case accordingly
                return root; // Or return something else, depending on your needs
            } else if (current.data > key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        // At this point, 'parent' is the node whose child will be the new node
        if (parent.data > key) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }

        return root;
    }
    /**
     * Performs a pre-order traversal of the Binary Search Tree and prints the data
     * of each node.
     *
     * @param root The root of the Binary Search Tree
     */
    public static void inOrder(BinarySearchTree<Integer> root) {
        if (root == null)
            return;

        // Traverse the left subtree
        inOrder(root.left);

        // Visit the current node
        System.out.print(root.data + " ");

        // Traverse the right subtree
        inOrder(root.right);
    }

    public static void main(String[] args) {
        // Create the Binary Search Tree
        BinarySearchTree<Integer> root = new BinarySearchTree<>(5);
        root.left = new BinarySearchTree<>(3);
        root.left.left = new BinarySearchTree<>(2);
        root.left.right = new BinarySearchTree<>(4);
        root.right = new BinarySearchTree<>(8);
        root.right.left = new BinarySearchTree<>(7);
        root.right.right = new BinarySearchTree<>(9);

        // Insert a new node with key 10
        BinarySearchTree<Integer> ans = insertion(root, 10);
        System.out.println("Updated root data: " + ans.data);



        BinarySearchTree<Integer> output2 = insertion_iterative(root, 1);
        if(output2 != null) {
            System.out.println("\nUpdated root data: " + output2.data);
        }
        else{
            System.out.println("Updated root data: null");
        }

        // Perform in-order traversal and print the data
        System.out.print("In-order traversal: ");
        inOrder(root);
    }
}
