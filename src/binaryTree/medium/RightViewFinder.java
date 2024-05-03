package binaryTree.medium;

import binaryTree.TreeNode;


public class RightViewFinder {

    public static void rightViewFinder(TreeNode<Integer> root) {}
    public static void main(String[] args) {

/* Example Binary Tree:
                        1
                       / \
                      2   3
                     / \ / \
                    4  5 6  7
                       / \
                      8   9
                     /     \
                    10      11
                          /    \
                         12    13
                       /   \   / \
                      14   15 16 17
        */
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);
        root.right.left = new TreeNode<>(6);
        root.right.right = new TreeNode<>(7);
        root.left.right.left = new TreeNode<>(8);
        root.left.right.left.left = new TreeNode<>(10);
        root.left.right.right = new TreeNode<>(9);
        root.left.right.right.right = new TreeNode<>(11);
        root.left.right.right.right.left = new TreeNode<>(12);
        root.left.right.right.right.right = new TreeNode<>(13);
        root.left.right.right.right.left.left = new TreeNode<>(14);
        root.left.right.right.right.left.right = new TreeNode<>(15);
        root.left.right.right.right.right.left = new TreeNode<>(16);
        root.left.right.right.right.right.right = new TreeNode<>(17);
    }
}
