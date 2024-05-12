package binaryTree.hard;

import binaryTree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;
public class BinaryTreeFromInorderPostorder {

    /**
     * Constructs a binary tree from inorder and postorder traversals.
     *
     * @param inorder   The inorder traversal array
     * @param postorder The postorder traversal array
     * @return The root node of the constructed binary tree
     */
    private static TreeNode<Integer> buildTreeHelper(int[] inorder, int[] postorder, int inorderStart, int inorderEnd, int postorderStart, int postorderEnd) {
        // Base case: If any traversal array is empty or the range is invalid, return null
        if (inorderStart > inorderEnd || postorderStart > postorderEnd) {
            return null;
        }

        // The last element in postorder array is the root
        int rootData = postorder[postorderEnd];
        TreeNode<Integer> root = new TreeNode<>(rootData);

        // Find the index of root in inorder array to determine left and right subtrees
        int rootIndex = -1;
        for (int i = inorderStart; i <= inorderEnd; i++) {
            if (inorder[i] == rootData) {
                rootIndex = i;
                break;
            }
        }

        // Indices for left subtree in inorder and postorder arrays
        int inorderLeftStartIndex = inorderStart;
        int inorderLeftEndIndex = rootIndex - 1;
        int postorderLeftEndIndex = postorderStart + (rootIndex - inorderStart) - 1;

        // Indices for right subtree in inorder and postorder arrays
        int inorderRightStartIndex = rootIndex + 1;
        int inorderRightEndIndex = inorderEnd;
        int postorderRightStartIndex = postorderLeftEndIndex + 1;
        int postorderRightEndIndex = postorderEnd - 1;

        // Recursively build left and right subtrees
        root.left = buildTreeHelper(inorder, postorder, inorderLeftStartIndex, inorderLeftEndIndex, postorderStart, postorderLeftEndIndex);
        root.right = buildTreeHelper(inorder, postorder, inorderRightStartIndex, inorderRightEndIndex, postorderRightStartIndex, postorderRightEndIndex);
        return root;
    }

    /**
     * Constructs a binary tree from inorder and postorder traversals.
     *
     * @param inorder   The inorder traversal array
     * @param postorder The postorder traversal array
     * @return The root node of the constructed binary tree
     */
    public static TreeNode<Integer> buildTree(int[] inorder, int[] postorder) {
        return buildTreeHelper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    /**
     * Prints the binary tree level by level.
     *
     * @param root The root node of the binary tree
     */
    public static void printBinaryTree(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode<Integer> node = queue.poll();
            System.out.print(node.data + ": ");
            if (node.left != null) {
                queue.offer(node.left);
                System.out.print("L " + node.left.data + " ");
            }
            if (node.right != null) {
                queue.offer(node.right);
                System.out.print("R " + node.right.data);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Example inorder and postorder traversals
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        // Build the binary tree
        TreeNode<Integer> root = buildTree(inorder, postorder);

        // Print the binary tree
        printBinaryTree(root);
    }
}