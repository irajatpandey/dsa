package BinarySearchTree.implementation;

import BinarySearchTree.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class PrintBST {
    public static void printBinaryTree(BinarySearchTree<Integer> root) {
        if (root == null) {
            return;
        }

        Queue<BinarySearchTree<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinarySearchTree<Integer> node = queue.poll();
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
