package binaryTree.medium;

import binaryTree.TreeNode;

//https://leetcode.com/problems/symmetric-tree/description/
public class SymmetricTreeChecker {
    //the overall time complexity is O(n), where n is the number of nodes in the tree.
    //the overall space complexity is O(n) in the worst case and O(log n) in the best case.
    public static boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isMirrorTree(root.left, root.right);
    }

    private static boolean isMirrorTree(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;

        return root1.data == root2.data && isMirrorTree(root1.left, root2.right) && isMirrorTree(root1.right, root2.left);
    }

    public static void main(String[] args) {

        /*


             1
            / \
           2   2
          / \ / \
         3  4 4  3


        * */
        // Level 0
        TreeNode<Integer> root = new TreeNode<>(1);

        // Level 1
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(2);

        // Level 2
        root.left.left = new TreeNode<>(3);
        root.left.right = new TreeNode<>(4);
        root.right.left = new TreeNode<>(4);
        root.right.right = new TreeNode<>(3);

        if(isSymmetric(root)){
            System.out.println("Symmetric tree");
        }
        else{
            System.out.println("Not symmetric tree");
        }
    }
}
