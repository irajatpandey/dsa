package binaryTree.traversal;

import binaryTree.TreeNode;

import java.util.Queue;
import java.util.LinkedList;

public class InorderTraversal {
    public static TreeNode<Integer> constructBinaryTree(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        TreeNode<Integer> root = new TreeNode<>(arr[0]);
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode<Integer> node = queue.poll();
            if(i < arr.length) {
                node.left = new TreeNode<>(arr[i++]);
                queue.add(node.left);
            }

            if(i < arr.length) {
                node.right = new TreeNode<>(arr[i++]);
                queue.add(node.right);
            }
        }
        return root;
    }
    public static void inorder(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + "  ");
        inorder(root.right);

    }
    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);
        root.right.right = new TreeNode<>(6);

        inorder(root);


    }
}
