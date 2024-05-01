package binaryTree.traversal;

import binaryTree.TreeNode;

import java.util.Stack;
//The time and space complexity of the iterative preorder traversal algorithm is 𝑂(𝑁), O(N),
public class PreOrderIterative {

    public static void preOrderIterative(TreeNode<Integer> root){
        Stack<TreeNode<Integer>> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode<Integer> current = stack.pop();
            System.out.print(current.data + " ");
            if(current.right != null) {
                stack.push(current.right);
            }
            if(current.left != null) {
                stack.push(current.left);
            }
        }
    }
    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);
        root.right.right = new TreeNode<>(6);
        preOrderIterative(root);
    }
}
