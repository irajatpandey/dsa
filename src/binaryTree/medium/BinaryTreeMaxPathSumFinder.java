package binaryTree.medium;

import binaryTree.TreeNode;

public class BinaryTreeMaxPathSumFinder {
    public static int findMaxPathSum(TreeNode<Integer> root, int result) {
        if (root == null) {
            return 0;
        }

        int left = findMaxPathSum(root.left, result);
        int right = findMaxPathSum(root.right, result);

        int temp = Math.max(Math.max(left, right) + root.data, root.data);
        int ans = Math.max(temp, left + right + root.data);

        result = Math.max(result, ans);
        return temp ;

    }
    public static void main(String[] args) {
	/* Example Binary Tree:
                     10
                    / \
                   2   10
                  / \    \
                 20  1   -25
                     / \
                    3   4
        */
        TreeNode<Integer> root = new TreeNode<>(10);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(10);
        root.left.left = new TreeNode<>(20);
        root.left.right = new TreeNode<>(1);
        root.right.right = new TreeNode<>(-25);
        root.right.right.left = new TreeNode<>(3);
        root.right.right.right = new TreeNode<>(4);

        int output = findMaxPathSum(root, Integer.MIN_VALUE);
        System.out.println(output);

    }
}
