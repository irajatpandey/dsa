package binaryTree.medium;

import binaryTree.TreeNode;
import static binaryTree.medium.BinaryTreeHeightCalculator.calculateHeightOfBinaryTree;

//https://leetcode.com/problems/diameter-of-binary-tree/
class Pair{
    int height;
    int diameter;
}
public class BinaryTreeDiameterCalculator {

    // Time Complexity: T(n) = K*n + 2T(n - 1)
    // O(h*n) where h is height of Binary Tree
    public static int calculateDiameterBruteForce(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int option1 = calculateHeightOfBinaryTree(root.left) + calculateHeightOfBinaryTree(root.right);
        int option2 = calculateDiameterBruteForce(root.left);
        int option3 = calculateDiameterBruteForce(root.right);

        return Math.max(option1, Math.max(option2, option3));
    }
    public static Pair calculateDiameterOptimized(TreeNode<Integer> root) {
        if (root == null) {
            Pair p = new Pair();
            p.height = 0;
            p.diameter = 0;
            return p;
        }
        Pair leftAns = calculateDiameterOptimized(root.left);
        Pair rightAns = calculateDiameterOptimized(root.right);

        int leftHeight = leftAns.height;
        int leftDiameter = leftAns.diameter;
        int rightHeight = rightAns.height;
        int rightDiameter = rightAns.diameter;

        int height = Math.max(leftHeight, rightHeight) + 1;
        int diameter = Math.max(leftHeight + rightHeight, Math.max(leftDiameter, rightDiameter));
        Pair p = new Pair();
        p.height = height;
        p.diameter = diameter;
        return p;

    }
    public static void main(String[] args) {
	/* Example Binary Tree:
                     1
                    / \
                   2   3
                  / \
                 4   5
                / \
               6   7
        */
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);
        root.left.left.left = new TreeNode<>(6);
        root.left.left.right = new TreeNode<>(7);

        int diameter = calculateDiameterBruteForce(root);
        System.out.println(diameter);

        Pair p = calculateDiameterOptimized(root);
        System.out.println("Height of Binary Tree " + p.height);
        System.out.println("Diameter of Binary Tree " + p.diameter);
    }
}
