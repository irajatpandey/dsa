package binaryTree.traversal;

import binaryTree.TreeNode;

public class PostOrder {
    public static void postorder(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }


        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + "  ");

    }
    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);
        root.right.right = new TreeNode<>(6);

        postorder(root);

    }
}
