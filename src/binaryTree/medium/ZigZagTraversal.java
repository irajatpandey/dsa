package binaryTree.medium;

import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
public class ZigZagTraversal {

    //the time & space complexity is O(n)
    public static List<List<Integer>> zigzagLevelOrder(TreeNode<Integer> root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            LinkedList<Integer> levelNodes = new LinkedList<>(); // Use LinkedList for efficient insertion at both ends

            for (int i = 0; i < levelSize; i++) {
                TreeNode<Integer> cur = queue.poll();
                if (leftToRight) {
                    levelNodes.addLast(cur.data); // Append to the end for left to right
                } else {
                    levelNodes.addFirst(cur.data); // Append to the beginning for right to left
                }
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }

            result.add(levelNodes);
            leftToRight = !leftToRight; // Toggle direction for the next level
        }

        return result;
    }
    public static void main(String[] args) {
        /*
                3
               / \
              9   20
                 /  \
                15   7
        */

        TreeNode<Integer> root = new TreeNode<>(3);
        root.left = new TreeNode<>(9);
        root.right = new TreeNode<>(20);
        root.right.left = new TreeNode<>(15);
        root.right.right = new TreeNode<>(7);

        List<List<Integer>> result = zigzagLevelOrder(root);
        System.out.println(result);
    }
}
