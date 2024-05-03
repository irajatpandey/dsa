package binaryTree.medium;

import binaryTree.TreeNode;

public class BinaryTreeMaxPathSumFinder {
    public static int findMaxPathSum(TreeNode<Integer> root) {
        return -1;
    }
    public static void main(String[] args) {
	/* Example Binary Tree:
                     10
                    / \
                   2   10
                  / \    \
                 20  1   -25
                     / \
                    3   4
        */
        TreeNode<Integer> root = new TreeNode<>(10);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(10);
        root.left.left = new TreeNode<>(20);
        root.left.right = new TreeNode<>(1);
        root.right.right = new TreeNode<>(-25);
        root.right.right.left = new TreeNode<>(3);
        root.right.right.right = new TreeNode<>(4);

        int output = findMaxPathSum(root);
        System.out.println(output);

    }
}
