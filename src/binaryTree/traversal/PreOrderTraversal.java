package binaryTree.traversal;

import binaryTree.TreeNode;

public class PreOrderTraversal {
    public static void preorder(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + "  ");
        preorder(root.left);
        preorder(root.right);

    }
    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);
        root.right.right = new TreeNode<>(6);

        preorder(root);


    }
}
