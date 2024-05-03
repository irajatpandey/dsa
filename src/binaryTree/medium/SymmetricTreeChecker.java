package binaryTree.medium;

import binaryTree.TreeNode;

public class SymmetricTreeChecker {
    public static boolean isSymmetric(TreeNode root) {
        return false;
    }
    public static void main(String[] args) {
          /* Example Complex Symmetric Binary Tree:
                            1
                           / \
                          2   2
                         / \ / \
                        3  4 4  3
                       /        \
                      5          5
                     / \        / \
                    6   7      7   6
                   / \ / \    / \ / \
                  8  9 9  8  8 9 9  8
                 /             \
                10             10
        */
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(2);
        root.left.left = new TreeNode<>(3);
        root.left.right = new TreeNode<>(4);
        root.right.left = new TreeNode<>(4);
        root.right.right = new TreeNode<>(3);
        root.left.left.left = new TreeNode<>(5);
        root.left.left.right = new TreeNode<>(5);
        root.right.right.left = new TreeNode<>(5);
        root.right.right.right = new TreeNode<>(5);
        root.left.left.left.left = new TreeNode<>(6);
        root.left.left.left.right = new TreeNode<>(7);
        root.left.left.right.left = new TreeNode<>(7);
        root.left.left.right.right = new TreeNode<>(6);
        root.right.right.left.left = new TreeNode<>(7);
        root.right.right.left.right = new TreeNode<>(6);
        root.right.right.right.left = new TreeNode<>(6);
        root.right.right.right.right = new TreeNode<>(7);
        root.left.left.left.left.left = new TreeNode<>(8);
        root.left.left.left.left.right = new TreeNode<>(9);
        root.left.left.left.right.left = new TreeNode<>(9);
        root.left.left.left.right.right = new TreeNode<>(8);
        root.right.right.right.left.left = new TreeNode<>(9);
        root.right.right.right.right.right = new TreeNode<>(8);
        root.left.left.left.left.left.left = new TreeNode<>(10);
        root.right.right.right.right.right.right = new TreeNode<>(10);
    }
}
