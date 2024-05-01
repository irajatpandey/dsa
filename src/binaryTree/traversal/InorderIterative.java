package binaryTree.traversal;

import binaryTree.TreeNode;

import java.util.Stack;

public class InorderIterative {
    public static void inOrderIterative(TreeNode root) {
        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> current = root;
        while(current != null || !stack.isEmpty()) {
           while(current != null){
               stack.push(current);
               current = current.left;
           }

           current = stack.pop();
           System.out.print(current.data + " ");
           current = current.right;

        }
    }
    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);
        root.right.right = new TreeNode<>(6);
        inOrderIterative(root);
    }
}
