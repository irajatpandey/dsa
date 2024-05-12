package binaryTree.hard;

import binaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

import static binaryTree.TreeNode.printBinaryTree;

/**
 * Time Complexity:
 * Serialization: The time complexity of serialization is O(n), where n is the number of nodes in the binary tree. This is because each node is visited exactly once during serialization.
 * Deserialization: The time complexity of deserialization is also O(n), where n is the number of nodes in the binary tree. Each node is visited exactly once during deserialization.

 * Space Complexity:
 * Both serialization and deserialization have a space complexity of O(n), where n is the number of nodes in the binary tree.
 * This is due to the space required for the queue data structure used in deserialization, as well as the recursion stack during both serialization and deserialization.
 *
 *
 * **/

//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
public class TreeSerializer {
    /**
     * Encodes a binary tree to a single string.
     *
     * @param root The root node of the binary tree to be serialized
     * @return The serialized string representing the binary tree
     */
    public static String serialize(TreeNode<Integer> root) {
        if (root == null) {
            return "null";
        }
        // Serialize left and right subtrees recursively
        String leftAns = serialize(root.left);
        String rightAns = serialize(root.right);
        // Concatenate the root data with serialized left and right subtrees
        return root.data + "," + leftAns + "," + rightAns;
    }

    /**
     * Decodes the serialized data string to reconstruct the binary tree.
     *
     * @param data The serialized string representing the binary tree
     * @return The root node of the reconstructed binary tree
     */
    public static TreeNode<Integer> deserialize(String data) {
        // Split the serialized string into tokens
        Queue<String> queue = new LinkedList<>();
        String[] arr = data.split(",");
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }
        // Reconstruct the binary tree using deserialization helper function
        return deserialize(queue);
    }

    /**
     * Deserialization helper function to reconstruct the binary tree.
     *
     * @param queue The queue containing tokens from the serialized data
     * @return The root node of the reconstructed binary tree
     */
    public static TreeNode<Integer> deserialize(Queue<String> queue) {
        if (queue.isEmpty()) {
            return null;
        }
        // Retrieve the next token from the queue
        String data = queue.poll();
        // If the token represents null, return null
        if (data.equals("null")) {
            return null;
        }
        // Create a new node with the token value as data
        TreeNode<Integer> root = new TreeNode<>(Integer.parseInt(data));
        // Reconstruct left and right subtrees recursively
        root.left = deserialize(queue);
        root.right = deserialize(queue);
        return root;
    }

    public static void main(String[] args) {
        // Create a sample binary tree
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);

        // Serialize the binary tree
        String serializedTree = serialize(root);
        System.out.println("Serialized tree: " + serializedTree);

        // Deserialize the serialized data and reconstruct the binary tree
        TreeNode<Integer> deserializedRoot = deserialize(serializedTree);

        // Print the reconstructed binary tree to verify correctness
        System.out.println("Reconstructed binary tree:");
        printBinaryTree(deserializedRoot);
    }
}
