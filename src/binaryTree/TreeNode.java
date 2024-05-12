package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode<T> {
    public T data;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
    public static void printBinaryTree(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode<Integer> node = queue.poll();
            System.out.print(node.data + ": ");
            if (node.left != null) {
                queue.offer(node.left);
                System.out.print("L " + node.left.data + " ");
            }
            if (node.right != null) {
                queue.offer(node.right);
                System.out.print("R " + node.right.data);
            }
            System.out.println();
        }
    }
}
