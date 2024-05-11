package binaryTree.hard;

import binaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeFromPreorderInorder {

    /**
     * Helper method to recursively build the binary tree using preorder and inorder traversal arrays.
     * @param inOrderList   Inorder traversal array
     * @param preOrderList  Preorder traversal array
     * @param inorderStart  Start index of the inorder traversal array for the current subtree
     * @param inorderEnd    End index of the inorder traversal array for the current subtree
     * @param preorderStart Start index of the preorder traversal array for the current subtree
     * @param preorderEnd   End index of the preorder traversal array for the current subtree
     * @return              The root node of the constructed binary tree
     */
    private static TreeNode<Integer> buildTreeHelper(int[] inOrderList, int[] preOrderList, int inorderStart, int inorderEnd, int preorderStart, int preorderEnd) {
        if (inorderStart > inorderEnd) {  // base case: no more nodes to construct
            return null;
        }

        // Get the root data from the preorder list
        int rootData = preOrderList[preorderStart];
        TreeNode<Integer> root = new TreeNode<>(rootData);

        // Find the index of the root in the inorder list
        int rootIndex = -1;
        for (int i = inorderStart; i <= inorderEnd; i++) {
            if (inOrderList[i] == rootData) {
                rootIndex = i;
                break;
            }
        }

        // Determine indices for left and right subtrees in both inorder and preorder lists
        int inorderLeftStartIndex = inorderStart;
        int inorderLeftEndIndex = rootIndex - 1;
        int preorderLeftStartIndex = preorderStart + 1;
        int preorderLeftEndIndex = inorderLeftEndIndex - inorderLeftStartIndex + preorderLeftStartIndex;
        int inorderRightStartIndex = rootIndex + 1;
        int inorderRightEndIndex = inorderEnd;
        int preorderRightStartIndex = preorderLeftEndIndex + 1;
        int preorderRightEndIndex = preorderEnd;

        // Recursively build left and right subtrees
        root.left = buildTreeHelper(inOrderList, preOrderList, inorderLeftStartIndex, inorderLeftEndIndex, preorderLeftStartIndex, preorderLeftEndIndex);
        root.right = buildTreeHelper(inOrderList, preOrderList, inorderRightStartIndex, inorderRightEndIndex, preorderRightStartIndex, preorderRightEndIndex);

        return root;
    }

    /**
     * Constructs a binary tree from the given inorder and preorder traversal arrays.
     * @param inOrderList   Inorder traversal array
     * @param preOrderList  Preorder traversal array
     * @return              The root node of the constructed binary tree
     */
    public static TreeNode<Integer> buildTree(int[] inOrderList, int[] preOrderList) {
        return buildTreeHelper(inOrderList, preOrderList, 0, inOrderList.length - 1, 0, preOrderList.length - 1);
    }

    /**
     * Prints the binary tree level by level.
     * @param root  The root node of the binary tree
     */
    public static void printTree(TreeNode<Integer> root) {
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
        /*
        Preorder: [3, 9, 20, 15, 7]
        Inorder: [9, 3, 15, 20, 7]

               3
              / \
             9  20
                / \
               15  7
         */

        int[] inOrderList = {9, 3, 15, 20, 7};
        int[] preOrderList = {3, 9, 20, 15, 7};
        TreeNode<Integer> root = buildTree(inOrderList, preOrderList);
        printTree(root);
    }
}
