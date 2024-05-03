package binaryTree.medium;

import binaryTree.TreeNode;

public class BinaryTreeDiameterCalculator {
    public static int calculateDiameterBruteForce(TreeNode<Integer> root) {
        return -1;
    }
    public static int calculateDiameterOptimized(TreeNode<Integer> root) {
        return -1;
    }
    public static void main(String[] args) {
	/* Example Binary Tree:
                     1
                    / \
                   2   3
                  / \
                 4   5
                / \
               6   7
        */
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);
        root.left.left.left = new TreeNode<>(6);
        root.left.left.right = new TreeNode<>(7);
    }
}
