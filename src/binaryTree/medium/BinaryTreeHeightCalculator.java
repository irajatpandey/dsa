package binaryTree.medium;


import binaryTree.TreeNode;
import binaryTree.traversal.InorderIterative;

public class BinaryTreeHeightCalculator {
    public static int calculateHeightOfBinaryTree(TreeNode<Integer> root) {
        if(root == null) return 0;
        int leftHeight = calculateHeightOfBinaryTree(root.left);
        int rightHeight = calculateHeightOfBinaryTree(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        TreeNode<Integer> node1 = new TreeNode<Integer>(1);
        TreeNode<Integer> node2 = new TreeNode<Integer>(2);
        TreeNode<Integer> node3 = new TreeNode<Integer>(3);
        TreeNode<Integer> node4 = new TreeNode<Integer>(4);
        TreeNode<Integer> node5 = new TreeNode<Integer>(5);
        TreeNode<Integer> node6 = new TreeNode<Integer>(6);
        TreeNode<Integer> node7 = new TreeNode<Integer>(7);
        TreeNode<Integer> node8 = new TreeNode<Integer>(8);
        TreeNode<Integer> node9 = new TreeNode<Integer>(9);
        TreeNode<Integer> node10 = new TreeNode<Integer>(10);


        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        node4.left = node7;
        node6.left = node8;
        node6.right = node9;
        node9.left = node10;

        /*
                1
               / \
              2   3
             / \   \
            4   5   6
           /       / \
          7       8   9
                     /
                    10   */

        int height = calculateHeightOfBinaryTree(node1);
        System.out.println("Height of Binary Tree is " + height);

        
    }
}
