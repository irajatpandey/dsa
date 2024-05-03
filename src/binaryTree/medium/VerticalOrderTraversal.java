package binaryTree.medium;

import binaryTree.TreeNode;

public class VerticalOrderTraversal {
    public static void verticalOrderTraversal(TreeNode<Integer> root) {
        
    }
    public static void main(String[] args) {
	/* Example Binary Tree:
                        1
                       / \
                      2   3
                     / \ / \
                    4  5 6  7
                       / \
                      8   9
        */
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);
        root.right.left = new TreeNode<>(6);
        root.right.right = new TreeNode<>(7);
        root.left.right.left = new TreeNode<>(8);
        root.left.right.right = new TreeNode<>(9);

    }
}
